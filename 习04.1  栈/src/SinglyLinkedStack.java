//��ϰ4.2��  �õ�������Ϊջ�ĳ�Ա����ʵ��ջ��

public class SinglyLinkedStack<T> implements SStack<T>     //��ʽջ�࣬ʵ��ջ�ӿ�
{
    private SinglyLinkedList<T> list;                      //ʹ�õ�����洢ջԪ�أ�����������������2��
    
    public SinglyLinkedStack()                             //�����ջ
    {
        this.list = new SinglyLinkedList<T>(); 
    }
    public boolean isEmpty()                               //�ж�ջ�Ƿ�գ����շ���true
    {
        return list.isEmpty();
    }

    public void push(T x)                                  //Ԫ��x��ջ���������ɹ�����true���ն�������ջ��O(1)
    {
        list.insert(0, x);                                 //��Ԫ��x�����ڵ�������ǰ��ͷ����
    } 
    
    public T pop()                                         //��ջ������ջ��Ԫ�أ���ջ�շ���null��O(1)
    {
        return list.remove(0);                             //����ջ�����Ԫ�ز�ɾ��ջ�����
    }

    public T get()                                         //ȡջ��Ԫ�أ�δ��ջ����ջ�շ���null
    {
        return list.isEmpty() ? null : list.get(0);
    }

    public String toString()                               //����ջ�и�Ԫ�ص��ַ������� 
    {
        return list.toString();
    }
}
