public class Dig9_r
{
    static void count(int i,int n)               //�ݹ鷽��
    {
        if(i<n)
        {
            System.out.print(i+"  ");
            count(i+1,n);
        }
        System.out.print(i+"  ");
    }
    public static void main(String args[])
    {
       int i,j,n=9;
       for(i=1;i<=n;i++)
       {
           for(j=n;j>i;j--)
                System.out.print("   ");         //ǰ���ո�
           count(1,i);
           System.out.println();
       }
    }
}