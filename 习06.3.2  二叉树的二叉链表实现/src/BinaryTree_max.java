//��ϰ6.3��  ��һ��BinaryTree<T>�������и������ֵ�����ֵ����Сֵ��
//T����ʵ��Comparable<T>�ӿ�

public class BinaryTree_max
{    
    public static<T extends Comparable<T>> T max(BinaryTree<T> bitree)   //��������Ԫ�ص����ֵ
    {
        T maxvalue = null;
        return max(bitree.root, maxvalue);
    }
    //������p���Ϊ�����Ӷ���������Ԫ�ص����ֵ��֮ǰ�������������ֵ�Ѵ����maxvalue�У��ݹ鷽�����ȸ��������
    private static<T extends Comparable<T>> T max(BinaryNode<T> p, T maxvalue)
    {
        if (p!=null)
        {
            if (maxvalue==null || p.data.compareTo(maxvalue)>0) 
                maxvalue = p.data;
            maxvalue = max(p.left, maxvalue);
            maxvalue = max(p.right, maxvalue); 
        }
        return maxvalue;
    }
        
    public static<T extends Comparable<T>> T min(BinaryTree<T> bitree)   //��������Ԫ�ص���Сֵ
    {
        return min(bitree.root);
    }
    //������p���Ϊ�����Ӷ���������Ԫ�ص���Сֵ���ݹ鷽��������������
    private static<T extends Comparable<T>> T min(BinaryNode<T> p)
    {
        if (p!=null)
        {
            T minvalue = min(p.left);
            T min_right = min(p.right); 
            if (minvalue==null || min_right!=null && min_right.compareTo(minvalue)<0) 
                minvalue = min_right;
            if (minvalue==null || p.data.compareTo(minvalue)<0) 
                minvalue = p.data;
            return minvalue;
        }
        return null;
    }

    //�ֶ�ͳ��Ԫ�ظ�����according����ָ���ֶεĻ��֣����ر���ͳ�ƽ��������
    public static<T extends Comparable<T>> int[] grade(T[] according, BinaryTree<T> bitree)
    {
        int result[]= new int[according.length+1];
        grade(according, bitree.root, result);
        return result;
    }
    //�ֶ�ͳ��Ԫ�ظ�����according����ָ���ֶεĻ��֣�result���鱣��ͳ�ƽ��
    private static<T extends Comparable<T>> void grade(T[] according, BinaryNode<T> p, int result[])
    {
        if (p!=null)  
        {
            int i=0;
            while (i<according.length && p.data.compareTo(according[i])<0)
                i++;
            result[i]++;
            grade(according, p.left, result);
            grade(according, p.right, result);
        }
    }

    public static void main(String args[])
    {
    	Integer[] value={79,82,71,63,95,90,65,75,80,55};
    	BinaryTree<Integer> bitree1 = new CompleteBinaryTree<Integer>(value);
                                                  //����ȫ�������Ĳ�����й�����ȫ������
//    	BinaryTree<Integer> bitree1 = new 
//            CompleteBinaryTree<Integer>(Ex103_ArraySearch_Object.randomInteger(10,100));
        bitree1.preOrder();
        System.out.println("���ֵԪ���� "+max(bitree1)+"����СֵԪ���� "+min(bitree1));
        String str[]={"����","����","�е�","����","������"};
        Integer[] according={90,80,70,60};
        int result[]=grade(according, bitree1);
        System.out.print("�ɼ�ͳ�ƣ�");
        for (int i=0; i<result.length; i++)
             System.out.print(str[i]+result[i]+"�ˣ�");
        System.out.println();       

/*        bitree1=new BinarySortTree<Integer>(Ex103_ArraySearch_Object.randomInteger(10,100));
                                                           //�������������
        bitree1.inOrder();
        System.out.println("���ֵԪ���� "+max(bitree1)+"����СֵԪ���� "+min(bitree1));

        BinaryTree<String> bitree2=new CompleteBinaryTree<String>(Ex103_ArraySearch_Object.randomString(10));
        bitree2.preOrder();
        System.out.println("���ֵԪ���� "+max(bitree2)+"����СֵԪ���� "+min(bitree2));

        bitree2=new BinarySortTree<String>(Ex103_ArraySearch_Object.randomString(10));
        bitree2.inOrder();
        System.out.println("���ֵԪ���� "+max(bitree2)+"����СֵԪ���� "+min(bitree2));*/
    }
}
/*
�������н�����£�
�ȸ����������������  49 29 71 23 95 99 55 65 30 70 
���ֵԪ���� 99����СֵԪ���� 23
�ɼ�ͳ�ƣ�����2�ˣ�����0�ˣ��е�2�ˣ�����1�ˣ�������5�ˣ�
�и����������������  12 24 29 53 63 69 82 91 96 
���ֵԪ���� 96����СֵԪ���� 12
�ȸ����������������  O Q I G P I N K M U 
���ֵԪ���� U����СֵԪ���� G
�и����������������  H I J K L N P T W 
���ֵԪ���� W����СֵԪ���� H


�ȸ����������������  79 82 63 75 80 95 55 71 90 65 
���ֵԪ���� 95����СֵԪ���� 55
�ɼ�ͳ�ƣ�����2�ˣ�����2�ˣ��е�3�ˣ�����2�ˣ�������1�ˣ�

*/
