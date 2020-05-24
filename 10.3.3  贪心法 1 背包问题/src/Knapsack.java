//10.3.3   ̰�ķ�
//����10.3�� ��̰�ķ���ⱳ�����⡣

public class Knapsack                                      //��������
{
    //���췽������ⱳ�����⡣����kweightָ����������������arts�ṩ������Ʒ
    public Knapsack(float kweight, Article arts[])               
    {
        System.out.println(arts.length+"����Ʒ(����,��ֵ,��λ������ֵ)��");
        print(arts);                                       //�����Ʒ���У����һά�������飬������ʡ��       
        java.util.Arrays.sort(arts);                       //��������Ĭ��compareTo()����ָ��������� 
//        java.util.Arrays.sort(arts,new CompareByPerprice()); //���������ɱȽ�������ָ���������� 
        System.out.println(arts.length+"����Ʒ(����,��ֵ,��λ������ֵ)������λ������ֵ�������У�");
        print(arts);                                       //�����Ʒ���У����һά�������飬������ʡ��
        float kprice=0, x[]=new float[arts.length];        //x���鱣�������
        int i=0;
        for (i=0; i<arts.length && arts[i].weight<kweight; i++)  //������Ʒȫ�����뱳��
        {
            kweight -= arts[i].weight;                     //kweightΪ��������
            kprice += arts[i].price;                       //kpriceΪ��������Ʒ�ܼ�ֵ
            x[i] = 1;                                      //��Ʒiȫ��װ��
        }
        if (i<arts.length && kweight>0)                    //��Ʒi���ַ��뱳��
        {
            x[i] = kweight/arts[i].weight;
            kprice += arts[i].price*x[i];
        }
        System.out.print("���Ž⣺ ");  
        print(arts,x);                                     //���һ���⼰����ʵ������
        System.out.println("��������ֵ��"+String.format("%5.2f", kprice)+"\n");
    }
    
    private void print(Article arts[], float x[])          //���һ���⼰����ʵ������
    {
        float kweight=arts[0].weight*x[0];                 //����ʵ������
        System.out.print("("+x[0]);
        for (int i=1; i<x.length; i++)
        {
            System.out.print(","+String.format("%5.2f", x[i]));
            kweight+=arts[i].weight*x[i];
        }
        System.out.print(")������������"+String.format("%5.2f", kweight));
    }
    
    private void print(Object table[])                     //���һά�������飬�����Ʒ����
    {
        for (int i=0; i<table.length; i++)
            System.out.print(table[i]+"  ");
        System.out.println();
    }
   
    public static Article[] random(int n)              //���ز���n�������������
    {
    	Article[] list = new Article[n];
        for (int i=0; i<n; i++)
            list[i]=new Article((int)(Math.random()*100),(int)(Math.random()*100));   //���������
        return list;
    }
    
    public static void main(String args[]) throws Exception
    {
        Article arts[]={new Article(80,20),new Article(50,25),new Article(15,45)}; //��Ʒ���У�û����
        new Knapsack(100, arts);
        new Knapsack(100, Knapsack.random(3));
    }
}
/*
�������н�����£�
3����Ʒ(����,��ֵ,��λ������ֵ)��
(80,20, 0.25)  (50,25, 0.50)  (15,45, 3.00)  
3����Ʒ(����,��ֵ,��λ������ֵ)������λ������ֵ�������У�
(15,45, 3.00)  (50,25, 0.50)  (80,20, 0.25)  
���Ž⣺ (1.0, 1.00, 0.44)������������100.00��������ֵ��78.75

3����Ʒ(����,��ֵ,��λ������ֵ)��
(12,33, 2.75)  (65,35, 0.54)  (78,72, 0.92)  
3����Ʒ(����,��ֵ,��λ������ֵ)������λ������ֵ�������У�
(12,33, 2.75)  (78,72, 0.92)  (65,35, 0.54)  
���Ž⣺ (1.0, 1.00, 0.15)������������100.00��������ֵ��110.38


*/
/*??
    private void printAll(float kweight, Article arts[])   //������п��ý�
    {
        System.out.println(arts.length+"����Ʒ(����,��ֵ,��λ������ֵ)��");
        print(arts);                                       //�����Ʒ���У����һά�������飬������ʡ��
        System.out.println("����������"+kweight);
    	float kprice=0, x[]=new float[arts.length];        //x���鱣�������
    	int i=0;
        for (i=0; i<arts.length && arts[i].weight<kweight; i++)  //������Ʒȫ�����뱳��
        {
            kweight -= arts[i].weight;                     //kweightΪ��������
            kprice += arts[i].price;                       //kpriceΪ��������Ʒ�ܼ�ֵ
            x[i] = 1;                                      //��Ʒiȫ��װ��
        }
        if (i<arts.length && kweight>0)                    //��Ʒi���ַ��뱳��
        {
            x[i] = kweight/arts[i].weight;
            kprice += arts[i].price*x[i];
            i++;
        }
    
        System.out.print("���ý⣺ ");  
        print(x);                                          //���һ���⣬���һά����x��������ʡ��
        System.out.println("������ֵ��"+kprice+"\n");
    }
*/