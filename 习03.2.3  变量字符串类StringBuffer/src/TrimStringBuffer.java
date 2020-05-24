//��ϰ3.7��  ɾ��StringBuffer�������пո�
//StringBuffer��û������trim()���� 

public class TrimStringBuffer
{
    //ɾ���ַ��������пո񣬵���ɾ���ַ��������ǿո��ַ���ǰ�ƶ���Σ�Ч�ʽϵ�
/*    public static void trim(StringBuffer str)
    {
        int i=0;
        while (i<str.length())
            if (str.charAt(i)==' ')
                str.delete(i, i+1);
            else
                i++;
    }*/
//���н��:	"abcdefghij"

    //ɾ���ַ��������пո񣬵���ɾ���ַ��������ǿո���ǰ�ַ��ƶ�һ�Σ�Ч�ʽϸߣ�O(n)
    public synchronized static void trim(StringBuffer str) 
    {
        int i=0, j=0;
        while (i<str.length() && str.charAt(i)!=' ')       //i��ס��1���ո��±�
            i++;
        for (j=i; j<str.length(); j++)
            if (str.charAt(j)!=' ')
                str.setCharAt(i++, str.charAt(j));         //�ǿո��ַ���ǰ�ƶ����ո��ַ�λ��
//        str.setLength(i);                                  //���ô�����Ϊi
    }
    
    public static void main(String args[])
    {
        StringBuffer str = new StringBuffer("   a bc d  e  f xyz");//"    a b c   def   g h i j   ");
        trim(str);
        System.out.println("\""+str+"\"");
    }
/*    
    //�����㷨�д�
    public static void trim(StringBuffer str)              //ɾ���ַ��������пո�
    {
        for (int i=0; i<str.length(); i++)
            if (str.charAt(i)==' ')
            	str.delete(i, i+1);
    }
//���н��:	"  abc def ghij "

/*    public static void trim(StringBuffer str)              //ɾ���ַ��������пո�
    {
        int i=0, n=str.length();
        while (i<n)
            if (str.charAt(i)==' ')
            	str.delete(i, i+1);
            else
            	i++;
    }*/
}
/*���н��:	
Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 10
at java.lang.StringBuffer.charAt(StringBuffer.java:162)
at TrimStringBuffer.trim(TrimStringBuffer.java:35)
at TrimStringBuffer.main(TrimStringBuffer.java:20)

*/

