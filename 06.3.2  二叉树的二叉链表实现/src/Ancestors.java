//����6.2��  �����������ָ�������������Ƚ�㡣

public class Ancestors 
{
    public static void main(String args[])
    {
        //��ͼ6.15��a����ʾ���������ȸ����к��и����д���������
        String[] prelist = {"A","B","D","G","C","E","F","H"};
        String[] inlist = {"D","G","B","A","E","C","H","F"};
        BinaryTree<String> bitree = new BinaryTree<String>(prelist, inlist);

        //ͼ6.18��ʾ�������������������ȸ�����
/*        String[] prelist = {"A","B","D",null,"G",null,null,null,"C","E",null,null,"F","H"};
        BinaryTree<String> bitree = new BinaryTree<String>(prelist);
*/        bitree.preOrder();
        bitree.inOrder();
        bitree.postOrder();
        System.out.println("��������"+bitree.count()+"���߶���"+bitree.height());
/*
        String value="H";
        BinaryNode<String> find = bitree.search(value);    //����
        if (find==null)
            System.out.println("δ�ҵ�"+value);
        else
        {
            BinaryNode<String> parent = bitree.getParent(find);
            System.out.print(find.data+"�����Ƚ����");
            while (parent!=null)
            {
                System.out.print(parent.data+"  ");
                parent = bitree.getParent(parent);
            }
            System.out.println();
        }*/
    }
}
/*
�������н�����£�
�ȸ����������������  A B D G C E F H 
�и����������������  D G B A E C H F 
������������������  G D B E H F C A 
��������8���߶���4
H�����Ƚ����F  C  A  

δ�ҵ�Z
D�����Ƚ����B  A 

*/
/*
        //��ͼ6.15��a����ʾ���������ȸ����к��и����д���������
prelist:ABDGCEFH��inlist:DGBAECHF
prelist:BDG��inlist:DGB
prelist:DG��inlist:DG
prelist:��inlist:
prelist:G��inlist:G
prelist:��inlist:
prelist:��inlist:
prelist:��inlist:
prelist:CEFH��inlist:ECHF
prelist:E��inlist:E
prelist:��inlist:
prelist:��inlist:
prelist:FH��inlist:HF
prelist:H��inlist:H
prelist:��inlist:
prelist:��inlist:
prelist:��inlist:
�ȸ����������������  A B D G C E F H 
�и����������������  D G B A E C H F 
������������������  G D B E H F C A 
��������8���߶���4
 * */
