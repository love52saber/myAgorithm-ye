//10.2   ʵ�ֵ�����

import java.util.*;

public class SeqList_iterator 
{
    public static SeqList<Integer> random(int n)              //���ز���n�������������
    {
        SeqList<Integer> list = new SeqList<Integer>(n*2);
  	    ListIterator<Integer> it = list.listIterator();      //����б����������
        for (int i=0; i<n; i++)
        {
//          System.out.println("nextIndex="+it.nextIndex());
            it.add(new Integer((int)(Math.random()*100)));   // //���������ͨ���б�������������Ԫ�أ������������
        }
        return list;
    }
	
    public static void sum(SeqList<Integer> list)
    {
    	ListIterator<Integer> it = list.listIterator();      //����б����������
        System.out.print("nextIndex="+it.nextIndex()+"��");
        int sum=0, value=0;
        while (it.hasNext())
        {
            value = it.next().intValue();
        	sum += value;
    	    System.out.print(value);
        	if (it.hasNext())
        	    System.out.print("+");
        }        	
        System.out.println("="+sum+"��nextIndex="+it.nextIndex());
//        it.next();                    //�׳�java.util.NoSuchElementException
        
        sum=0;
        System.out.print("nextIndex="+it.previousIndex()+"��");
        while (it.hasPrevious())                           //���������б����������
        {
            value=it.previous().intValue();
        	sum += value;
    	    System.out.print(value);
        	if (it.hasPrevious())
        	    System.out.print("+");
        }        	
        System.out.println("="+sum+"��nextIndex="+it.previousIndex());
//        it.previous();                    //�׳�java.util.NoSuchElementException
    }
	
	public static void main(String args[])
    {
    	SeqList<Integer> list1 = new SeqList<Integer>();             //�ձ�
        System.out.println("list1:"+list1.toString()+"��");
    	sum(list1);

        list1 = random(10);
//        list1 =  new SeqList(SeqList_ex.random(10));
        System.out.println("list1:"+list1.toString()+"��");
    	sum(list1);
    	
    	SeqList<Integer> list2 = new SeqList<Integer>(list1);    	//���
        System.out.println("list2:"+list2.toString()+"��");
    	ListIterator<Integer> lit = list2.listIterator();  //����б����������
        System.out.print("nextIndex="+lit.nextIndex()+"��");
    	Integer value = lit.next();
    	lit.remove();                                       //ɾ����һ��Ԫ��
                                //����ִ��it.next();�����׳�java.lang.IllegalStateException�쳣
        System.out.println("ɾ��"+value+"��list2:"+list2.toString()+"�� ");
        System.out.print("nextIndex="+lit.nextIndex()+"��");
    	value = lit.next();
        lit.remove();                                       //ɾ����һ��Ԫ��
        System.out.println("ɾ��"+value+"��list2:"+list2.toString());
    	sum(list2);                              //ͬʱ������������
       
        System.out.print("nextIndex="+lit.nextIndex()+"��");
//        lit.previous();
        lit.add(value);                                    //�����һ��Ԫ��
                         //����ִ��it.previous();�����׳�java.lang.IllegalStateException�쳣
        System.out.println("����"+value+"��list2:"+list2.toString());

        System.out.print("nextIndex="+lit.nextIndex()+"��");
        value = new Integer(100);
        lit.next();
    	lit.set(value);                    //�����ϵ�ǰԪ���滻Ϊx
        System.out.println("�滻"+value+"��list2:"+list2.toString());
        value = new Integer(200);
    	lit.set(value);                    //���������滻
        System.out.println("�滻"+value+"��list2:"+list2.toString());
    }
}
/*
�������н�����£�    
list1:() ��
nextIndex=0��=0��nextIndex=0
nextIndex=-1��=0��nextIndex=-1
list1:(86, 47, 24, 31, 62, 16, 23, 42, 34, 29) ��
nextIndex=0��86+47+24+31+62+16+23+42+34+29=394��nextIndex=10
nextIndex=9��29+34+42+23+16+62+31+24+47+86=394��nextIndex=-1
list2:(86, 47, 24, 31, 62, 16, 23, 42, 34, 29) ��
nextIndex=0��ɾ��86��list2:(47, 24, 31, 62, 16, 23, 42, 34, 29) �� 
nextIndex=0��ɾ��47��list2:(24, 31, 62, 16, 23, 42, 34, 29) 
nextIndex=0��24+31+62+16+23+42+34+29=261��nextIndex=8
nextIndex=7��29+34+42+23+16+62+31+24=261��nextIndex=-1
nextIndex=0������47��list2:(47, 24, 31, 62, 16, 23, 42, 34, 29) 
nextIndex=1���滻100��list2:(47, 100, 31, 62, 16, 23, 42, 34, 29) 
�滻200��list2:(47, 200, 31, 62, 16, 23, 42, 34, 29) 

*/

