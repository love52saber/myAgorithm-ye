//����1.4�� ���������˳������㷨��
//�� �������������͵������������˳�����

public class Ex104_SortedArray_Comparable 
{
    //���������򣩶�������value��˳�����key���������ҳɹ�����Ԫ���±꣬���򷵻�-1
    public static<T> int indexOf(Comparable<T>[] value, T key)
    {
//      if (isSorted(value))
        for (int i=0; i<value.length && value[i].compareTo(key)<=0; i++)        //����δ����������Ĵ���δ����
        {   System.out.print(value[i]+"? ");               //����м�������ʡ��
            if (value[i].compareTo(key)==0)
    	        return i;
    	}
    	return -1;
    }
    
    public static void main(String[] args)
    {
//        Integer value[] ={new Integer(15),new Integer(32),new Integer(78),new Integer(99)}; //����������
        Integer value[] = Ex106_Comparable.randomSortedInteger(10); //����������
        System.out.print("����������Ĺؼ�������: ");
        Ex103_ArraySearch_Object.print(value);
        Integer key = new Integer(50);
        System.out.println("˳����� "+key+", "+((indexOf(value, key)==-1)?"��":"")+"�ɹ�");
        //ϰ��1
        System.out.println("ϰ��1������? "+isSorted(value));
        
        //�����о���Comparable[]û�з��Ϳ��Դ洢������Ͷ��󣬱Ƚ�ʱ�׳��쳣
        Comparable[] table ={"aaa","abc",new String("xyz"),new Integer(123)};//������Ͷ���
        Ex103_ArraySearch_Object.print(table);             //����ʱ��̬
        System.out.println("˳����� "+key+", "+((indexOf(table, key)==-1)?"��":"")+"�ɹ�"); //�׳��쳣        
    }
    
    //ϰ��1
    //�ж�value���������Ƿ��Ѱ����������������򷵻�true�����򷵻�false
    public static boolean isSorted(Comparable[] value)
    {
        for (int i=0; i<value.length-1; i++)
            if (value[i].compareTo(value[i+1])>0)
                return false;
        return true;
    }
    //����    public static<T> boolean isSorted(Comparable<T>[] value)
    //��Ϊ������compareTo(Comparable<T>)��Ӧ��compareTo(T)��
}
/* 
�������н�����£�
����������Ĺؼ�������:  15 32 78 99
15? 32? ˳����� 50, ���ɹ�
ϰ��1������? true
 aaa abc xyz 123
Exception in thread "main" java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
	at java.lang.String.compareTo(String.java:92)
	at Ex104_SortedArray_Comparable.indexOf(Ex104_SortedArray_Comparable.java:12)
	at Ex104_SortedArray_Comparable.main(Ex104_SortedArray_Comparable.java:35)

����������Ĺؼ�������:  7 21 32 39 43 48 66 77 78 79
*/
