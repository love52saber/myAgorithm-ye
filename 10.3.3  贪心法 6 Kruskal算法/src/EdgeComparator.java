//EdgeComparator��ʵ�ֱȽ����ӿڣ��ṩͼ�ı���Edge��Ȩֵ�Ƚϴ�С�ķ���
class EdgeComparator implements java.util.Comparator<Edge>
{
    public int compare(Edge e1, Edge e2)         //ͼ�ı߰�Ȩֵ�Ƚϴ�С����������
    {
        return (int)(e1.weight - e2.weight);  
    }
}
