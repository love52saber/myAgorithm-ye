//10.1.1   Arrays������
// Arrays����Ͳ����㷨��

import java.util.Arrays;

public class Arrays_Integer 
{
    public static Integer[] random(int n)                  //���ز���n�������������
    {
        Integer[] list = new Integer[n];
        for (int i=0; i<n; i++)
            list[i]=new Integer((int)(Math.random()*100)); //���������
        return list;
    }

    public static void main(String args[])
    {  
    	Integer value[]=random(10);                        //����n����������������Ͷ�������
        System.out.print("��������У� ");        
        Ex103_ArraySearch_Object.print(value);
        java.util.Arrays.sort(value);                      //����������        
        System.out.print("�������У� ");        
        Ex103_ArraySearch_Object.print(value);
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