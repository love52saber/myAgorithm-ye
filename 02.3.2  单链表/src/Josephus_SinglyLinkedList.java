//����2.2��ʹ�õ��������Լɪ�����⡣
//ͬ˳���

public class Josephus_SinglyLinkedList
{
    //����Լɪ�򻷲���⣬����ָ�������ȡ���ʼλ�á�����
	public Josephus_SinglyLinkedList(int number, int start, int distance)
    {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
                   //���õ�����洢Լɪ�򻷵�Ԫ�أ�Ԫ���������ַ���
        for (int i=number-1; i>=0; i--)
            list.insert(0, (char)('A'+i)+"");
        System.out.print("Լɪ��("+number+","+start+","+distance+")��");
        System.out.println(list.toString());

        int i = start-1;                              //������ʼλ��
        while (list.length()>1) 
        {
            i = (i+distance-1) % list.length();
            System.out.print("ɾ��"+list.remove(i).toString()+"��");
            System.out.println(list.toString());
        }
        System.out.println("����������"+list.get(0).toString());
    }
    
    public static void main(String args[])
    {
        new Josephus_SinglyLinkedList(5,1,2);
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