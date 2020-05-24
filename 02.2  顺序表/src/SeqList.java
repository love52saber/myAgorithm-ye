//2.2   ���Ա��˳���ʾ��ʵ��

//˳������Ա��˳��洢�ṹ���࣬ʵ�����Ա�ӿڣ�T�Ƿ��Ͳ�����ָ��������
//package dataStructure.linear;                  //������ǰ�ļ��е����ӿ���ָ������
//import dataStructure.linear.LList;             //����ָ�����е����ӿ�

//public class SeqList<T> implements LList<T>    //��2��
public class SeqList<T> extends AbstractLList<T> implements LList<T>    //��10�£�10.2 ʵ�ֵ�����
{
    protected Object[] element;                  //�������飬������Ա
    protected int len;                           //˳����ȣ�����Ԫ�ظ���

    public SeqList(int size)                     //���췽������������Ϊsize�Ŀձ�
    {
        this.element = new Object[size];         //��size<0���׳������鳤���쳣NegativeArraySizeException
        this.len = 0;
    }
    public SeqList()                             //Ĭ�Ϲ��췽��������Ĭ�������Ŀձ�
    {
        this(64);
    }

    public boolean isEmpty()                     //�ж�˳����Ƿ�գ����շ���true��O(1)
    {
        return this.len==0;
    }

    public int length()                          //����˳����ȣ�O(1)
    {
        return this.len;
    }

    public T get(int i)                          //���ص�i����0����Ԫ�ء���i<0����ڱ��򷵻�null��O(1)
    {
        if (i>=0 && i<this.len)
            return (T)this.element[i];
//          return this.element[i];                       //�����Object�����ܷ���T����
        return null;                                       //ϡ�������Ԫ��˳�������Ҫ����null
    }

    //���õ�i����0����Ԫ��ֵΪx����i<0����ڱ����׳����Խ���쳣����x==null��������
    public void set(int i, T x)
    {
        if (x==null)  return;                              //�������ÿն���
        if (i>=0 && i<this.len)
            this.element[i] = x;
        else throw new IndexOutOfBoundsException(i+"");    //�׳����Խ���쳣
    }

    //����˳�������Ԫ�ص������ַ�������ʽΪ��(,)��������Object���toString()����
    public String toString()
    {
        String str="(";
        if (this.len>0)
            str += this.element[0].toString();
        for (int i=1; i<this.len; i++)
            str += ", "+this.element[i].toString();
        return str+") ";                         //�ձ���()
    }
    
    //3.  ˳���Ĳ������
    //�����i����0����Ԫ��ֵΪx����x==null�������롣
    //��i<0������x��Ϊ��0��Ԫ�أ���i���ڱ�������x��Ϊ���һ��Ԫ�ء�
    public void insert(int i, T x)
    {
        if (x==null)   return;                             //���ܲ���ն���
        if (this.len==element.length)                      //����������������˳�������
        {
            Object[] temp = this.element;                  //tempҲ����elements����
            this.element = new Object[temp.length*2];      //��������һ���������������
            for (int j=0; j<temp.length; j++)              //��������Ԫ�أ�O(n)
                this.element[j] = temp[j];
        }
        if (i<0)  i=0;                                     //�±��ݴ�
        if (i>this.len)  i=this.len;
        for (int j=this.len-1; j>=i; j--)                  //Ԫ�غ��ƣ�ƽ���ƶ�len/2
            this.element[j+1] = this.element[j];
        this.element[i] = x;
        this.len++;
    }
    public void append(T x)                             //��˳���������xԪ��
    {
        insert(this.len, x);
    }
    
    //4.  ˳����ɾ������
    //ɾ����i����0����Ԫ�أ����ر�ɾ��������i<0��i���ڱ�����ɾ��������null��
    public T remove(int i)
    {
        if (this.len==0 || i<0 || i>=this.len) 
            return null;
//        throw new IndexOutOfBoundsException(i+"");     //�׳����Խ���쳣
        T old = (T)this.element[i];
        for (int j=i; j<this.len-1; j++)                   //Ԫ��ǰ�ƣ�ƽ���ƶ�len/2
            this.element[j] = this.element[j+1];
        this.element[this.len-1]=null;
        this.len--;
        return old;
    }

