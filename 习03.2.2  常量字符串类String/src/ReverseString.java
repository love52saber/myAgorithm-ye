//��ϰ3.4��  ��תString����

public class ReverseString
{
    public static String reverse(String str)     //����str��ת��Ĵ������㷨�������Ӵ��ʹ�����
    {
        String temp = "";
        for (int i=str.length()-1; i>=0; i--)
            temp += str.substring(i,i+1);        //���ӵ��ַ��Ӵ�
        return temp;
    }   
    public static void main(String args[])
    {
//        String str = "abcdefghijklmnopqrstuvwxyz";
        String str = "abcdefghij";
        System.out.println("reverse(\""+str+"\")=\""+reverse(str)+"\"");
    }
}

/*
�������н�����£�
reverse("abcdefghijklmnopqrstuvwxyz")="zyxwvutsrqponmlkjihgfedcba"
reverse("abcdefghij")="jihgfedcba"

*/
