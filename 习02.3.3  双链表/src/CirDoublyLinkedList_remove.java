//��ϰ2.3�� ������������ƥ�䡢ɾ�����滻�ȶ��ӱ����������

public class CirDoublyLinkedList_remove 
{
    public static void main(String args[])
    {
        String[] valuea={"A","B","C","D","E","F","G","H","I","J","K"};
        CirDoublyLinkedList<String> lista = new CirDoublyLinkedList<String>(valuea);
        lista.remove(2,3);                                 //ɾ���ӱ�
        System.out.println("lista: "+lista.toString());        
        lista.remove(8,3);                                 //ɾ���ӱ�iԽ��
        System.out.println("lista: "+lista.toString());
        lista.remove(6,4);                                 //ɾ���ӱ�n����
        System.out.println("lista: "+lista.toString());
    }
}

/*
�������н�����£�    
lista: (A,B,F,G,H,I,J,K)
lista: (A,B,F,G,H,I,J,K)
lista: (A,B,F,G,H,I)

*/
