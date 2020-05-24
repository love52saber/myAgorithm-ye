//7.3   ͼ�ı���
//����ͨͼ������������������͹��������������

public abstract class AbstractGraph<T> implements GGraph<T>//����ͼ�� 
{
    public abstract int vertexCount();                     //���ض�����������������ʵ��
    public abstract T get(int i);                          //���ض���vi��������
    public abstract int getNextNeighbor(int i, int j);     //����vi��vj�����һ���ڽӶ������ 
                                       //��j=-1ʱ��vi�ĵ�һ���ڽӶ�����ţ����������ڽӶ��㣬����-1

    public void DFSTraverse(int i)                         //�Ӷ���vi�����Է���ͨͼ��һ�����������������
    {
        boolean[] visited=new boolean[this.vertexCount()]; //���ʱ�����飬Ԫ�س�ֵΪfalse����ʾδ������
        int j=i;
        do
        {   if (!visited[j])                               //������vjδ������
            {
                System.out.print("{ ");
                this.depthfs(j, visited);                  //�Ӷ���vi������һ�����������������
                System.out.print("} ");
            }
            j = (j+1) % this.vertexCount();                //��������ͨ������Ѱ��δ�����ʶ���
        } while (j!=i);
        System.out.println();
    }
    //�Ӷ���vi������һ�����������������������һ����ͨ����
    private void depthfs(int i, boolean[] visited)
    {
        System.out.print(this.get(i)+" ");                 //���ʶ���vi
        visited[i] = true;                                 //���ѷ��ʱ��
        int j = this.getNextNeighbor(i, -1);               //���vi�ĵ�һ���ڽӶ������
        while (j!=-1)                                      //�������ڽӶ���vj
        {
            if(!visited[j])                                //���ڽӶ���vjδ������
                depthfs(j, visited);                       //��vj������������������������ݹ����
            j = this.getNextNeighbor(i, j);                //����vi��vj�����һ���ڽӶ������
        }
    }

    //�Ӷ���vi�����Է���ͨͼ����һ�ι��������������
    public void BFSTraverse(int i)
    {
        boolean[] visited = new boolean[this.vertexCount()]; //���ʱ������
        int j=i;
        do
        {   if (!visited[j])                               //������vjδ������
            {
                System.out.print("{ ");
                breadthfs(j, visited);                     //�Ӷ���vj�����Ĺ��������������
                System.out.print("} ");
            }
            j = (j+1) % this.vertexCount();                //��������ͨ������Ѱ��δ�����ʶ���
        } while (j!=i);
        System.out.println();
    }
        
    //�Ӷ���vi�����Ĺ��������������������һ����ͨ����
    private void breadthfs(int i, boolean[] visited)
    {
        System.out.print(this.get(i)+" ");
        visited[i] = true;
//        SeqQueue<Integer> que = new SeqQueue<Integer>(this.vertexCount());   //����˳�����
        LinkedQueue<Integer> que = new LinkedQueue<Integer>();//this.vertexCount());   //����˳�����
        que.enqueue(new Integer(i));                       //���ʹ��Ķ���vi��������
        while (!que.isEmpty())                             //�����в���ʱѭ��
        {
            i = que.dequeue().intValue();                  //����
            int j = this.getNextNeighbor(i,-1);            //��ö���vi�ĵ�һ���ڽӶ������
            while (j!=-1)                                  //�������ڽӶ���vj
            {
                if (!visited[j])                           //������vjδ���ʹ�
                {
                    System.out.print(this.get(j)+" ");     //���ʶ���vj
                    visited[j] = true;
                    que.enqueue(new Integer(j));           //���ʹ��Ķ���vj��������
//                    System.out.println("������У�"+que.toString());                    
                }
                j = this.getNextNeighbor(i, j);            //����vi��vj�����һ���ڽӶ�������
            }
        }
    }
    
    //7.4.2   ��С�������Ĺ����㷨
    public abstract int getWeight(int i, int j);           //����<vi,vj>�ߵ�Ȩֵ

