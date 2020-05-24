//2.3.3   ˫����
//3. ѭ��˫����
//public class CirDoublyLinkedList<T> implements LList<T>    //ѭ��˫������
public class CirDoublyLinkedList<T> extends AbstractLList<T> implements LList<T>//��10�£�10.2 ʵ�ֵ����� 
{
    public DLinkNode<T> head;                    //ͷָ��

    public CirDoublyLinkedList()                 //Ĭ�Ϲ��췽���������ѭ��˫����
    {
        this.head = new DLinkNode<T>();          //����ͷ��㣬3����ֵ��Ϊnull
        this.head.pred = head;
        this.head.next = head;
    }
    public boolean isEmpty()                     //�ж�ѭ��˫�����Ƿ��
    {
        return head.next==head;
    }

    //���³�Ա�����Ĺ���ͬ�������㷨�в��
    
    //�����i����0����Ԫ��ֵΪx����x==null�������롣
    //��i<0������x��Ϊ��0��Ԫ�أ���i���ڱ�������x��Ϊ���һ��Ԫ�ء�O(n)
    public void insert(int i, T x)                         //��x������������Ϊi��㣬O(n)
    {
        if (x==null)  return;                              //���ܲ���ն���
        DLinkNode<T> p=this.head;
        for (int j=0; p.next!=this.head && j<i; j++)       //Ѱ�Ҳ���λ��
            p = p.next;                                    //ѭ��ֹͣʱ��pָ���i-1�����
        DLinkNode<T> q=new DLinkNode<T>(x, p, p.next);     //������p���֮�󣬰���ͷ���롢�м����
        p.next.pred = q;
        p.next = q;
    }
    public void append(T x)                                //��ѭ��˫���������ӽ�㣬O(1)
    {
        if (x==null)  return;                              //������ӿն���
        DLinkNode<T> q = new DLinkNode<T>(x, head.pred, head); 
        head.pred.next = q;                                //������ͷ���֮ǰ���൱��β����
        head.pred = q;
    }
    
    //ɾ����i����0����Ԫ�أ����ر�ɾ��������i<0��i���ڱ�����ɾ��������null��O(n)
    public T remove(int i)
    {
        if (i>=0)
        {
            DLinkNode<T> p=this.head.next;
            for (int j=0; p!=head && j<i; j++)             //��λ����ɾ�����
                p = p.next;
            if (p!=head)
            {
                T old = p.data;                            //���ԭ����
                p.pred.next = p.next;                      //ɾ��p����Լ�
                p.next.pred = p.pred;
                return old;
            }
        }
        return null;                                       //��i<0����ڱ�ʱ
//        throw new IndexOutOfBoundsException(i+"");         //�׳����Խ���쳣
    }
    public void removeAll()                                //ɾ��ѭ��˫��������Ԫ��
    {
        this.head.pred = head;
        this.head.next = head;
    }
    
    //����toString()��length()��get(i)��set(i,x)��equals()����������������㷨ͬ���������ʡ��
    //ϰ��2
    public T get(int i)                          //���ص�i����0����Ԫ�أ���i<0����ڱ��򷵻�null��O(n)
    {
        if (i>=0)
        {
            DLinkNode<T> p=this.head.next;
            for (int j=0; p!=null && j<i; j++)
                p = p.next;
            if (p!=null)
                return p.data;                             //pָ���i�����
        }
        return null;                                       //��i<0����ڱ�ʱ
    }
    
    //���õ�i����0����Ԫ��ֵΪx����i<0����ڱ����׳����Խ���쳣����x==null����������O(n)
    public void set(int i, T x)
    {
        if (x==null)  return;                              //��������Ԫ��Ϊ�ն���
        DLinkNode<T> p=this.head.next;
        for (int j=0; p!=null && j<i; j++)
            p = p.next;
        if (i>=0 && p!=null)
            p.data = x;                                    //pָ���i�����
        else throw new IndexOutOfBoundsException(i+"");    //�׳����Խ���쳣
    }
    
    public int length()                                    //����ѭ��˫������
    {
        int i=0; 
        for (DLinkNode<T> p=this.head.next;  p!=this.head;  p=p.next)//ѭ�������뵥����ͬ
            i++;
        return i;
    }   
    
