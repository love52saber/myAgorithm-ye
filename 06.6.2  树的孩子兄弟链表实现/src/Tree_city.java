//����6.7�� ����һ�ó�������ɭ�֡�

public class Tree_city
{
    public static Tree<String> make()                      //����һ�ó�������ɭ��
    {
        Tree<String> tree = new Tree<String>();            //����һ�ÿ���
        tree.root = new TreeNode<String>("�й�");
        tree.insertLastChild(tree.root, "������");
        tree.insertLastChild(tree.root, "�Ϻ���");
        TreeNode<String> js = tree.insertLastChild(tree.root, "����ʡ");
        tree.insertLastChild(js, "�Ͼ���");
        tree.insertLastChild(js, "������");
        TreeNode<String> zj = tree.insertLastSibling(js, "�㽭ʡ");
        tree.insertLastChild(zj, "������");
        tree.insertLastChild(zj, "������");
        tree.insertLastChild(zj, "������");
        TreeNode<String> korea = tree.insertLastSibling(tree.root, "����");
        tree.insertChild(korea, "�׶�", 0);
        TreeNode<String> usa = tree.insertLastSibling(korea, "����");
        tree.insertLastChild(usa, "��ʢ��");
        return tree;
    }

    public static void main(String[] args)
    {
        Tree<String> tree = make();
        System.out.print(tree.toString());                 //�ȸ������������������ĺ������ʾ�ַ���
    }
}

/*
�������н�����£�
�ȸ������������ 
 �й�
	������
	�Ϻ���
	����ʡ
		�Ͼ���
		������
	�㽭ʡ
		������
		������
		������
����
	�׶�
����
	��ʢ��

*/
