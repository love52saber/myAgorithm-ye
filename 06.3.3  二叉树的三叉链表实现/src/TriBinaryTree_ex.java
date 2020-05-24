//����6.4��  �����������ֱ����

public class TriBinaryTree_ex
{    	
    public static void main(String args[])
    {
        //ͼ6.18��ʾ�������������������ȸ�����
        String[] prelist = {"A","B","D",null,"G",null,null,null,"C","E",null,null,"F","H"};
        TriBinaryTree<String> bitree = new TriBinaryTree<String>(prelist);
        bitree.preOrder();
        bitree.inOrder();
        bitree.postOrder();
        bitree.levelOrder();
        System.out.println("��������"+bitree.count()+"���߶���"+bitree.height());
        
        //ϰ��6
        TriBinaryTree<String> bitree2 = new TriBinaryTree<String>(bitree);//���
        System.out.println("���ö��������?  "+bitree.equals(bitree2));
        TriNode<String> find = bitree2.searchNode("F");        //����
        if (find==null)
   	        System.out.println("��2�ö��������ң�  null");
        else
        {
            System.out.println(find.data.toString()+"�ĸ�ĸ�����"+find.parent.data.toString());
            find.data = "Y";
            bitree2.insertChild(find, "Z", true);
            System.out.println("����Z��Ϊ "+find.data+"������");
        }
        TriNode<String> q = bitree2.insertChild(bitree2.root.right, "X", false);
                                                          //����X��Ϊ���Һ��ӵ��Һ���
        System.out.println("ɾ��"+q.data.toString()+"�Һ��ӵ�����E");
	    System.out.println("��1�ö�������  ");
        bitree.preOrder();
        bitree.inOrder();
        bitree.postOrder();
        bitree.levelOrder();
        System.out.println("��2�ö�������  ");
        bitree2.preOrder();
        bitree2.inOrder();
        bitree2.postOrder();
        bitree2.levelOrder();
    }
}
/*
�������н�����£�
�ȸ����������������  1A 2B 3D 4G 2C 3E 3F 4H 
�и����������������  3D 4G 2B 1A 3E 2C 4H 3F 
������������������  4G 3D 2B 3E 4H 3F 2C 1A 
��α�����  1A 2B 2C 3D 3E 3F 4G 4H 
��������8���߶���4
���ö��������?  true
F�ĸ�ĸ�����C
����Z��Ϊ Y������
ɾ��X�Һ��ӵ�����E
��1�ö�������  
�ȸ����������������  1A 2B 3D 4G 2C 3E 3F 4H 
�и����������������  3D 4G 2B 1A 3E 2C 4H 3F 
������������������  4G 3D 2B 3E 4H 3F 2C 1A 
��α�����  1A 2B 2C 3D 3E 3F 4G 4H 
��2�ö�������  
�ȸ����������������  1A 2B 3D 4G 2C 3E 3X 4Y 5Z 6H 
�и����������������  3D 4G 2B 1A 3E 2C 3X 6H 5Z 4Y 
������������������  4G 3D 2B 3E 6H 5Z 4Y 3X 2C 1A 
��α�����  1A 2B 2C 3D 3E 3X 4G 4Y 5Z 6H 

*/
