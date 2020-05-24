//��2.4 ��������ת

public class SinglyLinkedList_reverse 
{
    //����������ת�����ͷ���������ֵ����ǰ�������Ͳ���T
    public static <T> void reverse(SinglyLinkedList<T> list)
    {
        Node<T> p=list.head.next, succ=null, front=null;   //head��������Ϊpublic 
        while (p!=null)
        {
            succ = p.next;                                 //����succ��p���ĺ�̽��
            p.next = front;                                //ʹp.nextָ��p����ǰ�����
            front = p;
            p = succ;                                      //p�����һ��
        }
        list.head.next = front;
    }
  
    public static void main(String args[])
    {
        String value[]={"A","B","C","D","E","F"};
        SinglyLinkedList<String> list = new SinglyLinkedList<String>(value);
        System.out.println("list: "+list.toString());
        reverse(list);
        System.out.println("��ת�� "+list.toString());
    }
}
/*
�������н�����£�    
list: (A, B, C, D, E, F)
��ת�� (F, E, D, C, B, A)

*/
    