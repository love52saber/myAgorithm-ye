//2.3   ���Ա����ʽ��ʾ��ʵ��
//��ͷ���ĵ������࣬ʵ�����Ա�ӿ�

//public class SinglyLinkedList<T> implements LList<T>     //2.3   ���Ա����ʽ��ʾ��ʵ��
public class SinglyLinkedList<T> extends AbstractLList<T> implements LList<T>//��10�£�10.2 ʵ�ֵ����� 
{
    public Node<T> head;                              //ͷָ�룬ָ�������ͷ���

    public SinglyLinkedList()                         //Ĭ�Ϲ��췽��������յ�����
    {
        this.head = new Node<T>();                    //����ͷ��㣬data��nextֵ��Ϊnull
    }
    
    //��ָ�������еĶ�������쵥��������β���빹�쵥����
    //��element==null��Java���׳��ն����쳣����element.length==0�����������
    public SinglyLinkedList(T[] element)
    {
        this();                                       //�����յ�����ֻ��ͷ���
        Node<T> rear=this.head;                       //rearָ���������һ�����
        for (int i=0; i<element.length; i++)          //��element==null���׳��ն����쳣
        {                                             //element.length==0ʱ�����������
            rear.next=new Node<T>(element[i],null);   //β����,�����������rear���֮��
            rear = rear.next;                         //rearָ���µ���β���
        }
    }

    public boolean isEmpty()                          //�жϵ������Ƿ�գ�O(1)
    {
        return this.head.next==null;
    }

    //����length()��toString()��get()��set()�������ڵ���������㷨
    public int length()                               //���ص������ȣ�O(n)
    {
        int i=0; 
        Node<T> p=this.head.next;                     //p�ӵ������һ����㿪ʼ
        while (p!=null)                               //��������δ����
        {   i++;
            p = p.next;                               //p�����̽��
        }
        return i;
    }
    
    //���ص���������Ԫ�ص������ַ�������ʽΪ��(,)��������Object���toString()������O(n)
    public String toString()
    {
        String str="(";
        for (Node<T> p = this.head.next;  p!=null;  p=p.next) 
        {   str += p.data.toString();
            if (p.next!=null) 
                str += ",";                                //�������һ�����ʱ��ӷָ���
        }
        return str+")";                                    //�ձ���()
    }

