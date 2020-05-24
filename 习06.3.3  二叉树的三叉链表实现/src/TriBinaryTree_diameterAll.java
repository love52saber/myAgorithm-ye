//��ϰ6.6��  �����������洢������������ֱ����
//ʹ��˳������

public class TriBinaryTree_diameterAll
{    
    //�����������洢������������ֱ��
    public static<T> void printDiameterAll(TriBinaryTree<T> bitree)
    {
        SeqList<TriNode<T>> list=new SeqList<TriNode<T>>();
        findDeepest(bitree.root, list);
        System.out.print("��������"+list.length()+"��ֱ��Ϊ�� ");
        for (int i=0; i<list.length(); i++)
        {
            String path=")";
            for (TriNode<T> deep=list.get(i);  deep!=bitree.root;  deep=deep.parent)
                path = ","+deep.data.toString()+path;
            if (bitree.root!=null)
                path = bitree.root.toString()+path;
            System.out.print("("+path+"  ");
        }
        System.out.println();
    }

    //����pΪ����������Ѱ�����в�������Ҷ�ӽ�㣬�洢��˳���list�У������������ݹ��㷨
    private static<T> void findDeepest(TriNode<T> p, SeqList<TriNode<T>> list)
    {
        if (p!=null)
        {
            findDeepest(p.left, list);
            findDeepest(p.right, list);
            int maxlevel=1;
            if (list.length()!=0)
                maxlevel = list.get(0).level;               //����ѱ��������������
            if (p.level > maxlevel) 
            {
                maxlevel = p.level; 
                list.removeAll();
            }
            if (p.level == maxlevel) 
                list.append(p); 
        }
    }

    public static void main(String args[])
    {
        //ͼ6-19��ʾ�������������������ȸ�����
        String[] prelist = {"A","B","D",null,"G",null,null,null,"C","E",null,null,"F","H"};
        TriBinaryTree<String> bitree = new TriBinaryTree<String>(prelist);
        bitree.preOrder();
        printDiameterAll(bitree);                          //���������������ֱ��
    }
}
/*
�������н�����£�
�ȸ����������������  1A 2B 3D 4G 2C 3E 3F 4H 
��������2��ֱ��Ϊ�� (A,B,D,G)  (A,C,F,H)  


*/
