//��ϰ2.17��  ���ö�ά����������ַ���
/*
������з��󣨵�n=4ʱ����
   1   3   6  10
   2   5   9  13
   4   8  12  15
   7  11  14  16
��
   1   2   4   7
   3   5   8  11
   6   9  12  14
  10  13  15  16
*/

//�㷨����ά�����У�ÿһ��б���ϸ�Ԫ���±�����

public class Upmat
{
    public static void main(String args[]) 
    {
        int n=4;                                 //����
       
        int[][] mat = new int[n][n];
        int k=1;                                 //k����Ȼ���������仯
        boolean up = true;                       //��������

        for (int sum=0;sum<n;sum++)              //�������ǣ�sum��ʾ���е��±��
        {
            if (up)
                for (int i=sum;i>=0;i--)
                    mat[i][sum-i] = k++;         //k�ȸ�ֵ���Լ�
            else
                for (int i=0;i<=sum;i++)
                    mat[i][sum-i] = k++;
            up=!up;                              //������
        }

        for (int sum=n;sum<2*n-1;sum++)          //��������
        {
            if (up)
                for (int j=sum-n+1;j<n;j++)
                    mat[sum-j][j] = k++;
            else
                for (int j=n-1;j>sum-n;j--)
                    mat[sum-j][j] = k++;
            up=!up;
        }

        for (int i=0;i<mat.length;i++)           //�����ά����Ԫ��
        {
            for (int j=0;j<mat[i].length;j++)    //i��j���С����±�
                System.out.print("  "+mat[i][j]);
            System.out.println();
        }
    }
}
/*
�������н�����£�
n=4
   1   2   4   7
   3   5   8  11
   6   9  12  14
  10  13  15  16

����ֵup=falseʱ���������н�����£�
   1   3   6  10
   2   5   9  13
   4   8  12  15
   7  11  14  16

*/

