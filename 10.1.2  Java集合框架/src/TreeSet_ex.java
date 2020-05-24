import java.util.*;

public class TreeSet_ex 
{
    public static TreeSet<Integer> random(int n)              //���ز���n�������������
    {
    	TreeSet<Integer> treeset = new TreeSet<Integer>();
        System.out.print("�������");
        for (int i=0; i<n; i++)
        {
        	int value = (int)(Math.random()*100); // //���������ͨ���б�������������Ԫ�أ������������
            System.out.print(value+" ");
        	treeset.add(new Integer(value));  
        }
        System.out.println();
        return treeset;
    }
	public static void ptint(Collection<Integer> coll)
    {
  	    Iterator<Integer> it = coll.iterator();      //����������
        System.out.print("���ϣ�");
        while (it.hasNext())
    	    System.out.print(it.next().toString()+" ");
        System.out.println();
    }
	public static void main(String args[])
    {
    	TreeSet<Integer> treeset = random(10);
    	ptint(treeset);                     //TreeSet<Integer>��Collection<Integer>������
    }
}
/*
�������н�����£� 
�������63 46 86 35 64 80 37 39 29 70 
���ϣ�29 35 37 39 46 63 64 70 80 86                       //����

*/