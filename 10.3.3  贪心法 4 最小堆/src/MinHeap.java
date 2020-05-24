//10.3.3   ̰�ķ�

import java.util.Comparator;
//��С�ѣ�T����ʵ��Comparable<T>�ӿڣ�֧�ֶ���Ƚϴ�С
public class MinHeap<T extends java.lang.Comparable<T>> 
{
    private Comparable [] element;                         //��С��Ԫ������
    private int len;                                       //��С��Ԫ�ظ���
    private Comparator comparator=null;                    //�Ƚ�������
    
    public MinHeap(int size)                               //���췽������������Ϊsize�Ŀն�
    {
        this.element = new Comparable[size]; 
        this.len = 0;
    }
    public MinHeap()                                       //Ĭ�Ϲ��췽��������Ĭ�������Ŀն�
    {
        this(64);
    }
    public MinHeap(T[] element)                            //���췽������������ָ���ѳ�ֵ�����
    {
        this(element.length*2);
        for (int i=0; i<element.length; i++)
            this.insert(element[i]);                       //����Ԫ�ز�����С��
    }
    public MinHeap(int size, Comparator comparator)        //����նѣ�ָ���Ƚ�������
    {
        this(size);
        this.comparator = comparator;
    }
    public MinHeap(Comparator comparator)
    {
        this(64, comparator);
    }
    public MinHeap(T[] element, Comparator comparator) 
    {
        this(element.length, comparator);
        for (int i=0; i<element.length; i++)
            this.insert(element[i]);
    }

    public boolean isEmpty()                     //�ж��Ƿ�նѣ����շ���true
    {
        return this.len==0;
    }
    public int length()                          //������С��Ԫ�ظ���
    {
        return this.len;
    }
    public String toString()                     //������С������Ԫ�ص������ַ�������ʽΪ��(,)��
    {
        String str="(";
        if (this.len>0)
            str += this.element[0].toString();
        for (int i=1; i<this.len; i++)
            str += ", "+this.element[i].toString();
        return str+") ";
    }
    
    public void insert(T x)                      //��x���뵽��С���У����ܲ���null
    {
        if (x==null)
           return;
        if (this.len==element.length)                      //���������������������
        {
            Comparable[] temp = this.element;
            this.element = new Comparable[temp.length*2];
            for (int j=0; j<temp.length; j++)
                this.element[j] = temp[j];
        }
        this.element[this.len] = x;                        //����С��������Ԫ��
        this.len++;
        for (int i=this.len/2-1; i>=0; i-=2)               //���¶��ϵ������Ӷ�����Ϊ��С��
            sift(i);        
//        System.out.println(this.toString()+" ");  
    }
    
    private void sift(int begin)                           //����beginΪ����������������С��
    {
        if (comparator==null)                              //���Ƚ���Ϊ�ն�����Ĭ�ϰ�Comparable�ӿڵķ����Ƚϴ�С
        {
            int i=begin, j=2*i+1;                          //iΪ�����ĸ���jΪi��������
            Comparable temp=this.element[i];               //��õ�i��Ԫ�ص�ֵ
            while (j<this.len)                             //�ؽ�Сֵ���ӽ������ɸѡ
            { 
                if (j<this.len-1 && this.element[j].compareTo(this.element[j+1])>0)  //���ĳ�<Ϊ���ѣ�
                    j++;                                   //jΪ���Һ��ӵĽ�С��
                if (temp.compareTo(this.element[j])>0)     //����ĸ���ֵ�ϴ󣨸ĳ�<Ϊ���ѣ�
                {
                    this.element[i]=this.element[j];       //���ӽ���еĽ�Сֵ����
                    i=j;                                   //i��j����һ��
                    j=2*i+1;
                }
                else break;
            }
            this.element[i]=temp;                          //��ǰ������ԭ��ֵ�������λ��
        }
        else sift(begin, comparator);
    }
    //����beginΪ����������������С�ѣ��㷨ͬ�ϣ��ɱȽ���comparator�ṩ��Ԫ�رȽϴ�С�ķ���
    private void sift(int begin, Comparator comparator)
    {
        int i=begin, j=2*i+1;
        Comparable<T> temp=this.element[i];
        while (j<this.len)
        { 
            if (j<this.len-1 && comparator.compare(this.element[j],this.element[j+1])>0)
                j++; 
            if (comparator.compare(temp,this.element[j])>0)
            {
                this.element[i]=this.element[j];
                i=j;
                j=2*i+1;
            }
            else break;
        }
        this.element[i]=temp;
    }

    public T removeMin()                         //������СֵԪ�أ�������ɾ������㲢����Ϊ��С��
    {
         if (this.len==0)
             return null;
         T x = (T)this.element[0];                         //�����С�Ѹ����Ԫ��
         this.element[0] = this.element[this.len-1];       //�����λ��Ԫ���Ƶ�������ɾ����
         this.len--;
         sift(0);                                          //���������ֵ����С�ѵĺ���λ��
         return x;
    }
}
