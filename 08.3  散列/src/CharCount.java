//8.3   ɢ��
//8.3.4   ��������ַ����ɢ�б�
//����8.3�� ͳ���ı��и��ַ��ĳ��ִ�����Ϊ����Huffman����׼����
//����ɢ�б�洢��ָ��һ���ı���ͳ�Ƴ��ĸ��ַ�������ִ�����

public class CharCount implements Comparable<CharCount>    //�ַ�������ִ���
{
    char character;                              //�ַ�
    int count;                                   //���ִ���
    public CharCount(char character,int count)
    {
        this.character = character;
        this.count = count;
    }
    public String toString()                     //�����ַ�������ִ��������ַ�������ʽΪ��(�ַ�,���ִ���)��
    {
        return "("+this.character+","+this.count+")";
    }
    public void add(int n)                       //���ִ�����1
    {
        this.count+=n;
    }
    public int hashCode()                        //����ɢ���룬����Object���hashCode()����
    {
        return (int)this.character;              //�����ַ�����������ɢ�б��е�λ��
    }
    public boolean equals(Object obj)            //�Ƚ����������Ƿ���� ������Object���equals(obj)����
    {
        return obj==this || obj instanceof CharCount && 
            this.character==((CharCount)obj).character;    //���Ƚ��ַ��Ƿ����
    }
    
    public int compareTo(CharCount c)
    {
        return this.character - c.character;
    }
}
