//MyStringBuffer串实现逆转。

public class StringBuffer_reverse 
{
    public static void main(String args[])
    {
//        StringBuffer str = "abcdefghij";                      编译错
        StringBuffer str = new StringBuffer("abcdefghij");
        System.out.println("\""+str+"\".reverse()=\""+str.reverse()+"\"，str=\""+str+"\"");
        MyStringBuffer mystr = new MyStringBuffer("abcdefghij");
        System.out.println("\""+mystr+"\".reverse()=\""+mystr.reverse()+"\"，str=\""+mystr+"\"");
    }
}
/*
程序运行结果如下：
"abcdefghij".reverse()="jihgfedcba"，str="jihgfedcba"
"abcdefghij".reverse()="jihgfedcba"，str="jihgfedcba"


*/
