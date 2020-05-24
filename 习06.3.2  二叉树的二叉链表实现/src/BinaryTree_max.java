//【习6.3】  求一棵BinaryTree<T>二叉树中各结点数值的最大值和最小值。
//T必须实现Comparable<T>接口

public class BinaryTree_max
{    
    public static<T extends Comparable<T>> T max(BinaryTree<T> bitree)   //返回所有元素的最大值
    {
        T maxvalue = null;
        return max(bitree.root, maxvalue);
    }
    //返回以p结点为根的子二叉树所有元素的最大值，之前遍历子树的最大值已存放在maxvalue中，递归方法，先根次序遍历
    private static<T extends Comparable<T>> T max(BinaryNode<T> p, T maxvalue)
    {
        if (p!=null)
        {
            if (maxvalue==null || p.data.compareTo(maxvalue)>0) 
                maxvalue = p.data;
            maxvalue = max(p.left, maxvalue);
            maxvalue = max(p.right, maxvalue); 
        }
        return maxvalue;
    }
        
    public static<T extends Comparable<T>> T min(BinaryTree<T> bitree)   //返回所有元素的最小值
    {
        return min(bitree.root);
    }
    //返回以p结点为根的子二叉树所有元素的最小值，递归方法，后根次序遍历
    private static<T extends Comparable<T>> T min(BinaryNode<T> p)
    {
        if (p!=null)
        {
            T minvalue = min(p.left);
            T min_right = min(p.right); 
            if (minvalue==null || min_right!=null && min_right.compareTo(minvalue)<0) 
                minvalue = min_right;
            if (minvalue==null || p.data.compareTo(minvalue)<0) 
                minvalue = p.data;
            return minvalue;
        }
        return null;
    }

    //分段统计元素个数，according数组指定分段的划分，返回保存统计结果的数组
    public static<T extends Comparable<T>> int[] grade(T[] according, BinaryTree<T> bitree)
    {
        int result[]= new int[according.length+1];
        grade(according, bitree.root, result);
        return result;
    }
    //分段统计元素个数，according数组指定分段的划分，result数组保存统计结果
    private static<T extends Comparable<T>> void grade(T[] according, BinaryNode<T> p, int result[])
    {
        if (p!=null)  
        {
            int i=0;
            while (i<according.length && p.data.compareTo(according[i])<0)
                i++;
            result[i]++;
            grade(according, p.left, result);
            grade(according, p.right, result);
        }
    }

    public static void main(String args[])
    {
    	Integer[] value={79,82,71,63,95,90,65,75,80,55};
    	BinaryTree<Integer> bitree1 = new CompleteBinaryTree<Integer>(value);
                                                  //以完全二叉树的层次序列构造完全二叉树
//    	BinaryTree<Integer> bitree1 = new 
//            CompleteBinaryTree<Integer>(Ex103_ArraySearch_Object.randomInteger(10,100));
        bitree1.preOrder();
        System.out.println("最大值元素是 "+max(bitree1)+"，最小值元素是 "+min(bitree1));
        String str[]={"优秀","良好","中等","及格","不及格"};
        Integer[] according={90,80,70,60};
        int result[]=grade(according, bitree1);
        System.out.print("成绩统计：");
        for (int i=0; i<result.length; i++)
             System.out.print(str[i]+result[i]+"人，");
        System.out.println();       

/*        bitree1=new BinarySortTree<Integer>(Ex103_ArraySearch_Object.randomInteger(10,100));
                                                           //构造二叉排序树
        bitree1.inOrder();
        System.out.println("最大值元素是 "+max(bitree1)+"，最小值元素是 "+min(bitree1));

        BinaryTree<String> bitree2=new CompleteBinaryTree<String>(Ex103_ArraySearch_Object.randomString(10));
        bitree2.preOrder();
        System.out.println("最大值元素是 "+max(bitree2)+"，最小值元素是 "+min(bitree2));

        bitree2=new BinarySortTree<String>(Ex103_ArraySearch_Object.randomString(10));
        bitree2.inOrder();
        System.out.println("最大值元素是 "+max(bitree2)+"，最小值元素是 "+min(bitree2));*/
    }
}
/*
程序运行结果如下：
先根次序遍历二叉树：  49 29 71 23 95 99 55 65 30 70 
最大值元素是 99，最小值元素是 23
成绩统计：优秀2人，良好0人，中等2人，及格1人，不及格5人，
中根次序遍历二叉树：  12 24 29 53 63 69 82 91 96 
最大值元素是 96，最小值元素是 12
先根次序遍历二叉树：  O Q I G P I N K M U 
最大值元素是 U，最小值元素是 G
中根次序遍历二叉树：  H I J K L N P T W 
最大值元素是 W，最小值元素是 H


先根次序遍历二叉树：  79 82 63 75 80 95 55 71 90 65 
最大值元素是 95，最小值元素是 55
成绩统计：优秀2人，良好2人，中等3人，及格2人，不及格1人，

*/
