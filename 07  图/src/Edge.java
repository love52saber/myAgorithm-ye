//7.2   ͼ�ı�ʾ��ʵ��
//7.2.1   ͼ���ڽӾ����ʾ��ʵ��
//7.2.2   ͼ���ڽӱ��ʾ��ʵ��
//��Ȩֵ�ı���

public class Edge implements Comparable<Edge>    //��Ȩֵ�ı���
{
    public int start,dest,weight;                //�ߵ������š��յ���ź�Ȩֵ
    
    public Edge(int start, int dest, int weight)
    {
        this.start = start;
        this.dest = dest;
        this.weight = weight;
    }

    public String toString()                     //���ر������ַ�������ʽΪ��(������,�յ����,Ȩֵ)��
    {
        return "("+start+","+dest+","+weight+")";
    }

    //�Ƚ������ߴ�С��Լ��������������ȹ���ֻ�Ƚ������յ㣬���Ƚ�Ȩֵ
    public int compareTo(Edge e)                 
    {
        if (this.start!=e.start)
            return this.start - e.start;         //����㲻��ͬʱ���������Ĳ�ֵ
        return this.dest - e.dest;               //�������ͬʱ�������յ�Ĳ�ֵ
    }
}   
 