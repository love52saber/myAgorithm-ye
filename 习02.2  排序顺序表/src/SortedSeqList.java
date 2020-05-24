//习2.1 按升序排序的顺序表。

//按升序排序的顺序表类，继承顺序表类，T必须实现Comparable<T>接口，支持对象比较大小
public class SortedSeqList<T extends Comparable<T>> extends SeqList<T>
{
    public SortedSeqList()                       //默认构造方法
    {
        super();                                 //调用父类默认构造方法，默认调用，可省略
    }
    public SortedSeqList(int size)               //构造方法，创建指定容量的空表
    {
        super(size);
    }
    
    //将elements数组中所有对象插入构造排序顺序表
    public SortedSeqList(T[] element)            //数组深拷贝，对象浅拷贝
    {
        super();                                 //创建空顺序表，调用父类默认构造方法，默认调用，可省略
        for (int i=0; i<element.length; i++)
            this.insert(element[i]);             //插入，根据值的大小决定插入位置
    }
    //深拷贝构造方法，复制顺序表
    public SortedSeqList(SortedSeqList<T> list)
    {
        super(list);                             //调用父类同参数的构造方法，不可省略
    }       

    //重载父类的insert(i,x)方法，因参数不同没有覆盖父类的insert(i,x)方法
    public void insert(T x)                      //根据指定对象的大小插入在合适位置
    {
        if (x==null)
           return;                               //不能插入空对象
        int i=0;
        while (i<this.length() && x.compareTo(this.get(i))>0)     //寻找插入位置
            i++;
        super.insert(i, x);                      //调用父类insert(int i,T x)方法，插入x序号为i
    }
    
    //不支持父类的insert(int i, T x)和append(T x)方法，将其覆盖并抛出异常。
    public void insert(int i, T x)
    {
        throw new UnsupportedOperationException("insert(int i, T x)"); //本类不支持该方法
    }
    public void append(T x)
    {
        throw new UnsupportedOperationException("append(T x)");    //本类不支持该方法
    }

    //重载父类的remove(T x)方法，因参数不同没有覆盖父类的remove(T x)方法
    public void remove(T x)                      //删除指定对象，未找到指定元素，不删除，O(n)
    {
        if (x==null)
           return;
        int i=0;
        while (i<this.length() && x.compareTo(this.get(i))>0)//寻找待删除元素
            i++;
        if (i<this.length() && x.compareTo(this.get(i))==0)
            super.remove(i);                     //调用父类remove(i)方法，删除序号为i元素
    }

/*    //深拷贝构造方法，由顺序表list构造排序顺序表，直接插入排序
    public SortedSeqList(SeqList<T> list)
    {
        super();                                 //创建空顺序表，调用父类默认构造方法，默认调用，可省略
        for (int i=0; i<list.length(); i++)      //若list==null，将抛出空对象异常
            this.insert(list.get(i));            //插入，根据值的大小决定插入位置
    } */
 
    //第9章习题
    //注意，以下3方法，深拷贝仅复制数组，没有复制对象，操作后存在共用对象问题

    //深拷贝构造方法，由顺序表list构造排序顺序表，对顺序表对象数组进行直接插入排序
    //需要访问SeqList的成员变量，因此设置SeqList的成员变量element和len权限为protected
    public SortedSeqList(SeqList<T> list)
    {
        super(list);                             //深拷构造方法，复制顺序表，未复制元素对象
        for (int i=1; i<this.len; i++)
        {
            T temp=(T)this.element[i];
            int j;
            for (j=i-1; j>=0 && temp.compareTo((T)this.element[j])<0; j--)
                element[j+1] = element[j];
            element[j+1] = temp;
        }
    }

    //习题9，归并两条排序顺序表，将list中所有结点归并到当前排序顺序表中
    //this=this+list，一次归并算法
    //不改变list顺序表。由于J的对象引用模型，自动析构，不会导致类似C++重复释放存储单元空间问题
    //若list==null，抛出空对象异常
    public void merge(SortedSeqList<T> list)  
    {
        Object[] temp = this.element;
        this.element = new Object[(this.len+list.len)*2];  //扩充当前顺序表容量
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
    
    //习题9，返回this和list归并后的排序顺序表，不改变this和list顺序表，一次归并算法
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
//不行,两个    protected Comparable<T>[] element;                   //对象数组，私有成员

*/