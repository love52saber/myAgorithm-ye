//【习2.3】 单链表类增加匹配、删除、替换等对子表操作方法。

public class CirDoublyLinkedList_removeAll 
{
    public static void main(String args[])
    {
        String[] value1={"A","A","B","A","B","A","B","A","C","A","B","A",};
        CirDoublyLinkedList<String> target = new CirDoublyLinkedList<String>(value1); //目标
        String[] value2={"A","B","A"};                 
        CirDoublyLinkedList<String> pattern = new CirDoublyLinkedList<String>(value2);//模式
        target.removeAll(pattern);
        
        CirDoublyLinkedList<String> empty = new CirDoublyLinkedList<String>(); //空表
        target.removeAll(empty);
        empty.removeAll(pattern);
        
        String[] valuec={"X","Y","Z"};
        pattern = new CirDoublyLinkedList<String>(valuec);
        target.removeAll(pattern);                           //没有匹配的
    }
}

/*
程序运行结果如下：    
将(A,A,B,A,B,A,B,A,C,A,B,A)中(A,B,A)全部删除的结果是(A,B,C)
将(A,B,C)中()全部删除
将()中(A,B,A)全部删除的结果是()

*/
