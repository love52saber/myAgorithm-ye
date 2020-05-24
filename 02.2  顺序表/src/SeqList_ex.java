//2.2   ���Ա��˳���ʾ��ʵ��

public class SeqList_ex 
{
    public static Integer[] random(int n)              //���ز���n�������������
    {
        Integer[] elements = new Integer[n];
        for (int i=0; i<n; i++)
        	elements[i] = new Integer((int)(Math.random()*100));   //���������
        return elements;
    }
	
    public static void main(String args[])
    {
    	//˳���
/*        SeqList<String> lista = new SeqList<String>(4);    //ִ��Ĭ�Ϲ��췽��
        for (int i=5; i>=0; i--)
            lista.insert(i, new String((char)('A'+i)+"")); //����
        System.out.println("lista: "+lista.toString());
        SeqList<String> listb = new SeqList<String>(lista);//ִ�п������췽��
        System.out.println("listb: "+listb.toString());
        lista.set(3, new String((char)(lista.get(3).charAt(0)+32)+""));
        lista.remove(0);
        lista.remove(3);
        lista.remove(10);                                  //���Խ�磬ûɾ��
        System.out.println("lista: "+lista.toString());
        System.out.println("listb: "+listb.toString());
        //���ڿ������췽��ʵ��Ϊ�������������ǳ����������Integer�ǳ�������new ������һ������ 
        //���������ֻ��˵������˳������ֱ��и��Ե����飬������Ԫ�ؿ����ò�ͬ����
        //������˵������ͬһ�������µ������޸Ĵ���
*/
        //�����Ƚ����
    	SeqList<Integer> list1 = new SeqList<Integer>();   //�ձ�
        System.out.println("list1: "+list1.toString());
    	SeqList<Integer> list2 = new SeqList<Integer>();   //�ձ�
        System.out.println("list2: "+list2.toString());
        System.out.println("list1.equals(list2)? "+list1.equals(list2));

    	list1 = new SeqList<Integer>(random(5));
        System.out.println("list1: "+list1.toString());
        list2 = new SeqList<Integer>(list1);               //�������췽��
        System.out.println("list2: "+list2.toString());
        System.out.println("list1.equals(list2)? "+list1.equals(list2));

        System.out.println("list1: "+list1.toString());
        list2.set(0, new Integer(list1.get(0).intValue()+100));
        list2.remove(list2.length()-1);                    //ɾ�����һ��Ԫ��
        list2.remove(100);                                 //���Խ�磬ûɾ��
        System.out.println("list2: "+list2.toString());
        System.out.println("list1.equals(list2)? "+list1.equals(list2));
    }
}
/*
�������н�����£�    
//��1�� ǳ����
lista: (A, F, B, E, C, D) 
listb: (A, F, B, E, C, D) 
lista: (F, B, e, D) 
Exception in thread "main" java.lang.NullPointerException
	at SeqList.toString(SeqList.java:55)
	at SeqList_ex.main(SeqList_ex.java:30)
 
//��2�� ���������˵���������ȷ�ԣ���String��Integer�����ձ���
lista: (A, F, B, E, C, D) 
listb: (A, F, B, E, C, D) 
lista: (F, B, e, D) 
listb: (A, F, B, E, C, D) 

//�����Ƚ����
list1: () 
list2: () 
list1.equals(list2)? true
list1: (16, 14, 81, 74, 68) 
list2: (16, 14, 81, 74, 68) 
list1.equals(list2)? true
list1: (16, 14, 81, 74, 68) 
list2: (116, 14, 81, 74) 
list1.equals(list2)? false

*/

/*
��������������:
�������������£�
        SinglyLinkedList<Object> list3 = new SinglyLinkedList<Object>();
//        SortedSinglyLinkedList<Object> list4 = new SortedSinglyLinkedList<Object>();
                                         //�����Object�಻����ΪE��ʵ�ʲ�����û��ʵ��ʵ��Comparable<E>�ӿ�
        SortedSinglyLinkedList<Integer> list4 = new SortedSinglyLinkedList<Integer>();
//        list4.insert(new Object());     //������������Ͳ�ƥ��
*/