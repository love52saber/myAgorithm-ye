//��ϰ6.7�� ��������������������ĸ��㡣

public class ThreadBinaryTree_getParent
{
    public static void main(String args[])
    {
        String[] prelist = {"A","B","C",null,null,"D",null,"E","F",null,null,"G",null,null,
            "H","I","J","K","L","M",null,null,"N",null,null,null,"O",null,"P",null,"Q","R",null,null,null,null,"S"};
        ThreadBinaryTree<String> tbitree = new ThreadBinaryTree<String>(prelist);    //������������������
        tbitree.preOrder();                                 //�ȸ��������
        tbitree.inOrder();                                  //�и��������
        tbitree.inOrder_pred();                             //�и������������ǰ����
        tbitree.postOrder_pred();                           //��������������ǰ����
        for (ThreadNode<String> p=tbitree.root;  p!=null; p=tbitree.preNext(p))
            System.out.println(p+"�ĸ�ĸ�����"+tbitree.getParent(p)); 
    }
}
/*
�������н�����£�
�ȸ������������������������  A B C D E F G H I J K L M N O P Q R S 
�и������������������������  C B D F E G A M L N K J O P R Q I H S 
�и����򣨷��򣩱�������������������  S H I Q R P O J K N L M A G E F D B C 
������򣨷��򣩱�������������������  A H S I J O P Q R K L N M B D E G F C 
A�ĸ�ĸ�����null
B�ĸ�ĸ�����A
C�ĸ�ĸ�����B
D�ĸ�ĸ�����B
E�ĸ�ĸ�����D
F�ĸ�ĸ�����E
G�ĸ�ĸ�����E
H�ĸ�ĸ�����A
I�ĸ�ĸ�����H
J�ĸ�ĸ�����I
K�ĸ�ĸ�����J
L�ĸ�ĸ�����K
M�ĸ�ĸ�����L
N�ĸ�ĸ�����L
O�ĸ�ĸ�����J
P�ĸ�ĸ�����O
Q�ĸ�ĸ�����P
R�ĸ�ĸ�����Q
S�ĸ�ĸ�����H

*/

