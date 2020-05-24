//��10�£�10.2 ʵ�ֵ�����
//ʹ��CirDoublyLinkedList���Լɪ�����⡣
//ʹ��CirDoublyLinkedList��Iterator�б�����������롢ɾ������
 
import java.util.Iterator;                   //�б������

public class Josephus_Doublyiterator
{
    //����Լɪ�򻷲���⣬����ָ�������ȡ���ʼλ�á�����
    public Josephus_Doublyiterator(int number,int start,int distance)
    {
    	CirDoublyLinkedList<String> list = new CirDoublyLinkedList<String>();
       	java.util.ListIterator<String> it = list.listIterator();        //����б����������
        for (int i=0; i<number; i++)
        	 it.add((char)('A'+i)+"");
        System.out.print("Լɪ��("+number+","+start+","+distance+")��");
        System.out.println(list.toString());

  	    it = list.listIterator(start-1);                   //����б����������ָ����ʼλ��
        int count=0;            
        String str="";
        while (list.length()>1)           
        {
            if (!(it.hasNext()))
          	    it = list.listIterator();                 //���»���б���������󣬳�ʼ���Ϊ-1
            str = it.next();
            count++;
            if (count==distance)
            {
                System.out.print("ɾ��"+str+"��");
            	it.remove();                               //ɾ��
                System.out.println(list.toString());
            	count=0;
            }
        }
        System.out.println("��������"+list.get(0).toString());
    }
    
    public static void main(String args[])
    {
        new Josephus_Doublyiterator(5,1,2);
    }
}
    
/*
�������н�����£�
Լɪ��(5,1,2)��(A, B, C, D, E) 
ɾ��B��(A, C, D, E) 
ɾ��D��(A, C, E) 
ɾ��A��(C, E) 
ɾ��E��(C) 
��������C

*/