    public String toString()    //����ѭ��˫��������Ԫ�ص������ַ�����ѭ��˫��������㷨��O(n)
    {
        String str="(";
        for (DLinkNode<T> p=this.head.next;  p!=this.head;  p=p.next)
        {
            str += p.data.toString();
            if (p.next!=this.head) 
                str += ",";
        }
        return str+")";                               //�ձ���()
    }

    //��ָ�������еĶ��������ѭ��˫��������β���빹��ѭ��˫����
    public CirDoublyLinkedList(T[] element)
    {
        this();                                  //������ѭ��˫����ֻ��ͷ���
        DLinkNode<T> rear=this.head;
        for (int i=0; i<element.length; i++)
        {
            rear.next=new DLinkNode<T>(element[i], rear, this.head);   //β����
            rear = rear.next; 
        }
        this.head.pred = rear;
    }
    
    //�Ƚ�����ѭ��˫�����Ƿ���ȣ�����Object���equals(obj)����
    public boolean equals(Object obj)
    {
        if (obj == this)
            return true;
        if (!(obj instanceof CirDoublyLinkedList))
            return false;
        DLinkNode<T> p=this.head.next;
        CirDoublyLinkedList<T> list = (CirDoublyLinkedList<T>)obj;
        DLinkNode<T> q=list.head.next;
        while (p!=head && q!=list.head && p.data.equals(q.data))
        {
            p=p.next;
            q=q.next;
        }
        return p==head && q==list.head;
    }

    //������췽��������ѭ��˫����
    public CirDoublyLinkedList(CirDoublyLinkedList<T> list)
    {
        this();                                  //������ѭ��˫����ֻ��ͷ���
        DLinkNode<T> rear = this.head;
        for (DLinkNode<T> p=list.head.next;  p!=list.head;  p=p.next)
        {
            rear.next = new DLinkNode<T>(p.data, rear, this.head);
            rear = rear.next; 
        }
        this.head.pred = rear;
    }
    
    //��8��
    //˳����ҹؼ���ΪkeyԪ�أ������״γ��ֵ�Ԫ�أ������Ҳ��ɹ�����null
    //key����ֻ�����ؼ����������T���equals()�����ṩ�Ƚ϶�����ȵ�����
    public T search(T key) 
    {
        if (key==null)
            return null;
        for (DLinkNode<T> p=this.head.next;  p!=this.head;  p=p.next)
            if (key.equals(p.data))
                return p.data;
        return null;
    }
    public boolean contain(T key)                          //�ж����Ա��Ƿ�����ؼ���ΪkeyԪ��
    {
        return this.search(key)!=null;                     //�Բ��ҽ������жϽ��
    }
    //����ʵ��LList�ӿ�

    //����Ϊѭ��˫�������ӵĳ�Ա����
    public void printPred()                                //���ѭ��˫�����Ӻ���ǰ����ǰ����
    {
        System.out.print("�Ӻ���ǰ����ǰ�������ѭ��˫����(");
        for (DLinkNode<T> p=this.head.pred; p!=this.head;  p=p.pred)
        {
            System.out.print(p.data.toString());
            if (p.pred!=this.head) 
                System.out.print(", ");
        }
        System.out.println(")");                           //�ձ���()
    }

    //ϰ��2
    //����4�������ṩ��������ѭ��˫����ʽ
    public DLinkNode<T> getFirst()               //����ѭ��˫�����һ����㣨��ͷ��㣩��O(1)
    {
        if (this.head.next==head)
            return null; 
        return this.head.next; 
    }
    public DLinkNode<T> getNext(DLinkNode<T> p)  //����p�ĺ�̽�㣬O(1)
    {
        if (this.head.next==head || p==null)
            return null;
        return p.next;
    }
    public DLinkNode<T> getPred(DLinkNode<T> p)  //����p��ǰ����㣬O(1)
    {
        if (this.head.next==head || p==null || this.head.next==p)
            return null;
        return p.pred;
    }
    public DLinkNode<T> getLast()                //����ѭ��˫�������һ����㣬O(1)
    {
        if (this.head.pred==head)
            return null;
        return this.head.pred;
    }
    
