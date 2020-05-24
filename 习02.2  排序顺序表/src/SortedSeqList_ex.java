
public class SortedSeqList_ex 
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
        lista.remove(10);                                  //ûɾ��
        System.out.println("lista: "+lista.toString());
        System.out.println("listb: "+listb.toString());
*/
        SeqList<Integer> list1 = new SeqList<Integer>(random(5));
        System.out.println("list1: "+list1.toString());
//        SeqList<Integer> list2 = new SeqList<Integer>(list1);    //�������췽��
//      System.out.println("list2: "+list2.toString());
//        list1.set(0, new Integer(list1.get(0).intValue()+100));
//        list1.remove(0);
//        System.out.println("list1: "+list1.toString());
//        System.out.println("list2: "+list2.toString());
           //���ڿ������췽��ʵ��Ϊ�������������ǳ����������Integer�ǳ�������new ������һ������ 
           //���������ֻ��˵������˳������ֱ��и��Ե����飬������Ԫ�ؿ����ò�ͬ����
           //������˵������ͬһ�������µ������޸Ĵ���

        //����˳���
        SortedSeqList<Integer> list3 = new SortedSeqList<Integer>(random(6));
        System.out.println("list3: "+list3.toString());
//        SortedSeqList<Integer> list4 = new SortedSeqList<Integer>(list3);  //�������췽��
//        System.out.println("list4: "+list4.toString());

        //��9��
        SortedSeqList<Integer> list5 = new SortedSeqList<Integer>(list1);  //�������췽��
        System.out.println("list5: "+list5.toString());
/*        list3.merge(list5);                           //�鲢��������˳���
        System.out.println("�鲢��list3: "+list3.toString());
        System.out.println("list5: "+list5.toString());
*/      
        SortedSeqList<Integer> list6 = list3.mergeWith(list5);      //�鲢��������˳���
        System.out.println("�鲢��list3: "+list3.toString());
        System.out.println("list5: "+list5.toString());
        System.out.println("list6: "+list6.toString());
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

list1: (19, 3, 79, 147, 29) 
list2: (19, 3, 79, 47, 29) 


list1: (74, 51, 48, 47, 64) 
list3: (40, 47, 67, 74, 94, 99) 
list5: (47, 48, 51, 64, 74) 
�鲢��list3: (40, 47, 47, 48, 51, 64, 67, 74, 74, 94, 99) 
list5: (47, 48, 51, 64, 74) 

list1: (53, 48, 92, 41, 1) 
list3: (48, 57, 60, 67, 81, 98) 
list5: (1, 41, 48, 53, 92) 
�鲢��list3: (48, 57, 60, 67, 81, 98) 
list5: (1, 41, 48, 53, 92) 
list6: (1, 41, 48, 48, 53, 57, 60, 67, 81, 92, 98) 
}
*/
