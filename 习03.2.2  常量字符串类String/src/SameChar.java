//��ϰ3.2�� ���������ַ�����������ͬ�ַ������ظ�����

public class SameChar
{
    public static String getSameChars(String astr, String bstr)  //���������ַ�����������ͬ�ַ������ظ���
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
        System.out.println("Two strings: "+astr+"��  "+bstr);
        System.out.println("SameChars: "+getSameChars(astr, bstr));
    }
}

/*
�������н�����£�
Two strings: integer��  string
SameChars: intgr

*/
