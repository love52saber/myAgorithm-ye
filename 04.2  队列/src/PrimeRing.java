//����4.3�� ������������⡣

public class PrimeRing 
{
    public PrimeRing(int n)                                //��1��n������
    {
        SeqList<Integer> ring = new SeqList<Integer>(n);   //����һ��˳���洢������
        ring.append(new Integer(1));                       //1��ӵ���������

        SeqQueue<Integer> que = new SeqQueue<Integer>(n);  //����һ������que
//        LinkedQueue<Integer> que = new LinkedQueue<Integer>();   //����һ������que
        for (int i=2; i<=n; i++)                              //2��nȫ�����
            que.enqueue(new Integer(i));
//        System.out.println(que.toString());
 
        int i=0;
        while (!que.isEmpty()) 
        {
            int k = que.dequeue().intValue();              //����
//            System.out.print("dequeue: "+k+"\t");
            if (isPrime(ring.get(i)+k))                    //�ж��Ƿ�Ϊ����
            {
                i++;
                ring.append(new Integer(k));               //k��ӵ���������
            }
            else
                que.enqueue(new Integer(k));               //k�ٴ����
//            System.out.println("����: "+que.toString());
        }
        System.out.println("������: "+ring.toString());
    }
    
    public boolean isPrime(int k)                          //�ж�k�Ƿ�Ϊ����
    {
        if (k==2)
            return true;
        if (k<2 || k>2 && k%2==0)
            return false;
        int j=(int)Math.sqrt(k);                           //Math.sqrt(k)����k��ƽ����ֵ
        if (j%2==0)
            j--;                                           //��ò��Է�Χ�ڵ��������
        while (j>2 && k%j!=0)
            j-=2;
        return j<2;
    }
    public static void main(String args[])
    {
         new PrimeRing(10);
    }
}

/*
�������н�����£�
 {2, 3, 4, 5, 6, 7, 8, 9, 10} 
dequeue: 2  ����:  {3, 4, 5, 6, 7, 8, 9, 10} 
dequeue: 3  ����:  {4, 5, 6, 7, 8, 9, 10} 
dequeue: 4  ����:  {5, 6, 7, 8, 9, 10} 
dequeue: 5  ����:  {6, 7, 8, 9, 10, 5} 
dequeue: 6  ����:  {7, 8, 9, 10, 5, 6} 
dequeue: 7  ����:  {8, 9, 10, 5, 6} 
dequeue: 8  ����:  {9, 10, 5, 6, 8} 
dequeue: 9  ����:  {10, 5, 6, 8, 9} 
dequeue: 10 ����:  {5, 6, 8, 9} 
dequeue: 5  ����:  {6, 8, 9, 5} 
dequeue: 6  ����:  {8, 9, 5, 6} 
dequeue: 8  ����:  {9, 5, 6, 8} 
dequeue: 9  ����:  {5, 6, 8} 
dequeue: 5  ����:  {6, 8, 5} 
dequeue: 6  ����:  {8, 5, 6} 
dequeue: 8  ����:  {5, 6} 
dequeue: 5  ����:  {6} 
dequeue: 6  ����:  {} 
������: (1, 2, 3, 4, 7, 10, 9, 8, 5, 6)


*/