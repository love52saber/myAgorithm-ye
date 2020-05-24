//3.3.2   KMP�㷨

public class KMP 
{
	private static int count=0;                            //���رȽϴ���
	private static int[] next;                             //ģʽ��pattern�Ľ���next����
	private static int[] nextk;                            //ģʽ��patternδ�Ľ���next����

    //����ģʽ��pattern��Ŀ�괮target�д�begin��ʼ���״�ƥ��λ�ã�ƥ��ʧ��ʱ����-1
    public static int indexOf(String target, String pattern, int begin)
    {
        if (pattern.length()>0 && target.length()>=pattern.length())
        {                                                  //��Ŀ�괮��ģʽ����ʱ���бȽ�
            int i=begin, j=0;                              //i��j�ֱ�ΪĿ�괮��ģʽ����ǰ�Ƚ��ַ��±�
            count=0;   
            nextk = getNextk(pattern);
            System.out.println("nextk[]: "+toString(nextk));
            next = getNext(pattern);                       //����ģʽ��pattern�Ľ���next����
            System.out.println("next[]:  "+toString(next));

            while (i<target.length())
            {
                if (j!=-1)
                    System.out.println("KMP.count="+KMP.count+"��i="+i+"��j="+j+"��"+target.charAt(i)+"=="+pattern.charAt(j)+"��");
                	
                if (j==-1 || target.charAt(i)==pattern.charAt(j))
                {                                          //��������������ǰ���ַ���ȣ���������ȽϺ����ַ�
                    i++;
                    j++;
                }
                else                                       //����Ŀ�괮�±�i�����ݣ������´�ƥ��
                    j=next[j];                             //ģʽ���±�j�˻ص�next[j]

                if(j!=-1) count++;
                if (j==pattern.length())                   //һ��ƥ�������ƥ��ɹ�
                {
                    System.out.println("KMP.count="+KMP.count);
                    return i-j;                            //����ƥ����Ӵ����
                }
            }
        }
        System.out.println("KMP.count="+KMP.count);
        return -1;                                         //ƥ��ʧ��
    }
    //����ģʽ��pattern��Ŀ�괮target�д�0��ʼ���״�ƥ��λ�ã�ƥ��ʧ��ʱ����-1
    public static int indexOf(String target, String pattern)
    {
        return indexOf(target, pattern, 0);
    }

    private static int[] getNextk(String pattern)          //����ģʽ��pattern��next����
    {
        int j=0, k=-1;
        int[] next=new int[pattern.length()];
        next[0]=-1;
        while (j<pattern.length()-1)
            if (k==-1 || pattern.charAt(j)==pattern.charAt(k))
            {
                j++;
                k++;
                next[j]=k;                                 //�д��Ľ�
            }
            else k=next[k];
        return next;
    }

    private static int[] getNext(String pattern)           //����ģʽ��pattern�Ľ���next����
    {
        int j=0, k=-1;
        int[] next=new int[pattern.length()];
        next[0]=-1;
        while (j<pattern.length()-1)
            if (k==-1 || pattern.charAt(j)==pattern.charAt(k))
            {
                j++;
                k++;
                if (pattern.charAt(j)!=pattern.charAt(k))  //�Ľ�֮��
                    next[j]=k;
                else
                    next[j]=next[k];  
            }
            else k=next[k];
        return next;
    }

    private static String toString(int[] next)             //���next[]����
    {
        String str="";
        for (int i=0; i<next.length; i++)
        	str += next[i]+" ";
        return str;
    }

    public static void main(String args[]) 
    {
//    	  String target="abdabcabbabcabc", pattern="abcabc"; //ͼ3.17
//          String target="ababdabcd", pattern="abc";        //BF������ͼ3.10
//          String target="abcabdabcabcaa", pattern="abcabdabcabcaa";  //��3.4
//          String target="aaaaa", pattern="aab";              //������ƥ�䲻�ɹ���ͼ3.13(b)
//          String target="aaaab", pattern="aab";           //������ƥ��ɹ�

        //ϰ��3
      String target="ababaab", pattern="aab";      //ϰ3.12��
//        String target="aaabaaaab", pattern="aaaab";      //ϰ3.12��
//      String target="acabbabbabc", pattern="abbabc";    //ϰ3.12��
//      String target="acabcabbabcabc", pattern="abcabaa";    //ϰ3.12��
//        String target="aabcbabcaabcaababc", pattern="abcaababc"; //ϰ3.12�ݣ�����Т��

        System.out.println("KMP.indexOf(\""+target+"\", \""+pattern+"\")="+KMP.indexOf(target, pattern));
    }
}

/*
�������н�����£�
KMP.indexOf("abdabcabbabcabc", "abcabc")=9       //ͼ3.17
nextk[]: -1 0 0 0 1 2 
next[]:  -1 0 0 -1 0 0 
KMP.count=17

KMP.indexOf("ababdabcd", "abc")=5                //BF������ͼ3.10
nextk[]: -1 0 0 
next[]:  -1 0 0 
KMP.count=10

KMP.indexOf("abcabdabcabcaa", "abcabdabcabcaa")=0  //��3.4
nextk[]: -1 0 0 0 1 2 0 1 2 3 4 5 3 4 
next[]:  -1 0 0 -1 0 2 -1 0 0 -1 0 5 -1 4 
KMP.count=14

KMP.indexOf("aaaaa", "aab")=-1                   //ͼ3.13(b)��������ƥ�䲻�ɹ����Ƚ�n+m��
nextk[]: -1 0 1 
next[]:  -1 -1 1 
KMP.count=8

KMP.indexOf("aaaab", "aab")=2                    //������ƥ��ɹ���O(n+m)
nextk[]: -1 0 1 
next[]:  -1 -1 1 
KMP.count=7

//ϰ��3��//ϰ3.12
KMP.indexOf("ababaab", "aab")=4                  //ϰ3.12��
nextk[]: -1 0 1 
next[]:  -1 -1 1 
KMP.count=7

KMP.indexOf("aaabaaaab", "aaaab")=4              //ϰ3.12��
nextk[]: -1 0 1 2 3 
next[]:  -1 -1 -1 -1 3 
KMP.count=9

KMP.indexOf("acabbabbabc", "abbabc")=5           //ϰ3.12��
nextk[]: -1 0 0 0 1 2 
next[]:  -1 0 0 -1 0 2 
KMP.count=13

KMP.indexOf("acabcabbabcabc", "abcabaa")=-1       //ϰ3.12��
nextk[]: -1 0 0 0 1 2 1 
next[]:  -1 0 0 -1 0 2 1 
KMP.count=18

KMP.indexOf("aabcbabcaabcaababc", "abcaababc")=9   //ϰ3.12��,����Т��
nextk[]: -1 0 0 0 1 1 2 1 2 
next[]:  -1 0 0 -1 1 0 2 0 0 
KMP.count=20




KMP.indexOf("abbabaaba", "aba")=3                 //BF����
nextk[]: -1 0 0 
next[]:  -1 0 -1 
KMP.count=6

*/