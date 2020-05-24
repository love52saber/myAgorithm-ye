//����4.5��  ��n����

public class Factorial
{
    public static int factorial(int n)                    //��׳�n!���ݹ鷽��
    {
        if (n<0)
            throw new java.lang.IllegalArgumentException("n="+n); //�׳���Ч�����쳣
        if (n==0 || n==1)
            return 1;
        return n*factorial(n-1);
    }

    public static void main(String args[])
    {
        int n=5;
        System.out.println(n+"!="+factorial(n));           //5!=120
        
        //ϰ��4
        System.out.println(n+"!="+toString(n)+factorial(n));
    }
    
    //ϰ��4
    public static String toString(int n)                   //��׳�n!
    {
        if (n>=0)
        	return toString(n, "");
        throw new java.lang.IllegalArgumentException("n="+n); //�׳���Ч�����쳣
    }
    private static String toString(int n, String str)      //��׳�n!���ݹ鷽��
    {
        if (n==0 || n==1)
            return "";
        else
        {
            str += n+"*"+(n-1)+"!="+toString(n-1, str);
            return str;
        }
    }
}
/*
�������н�����£�
5!=120      
5!=5*4*3*2*1=120
*/

/*
public static int factorial(int n, StringBuffer str)                //��׳ˣ��ݹ鷽��
{
    str=new StringBuffer();
	if (n<0)
        throw new NumberFormatException("n<0ʱn!�޶���");
}
public static int factorial(int n, StringBuffer str)                //��׳ˣ��ݹ鷽��
{
//    System.out.print(n);
    if (n==0 || n==1)
    {
        str
        return 1;
    }
    else
    {
//        System.out.println(n+"!="+n+"*"+(n-1)+"!");
//        System.out.print("*");
        return n*factorial(n-1);
    }
}

5!=5*4!
4!=4*3!
3!=3*2!
2!=2*1!
5!=120     */