    //������췽�����ɵ�����list����ѭ��˫����
    public CirDoublyLinkedList(SinglyLinkedList<T> list)
    {
        this();
        DLinkNode<T> rear = this.head;
        for (Node<T> p=list.head.next;  p!=null;  p=p.next) 
        {
            rear.next = new DLinkNode<T>(p.data, rear, this.head);
            rear = rear.next; 
        }
        this.head.pred = rear;
    }    
    
    //������췽������ѭ��������list����ѭ��˫����
    public CirDoublyLinkedList(CirSinglyLinkedList<T> list)
    {
        this();
        DLinkNode<T> rear = this.head;
        for (Node<T> p=list.head.next;  p!=list.head;  p=p.next) 
        {
            rear.next = new DLinkNode<T>(p.data, rear, this.head);
            rear = rear.next; 
        }
        this.head.pred = rear;
    }    
    
    //ϰ��2���ӱ����
    //��listѭ��˫���������н�������ڵ�ǰѭ��˫����֮�󣬲�����listΪ��
    public void concat(CirDoublyLinkedList<T> list) 
    {
        DLinkNode<T> rear=head.pred; 
        rear.next = list.head.next;
        list.head.next.pred = rear;
        rear=list.head.pred;
        rear.next = this.head;
        this.head.pred = rear;
        list.head.pred = list.head; 
        list.head.next = list.head; 
    }

    //���شӵ�i(��0)����㿪ʼ������Ϊn(��0)���ӱ������
    //��i<0��n<0���׳��쳣����i>����n=0�����ؿ�������n��������������β���ӱ�
    public CirDoublyLinkedList<T> sub(int i, int n)
    {
        if (i<0)  throw new IndexOutOfBoundsException(i+"");    //�׳����Խ���쳣
        if (n<0)  throw new IllegalArgumentException(i+"");     //�׳���Ч�����쳣
        DLinkNode<T> p=this.head.next;
        for (int j=0;  j<i && p!=this.head;  j++)          //Ѱ���ӱ��׽��
            p = p.next;                                    //ѭ��ֹͣʱ��pָ���i��㡣��i>������p==this.head
        CirDoublyLinkedList<T> list=new CirDoublyLinkedList<T>();//��ѭ��˫����
        DLinkNode<T> rear=list.head;                       //�����ӱ�list����rear���֮��
        for (int j=0;  p!=this.head && j<n;  j++, p=p.next)
        {
            rear.next.pred = new DLinkNode<T>(p.data, rear, list.head);
            rear.next = rear.next.pred;
            rear=rear.next;
        }
        return list;                                       //���ض�������
    }

    //�����ӱ����������listѭ��˫�����е����н�㸴�Ʋ��뵽��ǰѭ��˫����front���֮��
    public void insert(DLinkNode<T> front, CirDoublyLinkedList<T> list)
    {
        for (DLinkNode<T> q=list.head.next;  q!=list.head;  q=q.next)
        {
            front.next.pred = new DLinkNode<T>(q.data, front, front.next);
            front.next = front.next.pred;
            front = front.next;
        }
    }  
    //�����ӱ����������listѭ��˫�����е����н�㸴�Ʋ��뵽��ǰѭ��˫�����i�����֮ǰ
    public void insert(int i, CirDoublyLinkedList<T> list)
    {
        DLinkNode<T> p=this.head;
        for (int j=0;  j<i && p.next!=this.head;  j++)     //Ѱ�Ҳ���λ��
            p = p.next;                                    //ѭ��ֹͣʱ��pָ���i-1�������һ�����
        this.insert(p,list);                               //���Ʋ���list����p���֮��
    }
    
    //��listѭ��˫���������н�㸴����ӵ���ǰѭ��˫�������
    public void append(CirDoublyLinkedList<T> list)
    {
        this.insert(this.head.pred, list);                  //���Ʋ���list������β���֮��
    }
    
