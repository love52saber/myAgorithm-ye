//����6.1��  ���첢������������

public class BinaryTree_make
{
    public static BinaryTree<String> make()                  //���������һ�ö�����
    {
        BinaryTree<String> bitree=new BinaryTree<String>();  //�����ն�����
        BinaryNode<String> child_f, child_d, child_b, child_c;
        child_d = new BinaryNode<String>("D", null, new BinaryNode<String>("G"));
        child_b = new BinaryNode<String>("B", child_d, null);
        child_f = new BinaryNode<String>("F", new BinaryNode<String>("H"), null);
        child_c = new BinaryNode<String>("C", new BinaryNode<String>("E"), child_f);
        bitree.root = new BinaryNode<String>("A", child_b, child_c);
        return bitree;
    }
    public static void main(String args[])
    {
        BinaryTree<String> bitree = make();
        bitree.preOrder();                                   //�ȸ��������������
        bitree.inOrder();
        bitree.postOrder();
    }
}
/*
�������н�����£�
�ȸ����������������  A B D G C E F H 
�и����������������  D G B A E C H F 
������������������  G D B E H F C A 
*/
