//5.3   �����
//5.3.2   �����Ĵ洢�ṹ
//2.  ������˫����ʾ

//ʹ��GenList�࣬��ԭ�����鹹������
public class GenList_ex
{    
    public static void main(String args[])
    {
        GenList<String> glist_empty = new GenList<String>();//����չ����		
        System.out.print("glist_empty��"+glist_empty.toString()+"��  length="+glist_empty.length()); 
        System.out.println("��depth="+glist_empty.depth()); 

        glist_empty.insert(0, new GenList<String>());      //�ձ��в���ձ�
        glist_empty.append(new GenList<String>()); 
        System.out.print("glist��"+glist_empty.toString()+"��  length="+glist_empty.length()); 
        System.out.println("��depth="+glist_empty.depth()); 

        String[] gliststr_l = {"b","c","e"};
        GenList<String> glist_L = new GenList<String>(gliststr_l);//��ԭ�����鹹������
        glist_L.insert(0, "a");                            //ͷ����ԭ��
        glist_L.insert(3, "d");                            //�м����ԭ��
        glist_L.append("f");                               //β����ԭ��
        System.out.print("glist_L��"+glist_L.toString()+"��  length="+glist_L.length()); 
        System.out.println("��depth="+glist_L.depth()); 
    
        String[] gliststr_t = {"o","p","q"};
        GenList<String> glist_T = new GenList<String>(gliststr_t);
        glist_T.append(glist_L);                           //β�����ӱ�
        System.out.print("glist_T��"+glist_T.toString()+"��  length="+glist_T.length()); 
        System.out.println("��depth="+glist_T.depth()); 

        String[] gliststr_g = {"x","y","z"};
        GenList<String> glist_G = new GenList<String>(gliststr_g);
        glist_G.append(glist_L);
        glist_G.append(glist_T);                           //β�����ӱ�glist_L��Ϊ�����ӱ�
        System.out.print("glist_G��"+glist_G.toString()+"��  length="+glist_G.length()); 
        System.out.println("��depth="+glist_G.depth()); 
    }
}    
/*
�������н�����£�
glist_empty��()��  length=0��depth=1
glist��((),())��  length=2��depth=2
glist_L��(a,b,c,d,e,f)��  length=6��depth=1
glist_T��(o,p,q,(a,b,c,d,e,f))��  length=4��depth=2
glist_G��(x,y,z,(a,b,c,d,e,f),(o,p,q,(a,b,c,d,e,f)))��  length=5��depth=3

*/
