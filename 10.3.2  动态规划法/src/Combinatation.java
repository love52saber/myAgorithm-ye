//��10.2  ��̬�滮�����������

public class Combinatation
{
    public static int combine(int m, int n)      //���������Cmn�����β��Եݹ��㷨
    {
        if (n==0 || m==n)
            return 1;
        return combine(m-1, n-1) + combine(m-1, n);
    }

    public static int combinate(int m, int n)    //���������Cmn����̬�滮�������������εĶ�ά����
    {
        if (n==0 || m==n)
            return 1;
        int mat[][] = new int[m][]; 
        for (int i=0; i<m; i++)
        {
            mat[i] = new int[i+2]; 
            mat[i][0]=1;
            mat[i][i+1]=1;
            for (int j=1; j<=i; j++)
                mat[i][j] = mat[i-1][j-1]+mat[i-1][j];
            for (int j=0; j<=i+1; j++)
                System.out.print(String.format("%4d", mat[i][j]));
            System.out.println();
        }
        return mat[m-1][n];
    }

    public static int combination(int m, int n)  //���������Cmn����̬�滮��������һά����
    {
        if (n==0 || m==n)
            return 1;
        int table[] = new int[m+1], i;
        for (i=0; i<=m; i++)                     //��ʼ��
            table[i]=1;
        for (i=0; i<m; i++)
        {
            for (int j=i; j>0; j--)              //������һ������
                table[j] = table[j-1]+table[j];  //ͨʽ
            for (int j=0; j<=i+1; j++)
                System.out.print(String.format("%4d", table[j]));
            System.out.println();
        }
        return table[n];                         //����Cmn 
    }
    
    public static void main(String args[]) 
    {
        int m=5, n=2;
//        System.out.println("combine("+m+","+n+")="+combine(m,n));      //���β��Եݹ��㷨
//        System.out.println("combinate("+m+","+n+")="+combinate(m,n));    //��̬�滮�������������εĶ�ά����
//        System.out.println("combination("+m+","+n+")="+combination(m,n));//��̬�滮��������һά����

        //combinat(m, n);                          //���Cmn ���
        enumerate(m, n);
    }
/*
�������н�����£�
//���β��Եݹ��㷨
combine(5,1)=5
combine(5,2)=10
combine(5,3)=10

//��̬�滮�������������εĶ�ά���飬����һά����
   1   1
   1   2   1
   1   3   3   1
   1   4   6   4   1
   1   5  10  10   5   1
combinate(5,1)=5
combinate(5,2)=10
combinate(5,3)=10

*/

    static void combinat(int m, int n)                     //���Cmn��ϣ�ѭ��
    {
        if (n==0)
        {
            System.out.println("{}");
            return;
        }
        for (int i=1; i<m; i++)
        {
            for (int j=i; j<m; j++)
            {
                System.out.print("{"+i);
                for (int k=j+1; k<j+n; k++)
                    System.out.print(","+k);
                System.out.print("} ");
            }
            System.out.println();
        }
    }
/*
{1,2} {1,3} {1,4} {1,5} 
{2,3} {2,4} {2,5}
{3,4} {3,5} 
{4,5}
  */
    static int count=0;
    static int x[]; 
	public static void enumerate(int m, int n)                   //��ٷ��������ѡ��
	{
    	x=new int[n];
    	enumerate(0, m, n);                   //��ٷ��������ѡ��ݹ����
        System.out.println(count+"��ѡ��\n");
	}
	public static void enumerate(int i, int m, int n)                   //��ٷ��������ѡ��ݹ����
    {
        if (i<n)
            for (int j=0; j<=1; j++)
            {
                if (restrict(i,m))
        	    {
                    x[i]=j;
                    enumerate(i+1, n);
                }
            }
        else                                               //i==n������Ҷ�ӽ�㣬���һ��nԪ��
        {
            count++;                                       //����
            print(x);                                      //���һ���⣬���һά����x��������ʡ��
        }
    }
	public static boolean restrict(int i, int m)    //Լ������
	{
        int sum=0;
		for (int j=0; j<i; j++)
	        sum+=x[j];
		return sum<m;
	}
    public static void print(int x[])                            //���һά���飬�������һ����
    {
        System.out.print("("+x[0]);
        for (int i=1; i<x.length; i++)
            System.out.print(","+x[i]);
        System.out.println(")");
    }
}

