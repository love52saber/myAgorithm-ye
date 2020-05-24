//��Java�������ʵ�ý̳̣���3�棩��//��ϰ2.12�� ��ɸѡ������������
//�����ݽṹ(Java��)(��3��)��10.3.2   ��̬�滮��

public class Prime_array
{
	public static int[] prime(int max)           //���ذ���max��������������
	{
	    if (max<=0)
	    	return null;
        int primes[] = new int[max/2];
        primes[0]=2;                             //��֪����С����
        int n=1;                                 //��������,�������ʵ�ʳ���(Ԫ�ظ���)
        int i=1;                                 //��һ������Ӧ��ŵ������±�λ��
        int k=3;                                 //����С������ʼ����,����ż���������
        do
        {
            int j=0;
            while ((j<n) && (k % primes[j]!=0))  //����֪����primes[j]����k
                j++;                    
            if (j==n)                            //k������
            {
                primes[i]=k;                     //��k��ӵ�����prime��
                i++;
                n++;
            }
            k+=2;                                //������һ�������Ƿ�������
        }  while(k<max);
        int[] temp = new int[n];
        System.arraycopy(primes, 0, temp, 0, n);
        return temp;
	}

    public static void main(String args[]) 
    {
    	int max=100;
    	int primes[] = prime(max);               //���ذ���max��������������
    	System.out.println(max+"���ڵ�������"+primes.length+"��: ");
        for (int i=0; i<primes.length; i++) 
        {
            System.out.print(String.format("%5d",primes[i]));
            if ((i+1)%10==0)
                System.out.println();             //ÿ��д10����
        }
        System.out.println();
    }
}

/*
�������н�����£�
100���ڵ�������25��: 
    2    3    5    7   11   13   17   19   23   29
   31   37   41   43   47   53   59   61   67   71
   73   79   83   89   97

500���ڵ�������95��: 
    2    3    5    7   11   13   17   19   23   29
   31   37   41   43   47   53   59   61   67   71
   73   79   83   89   97  101  103  107  109  113
  127  131  137  139  149  151  157  163  167  173
  179  181  191  193  197  199  211  223  227  229
  233  239  241  251  257  263  269  271  277  281
  283  293  307  311  313  317  331  337  347  349
  353  359  367  373  379  383  389  397  401  409
  419  421  431  433  439  443  449  457  461  463
  467  479  487  491  499

*/