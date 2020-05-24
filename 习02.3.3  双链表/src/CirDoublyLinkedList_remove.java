//【习2.3】 单链表类增加匹配、删除、替换等对子表操作方法。

public class CirDoublyLinkedList_remove 
{
    public static void main(String args[])
    {
        String[] valuea={"A","B","C","D","E","F","G","H","I","J","K"};
        CirDoublyLinkedList<String> lista = new CirDoublyLinkedList<String>(valuea);
        lista.remove(2,3);                                 //删除子表
        System.out.println("lista: "+lista.toString());        
        lista.remove(8,3);                                 //删除子表，i越界
        System.out.println("lista: "+lista.toString());
        lista.remove(6,4);                                 //删除子表，n超长
        System.out.println("lista: "+lista.toString());
    }
}

/*
程序运行结果如下：    
lista: (A,B,F,G,H,I,J,K)
lista: (A,B,F,G,H,I,J,K)
lista: (A,B,F,G,H,I)

*/
