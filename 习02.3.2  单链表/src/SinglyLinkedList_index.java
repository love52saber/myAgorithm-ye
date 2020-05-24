
public class SinglyLinkedList_index 
{
    public static void main(String args[])
    {
        String[] value1={"A","A","B","A","B","B","A","B","A","C","A","B","A",};
        SinglyLinkedList<String> target = new SinglyLinkedList<String>(value1); //目标
        String[] value2={"A","B","A"};                 
        SinglyLinkedList<String> pattern = new SinglyLinkedList<String>(value2);//模式
        System.out.println("target: "+target.toString());
        System.out.println("pattern: "+pattern.toString());
        
        System.out.print("target.index(pattern):  ");
        Node<String> start=target.head.next;
        while (start!=null)
        {
            start = target.index(start,pattern);              //子表匹配，BF模式匹配算法
            if (start!=null)
            {
                System.out.print(start.data.toString()+"，");
                start=start.next;
            }
        }
        System.out.println();
        
        SinglyLinkedList<String> empty = new SinglyLinkedList<String>(); //空表
        System.out.println("target.index(empty):  "+target.index(empty));
        System.out.println("empty.index(pattern):  "+empty.index(pattern));
    }

}
/*
target: (A,A,B,A,B,B,A,B,A,C,A,B,A)
pattern: (A,B,A)
target.index(pattern):  A，A，A，
target.index(empty):  null
empty.index(pattern):  null


*/