//4.15  �ܷ񽫶�������Ϊ�̳����Ա���ջ����append(x)��������ջ����remove(0)������Ϊʲô��

public class SeqQueue2<T> extends SeqList<T>               //˳������࣬�̳�˳���
{
    public void enqueue(T x)                               //Ԫ��x���
    {
        this.append(x);
    } 
    public T dequeue()                                     //���ӣ����ض�ͷԪ�أ������пշ���null 
    {
        return this.remove(0);
    }
}
//���𡿲��С����в�֧���м�����ɾ�����������и�����������Ա�����ڡ�
