//����6.9�� ���Ĺ�����ʾ�����졣

public class Tree_GenList
{
    private static int i=0;
    public static Tree<String> createByGenList(String glist) //�Թ�����ʾ������
    {
        Tree<String> tree = new Tree<String>();            //���������tree.root==null
        i=0;
        if (glist.length()>0)
            tree.root = create(glist);                     //����������������ֵ��glist[0]
        return tree;
    }

    //�Թ�����ʾ����һ�����������������ֵ��glist[i]�����������ĸ���㣬�ݹ鷽��
    //glist�����ǿմ�""��
    private static TreeNode<String> create(String glist)
    {
        TreeNode<String> p=null;
        int j=i+1;
        if (j<glist.length())
        {
            char ch=glist.charAt(j);
            while (ch!='(' && ch!=',' && ch!=')')          //ʶ���ַ�����Ϊ���Ԫ��ֵ
            {
                j++;
                ch=glist.charAt(j);
            }
        }
        p=new TreeNode<String>(glist.substring(i,j));      //�������
        i=j;
        if (i<glist.length() && glist.charAt(i)=='(')      //����(����������
        {
            i++;                                           //����'('
            p.child = create(glist);                       //�����������ݹ����
        }
        if (i<glist.length() && glist.charAt(i)==',')      //����,��������һ���ֵ�����
        {
            i++;                                           //����','
            p.sibling = create(glist);                     //������һ���ֵ��������ݹ����
        }
        if (i<glist.length() && glist.charAt(i)==')')      //����)�������������
            i++;                                           //����')'
        return p;                                          //�մ�����null    
    }
    
    public static void main(String args[])
    {
        String glist_empty = "";                           //����
        System.out.println("��"+createByGenList(glist_empty).toGenListString());               
        String glist_a = "A";                              //ֻ�и����A����
        System.out.println("ֻ�и����A��"+createByGenList(glist_a).toGenListString());  
        String glist_abc = "A(B,C)";                       //��
        System.out.println(glist_abc+createByGenList(glist_abc).toGenListString());         
        String glist_abe = "A(B(E,F),C(G),D(H,I,J))";      //ͼ6.2(c)��ʾ���Ĺ�����ʾ
        System.out.println("ͼ6.2(c)"+createByGenList(glist_abe).toGenListString());  

        String glist="�й�(����,�Ϻ�,����(�Ͼ�(����),����,����),�㽭(����,����,����),�㶫(����)),"+
                      "����(�׶�),����(��ʢ��)";
        System.out.println(createByGenList(glist).toGenListString());  
    }
}

/*
�������н�����£�
�����Ĺ�����ʾ��
ֻ�и����A�����Ĺ�����ʾ��A
A(B,C)���Ĺ�����ʾ��A(B,C)
ͼ6.2(c)���Ĺ�����ʾ��A(B(E,F),C(G),D(H,I,J))
���Ĺ�����ʾ���й�(����,�Ϻ�,����(�Ͼ�(����),����,����),�㽭(����,����,����),�㶫(����)),����(�׶�),����(��ʢ��)

*/