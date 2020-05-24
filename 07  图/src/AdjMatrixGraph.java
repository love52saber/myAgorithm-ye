//7.2   ͼ�ı�ʾ��ʵ��
//7.2.1   ͼ���ڽӾ����ʾ��ʵ��
//�ڽӾ����ʾ��ͼ��

public class AdjMatrixGraph<T> extends AbstractGraph<T>    //�ڽӾ����ʾ��ͼ�࣬�̳г���ͼ�� 
{
    protected SeqList<T> vertexlist;                       //˳���洢ͼ�Ķ��㼯��
    protected int[][] adjmatrix;                           //ͼ���ڽӾ���
//    private static final int MAX_WEIGHT=99999;             //Integer.MAX_VALUE; //���Ȩֵ����ʾ�����ޣ�
    
    //�����ͼ��sizeָ������˳�����������ڽӾ����ά���������
    public AdjMatrixGraph(int size)
    {
        size = size<10 ? 10 : size;
        this.vertexlist = new SeqList<T>(size);            //��������Ϊsize�Ŀ�˳�����ǰ������Ϊ0
        this.adjmatrix = new int[size][size];
        for (int i=0; i<size; i++)                         //��ʼ��ͼ���ڽӾ���
            for (int j=0; j<size; j++)
                this.adjmatrix[i][j]= (i==j) ? 0 : MAX_WEIGHT;  //�ߵ�ȨֵΪ0�����Ȩֵ
    }

    //�Զ��㼯�Ϻͱ߼��Ϲ���һ��ͼ����vertices��edgesΪnull���׳��ն����쳣
    public AdjMatrixGraph(T[] vertices, Edge[] edges)
    {
        this(vertices.length);                             //����ָ�������Ŀ�ͼ
        for (int i=0; i<vertices.length; i++)
            insertVertex(vertices[i]);                     //����һ������
        for (int j=0; j<edges.length; j++)
            insertEdge(edges[j]);                          //����һ����
    }
    public AdjMatrixGraph(T[] vertices)                    //����ָ�����㼯�ϡ�û�бߵĿ�ͼ
    {
        this(vertices, new Edge[0]);
    }
 
    public AdjMatrixGraph(SeqList<T> list, Edge[] edges)   //�Զ��㼯�Ϻͱ߼��Ϲ���һ��ͼ
    {
        this(list.length());
        this.vertexlist = list;
        if (list==null)                                    //�����ͼ��û�ж���û�б�
            return;
        if (edges!=null)                                   //��edges==nullʱ�������ͼû�б�
            for (int j=0; j<edges.length; j++)
                insertEdge(edges[j]);                      //����һ����        
    }

    public int vertexCount()                          //���ض�����
    {
        return this.vertexlist.length();              //���ض���˳����Ԫ�ظ���
    }
    public T get(int i)                               //���ض���vi������Ԫ�أ���iָ�������Ч�򷵻�null
    {
        return this.vertexlist.get(i);
    }
    public int getWeight(int i, int j)                //����<vi,vj>�ߵ�Ȩֵ
    {
        return this.adjmatrix[i][j];
    }
    public String toString()                          //����ͼ�Ķ��㼯�Ϻ��ڽӾ��������ַ���
    {
        String str= "���㼯�ϣ�"+this.vertexlist.toString()+"\n�ڽӾ���:  \n";
        int n = this.vertexCount();                   //������
        for (int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
                str += this.adjmatrix[i][j]==MAX_WEIGHT ? "  ��" : "  "+this.adjmatrix[i][j];
            str+="\n";
        }
        return str;
    }

    //����Ԫ��ֵΪx�Ķ��㣬���ظö����ڶ���˳����е����
    public int insertVertex(T x)
    {
        this.vertexlist.append(x);                         //˳���׷��Ԫ�أ��Զ���������
        if (this.vertexCount()>this.adjmatrix.length)      //����ά�����������㣬������
        {
            int temp[][]=adjmatrix, i, j;
            this.adjmatrix = new int[temp.length*2][temp.length*2]; //��ά������������2��
            for (i=0; i<temp.length; i++)
            {
                for (j=0; j<temp.length; j++)              //����ԭ�ڽӾ���
                    this.adjmatrix[i][j] = temp[i][j];
                for (j=temp.length; j<temp.length*2; j++)
                    this.adjmatrix[i][j] = MAX_WEIGHT;
            }
            for (i=temp.length; i<temp.length*2; i++)      //��ʼ��������ڽӾ���
                for (j=0; j<temp.length*2; j++)
                    this.adjmatrix[i][j] = (i==j) ? 0 : MAX_WEIGHT;
        }
        return this.vertexlist.length()-1;                 //���ز��붥�����
    }    
    
