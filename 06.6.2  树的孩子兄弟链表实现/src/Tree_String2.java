//6.6.3   ���ĺ����ֵ�����ʵ��
//����6.8�� �����ĺ������ʾ��������ɭ�֡�
//��4�����TTree���ӿڿɲ�����getLastChild(TreeNode<T> p)��getLastSibling(TreeNode<T> p)����

public class Tree_String2
{
    //�Ժ������ʾ��������ɭ�֣�prelist����洢����ɭ�ֵĺ������ʾ�ַ�������
    //�ǵݹ��㷨����������ӷ�ʽ��û��ֱ�ӵ��÷��ء������㷽��
    public static Tree<String> create(String prelist[])
    {
        Tree<String> tree = new Tree<String>();            //��������
        if (prelist.length==0)
            return tree;                                   //���ؿ���
        tree.root = new TreeNode<String>(prelist[0]);      //���������
        TreeNode<String> p = tree.root;
        int len=0;                                         //p����ǰ׺'\t'����
        for (int i=1; i<prelist.length; i++)
        {        //����Ԫ��Ϊprelist[i]��㣬��ӵ�treeɭ�ֵ����һ�����У����ֵȥ��������\tǰ׺
            int j=0;
            while (j<prelist[i].length() && prelist[i].charAt(j)=='\t')
                j++;                                       //ͳ��prelist[i]����'\t'ǰ׺����
            
            String str = prelist[i].substring(j);          //ȥ��prelist[i]��������ǰ׺'\t'
            if (j==len+1)                                  //prelist[i]��p.data��һ��'\t'ǰ׺
            {
                p.child = new TreeNode<String>(str);       //������Ϊp�ĵ�һ������
                p = p.child;
                len++;
                continue;
            }
            if (j<len)                                     //prelist[i]��p.data��'\t'�٣�p�Ӹ���ʼ���Ҳ���λ��
            {
                len=0;
                p = tree.root;
                while (p.sibling!=null)                    //ѡ��ɭ�������һ����
                    p=p.sibling;                           //pָ��������һ���ֵ�
                while (len < j)                            //Ѱ�Ҳ���λ�ã���pָ��
                {
                    p=p.child;                             //p����һ��
                    len++;
                    while (p.sibling!=null)                //pָ�����һ���ֵ�
                        p=p.sibling;
                }
            }
            p.sibling = new TreeNode<String>(str);         //������Ϊp�����ֵ�
            p = p.sibling;
    	}
        return tree;
    }
    
    public static void main(String[] args)
    {
    	String prelist[]={"�й�","\t����","\t�Ϻ�","\t����","\t\t�Ͼ�","\t\t\t����","\t\t����",
            "\t\t����","\t\t\t��ɽ","\t�㽭","\t\t����","\t\t����","\t\t����","\t�㶫","\t\t����",
            "����","\t�׶�","����","�����","����","\t��ʢ����","\t\t��ʢ��","\tŦԼ��","\t\tŦԼ"};
        Tree<String> tree = create(prelist);                //�����ĺ������ʾ����������ɭ��
        System.out.print(tree.toString());                 //�ȸ������������������ĺ������ʾ�ַ���

/*   	    String prelist2[]={"A","\tB","\t\tE","\t\tF","\tC","\tD","\t\tG"}; //6.45
//      String prelist[]={"A","\tB","\t\tE","\t\tF","\tC","\t\tG","\tD","\t\tH","\t\tI","\t\tJ"};   //6.2
//        String prelist[]={"A","\tB","\t\tE","\t\tF","\tC","\tD","\t\tG","H","\tI","J","\tK","\tL"}; //6.48
        Tree<String> tree2 = create(prelist2);                //�����ĺ������ʾ����������ɭ��
//        System.out.print(tree2.toString());                 //�ȸ������������������ĺ������ʾ�ַ���

        tree.insertChild(tree.root, tree2, 2);
        System.out.print(tree.toString());       */ 
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


