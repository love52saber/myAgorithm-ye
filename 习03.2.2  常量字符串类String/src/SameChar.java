//【习3.2】 查找两个字符串中所有相同字符（不重复）。

public class SameChar
{
    public static String getSameChars(String astr, String bstr)  //查找两个字符串中所有相同字符（不重复）
    {
        String result = "";
        for (int i=0; i<astr.length(); i++)
            if (bstr.indexOf(astr.charAt(i))>=0 && result.indexOf(astr.charAt(i))<0)
                result += astr.charAt(i);
        return result;
    }    

    public static void main(String args[]) 
    {
        String astr = "integer", bstr = "string";
        System.out.println("Two strings: "+astr+"，  "+bstr);
        System.out.println("SameChars: "+getSameChars(astr, bstr));
    }
}

/*
程序运行结果如下：
Two strings: integer，  string
SameChars: intgr

*/
