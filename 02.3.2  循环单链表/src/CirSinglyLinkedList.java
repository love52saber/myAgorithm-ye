//import java.util.Iterator;                       //����������ӿ�

//ѭ���������࣬ʵ�����Ա�ӿ�
public class CirSinglyLinkedList<T> //extends AbstractList<T> implements LList<T>
{
    public Node<T> head;                              //ͷָ�룬ָ��ѭ���������ͷ���

    public CirSinglyLinkedList()                      //Ĭ�Ϲ��췽���������ѭ��������
    {
        this.head = new Node<T>();                    //����ͷ���
        this.head.next = this.head;
    }
    public boolean isEmpty()                          //�ж�ѭ���������Ƿ��
    {
        return this.head.next==this.head;
    }
    
    public String toString()                          //����ѭ������������Ԫ�ص������ַ���
    {
        String str="(";
        Node<T> p = this.head.next;
        while (p!=this.head)                          //�����������ѭ�������ı���
        {
            str += p.data.toString();
            if (p!=this.head) 
                str += ", ";                          //�������һ�����ʱ��ӷָ���
            p = p.next;
        }
        return str+")";                               //�ձ���()
    }

    //ϰ��2
    //��element�����еĶ�������쵥��������β���빹�쵥����
    public CirSinglyLinkedList(T[] element)
    {
        this();                                            //�����յ�����ֻ��ͷ���
        Node<T> rear=this.head;                            //rearָ���������һ�����
        for (int i=0; i<element.length; i++)               //��element==null���׳��ն����쳣
        {                                                  //��element.length==0�����������
            rear.next=new Node<T>(element[i], this.head);  //β���룬�����������rear���֮��
            rear = rear.next;                              //rearָ���µ���β���
        }
    }
    
    /*���ܣ���Ϊthis.headδ��ʼ��������null
    public CirSinglyLinkedList()                      //Ĭ�Ϲ��췽���������ѭ��������
    {
        this.head = new Node<T>(null, this.head);     //����ͷ���
    }*/

    public int length()                               //����ѭ���������ȣ�����������㷨��O(n)    
    {
        int i=0; 
        for (Node<T> p=this.head.next;  p!=this.head;  p=p.next)
            i++;
        return i;
    }
    
    public T get(int i)                  //���ص�i����0����Ԫ�أ���i<0����ڱ��򷵻�null��O(n)
    {
        if (i>=0)
        {
            Node<T> p=this.head.next;
            for (int j=0; p!=this.head && j<i; j++)
                p = p.next;
            if (p!=this.head)
                return p.data;                             //pָ���i�����
        }
        return null;                                       //��i<0����ڱ�ʱ
    }
   
    //���õ�i����0����Ԫ��ֵΪx����i<0����ڱ����׳����Խ���쳣����x==null����������O(n)
    public void set(int i, T x)
    {
        if (x==null)  return;                              //�������ÿն���
        Node<T> p=this.head.next;
        for (int j=0; p!=this.head && j<i; j++)
            p = p.next;
        if (i>=0 && p!=this.head)
            p.data = x;                                    //pָ���i�����
        else throw new IndexOutOfBoundsException(i+"");    //�׳����Խ���쳣
    }

    //���·���������ѭ����������в���
    public CirSinglyLinkedList(CirSinglyLinkedList<T> list)//ѭ��������������췽��
    {
        this();                                            //������ѭ��������ֻ��ͷ���       
        Node<T> rear = this.head;
        for (Node<T> p=list.head.next;  p!=list.head;  p=p.next)
        {
            rear.next = new Node<T>(p.data, this.head);
            rear = rear.next; 
        }
//      rear.next = this.head;
    }
    public CirSinglyLinkedList(SinglyLinkedList<T> list)   //������Ե�����list����ѭ��������
    {
        this();                                            //������ѭ��������ֻ��ͷ���
        Node<T> rear = this.head;
        for (Node<T> p=list.head.next;  p!=list.head;  p=p.next)
        {
            rear.next = new Node<T>(p.data, this.head);
            rear = rear.next; 
        }
    }
}
  
