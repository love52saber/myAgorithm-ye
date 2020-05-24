//��ϰ6.2�� ��֤������������3��n0=n2+1��

public class Property3<T>                                  //��֤������������3��n0=n2+1
{
    private static int n0=0,n2=0;
    public static<T> void count(BinaryTree<T> bitree)      //ͳ��2�Ƚ���Ҷ�ӽ�����
    {
        n0=0; n2=0;
        count(bitree.root);
        System.out.println("��֤������������3��n0="+n0+"��n2="+n2+"��n0==n2+1��"+(n0==n2+1));
    }
    private static<T> void count(BinaryNode<T> p)           //ͳ��2�Ƚ���Ҷ�ӽ�����
    {
        if (p!=null)
        {
            if (p.left==null && p.right==null)             //Ҷ�ӽ��
                n0++;
            if (p.left!=null && p.right!=null)             //2�Ƚ��
                n2++;
            count(p.left);
            count(p.right);
        }
    }

    public static void main(String args[])
    {
        String[] prelist = {"A","B","D",null,"G",null,null,null,"C","E",null,null,"F","H"}; //�������������ȸ�����
        BinaryTree<String> bitree = new BinaryTree<String>(prelist);
        bitree.preOrder();
        count(bitree);

        String[] preorder2 = {"A","B",null,null,"C"};               //�������������ȸ�����
        BinaryTree<String> bitree2 = new BinaryTree<String>(preorder2);
        bitree2.preOrder();
        count(bitree2);
    }
}
/*
�������н�����£�
�ȸ����������������  A B D G C E F H 
��֤������������3��n0=3��n2=2��n0==n2+1��true
�ȸ����������������  A B C 
��֤������������3��n0=2��n2=1��n0==n2+1��true

*/
