//����2.3��  �������������ƽ��ֵ��

public class SinglyLinkedList_average 
{
    public static Integer[] random(int n)              //���ز���n�������������
    {
        Integer[] elements = new Integer[n];
        for (int i=0; i<n; i++)
            elements[i] = new Integer((int)(Math.random()*100)); //����һ��0��100֮��������
        return elements;
    }
    
    public static double averageAll(SinglyLinkedList<Integer> list)   //������Ԫ�ص�ƽ��ֵ
    {
        if (list.isEmpty())
            throw new IllegalArgumentException("���ܶԿյ��������ƽ��ֵ��"); //�׳���Ч�����쳣
        int sum=0, i=0;
        Node<Integer> p=list.head.next;         //Ҫ��headȨ�ޱ�����public ��p=list.getFirst();
        while (p!=null) 
        {
            sum += p.data.intValue();  
            p=list.getNext(p);
            i++;
        }
        return (double)sum/i;                    //�����˳���Ϊ0����
    }
       
    //ȥ����߷ֺ���ͷ֣�����ƽ��ֵ��O(n)
    public static double averageExceptMaxMin(SinglyLinkedList<Integer> list)
    {
        if (list.isEmpty())
            throw new IllegalArgumentException("���ܶԿյ��������ƽ��ֵ��"); //�׳���Ч�����쳣
        int sum=0, i=0, max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
        Node<Integer> p=list.head.next;               //Ҫ��headȨ�ޱ�����public
        while (p!=null) 
        {
            int value = p.data.intValue();
            sum += value; 
            if (value>max)
                max = value;
            if (value<min)
                min = value;
            p = p.next;
            i++;
        }
        if (i==1 || i==2)
            return (double)sum/i;                     //��������Ԫ�ص�ƽ��ֵ�������˳���Ϊ0����
        return (double)(sum-max-min)/(i-2);           //����ȥ����߷ֺ���ͷֺ��ƽ��ֵ
    }
    public static void main(String args[])
    {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();//random(10));
        System.out.println("list: "+list.toString());
        System.out.println("averageAll: "+averageAll(list));
        System.out.println("averageExceptMaxMin: "+averageExceptMaxMin(list));
    }
}
/*
�������н�����£�    
list: ()
Exception in thread "main" java.lang.IllegalArgumentException: ���ܶԿյ��������ƽ��ֵ��
	at SinglyLinkedList_average.averageAll(SinglyLinkedList_average.java:16)
	at SinglyLinkedList_average.main(SinglyLinkedList_average.java:54)


list: (52)
averageAll: 52.0
averageExceptMaxMin: 52.0

list: (44, 87)
averageAll: 65.5
averageExceptMaxMin: 65.5

list: (22, 66, 10, 61, 66, 7, 25, 34, 24, 86)
averageAll: 40.1
averageExceptMaxMin: 38.5



*/
