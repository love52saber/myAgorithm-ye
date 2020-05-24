//������
public class HeapSort
{
    public static void print(Object[] table)               //�����������Ԫ��
    {
        if (table!=null)
            for (int i=0; i<table.length; i++)
                System.out.print(" "+table[i].toString());
        System.out.println();
    }
    public static Integer[] random(int n)                  //����n���������������������
    {
        if (n<=0)
            return null;
        Integer table[] = new Integer[n];
        for (int i=0; i<table.length; i++)
            table[i] = new Integer((int)(Math.random()*100)); //����һ��0��99֮��������
        return table;                                      //����һ������
    }
    
    public static void heapsort(Integer table[])        //��������򣬿ռ临�Ӷ�ΪO(n)
    {
        MinHeap<Integer> minheap = new MinHeap<Integer>(table);
        System.out.print("��С�����У�"+minheap.toString());
        for (int i=0; !minheap.isEmpty(); i++)
            table[i]=minheap.removeMin();               //������СֵԪ�أ�������ɾ������㲢����Ϊ��С��
        System.out.println();          
    }
    public static void main(String args[])
    {
        System.out.print("�ؼ�������: ");
        Integer table[] = random(9);
        print(table);
        heapsort(table);
        System.out.print("����");
        print(table);
    }
}
/*
�ؼ�������:  57 97 36 12 64 7 31 40 76 61
��С�����У�(7, 12, 31, 40, 61, 57, 36, 97, 76, 64) 
���� 7 12 31 36 40 57 61 64 76 97

�ؼ�������:  48 12 56 18 58 8 57 0 81 41
��С�����У�(0, 8, 12, 18, 41, 56, 57, 48, 81, 58) 
���� 0 8 12 18 41 48 56 57 58 81

�ؼ�������:  89 13 27 40 2 88 59 11 39 37
��С�����У�(2, 11, 27, 13, 37, 88, 59, 89, 39, 40) 
���� 2 11 13 27 37 39 40 59 88 89

�ؼ�������:  18 4 16 0 35 84 48 91 97 2
��С�����У�(0, 4, 16, 18, 2, 84, 48, 91, 97, 35) 
���� 0 4 2 16 18 35 48 84 91 97

�ؼ�������:  49 16 90 87 31 99 47 11 4
��С�����У�(4, 11, 47, 16, 31, 99, 90, 87, 49) 
���� 4 11 16 31 47 49 87 90 99


*/
