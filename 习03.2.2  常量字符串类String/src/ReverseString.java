//【习3.4】  逆转String串。

public class ReverseString
{
    public static String reverse(String str)     //返回str逆转后的串对象，算法基于求子串和串连接
    {
        String temp = "";
        for (int i=str.length()-1; i>=0; i--)
            temp += str.substring(i,i+1);        //连接单字符子串
        return temp;
    }   
    public static void main(String args[])
    {
//        String str = "abcdefghijklmnopqrstuvwxyz";
        String str = "abcdefghij";
        System.out.println("reverse(\""+str+"\")=\""+reverse(str)+"\"");
    }
}

/*
程序运行结果如下：
reverse("abcdefghijklmnopqrstuvwxyz")="zyxwvutsrqponmlkjihgfedcba"
reverse("abcdefghij")="jihgfedcba"

*/
