
//�����������ѭ��˫�����࣬�̳�ѭ��˫�����࣬E����ʵ��Comparable<T>�ӿڣ�֧�ֶ���ɱȽϴ�С
public class SortedDoublyLinkedList<T extends Comparable<T>> extends CirDoublyLinkedList<T>
{
    public SortedDoublyLinkedList()              //Ĭ�Ϲ��췽���������ѭ��˫����
    {
        super();                                 //���ø���Ĭ�Ϲ��췽���������ѭ��˫����Ĭ�ϵ��ã���ʡ��
    }
    public SortedDoublyLinkedList(T[] element)   //�����������ж�����빹����������
    {
        super();
        for (int i=0; i<element.length; i++)
            this.insert(element[i]);             //���룬����ֵ�Ĵ�С��������λ��
    }
    
    public void insert(T x)                      //����ָ������Ĵ�С�����ں���λ��
    {
        if (x==null)  return;                    //���ܲ���ն���
        if (this.head.pred!=head && this.head.pred.data.compareTo(x)<0)
        {                                        //���ֵ������ͷ���֮ǰ������������β��O(1)
            DLinkNode<T> q = new DLinkNode<T>(x, head.pred, head); 
            head.pred.next = q;
            head.pred = q;
        }
        DLinkNode<T> p=this.head.next;
        while (p!=head && p.data.compareTo(x)<0)           //Ѱ�Ҳ���λ��
            p = p.next;
        DLinkNode<T> q = new DLinkNode<T>(x, p.pred, p);   //������p���֮ǰ
        p.pred.next = q;
        p.pred = q;
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

    public void remove(T x)                      //ɾ���״γ��ֵ�ֵΪx��㣬��û�ҵ�ָ�������ɾ����O(n)
    {
        if (x==null)
           return;
        DLinkNode<T> p=this.head.next;
        while (p!=head && p.data.compareTo(x)<0) //��p��λ����ɾ���Ľ��
            p = p.next;
        if (p!=head && p.data.compareTo(x)==0)
        {
            p.pred.next = p.next;                //ɾ��p����Լ�
            p.next.pred = p.pred;
        }
    }
    
    //������췽������������˫����list
    public SortedDoublyLinkedList(SortedDoublyLinkedList<T> list)
    {
        super(list);                             //���ø���ͬ�����Ĺ��췽��������ʡ��
    }   

    //ϰ��2
    //������췽�����ɵ�����list��������ѭ��˫����ֱ�Ӳ��������㷨ͬ�ɵ���������������
    public SortedDoublyLinkedList(SinglyLinkedList<T> list)
    {
        super();                                           //������ѭ��˫����
        for (Node<T> p=list.head.next;  p!=null;  p=p.next)
            this.insert(p.data);                           //���룬����ֵ�Ĵ�С��������λ��
    }

    //������췽������ѭ��������list��������ѭ��˫����
    //�㷨������insert(x)��������˫������ĳ�����p��ʼ���Ҳ���λ�ã��������ֵ�ϴ���p����ߣ�������ǰ�ߡ�
    public SortedDoublyLinkedList(CirSinglyLinkedList<T> list)
    {
        super();                                           //������ѭ��˫����
        DLinkNode<T> p=this.head;
        for (Node<T> q=list.head.next;  q!=list.head;  q=q.next)//����q.data������ֵ�Ĵ�С��������λ��
        {   //��list�������н������������Ʋ��뵽this�������У�����q.dataֵ�Ĵ�С��������λ��
            DLinkNode<T> t;
            if (p!=this.head && q.data.compareTo(p.data)>0)
            {   while (p!=this.head && q.data.compareTo(p.data)>0)   //q.data�ϴ�p�����
                    p=p.next;
                t = new DLinkNode<T>(q.data, p.pred, p);             //t������p���֮ǰ
                p.pred.next = t;
                p.pred = t;
            }
            else
            {   while (p!=this.head && q.data.compareTo(p.data)<0)   //q.data��С��p��ǰ��
                    p=p.pred;
                t = new DLinkNode<T>(q.data, p, p.next);             //t������p���֮��
                p.next.pred = t;
                p.next = t;
            }
            p=t;
//            System.out.println(this.toString()+"��p="+p.data.toString());        
        }
    }
   
    //ϰ��9��������췽������ѭ��˫����list��������ѭ��˫����ֱ��ѡ������ɾ���ٲ����㷨
/*    public SortedDoublyLinkedList(CirDoublyLinkedList<T> list)
    {
        super(list);                                       //���listѭ��˫����
        DLinkNode<T> srear=head;                           //ָ������ѭ��˫����β
        while (srear.next!=head)                           //ԭѭ��˫������
        {
            DLinkNode<T> min=srear.next;                   //minָ����Сֵ���
            for (DLinkNode<T> p=min.next;  p!=head;  p=p.next) //p����ѭ��˫����
                if (p.data.compareTo(min.data)<0)          //�Ƚϣ�min��ס��Сֵ���
                    min = p;
            if (min.pred!=srear)
            {
                min.pred.next = min.next;                  //������ԭλ��ɾ��min���
                min.next.pred = min.pred;
                min.next=srear.next;                       //��min������srear֮��
                min.pred=srear;
                srear.next.pred = min;
                srear.next = min;
            }
            srear = min;                                   //srearָ������ѭ��˫����β
        }
    }*/
    
    //ϰ��9��������췽������ѭ��˫����list��������ѭ��˫����ֱ��ѡ�����򣬽���Ԫ���㷨
    //n-1�ˣ�ÿ�˱���������Ѱ�ҵ���Сֵ��㣬�������Ԫ�ص�ǰ�棬��ɾ���Ͳ����㡣�㷨ͬ��������
    public SortedDoublyLinkedList(CirDoublyLinkedList<T> list)
    {
        super(list);                                       //���listѭ��˫����
        for (DLinkNode<T> first=head.next;  first!=head;  first=first.next) //firstָ�������˫�����һ�����  
        {                              //n-1�ˣ�ÿ�˱���˫����Ѱ�ҵ���Сֵ��㣬�������Ԫ�ص�ǰ��
            DLinkNode<T> min=first;                        //minָ����Сֵ���
            for (DLinkNode<T> p=min.next;  p!=head;  p=p.next) //p����ѭ��˫����һ�ˣ��ҳ���Сֵ���
                if (p.data.compareTo(min.data)<0)          //�Ƚϣ�min��ס��Сֵ���
                    min = p;
            if (min!=first)                                //����min���Ԫ�ص�ǰ��
            {
                T temp = min.data;
                min.data = first.data;
                first.data = temp;
            }
            System.out.println(this.toString());
        }
    }
    
    //ϰ��9���鲢��������ѭ��˫������list�����н��鲢����ǰ����ѭ��˫�����У��ϲ�������listΪ��
    public void merge(SortedDoublyLinkedList<T> list)  
    {
        DLinkNode<T> p=this.head.next;
        DLinkNode<T> q=list.head.next;
        while (p!=this.head && q!=list.head)
            if ((p.data).compareTo(q.data)<0)         //�Ƚ���������ǰ���ֵ
                p = p.next;
            else
            {                                         //��q�����뵽���֮ǰ
                q.pred = p.pred;
                p.pred.next = q;
                p.pred = q;
                q = q.next;
                q.pred.next = p;
            }
        if (q!=list.head)                             //��list������ʣ���㲢�뵱ǰ����β
        {
            this.head.pred.next = q;
            q.pred = this.head.pred;
            while (q.next!=list.head)
                q = q.next;
            q.next = this.head;
            this.head.pred = q;
        }
        list.head.next=list.head;                     //�ϲ�������listΪ��
        list.head.pred=list.head;
    }
}