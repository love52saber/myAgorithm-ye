//��ϰ2.3�� ������������ƥ�䡢ɾ�����滻�ȶ��ӱ����������

public class CirDoublyLinkedList_subex 
{
    public static void main(String args[])
    {
/*        String[] valuea={"A","B","C","D","E","F","G","H","I","J","K"};
        CirDoublyLinkedList<String> lista = new CirDoublyLinkedList<String>(valuea);
        int i=3, n=4;
        CirDoublyLinkedList<String> listb = lista.sub(i,n);   //�����ӱ�
        lista.append(listb);                               //�������ӱ�
        lista.insert(i, listb);
        System.out.println("lista: "+lista.toString());
        System.out.println("listb: "+listb.toString());

        String[] valuec={"X","Y","Z"};
        CirDoublyLinkedList<String> listc = new CirDoublyLinkedList<String>(valuec);
        lista.replaceAll(listb, listc);                    //ȫ���滻�ӱ�
        System.out.println("lista: "+lista.toString());   	
        lista.removeAll(listc);                            //ȫ��ɾ���ӱ�
        System.out.println("lista: "+lista.toString());
        System.out.println("listb: "+listb.toString());
        System.out.println("listc: "+listc.toString());    	
        lista.remove(i,10);                                 //ɾ���ӱ�
        System.out.println("lista: "+lista.toString());
        lista.concat(listb);                               //���Ӻϲ���ǳ��������ӱ�
        System.out.println("lista: "+lista.toString());
        System.out.println("listb: "+listb.toString());
*/       
        //�ӱ�ƥ�䣬2011������
        String[] value1={"A","A","B","A","B","B","A","B","A","C","A","B","A"}; //Ŀ��
        CirDoublyLinkedList<String> list1 = new CirDoublyLinkedList<String>(value1);
        String[] value2={"A","B","A"};                     //ģʽ
        CirDoublyLinkedList<String> list2 = new CirDoublyLinkedList<String>(value2);
        System.out.println("\nlist1: "+list1.toString());
        System.out.println("list2: "+list2.toString());
//        list1.replaceAll(list2.sub(0,0), list2);          //ȫ���滻�ӱ�
//        System.out.println("list1: "+list1.toString());    	
        
   	    list1.removeAll(list2);                           //ȫ��ɾ���ӱ�
        System.out.println("list1: "+list1.toString());
        System.out.println("list2: "+list2.toString());
    }
}

/*
�������н�����£�    
lista: (A, B, C, D, E, F, G, D, E, F, G, H, I, J, K, D, E, F, G)
listb: (D, E, F, G)
this: (A, B, C, X, Y, Z, D, E, F, G, H, I, J, K, D, E, F, G)
this: (A, B, C, X, Y, Z, X, Y, Z, H, I, J, K, D, E, F, G)
this: (A, B, C, X, Y, Z, X, Y, Z, H, I, J, K, X, Y, Z)
lista: (A, B, C, X, Y, Z, X, Y, Z, H, I, J, K, X, Y, Z)
lista: (A, B, C, H, I, J, K)
listb: (D, E, F, G)
listc: (X, Y, Z)
lista: (A, B, C)
lista: (A, B, C, D, E, F, G)
listb: ()

list1: (A, A, B, A, B, B, A, B, A, C)
list2: (A, B, A)
this: (A, A, B, A, A, B, B, A, B, A, C)
this: (A, A, B, A, A, B, A, B, A, B, A, C)
this: (A, A, B, A, A, B, A, B, A, A, B, A, C)
this: (A, A, B, A, A, B, A, B, A, A, B, A, A, C)
list1: (A, A, B, A, A, B, A, B, A, A, B, A, A, C)
list1: (A, B, A, A, C)
list2: (A, B, A)



*/
