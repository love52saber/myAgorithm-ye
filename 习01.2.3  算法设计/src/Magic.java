//【例2.11】  显示幻方阵。

public class Magic
{
    public static void main(String args[])
    {
        int n=5;                          //阶数
        int mat[][] = new int [n][n];
        int i=0, j=n/2;                   //i,j用做下标，第1个数放在第1行中间位置
        for (int k=1; k<=n*n; k++)        //k是自然数
        {
            mat[i][j]=k;                  //当前位置取值
            if (k % n == 0)               //对角线已满
                i = (i+1) % n ;           //下一位置向下一行
            else
            {
                i = (i-1+n) % n ;         //下一位置向右上方
                j = (j+1) % n;
            }
        }
        
        System.out.println("n="+n);
        for (i=0; i<mat.length; i++)      //输出二维数组 
        {
            for (j=0;j<mat[i].length;j++)
//            	System.out.print(mat[i][j]+" ");
            	System.out.print(String.format("%4d", mat[i][j]));
            System.out.println();
        }
    }
}

/*
程序运行结果如下：
n=3
8   1   6
3   5   7
4   9   2

5阶幻方阵
n=5
  17  24   1   8  15
  23   5   7  14  16
   4   6  13  20  22
  10  12  19  21   3
  11  18  25   2   9
*/
/*
标准幻方 和是34，不对
n=4
   9  15   1   7
  14   4   6  12
   3   5  11  13            //不对，和是32
   8  10  16   2            //不对，和是36

*/

/*
//二维数组测试。

public class Array2
{
    public static void main(String args[])
    {
        int mat[][] = { {1,2,3},{4,5,6} };
        
        for (int i=0;i<mat.length;i++)        //输出二维数组 
        {
            for (int j=0;j<mat[i].length;j++)
                System.out.print(mat[i][j]+"\t");
            System.out.println();
        }
    }
}

/*

程序运行结果如下：
1	2	3
4	5   6

*/

/*
编译错误：
        int mat[2][3] = { {1,2,3},{4,5,6} };
        int mat[2][3] = { 1,2,3,4,5,6 };
        int mat[][] = { 1,2,3,4,5,6 };


*/

