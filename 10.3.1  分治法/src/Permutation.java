//��ϰ2.24��  �õݹ鷽����n���������ظ�ȫ���С�

public class Permutation
{
    private int[] table;
    
    public Permutation(int n)                    //���췽��
    {
        if (n>0)
        {
            table = new int[n];
            for (int i=0;i<n;i++)
                table[i] = i+1;
            permute(n);
        }
        else
            table = null;
    }

    private void output()                        //�������Ԫ��
    {
        for (int i=0;i<table.length;i++)
            System.out.print("  "+table[i]);
        System.out.println();
    }

    private void swap(int i,int j)               //������������Ԫ��ֵ
    {
        if (table!=null && i>=0 && i<table.length && j>=0 && j<table.length)
        {
            int temp = table[i];
            table[i] = table[j];
            table[j] = temp;
        }
    }

    private void permute(int n)                   //�õݹ鷽����n���������ظ�ȫ����
    {
        if (n==1)
            this.output();
        else
        {
            permute(n-1);
            for (int j=0;j<n-1;j++)
            {
                swap(n-1,j);
                permute(n-1);
                swap(n-1,j);
            }
        }        
    }
    
    public static void main(String args[]) 
    {
        new Permutation(3);
    }
}

/*
�������н�����£�
  1

  1  2
  2  1

  1  2  3
  2  1  3
  3  2  1
  2  3  1
  1  3  2
  3  1  2

*/

