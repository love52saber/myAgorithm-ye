//【习2.17】  采用二维数组输出数字方阵。
/*
输出下列方阵（当n=4时）：
   1   3   6  10
   2   5   9  13
   4   8  12  15
   7  11  14  16
或
   1   2   4   7
   3   5   8  11
   6   9  12  14
  10  13  15  16
*/

//算法：二维数组中，每一条斜线上各元素下标和相等

public class Upmat
{
    public static void main(String args[]) 
    {
        int n=4;                                 //阶数
       
        int[][] mat = new int[n][n];
        int k=1;                                 //k是自然数，递增变化
        boolean up = true;                       //方向向上

        for (int sum=0;sum<n;sum++)              //左上三角，sum表示行列的下标和
        {
            if (up)
                for (int i=sum;i>=0;i--)
                    mat[i][sum-i] = k++;         //k先赋值后自加
            else
                for (int i=0;i<=sum;i++)
                    mat[i][sum-i] = k++;
            up=!up;                              //方向求反
        }

        for (int sum=n;sum<2*n-1;sum++)          //右下三角
        {
            if (up)
                for (int j=sum-n+1;j<n;j++)
                    mat[sum-j][j] = k++;
            else
                for (int j=n-1;j>sum-n;j--)
                    mat[sum-j][j] = k++;
            up=!up;
        }

        for (int i=0;i<mat.length;i++)           //输出二维数组元素
        {
            for (int j=0;j<mat[i].length;j++)    //i、j是行、列下标
                System.out.print("  "+mat[i][j]);
            System.out.println();
        }
    }
}
/*
程序运行结果如下：
n=4
   1   2   4   7
   3   5   8  11
   6   9  12  14
  10  13  15  16

当初值up=false时，程序运行结果如下：
   1   3   6  10
   2   5   9  13
   4   8  12  15
   7  11  14  16

*/

