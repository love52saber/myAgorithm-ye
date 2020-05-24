//����3.2�����һ���������Ķ����ƻ�ʮ��������ʽ�ַ�����

public class Int
{
/*    public static String toBinaryString(int n)             //����int�����Ķ������ַ�������2ȡ�෨
    {
        String str="";
        for (int i=0x80000000; i!=0; i>>>=1)               //һ��intռ32λ������һλ����λ��0���
            str += (n & i)==0 ? '0': '1';
        return str;                                        //�����ַ���
    }*/

    public static String toHexString(int n)                //����������n��ʮ�������ַ���
    {
        String str="";
        while (n>0)                                        //��16ȡ�෨����������str�ַ���
        {
            int k = n % 16;
            str = (char)(k<=9 ? k+'0' : k+'A'-10) + str;   //��0��9��10��15ת��Ϊ'0'��'9'��'A'��'F'
            n /= 16;
        }
        return str;
    }
  
    public static String toString(int n, int radix)        //����������n��radix�����ַ�����radixȡֵΪ2��8��16
    {
        String str="";
        while (n>0)                                        //��radixȡ�෨����������str�ַ���
        {
            int k = n % radix;
            str = (char)(k<=9 ? k+'0' : k+'A'-10) + str; 
            n /= radix;
        }
        return str;
    }

    //��4��ϰ��,���µݹ��㷨
    public static void binary(int n)                       //���������n�Ķ������ַ������ݹ��㷨
    {
        if (n==0)
             return;
        binary(n/2);
        System.out.print((char)(n%2+'0')); 
    }
    
    public static void hex(int n)                          //���������n��ʮ�������ַ������ݹ��㷨
    {
        if (n==0)
        	return;
        hex(n/16);
        n %= 16;
        System.out.print((char)(n<=9 ? n+'0' : n+'A'-10)); 
    }
    
    public static String toBinary(int n)                   //����������n�Ķ������ַ������ݹ��㷨
    {
        if (n>0)
            return toBinary(n/2)+(char)(n%2+'0'); 
        return "";
    }
    
    public static String toHex(int n)                      //����������n��ʮ�������ַ������ݹ��㷨
    {
        int k= n % 16;
        if (n>0)
            return toHex(n/16)+(char)(k<=9 ? k+'0' : k+'A'-10); 
        return "";
    }
    
    public static void main(String args[])
    {
        byte n=-126;
//        int n=254;
        System.out.println("Integer.toBinaryString("+n+")="+Integer.toBinaryString(n));
        System.out.println("toBinaryString("+n+")="+Int.toBinaryString(n));
        System.out.println("toHexString("+n+")="+Int.toHexString(n));     
        System.out.println("toString("+n+",8)="+Int.toString(n,8));     

        //��4��ϰ��,���µݹ��㷨
        System.out.print("binary("+n+")=");
        Int.binary(n);
        System.out.print("\nhex("+n+")=");
        Int.hex(n);

        System.out.println("\ntoBinary("+n+")="+Int.toBinary(n));
        System.out.println("toHex("+n+")="+Int.toHex(n));     

        n=-1;
        System.out.println("toBinaryString("+n+")="+Int.toBinaryString(n));
    }
    
/*    //�㷨�д�
    public static String toBinaryString(int n)             //����������n�Ķ������ַ���
    {
        String str="";
        while (n>0)                                        //��2ȡ�෨����������str�ַ���
        {
            str = (char)(n%2 +'0') +str;
            n /= 2;
        }
        return str;     
    }*/
//    n=-1ʱ��n%2���Ϊ-1��(char)(n%2 +'0')���Ϊ'/'��'0'��ǰһ�ַ��������Բ��С�
    
    public static String toBinaryString(byte n)           //����byte�����Ķ������ַ���
    {
        String str="";
        for (int i=0x00000080; i!=0; i>>>=1)
//����         for (byte i=-128; i!=0; i>>>=1)                  //??-128(1111111110000000)
            str += (n & i)==0 ? '0': '1';
        return str;                                        //�����ַ���
    }
//i=-128(1111111110000000)��i>>>=1����λ��1��䣬i!=0������Զ��������ѭ����
    
}
/*
���������н�����£�
Integer.toBinaryString(254)=11111110
toBinaryString(254)=00000000000000000000000011111110
toHexString(254)=FE
toString(254,8)=376
binary(254)=11111110
hex(254)=FE
toBinary(254)=11111110
toHex(254)=FE
toBinaryString(-1)=11111111111111111111111111111111

*/

