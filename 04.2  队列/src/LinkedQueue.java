//4.2.3   ��ʽ����

public class LinkedQueue<T> implements QQueue<T> //��ʽ�����࣬ʵ�ֶ��нӿ�
{
    private Node<T> front, rear;                 //front��rear�ֱ�ָ���ͷ�Ͷ�β���

    public LinkedQueue()                         //����ն���
    {
        this.front=this.rear=null;
    }
    public boolean isEmpty()                     //�ж϶����Ƿ�գ����շ���true
    {
        return this.front==null && this.rear==null;
    }

    public void enqueue(T x)                     //Ԫ��x��ӣ��ն��������
    {
        if (x==null)
            return;                              //�ն��������
        Node<T> q = new Node<T>(x, null);
        if (this.front==null)
            this.front=q;                        //�նӲ���
        else 
            this.rear.next=q;                    //�����ڶ���֮β
        this.rear=q;
    } 

    public T dequeue()                           //���ӣ����ض�ͷԪ�أ������пշ���null 
    {
        if (isEmpty())
            return null;
        T temp = this.front.data;                //ȡ�ö�ͷԪ��
        this.front = this.front.next;            //ɾ����ͷ���
        if (this.front==null)
            this.rear=null;
        return temp;
    } 

    public String toString()                     //���ض�������Ԫ�ص������ַ�������ʽΪ��(,)��
    {                                            //�㷨ͬ����ͷ���ĵ�����
        String str="(";
        for (Node<T> p=this.front;  p!=null;  p=p.next)
        {
            str += p.data.toString();
            if (p.next!=null) 
                str += ", ";                               //�������һ�����ʱ��ӷָ���
        }
        return str+")";                                    //�ձ���()
    }
}
