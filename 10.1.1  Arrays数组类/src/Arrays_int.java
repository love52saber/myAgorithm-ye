//10.1.1   Arrays������
// Arrays����Ͳ����㷨��

import java.util.Arrays;

public class Arrays_int 
{
    public static void main(String args[])
    {  
        int value[]=Ex103_ArraySearch_int.random(10);                //����n��������������������飬����1��
        System.out.print("��������У� ");        
        Ex103_ArraySearch_int.print(value);
        Arrays.sort(value);                                //����������        
        System.out.print("�������У� ");        
        Ex103_ArraySearch_int.print(value);
        int key=100;
        int i=Arrays.binarySearch(value, key);
        System.out.println("���ַ�����"+key+"�����"+i+"������"+(i>=0 && i<value.length?"":"��")+"�ɹ�");
    }
}
/* 
�������н�����£�
��������У�  49 99 24 46 93 68 67 35 28 94
�������У�  24 28 35 46 49 67 68 93 94 99
���ַ�����100�����-11�����Ҳ��ɹ�

*/