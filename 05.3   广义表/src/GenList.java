//5.3   �����
//5.3.2   �����Ĵ洢�ṹ
//2.  ������˫����ʾ

//û�б���
public class GenList<T> implements GGenList<T>    //˫����ʾ�Ĺ������
{
    public GenListNode<T> head;                            //ͷָ�룬ָ�����ã�ͷ���

    public GenList()                                       //����չ����
    {
        this.head = new GenListNode<T>();                  //����ͷ��㣬3����ֵ��Ϊnull
    }

    //���������������ṩԭ�ӳ�ֵ��������������Ԫ�ش�����ͬ������β���빹�죬�㷨ͬ������
    public GenList(T[] atoms)
    {
        this();                                            //�����չ����ֻ��ͷ���
        GenListNode<T> rear=this.head;
        for (int i=0; i<atoms.length; i++)
        {
            rear.next=new GenListNode<T>(atoms[i]);        //β����
            rear = rear.next; 
        }
    }
    
    public boolean isEmpty()                               //�жϹ�����Ƿ��
    {
        return head.next==null;
    }

    public String toString()                               //���ع��������Ԫ�ص������ַ���
    {
        return this.toString("");
    }
    //���ع��������Ԫ��ֵ��Ӧ���ַ�������ʽΪ��(,)�������������㷨���ݹ鷽��
    public String toString(String str) 
    {
        str+="(";
        for (GenListNode<T> p=this.head.next;  p!=null;  p=p.next) 
        {
            if (p.child==null)
                str += p.data.toString();
            else
                str += p.child.toString();                 //�ݹ���ã������ӱ�����ӱ������ַ���
            if (p.next!=null) 
                str += ",";
        }
        return str+")";                                    //�ձ���()
    }

    public int length()                                    //���ع�����ȣ��㷨ͬ������
    {
        int i=0; 
        for (GenListNode<T> p=this.head.next;  p!=null;  p=p.next)
            i++;
        return i;
    }
    
    public int depth()                                     //���ع������ȣ��ݹ鷽��
    {
        int max=1;
        for (GenListNode<T> p=this.head.next;  p!=null;  p=p.next)
            if (p.child!=null)
            {
                int d=p.child.depth();                     //�ݹ���ã������ӱ����
                if (max<=d)                                //��ס����ӱ����
                    max=d+1;                               //��ǰ��������Ϊ�ӱ���ȼ�1
            }
        return max;
    }
    
    public GenListNode<T> insert(int i, T x)               //����ԭ��x��Ϊ��i��Ԫ�أ��㷨ͬ������
    {
        if (x==null)
            return null;                                   //���ܲ���ն���
        GenListNode<T> p=this.head;
        for (int j=0; p.next!=null && j<i; j++)            //Ѱ�Ҳ���λ��
            p = p.next; 
        p.next=new GenListNode<T>(x, null, p.next);        //������p���֮�󣬰���ͷ���롢�м����
        return p.next;
    }
    
    public GenListNode<T> insert(int i, GenList<T> glist)  //�����ӱ���Ϊ��i��Ԫ�أ��㷨ͬ�����������
    {
        if (glist==null)
            return null;                                   //���ܲ���ն���
        GenListNode<T> p=this.head;
        for (int j=0; p.next!=null && j<i; j++)
            p = p.next; 
        p.next=new GenListNode<T>(null, glist, p.next);
        return p.next;
    }
    
    public void append(T x)                                //�ڹ����������ԭ�ӽ�㣬�㷨ͬ������
    {
        insert(Integer.MAX_VALUE, x);
    }
    public void append(GenList<T> glist)                   //�ڹ�����������ӱ�
    {
        insert(Integer.MAX_VALUE, glist);
    }
    public void remove(int i)                         //ɾ����i��Ԫ��
    {}
   
//    void removeAll();                            //ɾ�����������Ԫ��
    
}
