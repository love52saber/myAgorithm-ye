//【习2.3】 单链表类增加匹配、删除、替换等对子表操作方法。

public class SinglyLinkedList_remove 
{
    public static void main(String args[])
    {
        String[] valuea={"A","B","C","D","E","F","G","H","I","J","K"};
        SinglyLinkedList<String> lista = new SinglyLinkedList<String>(valuea);
        System.out.print(lista.toString()+"执行remove(2,3)后为 ");        
        lista.remove(2,3);                                 //删除子表
        System.out.println(lista.toString());
        System.out.print(lista.toString()+"执行remove(8,3)后为 ");        
        lista.remove(8,3);                                 //i越界，不删除
        System.out.println(lista.toString());
        System.out.print(lista.toString()+"执行remove(6,4)后为 ");        
        lista.remove(6,4);                                 //n超长，删除至表尾的子表
        System.out.println(lista.toString());
    }
}

/*
程序运行结果如下：    
(A,B,C,D,E,F,G,H,I,J,K)执行remove(2,3)后为 (A,B,F,G,H,I,J,K)
(A,B,F,G,H,I,J,K)执行remove(8,3)后为 (A,B,F,G,H,I,J,K)
(A,B,F,G,H,I,J,K)执行remove(6,4)后为 (A,B,F,G,H,I)


*/
