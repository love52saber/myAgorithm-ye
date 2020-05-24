//��9��   ����

public class Array
{
    public static void print(int[] table)                  //�������Ԫ��
    {
        if (table!=null)
            for (int i=0; i<table.length; i++)
                System.out.print(" "+table[i]);
        System.out.println();
    }
    public static void print(Object[] table)               //�����������Ԫ��
    {
        if (table!=null)
            for (int i=0; i<table.length; i++)
                System.out.print(" "+table[i].toString());
        System.out.println();
    }

    //ֱ�Ӳ��������������������ͣ���Ϊ�����Ĳ�������Ԫ��ֵ�����ı�
    public static void insertSort(int[] table)
    {
        System.out.println("ֱ�Ӳ�������");
        for (int i=1; i<table.length; i++)                 //n-1��ɨ��
        {
            int temp=table[i], j;                          //ÿ�˽�table[i]���뵽ǰ������������
            for (j=i-1; j>=0 && temp<table[j]; j--)        //��ǰ��ϴ�Ԫ������ƶ�
                table[j+1] = table[j];
            table[j+1] = temp;                             //tempֵ�������λ��
            System.out.print("��"+i+"��: ");
            print(table);                                  //��������м�������ʡ��
        }
    }

    public static void shellSort(int[] table)              //ϣ������
    {
        System.out.println("ϣ������");
        for (int delta=table.length/2; delta>0; delta/=2)  //������ɨ�裬������������������
        {
            for (int i=delta; i<table.length; i++)         //һ�˷������飬ÿ�����ֱ�Ӳ�������
            {
                int temp=table[i], j;                      //table[i]�ǵ�ǰ������Ԫ��
                for (j=i-delta; j>=0 && temp<table[j]; j-=delta) //ÿ��Ԫ�����deltaԶ��Ѱ�Ҳ���λ��
                    table[j+delta] = table[j];
                table[j+delta] = temp;                     //����Ԫ��
            }
            System.out.print("delta="+delta+"  ");
            print(table);
        }
    }

    private static void swap(int[] table, int i, int j)     //�����������±�Ϊi��j��Ԫ��
    { 
        if (i>=0 && i<table.length && j>=0 && j<table.length && i!=j)   //�ж�i��j�Ƿ�Խ��
        {
            int temp = table[j];
            table[j] = table[i];
            table[i] = temp;
        }
    }

    public static void bubbleSort(int[] table)             //ð������
    {
        System.out.println("ð������");
        boolean exchange=true;                             //�Ƿ񽻻��ı��
        for (int i=1; i<table.length && exchange; i++)     //�н���ʱ�ٽ�����һ�ˣ����n-1��
        {
            exchange=false;                                //�ٶ�Ԫ��δ���� 
            for (int j=0; j<table.length-i; j++)           //һ�˱Ƚϡ�����
                if (table[j]>table[j+1])                   //����ʱ������
                {
                    int temp = table[j];
                    table[j] = table[j+1];
                    table[j+1] = temp;
                    exchange=true;                         //�н��� 
                }
            System.out.print("��"+i+"��: ");
            print(table);
        }
    }

    public static void quickSort(int[] table)              //��������
    {
        System.out.println("��������");
        quickSort(table, 0, table.length-1);
    }
    //һ�˿�������begin��highָ�����е��½���Ͻ磬�ݹ��㷨
    private static void quickSort(int[] table, int begin, int end)
    {
        if (begin<end)                                     //������Ч
        {
            int i=begin, j=end;
            int vot=table[i];                              //��һ��ֵ��Ϊ��׼ֵ
            while (i!=j)                                   //һ������
            {
                while (i<j && vot<=table[j])               //�Ӻ���ǰѰ�ҽ�Сֵ
                    j--;
                if (i<j)
                    table[i++]=table[j];                   //��СԪ����ǰ�ƶ�
                while (i<j && table[i]<=vot)               //��ǰ���Ѱ�ҽϴ�ֵ
                    i++;
                if (i<j)
                    table[j--]=table[i];                   //�ϴ�Ԫ������ƶ�
            }
            table[i]=vot;                                  //��׼ֵ��������λ��
            System.out.print(begin+".."+end+",  vot="+vot+"  ");
            print(table);
            quickSort(table, begin, j-1);                 //ǰ�������������򣬵ݹ����
            quickSort(table, i+1, end);                   //��������������򣬵ݹ����
        }
    }

