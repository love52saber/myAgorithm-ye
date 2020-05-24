//7.2.2   ͼ���ڽӱ��ʾ��ʵ��
//ͼ���ڽӱ���

public class AdjListGraph<T> extends AbstractGraph<T>      //�ڽӱ��ʾ��ͼ�� ���̳г���ͼ��
{
    protected SeqList<Vertex<T>> vertexlist;               //����˳���
    
    public AdjListGraph(int size)                          //���췽����sizeָ������˳�������
    {
        size = size<10 ? 10 : size;
        this.vertexlist = new SeqList<Vertex<T>>(size);
    }

    public AdjListGraph(T[] vertices, Edge[] edges)        //�Զ��㼯�Ϻͱ߼��Ϲ���һ��ͼ
    {
        this(vertices.length*2);                           //����ָ�������Ŀ�ͼ����vertices==null���׳��ն����쳣
        for (int i=0; i<vertices.length; i++)
            insertVertex(vertices[i]);                     //����һ������
        if (edges!=null)                                   //��edges==nullʱ�������ͼû�б�
            for (int j=0; j<edges.length; j++)
                insertEdge(edges[j]);                      //����һ����        
    }

    public int vertexCount()                               //���ض�����
    {
        return this.vertexlist.length();
    }

    public T get(int i)                                    //���ض���vi������Ԫ�أ���iָ�������Ч�򷵻�null
    {
        return this.vertexlist.get(i).data;
    }
    public int getWeight(int i, int j)                     //����<vi,vj>�ߵ�Ȩֵ
    {
        int n=this.vertexCount();
        if (i>=0 && i<n && j>=0 && j<n) 
        {
            if (i==j)
                return 0;
            Node<Edge> p=this.vertexlist.get(i).adjlink.head.next; //��õ�i���ߵ�����ĵ�һ�����
            while (p!=null)                                //Ѱ����һ���ڽӶ���
            {
                if (p.data.dest==j)
                    return p.data.weight;                  //����<vi,vj>�ߵ�Ȩֵ
                p = p.next;
            }
            return MAX_WEIGHT;
        }
        throw new IndexOutOfBoundsException("i="+i+", j="+j);//�׳����Խ���쳣
    }

    public String toString()                          //����ͼ�Ķ��㼯�Ϻ��ڽӱ������ַ���
    {
        return "���߱�\n"+this.vertexlist.toString()+"\n ";
    }

    //����Ԫ��ֵΪx�Ķ��㣬���ظö����ڶ���˳����е����
    public int insertVertex(T x)
    {
        this.vertexlist.append(new Vertex<T>(x));     //˳���׷��Ԫ�أ��Զ���������
        return this.vertexlist.length()-1;
    }

    //����һ��ȨֵΪweight�ıߡ�vi,vj�������ñ��Ѵ��ڣ��򲻲��롣
    //�㷨��ָ���߽�������dest��ֵ���뵽��i���ߵ�����ĺ���λ�á�
    public void insertEdge(int i, int j, int weight)
    { 
        if (i>=0 && i<vertexCount() && j>=0 && j<vertexCount() && i!=j)
        {
            Edge edge=new Edge(i,j,weight);
            SortedSinglyLinkedList<Edge> adjlink=this.vertexlist.get(i).adjlink;//��õ�i���ߵ�����
            Node<Edge> front=adjlink.head, p=front.next;
            while (p!=null && p.data.compareTo(edge)<0)    //Ѱ�Ҳ���λ��
            {
                front = p;
                p = p.next;
            }
            if (p!=null && p.data.compareTo(edge)==0)      //���ñ��Ѵ��ڣ��򲻲���
                return;
            front.next = new Node<Edge>(edge, p);          //��edge�߽����뵽front���֮��
        }
    }   
    public void insertEdge(Edge edge)                      //����һ����
    {        
        insertEdge(edge.start, edge.dest, edge.weight);
    }
    //��˼���⡿���������㷨Ϊʲô����ֱ�ӵ���ִ��������������Ĳ���Ԫ����䣿
    //this.vertexlist.get(i).adjlink.insert(edge); 
    //���𡿲���Ҫ��ͬ���˴�Ҫ�󲻲�����ֵͬ������������Ĳ��뷽���������ֵͬ��
    
    public void removeEdge(int i, int j)         //ɾ���ߡ�vi,vj����i��jָ���������
    {
        if (i>=0 && i<vertexCount() && j>=0 && j<vertexCount() && i!=j)
            this.vertexlist.get(i).adjlink.remove(new Edge(i,j,1));//�ڵ�i���ߵ�������ɾ��ָ��ֵ���
               //�������������ɾ������������������Edge��compareTo(e)��������0
    }
    public void removeEdge(Edge edge)            //ɾ����
    {        
        removeEdge(edge.start, edge.dest);
    }

    public void removeVertex(int i)                        //ɾ�����Ϊvi�Ķ��㼰������ı�
    {
        int n=vertexCount();                               //ɾ��֮ǰ�Ķ�����
        if (i<0 || i>n)
            return;
        for (int j=0; j<n-1; j++)                          //δɾ���ı߽�����ĳЩ�������
        {
            Node<Edge> front=this.vertexlist.get(j).adjlink.head;
            Node<Edge> p=front.next;                       //��õ�j���ߵ�����ĵ�һ�����
            while (p!=null)
            {
                Edge e=p.data;
                if (e.start==i || e.dest==i)
                {
                    front.next = p.next;                   //ɾ����vi�����ı�
                    p=front.next;
                }
                else
                {
                    if (e.start>i)
                        e.start--;                         //������ż�һ
                    if (e.dest>i)
                        e.dest--;                     
                    front = p;
                    p = p.next;
                }
            }
        }
        this.vertexlist.remove(i);                         //ɾ������vi���������Ѽ�һ
    }

    //7.3   ͼ�ı���
    //����vi��vj�����һ���ڽӶ������ţ���j=-1ʱ�����ص�һ���ڽӶ������ţ�����������һ���ڽӶ��㣬�򷵻�-1
    public int getNextNeighbor(int i, int j)
    {
        int n=this.vertexCount();
        if (i>=0 && i<n && j>=-1 && j<n && i!=j)
            for (Node<Edge> p=this.vertexlist.get(i).adjlink.head.next;  p!=null;  p=p.next)
                                                           //�ڵ�i���ߵ�������Ѱ����һ���ڽӶ���
                if (p.data.dest>j)                         //j=-1ʱ�����ص�һ���ڽӶ�������
                    return p.data.dest;                    //������һ���ڽӶ�������
        return -1;
    }    
}     

/*
    //���ڵ�����ĵ�����
    //����vi��vj�����һ���ڽӶ������ţ���j=-1ʱ�����ص�һ���ڽӶ������ţ�����������һ���ڽӶ��㣬�򷵻�-1
    public int getNextNeighbor(int i, int j) 
    {
        int n=this.vertexCount();
        if (i>=0 && i<n && j>=-1 && j<n && i!=j)
        {
            SortedSinglyLinkedList<Edge> slink = this.vertexlist.get(i).adjlink;  //��õ�i���ߵ�����
            java.util.Iterator<Edge> it = slink.iterator();//it�ǵ�����ĵ�����
            while (it.hasNext())                           //���к��Ԫ��
            {
                Edge edge = it.next();                     //���ص�����ĵ�һ���ߣ��൱��slink.get(0)
//                System.out.print(edge.toString()+" ");     //���ʸö���
                if (edge.dest>j)
                    return edge.dest;                      //������һ���ڽӶ�������
            }  
        }
        return -1;
    }
}*/