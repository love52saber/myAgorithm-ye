//������

import java.util.Iterator;

public class SinglyLinkedList_ex 
{	
    public static void main(String args[])
    {
/*    	SinglyLinkedList<String> lista = new SinglyLinkedList<String>();
//        for (int i=5; i>=0; i--)
        for (int i=0; i<=5; i++)
            lista.insert(i, new String((char)('A'+i)+""));
        System.out.println("lista: "+lista.toString()+"��length()="+lista.length());
        lista.set(3, new String((char)(lista.get(0).charAt(0)+32)+""));
        lista.remove(0);
        lista.remove(3);
//        lista.remove(10);                             //�׳��쳣
        System.out.println("lista: "+lista.toString());
*/
    	
        //�����Ƚ����
    	SinglyLinkedList<Integer> list1 = new SinglyLinkedList<Integer>();   //�ձ�
        System.out.println("list1: "+list1.toString());
    	SinglyLinkedList<Integer> list2 = new SinglyLinkedList<Integer>();   //�ձ�
        System.out.println("list2: "+list2.toString());
        System.out.println("list1.equals(list2)? "+list1.equals(list2));

    	list1 = new SinglyLinkedList<Integer>(SinglyLinkedList_average.random(5));  //���ز���n�������������
        System.out.println("list1: "+list1.toString());
        list2 = new SinglyLinkedList<Integer>(list1);               //�������췽��
        System.out.println("list2: "+list2.toString());
        System.out.println("list1.equals(list2)? "+list1.equals(list2));

        System.out.println("list1: "+list1.toString());
        list2.set(0, new Integer(list1.get(0).intValue()+100));
        list2.remove(list2.length()-1);                    //ɾ�����һ��Ԫ��
        list2.remove(100);                                 //���Խ�磬ûɾ��
        System.out.println("list2: "+list2.toString());
        System.out.println("list1.equals(list2)? "+list1.equals(list2));

        //10.2   ʵ�ֵ�����
        Iterator<Integer> it = list1.iterator();      //��õ��������������
        int sum=0;
        while (it.hasNext())
        {
            int value=it.next().intValue();
        	sum += value;
    	    System.out.print(value);
        	if (it.hasNext())
        	    System.out.print("+");
        }        	
        System.out.println("="+sum);
    }
}

/*
�������н�����£�    
lista: (A, F, B, E, C, D)
lista: (F, B, e, D)

        //�����Ƚ����
list1: ()
list2: ()
list1.equals(list2)? true
list1: (44, 10, 11, 20, 72)
list2: (44, 10, 11, 20, 72)
list1.equals(list2)? true
list1: (44, 10, 11, 20, 72)
list2: (144, 10, 11, 20)
list1.equals(list2)? false
44+10+11+20+72=157


*/
