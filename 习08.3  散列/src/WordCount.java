//8.3   ɢ��
//8.3.4   ��������ַ����ɢ�б�
//��ϰ8.4�� ͳ���ı��и����ʵĳ��ִ�����
//����ɢ�б�洢��ָ��һ���ı���ͳ�Ƴ��ĸ����ʼ�����ִ�����

public class WordCount                           //���ʼ�����ִ���
{
    String word;                                 //����
    int count;                                   //���ִ���
    public WordCount(String word, int count)
    {
        this.word = word;
        this.count = count;
    }
    public String toString()                     //���ص��ʼ�����ִ��������ַ�������ʽΪ��(�ַ�,���ִ���)��
    {
        return "("+this.word+","+this.count+")";
    }
    public void add(int n)                       //���ִ�����1
    {
        this.count+=n;
    }
    public int hashCode()                        //����ɢ���룬����Object���hashCode()����
    {
        return (int)this.word.hashCode();        //���ݵ��ʾ���������ɢ�б��е�λ��
    }
    public boolean equals(Object obj)            //�Ƚ����������Ƿ���ȣ�����Object���equals(obj)����
    {
        return obj==this || obj instanceof CharCount && 
            this.word.equals(((WordCount)obj).word);       //���Ƚϵ����Ƿ����
    }
}
