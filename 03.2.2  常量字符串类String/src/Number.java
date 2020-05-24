//����3.1�� ���������ʵ���ַ�����ʾ����ֵ��

public class Number 
{
    public static int parseInt(String s)                      //���������ַ���s��ʾ������ֵ
    {
        int x=0, i=0;
        int sign = s.charAt(0)=='-' ? -1 : 1;              //����λ����ס��������� 
        if (s.charAt(0)=='+' || s.charAt(0)=='-')          //��������λ
            i++;                                           //i��ס��ǰ�ַ����
        while (i<s.length()) 
            if (s.charAt(i)>='0' && s.charAt(i)<='9')
                x = x*10+s.charAt(i++)-'0';                //x��ס��ǰ��õ�����ֵ
            else
                throw new NumberFormatException(s);        //�׳���ֵ��ʽ�쳣
        return x*sign;                                     //��������ֵ�����������ַ�
    }

    public static double parseDouble(String s)                //����ʵ���ַ�����ʾ�ĸ�����ֵ 
    {
        int n=s.length(), i=0;
        int sign = s.charAt(0)=='-' ? -1 : 1;              //����λ����ס��������� 
        double x=0, power=10.0E0;                          //power��ʾ����Ϊ10����//�ܹ�����������������
        if (s.charAt(0)=='+' || s.charAt(0)=='-')          //��������λ
            i++;
        while (i<n && s.charAt(i)>='0' && s.charAt(i)<='9')//�����������ֵ
            x = x*10+s.charAt(i++)-'0';
        if (i<n && s.charAt(i)=='.')                       //����С����
        {
            i++;
            while (i<n && s.charAt(i)>='0' && s.charAt(i)<='9')//���С������ֵ
            {
                x += (s.charAt(i)-'0')/power;
                i++;
                power*=10;
            }
        }
        x *=sign;
        
        if (i<n && (s.charAt(i)=='E' || s.charAt(i)=='e'))  //�������
        {
            i++;
            power = (s.charAt(i)=='-') ? 0.1 :10;           //����ķ���λ����ָ����������������
            if (s.charAt(i)=='+' || s.charAt(i)=='-')
                i++;
            int exp=0;
            while (i<n && s.charAt(i)>='0' && s.charAt(i)<='9')
                exp = exp*10+s.charAt(i++)-'0';            //���ָ���ľ���ֵ
            for (int j=0; j<exp; j++)
                x*=power;
        }
        return x; 
    } 
    
    public static void main(String args[])
    {
        String s="-12345abc";
        System.out.println("parseInt(\""+s+"\")="+parseInt(s));
        s="-12345.67E-2";
        System.out.println("parseDouble(\""+s+"\")="+parseDouble(s));
    } 
}
/*
���������н�����£�
parseInt("12345")=12345
parseInt("-12345")=-12345
parseInt("-12345abc")=-12345
parseDouble("-12345.67")=-12345.67
parseDouble("-12345.67E-2")=-123.45670000000001
    
Exception in thread "main" java.lang.NumberFormatException: -12345abc
	at Number.toInt(Number.java:15)
	at Number.main(Number.java:58)
    
*/
/*
    //ϰ��3δ���
    public static int BinaryToInt(String s)      //���ض����������ַ���s��ʾ������ֵ
    public static int HexToInt(String s)         //����ʮ�����������ַ���s��ʾ������ֵ
    public static int toInt(String s, int radix) //����radix���������ַ���s��ʾ������ֵ

  
/*    //??δ��� toDouble("-12345.67E-2")=-12344.33
    public static double toDouble2(String s)               //����ʵ���ַ�����ʾ�ĸ�����ֵ 
    {
        double x=0;
        int i=s.indexOf(".");                              //Ѱ��С����
        if (i!=-1)                                         //û�ҵ�
            x=toInt(s.substring(0,i));                     //�����������ֵ
        else
            x=toInt(s);

        i=s.indexOf(".");                                  //Ѱ��С����
        int n=s.length();
        double power=10.0E0;                               //power��ʾ����Ϊ10����//�ܹ�����������������
        i++;                                               //����С����
        while (i<n && s.charAt(i)>='0' && s.charAt(i)<='9')  //���С������ֵ
        {
            x += (s.charAt(i)-'0')/power;
            System.out.println("x="+x);
            i++;
            power*=10;
        }
        if (i<n && (s.charAt(i)=='E' || s.charAt(i)=='e'))
        {
            i++;
            int exp=toInt(s.substring(i));                 //���ָ�����ֵ�����ֵ
            while (i<n && s.charAt(i)>='0' && s.charAt(i)<='9')
            {
                x += (s.charAt(i)-'0')/power;
                i++;
                power*=10;
            }
        }
        return x; 
    } */
