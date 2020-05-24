//6.6.3   ���ĺ����ֵ�����ʵ��
//ϰ��6

public class Tree_ex
{    
    public static Tree<String> make645()                   //����ͼ6.45��ʾ��һ����
    {
        Tree<String> tree = new Tree<String>();
        tree.root = new TreeNode<String>("A");
        TreeNode<String> child = tree.insertLastChild(tree.root, "B");
        tree.insertLastChild(child, "E");
        tree.insertLastChild(child, "F");
        tree.insertLastChild(tree.root, "C");
        child = tree.insertLastChild(tree.root, "D");
        tree.insertLastChild(child, "G");
        return tree;
    }

    public static Tree<String> make602()                   //����ͼ6.2��ʾ��һ����
    {
        Tree<String> tree = new Tree<String>();
        tree.root = new TreeNode<String>("D");
        tree.insertChild(tree.root, "H", 2);                //0
        tree.insertChild(tree.root, "J", 3);                //1
        tree.insertChild(tree.root, "I", 1);                //1
        tree.insertRoot("A");
        TreeNode<String> child = tree.insertChild(tree.root, "B", 0); //0
        tree.insertChild(child, "E", 2);                    //1
        tree.insertChild(child, "F", 3);                    //2
        child = tree.insertChild(tree.root, "C", 1); 
        tree.insertChild(child, "G", 2);                    //0
        return tree;
    }

    public static void main(String args[])
    {
        Tree<String> tree = make602();
        System.out.print("ͼ6.2����"+tree.toString());        //�ȸ�����������������ĺ������ʾ�������
//        Tree<String> tree = make645();
//        System.out.print("ͼ6.45����"+tree.toString());     //�ȸ�����������������ĺ������ʾ�������
        tree.preOrderTraverse();                           //�ȸ���������������        
        tree.postOrder();                                  //�����������������        
        System.out.println("��������"+tree.count()+"���߶���"+tree.height());
        System.out.println(tree.root.data.toString()+"��"+tree.childCount(tree.root)+"�����ӽ��");
        System.out.print(tree.toGenListString());          //������Ĺ������ʽ
        tree.levelOrder();                                 //����α�����
        
        System.out.println("J���Ĳ����"+tree.getLevel("J"));
        TreeNode<String> find = tree.search("J");          //����
        System.out.println(find.data+"���ĸ�ĸ�����"+tree.getParent(find));        
        find = tree.search("D");
        tree.removeChild(find, 1); 
        System.out.print("ɾ��"+find.data+"�ĵ�1�����ӣ�");
        tree.preOrder();                                   //�ȸ���������������
        tree.removeChild(find, 0); 
        System.out.print("ɾ��"+find.data+"�ĵ�0�����ӣ�");
        tree.preOrder();
        tree.removeChild(find, 0);                  
        System.out.print("ɾ��"+find.data+"�ĵ�0�����ӣ�");
        tree.preOrder();
        
        
    }
}
/*
�������н�����£�
ͼ6.2�����ȸ������������ 
 A
	B
		E
		F
	C
		G
	D
		H
		I
		J
������������:  E F B G C H I J D A 
��������10���߶���7
A��3�����ӽ��
������Ĺ�����ʾ��A(B(E,F),C(G),D(H,I,J))
��α�������  A B C D E F G H I J 
J���Ĳ����3
ɾ��D�ĵ�1�����ӣ��ȸ����������:  A B E F C G D H J 
ɾ��D�ĵ�0�����ӣ��ȸ����������:  A B E F C G D J 
ɾ��D�ĵ�0�����ӣ��ȸ����������:  A B E F C G D 

        BinaryTree<String> bitree3 = new BinaryTree<String>(bitree2); //���
        System.out.println("���ö��������?  "+bitree3.equals(bitree2));
        System.out.println("��3�ö������滻(\"D\",\"F\")��  "+bitree3.replace("D","F"));        
        System.out.println("���ö��������?  "+bitree3.equals(bitree2));
        System.out.println("��3�ö�����ȫ���滻(\"F\",\"Y\")  ");
        bitree3.replaceAll("F","Y");
        */

