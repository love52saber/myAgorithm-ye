//【习2.3】 单链表类增加匹配、删除、替换等对子表操作方法。

public class SinglyLinkedList_set 
{
    public static void main(String args[])
    {
        String[] valuea={"A","B","C","D","E","F","G","H"};
        SinglyLinkedList<String> lista = new SinglyLinkedList<String>(valuea);
        System.out.println("lista: "+lista.toString());
        lista.set(2,"X");
        System.out.println("lista.set(2,\"X\")，"+lista.toString());
        lista.set(-2,"Y");                                 //i<0，抛出序号越界异常
        lista.set(12,"Z");                                 //i>表长，抛出序号越界异常
    }
} 

/*
程序运行结果如下：    
lista: (A,B,C,D,E,F,G,H)
lista.set(2,"X")，(A,B,X,D,E,F,G,H)
Exception in thread "main" java.lang.IndexOutOfBoundsException: -2
	at SinglyLinkedList.set(SinglyLinkedList.java:78)
	at SinglyLinkedList_set.main(SinglyLinkedList_set.java:12)

lista: (A,B,C,D,E,F,G,H)
Exception in thread "main" lista.set(2,"X")，(A,B,X,D,E,F,G,H)
java.lang.IndexOutOfBoundsException: 12
	at SinglyLinkedList.set(SinglyLinkedList.java:78)
	at SinglyLinkedList_set.main(SinglyLinkedList_set.java:13)


*/
