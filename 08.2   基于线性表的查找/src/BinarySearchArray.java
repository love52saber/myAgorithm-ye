//8.2.2   ��������˳�����۰����

public class BinarySearchArray
{
    public static void print(int[] value)                  //�������Ԫ��
    {
        for (int i=0; i<value.length; i++)
            System.out.print(" "+value[i]);
        System.out.println();
    }

    //�ڰ��������е�value�����У��۰���ҹؼ���Ϊkey��Ԫ�أ������ҳɹ������±꣬���򷵻�-1
    //������Ϊ��value==null�����׳��ն����쳣
/*    public static int binarySearch(int[] value, int key)
    {
        int begin=0, end=value.length-1;                   //���ҷ�Χ���½���Ͻ�
        while (begin<=end)                                 //�߽���Ч 
        {
            int mid = (begin+end)/2;                       //�м�λ�ã���ǰ�Ƚ�Ԫ��λ��
            System.out.print(value[mid]+"? ");             //��ʾ�Ƚ��м�������ʡ��
            if (value[mid]==key) 
                return mid;                                //���ҳɹ�
            if (value[mid]>key)                            //����ֵС
                end = mid-1;                               //���ҷ�Χ��С��ǰ���
            else
                begin = mid+1;                             //���ҷ�Χ��С������
        }
        return -1;                                         //���Ҳ��ɹ�
    }  */

    //�ڰ��������е�value���������У��۰���ҹؼ���Ϊkey��Ԫ�أ������ҳɹ������±꣬���򷵻�-1
    public static <T> int binarySearch(Comparable<T>[] value, T key)
    {
        return binarySearch(value, 0, value.length-1, key);
    }  
    //�ڴ�begin��end��Χ�ڡ����������е�value�����У��۰���ҹؼ���Ϊkey��Ԫ��
    //�����ҳɹ�����Ԫ���±꣬���򷵻�-1
    public static <T> int binarySearch(Comparable<T>[] value, int begin, int end, T key)
    {
        if (key!=null)
            while (begin<=end)                              //�߽���Ч
            {   int mid = (begin+end)/2;                    //�м�λ�ã���ǰ�Ƚ�Ԫ��λ��
                System.out.print(value[mid]+"? ");
                if (value[mid].compareTo(key)==0)           //����Ƚϴ�С
                    return mid;                             //���ҳɹ�
                if (value[mid].compareTo(key)>0)            //��������С
                    end = mid-1;                            //���ҷ�Χ��С��ǰ���
                else begin = mid+1;                         //���ҷ�Χ��С������
            }
        return -1;                                          //���Ҳ��ɹ�
    }
    
    public static void main(String[] args)
    {
        int[] value ={8,17,26,32,40,72,87,99};             //�Ѱ���������
        System.out.print("�Ѱ���������Ĺؼ�������: ");
        print(value);
        int key=99;
        System.out.println("�۰���� "+key+", "+((binarySearch(value,key)==-1)?"��":"")+"�ɹ�");
        key=25;
        System.out.println("�۰���� "+key+", "+((binarySearch(value,key)==-1)?"��":"")+"�ɹ�");
    }
/* 
�������н�����£�
�Ѱ���������Ĺؼ�������:  8 17 26 32 40 72 87 99 
32? 72? 87? 99? �۰���� 99, �ɹ� 
32? 17? 26? �۰���� 25, ���ɹ� 

*/

    //��8��ϰ�⣬�ݹ��㷨
    //���Ѱ��������е�value�����У��۰���ҹؼ���Ϊkey��Ԫ�أ������ҳɹ������±꣬���򷵻�-1
    public static int binarySearch(int[] value, int key)
    { 
        return binarySearch(value, key, 0, value.length-1);
    }
    //���Ѱ��������е�value�����У���begin��endָ�����ҷ�Χ���½���Ͻ磬�۰����Ԫ��x
    //�����ҳɹ�����Ԫ���±꣬���򷵻�-1���ݹ��㷨
    public static int binarySearch(int[] value, int key, int begin, int end)
    {
        if (begin<=end)                                    //�߽���Ч 
        {
            int mid = (begin+end)/2;                       //�м�λ�ã���ǰ�Ƚ�Ԫ��λ��
            System.out.print(value[mid]+"? ");             //��ʾ�Ƚ��м�������ʡ��
            if (value[mid]==key) 
                return mid;                                //���ҳɹ�
            if (value[mid]>key)                                  //����ֵС
                return binarySearch(value, key, begin, mid-1);   //���ҷ�Χ��С��ǰ���
            return binarySearch(value, key, mid+1, end);         //���ҷ�Χ��С������
        }
        return -1;                                         //���Ҳ��ɹ�
    }  
    
    //��12�£���
    //�ڴ�begin��end��Χ�ڡ��Ѱ��������е�value�����У��۰���ҹؼ���Ϊkey��Ԫ��
    //���Ѱ��������е�value�����������۰���ҹؼ���Ϊkey��Ԫ�أ��ɱȽ�������comparatorָ������Ƚϴ�С�Ĺ���
    //�����ҳɹ������±꣬���򷵻�-1
    public static<T> int binarySearch(T[] value, T key, java.util.Comparator<? super T> comparator)
    {
        return binarySearch(value, 0, value.length-1, key, comparator);
    }  
    //���Ѱ��������е�value�����У���low��highָ�����ҷ�Χ���½���Ͻ磬�۰����cobj
    //�����ҳɹ�����Ԫ���±꣬���򷵻�-1
    public static<T> int binarySearch(T[] value, int begin, int end, T key, java.util.Comparator<? super T> comparator)
    {
        if (value!=null && key!=null)
            while (begin<=end)                              //�߽���Ч
            {
                int mid = (begin+end)/2;                    //�м�λ�ã���ǰ�Ƚ�Ԫ��λ��
                System.out.print(value[mid]+"? ");
                if (comparator.compare(value[mid],key)==0)  //����Ƚϴ�С
                    return mid;                             //���ҳɹ�
                if (comparator.compare(value[mid],key)>0)   //��������С
                    end = mid-1;                            //���ҷ�Χ��С��ǰ���
                else
                    begin = mid+1;                          //���ҷ�Χ��С������
            }
        return -1;                                          //���Ҳ��ɹ�
    }  

}
