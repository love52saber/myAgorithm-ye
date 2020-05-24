
public class CirDoublyLinkedList_replaceAll 
{
    public static void main(String args[])
    {
        String[] value1={"A","A","B","A","B","B","A","B","A","C","A","B","A"}; //Ŀ��
        CirDoublyLinkedList<String> target = new CirDoublyLinkedList<String>(value1);        
        String[] value2={"A","B","A"};                    
        CirDoublyLinkedList<String> dest = new CirDoublyLinkedList<String>(value2);
        CirDoublyLinkedList<String> pattern = dest.sub(0,2);        
        target.replaceAll(dest, pattern);
        target.replaceAll(pattern, dest);        
        CirDoublyLinkedList<String> empty = new CirDoublyLinkedList<String>(); //�ձ�
        target.replaceAll(dest, empty);
        target.replaceAll(empty, dest);
        
        String[] valuec={"X","Y","Z"};
        pattern = new CirDoublyLinkedList<String>(valuec);
        target.removeAll(pattern);                           //û��ƥ���
    }

}
/*
��(A,A,B,A,B,B,A,B,A,C,A,B,A)��(A,B,A)ȫ���滻Ϊ(A,B)�Ľ����(A,A,B,B,B,A,B,C,A,B)
��(A,A,B,B,B,A,B,C,A,B)��(A,B)ȫ���滻Ϊ(A,B,A)�Ľ����(A,A,B,A,B,B,A,B,A,C,A,B,A)
��(A,A,B,A,B,B,A,B,A,C,A,B,A)��(A,B,A)ȫ���滻Ϊ()�Ľ����(A,B,B,C)
��(A,B,B,C)��()ȫ���滻Ϊ(A,B,A)�Ľ����
��(A,B,B,C)��(X,Y,Z)ȫ��ɾ���Ľ����(A,B,B,C)

*/