//5.3   �����
//5.3.2   �����Ĵ洢�ṹ
//2.  ������˫����ʾ

//ʹ��GenList�࣬���﷨ͼ��������
public class GenList_String
{    
    private static int i=0;
    public static GenList<String> createGenList(String gliststr)  //��gliststr�ַ������������ع����
    {
        i=0;
        return create(gliststr);
    }    
    //�����Դ�gliststr[i]��ʼ���Ӵ��������ӹ����ǰ�����﷨��ȷ���ݹ鷽��
    private static GenList<String> create(String gliststr)
    {
        i++;                                               //����'('
        GenList<String> glist = new GenList<String>();     //����չ����ֻ��ͷ���
        GenListNode<String> p = glist.head;                //ָ��ͷ���
        while (i<gliststr.length())
        {
            char ch=gliststr.charAt(i);
            switch (ch)
            {
                case ',': i++; break;
                case '(': 
                {
                    p.next=new GenListNode<String>();      //�����ӱ���
                    p = p.next; 
                    p.child = create(gliststr);            //�����ӱ��ݹ����
                    break;
                }
                case ')': i++; return glist;
                default :                                  //�ַ�����ʾԭ��
                {
                    int j=i+1;
                    ch=gliststr.charAt(j);
                    while (ch!='(' && ch!=',' && ch!=')')
                        ch=gliststr.charAt(++j);
                    p.next=new GenListNode<String>(gliststr.substring(i,j)); //�������
                    p = p.next; 
                    i=j;
                }
            }
        }
        return null;
    }
    
    public static void main(String args[])
    {
        GenList<String> glist_empty = createGenList("()");     //����չ����
        System.out.print("glist_empty��"+glist_empty.toString()+"��  length="+glist_empty.length()); 
        System.out.println("��depth="+glist_empty.depth()); 

        GenList<String> glist_L = createGenList("(a)");  //��������
//        GenList<String> glist_L = createGenList("(a,b,c,d,e,f)");  //��������
        System.out.print("glist_L��"+glist_L.toString()+"��  length="+glist_L.length()); 
        System.out.println("��depth="+glist_L.depth()); 
    
        GenList<String> glist_T = createGenList("(d,(a,b),(c,(a,b)))");
        System.out.print("glist_T��"+glist_T.toString()+"��  length="+glist_T.length()); 
        System.out.println("��depth="+glist_T.depth()); 

        GenList<String> glist_S = createGenList("(and,(begin,end),(my,your,(his,her)))");
        System.out.print("glist_S��"+glist_S.toString()+"��  length="+glist_S.length()); 
        System.out.println("��depth="+glist_S.depth()); 
    }
}    
/*
�������н�����£�
glist_empty��()��  length=0��depth=1
glist_L��(a,b,c,d,e,f)��  length=6��depth=1
glist_T��(d,(a,b),(c,(a,b)))��  length=3��depth=3
glist_S��(and,(begin,end),(my,your,(his,her)))��  length=3��depth=3

*/
