//【习2.3】 单链表类增加匹配、删除、替换等对子表操作方法。

public class CirDoublyLinkedList_sub 
{
    public static void main(String args[])
    {
        String[] valuea={"A","B","C","D","E","F","G","H"};
        CirDoublyLinkedList<String> lista = new CirDoublyLinkedList<String>(valuea);
        System.out.println(lista.toString()+".sub(2,3)="+lista.sub(2,3));      //返回子表
        System.out.println(lista.toString()+".sub(2,0)="+lista.sub(2,0));      //n=0，返回空链表
        System.out.println(lista.toString()+".sub(6,5)="+lista.sub(6,5));      //n超长，返回至表尾的子表
        System.out.println(lista.toString()+".sub(9,3)="+lista.sub(9,3));      //i>表长，返回空链表
//        System.out.println(lista.toString()+".sub(-1,3)="+lista.sub(-1,3));    //i<0，抛出序号越界异常
//        System.out.println(lista.toString()+".sub(1,-3)="+lista.sub(1,-3));    //n<0，抛出无效参数异常
    }
} 

/*
程序运行结果如下：    
(A,B,C,D,E,F,G,H).sub(2,3)=(C,D,E)
(A,B,C,D,E,F,G,H).sub(2,0)=()
(A,B,C,D,E,F,G,H).sub(6,5)=(G,H)
(A,B,C,D,E,F,G,H).sub(9,3)=()
Exception in thread "main" java.lang.IndexOutOfBoundsException: -1
	at SinglyLinkedList.sub(SinglyLinkedList.java:273)
	at SinglyLinkedList_sub.main(SinglyLinkedList_sub.java:13)


*/