    //����һ��ȨֵΪweight�ıߡ�vi,vj�������ñ��Ѵ��ڣ��򲻲���
    public void insertEdge(int i, int j, int weight)
    {
        int n=this.vertexCount();
    	if (i>=0 && i<n && j>=0 && j<n && i!=j && adjmatrix[i][j]==MAX_WEIGHT)
            this.adjmatrix[i][j]=weight;
    }    
    public void insertEdge(Edge edge)                      //����һ����
    {
        this.insertEdge(edge.start, edge.dest, edge.weight);
    }

    public void removeEdge(int i, int j)                   //ɾ���ߡ�vi,vj����i��jָ���������
    {
        int n=this.vertexCount();
        if (i>=0 && i<n && j>=0 && j<n && i!=j)
            this.adjmatrix[i][j]=MAX_WEIGHT;               //���øñߵ�ȨֵΪ�����
    }
    
    public void removeVertex(int i)                        //ɾ������vi��������ı�
    {
        int n=this.vertexCount();                          //������
        if (i<0 || i>n)
            return;
        this.vertexlist.remove(i);                         //ɾ��˳���ĵ�i��Ԫ�أ��������Ѽ�һ
        for (int j=0; j<i; j++)
            for (int k=i+1; k<n; k++)
                this.adjmatrix[j][k-1] = this.adjmatrix[j][k];  //Ԫ������һ��
        for (int j=i+1; j<n; j++)
            for (int k=0; k<i; k++)
                this.adjmatrix[j-1][k] = this.adjmatrix[j][k];  //Ԫ������һ��
        for (int j=i+1; j<n; j++)
            for (int k=i+1; k<n; k++)
                this.adjmatrix[j-1][k-1] = this.adjmatrix[j][k]; //Ԫ��������һ��һ��
    }
    public void removeVertex(T vertex)           //ɾ������vertex��������ı�
    {
        int i=this.vertexlist.indexOf(vertex);   //��˳����в���ֵΪvertex��Ԫ�أ�������ţ��㷨����8��
        this.removeVertex(i);                    //ɾ������vi��������ı�
    }
   
    //7.3   ͼ�ı���
    //����vi��vj�����һ���ڽӶ������ ����j=-1ʱ��vi�ĵ�һ���ڽӶ�����ţ�����������һ���ڽӶ��㣬�򷵻�-1
    public int getNextNeighbor(int i, int j)
    {
        int n=this.vertexCount();
        if (i>=0 && i<n && j>=-1 && j<n && i!=j)
            for (int k=j+1; k<n; k++)                      //��j=-1ʱ��k��0��ʼѰ����һ���ڽӶ���
                if (this.adjmatrix[i][k]>0 && this.adjmatrix[i][k]<MAX_WEIGHT)
                    return k;
        return -1;         
    }
    
    //ϰ��7
    public int edgeCount()                                 //���ر���
    {
        int n=this.vertexlist.length();                    //������
        int count=0;
        for (int i=0; i<n; i++)
            for (int j=0; j<n; j++)
                if (i!=j && this.adjmatrix[i][j]!=MAX_WEIGHT)
                    count++;
        return count;
    }

    public int indegree(int i)                             //���ض���vi�����
    {
        int n=this.vertexlist.length();                    //������
        int degree=0;
        for (int j=0; j<n; j++)                            //��i���ϸ�Ԫ��֮���Ƕ���vi�����
            if (i!=j && this.adjmatrix[j][i]!=MAX_WEIGHT)
                degree++;
        return degree;
    }
    public int outdegree(int i)                            //���ض���vi�ĳ���
    {
        int n=this.vertexlist.length();                    //������
        int degree=0;
        for (int j=0; j<n; j++)                            //��i���ϸ�Ԫ��֮���Ƕ���vi�ĳ���
            if (i!=j && this.adjmatrix[i][j]!=MAX_WEIGHT)
                degree++;
        return degree;
    }
}

/*
 * δʵ��
//���Ȩͼ�����бߵ�Ȩֵ֮��??
    public AdjMatrixGraph(T[] vertices)               //�Զ��㼯�Ϲ�����ȫͼ
*/

