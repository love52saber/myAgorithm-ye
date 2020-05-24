//【习6.6】  输出三叉链表存储二叉树的所有直径。
//使用顺序表对象

public class TriBinaryTree_diameterAll
{    
    //输出三叉链表存储二叉树的所有直径
    public static<T> void printDiameterAll(TriBinaryTree<T> bitree)
    {
        SeqList<TriNode<T>> list=new SeqList<TriNode<T>>();
        findDeepest(bitree.root, list);
        System.out.print("二叉树的"+list.length()+"条直径为： ");
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

    //在以p为根的子树中寻找所有层次最深的叶子结点，存储在顺序表list中，后根次序遍历递归算法
    private static<T> void findDeepest(TriNode<T> p, SeqList<TriNode<T>> list)
    {
        if (p!=null)
        {
            findDeepest(p.left, list);
            findDeepest(p.right, list);
            int maxlevel=1;
            if (list.length()!=0)
                maxlevel = list.get(0).level;               //获得已遍历过结点的最大层次
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
        //图6-19所示二叉树标明空子树的先根序列
        String[] prelist = {"A","B","D",null,"G",null,null,null,"C","E",null,null,"F","H"};
        TriBinaryTree<String> bitree = new TriBinaryTree<String>(prelist);
        bitree.preOrder();
        printDiameterAll(bitree);                          //输出二叉树的所有直径
    }
}
/*
程序运行结果如下：
先根次序遍历二叉树：  1A 2B 3D 4G 2C 3E 3F 4H 
二叉树的2条直径为： (A,B,D,G)  (A,C,F,H)  


*/
