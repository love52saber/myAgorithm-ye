//����2.1��ʹ��˳�����SeqList���Լɪ�����⡣
//����2.2��ʹ�õ��������Լɪ�����⡣
 
public class Josephus_CirDoublyLinkedList
{
    private CirDoublyLinkedList<String> list;         //�洢Լɪ���ж������

       //����Լɪ�򻷲���⣬����ָ�������ȡ���ʼλ�á�����
    public Josephus_CirDoublyLinkedList(int number, int start, int distance)
    {
        this.list = new CirDoublyLinkedList<String>();
        for (int i=0; i<number; i++)
            this.list.append(new String((char)('A'+i)+""));
        System.out.print("Լɪ��("+number+","+start+","+distance+")��");
        System.out.println(this.list.toString());

        int index = start-1;                               //������ʼλ��
        while (this.list.length()>1)                       //����һ������ʱѭ�� 
        {
            index = (index+distance-1) % this.list.length();
            System.out.print("ɾ��"+this.list.remove(index).toString()+"��");  //ɾ��ָ��λ�ö���
            System.out.println(this.list.toString());
        }
        System.out.println("����������"+list.get(0).toString());
    }
    
    public static void main(String args[])
    {
        new Josephus_CirDoublyLinkedList(5,1,2);
    }
}
    
/*
�������н�����£�
Լɪ��(5,1,2)��(A, B, C, D, E)
ɾ��B��(A, C, D, E)
ɾ��D��(A, C, E)
ɾ��A��(C, E)
ɾ��E��(C)
����������C


*/