//10.1.2   Java���Ͽ��
//ʹ���б���ArrayList/LinkedList���Լɪ�����⡣ͬ˳���
 
import java.util.ArrayList;                      //�����б��࣬����Ԫ���д��򣬿��ظ��������Զ�����
import java.util.LinkedList;                     //������

public class Josephus_List
{
    //����Լɪ�򻷲���⣬����ָ�������ȡ���ʼλ�á�����
    public Josephus_List(int number,int start,int distance)
    {
        java.util.List<String> list;                       //ʹ��һ���б�洢Լɪ���ж��������Ϣ
        list = new ArrayList<String>(number);              //�б��д洢�ַ�������ָ���б�����
//        this.list = new LinkedList<String>();
        for (int i=0; i<number; i++)
            list.add((char)('A'+i)+"");                    //�б���Ӷ���
        System.out.print("Լɪ��("+number+","+start+","+distance+")��");
        System.out.println(list.toString());               //��ʾ�б��е����ж���
    
        int i = start-1;                                   //������ʼλ��
        while (list.size()>1)                              //����һ������ʱѭ�� 
        {
            i = (i+distance-1) % list.size();              //������ѭ�����ɱ仯��˳���ɿ����ǻ��νṹ
            System.out.print("ɾ��"+list.remove(i).toString()+"��");//ɾ��ָ��λ�ö���
            System.out.println(list.toString());
        }
        System.out.println("��������"+list.get(0).toString());
    }
    
    public static void main(String args[])
    {
        new Josephus_List(5,1,2);
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

Լɪ��(5,2,2)��[A, B, C, D, E]
ɾ��C��[A, B, D, E]
ɾ��E��[A, B, D]
ɾ��B��[A, D]
ɾ��A��[D]
��������D
*/