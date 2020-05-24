//ϰ4.4 ʹ�õ�������Ϊ���еĳ�Ա����ʵ�ֶ��С�

public class SLinkedQueue<T> implements QQueue<T>     //��ʽ�����࣬ʵ�ֶ��нӿ�
{
    private SinglyLinkedList<T> list;                 //ʹ�õ�����洢����Ԫ��

    public SLinkedQueue()                             //����ն���
    {
        this.list = new SinglyLinkedList<T>(); 
    }
    public boolean isEmpty()                          //�ж϶����Ƿ�գ����շ���true
    {
        return list.isEmpty();
    }

    public void enqueue(T x)                          //Ԫ��x��ӣ��ն�������ӣ��������ɹ�����true
    {
        list.append(x);                               //�ڵ�����������xԪ�ؽ�㣬β���룬O(n)
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
