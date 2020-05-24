//【习6.3】  求一棵BinaryTree<Integer>二叉树中各结点数值的平均值。

public class BinaryTree_average
{    
    //平均值
    private static int sum=0, count=0, max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
    public static double averageAll(BinaryTree<Integer> bitree) //返回所有元素的平均值
    {
        sumCount(bitree.root);                             //二叉树求和并计数，要求root权限必须是public
        if (count==0)
            return 0.0;
        return (double)sum/count;
    }
    //对以p结点为根的子二叉树求和并计数，递归方法，先根次序遍历
    private static void sumCount(BinaryNode<Integer> p)
    {
        if (p!=null)
        {
            sum += p.data.intValue();  
            count++;
            sumCount(p.left);
            sumCount(p.right); 
        }
    }
          
    //返回去掉最高分和最低分后的平均值
    public static double averageExceptMaxMin(BinaryTree<Integer> bitree)
    {
        sumCountMaxMin(bitree.root);                       //二叉树求和、计数、求最大值、最小值
        if (count==0)
            return 0.0;
        if (count==1 || count==2)
            return (double)sum/count;                      //返回所有元素的平均值
        return (double)(sum-max-min)/(count-2);            //返回去掉最高分和最低分后的平均值
    }
    //对以p结点为根的子二叉树求和、计数、求最大值、最小值，递归方法，先根次序遍历二叉树
    private static void sumCountMaxMin(BinaryNode<Integer> p)
    {
        if (p!=null) 
        {
            int value = p.data.intValue();
            sum += value; 
            if (value>max)
                max = value;
            if (value<min)
                min = value;
            count++;
            sumCountMaxMin(p.left); 
            sumCountMaxMin(p.right); 
        }
    }
    
    //分段统计元素个数
    public static int[] grade(Integer[] according, BinaryTree<Integer> bitree)
    {
    	int result[]= new int[according.length+1];
        grade(according, bitree.root, result);
        return result;
    }
    private static void grade(Integer[] according, BinaryNode<Integer> p, int result[])
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
        BinaryTree<Integer> bitree1=
            new CompleteBinaryTree<Integer>(Ex103_ArraySearch_Object.randomInteger(10,100));
                                              //以完全二叉树的层次序列构造完全二叉树
        bitree1.preOrder();
        System.out.println("所有元素的平均值是  "+String.format("%10.3f", averageAll(bitree1)));
        System.out.println("去掉最高分和最低分后的平均值是  "+String.format("%10.3f",averageExceptMaxMin(bitree1)));

        String str1[]={"优秀","良好","中等","及格","不及格"};
        Integer[] according1={90,80,70,60};
        int result1[]=grade(according1, bitree1);
        System.out.print("1班成绩统计：");
        for (int i=0; i<result1.length; i++)
            System.out.print(str1[i]+result1[i]+"人，");
        System.out.println();       

        BinaryTree<Integer> bitree2=new CompleteBinaryTree<Integer>(Ex103_ArraySearch_Object.randomInteger(10,150));
        bitree2.preOrder();
        System.out.println("所有元素的平均值是  "+String.format("%10.3f", averageAll(bitree2)));
        Integer[] according2={135,120,105,90};
        int result2[]=grade(according2, bitree2);
        System.out.print("2班成绩统计：");
        for (int i=0; i<result2.length; i++)
            System.out.print(str1[i]+result2[i]+"人，");
        System.out.println();

        System.out.print("两班成绩合计：");
        for (int i=0; i<result2.length; i++)
            System.out.print(str1[i]+(result1[i]+result2[i])+"人，");
        System.out.println();

        String str2[]={"及格","不及格"};
        Integer[] according3={90};
        int result3[]=grade(according3, bitree2);
        System.out.print("2班成绩统计：");
        for (int i=0; i<result3.length; i++)
            System.out.print(str2[i]+result3[i]+"人，");
        System.out.println();       
    }
}
/*
程序运行结果如下：
先根次序遍历二叉树：  93 13 18 3 81 76 42 44 82 66 
所有元素的平均值是      51.800
去掉最高分和最低分后的平均值是      52.222
1班成绩统计：优秀1人，良好2人，中等1人，及格1人，不及格5人，
先根次序遍历二叉树：  2 97 55 57 83 83 28 126 29 144 
所有元素的平均值是      58.000
2班成绩统计：优秀1人，良好1人，中等0人，及格1人，不及格7人，
两班成绩合计：优秀2人，良好3人，中等1人，及格2人，不及格12人，
2班成绩统计：及格3人，不及格7人，


*/
