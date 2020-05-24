//��ϰ2.24��  �û��ݷ����ݹ鷽������n���������ظ�ȫ���С�n!����

public class Permutation_backtrack
{
    private int[] x;                                //����һ����
    private int count=0;                                   //�����
    
    public Permutation_backtrack(int n)                    //���췽��
    {
        x = new int[n];
        enumerate(0, n);                         //��ٷ����1��n���������У����ظ������ݹ����
//        permute(0,n);
        System.out.println(count+"��ѡ��\n");
    }
    
    //��ٷ����1��n���������У����ظ������ݹ����
    private void enumerate(int i, int n)
    {
        if (i<n)
            for (int j=1; j<=n; j++)
            {
        	    x[i]=j;
                enumerate(i+1, n);
            }
        else                                               //i==n������Ҷ�ӽ�㣬���һ��nԪ��
        {
            count++;                                       //����
            print(x);                                      //���һ���⣬���һά����x��������ʡ��
        }
    }

    //��ٷ����1��n�����ظ�ȫ���У��ݹ����??
    private void permute(int i, int n)
    {
        if (i<n)
        {
        	int j=i+1;
        	for (int k=0; k<n-i; k++)
            {
        	    x[i]=j;
        	    permute(i+1, n);
            }
        }
        else                                               //i==n������Ҷ�ӽ�㣬���һ��nԪ��
        {
            count++;                                       //����
            print(x);                                      //���һ���⣬���һά����x��������ʡ��
        }
    }

    private void print(int x[])                            //���һ����
    {
        System.out.print("("+x[0]);
        for (int i=1; i<x.length; i++)
            System.out.print(","+x[i]);
        System.out.println(") ");
    }
    
    public static void main(String args[]) 
    {
        new Permutation_backtrack(3);
    }
}

/*
�������н�����£�
(1,1,1)
(1,1,2)
(1,1,3)
(1,2,1)
(1,2,2)
(1,2,3)
(1,3,1)
(1,3,2)
(1,3,3)
(2,1,1)
(2,1,2)
(2,1,3)
(2,2,1)
(2,2,2)
(2,2,3)
(2,3,1)
(2,3,2)
(2,3,3)
(3,1,1)
(3,1,2)
(3,1,3)
(3,2,1)
(3,2,2)
(3,2,3)
(3,3,1)
(3,3,2)
(3,3,3)
27��ѡ��

  1

  1  2
  2  1

  1  2  3
  2  1  3
  3  2  1
  2  3  1
  1  3  2
  3  1  2

        enumerate(0, n);
(1,1,1)
(1,1,2)
(1,1,3)
(1,2,1)
(1,2,2)
(1,2,3)
(1,3,1)
(1,3,2)
(1,3,3)
(2,1,1)
(2,1,2)
(2,1,3)
(2,2,1)
(2,2,2)
(2,2,3)
(2,3,1)
(2,3,2)
(2,3,3)
(3,1,1)
(3,1,2)
(3,1,3)
(3,2,1)
(3,2,2)
(3,2,3)
(3,3,1)
(3,3,2)
(3,3,3)
27��ѡ��


*/

/*
private void swap(int i,int j)               //������������Ԫ��ֵ
{
    if (x!=null && i>=0 && i<x.length && j>=0 && j<x.length)
    {
        int temp = x[i];
        x[i] = x[j];
        x[j] = temp;
    }
}*/
