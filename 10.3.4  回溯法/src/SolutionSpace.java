//���ݷ��Ľ�ռ�
public class SolutionSpace 
{
    static int count=0;
    static int x[]; 
	public static void enumerate(int n)                   //��ٷ��������ѡ��
	{
    	x=new int[n];
    	enumerate(0, n);                   //��ٷ��������ѡ��ݹ����
        System.out.println(count+"��ѡ��\n");
	}
	public static void enumerate(int i, int n)                   //��ٷ��������ѡ��ݹ����
    {
        if (i<n)
            for (int j=0; j<=1; j++)
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
    public static void print(int x[])                            //���һά���飬�������һ����
    {
        System.out.print("("+x[0]);
        for (int i=1; i<x.length; i++)
            System.out.print(","+x[i]);
        System.out.println(")");
    }
    public static void main(String args[]) 
    {
        enumerate(3);
    }
} 
/*
    enumerate(3);
(0,0,0)
(0,0,1)
(0,1,0)
(0,1,1)
(1,0,0)
(1,0,1)
(1,1,0)
(1,1,1)
8��ѡ��

   enumerate(4);
(0,0,0,0)
(0,0,0,1)
(0,0,1,0)
(0,0,1,1)
(0,1,0,0)
(0,1,0,1)
(0,1,1,0)
(0,1,1,1)
(1,0,0,0)
(1,0,0,1)
(1,0,1,0)
(1,0,1,1)
(1,1,0,0)
(1,1,0,1)
(1,1,1,0)
(1,1,1,1)
16��ѡ��


*/