    public T get(int i)                //���ص�i����0����Ԫ�أ���i<0����ڱ��򷵻�null��O(n)
    {
        if (i>=0)
        {
            Node<T> p=this.head.next;
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
        Node<T> p=this.head.next;
        for (int j=0; p!=null && j<i; j++)
            p = p.next;
        if (i>=0 && p!=null)
            p.data = x;                                    //pָ���i�����
        else throw new IndexOutOfBoundsException(i+"");    //�׳����Խ���쳣
    }
    
    //����insertAfter()��insert()��append()�㷨���۵�����������    
/*    //����x��Ϊp���ĺ�̽�㣬�������ɹ������²����㣻���򷵻�null��O(1)
    public Node<T> insertAfter(Node<T> p, T x)    
    {
        if (x==null || p==null)
            return null; 
        Node<T> q=new Node<T>(x, p.next);             //����x��Ϊp���ĺ�̽��
        p.next = q; 
        return q;
    }*/
    
    //�����i����0����Ԫ��ֵΪx����x==null�������롣
    //��i<0������x��Ϊ��0��Ԫ�أ���i���ڱ�������x��Ϊ���һ��Ԫ�ء�O(n)
    public void insert(int i, T x) 
    {
        if (x==null)  return;                         //���ܲ���ն���         
        Node<T> p=this.head;                          //pָ��ͷ���
        for (int j=0;  p.next!=null && j<i;  j++)     //Ѱ�Ҳ���λ��
            p = p.next;                               //ѭ��ֹͣʱ��pָ���i-1�������һ�����
        p.next = new Node<T>(x, p.next);              //����x��Ϊp���ĺ�̽�㣬����ͷ���루i<=0�����м�/β���루i>0��
    }
    public void append(T x)                           //�ڵ�����������x����O(n)
    {
        insert(Integer.MAX_VALUE, x);                //����һ��
//      insert(this.length(), x);                  //��������������Σ�Ч�ʽϵ�
//      this.insertAfter(this.getLast(),x)!=null;      //����һ��
    }
    /*    
    //��x������������Ϊi��㣬�������ɹ������²����㣻���򷵻�null��O(n)
    public Node<T> insert(int i, T x)    
    {
        if (x==null)
            return null;                              //���ܲ���ն���
        Node<T> p=this.head;                          //pָ��ͷ���
        for (int j=0; p.next!=null && j<i; j++)       //Ѱ�Ҳ���λ��
            p = p.next;                               //ѭ��ֹͣʱ��pָ���i-1�������һ�����
        Node<T> q=new Node<T>(x, p.next);             //����x��Ϊp���ĺ�̽��
        p.next = q;                                   //����ͷ���루i<=0�����м�/β���루i>0��
        return q;
    }*/
    
    
    //����removeAfter()��remove()��removeAll()�㷨ʵ�ֵ�����ɾ������
/*    //ɾ��p���ĺ�̽�㣬�������ɹ�����ɾ����㣻���򷵻�null��O(1)
    public Node<T> removeAfter(Node<T> p)    
    {
        if (p==null || p.next==null)
            return null; 
        Node<T> q=p.next;
        p.next = q.next;                              //ɾ��p���ĺ�̽��q
        return q;
    }*/
    
    //ɾ����i����0����Ԫ�أ����ر�ɾ��������i<0��i���ڱ�����ɾ��������null��O(n)
    public T remove(int i)
    {
        if (i>=0)
        {
            Node<T> p=this.head;
            for (int j=0;  p.next!=null && j<i;  j++)      //��λ����ɾ����㣨i����ǰ����㣨i-1��
                p = p.next;
            if (p.next!=null)
            {
                T old = p.next.data;                       //���ԭ����
                p.next = p.next.next;                      //ɾ��p�ĺ�̽��
                return old;
            }
        }
        return null;                                       //��i<0����ڱ�ʱ
//        throw new IndexOutOfBoundsException(i+"");         //�׳����Խ���쳣
    }

    public void removeAll()                                //ɾ������������Ԫ��
    {
        this.head.next=null;                               //Java���Զ��ջظ������ռ�õ��ڴ�ռ�
    }

    /* 7.  ��ߵ��������Ч�ʵĴ�ʩ
                    �㷨���У���Ч�ʵͣ�ʱ�临�Ӷ���O(n*n)��
        public String toString()
        {
            String str="(";
            if (this.length()!=0)
            {
                for(int i=0; i<this.length()-1; i++)
                    str += this.get(i).toString()+", ";
                str += this.get(this.length()-1).toString();
            }
            return str+")";
        }
    */
    
    //8.  �������ǳ���������
    //������췽�������Ƶ�����list�����н�㹹���µĵ�����
    public SinglyLinkedList(SinglyLinkedList<T> list)
    {
        this();                                       //�����յ�����ֻ��ͷ���
        Node<T> rear = this.head;
        for (Node<T> p=list.head.next;  p!=null;  p=p.next)  //��list==null���׳��ն����쳣
        {
            rear.next = new Node<T>(p.data, null);
            rear = rear.next; 
        }
    }
    
    //9.  ������Ƚ����
    //�Ƚ������������Ƿ���� ������Object���equals(obj)����
/*    public boolean equals(Object obj)
    {
        if (obj == this)
            return true;
        if (!(obj instanceof SinglyLinkedList))
            return false;
        Node<T> p=this.head.next;
        Node<T> q=((SinglyLinkedList<T>)obj).head.next;
        while (p!=null && q!=null && p.data.equals(q.data))
        {
            p=p.next;
            q=q.next;
        }
        return p==null && q==null;
    }*/
    //����ʵ��LList�ӿڣ���2��  
   
    //ϰ��2  
    
    //(1)����4�������ṩ��������������ʽ
    public Node<T> getFirst()                    //���ص������һ��Ԫ�ؽ�㣨��ͷ��㣩��O(1)
    {
        return this.head.next;                   //��������շ���null
    }
    public Node<T> getNext(Node<T> p)            //����p�ĺ�̽�㣬O(1)
    {
        if (this.head.next==null || p==null)
            return null;
        return p.next;
    }
    public Node<T> getPred(Node<T> p)            //����p��ǰ����㣬O(n)
    {
        if (p==null || this.head.next==p)
            return null;
        Node<T> front=this.head.next;
        while (front!=null && front.next!=p)
            front = front.next;
        return front;
    }
    public Node<T> getLast()                     //���ص��������һ��Ԫ�ؽ�㣬O(n)
    {
        Node<T> p=this.head.next;
        while (p!=null && p.next!=null)
            p = p.next;
        return p;                                //��������շ���null
    }    
/*    public String toString()                     //O(n)
    {
        String str="(";
        for (Node<T> p=this.getFirst();  p!=null;  p=this.getNext(p))
        {
            str += p.data.toString();
            if (p.next!=null) 
                str += ", ";
        }
        return str+")";
    }*/

    //(2)����
    //��ָ�������еĶ�������쵥��������β���빹�쵥��������insertAfter()����
/*    public SinglyLinkedList(T[] element)
    {
        this();                                       //�����յ�����ֻ��ͷ���
        Node<T> rear=this.head;
        for (int i=0; i<element.length; i++)
            rear = insertAfter(rear, element[i]);
    }   */
    //��ָ�������еĶ�������쵥��������ͷ���빹�췴��ĵ�����
/*    public SinglyLinkedList(T[] element)
    {
        this();                                       //�����յ�����ֻ��ͷ���
        for (int i=0; i<element.length; i++)
            this.head.next = new Node<T>(element[i], this.head.next);
    }*/

    //��3�� ���ӱ�������ƥ�䡢���ӡ����롢ɾ���ȵ�������ӱ�Ĳ���
        
    //���شӵ�i(��0)����㿪ʼ������Ϊn(��0)���ӱ������
    //��i<0��n<0���׳��쳣����i>����n=0�����ؿ�������n��������������β���ӱ�
    public SinglyLinkedList<T> sub(int i, int n)
    {
        if (i<0)  throw new IndexOutOfBoundsException(i+"");    //�׳����Խ���쳣
        if (n<0)  throw new IllegalArgumentException(i+"");     //�׳���Ч�����쳣
        Node<T> p=this.head.next;
        for (int j=0;  j<i && p!=null;  j++)               //Ѱ���ӱ��׽��
            p = p.next;                                    //ѭ��ֹͣʱ��pָ���i��㡣��i>������p==null  
        SinglyLinkedList<T> list=new SinglyLinkedList<T>();
        Node<T> rear=list.head;                            //�����ӱ�list����
        for (int j=0;  p!=null && j<n;  j++, p=p.next)
        {
            rear.next = new Node<T>(p.data,null);          //��rear���֮�����ֵΪp.data�Ľ��
            rear = rear.next;
        }
        return list;                                       //���ض�������
    }

    //�жϵ�ǰ�������Ƿ����list����������н�㣬�ж�������Ӽ�
    public boolean contain(SinglyLinkedList<T> list)
    {
        for (Node<T> q=list.head.next;  q!=null;  q=q.next)
        {
            Node<T> p=head.next;
            while (p!=null && !p.data.equals(q.data))      //�Ƚ�q���ֵ�Ƿ�����ڵ�ǰ��������
                p = p.next;
            if (p==null)                                   //������
                return false;
        }
        return true;
    }
    
    //��list�����������н�������ڵ�ǰ������֮�󣬲�����listΪ��
    public void concat(SinglyLinkedList<T> list)
    {
    	Node<T> rear=this.head;
        while (rear.next!=null)
        	rear = rear.next;
        rear.next = list.head.next;
        list.head.next=null;
    }
    
    //��9�� �����ӱ������
    //��list�������е����н�㸴�Ʋ��뵽this������front���֮��
    public void insert(Node<T> front, SinglyLinkedList<T> list)
    {
        for (Node<T> q=list.head.next;  q!=null;  q=q.next)
        {
            front.next = new Node<T>(q.data, front.next);  //��p���֮�����ֵΪq.data�Ľ��
            front = front.next;
        }
    }
    //��list�������е����н�㸴�Ʋ��뵽this�������i�����֮ǰ
    public void insert(int i, SinglyLinkedList<T> list)
    {
        Node<T> p=head;
        for (int j=0;  j<i && p.next!=null;  j++)          //Ѱ�Ҳ���λ��
            p = p.next;                                    //ѭ��ֹͣʱ��pָ���i-1�������һ�����
        this.insert(p,list);                               //���Ʋ���list����p���֮��
    }    
    //��list�����������н�㸴����ӵ���ǰ���������
    public void append(SinglyLinkedList<T> list)
    {
        Node<T> rear=head;
        while (rear.next!=null)                            //Ѱ����β�����Ϊ����λ��
            rear = rear.next;
        insert(rear, list);                                //��rear���֮���Ʋ���list����
    }
/*����
    public void append(SinglyLinkedList<T> list)
    {
        insert(this.getLast(), list);
    }    */
    
    //ɾ���ӵ�i����0������㿪ʼ������Ϊn����1�����ӱ�
    //��i<0��n<0���׳��쳣����i>����n=0����ɾ������n������ɾ������β���ӱ�
    public void remove(int i, int n)
    {
        if (i<0)  throw new IndexOutOfBoundsException(i+"");    //�׳����Խ���쳣
        if (n<0)  throw new IllegalArgumentException(i+"");     //�׳���Ч�����쳣
        Node<T> front=head;
        for (int j=0; front!=null && j<i; j++)             //Ѱ�Ҵ�ɾ���ӱ��׽���ǰ�����
            front = front.next;
        if (front==null)                                   //iԽ�磬��ɾ��
            return;
        Node<T> p=front.next;
        for (int j=0; p!=null && j<n; j++)                 //Ѱ�Ҵ�ɾ���ӱ�֮��Ľ��
            p = p.next; 
        front.next = p;                                    //ɾ��front��̽����pǰ�����֮����ӱ�
    }
    
    //����this�������״γ��ֵ���patternƥ����ӱ��׽�㣬
    //���Ҳ��ɹ�����ǰ��pattern������Ϊ��ʱ������null
    public Node<T> index(SinglyLinkedList<T> pattern)
    {
        return index(head.next, pattern);
    }
    //����this�������start��㿪ʼ�״γ��ֵ���patternƥ����ӱ��׽�㡣
    //BFģʽƥ�䡣������Ƚϣ�һ��ѭ����
    public Node<T> index(Node<T> start, SinglyLinkedList<T> pattern)
    {
        if (pattern.isEmpty())                             //���޴˾䣬�򷵻�start������
            return null;
        Node<T> p=start, q=pattern.head.next;
        while (p!=null && q!=null)
        {
            if (p.data.equals(q.data))                     //�����Ƚ���һ�����
            {   p=p.next;
                q=q.next;
            }
            else                                           //һ��ƥ��ʧ��
            {   start=start.next;                          //this����ƥ���¸��ӱ�
                p=start;
                q=pattern.head.next;                       //pattern��������ͷ
            }
        }
        if (q==null)                                       //ƥ��ɹ�
            return start;                                  //����ƥ���ӱ��׽��
        return null;                                       //this�ջ�ȫ��ƥ��ʧ��
    } 

    /* Ҳ�ɣ�    //BFģʽƥ�䡣����ӱ�ƥ�䣬����ѭ����
    public Node<T> index(Node<T> start, SinglyLinkedList<T> pattern)
    {
        if (pattern.isEmpty())                             //���޴˾䣬�򷵻�start������
            return null;
        while (start!=null)
        {
            Node<T> p=start, q=pattern.head.next;
            while (p!=null && q!=null && p.data.equals(q.data))//�����Ƚ���һ�����
            {
                p=p.next;
                q=q.next;
            }
            if (q==null)                                   //ƥ��ɹ�
                return start;                              //����ƥ���ӱ��׽��
            start=start.next;
        }
        return null;                                       //this�ջ�ȫ��ƥ��ʧ��
    }    */
 
    //ɾ��������patternƥ����ӱ�BFģʽƥ����ҵ���ɾ��
    public void removeAll(SinglyLinkedList<T> pattern)
    {
        System.out.print("��"+this.toString()+"��"+pattern.toString()+"ȫ��ɾ��");
        if (pattern.isEmpty())                             //���޴˾䣬����ѭ��������
            return;
        Node<T> start=this.head.next, front=this.head;
        while (start!=null)
        {
            Node<T> p=start, q=pattern.head.next;
            while (p!=null && q!=null && p.data.equals(q.data)) //һ��ƥ��
            {
                p=p.next;
                q=q.next;
            }
            if (q!=null)                                   //ƥ��ʧ�ܣ������´�ƥ��
            {   front=start;
                start=start.next;
            }
            else                                           //ƥ��ɹ���ɾ����ƥ���ӱ�
            {   front.next = p;
                start=p;
            }
        }
        System.out.println("�Ľ����"+this.toString());
    }
    
    //��this��������������patternƥ����ӱ��滻Ϊdest�ӱ���destΪ��ʱ���൱��ɾ��ƥ���ӱ�
    //����BFģʽƥ�䡢ɾ��ƥ���ӱ����Ʋ����ӱ��㷨
    public void replaceAll(SinglyLinkedList<T> pattern, SinglyLinkedList<T> dest)
    {
        System.out.print("��"+this.toString()+"��"+pattern.toString()+"ȫ���滻Ϊ"+dest.toString());
        if (pattern.isEmpty())                             //���޴˾䣬��dest���뵽start���֮�󣬴���
            return;
        Node<T> start=this.head.next, front=this.head;     //front��start��ǰ�����
        while (start!=null)                                //startָ��ÿ��ƥ�����ʼ���
        {
            Node<T> p=start, q=pattern.head.next;
            while (p!=null && q!=null && p.data.equals(q.data))//һ��ƥ��Ķ�αȽ�
            {   p=p.next;
                q=q.next;
            }
            if (q!=null)                                   //ƥ��ʧ�ܣ������´�ƥ��
            {   front=start;
                start=start.next;
            }
            else                                           //ƥ��ɹ����滻��ƥ���ӱ�
            {   front.next = p;
                start=p;
                Node<T> d=dest.head.next;
                while (d!=null)                            //��destʣ����������뵽this������front֮��p֮ǰ
                {
                    front.next = new Node<T>(d.data, p); 
                    front = front.next;
                    d = d.next;
                }
            }
        }
        System.out.println("�Ľ����"+this.toString());
    }

    //���µ�4�£��ݹ鷽��
/*    public String toString()                               //���ص����������ַ���
    {
        return "("+ this.toString(this.head.next) +")";
    }
    public String toString(Node<T> p)                      //���ش�p��㿪ʼ���ӱ������ַ������ݹ鷽��
    {
         if (p==null)
             return "";
         String str=p.data.toString();
         if (p.next!=null) 
             str+=", ";
         return str+this.toString(p.next);                 //�ݹ����
    }        

    public SinglyLinkedList(T[] element)                  //��ָ�������еĶ�������쵥����
    {
        this();                                            //�����յ�����ֻ��ͷ���
        this.head.next = create(element,0);
    }
    private Node<T> create(T[] element, int i)            //��ָ�����鹹�쵥�����ݹ鷽��
    {
        Node<T> p=null;
        if (i<element.length)
        {
            p = new Node<T>(element[i], null);
            p.next = create(element, i+1); 
        }
        return p;
    }
    
    public SinglyLinkedList(SinglyLinkedList<T> list)      //������Ե�����list�����µĵ�����
    {
        this();
        this.head.next = copy(list.head.next);
    }
    private Node<T> copy(Node<T> p)                        //���Ƶ������ݹ鷽��
    {
        Node<T> q=null;
        if (p!=null)
        {
            q = new Node<T>(p.data, null);
            q.next = copy(p.next); 
        }
        return q;
    }    
    
    //ϰ��4
    public int length()                                    //���ص�������
    {
        return length(this.head.next);
    }
    public int length(Node<T> p)                           //���ش�p��㿪ʼ�ĵ������ȣ��ݹ鷽��
    {
        if (p==null)
            return 0;
        return 1+length(p.next);                           //�ݹ����
    }
    
    public boolean equals(Object obj)                      //�Ƚ������������Ƿ���� 
    {
        if (obj == this)
            return true;
        if (obj instanceof SinglyLinkedList)    
        {
            SinglyLinkedList<T> list = (SinglyLinkedList<T>)obj;
            return equals(this.head.next, list.head.next);
        }
        return false;
    }
    private boolean equals(Node<T> p, Node<T> q)           //�Ƚ������������Ƿ���ȣ��ݹ鷽��
    {
        return p==null && q==null || 
               p!=null && q!=null && p.data.equals(q.data) && equals(p.next, q.next);
    }
    */
    
    //���µ�8�� 8.2.1 ˳����ң�ɢ�б�����

    //˳����ҹؼ���ΪkeyԪ�أ������״γ��ֵ�Ԫ�أ������Ҳ��ɹ�����null
    //key����ֻ�����ؼ����������T���equals()�����ṩ�Ƚ϶�����ȵ�����
    public T search(T key) 
    {
        if (key==null)
            return null;
        for (Node<T> p=this.head.next;  p!=null;  p=p.next)
            if (p.data.equals(key))
                return p.data;
        return null;
    }
    public boolean contain(T key)                          //�ж����Ա��Ƿ�����ؼ���ΪkeyԪ��
    {
        return this.search(key)!=null;                     //�Բ��ҽ������жϽ��
    }

    public void remove(T x)                   //ɾ���״γ��ֵ�ֵΪx�Ľ�㣬��û�ҵ�ָ�������ɾ����O(n)
    {
        if (x==null)
            return;
        Node<T> front=this.head, p=front.next;
        while (p!=null && !p.data.equals(x))
        {
            front = p;
            p=p.next;
        }
        if (p!=null)
            front.next = p.next;                     //ͷɾ�����м�/βɾ��
    }
    //˼���⣺remove(x)�����ܷ����search(x)������λ��Ϊʲô��
    
    //�����ǵ�8��ϰ��
    public void removeAll(T x)                   	       //ɾ������ֵΪx�Ľ��
    {
        if (x!=null)
        {        
            Node<T> front=this.head, p=front.next;
            while (p!=null)
                if (p.data.equals(x))
                {   front.next = p.next;                   //ɾ��p���
                    p = front.next;
                }
                else
                {   front = p;
                    p = p.next;
                }
        }
    }
    public void replace(T x, T y)                          //���״γ��ֵ�Ԫ��x�滻Ϊy��O(n)
    {
        if (x!=null && y!=null)
            for (Node<T> p=this.head.next;  p!=null;  p=p.next)
                if (p.data.equals(x))
                {
                    p.data = y;
                    return;
                }
    } 
    public void replaceAll(T x, T y)             	//������ֵΪxԪ���滻Ϊy��O(n)
    {
        if (x!=null && y!=null)
            for (Node<T> p=this.head.next;  p!=null;  p=p.next)
                if (p.data.equals(x))
                     p.data = y;
    }
    
    //��10�£�10.2 ʵ�ֵ�����
    public java.util.Iterator<T> iterator()                //����Java����������
    {
        return new SinglyIterator();
    }

    private class SinglyIterator implements java.util.Iterator<T> //˽���ڲ��࣬ʵ�ֵ������ӿ�
    {
        Node<T> current=SinglyLinkedList.this.head;        //��ǰ��㣬��ֵΪ�ⲿ�൥����ͷ���
        Node<T> front=null;                                //��ǰ����ǰ�����

        public boolean hasNext()                           //���к��Ԫ�أ�����true
        {
            return this.current!=null && this.current.next!=null;
        }

        public T next()                                    //���غ��Ԫ��
        {
            if (this.hasNext())
            {
                this.front = this.current;
                this.current = this.current.next;
                return this.current.data;
            }
            else throw new java.util.NoSuchElementException();  //�׳��޴�Ԫ���쳣
        }

        public void remove()                               //ɾ�������������ʾ�ļ��ϵ�ǰԪ��
        {
            if (this.front!=null)
            {
                this.front.next = this.current.next;       //ɾ����ǰ���
                this.current = this.front;
                this.front=null;                           //���ò�������ɾ��
            }
            else throw new java.lang.IllegalStateException(); //�׳���Ч״̬�쳣
//            throw new UnsupportedOperationException();     //��֧�ָò������׳��쳣
        }
    }//�ڲ������
}