    public void minSpanTree_prim()                         //�����Ȩͼ��С������������ķ�㷨
    {
        Edge[] mst = new Edge[vertexCount()-1];            //mst�洢��С�������ı߼��ϣ�����Ϊ������-1
        for (int i=0; i<mst.length; i++)                   //��ʼ��mst���飬�Ӷ���v0����������С������
            mst[i]=new Edge(0,i+1,this.getWeight(0,i+1));  //����Ӷ���v0������������ıߵ�Ȩ

        System.out.print("mst���飺");
        for(int j=0; j<mst.length; j++)                    //��ʾmst����ı仯����
            System.out.print(mst[j].toString());

        for (int i=0; i<mst.length; i++)                   //��ѡ����������-1������
        {
            int minweight = MAX_WEIGHT;                    //��СȨֵ
            int min = i;
            for (int j=i; j<mst.length; j++)               //Ѱ�ҵ�ǰȨֵ��С�ߵĶ���
                if (mst[j].weight<minweight)
                {
                    minweight = mst[j].weight;             //������СȨֵ
                    min = j;                               //���浱ǰȨֵ��С�ߵ��յ����
                }
            
            Edge temp = mst[i];                            //����Ȩֵ��С�ı�
            mst[i] = mst[min];
            mst[min] = temp;

            int tv = mst[i].dest;                          //�ղ���TV�Ķ���
            for (int j=i+1; j<mst.length; j++)             //����mst[i+1]�����Ԫ��ΪȨֵ��С�ı�
            {
                int v = mst[j].dest;                       //ԭ����V-TV�е��յ�
                if (this.getWeight(tv,v)<mst[j].weight)    //����Ȩֵ��С�ı�(tv,v)������(tv,v)���滻ԭ��
                {
                    mst[j].weight = this.getWeight(tv,v);
                    mst[j].start = tv;
                }
            }
            System.out.print("\nmst���飺");
            for(int j=0; j<mst.length; j++)                //��ʾmst����ı仯����
                System.out.print(mst[j].toString());
        }
        System.out.print("\n��С�������ı߼��ϣ�");
        int mincost=0;
        for (int i=0; i<mst.length; i++)
        {
            System.out.print(mst[i]+" ");
            mincost += mst[i].weight;
        }
        System.out.println("����С����Ϊ"+mincost);
    }

    //7.5   ���·��
    //7.5.1   �Ǹ�Ȩֵ�ĵ�Դ���·����Dijkstra�㷨��
    public void shortestPath(int i)              //��Dijkstra�㷨���Ȩͼ�ж���vi�ĵ�Դ���·��
    {
        int n = this.vertexCount(),j,k;          //nΪ������
        int[] dist = new int[n];                 //���·������
        int[] path = new int[n];                 //���·�����յ��ǰһ������
        int[] vset = new int[n];                 //��������·���Ķ��㼯�ϣ���ֵȫΪ0
        vset[i] = 1;                             //���Դ��vi�ڼ���S��
        for (j=0; j<n; j++)                      //��ʼ��dist��path����
        {
            dist[j] = this.getWeight(i,j);
            path[j] = (j!=i && dist[j]<MAX_WEIGHT) ? i : -1;
        }
        System.out.print("\nvset����"+toString(vset));
        System.out.print("\tpath����"+toString(path));
        System.out.print("\tdist����"+toString(dist));
        
        for (j=(i+1)%n; j!=i; j=(j+1)%n)         //Ѱ�Ҵ�vi������vj�����·��
        {
            int mindist=MAX_WEIGHT, u=0;
            for (k=0; k<n; k++)                  //ѡ��·��������Сֵ
                if (vset[k]==0 && dist[k]<mindist)
                {
                    u = k;                       //��ǰ������С·�����յ�
                    mindist = dist[k];           //��ǰ·��������Сֵ
                }
            if (mindist==MAX_WEIGHT)             //��û���������·�����㷨������ �����Է���ͨͼ�Ǳ����
                break;
            vset[u] = 1;                         //ȷ��һ�����·�����յ�u���뼯��S
            for (k=0; k<n; k++)                  //������vi��V-S��������������·��������
                if(vset[k]==0 && this.getWeight(u,k)<MAX_WEIGHT && dist[u]+this.getWeight(u,k)<dist[k])
                {
                    dist[k] = dist[u] + this.getWeight(u,k);
                    path[k] = u;
                }    
            System.out.print("\nvset����"+toString(vset));
            System.out.print("\tpath����"+toString(path));
            System.out.print("\tdist����"+toString(dist));
        }

        System.out.println("\n�Ӷ���"+this.get(i)+"��������������·�����£�");
        for (j=0; j<n; j++) 
            if (j!=i)
            {
                String pathstr="";
                for (k=path[j]; k!=i && k!=j && k!=-1; k=path[k])
                    pathstr=","+this.get(k)+pathstr;       //���·���ַ���
                pathstr = "("+this.get(i)+pathstr+","+this.get(j)+")����Ϊ "+(dist[j]==MAX_WEIGHT ? "��" : dist[j]);
                System.out.print(pathstr+"��");
            }
        System.out.println();
    }
    private static String toString(int[] value)        //�������ֵ
    {
        if (value!=null && value.length>0)
        {
            String str="{";
            int i=0;
            for(i=0; i<value.length-1; i++)
                str += (value[i]==MAX_WEIGHT ? "��" : value[i])+",";
            return str+(value[i]==MAX_WEIGHT ? "��" : value[i])+"}";
        }
        return null;        
    }
   
