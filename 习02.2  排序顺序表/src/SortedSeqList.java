//ϰ2.1 �����������˳���

//�����������˳����࣬�̳�˳����࣬T����ʵ��Comparable<T>�ӿڣ�֧�ֶ���Ƚϴ�С
public class SortedSeqList<T extends Comparable<T>> extends SeqList<T>
{
    public SortedSeqList()                       //Ĭ�Ϲ��췽��
    {
        super();                                 //���ø���Ĭ�Ϲ��췽����Ĭ�ϵ��ã���ʡ��
    }
    public SortedSeqList(int size)               //���췽��������ָ�������Ŀձ�
    {
        super(size);
    }
    
    //��elements���������ж�����빹������˳���
    public SortedSeqList(T[] element)            //�������������ǳ����
    {
        super();                                 //������˳������ø���Ĭ�Ϲ��췽����Ĭ�ϵ��ã���ʡ��
        for (int i=0; i<element.length; i++)
            this.insert(element[i]);             //���룬����ֵ�Ĵ�С��������λ��
    }
    //������췽��������˳���
    public SortedSeqList(SortedSeqList<T> list)
    {
        super(list);                             //���ø���ͬ�����Ĺ��췽��������ʡ��
    }       

    //���ظ����insert(i,x)�������������ͬû�и��Ǹ����insert(i,x)����
    public void insert(T x)                      //����ָ������Ĵ�С�����ں���λ��
    {
        if (x==null)
           return;                               //���ܲ���ն���
        int i=0;
        while (i<this.length() && x.compareTo(this.get(i))>0)     //Ѱ�Ҳ���λ��
            i++;
        super.insert(i, x);                      //���ø���insert(int i,T x)����������x���Ϊi
    }
    
    //��֧�ָ����insert(int i, T x)��append(T x)���������串�ǲ��׳��쳣��
    public void insert(int i, T x)
    {
        throw new UnsupportedOperationException("insert(int i, T x)"); //���಻֧�ָ÷���
    }
    public void append(T x)
    {
        throw new UnsupportedOperationException("append(T x)");    //���಻֧�ָ÷���
    }

    //���ظ����remove(T x)�������������ͬû�и��Ǹ����remove(T x)����
    public void remove(T x)                      //ɾ��ָ������δ�ҵ�ָ��Ԫ�أ���ɾ����O(n)
    {
        if (x==null)
           return;
        int i=0;
        while (i<this.length() && x.compareTo(this.get(i))>0)//Ѱ�Ҵ�ɾ��Ԫ��
            i++;
        if (i<this.length() && x.compareTo(this.get(i))==0)
            super.remove(i);                     //���ø���remove(i)������ɾ�����ΪiԪ��
    }

/*    //������췽������˳���list��������˳���ֱ�Ӳ�������
    public SortedSeqList(SeqList<T> list)
    {
        super();                                 //������˳������ø���Ĭ�Ϲ��췽����Ĭ�ϵ��ã���ʡ��
        for (int i=0; i<list.length(); i++)      //��list==null�����׳��ն����쳣
            this.insert(list.get(i));            //���룬����ֵ�Ĵ�С��������λ��
    } */
 
    //��9��ϰ��
    //ע�⣬����3������������������飬û�и��ƶ��󣬲�������ڹ��ö�������

    //������췽������˳���list��������˳�����˳�������������ֱ�Ӳ�������
    //��Ҫ����SeqList�ĳ�Ա�������������SeqList�ĳ�Ա����element��lenȨ��Ϊprotected
    public SortedSeqList(SeqList<T> list)
    {
        super(list);                             //����췽��������˳���δ����Ԫ�ض���
        for (int i=1; i<this.len; i++)
        {
            T temp=(T)this.element[i];
            int j;
            for (j=i-1; j>=0 && temp.compareTo((T)this.element[j])<0; j--)
                element[j+1] = element[j];
            element[j+1] = temp;
        }
    }

    //ϰ��9���鲢��������˳�����list�����н��鲢����ǰ����˳�����
    //this=this+list��һ�ι鲢�㷨
    //���ı�list˳�������J�Ķ�������ģ�ͣ��Զ����������ᵼ������C++�ظ��ͷŴ洢��Ԫ�ռ�����
    //��list==null���׳��ն����쳣
    public void merge(SortedSeqList<T> list)  
    {
        Object[] temp = this.element;
        this.element = new Object[(this.len+list.len)*2];  //���䵱ǰ˳�������
        int i=0, j=0, k=0;
        while (i<this.len && j<list.len)
            if (((T)temp[i]).compareTo((T)list.element[j])<=0)
                this.element[k++]=temp[i++];
            else
            	this.element[k++]=list.element[j++];

        while (i<this.len)
            this.element[k++]=temp[i++];
        while (j<list.len)
            this.element[k++]=list.element[j++];
        this.len+=list.len;
    }
    
    //ϰ��9������this��list�鲢�������˳������ı�this��list˳���һ�ι鲢�㷨
    public SortedSeqList<T> mergeWith(SortedSeqList<T> list)  
    {
        SortedSeqList<T> templist = new SortedSeqList<T>((this.len+list.len)*2);
        int i=0, j=0, k=0;
        while (i<this.len && j<list.len)
            if (((T)this.element[i]).compareTo((T)list.element[j])<=0)
                templist.element[k++]=this.element[i++];
            else
                templist.element[k++]=list.element[j++];

        while (i<this.len)
            templist.element[k++]=this.element[i++];
        while (j<list.len)
            templist.element[k++]=list.element[j++];
        templist.len=this.len+list.len;
        return templist;
    }
}

/*
//����,����    protected Comparable<T>[] element;                   //�������飬˽�г�Ա

*/