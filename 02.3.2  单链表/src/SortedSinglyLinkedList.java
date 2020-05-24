//����2.4��  ��������������ĵ�����

//����������ĵ������࣬�̳е������࣬T����ʵ��Comparable<T>�ӿڣ�֧�ֶ���ɱȽϴ�С
public class SortedSinglyLinkedList<T extends Comparable<T>> extends SinglyLinkedList<T>
{
    public SortedSinglyLinkedList()                        //Ĭ�Ϲ��췽��
    {
        super();                                           //���ø���Ĭ�Ϲ��췽����Ĭ�ϵ��ã���ʡ��
    }
    
    //��elements���������ж�����빹������ĵ�����ֱ�Ӳ�������
    public SortedSinglyLinkedList(T[] element)
    {
        super();                                           //�����յ��������ø���Ĭ�Ϲ��췽����Ĭ�ϵ��ã���ʡ��
        for (int i=0; i<element.length; i++)               //��element==null���׳��ն����쳣
            this.insert(element[i]);                       //����һ����㣬����ֵ�Ĵ�С��������λ��
    }
    
    //����ֵΪx��㣬����xֵ��С�����ں���λ��
    //���ظ����insert(i,x)�������������ͬû�и��Ǹ����insert(i,x)����
    public void insert(T x)
    {
        if (x==null)
           return;                                         //���ܲ���ն���
        Node<T> front=this.head, p=front.next;             //front��p��ǰ�����
        while (p!=null && p.data.compareTo(x)<0)           //Ѱ�Ҳ���λ��
        {
            front = p;
            p = p.next;
        }
        front.next = new Node<T>(x, p);                    //������������front֮��p֮ǰ
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

    //ɾ���״γ��ֵ�ֵΪx��㣬��û�ҵ�ָ�������ɾ����O(n)
    //���ظ����remove(T x)�������������ͬû�и��Ǹ����remove(T x)����
    public void remove(T x)
    {
        if (x==null)
           return;
        Node<T> front=this.head, p=front.next;        //front��p��ǰ�����
        while (p!=null && p.data.compareTo(x)<0)      //Ѱ�Ҵ�ɾ���Ľ��
        {
            front = p;
            p = p.next;
        }
        if (p!=null && p.data.compareTo(x)==0)
            front.next = p.next;                      //ɾ��p���
    }

    //������췽�������Ƶ�����
    public SortedSinglyLinkedList(SortedSinglyLinkedList<T> list)
    {
        super(list);                             //���ø���ͬ�����Ĺ��췽��������ʡ��
    }   
    
    //ϰ��2����9�£�������췽�����ɵ�����list������������ֱ�Ӳ�������
/*    public SortedSinglyLinkedList(SinglyLinkedList<T> list)
    {
        super();                                 //�����յ�����
        for (Node<T> p=list.head.next;  p!=null;  p=p.next)
            this.insert(p.data);                 //����ֵ�Ĵ�С��������λ�ã���������������Ĳ��뷽��
    }*/

    
    //���µ�5�� 5.2.2 ˳����ң�ϡ������еĵ�������

    //˳����ҹؼ���ΪkeyԪ�أ������״γ��ֵ�Ԫ�أ������Ҳ��ɹ�����null
    //key����ֻ�����ؼ����������T���compareTo()�ṩ�Ƚ϶����С����ȵ�����
    //���Ǹ���SinglyLinkedList��ͬ������
    public T search(T key) 
    {
        if (key==null)
            return null;
        for (Node<T> p=this.head.next;  p!=null && p.data.compareTo(key)<=0;  p=p.next)
            if (p.data.compareTo(key)==0)        //��compareTo()�ṩ�Ƚ϶����С����ȵ�����
                return p.data;
        return null; 
    }

    //��9�£�������췽�����ɵ�����list������������ֱ��ѡ������
/*    //��3�����ÿ��Ѱ����Сֵ��㣬������ǰ�棬ͨ��ɾ���������㷽ʽʵ�ֽ���
    public SortedSinglyLinkedList(SinglyLinkedList<T> list)
    {
        super(list);                                       //���list������
        Node<T> srear=head;                                //ָ����������β
        while (srear.next!=null)                           //ԭ��������
        {
            Node<T> mfront=srear, min=mfront.next;         //minָ����Сֵ��㣬mfrontָ��min��ǰ��
            Node<T> pfront=min, p=min.next;                //p����������pfrontָ��p��ǰ�����
            while (p!=null)
            {
                if (p.data.compareTo(min.data)<0)          //�Ƚϣ�min��ס��Сֵ���
                {   mfront = pfront;                       //mfront��min��ǰ�����
                    min = p;
                }
                pfront = p;                                //pfront��p��ǰ�����
                p = p.next;
            }  
            if (mfront!=srear)
            {
                mfront.next = min.next;                    //������ԭλ��ɾ��min���
                min.next=srear.next;                       //��min������srear֮��
                srear.next = min;
            }
            srear = min;                                   //srearָ����������β 
        }
    }*/
    
    //��9�£�������췽�����ɵ�����list������������ֱ��ѡ������
    //��4��Ľ�����n-1�ˣ�ÿ�˱���������Ѱ�ҵ���Сֵ��㣬�������Ԫ�ص�ǰ�棬��ɾ���Ͳ�����
    public SortedSinglyLinkedList(SinglyLinkedList<T> list)
    {
        super(list);                                       //���list������
        for (Node<T> first=head.next;  first!=null;  first=first.next) //firstָ������������һ�����  
        {                              //n-1�ˣ�ÿ�˱���������Ѱ�ҵ���Сֵ��㣬�������Ԫ�ص�ǰ��
            Node<T> min=first;                             //minָ����Сֵ���
            for (Node<T> p=min.next;  p!=null;  p=p.next)  //����������һ�ˣ��ҳ���Сֵ���
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

    //��9�£��鲢��������ĵ�������list�����н��鲢����ǰ���������У��ϲ�������listΪ��
    public void merge(SortedSinglyLinkedList<T> list)  
    {
        Node<T> front=this.head, p=front.next;   //pָ��this������ĵ�һ�����
        Node<T> q=list.head.next;                //qָ��list������ĵ�һ�����
        while (p!=null && q!=null)
            if ((p.data).compareTo(q.data)<0)    //�Ƚ�����������ǰ���ֵ
            {
                front = p;                       //frontָ��p��ǰ�����
                p = p.next;
            }
            else
            {                                    //��q�����뵽front���֮��
                front.next = q;
                q = q.next;
                front = front.next;
                front.next = p;
            }
        if (q!=null)                             //��list������ʣ���㲢�뵱ǰ����β
            front.next=q;
        list.head.next=null;                     //����list����������Ϊ������
    }
}
