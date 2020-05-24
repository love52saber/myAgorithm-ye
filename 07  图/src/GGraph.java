//7.1.2   ͼ������������
//ͼ�ӿ�

public interface GGraph<T>                       //ͼ�ӿڣ�ͼ������������
{
    public static final int MAX_WEIGHT=99999;    //���Ȩֵ����ʾ�����ޣ�
    int vertexCount();                           //���ض�����
    T get(int i);                                //���ض���vi������Ԫ��
    int getWeight(int i, int j);                 //����<vi,vj>�ߵ�Ȩֵ
    int insertVertex(T x);                       //����Ԫ��ֵΪx�Ķ��㣬���ض������
    void insertEdge(int i, int j, int weight);   //����һ��ȨֵΪweight�ıߡ�vi,vj��
    void removeVertex(int i);                    //ɾ������v��������ı�
    void removeEdge(int i, int j);               //ɾ���ߡ�vi,vj��
    int getNextNeighbor(int i, int j);           //����vi��vj�����һ���ڽӶ������ 
    void DFSTraverse(int i);                     //�Ӷ���vi������ͼ����һ�����������������
    void BFSTraverse(int i);                     //�Ӷ���vi������ͼ����һ�ι��������������
}
//int getFirstNeighbor(int i);                 //���ض���vi�ĵ�һ���ڽӶ�������
