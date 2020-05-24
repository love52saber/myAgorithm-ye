//10.1.2   Java���Ͽ��
//ʹ���б���ArrayList/LinkedList���Լɪ�����⡣
//ʹ��ListIterator�б�����������롢ɾ������
 
import java.util.ArrayList;                      //�����б��࣬����Ԫ���д��򣬿��ظ��������Զ�����
import java.util.LinkedList;                     //������
import java.util.ListIterator;                   //�б������

public class Josephus_iterator
{
    private java.util.List<String> list;                   //ʹ��һ���б�洢Լɪ���ж��������Ϣ
    
    //����Լɪ�򻷲���⣬����ָ�������ȡ���ʼλ�á�����
    public Josephus_iterator(int number,int start,int distance)
    {
//        this.list = new ArrayList<String>(number);       //�б��д洢�ַ�������ָ���б�����
        this.list = new LinkedList<String>();
  	    ListIterator<String> it = list.listIterator();     //����б����������
        for (int i=0; i<number; i++)
            it.add((char)('A'+i)+"");                      //ͨ���б��������Ӷ��󣬿����������
        System.out.print("Լɪ��("+number+","+start+","+distance+")��");
        System.out.println(this.list.toString());
    
  	    it = list.listIterator(start-1);                   //����б����������ָ����ʼλ��
        int count=0;            
        String str="";
        while (this.list.size()>1)           
        {
            if (!(it.hasNext()))
          	    it = list.listIterator();                  //���»���б���������󣬳�ʼ���Ϊ-1
            str = it.next();
            count++;
            if (count==distance)
            {
                System.out.print("ɾ��"+str+"��");
            	it.remove();                               //ɾ��
                System.out.println(this.list.toString());
            	count=0;
            }
        }
        System.out.println("��������"+list.get(0).toString());
    }
    
    public static void main(String args[])
    {
        new Josephus_iterator(5,1,2);
    }
}
    
/*
�������н�����£�
Լɪ��(5,1,2)��[A, B, C, D, E]
ɾ��B��[A, C, D, E]
ɾ��D��[A, C, E]
ɾ��A��[C, E]
ɾ��E��[C]
��������C

*/