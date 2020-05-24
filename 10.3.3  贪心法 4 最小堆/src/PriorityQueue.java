//4.3   ���ȶ���
//10.3.3   ̰�ķ�  4.�Ѽ���Ӧ��
//���ȶ����࣬ʵ�ֶ��нӿڣ�ʹ����С�Ѵ洢����Ԫ�أ�Ԫ�ذ����ȼ���������
public class PriorityQueue<T extends Comparable<T>> implements QQueue<T>
{
    private MinHeap<T> minheap;                       //ʹ����С�Ѵ洢����Ԫ��

    public PriorityQueue()                            //����ն���
    {
        this.minheap = new MinHeap<T>();              //����Ĭ�������Ŀ���С��
    }
    
    public boolean isEmpty()                          //�ж϶����Ƿ�գ����շ���true
    {
        return minheap.isEmpty();
    }
    
    public void enqueue(T x)                          //Ԫ��x��ӣ��ն��������
    {
        minheap.insert(x);                            
    } 

    public T dequeue()                                //���ӣ����ض�ͷԪ�أ������пշ���null
    {
        return minheap.removeMin();                   //������С�ѵĸ�Ԫ�أ�ɾ�������
    } 

    public String toString()                          //���ض�������Ԫ�ص������ַ���
    {
        return minheap.toString();
    }
}
