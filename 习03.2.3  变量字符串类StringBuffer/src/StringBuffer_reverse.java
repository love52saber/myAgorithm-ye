//MyStringBuffer��ʵ����ת��

public class StringBuffer_reverse 
{
    public static void main(String args[])
    {
//        StringBuffer str = "abcdefghij";                      �����
        StringBuffer str = new StringBuffer("abcdefghij");
        System.out.println("\""+str+"\".reverse()=\""+str.reverse()+"\"��str=\""+str+"\"");
        MyStringBuffer mystr = new MyStringBuffer("abcdefghij");
        System.out.println("\""+mystr+"\".reverse()=\""+mystr.reverse()+"\"��str=\""+mystr+"\"");
    }
}
/*
�������н�����£�
"abcdefghij".reverse()="jihgfedcba"��str="jihgfedcba"
"abcdefghij".reverse()="jihgfedcba"��str="jihgfedcba"


*/
