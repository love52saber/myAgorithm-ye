//7.2.2   ͼ���ڽӱ��ʾ��ʵ��
//�����Ԫ����

public class Vertex<T>                                     //�����Ԫ��
{
    public T data;                                         //����������
    public SortedSinglyLinkedList<Edge> adjlink;           //�ö���ıߵ�����
    
    public Vertex(T data)
    {
        this.data = data;
        this.adjlink = new SortedSinglyLinkedList<Edge>(); //���춥��ʱ�����յ�����
    }
    public String toString()                               //���ض��㼰��ߵ�����������ַ���
    {
        return "\n"+this.data.toString()+"��"+this.adjlink.toString();
    }
}   
/*���У�ǳ����
 *     public Vertex(T data, SortedSinglyLinkedList<Edge> adjlink)
{
    this.data = data;
    this.adjlink = adjlink;       //���ø�ֵ
}
    public Vertex(T data)
    {
        this(data, new SortedSinglyLinkedList<Edge>());   //������ʱ�����յ�����
    }
*/
