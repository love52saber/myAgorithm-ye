//��ϰ6.3��  ��һ��BinaryTree<Integer>�������и������ֵ��ƽ��ֵ��

public class BinaryTree_average
{    
    //ƽ��ֵ
    private static int sum=0, count=0, max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
    public static double averageAll(BinaryTree<Integer> bitree) //��������Ԫ�ص�ƽ��ֵ
    {
        sumCount(bitree.root);                             //��������Ͳ�������Ҫ��rootȨ�ޱ�����public
        if (count==0)
            return 0.0;
        return (double)sum/count;
    }
    //����p���Ϊ�����Ӷ�������Ͳ��������ݹ鷽�����ȸ��������
    private static void sumCount(BinaryNode<Integer> p)
    {
        if (p!=null)
        {
            sum += p.data.intValue();  
            count++;
            sumCount(p.left);
            sumCount(p.right); 
        }
    }
          
    //����ȥ����߷ֺ���ͷֺ��ƽ��ֵ
    public static double averageExceptMaxMin(BinaryTree<Integer> bitree)
    {
        sumCountMaxMin(bitree.root);                       //��������͡������������ֵ����Сֵ
        if (count==0)
            return 0.0;
        if (count==1 || count==2)
            return (double)sum/count;                      //��������Ԫ�ص�ƽ��ֵ
        return (double)(sum-max-min)/(count-2);            //����ȥ����߷ֺ���ͷֺ��ƽ��ֵ
    }
    //����p���Ϊ�����Ӷ�������͡������������ֵ����Сֵ���ݹ鷽�����ȸ��������������
    private static void sumCountMaxMin(BinaryNode<Integer> p)
    {
        if (p!=null) 
        {
            int value = p.data.intValue();
            sum += value; 
            if (value>max)
                max = value;
            if (value<min)
                min = value;
            count++;
            sumCountMaxMin(p.left); 
            sumCountMaxMin(p.right); 
        }
    }
    
    //�ֶ�ͳ��Ԫ�ظ���
    public static int[] grade(Integer[] according, BinaryTree<Integer> bitree)
    {
    	int result[]= new int[according.length+1];
        grade(according, bitree.root, result);
        return result;
    }
    private static void grade(Integer[] according, BinaryNode<Integer> p, int result[])
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
        BinaryTree<Integer> bitree1=
            new CompleteBinaryTree<Integer>(Ex103_ArraySearch_Object.randomInteger(10,100));
                                              //����ȫ�������Ĳ�����й�����ȫ������
        bitree1.preOrder();
        System.out.println("����Ԫ�ص�ƽ��ֵ��  "+String.format("%10.3f", averageAll(bitree1)));
        System.out.println("ȥ����߷ֺ���ͷֺ��ƽ��ֵ��  "+String.format("%10.3f",averageExceptMaxMin(bitree1)));

        String str1[]={"����","����","�е�","����","������"};
        Integer[] according1={90,80,70,60};
        int result1[]=grade(according1, bitree1);
        System.out.print("1��ɼ�ͳ�ƣ�");
        for (int i=0; i<result1.length; i++)
            System.out.print(str1[i]+result1[i]+"�ˣ�");
        System.out.println();       

        BinaryTree<Integer> bitree2=new CompleteBinaryTree<Integer>(Ex103_ArraySearch_Object.randomInteger(10,150));
        bitree2.preOrder();
        System.out.println("����Ԫ�ص�ƽ��ֵ��  "+String.format("%10.3f", averageAll(bitree2)));
        Integer[] according2={135,120,105,90};
        int result2[]=grade(according2, bitree2);
        System.out.print("2��ɼ�ͳ�ƣ�");
        for (int i=0; i<result2.length; i++)
            System.out.print(str1[i]+result2[i]+"�ˣ�");
        System.out.println();

        System.out.print("����ɼ��ϼƣ�");
        for (int i=0; i<result2.length; i++)
            System.out.print(str1[i]+(result1[i]+result2[i])+"�ˣ�");
        System.out.println();

        String str2[]={"����","������"};
        Integer[] according3={90};
        int result3[]=grade(according3, bitree2);
        System.out.print("2��ɼ�ͳ�ƣ�");
        for (int i=0; i<result3.length; i++)
            System.out.print(str2[i]+result3[i]+"�ˣ�");
        System.out.println();       
    }
}
/*
�������н�����£�
�ȸ����������������  93 13 18 3 81 76 42 44 82 66 
����Ԫ�ص�ƽ��ֵ��      51.800
ȥ����߷ֺ���ͷֺ��ƽ��ֵ��      52.222
1��ɼ�ͳ�ƣ�����1�ˣ�����2�ˣ��е�1�ˣ�����1�ˣ�������5�ˣ�
�ȸ����������������  2 97 55 57 83 83 28 126 29 144 
����Ԫ�ص�ƽ��ֵ��      58.000
2��ɼ�ͳ�ƣ�����1�ˣ�����1�ˣ��е�0�ˣ�����1�ˣ�������7�ˣ�
����ɼ��ϼƣ�����2�ˣ�����3�ˣ��е�1�ˣ�����2�ˣ�������12�ˣ�
2��ɼ�ͳ�ƣ�����3�ˣ�������7�ˣ�


*/
