//����ѭ��˫����

public class SortedDoublyLinkedList_ex 
{
	public static Integer[] random(int n)              //���ز���n�������������
	{
	    Integer[] elements = new Integer[n];
	    for (int i=0; i<n; i++)
	        elements[i] = (int)(Math.random()*100);   //���������
	    return elements;
	}
	
	public static void main(String args[])
	{
/*		SortedDoublyLinkedList<Integer> list1 = new SortedDoublyLinkedList<Integer>(random(9));
//        list1.insert(-1, -1);                    //���ǵ�������ķ�����û��ִ�в���
//        list1.insert(-2);                        //����ָ��ֵ��㣬��������������ķ���
        System.out.println("list1: "+list1.toString());        
/*        SortedDoublyLinkedList<Integer> list2 = new SortedDoublyLinkedList<Integer>(list1);//���
        System.out.println("list2: "+list2.toString());
        list1.remove(list1.length()-1);          //ɾ������㣬����������int�����õ�������ķ���
        list1.remove(list1.get(0));              //ɾ���׸���㣬����������Integer����������������ķ���
        list1.remove(new Integer(50));           //ɾ��ָ��ֵ��㣬����ûɾ��
        System.out.println("list1: "+list1.toString());
        list1.printPrevious();
        System.out.println("list2: "+list2.toString());
        list2.printPrevious();
*/
        //ϰ��2
        CirSinglyLinkedList<Integer> list3 = new CirSinglyLinkedList<Integer>(random(9));//������
        System.out.println("list3: "+list3.toString());        
        SortedDoublyLinkedList<Integer> list4=new SortedDoublyLinkedList<Integer>(list3);//�ɵ�����������ѭ��˫����
        System.out.println("list4: "+list4.toString());
/*
        //��9�£�
        list3.merge(list4);                           //�鲢��������ѭ��˫����
        System.out.println("�鲢��list3: "+list3.toString());
        list3.printPrevious();
        System.out.println("list4: "+list4.toString());

/*       //��9�£�  ��ѭ��˫����list��������ѭ��˫����ֱ��ѡ������
        CirDoublyLinkedList<Integer> list1 = new CirDoublyLinkedList<Integer>(random(9));
        System.out.println("list1: "+list1.toString());        
        SortedDoublyLinkedList<Integer> list2 = new SortedDoublyLinkedList<Integer>(list1);
        System.out.println("list2: "+list2.toString());    
        list2.printPrevious();*/
	}
}
/*
�������н�����£�
list1: (-2, 0, 1, 4, 8, 34, 38, 67, 86, 88)
list2: (-2, 0, 1, 4, 8, 34, 38, 67, 86, 88)
list1: (0, 1, 4, 8, 34, 38, 67, 86)
(86, 67, 38, 34, 8, 4, 1, 0)
list2: (-2, 0, 1, 4, 8, 34, 38, 67, 86, 88)
(88, 86, 67, 38, 34, 8, 4, 1, 0, -2)
list3: (45, 6, 37, 8, 19, 86, 26, 77, 22)
list4: (6, 8, 19, 22, 26, 37, 45, 77, 86)

list3: (71,53,51,53,20,0,74,34,94)
list4: (0,20,34,51,53,53,71,74,94)

*/