    public void removeAll()                                //ɾ�����Ա�����Ԫ��
    {
        this.len=0;
    }
    //����ʵ��LList�ӿڣ���2������
    
/*
���У�Ч��ͬ��
    public String toString()                     //������ʾ���Ա�����Ԫ��ֵ���ַ�������ʽΪ[,] 
    {
        String str="(";
        if (this.n()!=0)
        {
            for(int i=0; i<this.n()-1; i++)
                str += this.get(i).toString()+", ";
            str += this.get(this.n()-1).toString();
        }
        return str+")";
    }
*/
    //6.  ˳����ǳ���������
/*    public SeqList(SeqList<T> list)                      //ǳ�������췽��
    {
        this.element = list.element;                  //�������ø�ֵ��������������һ�����飬����
        this.len = list.len;
    }*/
    public SeqList(SeqList<T> list)                        //������췽��
    {
        this.len = list.len;                               //��list==null���׳��ն����쳣
        this.element = new Object[list.element.length];    //����һ������
        for (int i=0; i<list.element.length; i++)          //��������Ԫ�أ�O(n)
            this.element[i] = list.element[i];             //�������ã�û�д����¶���
//          this.element[i] = new T(list.element[i]);    //�﷨����ΪJavaû���ṩĬ�Ͽ������췽��
//      this.element[i] = new Object(list.element[i]);    //�﷨����ΪObjectû���ṩ�������췽�����ҹ��췽�����ܼ̳� 
    }
    public SeqList(T[] element)                           //���췽������������ָ��˳����ֵ�����
    {
        this.len = element.length;
        this.element = new Object[element.length];         //����һ������
        for (int i=0; i<element.length; i++)               //��������Ԫ�أ�O(n)
            this.element[i] = element[i];
    }

    //7 ˳���Ƚ����
    //�Ƚ�����˳����Ƿ���� ������Object���equals(obj)������O(n)
    public boolean equals(Object obj)
    {
        if (this==obj)
            return true;
        if (obj instanceof SeqList)
        {
            SeqList<T> list = (SeqList<T>)obj;
            if (this.length()==list.length())
            {
                for (int i=0; i<this.length(); i++)             //�Ƚ�ʵ�ʳ��ȵ�Ԫ�أ�������������
                    if (!(this.get(i).equals(list.get(i))))     //����ʱ��̬��
                        return false; 
                return true;
            }
        }
        return false;
    }

    //���µ�8�� 8.2.1 ˳�����
    
    //˳����ҹؼ���ΪkeyԪ�أ������״γ��ֵ�Ԫ�أ������Ҳ��ɹ�����-1
    //key����ֻ�����ؼ����������T���equals()�����ṩ�Ƚ϶�����ȵ�����
    public int indexOf(T key)
    {
        if (key!=null)
            for (int i=0; i<this.len; i++)
                if (this.element[i].equals(key))           //�������equals()�����Ƚ��Ƿ����
                    return i;
        return -1;                                         //�ձ�keyΪ�ն����δ�ҵ�ʱ
    }
    public T search(T key)                                 //���ң������״γ��ֵĹؼ���ΪkeyԪ��
    {
        int find=this.indexOf(key);
        return find==-1 ? null : (T)this.element[find];
    }
    public boolean contain(T key)                          //�ж����Ա��Ƿ�����ؼ���ΪkeyԪ��
    {
        return this.indexOf(key)>=0;                       //�Բ��ҽ������жϽ��
    }
    public void remove(T key)                              //ɾ���״γ��ֵĹؼ���ΪkeyԪ��
    {
        this.remove(this.indexOf(key));                    //����remove(int)����
    }  

    //�����ǵ�8�� 8.2.1 ˳�����ϰ��
    public int lastIndexOf(T key)                          //����Ԫ��key������λ�ã���δ�ҵ�����-1
    {
        if (key!=null)
            for (int i=this.len-1; i>=0; i--)
                if (this.element[i].equals(key))
                    return i;
        return -1;                                         //�ձ�keyΪ�ն����δ�ҵ�ʱ
    }

    public void removeAll(T key)                           //ɾ�����йؼ���ΪkeyԪ��
    {
        if (key!=null)
        {
            int i=0;
            while (i<this.len)
                if (this.element[i].equals(key))
                    this.remove(i);                        //ɾ��Ԫ�أ�this.len��1��i����
                else i++;
        }
    }
    
    public void replace(T x, T y)                          //���״γ��ֵ�Ԫ��x�滻Ϊy��O(n)
    {
        if (x!=null && y!=null)
        {
            int i = this.indexOf(x);                       //����x�״γ���λ��
            if (i==-1)
            this.element[i] = y;
        }
    }
    public void replaceAll(T x, T y)                       //������Ԫ��x�滻Ϊy
    {
        if (x!=null && y!=null)
            for (int i=0; i<this.len; i++)
                if (x.equals(this.element[i]))
                    this.element[i] = y;
    }

