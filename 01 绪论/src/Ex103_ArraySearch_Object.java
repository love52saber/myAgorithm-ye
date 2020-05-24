//����1.3�� �����˳������㷨��
//(2) ���������˳������㷨

public class Ex103_ArraySearch_Object 
{
    //�ڶ�������value�в���key���������ҳɹ�����Ԫ���±꣬���򷵻�-1
    //��value��keyΪnull�����׳��ն����쳣NullPointerException
    public static int indexOf(Object[] value, Object key)
    {
        for(int i=0; i<value.length; i++)
            if (key.equals(value[i]))                     //�������equals()�����Ƚ����
                return i;
        return -1;
    }
    
    public static void print(Object[] value)              //�����������Ԫ��
    {
        for (int i=0; i<value.length; i++)
            System.out.print(" "+value[i].toString());    //�������Ĭ��ִ����toString()����
        System.out.println();
    }

    public static void main(String[] args)
    {
//        Integer[] value = {new Integer(32),new Integer(15),new Integer(78),new Integer(99)}; 
        Integer[] value = {32,15,78,99,87,34,14,19,76,46,1}; 
//        Object[] value =randomInteger(10); 
        System.out.print("���������: ");
        print(value);
        Object key = 99;//new Integer(99);
        System.out.println("˳����� "+key+", "+((indexOf(value,key)==-1)?"��":"")+"�ɹ�");

        //ϰ��1
/*        value =randomString(10); 
        System.out.print("����ַ�����: ");
        print(value);
        key = "X";
        System.out.println("˳����� "+key+", "+((indexOf(value,key)==-1)?"��":"")+"�ɹ�");*/
    }
    
    //ϰ��1
    public static Integer[] randomInteger(int n)           //������n���������ɵ�������������
    {
        Integer[] value = new Integer[n];
        for (int i=0; i<value.length; i++)
            value[i]=new Integer((int)(Math.random()*100));//���������
        return value;                                     //������������
    }
    
    public static Integer[] randomInteger(int n, int size) //���ز���n������������飬��Χ��1��size
    {
        Integer[] value = new Integer[n];
        for (int i=0; i<n; i++)
            value[i]=new Integer((int)(Math.random()*size));
        return value;
    }    

    public static String[] randomString(int n)             //������n������ַ���ɵ��ַ�������
    {
        String[] value = new String[n];
        for (int i=0; i<value.length; i++)
            value[i]=(char)(Math.random()*26+'A')+"";     //��һ����д��ĸ���ɵ��ַ���
//            value[i]=(char)(Math.random()*93+'!')+"";   //��һ��ASCII�ɴ�ӡ�ַ����ɵ��ַ���
        return value;
    }
    
}
/*
�������н�����£�
���������:  33 15 87 34 78 14 19 76 46 1
˳����� 99, ���ɹ�
����ַ�����:  J Y R Y R U X U B T
˳����� X, �ɹ�
����ַ�����:  S K s L S ` ) - a U
˳����� X, �ɹ�
*/
