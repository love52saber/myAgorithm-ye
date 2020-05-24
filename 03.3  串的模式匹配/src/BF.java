//3.3   ����ģʽƥ��
//3.3.1   ���ص�ģʽƥ�䣨Brute-Force���㷨

public class BF 
{
    private static int count=0;                            //���رȽϴ���

    //����ģʽ��pattern��Ŀ�괮target�д�begin��ʼ���״�ƥ��λ�ã�ƥ��ʧ��ʱ����-1
    public static int indexOf(String target, String pattern, int begin)
    {
        if (pattern!=null && pattern.length()>0 && target.length()>=pattern.length())
        {                                                  //��Ŀ�괮��ģʽ����ʱ���бȽ�
            int i=begin, j=0;                              //i��j�ֱ�ΪĿ�괮��ģʽ����ǰ�ַ����±�
            count=0;   
            while (i<target.length())
            {
                if (target.charAt(i)==pattern.charAt(j))   //����ǰ���ַ���ȣ�������ȽϺ����ַ�
                {
                    i++;
                    j++;
                }
                else                                       //����i��j���ݣ�������һ��ƥ��
                {
                    i=i-j+1;                               //Ŀ�괮�±�i�˻ص���һ����ƥ���Ӵ����ַ�
                    j=0;                                   //ģʽ���±�j�˻ص�0
                }
                count++;
                if (j==pattern.length())                   //һ��ƥ�������ƥ��ɹ�
                {
                    System.out.println("BF.count="+BF.count);
                    return i-j;                            //����ƥ����Ӵ����
                }
            }
        }
        System.out.println("BF.count="+BF.count);
        return -1;                                         //ƥ��ʧ��ʱ����-1
    }
    //����ģʽ��pattern��Ŀ�괮target�д�0��ʼ���״�ƥ��λ�ã�ƥ��ʧ��ʱ����-1
    public static int indexOf(String target, String pattern)
    {
        return BF.indexOf(target, pattern, 0);
    }
    
    public static void main(String args[]) 
    {
        String target="ababdabcd", pattern="abc";        //ͼ3.10��BF����
//        String target="aabaaa", pattern="aab";           //ͼ3.13(a)��ƥ��ɹ���������
//        String target="aaaaa", pattern="aab";            //ͼ3.13(b)��������ƥ�䲻�ɹ�
//        String target="aaaab", pattern="aab";            //������ƥ��ɹ�

        System.out.println("BF.indexOf(\""+target+"\"��\""+pattern+"\")="+BF.indexOf(target,pattern));
    }
}
/*
�������н�����£�
BF.count=12
BF.indexOf("ababdabcd"��"abc")=5                            //ͼ3.10��BF����

BF.count=3
BF.indexOf("aabaaa"��"aab")=0                               //ͼ3.13(a)��ƥ��ɹ���������

BF.count=11
BF.indexOf("aaaaa"��"aab")=-1                               //ͼ3.13(b)��������ƥ�䲻�ɹ�

BF.count=9
BF.indexOf("aaaab"��"aab")=2                                //������ƥ��ɹ�


*/