    //7.5.2   ÿ�Զ��������·����Floyd�㷨��
    public void shortestPath()                   //��Floyd�㷨���Ȩͼÿ�Զ��������·��
    {
        int n=this.vertexCount(), i, j;          //nΪ������
        int dist[][] = new int[n][n];            //dist�洢ÿ�Զ��������·������
        int path[][] = new int[n][n];            //�洢���·���յ��ǰһ���������
        for (i=0; i<n; i++)                      //��ʼ��path����
            for (j=0; j<n; j++)
            {
                dist[i][j] = this.getWeight(i,j);          //dist��ʼΪ�ڽӾ���
                path[i][j] = (i!=j && dist[i][j]<MAX_WEIGHT) ? i : -1;
            }
        System.out.print("��ֵpath����\n"+toString(path));
        System.out.println("dist����\n"+toString(dist));

        for (int k=0; k<n; k++)                  //�� ��Ϊ����·�����м䶥�㣬����·�������Ƿ����
        {
            System.out.println("��"+get(k)+"��Ϊ�м䶥��");
            for (i=0; i<n; i++)
                if (k!=i)
                    for (j=0; j<n; j++)
                        if (k!=j && i!=j)
                        {
                        System.out.print(pathToString(path,i,j)+"·������"+dist[i][j]+"���滻Ϊ"+
                            pathToString(path,i,k)+","+pathToString(path,k,j)+"·������"+(dist[i][k]+dist[k][j])+"��");
                        if (k!=j && i!=j && dist[i][j]>dist[i][k]+dist[k][j])
                        {
                            dist[i][j] = dist[i][k]+dist[k][j];
                            path[i][j] = path[k][j];
                            System.out.println("�ǣ�d"+i+j+"="+dist[i][j]+"��p"+i+j+"="+path[i][j]);
                        }
                        else
                        	System.out.println("��");
                        }
            System.out.print("path����\n"+toString(path));
            System.out.println("dist����\n"+toString(dist));
        }
    
        System.out.println("ÿ�Զ��������·�����£�");
        for (i=0; i<n; i++)
            for (j=0; j<n; j++)
                if (i!=j)
                {
                    String pathstr="";
                    for (int k=path[i][j]; k!=i && k!=j && k!=-1;  k=path[i][k])
                        pathstr=","+this.get(k)+pathstr;   //���·���Ķ�������Ƿ����
                    pathstr = "("+this.get(i)+pathstr+","+this.get(j)+")����Ϊ"+(dist[i][j]==MAX_WEIGHT ? "��" : dist[i][j]);
                    System.out.print("��"+pathstr);
                }
        System.out.println();
    }
    
    private String pathToString(int[][] path, int i, int j)
    {
        String pathstr="";
        for (int k=path[i][j]; k!=i && k!=j && k!=-1;  k=path[i][k])
            pathstr=","+this.get(k)+pathstr;               //���·���Ķ�������Ƿ����
        pathstr = "("+get(i)+pathstr+","+this.get(j)+")";
        return pathstr;     
    }
    public static String toString(int[][] value) 
    {
        String str="";
    	for (int i=0; i<value.length; i++) 
    	{
            for (int j=0; j<value[i].length; j++) 
                str += value[i][j]==MAX_WEIGHT ? "  ��" : "  "+value[i][j];
            str+="\n";
    	}
        return str;
    }
}