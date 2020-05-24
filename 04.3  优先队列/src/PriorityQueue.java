//4.3   ���ȶ���

//���ȶ����࣬ʵ�ֶ��нӿڣ�ʹ����������洢����Ԫ�أ�Ԫ�ذ����ȼ���������
public class PriorityQueue<T extends Comparable<T>> implements QQueue<T>
{
    private SortedSinglyLinkedList<T> list;                //ʹ����������洢����Ԫ��

    public PriorityQueue()                                 //����ն���
    {
        this.list = new SortedSinglyLinkedList<T>(); 
    }
    public boolean isEmpty()                               //�ж϶����Ƿ�գ����շ���true
    {
        return list.isEmpty();
    }

    public void enqueue(T x)                               //Ԫ��x��ӣ��ն��������
    {
        list.insert(x);                                    //����Ԫ�ش�С�����ڵ������ʵ�λ��
    } 

    public T dequeue()                                     //���ӣ����ض�ͷԪ�أ������пշ���null
    {
        return list.remove(0);                             //���ض�ͷԪ�أ�ɾ����ͷ���
    } 

    public String toString()                               //���ض�������Ԫ�ص������ַ���
    {
        return list.toString();
    }
}
