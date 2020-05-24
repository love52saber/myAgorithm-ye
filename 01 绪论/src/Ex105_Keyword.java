//����1.5��  �ж�ָ���ַ����Ƿ�ΪJava�ؼ��֡�

public class Ex105_Keyword
{
    //�ؼ��ֱ�
    private static String[] keywords={"abstract","assert","boolean","break","byte","case","catch",
        "char","class","continue","default","do","double","else","extends","false","final","finally",
        "float","for","if","implements","import","instanceof","int","interface","long","native","new",
        "null","package","private","protected","public","return","short","static","super","switch",
        "synchronized","this","throw","throws","transient","true","try","void","volatile","while"};

    public static boolean isKeyword(String str)            //�ж�str�Ƿ�ΪJava�ؼ���
    {
        return Ex104_SortedArray_Comparable.indexOf(keywords, str)!=-1;
    }
    
    public static void main(String[] args) 
    {
        if (args.length==0)
            System.out.println("length"+(isKeyword("length")?"":"��")+"�ǹؼ���");
        else                                               //�������в���ʱ
            for (int i=0; i<args.length; i++) 
                System.out.println(args[i]+(isKeyword(args[i])?"":"��")+"�ǹؼ���");
    }
    
/*    public static void main(String[] args) throws java.io.IOException  //�׳��쳣����Java���������
    {  
        System.out.print("�ַ���: ");
        byte buffer[] = new byte[512];                    	//���ֽ�������Ϊ������
        int count = System.in.read(buffer);      
                       //�ӱ�׼�������ж�ȡ�����ֽڵ�������buffer���Իس����з�����������ʵ�ʶ�ȡ�ֽ���
        String str=new String(buffer,0,count-2);
                            //��buffer�����д�0��ʼ����Ϊcount-2�������ֽڹ��촮�����ƻس����з�
        System.out.println(str+(isKeyword(str)?"":"��")+"�ǹؼ���");
    }*/
    
}
/*
�������н�����£�
abstract? assert? boolean? break? byte? case? catch? char? class? continue? default? do? double? else? extends? false? final? finally? float? for? if? implements? import? instanceof? int? interface? length���ǹؼ���

�����в���ΪWelcome publicʱ��
Welcome ���ǹؼ���
public �ǹؼ���


�ַ���:                 //����س�������ʾ�մ�
���ǹؼ���

�ַ���: if
if�ǹؼ���

�ַ���: length
length���ǹؼ���

*/
/*    
Ҳ��
public static void main(String args[]) throws java.io.IOException  //�׳��쳣����Java���������
{  
    System.out.print("�ַ���: ");
    String str="";
    int i;
    while ((i=System.in.read())!=-1)  //�ȴ��������룬�ӱ�׼�������ж�ȡһ���ַ���ASCII��
        str+=(char)i;
    System.out.println((isKeyword(str)?"":"��")+"�ǹؼ���");
}*/

