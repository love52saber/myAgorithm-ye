//��10�£�10.2 ʵ�ֵ�����
//ʹ��SinglyLinkedList���Լɪ�����⡣
//ʹ��SinglyLinkedList��Iterator�б�����������롢ɾ������
 
import java.util.Iterator;                   //�б������

public class Josephus_Singlyiterator
{
    //����Լɪ�򻷲���⣬����ָ�������ȡ���ʼλ�á�����
    public Josephus_Singlyiterator(int number,int start,int distance)
    {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        for (int i=number-1; i>=0; i--)
        	 list.insert(0, (char)('A'+i)+"");
        System.out.print("Լɪ��("+number+","+start+","+distance+")��");
        System.out.println(list.toString());

       	Iterator<String> it = list.iterator();        //����б����������
        int count=0;            
        String str="";
        while (list.length()>1)           
        {
            if (!(it.hasNext()))
          	    it = list.iterator();                 //���»���б���������󣬳�ʼ���Ϊ-1
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
        new Josephus_Singlyiterator(5,1,2);
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