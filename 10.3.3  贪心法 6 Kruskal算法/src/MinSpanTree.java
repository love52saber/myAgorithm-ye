import java.util.Comparator;
//��С�������࣬�洢һ����Ȩ����ͼ��С�������ı߼��ϣ��Լ���С����
public class MinSpanTree 
{
    private Edge[] mst;                                    //�洢��С�������ı߼���
    private int cost=0;                                    //��С����������
 
    //��Kruskal�㷨�����Ȩͼ����С������������ۣ�ʹ����С�ѺͲ��鼯
    //����nָ����������edges����ָ��ͼ�����бߣ�ÿ��ֻ��ʾһ�Σ���comparatorָ���ߵıȽ�������
//    public MinSpanTree(AbstractGraph<T> graph, Comparator<Edge> comparator)
    public MinSpanTree(int n, Edge[] edges, Comparator<Edge> comparator)
    {
        MinHeap<Edge> minheap = new MinHeap<Edge>(edges, comparator);  //ʹ����С�Ѵ洢һ��ͼ�����бߣ��߰�Ȩֵ�Ƚϴ�С
        mst = new Edge[n-1];                               //mst�洢��С�������ı߼��ϣ�����Ϊ������-1
        UnionFindSet ufset = new UnionFindSet(n);          //���鼯
        System.out.println("���鼯��"+ufset.toString()+"����С�ѣ�"+minheap.toString());
        int i=0;                                           //��С�������е�ǰ�ߵ����
        for (int j=0; j<n; j++)                            //��ѡ����������-1������
        {
            Edge minedge = minheap.removeMin();            //ɾ����С�ѵĸ���������СȨֵ�ı�
            System.out.print("��С��"+minedge.toString()+"��");
            if (ufset.union(minedge.start, minedge.dest))  //����СȨֵ�ߵ������յ����ڵ��������Ϻϲ�
            {
                this.mst[i++]=minedge;                     //�ñ߼�����С������
                this.cost+=minedge.weight;                 //������С�������Ĵ���
                System.out.println("�����"+minedge.toString()+"��"+"���鼯��"+ufset.toString());
            }
        }
    }

    public String toString()                               //������С�������߼��ϵ������ַ���
    {
        String str="��С�������ı߼��ϣ�";
        for (int i=0; i<mst.length; i++)
            str+=mst[i]+" ";
        return str+"����С����Ϊ"+this.cost;
    }
    private static void print(boolean table[])                          //���һά���飬�������һ����
    {
        System.out.print("("+table[0]);
        for (int i=1; i<table.length; i++)
            System.out.print(","+table[i]);
        System.out.println(")");
    }
}
/*

 ??   //��Prim�㷨�����Ȩͼ����С������������ۣ�//ʹ����С��
    //����nָ��������, edges����ָ��ͼ�����б�
    public MinSpanTree(int n, Edge[] edges, Comparator<Edge> comp)
    {
        MinHeap<Edge> minheap = new MinHeap<Edge>(edges, comp);  //ʹ����С�Ѵ洢һ��ͼ�����бߣ��߰�Ȩֵ�Ƚϴ�С
        System.out.println("��С�ѣ�"+minheap.toString());
        mst = new Edge[n-1];                               //mst�洢��С�������ı߼��ϣ�����Ϊ������-1
        boolean vertmst[]=new boolean[n];
        print(vertmst);
        int i=0;                                           //��С�������е�ǰ�ߵ����
        vertmst[i]=true;   //������СȨֵ�ߵ�������ڵļ���
        for (int j=1; j<n; j++)                            //��ѡ����������-1������
        {
            Edge minedge = minheap.removeMin();            //ɾ����С�ѵĸ���������СȨֵ�ı�
            if (!vertmst[minedge.dest])   //��СȨֵ�ߵ������յ㲻��һ������
            {
               //vertmst[minedge.start]=true;   //������СȨֵ�ߵ�������ڵļ���
                vertmst[minedge.dest]=true;   //������СȨֵ�ߵ�������ڵļ���
                this.mst[i++]=minedge;                     //�ñ߼�����С������
                this.cost+=minedge.weight;                 //������С�������Ĵ���
                System.out.print("�����"+minedge.toString()+"��");
                print(vertmst);
            }
        }
    }

*/
