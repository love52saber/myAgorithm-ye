//˫��������

public class DLinkNode<T>                        //˫��������
{
    public T data;                               //����Ԫ��
    public DLinkNode<T> pred, next;              //predָ��ǰ����㣬nextָ���̽��

    //�����㣬dataָ��Ԫ�أ�predָ��ǰ����㣬nextָ���̽��
    public DLinkNode(T data, DLinkNode<T> pred, DLinkNode<T> next)
    {
        this.data = data;
        this.pred = pred;
        this.next = next;
    }
    public DLinkNode()
    {
        this(null, null, null);
    }
}

/*
    public DLinkNode(T data)
    {
        this(data, null, null);
    }
    public String toString()                     //���ؽ��Ԫ��ֵ��Ӧ���ַ���
    {
        return this.data.toString();
    }
}*/
/*
����������˵����
1��DLinkNode<T>�����������£���Ϊnext����ΪNode<T>��������DLinkNode<T>��
public class DLinkNode<T> extends Node<T> 
{
    public DLinkNode<T> pred;                    //prevָ��ǰ�����
    
    public DLinkNode(T data, DLinkNode<T> pred, DLinkNode<T> next)
    {
        super(data, next);                       //��������next����ΪNode<T>�����ṹ����
//        this.data = data;
//        this.next = next;                        //��this.next����ΪNode<T>�����ṹ����
        this.pred = pred;
    }
    public DLinkNode()
    {
//        super();                          //��������next����ΪNode<T>�����ṹ���ԣ���û��prev��
        this(null, null, null);
    }
}
   
/*   
2�����﷨��DLinkNode<T>�����������£���˫�������뵥�����㣬�������������а�����ϵ�ĸ��
public class DLinkNode<T> extends Node<T> 
{
    public DLinkNode<T> pred, next;              //prevָ��ǰ����㣬nextָ���̽��
    public DLinkNode(T data, DLinkNode<T> pred, DLinkNode<T> next)
    {
//        super(data, next);                     //��������next����ΪNode<T>�����ṹ����
      super(data, null);                         //��
//        this.data = data;
        this.next = next;                        //�ԣ�this.next����super.next������ΪNode<T>��
        this.pred = pred;
    }
    public DLinkNode()
    {
        this(null, null, null);
    }
}
*/