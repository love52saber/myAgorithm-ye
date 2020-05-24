//���ĺ����ֵ���������

public class TreeNode<T>                         //���ĺ����ֵ��������࣬����Tָ������Ԫ������
{
    public T data;                               //�����򣬴洢����Ԫ��
    public TreeNode<T> child, sibling;           //�����ֱ�ָ���ӡ��ֵܽ��

    //�����㣬�����ֱ�ָ��Ԫ�ء����Ӻ��ֵܽ��
    public TreeNode(T data, TreeNode<T> child, TreeNode<T> sibling)
    {
        this.data = data;
        this.child = child;
        this.sibling = sibling;
    }
    public TreeNode(T data)                      //����ָ��ֵ��Ҷ�ӽ��
    {
        this(data, null, null);
    }
    public TreeNode()
    {
        this(null, null, null);
    }
    
    //���������·���
    public String toString()
    {
        return this.data.toString();
    }
    public boolean equals(Object obj)            //�Ƚ��������ֵ�Ƿ���ȣ�����Object���equals(obj)����
    {
        return obj==this || obj instanceof TreeNode && this.data.equals(((TreeNode<T>)obj).data);
    }    
    public boolean isLeaf()                      //�ж��Ƿ�Ҷ�ӽ��
    {
        return this.child==null && this.sibling==null;
    }
}
