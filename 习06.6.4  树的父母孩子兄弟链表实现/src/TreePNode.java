//6.6.4   ���ĸ�ĸ�����ֵ�����ʵ��
//���ĸ�ĸ�����ֵ���������

public class TreePNode<T>                         //���ĸ�ĸ�����ֵ��������࣬����Tָ������Ԫ������
{
    public T data;                                //�����򣬴洢����Ԫ��
    public TreePNode<T> parent;                   //ָ��ĸ������
    public TreePNode<T> child, sibling;           //�����ֱ�ָ���ӡ��ֵܽ��

    //�����㣬�����ֱ�ָ��Ԫ�ء���ĸ�����Ӻ��ֵܽ��
    public TreePNode(T data, TreePNode<T> parent, TreePNode<T> child, TreePNode<T> sibling)
    {
        this.data = data;
        this.parent = parent;
        this.child = child;
        this.sibling = sibling;
    }
    public TreePNode(T data)                      //����ָ��ֵ��Ҷ�ӽ��
    {
        this(data, null, null, null);
    }
    public TreePNode()
    {
        this(null, null, null, null);
    }
    
    //���������·���
    public String toString()
    {
        return this.data.toString();
    }
    public boolean equals(Object obj)            //�Ƚ��������ֵ�Ƿ���ȣ�����Object���equals(obj)����
    {
        return obj==this || obj instanceof TreePNode && this.data.equals(((TreePNode<T>)obj).data);
    }    
}
