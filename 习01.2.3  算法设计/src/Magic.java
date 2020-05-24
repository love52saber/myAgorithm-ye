//����2.11��  ��ʾ�÷���

public class Magic
{
    public static void main(String args[])
    {
        int n=5;                          //����
        int mat[][] = new int [n][n];
        int i=0, j=n/2;                   //i,j�����±꣬��1�������ڵ�1���м�λ��
        for (int k=1; k<=n*n; k++)        //k����Ȼ��
        {
            mat[i][j]=k;                  //��ǰλ��ȡֵ
            if (k % n == 0)               //�Խ�������
                i = (i+1) % n ;           //��һλ������һ��
            else
            {
                i = (i-1+n) % n ;         //��һλ�������Ϸ�
                j = (j+1) % n;
            }
        }
        
        System.out.println("n="+n);
        for (i=0; i<mat.length; i++)      //�����ά���� 
        {
            for (j=0;j<mat[i].length;j++)
//            	System.out.print(mat[i][j]+" ");
            	System.out.print(String.format("%4d", mat[i][j]));
            System.out.println();
        }
    }
}

/*
�������н�����£�
n=3
8   1   6
3   5   7
4   9   2

5�׻÷���
n=5
  17  24   1   8  15
  23   5   7  14  16
   4   6  13  20  22
  10  12  19  21   3
  11  18  25   2   9
*/
/*
��׼�÷� ����34������
n=4
   9  15   1   7
  14   4   6  12
   3   5  11  13            //���ԣ�����32
   8  10  16   2            //���ԣ�����36

*/

/*
//��ά������ԡ�

public class Array2
{
    public static void main(String args[])
    {
        int mat[][] = { {1,2,3},{4,5,6} };
        
        for (int i=0;i<mat.length;i++)        //�����ά���� 
        {
            for (int j=0;j<mat[i].length;j++)
                System.out.print(mat[i][j]+"\t");
            System.out.println();
        }
    }
}

/*

�������н�����£�
1	2	3
4	5   6

*/

/*
�������
        int mat[2][3] = { {1,2,3},{4,5,6} };
        int mat[2][3] = { 1,2,3,4,5,6 };
        int mat[][] = { 1,2,3,4,5,6 };


*/

