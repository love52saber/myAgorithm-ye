//��ϰ2.3�� ������������ƥ�䡢ɾ�����滻�ȶ��ӱ����������

public class SinglyLinkedList_removeAll 
{
    public static void main(String args[])
    {
        String[] value1={"A","A","B","A","B","A","B","A","C","A","B","A",};
        SinglyLinkedList<String> target = new SinglyLinkedList<String>(value1); //Ŀ��
        String[] value2={"A","B","A"};                 
        SinglyLinkedList<String> pattern = new SinglyLinkedList<String>(value2);//ģʽ
        target.removeAll(pattern);
        
        SinglyLinkedList<String> empty = new SinglyLinkedList<String>(); //�ձ�
        target.removeAll(empty);
        empty.removeAll(pattern);
        
        String[] valuec={"X","Y","Z"};
        pattern = new SinglyLinkedList<String>(valuec);
        target.removeAll(pattern);                           //û��ƥ���
    }
}

/*
�������н�����£�    
��(A,A,B,A,B,A,B,A,C,A,B,A)��(A,B,A)ȫ��ɾ���Ľ����(A,B,C)
��(A,B,C)��()ȫ��ɾ��
��()��(A,B,A)ȫ��ɾ���Ľ����()

*/
