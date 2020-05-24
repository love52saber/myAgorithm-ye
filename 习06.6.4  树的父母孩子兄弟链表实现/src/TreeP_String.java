//6.6.4   ���ĸ�ĸ�����ֵ�����ʵ��
//����6.8�� �����ĺ������ʾ��������ɭ�֡�

public class TreeP_String
{
    //�Ժ������ʾ��������ɭ�֣�prelist����洢����ɭ�ֵĺ������ʾ�ַ�������
    //�ǵݹ��㷨����������ӷ�ʽ��û��ֱ�ӵ��÷��ء������㷽��
    public static TreeP<String> create(String prelist[])
    {
        TreeP<String> tree = new TreeP<String>();          //��������
        if (prelist.length==0)
            return tree;                                   //���ؿ���
        tree.root = new TreePNode<String>(prelist[0]);     //���������
        TreePNode<String> p = tree.root;
        int len=0;                                         //p����ǰ׺'\t'����
        for (int i=1; i<prelist.length; i++)
        {        //����Ԫ��Ϊprelist[i]��㣬��ӵ�treeɭ�ֵ����һ�����У����ֵȥ��������\tǰ׺
            int j=0;
            while (j<prelist[i].length() && prelist[i].charAt(j)=='\t')
                j++;                                       //ͳ��prelist[i]����'\t'ǰ׺����
            
            String str = prelist[i].substring(j);          //ȥ��prelist[i]��������ǰ׺'\t'
            if (j==len+1)                                  //prelist[i]��p.data��һ��'\t'ǰ׺
            {
                p.child = new TreePNode<String>(str, p, null, null);//������Ϊp�ĵ�һ������
                p = p.child;
                len++;
                continue;
            }
            while (len > j)                                //prelist[i]��p.data��'\t'�٣�p����Ѱ�Ҳ���λ��
            {
                p=p.parent;                                //p����һ��
                len--;
            }
            p.sibling = new TreePNode<String>(str, p.parent, null, null);//������Ϊp�����ֵ�
            p = p.sibling;
        }
        return tree;
    }
    
    public static void main(String[] args)
    {
    	String prelist[]={"�й�","\t����","\t�Ϻ�","\t����","\t\t�Ͼ�","\t\t\t����","\t\t����",
            "\t\t����","\t\t\t��ɽ","\t�㽭","\t\t����","\t\t����","\t\t����","\t�㶫","\t\t����",
            "����","\t�׶�","����","�����","����","\t��ʢ����","\t\t��ʢ��","\tŦԼ��","\t\tŦԼ"};
        TreeP<String> tree = create(prelist);              //�����ĺ������ʾ����������ɭ��
        System.out.print(tree.toString());                 //�ȸ������������������ĺ������ʾ�ַ���
    }
}
/*
�������н�����£�
�ȸ������������ 
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
�����
����
	��ʢ����
		��ʢ��
	ŦԼ��
		ŦԼ

*/


