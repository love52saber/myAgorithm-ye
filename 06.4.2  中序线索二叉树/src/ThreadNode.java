//6.4   ����������
//�����������Ķ����������࣬Tָ������Ԫ������
public class ThreadNode<T>
{
    public T data;                               //����Ԫ��
    public ThreadNode<T> left, right;            //�ֱ�ָ�����Һ��ӽ��
    public int ltag, rtag;                       //�����������

    public ThreadNode(T data, ThreadNode<T> left, int ltag, ThreadNode<T> right, int rtag)
    {
        this.data = data;
        this.left = left;
        this.ltag = ltag;
        this.right = right;
        this.rtag = rtag;
    }
    public ThreadNode(T data)                    //����ָ��ֵ���
    {
        this(data, null, 0, null, 0);
    }
    public ThreadNode()
    {
        this(null, null, 0, null, 0);
    }
    
    //���������·���
    public String toString()
    {
        return this.data.toString();
    }
    public boolean equals(Object obj)            //�Ƚ��������ֵ�Ƿ���ȣ�����Object���equals(obj)����
    {
        return obj==this || obj instanceof ThreadNode && this.data.equals(((ThreadNode<T>)obj).data);
    }    
    public boolean isLeaf()                      //�ж��Ƿ�Ҷ�ӽ��
    {
        return this.ltag==1 && this.rtag==1;
    }
}
/*
    public String toString()
    {
        return "("+this.data+","+this.ltag+","+this.rtag+")";
    }
*/