    public static void selectSort(int[] table)             //ֱ��ѡ������
    {
        System.out.println("ֱ��ѡ������");
        for (int i=0; i<table.length-1; i++)               //n-1������
        {                                                  //ÿ���ڴ�i��ʼ����������Ѱ����СԪ��
            int min=i;                                     //���i������Ԫ����С
            for (int j=i+1; j<table.length; j++)           //���������в�����Сֵ
                if (table[j]<table[min])
                     min = j;                              //��ס��СԪ���±�
            if (min!=i)                                    //��������СԪ�ؽ�����ǰ��
            {
                int temp = table[i];
                table[i] = table[min];
                table[min] = temp;
            }
            System.out.print("��"+(i+1)+"��: ");
            print(table);
        }
    }

    public static void heapSort_min(int[] table)           //�����򣨽��򣩣���С��
    {
        System.out.println("��С�ѣ� "+isMinHeap(table));
        System.out.println("������С������");
        int n=table.length;
        for (int j=n/2-1; j>=0; j--)                       //������С��
            sift_min(table, j, n-1);
        System.out.println("��С�ѣ� "+isMinHeap(table));
            
        System.out.println("�����򣨽���");
        for (int j=n-1; j>0; j--)                          //ÿ�˽���Сֵ���������棬�ٵ����ɶ�
        {
            int temp = table[0];
            table[0] = table[j];
            table[j] = temp;
            sift_min(table, 0, j-1);
        }
    }
    //����beginΪ����������������С�ѣ�begin��end�������½���Ͻ�
    private static void sift_min(int[] table, int begin, int end)
    {
        int i=begin,j=2*i+1;                               //iΪ�����ĸ���jΪi��������
        int temp=table[i];                                 //��õ�i��Ԫ�ص�ֵ
        while (j<=end)                                     //�ؽ�Сֵ���ӽ������ɸѡ
        { 
            if (j<end && table[j]>table[j+1])              //����Ԫ�رȽϣ��ĳ�<Ϊ���ѣ�
                j++;                                       //jΪ���Һ��ӵĽ�С��
            if (temp>table[j])                             //����ĸ���ֵ�ϴ󣨸ĳ�<Ϊ���ѣ�
            {
                table[i]=table[j];                         //���ӽ���еĽ�Сֵ����
                i=j;                                       //i��j����һ��
                j=2*i+1;
            }
            else break;                                    //�˳�ѭ��
        }
        table[i]=temp;                                     //��ǰ������ԭ��ֵ�������λ��
        System.out.print("sift  "+begin+".."+end+"  ");
        print(table);
    }

    public static void heapSort_max(int[] table)           //���������򣩣�����
    {
        System.out.println("���ѣ� "+isMaxHeap(table));
        System.out.println("������������");
        int n=table.length;
        for (int j=n/2-1; j>=0; j--)                       //��������
            sift_max(table, j, n-1);
        System.out.println("���ѣ� "+isMaxHeap(table));
            
        System.out.println("����������");
        for (int j=n-1; j>0; j--)                          //ÿ�˽����ֵ���������棬�ٵ����ɶ�
        {
            int temp = table[0];
            table[0] = table[j];
            table[j] = temp;
            sift_max(table, 0, j-1);
        }
    }
    //����beginΪ�����������������ѣ�begin��end�������½���Ͻ�
    private static void sift_max(int[] table, int begin, int end)
    {
        int i=begin,j=2*i+1;                               //iΪ�����ĸ���jΪi��������
        int temp=table[i];                                 //��õ�i��Ԫ�ص�ֵ
        while (j<=end)                                     //�ؽϴ�ֵ���ӽ������ɸѡ
        { 
            if (j<end && table[j]<table[j+1])              //����Ԫ�رȽ�
                j++;                                       //jΪ���Һ��ӵĽϴ���
            if (temp<table[j])                             //����ĸ���ֵ��С
            {
                table[i]=table[j];                         //���ӽ���еĽϴ�ֵ����
                i=j;                                       //i��j����һ��
                j=2*i+1;
            }
            else break; 
        }
        table[i]=temp;                                     //��ǰ������ԭ��ֵ�������λ��
        System.out.print("sift  "+begin+".."+end+"  ");
        print(table);
    }

