//��ϰ2.3�� ������������ƥ�䡢ɾ�����滻�ȶ��ӱ����������

public class SinglyLinkedList_remove 
{
    public static void main(String args[])
    {
        String[] valuea={"A","B","C","D","E","F","G","H","I","J","K"};
        SinglyLinkedList<String> lista = new SinglyLinkedList<String>(valuea);
        System.out.print(lista.toString()+"ִ��remove(2,3)��Ϊ ");        
        lista.remove(2,3);                                 //ɾ���ӱ�
        System.out.println(lista.toString());
        System.out.print(lista.toString()+"ִ��remove(8,3)��Ϊ ");        
        lista.remove(8,3);                                 //iԽ�磬��ɾ��
        System.out.println(lista.toString());
        System.out.print(lista.toString()+"ִ��remove(6,4)��Ϊ ");        
        lista.remove(6,4);                                 //n������ɾ������β���ӱ�
        System.out.println(lista.toString());
    }
}

/*
�������н�����£�    
(A,B,C,D,E,F,G,H,I,J,K)ִ��remove(2,3)��Ϊ (A,B,F,G,H,I,J,K)
(A,B,F,G,H,I,J,K)ִ��remove(8,3)��Ϊ (A,B,F,G,H,I,J,K)
(A,B,F,G,H,I,J,K)ִ��remove(6,4)��Ϊ (A,B,F,G,H,I)


*/
