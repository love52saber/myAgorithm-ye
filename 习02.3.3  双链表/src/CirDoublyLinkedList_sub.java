//��ϰ2.3�� ������������ƥ�䡢ɾ�����滻�ȶ��ӱ����������

public class CirDoublyLinkedList_sub 
{
    public static void main(String args[])
    {
        String[] valuea={"A","B","C","D","E","F","G","H"};
        CirDoublyLinkedList<String> lista = new CirDoublyLinkedList<String>(valuea);
        System.out.println(lista.toString()+".sub(2,3)="+lista.sub(2,3));      //�����ӱ�
        System.out.println(lista.toString()+".sub(2,0)="+lista.sub(2,0));      //n=0�����ؿ�����
        System.out.println(lista.toString()+".sub(6,5)="+lista.sub(6,5));      //n��������������β���ӱ�
        System.out.println(lista.toString()+".sub(9,3)="+lista.sub(9,3));      //i>�������ؿ�����
//        System.out.println(lista.toString()+".sub(-1,3)="+lista.sub(-1,3));    //i<0���׳����Խ���쳣
//        System.out.println(lista.toString()+".sub(1,-3)="+lista.sub(1,-3));    //n<0���׳���Ч�����쳣
    }
} 

/*
�������н�����£�    
(A,B,C,D,E,F,G,H).sub(2,3)=(C,D,E)
(A,B,C,D,E,F,G,H).sub(2,0)=()
(A,B,C,D,E,F,G,H).sub(6,5)=(G,H)
(A,B,C,D,E,F,G,H).sub(9,3)=()
Exception in thread "main" java.lang.IndexOutOfBoundsException: -1
	at SinglyLinkedList.sub(SinglyLinkedList.java:273)
	at SinglyLinkedList_sub.main(SinglyLinkedList_sub.java:13)


*/
