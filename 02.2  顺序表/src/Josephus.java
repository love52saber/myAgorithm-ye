//����2.1��ʹ��˳�����SeqList���Լɪ�����⡣

public class Josephus
{
    //����Լɪ�򻷲���⣬����ָ�������ȡ���ʼλ�á�����
    public Josephus(int number, int start, int distance) 
    {
        SeqList<String> list = new SeqList<String>(number);
                   //����˳���洢Լɪ�򻷵�Ԫ�أ�Ԫ���������ַ��������췽������ָ��˳�������
        for (int i=0; i<number; i++)
            list.append((char)('A'+i)+"");                 //����ַ�������
        System.out.print("Լɪ��("+number+","+start+","+distance+")��");
        System.out.println(list.toString());               //���˳���������ַ���

        int i = start;                                     //������ʼλ��
        while (list.length()>1)                            //����һ������ʱѭ�� 
        {
            i = (i+distance-1) % list.length();            //������ѭ�����ɱ仯��˳���ɿ����ǻ��νṹ
            System.out.print("ɾ��"+list.remove(i).toString()+"��");  //ɾ��ָ��λ�ö���
            System.out.println(list.toString());
        }
        System.out.println("����������"+list.get(0).toString());
    }
    
    public static void main(String args[])
    {
        new Josephus(5,0,2);
    }
}
    
/*
�������н�����£�
Լɪ��(5,0,2)��(A, B, C, D, E) 
ɾ��B��(A, C, D, E) 
ɾ��D��(A, C, E) 
ɾ��A��(C, E) 
ɾ��E��(C) 
����������C
*/
//ע�⣺����<E>��ʵ�ʲ���ֻ�����࣬�����ǻ�������char��int��
