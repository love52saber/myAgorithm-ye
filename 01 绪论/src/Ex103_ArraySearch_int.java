//����1.3�� �����˳������㷨��
//(1) ���������˳������㷨

public class Ex103_ArraySearch_int
{
    public static int[] random(int n)                      //����n���������������������
    {
        if (n<=0)
            return null;                                   //��������ɻ�����ÿ�ֵ
        int[] value = new int[n];                         //��̬����ʹ��new�������������洢�ռ�
                                                          //��n<0�����׳������鳤���쳣
        for (int i=0; i<value.length; i++)                //�������ͨ��length���Ի����洢��Ԫ��
            value[i] = (int)(Math.random()*100);          //����һ��0��100֮��������
        return value;                                     //���ؾֲ�����valueҪ���õ�����
    }

    public static void print(int[] value)                 //�������Ԫ��
    {
        for (int i=0; i<value.length; i++)
            System.out.print(" "+value[i]);
        System.out.println();
    }

    //����������value�в���keyֵ�������ҳɹ�����Ԫ���±꣬���򷵻�-1
    public static int indexOf(int[] value, int key)
    {
        for (int i=0; i<value.length; i++)                 //��value==null�����׳��ն����쳣NullPointerException
        {
            System.out.print(value[i]+"? ");
            if (value[i]==key)                             //�����������Ͳ���==��!=������Ƚ����
                return i;
        }
        return -1;
    }  

    public static void main(String[] args)
    {
        int[] value =random(10); 
        System.out.print("���������: ");
        print(value);
        int key=value[value.length/2];
        System.out.println("˳����� "+key+", "+((indexOf(value,key)==-1)?"��":"")+"�ɹ�");
        key=25;
        System.out.println("˳����� "+key+", "+((indexOf(value,key)==-1)?"��":"")+"�ɹ�");

        //ϰ��1
        value =randomDifferent(10,100); 
        System.out.print("ϰ��1���������������: ");
        print(value);
    }
    
    //ϰ��1
    //��value����ǰn��Ԫ���в���keyֵ�������ҳɹ�����Ԫ���±꣬���򷵻�-1
    public static int indexOf(int[] value, int n, int key)
    {
        for (int i=0; i<n; i++)
            if (value[i]==key)
                return i;
        return -1;
    }  

    public static int[] random(int n, int size)            //����n�����������Χ��1��size��������������
    {
        int value[] = new int[n];                          //��n<0�����׳������鳤���쳣
        int i=0;
        while (i<value.length)
        {
            int key = (int)(Math.random()*size);
            if (key!=0)
                value[i++] = key; 
        }
        return value;
    }

    public static int[] randomDifferent(int n, int size)   //����n���������������Χ��1��size��������������
    {
        int value[]=new int[n], i=0; 
        while (i<value.length) 
        {
            int key=(int)(Math.random()*size);
            if (indexOf(value, i, key)==-1)               //˳����Ҳ��ɹ�
                value[i++] = key;
        }
        return value; 
    }
}

/* 
�������н�����£�
���������:  98 21 55 24 97 36 1 42 35 98
98? 21? 55? 24? 97? 36? ˳����� 36, �ɹ�
98? 21? 55? 24? 97? 36? 1? 42? 35? 98? ˳����� 25, ���ɹ�

���������:  43 47 14 67 40 0 53 9 45 78
43? 47? 14? 67? 40? 0? ˳����� 0, �ɹ�
43? 47? 14? 67? 40? 0? 53? 9? 45? 78? ˳����� 25, ���ɹ�
ϰ��1���������������:  11 71 74 72 99 52 91 19 70 44

*/
