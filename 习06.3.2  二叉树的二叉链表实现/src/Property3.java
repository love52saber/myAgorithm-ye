//【习6.2】 验证二叉树的性质3，n0=n2+1。

public class Property3<T>                                  //验证二叉树的性质3，n0=n2+1
{
    private static int n0=0,n2=0;
    public static<T> void count(BinaryTree<T> bitree)      //统计2度结点和叶子结点个数
    {
        n0=0; n2=0;
        count(bitree.root);
        System.out.println("验证二叉树的性质3，n0="+n0+"，n2="+n2+"，n0==n2+1？"+(n0==n2+1));
    }
    private static<T> void count(BinaryNode<T> p)           //统计2度结点和叶子结点个数
    {
        if (p!=null)
        {
            if (p.left==null && p.right==null)             //叶子结点
                n0++;
            if (p.left!=null && p.right!=null)             //2度结点
                n2++;
            count(p.left);
            count(p.right);
        }
    }

    public static void main(String args[])
    {
        String[] prelist = {"A","B","D",null,"G",null,null,null,"C","E",null,null,"F","H"}; //标明空子树的先根序列
        BinaryTree<String> bitree = new BinaryTree<String>(prelist);
        bitree.preOrder();
        count(bitree);

        String[] preorder2 = {"A","B",null,null,"C"};               //标明空子树的先根序列
        BinaryTree<String> bitree2 = new BinaryTree<String>(preorder2);
        bitree2.preOrder();
        count(bitree2);
    }
}
/*
程序运行结果如下：
先根次序遍历二叉树：  A B D G C E F H 
验证二叉树的性质3，n0=3，n2=2，n0==n2+1？true
先根次序遍历二叉树：  A B C 
验证二叉树的性质3，n0=2，n2=1，n0==n2+1？true

*/
