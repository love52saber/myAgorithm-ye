//10.1.2   Java���Ͽ��

import java.util.*;

public class Collection_ex 
{
	public static int sum(Collection<Integer> list)
    {
    	Iterator<Integer> it = list.iterator();      //��õ���������
        int s=0;
        while (it.hasNext())
        {
            int value=it.next().intValue();
        	s += value;
    	    System.out.print(value);
        	if (it.hasNext())
        	    System.out.print("+");
        }        	
        System.out.println("="+s);
        return s;
    }

	public static void main(String args[])
    {
    	int n=10;
    	ArrayList<Integer> list1 = new ArrayList(n*2);
        for (int i=0; i<n; i++)
            list1.add(new Integer((int)(Math.random()*100)));   //���������
        System.out.print("list1:"+list1.toString()+"��");
    	sum(list1);
    	
    	LinkedList<Integer> list2 = new LinkedList(list1);
        System.out.print("list2:"+list1.toString()+"��");
    	sum(list2);
    }
}
/*
�������н�����£�    
list1:[14, 91, 1, 4, 10, 67, 66, 42, 30, 76]��14+91+1+4+10+67+66+42+30+76=401
list2:[14, 91, 1, 4, 10, 67, 66, 42, 30, 76]��14+91+1+4+10+67+66+42+30+76=401

*/
