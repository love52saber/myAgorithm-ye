//��ϰ3.3��  ʶ���ʶ����

public class Identifier
{
    public static boolean isLetter(char ch)                //�ж�ָ���ַ��Ƿ�Ϊ��ĸ
    {
        return ch>='A' && ch<='Z' || ch>='a' && ch<='z';
    }
	
    public static boolean isIdentifier(String str)         //�ж�ָ���ַ����Ƿ�Ϊ��ʶ��
    {
        char ch = str.charAt(0);                           //���ַ�����str������Ϊ0�����׳����Խ���쳣
//      if (ch>='A' && ch<='Z' || ch>='a' && ch<='z' || ch=='_' || ch=='$') //��ĸ��ͷ
        if (isLetter(ch) || ch=='_' || ch=='$')            //��ĸ��ͷ
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

    public static String[] toIdentifier(String str)        //ʶ���ָ���ַ���str�е����б�ʶ��
    {
        int len=20;
        String[] ids = new String[len];
        int i=0, j=0;
        while (i<str.length())
        {
            char ch = str.charAt(i);
            if (ch>='A' && ch<='Z' || ch>='a' && ch<='z' || ch=='_' || ch=='$')  //��ĸ��ͷ
            {
                ids[j]="";
                do{
                    ids[j] += ch;                          //�ַ������ַ����ӣ��Զ����ַ�ת�����ַ���
                    i++;
                    if (i<str.length())
                         ch = str.charAt(i);
                } while (i<str.length() && (ch>='A' && ch<='Z' || ch>='a' && ch<='z' || ch=='_' || ch=='$' || ch>='0' && ch<='9'));
                j++;
            }
            else i++;
        }
        String[] dest=new String[j];
        System.arraycopy(ids,0,dest,0,j);                  //����ids����ǰj��Ԫ�ص�dest
        return dest;
    }
    
    public static void main(String args[]) 
    {
        String str = "$_name1";                            //�жϱ�ʶ��
        System.out.println("\""+str+"\" isIdentifier? "+isIdentifier(str));
        
        str="10+a1+b+c*(d-2)";                             //ʶ���ʶ��
        System.out.print("\""+str+"\"toIdentifier��");
        String[] ids=toIdentifier(str);
        for (int i=0; i<ids.length; i++)
            System.out.print(ids[i]+"�� ");
        System.out.println();

        //ϰ��4
        str = "_name1";                                    //�жϱ�ʶ��
        System.out.println("\""+str+"\" identifier? "+identifier(str));
    }

    //ϰ��4
    public static boolean identifier(String str)           //�ж�ָ���ַ����Ƿ�Ϊ��ʶ�����ݹ��㷨
    {
        char ch = str.charAt(0);                           //���ַ�
        if (ch>='A' && ch<='Z' || ch>='a' && ch<='z' || ch=='_' || ch=='$') //��ĸ��ͷ
            return identifier(str, 1);
        return false;
    }

    private static boolean identifier(String str, int i)   //�ж�ָ���ַ����Ƿ�Ϊ��ʶ�����ݹ��㷨
    {
        if (i<str.length())                                //����ַ���
        {
            char ch = str.charAt(i);
            return (ch>='A' && ch<='Z' || ch>='a' && ch<='z' || ch=='_' || ch=='$' || ch>='0' && ch<='9')
                && identifier(str, i+1);                   //�ݹ����
        }
        return true;
    }
}
/*
�������н�����£�
"$_name1" isIdentifier? true
"10+a1+b+c*(d-2)"toIdentifier��a1�� b�� c�� d�� 
"_name1" identifier? true
*/

