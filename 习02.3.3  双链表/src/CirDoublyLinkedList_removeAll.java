//��ϰ2.3�� ������������ƥ�䡢ɾ�����滻�ȶ��ӱ����������

public class CirDoublyLinkedList_removeAll 
{
    public static void main(String args[])
    {
        String[] value1={"A","A","B","A","B","A","B","A","C","A","B","A",};
        CirDoublyLinkedList<String> target = new CirDoublyLinkedList<String>(value1); //Ŀ��
        String[] value2={"A","B","A"};                 
        CirDoublyLinkedList<String> pattern = new CirDoublyLinkedList<String>(value2);//ģʽ
        target.removeAll(pattern);
        
        CirDoublyLinkedList<String> empty = new CirDoublyLinkedList<String>(); //�ձ�
        target.removeAll(empty);
        empty.removeAll(pattern);
        
        String[] valuec={"X","Y","Z"};
        pattern = new CirDoublyLinkedList<String>(valuec);
        target.removeAll(pattern);                           //û��ƥ���
    }
}

/*
�������н�����£�    
��(A,A,B,A,B,A,B,A,C,A,B,A)��(A,B,A)ȫ��ɾ���Ľ����(A,B,C)
��(A,B,C)��()ȫ��ɾ��
��()��(A,B,A)ȫ��ɾ���Ľ����()

*/
