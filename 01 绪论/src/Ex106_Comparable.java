//����1.6�� �����㷨�����Ҫ�ԡ�
//(2) ֱ�Ӳ��������㷨������
//ϰ��1

public class Ex106_Comparable 
{
    //��Ԫ��x���뵽value��������ǰn��Ԫ���У�����λ����xֵ��С����
    public static<T> void insert(Comparable<T> value[], int n, T x)
    {
        int i=0;
        while (i<n && value[i].compareTo(x)<=0)            //˳�����x�Ĳ���λ��
            i++;
        for (int j=n-1; j>=i; j--)
            value[j+1]=value[j];                           //Ԫ������ƶ�
        value[i]=(Comparable<T>)x;                         //i��x�Ĳ���λ��
    }
      
    public static Integer[] randomSortedInteger(int n)     //������n���������ɵ�����������������
    {
        Integer[] value = new Integer[n];
        for (int i=0; i<value.length; i++)
            insert(value, i, new Integer((int)(Math.random()*100)));
                                   //��һ�������������������뵽value����ǰi��Ԫ����
        return value; 
    }

    public static String[] randomSortedString(int n)       //������n������ַ���ɵ������ַ�������
    {
        String[] value = new String[n];
        for (int i=0; i<value.length; i++)
            insert(value, i, (char)(Math.random()*26+'A')+"");  //��д��ĸ�ַ���
        return value;
    }
    
    public static void main(String[] args)
    {
        Comparable value[] = randomSortedInteger(10);     //����������������������
        System.out.print("����������Ĺؼ�������: ");
        Ex103_ArraySearch_Object.print(value);        
        Object key = new Integer(49);
        System.out.println("˳����� "+key+", "+((Ex104_SortedArray_Comparable.indexOf(value,key)==-1)?"��":"")+"�ɹ�");

        value = randomSortedString(10);                   //�����������ַ�������
        System.out.print("����������Ĺؼ�������: ");
        Ex103_ArraySearch_Object.print(value);        
        key = "Q";
        System.out.println("˳����� "+key+", "+((Ex104_SortedArray_Comparable.indexOf(value,key)==-1)?"��":"")+"�ɹ�");
    }
    
    //������n���������ɵ�һ������������������
    public static Integer[] randomDifferentSortedInteger(int n)
    {
        Integer[] value = new Integer[n];
        for (int i=0; i<value.length; i++)
            insert(value, i, new Integer((int)(Math.random()*100)));
                                   //��һ�������������������뵽value����ǰi��Ԫ����
        return value; 
    }
}
/*
�������н�����£�
����������Ĺؼ�������:  2 7 24 35 48 50 60 71 82 87
2? 7? 24? 35? 48? ˳����� 49, ���ɹ�
����������Ĺؼ�������:  A C C D J J R T T Y
A? C? C? D? J? J? ˳����� Q, ���ɹ�

*/
/*Ҳ��
Comparable<Integer> value[] = randomSortedInteger(10); //����������
System.out.print("����������Ĺؼ�������: ");
Ex103_ArraySearch_Object.print(value);        
Integer key = new Integer(49);
System.out.println("˳����� "+key+", "+((Ex104_SortedArray_Comparable.indexOf(value,key)==-1)?"��":"")+"�ɹ�");
*/
