//2.4   ���Ա��Ӧ�ã�����ʽ�ı�ʾ������
//2.4.1   һԪ����ʽ�ı�ʾ������

//����ʽ���������࣬�̳����������࣬�ṩ��������Ķ���ʽ������㣬
//Ҫ���Ͳ���Tʵ��java.lang.Comparable�ɱȽϽӿں�Addible����ӽӿ�
public class PolySLinkedList<T extends Comparable<T> & Addible<T>> extends SortedSinglyLinkedList<T>
{
    public PolySLinkedList()                               //Ĭ�Ϲ��췽��
    {
        super();                                           //�����յ�����ִ����������Ĭ�Ϲ��췽��
    }
    public PolySLinkedList(T terms[])                      //��������ָ������ʽ����ֵ
    {
        super(terms);
    }
    public PolySLinkedList(PolySLinkedList<T> polylist)    //������췽��
    {
        super(polylist);                                   //������������������н�㣬û�и���Ԫ�ض���
    }
       
    public void add(PolySLinkedList<T> polylist)           //����ʽ��ӣ�this��=polylist
    {
        Node<T> front=this.head, p=front.next;
        Node<T> q=polylist.head.next;
        while (p!=null && q!=null)
            if (p.data.compareTo(q.data)==0)               //�����С��ͬ
            {
                p.data.add(q.data);                        //������ӣ�add()������Addible�ӿ�Լ��
                if (p.data.removable())                    //��Ӻ�Ԫ������ɾ������
                {                                          //removable()������Addible�ӿ�Լ��
                    front.next=p.next;                     //��Ӻ�Ԫ�ز���Ҫ�洢��ɾ��p���
                    p=front.next;
                }
                else 
                {
                    front = p;                             //front��p��ǰ�����
                    p = p.next;
                }
                q = q.next;
            }
            else if (p.data.compareTo(q.data)<0)
                 {
                     front = p;       
                     p = p.next;
                 }
                 else
                 {
                     front.next = new Node<T>(q.data, p);  //����q��㲢���뵽front���֮��
                     q = q.next;
                 }
        while (q!=null)                                    //��polylist��������ʣ���㸴�Ʋ����뵽��ǰ����β
        {
            front.next = new Node<T>(q.data, null);
            front = front.next;
            q = q.next;
        }
    }
}
/* 
public void insert(Term term)                          //������
{
    list.insert(term);                                 //�����������в����㣬����λ����term��ָ������
}*/
/*
//��2�� ����ʽ����㷨
public Polynomial plus(Polynomial pol)                 //�ӷ�����C=this��pol
{
    Polynomial cpol = new Polynomial();
    Node<Term> p=this.list.head.next;            
    Node<Term> q=pol.list.head.next;
    Node<Term> rear=cpol.list.head;
    while (p!=null && q!=null)
    {
        if (p.data.compareTo(q.data)==0)               //����ָ����ͬʱ
        {
            double sum=p.data.coef + q.data.coef;      //����ϵ�����
            if (Math.abs(sum)>0.00001)                 //�������Ƿ�Ϊ0�ɾ���ȷ��
            {
                rear.next=new Node<Term>(new Term(sum, p.data.exp), null);//���������ӷ�0ϵ�����
                rear=rear.next;
            }
            p = p.next;
            q = q.next;
        }
        else if (p.data.compareTo(q.data)<0)
        {
            rear.next = new Node<Term>(p.data, null);  //����p��㲢���뵽rear���֮��
            rear=rear.next;
            p = p.next;
        }
        else
        {
            rear.next = new Node<Term>(q.data, null);  //����q��㲢���뵽rear���֮��
            rear=rear.next;
            q = q.next;
        }
    }
    if (p==null)
        p=q;
    while (p!=null)                                    //����ǰ�����pol������ʣ���㸴�Ʋ����뵽cpol����β
    {
        rear.next = new Node<Term>(p.data, null);
        rear=rear.next;
        p = p.next;
    }
    return cpol;  
}
    public PolySLinkedList<T> plus(PolySLinkedList<T> polylist)    //�ӷ�����C=this��polylist
    {
    	PolySLinkedList<T> polyc=new PolySLinkedList<T>(this);   //���
        polyc.add(polylist);
        return polyc;                                      //���ض�������
    }*/
