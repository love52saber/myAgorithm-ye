//【习3.7】  删除StringBuffer串中所有空格。
//StringBuffer类没有声明trim()方法 

public class TrimStringBuffer
{
    //删除字符串中所有空格，调用删除字符方法，非空格字符向前移动多次，效率较低
/*    public static void trim(StringBuffer str)
    {
        int i=0;
        while (i<str.length())
            if (str.charAt(i)==' ')
                str.delete(i, i+1);
            else
                i++;
    }*/
//运行结果:	"abcdefghij"

    //删除字符串中所有空格，调用删除字符方法，非空格向前字符移动一次，效率较高，O(n)
    public synchronized static void trim(StringBuffer str) 
    {
        int i=0, j=0;
        while (i<str.length() && str.charAt(i)!=' ')       //i记住第1个空格下标
            i++;
        for (j=i; j<str.length(); j++)
            if (str.charAt(j)!=' ')
                str.setCharAt(i++, str.charAt(j));         //非空格字符向前移动到空格字符位置
//        str.setLength(i);                                  //设置串长度为i
    }
    
    public static void main(String args[])
    {
        StringBuffer str = new StringBuffer("   a bc d  e  f xyz");//"    a b c   def   g h i j   ");
        trim(str);
        System.out.println("\""+str+"\"");
    }
/*    
    //以下算法有错
    public static void trim(StringBuffer str)              //删除字符串中所有空格
    {
        for (int i=0; i<str.length(); i++)
            if (str.charAt(i)==' ')
            	str.delete(i, i+1);
    }
//运行结果:	"  abc def ghij "

/*    public static void trim(StringBuffer str)              //删除字符串中所有空格
    {
        int i=0, n=str.length();
        while (i<n)
            if (str.charAt(i)==' ')
            	str.delete(i, i+1);
            else
            	i++;
    }*/
}
/*运行结果:	
Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 10
at java.lang.StringBuffer.charAt(StringBuffer.java:162)
at TrimStringBuffer.trim(TrimStringBuffer.java:35)
at TrimStringBuffer.main(TrimStringBuffer.java:20)

*/

