//��ϰ3.6�� StringBuffer������ĸ��Сдת����
//StringBuffer��û���������·��� 

public class letterCase 
{
    //��str���еĴ�д��ĸȫ��ת���ɶ�Ӧ��Сд��ĸ������
    public synchronized static StringBuffer toLowerCase(StringBuffer str)
    {
        for (int i=0; i<str.length(); i++)
            if (str.charAt(i)>='A' && str.charAt(i)<='Z')                  //��д��ĸ
                str.setCharAt(i, (char)(str.charAt(i)+'a'-'A'));           //ת����Сд��ĸ
        return str;
    }
    
    //��str���е�Сд��ĸȫ��ת���ɶ�Ӧ�Ĵ�д��ĸ������
    public synchronized static StringBuffer toUpperCase(StringBuffer str)
    {
        for (int i=0; i<str.length(); i++)
            if (str.charAt(i)>='a' && str.charAt(i)<='z')                  //Сд��ĸ
                str.setCharAt(i, (char)(str.charAt(i)-'a'+'A'));           //ת���ɴ�д��ĸ
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
�������н�����£�
toUpperCase("abcdefghij")=ABCDEFGHIJ
toLowerCase("ABCDEFGHIJ")=abcdefghij
*/