    //��10�£�10.2 ʵ�ֵ�����
    public java.util.Iterator<T> iterator()                //����Java����������
    {
        return new SeqIterator();
    }

    private class SeqIterator implements java.util.Iterator<T> //˽���ڲ��࣬ʵ�ֵ������ӿ�
    {
        int index=-1, succ=0;                              //��ǰԪ�غͺ��Ԫ�����
    
        public boolean hasNext()                           //���к��Ԫ�أ�����true
        {
            return this.succ<SeqList.this.len;   //SeqList.this.len���ⲿ�൱ǰʵ���ĳ�Ա����
        }

        public T next()                               //���غ��Ԫ�أ���û�к��Ԫ�أ�����null
        {
            T value = SeqList.this.get(this.succ);    //�����ⲿ��SeqList��ǰʵ���ĳ�Ա����
            if (value!=null)
            {
                this.index = this.succ++;
                return value;
            }
            throw new java.util.NoSuchElementException();  //�׳��޴�Ԫ���쳣
        }

        public void remove()                               //ɾ�������������ʾ�ļ��ϵ�ǰԪ��
        {
            if (this.index>=0 && this.index<SeqList.this.len)
            {
                SeqList.this.remove(this.index);           //�����ⲿ�൱ǰʵ���ĳ�Ա����
                                                           //ɾ����index��Ԫ�أ�����SeqList.this.len-1
                if (this.succ>0)//(this.index<this.succ)
                    this.succ--;
                this.index=-1;                             //���ò�������ɾ��
            }
            else throw new java.lang.IllegalStateException(); //�׳���Ч״̬�쳣
        }
    }//SeqIterator�ڲ������

    //ϰ��10
    public java.util.ListIterator<T> listIterator()        //����Java�б����������
    {
        return new SeqListIterator(0);
    }
    public java.util.ListIterator<T> listIterator(final int index) //����Java�б����������
    {
        if (index>=0 && index<this.len)
            return new SeqListIterator(index);
        else throw new IndexOutOfBoundsException("Index: "+index);
    }

    //˽���ڲ��࣬�̳�ʵ�ֵ������ӿڵ�SeqIterator�ڲ��࣬ʵ���б�������ӿ�
    private class SeqListIterator extends SeqIterator implements java.util.ListIterator<T>
    {
        public SeqListIterator(int index)
        {
            this.succ=index;
        }
        public boolean hasPrevious()                       //����ǰ��Ԫ�أ�����true
        {
            return this.succ!=0;
        }

        public T previous()                                //����ǰ��Ԫ��
        {
            T value = SeqList.this.get(this.succ-1);
            if (value!=null)
            {
                this.index = this.succ--;
                return value;
            }
            throw new java.util.NoSuchElementException();  //�׳��޴�Ԫ���쳣
        }
        
        public int nextIndex()                             //���غ��Ԫ�����
        {
            return this.succ;
        }
        public int previousIndex()                         //����ǰ��Ԫ�����
        {
            return this.succ-1;
        } 
        
        public void set(T x)                               //�����ϵ�ǰԪ���滻Ϊx
        {
            if (this.index>=0 && this.index<SeqList.this.len)
                SeqList.this.set(this.index, x);           //�����ⲿ�൱ǰʵ���ĳ�Ա����
            else throw new java.lang.IllegalStateException(); //�׳���Ч״̬�쳣
        }
        public void add(T x)                               //����Ԫ��x
        {
            SeqList.this.insert(this.succ, x);             //�����ⲿ�൱ǰʵ���ĳ�Ա����
            this.succ++;                                   //����Ԫ��Ϊ��ǰԪ��
        }
    }//SeqListIterator�ڲ������
}
/*
 ����   //��10��
    //˳�����ָ��Ԫ�أ������ҳɹ������״γ���λ�ã����򷵻�-1
    //���Ѱ��������е�value�����������۰���ҹؼ���Ϊkey��Ԫ�أ��ɱȽ�������comparatorָ������Ƚϴ�С�Ĺ���
    public int indexOf(T key, java.util.Comparator<? super T> comparator)
    {
        if (key!=null)
            for (int i=0; i<this.len; i++)
                if (this.element[i].equals(key))  //�������equals()�����Ƚ��Ƿ����
                    return i;
        return -1;                               //�ձ�xΪ�ն����δ�ҵ�ʱ
    }
}
*/
