//【习6.7】 在中序线索二叉树中求父母结点。

public class ThreadBinaryTree_getParent
{
    public static void main(String args[])
    {
        String[] prelist = {"A","B","C",null,null,"D",null,"E","F",null,null,"G",null,null,
            "H","I","J","K","L","M",null,null,"N",null,null,null,"O",null,"P",null,"Q","R",null,null,null,null,"S"};
        ThreadBinaryTree<String> tbitree = new ThreadBinaryTree<String>(prelist);    //创建中序线索二叉树
        tbitree.preOrder();                                 //先根次序遍历
        tbitree.inOrder();                                  //中根次序遍历
        tbitree.inOrder_pred();                             //中根次序遍历（求前驱）
        tbitree.postOrder_pred();                           //后根次序遍历（求前驱）
        for (ThreadNode<String> p=tbitree.root;  p!=null; p=tbitree.preNext(p))
            System.out.println(p+"的父母结点是"+tbitree.getParent(p)); 
    }
}
/*
程序运行结果如下：
先根次序遍历中序线索二叉树：  A B C D E F G H I J K L M N O P Q R S 
中根次序遍历中序线索二叉树：  C B D F E G A M L N K J O P R Q I H S 
中根次序（反序）遍历中序线索二叉树：  S H I Q R P O J K N L M A G E F D B C 
后根次序（反序）遍历中序线索二叉树：  A H S I J O P Q R K L N M B D E G F C 
A的父母结点是null
B的父母结点是A
C的父母结点是B
D的父母结点是B
E的父母结点是D
F的父母结点是E
G的父母结点是E
H的父母结点是A
I的父母结点是H
J的父母结点是I
K的父母结点是J
L的父母结点是K
M的父母结点是L
N的父母结点是L
O的父母结点是J
P的父母结点是O
Q的父母结点是P
R的父母结点是Q
S的父母结点是H

*/

