//5.2.2 ϡ������ѹ���洢
//5.  ϡ�����ʮ������
//ʮ����������

public class CrossNode                           //ʮ����������
{
    Triple data;                                 //�������ʾ��Ԫ�飬Ĭ�Ϸ���Ȩ��
    CrossNode right, down;                       //rightָ���е���һ����㣬downָ���е���һ�����

    //�����㣬dataָ��Ԫ�أ�rightָ���е���һ����㣬downָ���е���һ�����
    public CrossNode(Triple data, CrossNode right, CrossNode down)
    {
        this.data = data;
        this.right = right;
        this.down = down;
    }
}
/*
    û���õ�
    public CrossNode()
    {
        this(null, null, null);
    }*/


/*
public class CrossNode<T>                        //ʮ����������

{
    public T data;                               //����Ԫ��
    public CrossNode<T> right, down;              //nextָ���еĺ�̽�㣬downָ���еĺ�̽��

    //�����㣬dataָ��Ԫ�أ�nextָ���еĺ�̽�㣬downָ���еĺ�̽��
    public CrossNode(T data, CrossNode<T> right, CrossNode<T> down)
    {
        this.data = data;
        this.right = right;
        this.down = down;
    }
    public CrossNode()
    {
        this(null, null, null);
    }
}
*/