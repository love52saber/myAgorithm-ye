//【习3.3】  识别标识符。

public class Identifier
{
    public static boolean isLetter(char ch)                //判断指定字符是否为字母
    {
        return ch>='A' && ch<='Z' || ch>='a' && ch<='z';
    }
	
    public static boolean isIdentifier(String str)         //判断指定字符串是否为标识符
    {
        char ch = str.charAt(0);                           //首字符。若str串长度为0，将抛出序号越界异常
//      if (ch>='A' && ch<='Z' || ch>='a' && ch<='z' || ch=='_' || ch=='$') //字母开头
        if (isLetter(ch) || ch=='_' || ch=='$')            //字母开头
        {
            for (int i=1; i<str.length(); i++)
            {
                ch = str.charAt(i);
//              if (!(ch>='A' && ch<='Z' || ch>='a' && ch<='z' || ch=='_' || ch=='$' || ch>='0' && ch<='9'))
                if (!(isLetter(ch) || ch=='_' || ch=='$' || ch>='0' && ch<='9'))
                    return false;
            }
            return true;
        }
        return false;
    }

    public static String[] toIdentifier(String str)        //识别出指定字符串str中的所有标识符
    {
        int len=20;
        String[] ids = new String[len];
        int i=0, j=0;
        while (i<str.length())
        {
            char ch = str.charAt(i);
            if (ch>='A' && ch<='Z' || ch>='a' && ch<='z' || ch=='_' || ch=='$')  //字母开头
            {
                ids[j]="";
                do{
                    ids[j] += ch;                          //字符串与字符连接，自动将字符转换成字符串
                    i++;
                    if (i<str.length())
                         ch = str.charAt(i);
                } while (i<str.length() && (ch>='A' && ch<='Z' || ch>='a' && ch<='z' || ch=='_' || ch=='$' || ch>='0' && ch<='9'));
                j++;
            }
            else i++;
        }
        String[] dest=new String[j];
        System.arraycopy(ids,0,dest,0,j);                  //复制ids数组前j个元素到dest
        return dest;
    }
    
    public static void main(String args[]) 
    {
        String str = "$_name1";                            //判断标识符
        System.out.println("\""+str+"\" isIdentifier? "+isIdentifier(str));
        
        str="10+a1+b+c*(d-2)";                             //识别标识符
        System.out.print("\""+str+"\"toIdentifier：");
        String[] ids=toIdentifier(str);
        for (int i=0; i<ids.length; i++)
            System.out.print(ids[i]+"， ");
        System.out.println();

        //习题4
        str = "_name1";                                    //判断标识符
        System.out.println("\""+str+"\" identifier? "+identifier(str));
    }

    //习题4
    public static boolean identifier(String str)           //判断指定字符串是否为标识符，递归算法
    {
        char ch = str.charAt(0);                           //首字符
        if (ch>='A' && ch<='Z' || ch>='a' && ch<='z' || ch=='_' || ch=='$') //字母开头
            return identifier(str, 1);
        return false;
    }

    private static boolean identifier(String str, int i)   //判断指定字符串是否为标识符，递归算法
    {
        if (i<str.length())                                //序号字符串
        {
            char ch = str.charAt(i);
            return (ch>='A' && ch<='Z' || ch>='a' && ch<='z' || ch=='_' || ch=='$' || ch>='0' && ch<='9')
                && identifier(str, i+1);                   //递归调用
        }
        return true;
    }
}
/*
程序运行结果如下：
"$_name1" isIdentifier? true
"10+a1+b+c*(d-2)"toIdentifier：a1， b， c， d， 
"_name1" identifier? true
*/

