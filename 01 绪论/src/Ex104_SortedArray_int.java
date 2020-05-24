//����1.4�� ���������˳������㷨��
//�� �Ի����������͵������������˳�����

public class Ex104_SortedArray_int
{
    //���������򣩵���������value��˳�����key�������ҳɹ�����Ԫ���±꣬���򷵻�-1
    public static int indexOf(int[] value, int key)
    {
//        if (isSorted(value))
        for(int i=0; i<value.length && value[i]<=key; i++) //����δ����������Ĵ���δ����
        {   System.out.print(value[i]+"? ");               //����м�������ʡ��
            if (value[i]==key)
                return i;
        }
        return -1;
    }  
    
    public static void main(String[] args)
    {
//      int[] value ={8,17,26,32,40,72,87,99};            //����������
        int[] value = Ex106_int.randomDifferentSorted(10, 100);   //��1.6
        System.out.print("����������Ĺؼ�������: ");
        Ex103_ArraySearch_int.print(value);
        int key=25;
        System.out.println("˳����� "+key+", "+((indexOf(value, key)==-1)?"��":"")+"�ɹ�");

        //ϰ��1
        System.out.println("ϰ��1������? "+isSorted(value));

        value = Ex103_ArraySearch_int.random(10);         //�������������1.3
        System.out.print("�ؼ�������: ");
        Ex103_ArraySearch_int.print(value);
        System.out.println("����? "+isSorted(value));
    }

    //ϰ��1
    //�ж�value�����Ƿ��Ѱ����������������򷵻�true�����򷵻�false
    public static boolean isSorted(int[] value)
    {
        for (int i=0; i<value.length-1; i++)
            if (value[i]>value[i+1])
                return false;
        return true;
    }
}

/* 
�������н�����£�
����������Ĺؼ�������:  8 17 26 32 40 72 87 99
8? 17? ˳����� 25, ���ɹ�
ϰ��1������? true
�ؼ�������:  99 46 84 28 16 39 38 79 48 24
����? false

//��1.6
����������Ĺؼ�������:  18 19 23 34 35 39 49 49 60 91
18? 19? 23? ˳����� 25, ���ɹ�
ϰ��1������? true
�ؼ�������:  83 95 22 42 72 92 56 64 47 42
����? false

*/
