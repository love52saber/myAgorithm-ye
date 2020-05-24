
public class CirDoublyLinkedList_index 
{
    public static void main(String args[])
    {
        String[] value1={"A","A","B","A","B","B","A","B","A","C","A","B","A",};
        CirDoublyLinkedList<String> target = new CirDoublyLinkedList<String>(value1); //Ŀ��
        String[] value2={"A","B","A"};                 
        CirDoublyLinkedList<String> pattern = new CirDoublyLinkedList<String>(value2);//ģʽ
        System.out.println("target: "+target.toString());
        System.out.println("pattern: "+pattern.toString());
        
        System.out.print("target.index(pattern):  ");
        DLinkNode<String> start=target.head.next;
        while (start!=null)
        {
            start = target.index(start,pattern);              //�ӱ�ƥ�䣬BFģʽƥ���㷨
            if (start!=null)
            {
                System.out.print(start.data.toString()+"��");
                start=start.next;
            }
        }
        System.out.println();
        
        CirDoublyLinkedList<String> empty = new CirDoublyLinkedList<String>(); //�ձ�
        System.out.println("target.index(empty):  "+target.index(empty));
        System.out.println("empty.index(pattern):  "+empty.index(pattern));
    }

}
/*
target: (A,A,B,A,B,B,A,B,A,C,A,B,A)
pattern: (A,B,A)
target.index(pattern):  A��A��A��
target.index(empty):  null
empty.index(pattern):  null


*/