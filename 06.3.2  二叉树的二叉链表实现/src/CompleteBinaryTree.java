 //����6.3��  �������������ʾ����ȫ��������
 
//��4�� ����ȫ�������Ĳ�α������й����������ṹ�洢����ȫ������

//���������ʾ����ȫ�������࣬�̳ж������� 
public class CompleteBinaryTree<T> extends BinaryTree<T>
{
    public CompleteBinaryTree()                            //����ն�����
    {
        super();
    }

    //����ȫ�������Ĳ�����й�����ȫ��������levellistָ���������
    public CompleteBinaryTree(T[] levellist)
    {
        this.root = create(levellist, 0);
    }

    //������levellist[i]Ϊ����һ������ȫ���������������������ĸ����
    private BinaryNode<T> create(T[] levellist, int i)
    {
        BinaryNode<T> p = null;
        if (i<levellist.length)
        {
            p = new BinaryNode<T>(levellist[i]);           //����Ҷ�ӽ��
            p.left = create(levellist, 2*i+1);             //����p��������
            p.right = create(levellist, 2*i+2);            //����p��������
        }
        return p;
    }

    public static void main(String args[])
    {
        //ͼ6.10��ʾ��ȫ�������Ĳ�α�������
        String[] levellist = {"A","B","C","D","E","F","G","H"};
        CompleteBinaryTree<String> cbitree = new CompleteBinaryTree<String>(levellist);
        cbitree.preOrder();
        cbitree.inOrder();
        cbitree.postOrder();
        //ϰ��6
        System.out.println("�Ƿ���ȫ��������  "+cbitree.isCompleteBinaryTree());
    }
}
/*
�ȸ����У�  A B D H E C F G 
�и����У�  H D B E A F C G 
������У�  H D E B F G C A 
*/