    //ɾ���ӵ�i����0������㿪ʼ������Ϊn����1�����ӱ�
    //��i<0��n<0���׳��쳣����i>����n=0����ɾ������n������ɾ������β���ӱ�
    //�㷨���Ƶ�����
    public void remove(int i, int n)
    {
        if (i<0)  throw new IndexOutOfBoundsException(i+"");    //�׳����Խ���쳣
        if (n<0)  throw new IllegalArgumentException(i+"");     //�׳���Ч�����쳣
        DLinkNode<T> front=this.head.next;
        for (int j=0; j<i && front!=this.head; j++)        //Ѱ�Ҵ�ɾ���ӱ��׽���ǰ�����
            front = front.next;
        if (front==this.head)                              //iԽ�磬��ɾ��
            return;
        DLinkNode<T> p=front.next;
        for (int j=0;  j<n && p!=this.head;  j++)          //Ѱ�Ҵ�ɾ���ӱ�֮��Ľ��
            p = p.next; 
        front.next = p;                                    //ɾ��front��̽����pǰ�����֮����ӱ�
        p.pred = front; 
    }

    //����this�������׸���pattenƥ���ӱ���׽�㣬���Ҳ��ɹ�ʱ����null
    public DLinkNode<T> index(CirDoublyLinkedList<T> pattern)
    {
        return index(head.next, pattern);
    }
    //����this�������start��㿪ʼ�׸���patternƥ���ӱ���׽�㣬���Ҳ��ɹ�ʱ����null��BFģʽƥ��
    public DLinkNode<T> index(DLinkNode<T> start, CirDoublyLinkedList<T> pattern)
    {
        if (start==null || pattern.isEmpty())
            return null;
        DLinkNode<T> p=start, q=pattern.head.next;
        while (p!=this.head && q!=pattern.head)
        {
            if (p.data.equals(q.data))                     //�����Ƚ���һ�����
            {
                p=p.next;
                q=q.next;
            }
            else                                           //����
            {   start=start.next;                          //Ŀ���������¸��ӱ�
                p=start;
                q=pattern.head.next;                       //ģʽ���������ͷ
            }
        }
        if (q==pattern.head)                               //����ƥ����ӱ�
            return start;                                  //�����ӱ��׽���ַ
        return null; 
    } 
    
/*    //ɾ��������patternƥ����ӱ��㷨����index(pattern)���ҵ���ɾ����
    public void removeAll(CirDoublyLinkedList<T> pattern)
    {
        System.out.print("��"+this.toString()+"��"+pattern.toString()+"ȫ��ɾ��");
        DLinkNode<T> p=this.index(pattern);      //���ش�ͷ��㿪ʼ�׸���patternƥ���ӱ���׽��
                                                 //��patternΪ�գ�����null
        while (p!=null)
        {
            DLinkNode<T> q=pattern.head.next;
            while (q!=pattern.head)              //ɾ����p��ʼ��patternƥ����ӱ����ܵ���remove(i,n)������Ч�ʵ�
            {
                p.pred.next = p.next;            //ɾ��p��㣬��δ�ͷ�p��㣬p.next��p.pred��Ȼ��Ч
                p.next.pred = p.pred;
                p=p.next;                        //pָ��ɾ������ԭ��̽��
                q=q.next;
            }
            p=this.index(p,pattern);             //�ٴ�ƥ�䣬���ش�p��㿪ʼ�׸���patternƥ���ӱ���׽��
        }
        System.out.println("�Ľ����"+this.toString());
    }*/
    
    //��this���������׸���patternƥ����ӱ��滻Ϊdest�ӱ�
    //�㷨����replaceAll(pattern, dest)��ֻ��while��Ϊif��ֻ��һ��ƥ���滻
    public void replaceFirst(CirDoublyLinkedList<T> pattern, CirDoublyLinkedList<T> dest)
    {
        System.out.print("��"+this.toString()+"���׸�"+pattern.toString()+"�滻Ϊ"+dest.toString());
        DLinkNode<T> p=this.index(pattern);      //���ش�ͷ��ʼ�׸���patternƥ���ӱ���׽��
        if (p!=null)                             //ƥ��ɹ��������滻
        {
            DLinkNode<T> q=pattern.head.next;
            while (q!=pattern.head)              //ɾ����p��ʼ��patternƥ����ӱ�
            {
                p.pred.next = p.next;            //ɾ��p��㣬��δ�ͷ�p��㣬p.next��p.pred��Ȼ��Ч
                p.next.pred = p.pred;
                p=p.next;
                q=q.next;
            }
            p=p.pred;
            q=dest.head.next;
            while (q!=dest.head)                 //��dest�����н��������뵽��ǰ������p���֮��
            {
                p.next.pred = new DLinkNode<T>(q.data,p,p.next);  //��q���������뵽p���֮��
                p.next=p.next.pred;
                p=p.next;
                q=q.next;
            }
            p=p.next;
        }
        System.out.println("�Ľ����"+this.toString());    	
    }

