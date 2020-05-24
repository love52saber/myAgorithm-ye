//����6.4��  �����������洢��������һ��ֱ����
//��һ����������洢�Ķ������У����һ��ֱ�������Ӹ�������Ҷ�ӽ���һ��·����

public class TriBinaryTree_diameter
{    
    //�����������洢��������һ��ֱ��
    public static<T> void printDiameter(TriBinaryTree<T> bitree)
    {
        String path=")";
        TriNode<T> deep=findDeepest(bitree.root,bitree.root);//deep�ҵ��״γ��ֵ�����Ҷ�ӽ��
        while (deep!=bitree.root)
        {
            path = ","+deep.data.toString()+path;
            deep = deep.parent;                            //���ϵ���ĸ���
        }
        if (bitree.root!=null)
            path = deep.data.toString()+path;
        System.out.println("��������ֱ�����Ӹ�������Ҷ�ӽ�㣩�� ("+path);
    }

    //��������pΪ����������Ѱ�ҵ�������Ҷ�ӽ�㣬deepָ��ǰ��֪��������㣬�ȸ���������ĵݹ��㷨
    private static<T> TriNode<T> findDeepest(TriNode<T> p, TriNode<T> deep)
    {
        if (p!=null)
        {
            if (p.level > deep.level)                      //��ǰ���Ĳ�θ���
                deep = p; 
            deep = findDeepest(p.left, deep);
            deep = findDeepest(p.right, deep);
        }
        return deep;
    }
    
    public static void main(String args[])
    {                                            //ͼ6-19��ʾ�������������������ȸ�����
        String[] prelist = {"A","B","D",null,"G",null,null,null,"C","E",null,null,"F","H"};
        TriBinaryTree<String> bitree = new TriBinaryTree<String>(prelist);
        bitree.preOrder();
        printDiameter(bitree);                             //�����������ֱ��
    }
}
/*
�������н�����£�
�ȸ����������������  1A 2B 3D 4G 2C 3E 3F 4H 
��������ֱ�����Ӹ�������Ҷ�ӽ�㣩�� (A,B,D,G)

�ȸ����������������                                                                                                    //������������ȷ
��������ֱ�����Ӹ�������Ҷ�ӽ�㣩�� ()

*/
//���⣺����������������ֱ����·����
