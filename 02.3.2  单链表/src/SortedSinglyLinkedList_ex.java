//��2.5 ��������

public class SortedSinglyLinkedList_ex 
{
    public static Integer[] random(int n)              //���ز���n������������飬ͬ��2.3
    {
        Integer[] elements = new Integer[n];
        for (int i=0; i<n; i++)
            elements[i] = (int)(Math.random()*100);   //���������
        return elements;
    }
	
    public static void main(String args[])
    {
/*        //��2.5 
        SortedSinglyLinkedList<Integer> list1 = new SortedSinglyLinkedList<Integer>(random(9));
//        list1.insert(-1, -1);                    //���ǵ�������ķ������׳��쳣
        list1.insert(-2);                        //����ָ��ֵ��㣬��������������ķ���
        System.out.println("list1: "+list1.toString());        
        SortedSinglyLinkedList<Integer> list2=new SortedSinglyLinkedList<Integer>(list1);//���
        System.out.println("list2: "+list2.toString());
        list1.remove(list1.length()-1);          //ɾ������㣬����������int�����õ�������ķ���
        list1.remove(list1.get(0));              //ɾ���׸���㣬����������Integer����������������ķ���
        list1.remove(new Integer(50));           //ɾ��ָ��ֵ��㣬����ûɾ��
        System.out.println("list1: "+list1.toString());
        System.out.println("list2: "+list2.toString());

        //ϰ��2
        SinglyLinkedList<Integer> list3 = new SinglyLinkedList<Integer>(random(9));//������
        System.out.println("list3: "+list3.toString());        
        SortedSinglyLinkedList<Integer> list4=new SortedSinglyLinkedList<Integer>(list3);//�ɵ���������������
        System.out.println("list4: "+list4.toString());*/


        //��9�£��ɵ�����list������������ֱ��ѡ������
    	SinglyLinkedList<Integer> list1 = new SinglyLinkedList<Integer>(random(7));
        System.out.println("������list1: "+list1.toString());        
        SortedSinglyLinkedList<Integer> list2 = new SortedSinglyLinkedList<Integer>(list1);
        System.out.println("��������list2: "+list2.toString());    
//        list1.set(0, new Integer(list1.get(0).intValue()+100));        
//        System.out.println("list1: "+list1.toString());        
//        System.out.println("list2: "+list2.toString());    
//      list1.merge(list2);                           //�鲢������������
//      System.out.println("�鲢��list1: "+list1.toString());
//      System.out.println("list2: "+list2.toString());
    }
}
/*
�������н�����£�    
list1: (-2, 1, 21, 21, 23, 44, 59, 65, 83, 95)
list2: (-2, 1, 21, 21, 23, 44, 59, 65, 83, 95)
list1: (1, 21, 21, 23, 44, 59, 65, 83)
list2: (-2, 1, 21, 21, 23, 44, 59, 65, 83, 95)
//ϰ��2
list3: (92, 98, 45, 74, 66, 0, 87, 45, 2)
list4: (0, 2, 45, 45, 66, 74, 87, 92, 98)



�鲢��list1: (11, 12, 20, 24, 29, 34, 35, 40, 51, 55, 78, 86, 89)
list2: ()

list1: (1, 7, 8, 34, 36)
list2: (27, 78, 85, 90)
�鲢��list1: (1, 7, 8, 27, 34, 36, 78, 85, 90)
list2: ()

//��9�£��ɵ�����list������������ѡ������
list1: (95, 22, 99, 9, 28, 67, 71, 82, 86)
list2: (9, 22, 28, 67, 71, 82, 86, 95, 99)

list1: (70, 45, 53, 48, 11, 1, 4)
list2: (1, 4, 11, 45, 48, 53, 70)
list1: (170, 45, 53, 48, 11, 1, 4)
list2: (1, 4, 11, 45, 48, 53, 70)

//��4��Ľ�����
������list1: (95,79,41,26,45,92,82)
(26,79,41,95,45,92,82)
(26,41,79,95,45,92,82)
(26,41,45,95,79,92,82)
(26,41,45,79,95,92,82)
(26,41,45,79,82,92,95)
(26,41,45,79,82,92,95)
(26,41,45,79,82,92,95)
��������list2: (26,41,45,79,82,92,95)

�������������£�
        SinglyLinkedList<Object> list3 = new SinglyLinkedList<Object>();
//        SortedSinglyLinkedList<Object> list4 = new SortedSinglyLinkedList<Object>();
                                         //�����Object�಻����ΪE��ʵ�ʲ�����û��ʵ��ʵ��Comparable<E>�ӿ�
        SortedSinglyLinkedList<Integer> list4 = new SortedSinglyLinkedList<Integer>();
//        list4.insert(new Object());     //������������Ͳ�ƥ��
*/
