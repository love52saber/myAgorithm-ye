
public class CirDoublyLinkedList_replaceAll 
{
    public static void main(String args[])
    {
        String[] value1={"A","A","B","A","B","B","A","B","A","C","A","B","A"}; //目标
        CirDoublyLinkedList<String> target = new CirDoublyLinkedList<String>(value1);        
        String[] value2={"A","B","A"};                    
        CirDoublyLinkedList<String> dest = new CirDoublyLinkedList<String>(value2);
        CirDoublyLinkedList<String> pattern = dest.sub(0,2);        
        target.replaceAll(dest, pattern);
        target.replaceAll(pattern, dest);        
        CirDoublyLinkedList<String> empty = new CirDoublyLinkedList<String>(); //空表
        target.replaceAll(dest, empty);
        target.replaceAll(empty, dest);
        
        String[] valuec={"X","Y","Z"};
        pattern = new CirDoublyLinkedList<String>(valuec);
        target.removeAll(pattern);                           //没有匹配的
    }

}
/*
将(A,A,B,A,B,B,A,B,A,C,A,B,A)中(A,B,A)全部替换为(A,B)的结果是(A,A,B,B,B,A,B,C,A,B)
将(A,A,B,B,B,A,B,C,A,B)中(A,B)全部替换为(A,B,A)的结果是(A,A,B,A,B,B,A,B,A,C,A,B,A)
将(A,A,B,A,B,B,A,B,A,C,A,B,A)中(A,B,A)全部替换为()的结果是(A,B,B,C)
将(A,B,B,C)中()全部替换为(A,B,A)的结果是
将(A,B,B,C)中(X,Y,Z)全部删除的结果是(A,B,B,C)

*/