//10.2   ʵ�ֵ�����

import java.util.*;

public class SinglyLinkedList_iterator 
{
    public static SinglyLinkedList<Integer> random(int n)              //���ز���n�������������
    {
    	SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>(); //�ձ�
        for (int i=0; i<n; i++)
            list.append(new Integer((int)(Math.random()*100)));   //���������ͨ���б�������������Ԫ�أ������������
        return list;
    }
	
    public static int sum(SinglyLinkedList<Integer> list)
    {
    	java.util.Iterator<Integer> it = list.iterator();      //��õ���������
        int sum=0, value=0;
        while (it.hasNext())
        {
            value = it.next().intValue();
        	sum += value;
    	    System.out.print(value);
        	if (it.hasNext())
        	    System.out.print("+");
        }        	
        System.out.println("="+sum);
        return sum;
    }
	
	public static void main(String args[])
    {
		SinglyLinkedList<Integer> list1 = random(10); 
        System.out.println("list1:"+list1.toString()+"��");
    	sum(list1);
    	
    	SinglyLinkedList<Integer> list2 = new SinglyLinkedList<Integer>(list1);    	//���
        System.out.println("list2:"+list2.toString()+"��");
    	java.util.Iterator<Integer> it = list2.iterator();      //��õ���������
    	Integer value = it.next();
    	it.remove();                                       //ɾ����һ��Ԫ��
                                //����ִ��it.next();�����׳�java.lang.IllegalStateException�쳣
        System.out.println("ɾ��"+value+"��list2:"+list2.toString()+"�� ");
    	value = it.next();
        it.remove();                                       //ɾ����һ��Ԫ��
        System.out.println("ɾ��"+value+"��list2:"+list2.toString());
    	sum(list2);                              //ͬʱ������������
    }
}
/*
�������н�����£�    
list1:(37, 61, 67, 63, 35, 5, 11, 27, 89, 87)��
37+61+67+63+35+5+11+27+89+87=482
list2:(37, 61, 67, 63, 35, 5, 11, 27, 89, 87)��
ɾ��37��list2:(61, 67, 63, 35, 5, 11, 27, 89, 87)�� 
ɾ��61��list2:(67, 63, 35, 5, 11, 27, 89, 87)
67+63+35+5+11+27+89+87=384

*/

