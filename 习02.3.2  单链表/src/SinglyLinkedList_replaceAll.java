
public class SinglyLinkedList_replaceAll 
{
    public static void main(String args[])
    {
        String[] value1={"A","A","B","A","B","B","A","B","A","C","A","B","A"};
        SinglyLinkedList<String> target = new SinglyLinkedList<String>(value1); //目标        
        String[] value2={"A","B","A"};                    
        SinglyLinkedList<String> dest = new SinglyLinkedList<String>(value2);
        SinglyLinkedList<String> pattern = dest.sub(0,2);        
        target.replaceAll(pattern, dest);        
        target.replaceAll(dest,pattern);        
        SinglyLinkedList<String> empty = new SinglyLinkedList<String>(); //空表
        target.replaceAll(dest, empty);
        target.replaceAll(empty, dest);
        empty.replaceAll(pattern, dest);      
        
        String[] valuec={"X","Y","Z"};
        pattern = new SinglyLinkedList<String>(valuec);
        target.removeAll(pattern);                           //没有匹配的
    }

}
/*
将(A,A,B,A,B,B,A,B,A,C,A,B,A)中(A,B)全部替换为(A,B,A)的结果是(A,A,B,A,A,B,A,B,A,B,A,A,C,A,B,A,A)
将(A,A,B,A,A,B,A,B,A,B,A,A,C,A,B,A,A)中(A,B,A)全部替换为(A,B)的结果是(A,A,B,A,B,B,A,B,A,C,A,B,A)
将(A,A,B,A,B,B,A,B,A,C,A,B,A)中(A,B,A)全部替换为()的结果是(A,B,B,C)
将(A,B,B,C)中()全部替换为(A,B,A)将()中(A,B)全部替换为(A,B,A)的结果是()
将(A,B,B,C)中(X,Y,Z)全部删除的结果是(A,B,B,C)


*/