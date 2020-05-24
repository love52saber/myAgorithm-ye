
public class SinglyLinkedList_replaceAll 
{
    public static void main(String args[])
    {
        String[] value1={"A","A","B","A","B","B","A","B","A","C","A","B","A"};
        SinglyLinkedList<String> target = new SinglyLinkedList<String>(value1); //Ŀ��        
        String[] value2={"A","B","A"};                    
        SinglyLinkedList<String> dest = new SinglyLinkedList<String>(value2);
        SinglyLinkedList<String> pattern = dest.sub(0,2);        
        target.replaceAll(pattern, dest);        
        target.replaceAll(dest,pattern);        
        SinglyLinkedList<String> empty = new SinglyLinkedList<String>(); //�ձ�
        target.replaceAll(dest, empty);
        target.replaceAll(empty, dest);
        empty.replaceAll(pattern, dest);      
        
        String[] valuec={"X","Y","Z"};
        pattern = new SinglyLinkedList<String>(valuec);
        target.removeAll(pattern);                           //û��ƥ���
    }

}
/*
��(A,A,B,A,B,B,A,B,A,C,A,B,A)��(A,B)ȫ���滻Ϊ(A,B,A)�Ľ����(A,A,B,A,A,B,A,B,A,B,A,A,C,A,B,A,A)
��(A,A,B,A,A,B,A,B,A,B,A,A,C,A,B,A,A)��(A,B,A)ȫ���滻Ϊ(A,B)�Ľ����(A,A,B,A,B,B,A,B,A,C,A,B,A)
��(A,A,B,A,B,B,A,B,A,C,A,B,A)��(A,B,A)ȫ���滻Ϊ()�Ľ����(A,B,B,C)
��(A,B,B,C)��()ȫ���滻Ϊ(A,B,A)��()��(A,B)ȫ���滻Ϊ(A,B,A)�Ľ����()
��(A,B,B,C)��(X,Y,Z)ȫ��ɾ���Ľ����(A,B,B,C)


*/