    //��this��������������patternƥ����ӱ��滻Ϊdest�ӱ�
    //�㷨����index(pattern)���ҵ���ɾ���Ͳ��롣
/*    public void replaceAll(CirDoublyLinkedList<T> pattern, CirDoublyLinkedList<T> dest)
    {
        System.out.print("��"+this.toString()+"��"+pattern.toString()+"ȫ���滻Ϊ"+dest.toString());
        DLinkNode<T> p=this.index(pattern);      //���ش�ͷ��ʼ�׸���patternƥ���ӱ���׽��
        while (p!=null)                          //ƥ��ɹ�������һ���滻
        {
            DLinkNode<T> q=pattern.head.next;
            while (q!=pattern.head)              //ɾ����p��ʼ��patternƥ����ӱ�
            {
                p.pred.next = p.next;            //ɾ��p��㣬��δ�ͷ�p��㣬p.next��p.pred��Ȼ��Ч
                p.next.pred = p.pred;
                p=p.next;
                q=q.next;
            }
            p=p.pred;
            q=dest.head.next;
            while (q!=dest.head)                 //��dest�����н��������뵽��ǰ������p���֮��
            {
                p.next.pred = new DLinkNode<T>(q.data,p,p.next);  //��q���������뵽p���֮��
                p.next=p.next.pred;
                p=p.next;
                q=q.next;
            }
            p=p.next;
            p=this.index(p,pattern);             //�ٴ�ƥ�䣬���ش�p��㿪ʼ�׸���patternƥ���ӱ���׽��
        }
        System.out.println("�Ľ����"+this.toString());
    }*/

    //ɾ��������patternƥ����ӱ�BFģʽƥ���㷨���ҵ���ɾ����û�е���index(pattern)���㷨ͬ������
    public void removeAll(CirDoublyLinkedList<T> pattern)
    {
        System.out.print("��"+this.toString()+"��"+pattern.toString()+"ȫ��ɾ��");
        if (pattern.isEmpty())                             //���޴˾䣬����ѭ��������
            return;
        DLinkNode<T> start=this.head.next;
        while (start!=this.head)
        {
            DLinkNode<T> p=start, q=pattern.head.next;
            while (p!=this.head && q!=pattern.head && p.data.equals(q.data)) //һ��ƥ��
            {   p=p.next;
                q=q.next;
            }
            if (q!=pattern.head)                           //ƥ��ʧ�ܣ������´�ƥ��
                start=start.next;
            else                                           //ƥ��ɹ���ɾ����ƥ���ӱ�
            {   start.pred.next = p;
                p.pred = start.pred;
                start=p;
            }
        }
        System.out.println("�Ľ����"+this.toString());
    }    
    
    //��this��������������patternƥ����ӱ��滻Ϊdest�ӱ���destΪ��ʱ���൱��ɾ��ƥ���ӱ�
    //����BFģʽƥ�䡢ɾ��ƥ���ӱ����Ʋ����ӱ��㷨
    public void replaceAll(CirDoublyLinkedList<T> pattern, CirDoublyLinkedList<T> dest)
    {
        System.out.print("��"+this.toString()+"��"+pattern.toString()+"ȫ���滻Ϊ"+dest.toString()+"�Ľ����");
        if (pattern.isEmpty())                             //���޴˾䣬��dest���뵽start���֮�󣬴���
            return;
        DLinkNode<T> start=this.head.next;
        while (start!=this.head)                           //startָ��ÿ��ƥ�����ʼ���
        {
            DLinkNode<T> p=start, q=pattern.head.next;
            while (p!=this.head && q!=pattern.head && p.data.equals(q.data))//һ��ƥ��Ķ�αȽ�
            {   p=p.next;
                q=q.next;
            }
            if (q!=pattern.head)                           //ƥ��ʧ�ܣ������´�ƥ��
                start=start.next;
            else                                           //ƥ��ɹ����滻��ƥ���ӱ�
            {   start.pred.next = p;                       //ɾ����ƥ���ӱ�
                p.pred = start.pred;
                start=p;
                DLinkNode<T> d=dest.head.next;
                while (d!=dest.head)                       //��destʣ����������뵽this������p֮ǰ
                {   DLinkNode<T> t = new DLinkNode<T>(d.data, p.pred, p); 
                    p.pred.next = t;
                    p.pred = t;
                    d = d.next;
                }
            }
        }
        System.out.println(this.toString());
    }
    
