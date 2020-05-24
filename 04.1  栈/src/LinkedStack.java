//4.1.3   ��ʽջ

public class LinkedStack<T> implements SStack<T>           //��ʽջ�࣬ʵ��ջ�ӿ�
{
    private Node<T> top;                                   //ջ����㣬������������������2��
    
    public LinkedStack()                                   //�����ջ
    {
        this.top=null; 
    }
    public boolean isEmpty()                               //�ж�ջ�Ƿ�գ����շ���true
    {
        return this.top==null;
    }
    public void push(T x)                                  //Ԫ��x��ջ���ն�������ջ
    {
        if (x!=null)
            this.top = new Node(x, this.top);              //ͷ���룬x�����Ϊ�µ�ջ�����
    } 
    public T pop()                                         //��ջ������ջ��Ԫ�أ���ջ�շ���null
    {
        if (this.top==null)
            return null;
        T temp = this.top.data;                            //ȡջ�����Ԫ��
        this.top = this.top.next;                          //ɾ��ջ�����
        return temp;
    }
    public T get()                                         //ȡջ��Ԫ�أ�δ��ջ����ջ�շ���null
    {
        return this.top==null ? null : this.top.data;
    }
    
    //����ջ����Ԫ�ص������ַ�������ʽΪ��(,)�����㷨ͬ����ͷ���ĵ�����
    public String toString()
    {
        String str="(";
        for (Node<T> p=this.top;  p!=null;  p=p.next) 
        {   str += p.data.toString();
            if (p.next!=null) 
                str += ", ";                               //�������һ�����ʱ��ӷָ���
        }
        return str+")";                                    //�ձ���()
    }
}
