//ϰ��6

public class BinaryTree_ex
{    
    public static void main(String args[])
    {
/*        //�������������ȸ����У����ö�����Ҳ��
        String[] prelist1 = {"A","B",null,null,"C",};
        BinaryTree<String> bitree1 = new BinaryTree<String>(prelist1);
        bitree1.preOrder();
        bitree1.inOrder();
        bitree1.postOrder();
        System.out.println("�Ƿ���ȫ��������  "+bitree1.isCompleteBinaryTree());
*/
        String[] prelist2 = {"A","B","D",null,"G",null,null,null,"C","E",null,null,"F","H"};
        BinaryTree<String> bitree2 = new BinaryTree<String>(prelist2);
        bitree2.preOrder();
        bitree2.inOrder();
        bitree2.postOrder();
        bitree2.preOrderTraverse();
        bitree2.inOrderTraverse();
        bitree2.postOrderTraverse();
/*        System.out.println(bitree2.toGenListString());
        bitree2.levelOrder();                         //����α���������
        System.out.println("H���Ĳ���� "+bitree2.getLevel("H"));
        System.out.println("�Ƿ���ȫ��������  "+bitree2.isCompleteBinaryTree());

        System.out.print("Ҷ�ӽ�㣺  ");
        bitree2.leaf();
        System.out.println("����"+bitree2.countLeaf()+"��");

        BinaryTree<String> bitree3 = new BinaryTree<String>(bitree2); //���
        System.out.println("���ö��������?  "+bitree3.equals(bitree2));
        System.out.println("��3�ö������滻(\"D\",\"F\")��");
        bitree3.replace("D","F");
        
        System.out.println("���ö��������?  "+bitree3.equals(bitree2));
        System.out.println("��3�ö�����ȫ���滻(\"F\",\"Y\")  ");
        bitree3.replaceAll("F","Y");
        bitree3.preOrder();

        BinaryNode<String> find = bitree2.search("D");      //����
        bitree2.insertChild(find, "Z", true);
        System.out.println("����Z��Ϊ "+find.data+"������");
        bitree2.preOrder();
*/        
    }
}
/*
�������н�����£�
�ȸ����������������  A B C 
�и����������������  B A C 
������������������  B C A 
�Ƿ���ȫ��������  true
�ȸ����������������  A B D G C E F H 
�и����������������  D G B A E C H F 
������������������  G D B E H F C A 
�Թ�����ʾ�����������A(B(D(^,G),^),C(E,F(H,^)))
��α�����������  A B C D E F G H 
H���Ĳ���� 4
�Ƿ���ȫ��������  false
Ҷ�ӽ�㣺  G E H ����3��
���ö��������?  true
��3�ö������滻("D","F")��  true
���ö��������?  false
��3�ö�����ȫ���滻("F","Y")  
�ȸ����������������  A B Y G C E Y H 
����Z��Ϊ D������
�ȸ�����������ǵݹ飩��  A B D Z G C E F H 
�и�����������ǵݹ飩��  Z D G B A E C H F 
�������������ǵݹ飩��  Z G D B E H F C A 


        BinaryTree<String> bitree4 = new BinaryTree<String>(prelist2);
        bitree4.root = bitree4.create(prelist2);           //��iԽ�磬˽�л��ɱ�������
        bitree4.preOrder();

�ȸ����У�  A B D G C E F H 
�и����У�  D G B A E C H F 
������У�  G D B E H F C A 

�и����У�  A B C D E 
����������? true

        */

