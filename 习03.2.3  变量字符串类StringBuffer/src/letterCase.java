//【习3.6】 StringBuffer串中字母大小写转换。
//StringBuffer类没有声明以下方法 

public class letterCase 
{
    //将str串中的大写字母全部转换成对应的小写字母并返回
    public synchronized static StringBuffer toLowerCase(StringBuffer str)
    {
        for (int i=0; i<str.length(); i++)
            if (str.charAt(i)>='A' && str.charAt(i)<='Z')                  //大写字母
                str.setCharAt(i, (char)(str.charAt(i)+'a'-'A'));           //转换成小写字母
        return str;
    }
    
    //将str串中的小写字母全部转换成对应的大写字母并返回
    public synchronized static StringBuffer toUpperCase(StringBuffer str)
    {
        for (int i=0; i<str.length(); i++)
            if (str.charAt(i)>='a' && str.charAt(i)<='z')                  //小写字母
                str.setCharAt(i, (char)(str.charAt(i)-'a'+'A'));           //转换成大写字母
        return str;
    }

    public static void main(String args[])
    {
        StringBuffer str = new StringBuffer("abcdefghij");
        System.out.println("toUpperCase(\""+str+"\""+")="+toUpperCase(str));
        System.out.println("toLowerCase(\""+str+"\""+")="+toLowerCase(str));
    }
}
/*
程序运行结果如下：
toUpperCase("abcdefghij")=ABCDEFGHIJ
toLowerCase("ABCDEFGHIJ")=abcdefghij
*/
