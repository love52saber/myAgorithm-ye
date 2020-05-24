//����1.6�� �����㷨�����Ҫ�ԡ�
//(1) �����㷨�ı�Ҫ��
//(2) ֱ�Ӳ��������㷨��int

public class Ex106_int 
{
    //(1) �����㷨�ı�Ҫ��
    public static void sort(int a, int b)                  //���������������������
    {
        if (a<b)
            System.out.println(a+", "+b);
        else
            System.out.println(b+", "+a);
    }

    public static void sort(int a, int b, int c)           //���������������������
    {
        if (a<b) 
            if (b<c)
                System.out.println(a+"  "+b+"  "+c);
            else
                if (a<c)
                    System.out.println(a+"  "+c+"  "+b);
                else
                    System.out.println(c+"  "+a+"  "+b);
        else 
            if (a<c)
                System.out.println(b+"  "+a+"  "+c);
            else
                if (c<b)
                    System.out.println(c+"  "+b+"  "+a);
                else
                    System.out.println(b+"  "+c+"  "+a);
    }

    //(2) ֱ�Ӳ��������㷨��int 
    public static void insert(int[] value, int n, int key)//��key��������뵽value����ǰn��Ԫ����
    {
        int i=0;
        while (i<n && key>=value[i])                      //˳�����key�Ĳ���λ��
            i++;
        for (int j=n-1; j>=i; j--)
            value[j+1]=value[j];                         //Ԫ������ƶ�
        value[i]=key;                                     //i��key�Ĳ���λ��
    }

    public static void print(int[] value, int n)          //�������ǰn��Ԫ��
    {
        for (int i=0; i<n && i<value.length; i++)
            System.out.print(" "+value[i]);
        System.out.println();
    }
    
    //�ӱ�׼�������ж�ȡ��ʾ����������һ���ַ������Կո�ָ����ٵ���split()�����ֽ���ַ������顣
    public static int[] readInt() throws java.io.IOException  //�׳�IO�쳣
    {  
        System.out.print("�����������������: ");
        byte[] buffer = new byte[512];           //���ֽ�������Ϊ������
        int count = System.in.read(buffer);      //�ӱ�׼�������ж�ȡ�����ֽڵ�������buffer������ʵ�ʶ�ȡ�ֽ���
        if (count<=2)                            //����س�����^Z
            return null;        
        String s=new String(buffer,0,count-2);   //��buffer�����д�0��ʼ����Ϊcount-2�������ֽڹ��촮
        String[] str=s.split(" ");               //�ֽ���ַ������飬�Կո�ָ�
        int[] value=new int[str.length]; 
        int i=0, j=0;
        while (i<str.length)
            try                                           //�쳣������䣬����Ǳ���쳣�Ĵ���
            {   value[j] = Integer.parseInt(str[i]);       //���������׳��쳣�ķ���
                j++;
            }
            catch(NumberFormatException e)                 //���񲢴����쳣
            {
                System.out.println(str[i]+"�ַ�������ת��Ϊ����");
            }
            finally                              //������ִ�еĴ��룬�����Ƿ񲶻��쳣
            {
                i++;
            }
        if (i==j)
            return value;
        int[] keys=new int[j];
        System.arraycopy(value, 0, keys, 0, j);
                                       //��value�����0��ʼ��j��Ԫ�ظ��Ƶ�keys�����0��ʼ��Ԫ����
        return keys;
    }
    
    public static void main(String[] args) throws java.io.IOException  //�׳�IO�쳣����Java���������
    {
        int[] value = readInt();                           //����һ������
//        int[] value = readlnInt(10);                          //����һ��������ϰ��1
        for (int i=0; i<value.length; i++)
        {
            System.out.print("���룺"+value[i]+", \t�������У�" );
            insert(value, i, value[i]);                  //��value[i]��������뵽value����ǰi��Ԫ����
            print(value, i+1);                            //�������ǰi+1��Ԫ�أ���������ʡ��
        }
        int key=100;
        int index=Ex104_SortedArray_int.indexOf(value, key);
        System.out.println("˳�����"+key+", "+(index==-1?"��":"")+"�ɹ�");

        //ϰ��1
//??        System.out.println("����? "+SortedArray.isSorted(value));        
    }
    /* 
    �������н�����£�
    �����������������: 34 23 54 12 xyz 76 32 
    xyz�ַ�������ת��Ϊ����
    ���룺34, 	�������У� 34
    ���룺23, 	�������У� 23 34
    ���룺54, 	�������У� 23 34 54
    ���룺12, 	�������У� 12 23 34 54
    ���룺76, 	�������У� 12 23 34 54 76
    ���룺32, 	�������У� 12 23 32 34 54 76
    12? 23? 32? 34? 54? 76? ˳����� 100, ���ɹ�
    ����? true

    */    
    //ϰ��1
    //����������1.4
    public static int[] randomDifferentSorted(int n, int size)   //����n���������������Χ��0��size��������������
    {
        if (n<=0)
            return null; 
        int value[]=new int[n]; 
        for (int i=0; i<value.length; i++)
            insert(value, i, (int)(Math.random()*size));
                                   //��һ��0��size֮����������������뵽value����ǰi��Ԫ����
        return value; 
    }
    
    //�ӱ�׼�������ж�ȡ���n�б�ʾ�������ַ������Իس����з��ָ�����^Z����������������ʵ�ʶ�ȡ����������
    public static int[] readlnInt(int n) throws java.io.IOException  //�׳�IO�쳣
    {  
        int[] value=new int[n]; 
        System.out.print("�������"+n+"����������: ");
        byte buffer[] = new byte[32];                      //���ֽ�������Ϊ������
        int count = System.in.read(buffer);                //�ӱ�׼�������ж�ȡ�����ֽڵ�������buffer������ʵ�ʶ�ȡ�ֽ���
        int i=0;
        String s="";
        if (count<=2)                                      //����س�����^Z
            return null;        
        while (count>2 && i<n-1)                           //����س�����^Z
            try                                            //�쳣�������
            {                                              //����Ǳ���쳣�Ĵ���
                s=new String(buffer,0,count-2);            //��buffer�����д�0��ʼ����Ϊcount-2�������ֽڹ��촮
                value[i] = Integer.parseInt(s);            //���������׳��쳣�ķ���
                i++;
                count = System.in.read(buffer);
            }
            catch(NumberFormatException e)                //���񲢴���parseInt()�����������쳣����
            {
                System.out.println(s+"�ַ�������ת��Ϊ����");
            }
            finally                                        //������ִ�еĴ��룬�����Ƿ񲶻��쳣
            {
            }
        if (i==n)
            return value;
        int[] keys=new int[i];
        System.arraycopy(value, 0, keys, 0, i);
                                       //����value�����0��ʼ��i��Ԫ�ص�keys�����0��ʼ��Ԫ����
        return keys;
    }
    
}
/* 
�������н�����£�
�������10����������: 123
332
24
65
55
768
543
3546
88
90
87
���룺123, 	�������У� 123
���룺332, 	�������У� 123 332
���룺24, 	�������У� 24 123 332
���룺65, 	�������У� 24 65 123 332
���룺55, 	�������У� 24 55 65 123 332
���룺768, 	�������У� 24 55 65 123 332 768
���룺543, 	�������У� 24 55 65 123 332 543 768
���룺3546, 	�������У� 24 55 65 123 332 543 768 3546
���룺88, 	�������У� 24 55 65 88 123 332 543 768 3546
���룺90, 	�������У� 24 55 65 88 90 123 332 543 768 3546
24? 55? 65? 88? 90? ˳�����100, ���ɹ�


*/