    public static void mergeSort(int[] X)                  //�鲢����
    {
        System.out.println("�鲢����");
        int[] Y = new int[X.length];                       //Y���鳤��ͬX����
        int n=1;                                           //������������г��ȣ���ֵΪ1
        while (n<X.length)
        {
            mergepass(X, Y, n);                            //һ�˹鲢����X�����и������й鲢��Y��
            print(Y);
            n*=2;                                          //�����г��ȼӱ�
            if (n<X.length)
            {
                mergepass(Y, X, n);                        //��Y�����и��������ٹ鲢��X��
                print(X);
                n*=2;
            }
        }
    }
    
    private static void mergepass(int[] X, int[] Y, int n) //һ�˹鲢
    {
        System.out.print("�����г���n="+n+"  ");
        int i=0;
        for (i=0;  i<X.length-2*n+1;  i+=2*n)              //X���������������й鲢��Y��
            merge(X, Y, i, i+n, n);                        //��X����������������һ�ι鲢��Y������
        if (i+n<X.length)
            merge(X, Y, i, i+n, n);                        //��һ�ι鲢
        else  
            for (int j=i; j<X.length; j++)                 //��Xʣ��Ԫ�ظ��Ƶ�Y��
                Y[j]=X[j];
    }

    private static void merge(int[] X, int[] Y, int m, int r, int n)   //һ�ι鲢
    {
        int i=m, j=r, k=m;
        while (i<r && j<r+n && j<X.length)                 //��X���������������й鲢��Y��
            if (X[i]<X[j])                                 //��Сֵ���Ƶ�Y��
                Y[k++]=X[i++];
            else
                Y[k++]=X[j++];

        while (i<r)                                        //��ǰһ��������ʣ��Ԫ�ظ��Ƶ�Y��
            Y[k++]=X[i++];
        while (j<r+n && j<X.length)                        //����һ��������ʣ��Ԫ�ظ��Ƶ�Y��
            Y[k++]=X[j++];
    }
    
    //ϰ��9
    public static void insertSort(Comparable[] value)      //���������ֱ�Ӳ�������
    {
        System.out.println("ֱ�Ӳ�������");
        for (int i=1; i<value.length; i++)                 //n-1��ɨ��
        {
            Comparable temp=value[i];                      //ÿ�˽�value[i]���뵽ǰ��������������
            int j;
            for (j=i-1; j>=0 && temp.compareTo(value[j])<0; j--)  //��ǰ��ϴ�Ԫ������ƶ�
                value[j+1] = value[j];
            value[j+1] = temp;                             //tempֵ�������λ��
            System.out.print("��"+i+"��: ");
            print(value);                                  //����print(Object)��������м�������ʡ��
        }
    }
    
    //��9��ϰ��    
    public static boolean isMinHeap(int[] value)           //�ж�һ�����������Ƿ�Ϊ��С��
    {
        if (value.length==0)                               //�����в��Ƕѡ����޴˾䣬��������Ƕѣ����岻ͬ
            return false;
        for (int i=value.length/2-1; i>=0; i--)            //i������һ�������ĸ���㿪ʼ
        {
            int j=2*i+1;                                   //j��i�����ӣ��϶�����
            if (value[i]>value[j] || j+1<value.length && value[i]>value[j+1])
                return false;
        }
        return true;
    }

    public static boolean isMaxHeap(int[] value)           //�ж�һ�����������Ƿ�Ϊ����
    {
        if (value.length==0)                               //�����в��Ƕ�
            return false;
        for (int i=value.length/2-1; i>=0; i--)            //i������һ�������ĸ���㿪ʼ
        {
            int j=2*i+1;                                   //j��i�����ӣ��϶�����
            if (value[i]<value[j] || j+1<value.length && value[i]<value[j+1])
                return false;
        }
        return true;
    }
}
