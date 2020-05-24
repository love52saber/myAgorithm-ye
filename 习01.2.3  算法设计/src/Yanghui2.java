//����2.15�� ������ǡ�

public class Yanghui2
{
    public static int[][] yanghui(final int n)         //��n��������ǣ����ض�ά����
    {
        int mat[][] = new int [n][];             //�����һά�Ĵ洢�ռ�        
        for (int i=0; i<n; i++)
        {
            mat[i]= new int [i+1];               //����ڶ�ά�Ĵ洢�ռ䣬ÿ�γ��Ȳ�ͬ
            mat[i][0]=mat[i][i]=1;
            for (int j=1; j<i; j++)        
                mat[i][j]=mat[i-1][j-1]+mat[i-1][j];
        }
        return mat;                        
    }
    
    public static void print(final int table[][])      //�����ά����
    {
    	int n=table.length;
//        table[0][0]=0;                             //??���Ըģ�final�������ܸģ�����ģ�ʲô����??
        for (int i=0; i<n; i++)
        {
            System.out.print(String.format("%"+(n-i+1)*2+"c",' '));
        	for (int j=0; j<table[i].length; j++)
//            	System.out.print(" "+table[i][j]);
            	System.out.print(String.format("%4d",table[i][j]));
            System.out.println();
        }
    }
    
    public static void main(String args[])
    {
        print(yanghui(10));
    }
}

/*
�������н�����£�
   1
   1   1
   1   2   1
   1   3   3   1
   1   4   6   4   1
   1   5  10  10   5   1
   1   6  15  20  15   6   1
   1   7  21  35  35  21   7   1
   1   8  28  56  70  56  28   8   1
   1   9  36  84 126 126  84  36   9   1

                         1
                       1   1
                     1   2   1
                   1   3   3   1
                 1   4   6   4   1
               1   5  10  10   5   1
             1   6  15  20  15   6   1
           1   7  21  35  35  21   7   1
         1   8  28  56  70  56  28   8   1
       1   9  36  84 126 126  84  36   9   1


*/