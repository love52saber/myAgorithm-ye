//����4.4�� ���̰����ȼ����ȹ���

public class Process implements Comparable<Process>        //����
{
    private String name;                                   //������
    private int priority;                                  //���ȼ�
                
    public Process(String name, int priority)
    {
        this.name = name;
        this.priority = priority;
    }
    public String toString()
    {
        return "("+this.name+","+this.priority+")";
    }

    public int compareTo(Process p)                        //�Ƚ��������̵Ĵ�С��Լ�������ŶӴ���Ĺ���
    {
        return this.priority - p.priority;
    }

    public static void main(String args[])
    {
        Process process[]={new Process("A",4),new Process("B",3),new Process("C",5),
                           new Process("D",4),new Process("E",10),new Process("F",1)};
        PriorityQueue<Process> que = new PriorityQueue<Process>();   //����һ�����ȶ���
        System.out.print("��ӽ��̣�");
        for (int i=0; i<process.length; i++)
        {
            que.enqueue(process[i]);                                 //�������
//            System.out.print(process[i]+" ");
        }
        System.out.print("\n���ӽ��̣�");
        while (!que.isEmpty()) 
            System.out.print(que.dequeue().toString()+" ");          //����
        System.out.println();
    }
}
/*
�������н�����£�
��ӽ��̣�(A,4) (B,3) (C,5) (D,4) (E,10) (F,1)
���ӽ��̣�(F,1) (B,3) (A,4) (D,4) (C,5) (E,10) 
*/
//���ϵ�4��

/*
��10�³������н�����£�
��ӽ��̣�((A,4))  
((B,3), (A,4))  
((B,3), (A,4), (C,5))  
((B,3), (A,4), (C,5), (D,4))  
((B,3), (A,4), (C,5), (D,4), (E,10))  
((F,1), (A,4), (B,3), (D,4), (E,10), (C,5))  

���ӽ��̣�(F,1) (B,3) (A,4) (D,4) (C,5) (E,10) 

*/
