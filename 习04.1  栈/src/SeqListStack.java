//��ϰ4.1��  ��˳�����Ϊջ�ĳ�Ա����ʵ��ջ��

public class SeqListStack<T> implements SStack<T>          //˳��ջ�࣬ʵ��ջ�ӿ�
{
    private SeqList<T> list;                               //ʹ��˳���洢ջԪ��
    
    public SeqListStack(int size)                          //��������Ϊsize�Ŀ�ջ
    {
        this.list = new SeqList<T>(size); 
    }
    public SeqListStack()                                  //�����ջ
    {
        this.list = new SeqList<T>(); 
    }
    public boolean isEmpty()                               //�ж�ջ�Ƿ�գ����շ���true
    {
        return list.isEmpty();
    }

    public void push(T x)                                  //Ԫ��x��ջ���ն�������ջ���������ɹ�����true��O(1)
    {
        list.append(x);                                    //��Ԫ��x������˳�������Զ���������
    } 
    
    public T pop()                                         //��ջ������ջ��Ԫ�أ���ջ�շ���null��O(1)
    {
        return list.remove(list.length()-1);               //����ջ��Ԫ�ز�ɾ��ջ��Ԫ�أ�βɾ��
    }

    public T get()                                         //ȡջ��Ԫ�أ�δ��ջ����ջ�շ���null
    {
        return list.isEmpty() ? null : list.get(list.length()-1);
    }

    public String toString()                               //����ջ�и�Ԫ�ص��ַ������� 
    {
        return list.toString();
    }
}
/*
���²���Ч�ʽϵͣ�
    public void push(T x)                                  //Ԫ��x��ջ��O(n)
    {
        list.insert(0, x);                                 //��Ԫ��x�����ڵ�������ǰ��ͷ����
    } 
    public T pop()                                         //��ջ������ջ��Ԫ�أ���ջ�շ���null��O(n)
    {
        return list.remove(0);                             //����ջ��Ԫ�ز�ɾ��ջ��Ԫ��
    }
*/