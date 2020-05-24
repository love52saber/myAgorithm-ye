//ϰ4.5 ��ѭ��˫������Ϊ���еĳ�Ա����ʵ�ֶ��С�

public class DLinkedQueue<T> implements QQueue<T>     //��ʽ�����࣬ʵ�ֶ��нӿ�
{
    private CirDoublyLinkedList<T> list;              //ʹ��ѭ��˫����洢����Ԫ��

    public DLinkedQueue()                             //����ն���
    {
        this.list = new CirDoublyLinkedList<T>(); 
    }
    public boolean isEmpty()                          //�ж϶����Ƿ�գ����շ���true
    {
        return list.isEmpty();
    }

    public void enqueue(T x)                          //Ԫ��x��ӣ��ն�������ӣ��������ɹ�����true
    {
        list.append(x);                               //��˫����������xԪ�ؽ�㣬ʵ����ͷ���룬O(1)
    } 

    public T dequeue()                                //���ӣ����ض�ͷԪ�أ������пշ���null
    {
        return list.remove(0);                        //ȡ�ö�ͷԪ�ز�ɾ����ͷ��㣬ͷɾ����O(1)
    } 

    public String toString()                          //���ض����и�Ԫ�ص��ַ�������
    {
        return list.toString();
    }
}
