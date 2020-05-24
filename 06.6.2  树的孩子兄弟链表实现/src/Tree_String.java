//6.6.3   ���ĺ����ֵ�����ʵ��
//����6.8�� �����ĺ������ʾ��������ɭ�֡�

public class Tree_String
{
    //�Ժ������ʾ��������ɭ�֣�prelist����洢����ɭ�ֵĺ������ʾ�ַ�������
    public static Tree<String> create(String prelist[])
    {
        Tree<String> tree = new Tree<String>();            //��������
        if (prelist.length!=0)
        {
            tree.root = new TreeNode<String>(prelist[0]);  //���������
            for (int i=1; i<prelist.length; i++)
                insert(tree, prelist[i]);                  //��ֵΪprelist[i]�����뵽treeɭ�ֵ����һ������
        }
        return tree;
    }

    //��treeɭ�����һ�����в�����str�������ʾ��һ����㣬���ֵȥ����str����\tǰ׺
    //�ǵݹ��㷨
    public static void insert(Tree<String> tree, String str)
    {
        TreeNode<String> p = tree.getLastSibling(tree.root); //pָ��������һ���ֵ�
        if (p==null)
            p = tree.root;                                 //pû���ֵ�ʱָ�����ѡ��ɭ�������һ����
        if (str.charAt(0)!='\t')
            p.sibling = new TreeNode<String>(str);
//            tree.insertLastSibling(p, str);                //û��\tǰ׺ʱ������str��Ϊp�������һ���ֵ�
        else
        {                                                  //��\tǰ׺ʱ������str��p�����һ��������
            str = str.substring(1);                        //ȥ��str����һ��ǰ׺'\t'
            while (str.charAt(0)=='\t')                    //�ַ�����\t��ͷ
            {
                TreeNode<String> lastChild=tree.getLastChild(p);//���p�����һ�����ӽ��
                if (lastChild!=null)
                    p = lastChild;
                str = str.substring(1);                    //ȥ��str����һ��ǰ׺'\t'
            }
            tree.insertLastChild(p, str);                  //����str��Ϊp�������һ������
        }
    }
    
    public static void main(String[] args)
    {
    	String prelist[]={"�й�","\t����","\t�Ϻ�","\t����","\t\t�Ͼ�","\t\t\t����","\t\t����",
            "\t\t����","\t\t\t��ɽ","\t�㽭","\t\t����","\t\t����","\t\t����","\t�㶫","\t\t����",
            "����","\t�׶�","����","\t��ʢ����","\t\t��ʢ��","\tŦԼ��","\t\tŦԼ"};
        Tree<String> tree = create(prelist);                //�����ĺ������ʾ����������ɭ��
//        System.out.print(tree.toString());                 //�ȸ������������������ĺ������ʾ�ַ���

   	    String prelist2[]={"A","\tB","\t\tE","\t\tF","\tC","\tD","\t\tG"}; //6.45
//      String prelist[]={"A","\tB","\t\tE","\t\tF","\tC","\t\tG","\tD","\t\tH","\t\tI","\t\tJ"};   //6.2
//        String prelist[]={"A","\tB","\t\tE","\t\tF","\tC","\tD","\t\tG","H","\tI","J","\tK","\tL"}; //6.48
        Tree<String> tree2 = create(prelist2);                //�����ĺ������ʾ����������ɭ��
//        System.out.print(tree2.toString());                 //�ȸ������������������ĺ������ʾ�ַ���

        tree.insertChild(tree.root, tree2, 2);
        System.out.print(tree.toString());        
    }
    
    //ϰ��6
    //�ݹ��㷨
    //�Ժ������ʾ��������ɭ�֣�prelist����洢����ɭ�ֵĺ������ʾ�ַ�������
    /*    public static Tree<String> create(String prelist[])
        {
            Tree<String> tree = new Tree<String>();            //��������
            if (prelist!=null && prelist.length!=0)
            {
                tree.root = new TreeNode<String>(prelist[0]);  //���������
                for (int i=1; i<prelist.length; i++)
                {       
                    TreeNode<String> lastSibling=tree.getLastSibling(tree.root);//��ø������һ���ֵܽ��
                    if (lastSibling==null)                     //��û���ֵ�
                        insert(tree, tree.root, prelist[i]);   //��ֵΪprelist[i]�����뵽����������
                    else
                        insert(tree, lastSibling, prelist[i]); //���뵽�����һ���ֵܽ���������
                }
            }
            return tree;
        }
    */
        //��tree���в���һ�������Ϊp���ֵܻ��ӣ������str�Ժ������ʾһ�����ֵ��
        //����Ľ��ֵΪstrȥ������ǰ׺\t���ַ������ݹ��㷨
        //ǰ��p!=null
        private static void insert(Tree<String> tree, TreeNode<String> p, String str)
        { 
            if (str.charAt(0)!='\t')
                tree.insertLastSibling(p, str);           //û��\tǰ׺ʱ������str��Ϊp�����һ���ֵ�
            else
            {                                             //��\tǰ׺ʱ������str��p�����һ��������
                str = str.substring(1);                        //ȥ��str����һ��ǰ׺'\t'
                TreeNode<String> lastChild=tree.getLastChild(p);//���p�����һ�����ӽ��
                if (lastChild==null)                           //pû�к���
                    tree.insertLastChild(p, str);              //����str��Ϊp�����һ������
                else
                    insert(tree, lastChild, str);              //���뵽p�����һ�������У��ݹ����
            }
        }    
}
/*
�������н�����£�
�ȸ������������ 
 �й�
	����
	�Ϻ�
	����
		�Ͼ�
			����
		����
		����
			��ɽ
	�㽭
		����
		����
		����
	�㶫
		����
����
	�׶�
����
	��ʢ����
		��ʢ��
	ŦԼ��
		ŦԼ

*/
