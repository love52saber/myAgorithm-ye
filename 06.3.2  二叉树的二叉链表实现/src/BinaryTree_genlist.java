//����6.3�� �������Ĺ�����ʾ��

public class BinaryTree_genlist
{    
    private static int i=0;
    public static BinaryTree<String> createByGenList(String glist) //�Թ�����ʾ���������
    {
        BinaryTree<String> bitree = new BinaryTree<String>();
        i=0;
        if (glist.length()>0)
            bitree.root = create(glist);                   //����������������ֵ��glist[0]
        return bitree;
    }
    //�Թ�����ʾ����һ��������������ֵ��glist[i]�����ظ���㣬�ݹ鷽��
    private static BinaryNode<String> create(String glist)
    {
        BinaryNode<String> p=null;
        char ch=glist.charAt(i);
        if (ch>='A' && ch<='Z')                            //��д��ĸ
        {
            p = new BinaryNode<String>(ch+"");             //����Ҷ�ӽ��
            i++;
            if (glist.charAt(i)=='(')
            {
                i++;                                       //����'('
                p.left = create(glist);                    //�������������ݹ����
                i++;                                       //����','
                p.right = create(glist);                   //�������������ݹ����
                i++;                                       //����')'
            }
        }
        if (ch=='^')
            i++;                                           //����'^'
        return p;                                          //�մ�����null
    }
    public static void main(String args[])
    {
        String glist = "A(B(D(^,G),^),C(E,F(H,^)))";       //ͼ6.18��ʾ�������Ĺ�����ʾ
        BinaryTree<String> bitree = createByGenList(glist);               
        System.out.println(bitree.toGenListString());               
        System.out.println("�Ƿ���ȫ��������  "+bitree.isCompleteBinaryTree());        
                
        glist = "A(B,C)";
        bitree = createByGenList(glist);               
        System.out.println(bitree.toGenListString());      
        //ϰ��6
        System.out.println("�Ƿ���ȫ��������  "+bitree.isCompleteBinaryTree());        
    }
}

/*
�������н�����£�
�������Ĺ�����ʾ��A(B(D(^,G),^),C(E,F(H,^)))
�������Ĺ�����ʾ��A(B,C)

*/
