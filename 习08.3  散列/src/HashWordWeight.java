
public class HashWordWeight
{
    private HashSet<WordCount> hashset;                    //ʹ��ɢ�б�洢ͳ�ƽ��

    public HashWordWeight(String text)     //����text��ͳ�Ƴ��ĸ����ʼ�����ִ����洢��ɢ�б���
    {
        hashset = new HashSet<WordCount>(text.length());   //������ɢ�б�
        int i=0; 
        while (i<text.length())                            //������ʲ��Ҽ���
        {
            int j=text.indexOf(' ',i);
            if (j==-1)
                j=text.length();
            if (j!=i)
            {            
                WordCount key = new WordCount(text.substring(i,j),1);
                WordCount find = hashset.search(key);      //���ң�find���ò��ҵ���Ԫ��
                if (find==null)
                    hashset.insert(key);                   //ɢ�б����
                else
                    find.add(1);                           //��Ӧ���ʼ�����1
            }
            i=j+1;
        }   
        System.out.println("���ʼ�����ִ�����"+hashset.toString());
    }
 
    public static void main(String args[]) //throws java.io.IOException
    {
        new HashWordWeight("public  class  CharCount");
    }
}
/*
�������н�����£�
���ʼ�����ִ�����((class,1))
((public,1))
((CharCount,1))

 */