    //��10��ϰ�⣬10.2 ʵ�ֵ�����
    public java.util.Iterator<T> iterator()                //����Java����������
    {
        return new DoublyIterator();
    }

    private class DoublyIterator implements java.util.Iterator<T> //˽���ڲ��࣬ʵ�ֵ������ӿ�
    {
        DLinkNode<T> current=CirDoublyLinkedList.this.head;//��ǰ���
        boolean removable=false;                           //�Ƿ��ɾ��״̬
//        DLinkNode<T> front=null;                           //��ǰ����ǰ�����

        public boolean hasNext()                           //���к��Ԫ�أ�����true
        {
            return //this.current!=CirDoublyLinkedList.this.head && 
                   this.current.next!=CirDoublyLinkedList.this.head;
        }

        public T next()                                    //���غ��Ԫ��
        {
            if (this.hasNext())
            {
                this.removable=true;
//                this.front = this.current;
                this.current = this.current.next;
                return this.current.data;
            }
            else throw new java.util.NoSuchElementException();  //�׳��޴�Ԫ���쳣
        }

        public void remove()                               //ɾ�������������ʾ�ļ��ϵ�ǰԪ��
        {
            if (this.removable)//(this.front!=null)
            {
                this.current.next.pred = this.current.pred;//ɾ����ǰ���
                this.current.pred.next = this.current.next;
                this.current = this.current.pred;
                this.removable=false;
//                this.front=null;                           //���ò�������ɾ��
            }
            else throw new java.lang.IllegalStateException(); //�׳���Ч״̬�쳣
        }
    }//DoublyIterator�ڲ������

    
    public java.util.ListIterator<T> listIterator()        //����Java�б����������
    {
        return new DoublyListIterator(0);
    }
    public java.util.ListIterator<T> listIterator(final int index)        //����Java�б����������
    {
        return new DoublyListIterator(index);
    }
//??
    private class DoublyListIterator extends DoublyIterator implements java.util.ListIterator<T>   //˽���ڲ��࣬ʵ���б�������ӿ�
    {
        int succ=0;                                    //��ǰԪ�����

        public DoublyListIterator(int index)//??
        {
    	    this.succ=index;
    //        current=CirDoublyLinkedList.this.head;//��ǰ���
            int i=-1;
            while (i<index && this.hasNext())
            {
            	i++;
            	this.current = this.current.next;
            }
        	if (index<0 || !this.hasNext())
        	    throw new IndexOutOfBoundsException("Index: "+index);
        }
        
        public boolean hasPrevious()                       //����ǰ��Ԫ�أ�����true
        {
            return this.current.pred!=CirDoublyLinkedList.this.head;
        }

        public T previous()                                //����ǰ��Ԫ��
        {
            if (this.hasPrevious())
            {
                this.current = this.current.pred;
                this.succ--;
                return this.current.data;
            }
            else throw new java.util.NoSuchElementException();  //�׳��޴�Ԫ���쳣
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
            if (x!=null && this.current!=CirDoublyLinkedList.this.head)
                this.current.data = x;
        }
        public void add(T x)                               //����Ԫ��x���ڵ�ǰ���֮�����x
        {
            if (x==null)
                return;                                    //������ӿն���
            DLinkNode<T> q = new DLinkNode<T>(x, this.current, this.current.next); 
            this.current.next.pred = q;                    //�ڵ�ǰ���֮�����x
            this.current.next = q;
            this.current = this.current.next;
            this.succ++;                                  //������Ϊ��ǰ���
        }
    }//DoublyListIterator�ڲ������
}  


