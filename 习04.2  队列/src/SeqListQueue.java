//ϰ4.3 ʹ��˳�����Ϊ���еĳ�Ա����ʵ�ֶ��С�

public class SeqListQueue<T> implements QQueue<T>     //˳������࣬ʵ�ֶ��нӿ�
{
    private SeqList<T> list;                          //ʹ��˳���洢����Ԫ��

    public SeqListQueue()                             //����ն���
    {
        this.list = new SeqList<T>(); 
    }
    
    public boolean isEmpty()                          //�ж϶����Ƿ�գ����շ���true
    {
        return list.isEmpty();
    }

    public void enqueue(T x)                          //Ԫ��x��ӣ��ն�������ӣ��������ɹ�����true
    {
        list.append(x);                               //��˳���������xԪ�ؽ�㣬O(1)
    } 

    public T dequeue()                                //���ӣ����ض�ͷԪ�أ������пշ���null
    {
        return list.remove(0);                        //ȡ�ö�ͷԪ�ز�ɾ����ͷԪ�أ�ͷɾ����O(n)
    } 

    public String toString()                          //���ض����и�Ԫ�ص��ַ�������
    {
        return list.toString();
    }
}
