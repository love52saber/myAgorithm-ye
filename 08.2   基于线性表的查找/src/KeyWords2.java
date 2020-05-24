//8.2.3  ��������˳���ķֿ�����㷨��
//����8.2�� ���������������ѯJava�ؼ��֡�
public class KeyWords2  
{
    //�ؼ��ֱ�
    private static String[] keywords={"abstract","assert","boolean","break","byte","case","catch",
        "char","class","continue","default","do","double","else","extends","false","final","finally",
        "float","for","if","implements","import","instanceof","int","interface","long","native","new",
        "null","package","private","protected","public","return","short","static","super","switch",
        "synchronized","this","throw","throws","transient","true","try","void","volatile","while"};

    private static class IndexItem implements Comparable<IndexItem>  //�����˽���ڲ���
    {
        String first;                                      //�ؼ��ֵ�����ĸ
        int start,end;                                     //����ĸ��ͬ�Ĺؼ��ֿ��������е�ʼĩ�±�
        public IndexItem(String first, int start, int end)
        {
            this.first = first;
            this.start = start;
            this.end = end;
        }
        public String toString()                           //����������������ַ���
        {
            return "("+this.first+","+start+","+end+")";
        }
        public int compareTo(IndexItem item)               //Լ������������Ƚϴ�С�Ĺ���ʵ��Comparable�ӿ�
        {
            return this.first.compareTo(item.first);       //������ĸ�Ƚϴ�С
        }
    }//�ڲ������

    private static IndexItem index[];                      //������
    static                                                 //��̬��ʼ��������������
    {
        index = new IndexItem[26];
        int i=0, j=0;
        for (i=0; i<index.length && j<keywords.length; i++)
        {
            char ch=(char)('a'+i);
            if (keywords[j].charAt(0)>ch)
                index[i]=new IndexItem(ch+"",-1,-1);
            else
            {
                int start = j++;
                while (j<keywords.length && keywords[j].charAt(0)==ch)
                    j++;
                index[i]=new IndexItem(ch+"",start,j-1);
            }
        }
        
        System.out.print("index[]:");
        for (i=0; i<index.length; i++)
            if (index[i]!=null)
                 System.out.print(index[i].toString()+" ");
        System.out.println();
    }
    
    public static boolean isKeyword(String str)            //�ж�str�Ƿ�ΪJava�ؼ���
    {
        int pos = str.charAt(0)-'a';                       //����ĸ��Ӧ�����������
        if (pos<0 || pos>26)
            return false;
        int begin=index[pos].start;                          //���������ҷ�Χ���½�
        if (begin==-1)
            return false;
        int end=index[pos].end;                           //���������ҷ�Χ���Ͻ�
        return BinarySearchArray.binarySearch(keywords,begin,end,str)>=0;   //�۰���������ָ����Χ
    }

    public static void main(String[] args) 
    {                                         //Ĭ�����Ƚ��о�̬��ʼ��������������
        String str="final";
        System.out.println(str+(isKeyword(str)?"":"��")+"�ǹؼ���");
        str ="length";
        System.out.println(str+(isKeyword(str)?"":"��")+"�ǹؼ���");
    }
}

/*
�������н�����£�
index[]:(a,0,1) (b,2,4) (c,5,9) (d,10,12) (e,13,14) (f,15,19) (g,-1,-1) (h,-1,-1) (i,20,25) (j,-1,-1) (k,-1,-1) (l,26,26) (m,-1,-1) (n,27,29) (o,-1,-1) (p,30,33) (q,-1,-1) (r,34,34) (s,35,39) (t,40,45) (u,-1,-1) (v,46,47) (w,48,48) 
finally? false? final? final�ǹؼ���
long? length���ǹؼ���

*/