/*
����ɾ���ӱ��滻�ӱ������֮ǰ�����Ĳ��롢ɾ��������δ�ɹ���
    //�����ӱ����������listѭ��˫�����е����н�㸴�Ʋ��뵽��ǰѭ��˫����front���֮��
    public DLinkNode<T> insert(DLinkNode<T> front, CirDoublyLinkedList<T> list)
    {
        DLinkNode<T> q=list.head.next;                      //���Ʋ���list����front���֮��
        while (q!=list.head)
        {
            front.next.pred = new DLinkNode<T>(q.data, front, front.next);
            front.next = front.next.pred;
            front = front.next;
            q=q.next;
        }
        return front;  //���ز����ӱ��Ľ�㣬�п�����ͷ��㣬Ϊ�˹�replaceAll���ã�������ǿ
    }
    //ɾ��this�������ͷ��ʼ�׸���patternƥ����ӱ�
    public DLinkNode<T> removeFirst(CirDoublyLinkedList<T> pattern)
    {
    	return removeFirst(this.head.next, pattern);
    }
    //ɾ��this�������start��㿪ʼ�׸���patternƥ����ӱ�
    //�㷨����index(pattern)���ҵ���ɾ�������ܵ���remove(i,n)������Ч�ʵ�
    public DLinkNode<T> removeFirst(DLinkNode<T> start, CirDoublyLinkedList<T> pattern)
    {
        DLinkNode<T> p=this.index(start,pattern); //���ش�start��㿪ʼ�״γ��ֵ���patternƥ����ӱ��׽��
                                                 //��patternΪ�գ�����null
        if (p==null)
        	return null;
        DLinkNode<T> q=pattern.head.next;
        while (q!=pattern.head)               //ɾ����p��ʼ��patternƥ����ӱ����ܵ���remove(i,n)������Ч�ʵ�
        {
            p.pred.next = p.next;            //ɾ��p��㣬��δ�ͷ�p��㣬p.next��p.pred��Ȼ��Ч
            p.next.pred = p.pred;
            p=p.next;                        //pָ��ɾ������ԭ��̽��
            q=q.next;
        }
        return p=p.pred;        //??��������ֵ�ܹ���removeAll()���ã����������ֵ�ĺ���˵�������
    }
    //ɾ��������patternƥ����ӱ��㷨����removeFirst(start,pattern)������Ҳ�ɾ���ӱ�
    public void removeAll(CirDoublyLinkedList<T> pattern)
    {
        DLinkNode<T> p=this.removeFirst(pattern);
        while (p!=null && p!=this.head)
        	p=this.removeFirst(p,pattern);
    }         
    //��this���������׸���patternƥ����ӱ��滻Ϊdest�ӱ��㷨����ɾ���Ͳ��뷽����
    public DLinkNode<T> replaceFirst(DLinkNode<T> start, CirDoublyLinkedList<T> pattern, CirDoublyLinkedList<T> dest)
    {
        System.out.print("��"+this.toString()+"���׸�"+pattern.toString()+"�滻Ϊ"+dest.toString());
        DLinkNode<T> p=this.removeFirst(pattern);
        if (p!=null)
        	p=this.insert(p, dest);
        System.out.println("�Ľ����"+this.toString());   
        return p;
    }
    //��this��������������patternƥ����ӱ��滻Ϊdest�ӱ��㷨����index(pattern)���ҵ���ɾ���Ͳ��롣
    //û�е���replaceFirst(pattern)����������û�з���ֵʱ���޷���λ����ͷ����Ч�ʵ�
    //�㷨����removeFirst(start,pattern)������Ҳ�ɾ���ӱ�
    public void replaceAll(CirDoublyLinkedList<T> pattern, CirDoublyLinkedList<T> dest)
    {
        DLinkNode<T> p=this.head.next;
        while (p!=null && p!=this.head)
        {
//        	p=p.next;
            p=this.replaceFirst(p, pattern, dest);     //����
        }
    }    
 */ 
