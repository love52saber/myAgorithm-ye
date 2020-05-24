//5.3   �����
//5.3.2   �����Ĵ洢�ṹ
//2.  ������˫����ʾ

public class GenList_ch
{    
    private static int i=0;
    public static GenList<String> createGenList(String gliststr)  //��ָ���ַ������������ع����
    {
        i=0;
    	return create(gliststr);
    }
    
    //�����Դ�gliststr[i]��ʼ���Ӵ������Ĺ�����﷨��ȷ
    private static GenList<String> create(String gliststr)
    {
        i++;                                               //����'('
    	GenList<String> glist = new GenList<String>();     //����չ����ֻ��ͷ���
        GenListNode<String> p = glist.head;                //ָ��ͷ���
        while (i<gliststr.length())
        {
            char ch=gliststr.charAt(i);
            if (ch>='a' && ch<='z')                        //Сд��ĸ��ʾԭ��
            {
    	        p.next=new GenListNode<String>(ch+"", null, null); //�������
                p = p.next; 
                i++;
            }
            if (ch==',')
            	i++;
            if (ch=='(')
            {
    	        p.next=new GenListNode<String>(null,null,null); //�����ӱ�Ľ��
                p = p.next; 
            	p.child = create(gliststr);                //�����ӱ�
            }
            if (ch==')')
            {
            	i++;
            	return glist;
            }
        }
        return null;
    }
    public static void main(String args[])
    {
        GenList<String> glist_empty = createGenList("()"); //����չ����		
        System.out.print("glist_empty��"+glist_empty.toString()+"��  length="+glist_empty.length()); 
        System.out.println("��depth="+glist_empty.depth()); 

        GenList<String> glist_L = createGenList("(a,b,c,d)");  //��������
        System.out.print("glist_L��"+glist_L.toString()+"��  length="+glist_L.length()); 
        System.out.println("��depth="+glist_L.depth()); 
    	
        GenList<String> glist_T = createGenList("(a,b,c,(p,q),(x,y,(a,b)))");
        System.out.print("glist_T��"+glist_T.toString()+"��  length="+glist_T.length()); 
        System.out.println("��depth="+glist_T.depth()); 
    }
}    
