//4.2.2  ˳��ѭ������
public class SeqQueue<T> implements QQueue<T>              //˳��ѭ�������࣬ʵ�ֶ��нӿ�
{
    private Object element[];                              //�洢��������Ԫ�ص�����
    private int front, rear;                               //front��rear�ֱ�Ϊ����ͷβ�±�

    public SeqQueue(int length)                            //��������Ϊlength�Ŀն���
    {
        if (length<64)
            length=64;                                     //���ö�������������Сֵ
    	this.element = new Object[Math.abs(length)];
        this.front = this.rear = 0;                        //���ÿն���
    }
    public SeqQueue()                                      //����Ĭ�������Ŀն���
    {
        this(64);
    }

    public boolean isEmpty()                               //�ж϶����Ƿ�գ����շ���true
    {
        return this.front==this.rear;
    } 

    public void enqueue(T x)                               //Ԫ��x��ӣ��ն��������
    {
        if (x==null)
           return;                                         //�ն��������
        if (this.front==(this.rear+1)%this.element.length) //��������ʱ����������
        {
            Object[] temp = this.element;         
            this.element = new Object[temp.length*2];      //��������һ���������������
            int j=0;
            for (int i=this.front;  i!=this.rear;  i=(i+1) % temp.length) //���ն���Ԫ�ش���������Ԫ��
                this.element[j++] = temp[i];
            this.front = 0;
            this.rear = j;
        }
        this.element[this.rear] = x;
        this.rear = (this.rear+1) % this.element.length;
    } 

    public T dequeue()                           //���ӣ����ض�ͷԪ�أ������пշ���null 
    {
        if (isEmpty())                           //�����пշ���null 
            return null;
        T temp = (T)this.element[this.front];    //ȡ�ö�ͷԪ��
        this.front = (this.front+1) % this.element.length;
        return temp;
    }

    public String toString()                     //���ض�������Ԫ�ص������ַ�������ʽΪ��(,)�������ն���Ԫ�ش���
    {
        String str="(";
        if (!isEmpty())
        {
            str += this.element[this.front].toString();
            int i=(this.front+1) % this.element.length;
            while(i!=this.rear)
            {
                str += ", "+this.element[i].toString();
                i=(i+1) % this.element.length;
            }
        }
        return str+")";
    }
}
