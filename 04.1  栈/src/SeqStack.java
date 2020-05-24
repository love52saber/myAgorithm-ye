//4.1.2   ˳��ջ

public class SeqStack<T> implements SStack<T>              //˳��ջ�࣬ʵ��ջ�ӿ�
{
    private Object element[];                              //�洢ջ����Ԫ�ص�����
    private int top;                                       //ջ��Ԫ���±�

    public SeqStack(int size)                              //��������Ϊsize�Ŀ�ջ
    {
        this.element = new Object[Math.abs(size)];
        this.top=-1;
    }
    public SeqStack()                                      //����Ĭ�������Ŀ�ջ
    {
        this(64);
    }
    public boolean isEmpty()                               //�ж�ջ�Ƿ�գ����շ���true
    {
        return this.top==-1;
    } 

    public void push(T x)                                  //Ԫ��x��ջ���ն�������ջ
    {
        if (x==null)
           return;                                         //�ն�������ջ
        if (this.top==element.length-1)                    //��ջ����������ջ����
        {
            Object[] temp = this.element;         
            this.element = new Object[temp.length*2];      //��������һ���������������
            for (int i=0; i<temp.length; i++)              //��������Ԫ�أ�O(n)
                this.element[i] = temp[i];
        }
        this.top++;
        this.element[this.top] = x;
    } 

    public T pop()                                         //��ջ������ջ��Ԫ�أ���ջ�շ���null
    {
        return this.top==-1 ? null : (T)this.element[this.top--];
    }

    public T get()                                         //ȡջ��Ԫ�أ�δ��ջ����ջ�շ���null
    {
        return this.top==-1 ? null : (T)this.element[this.top];
    }

    public String toString()            //����ջ����Ԫ�ص������ַ�������ʽΪ��(,)�����㷨ͬ˳���
    {
        String str="(";  
        if (this.top!=-1)
            str += this.element[this.top].toString();
        for (int i=this.top-1; i>=0; i--)
            str += ", "+this.element[i].toString();
        return str+") ";
    }
}
