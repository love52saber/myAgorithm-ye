//10.3.3   ̰�ķ�
//����10.3�� ��̰�ķ���ⱳ�����⡣
//��Ʒ��
public class Article implements java.lang.Comparable<Article>, java.util.Comparator<Article>
{
    int weight, price;                                     //��Ʒ�������ͼ�ֵ
    float pricePerWeight;                                  //��Ʒ�ĵ�λ������ֵ

    public Article(int weight, int price)
    {
        this.weight = weight;
        this.price = price;
        this.pricePerWeight = (float)price/weight;
    }
    public String toString()                     //������Ʒ�ļ�ֵ�������͵�λ������ֵ�����Ե������ַ���
    {
        return "("+weight+","+price+","+String.format("%5.2f", pricePerWeight)+")";
    }

    //ʵ��Comparable�ɱȽϽӿڣ��ṩ��Ʒ����λ������ֵ�Ƚϴ�С�Ĺ����ṩ��Ʒ����λ������ֵ������������  
    public int compareTo(Article art)
    {
//        return (int)((this.pricePerWeight - art.pricePerWeight)*100);      //����
        return (int)((art.pricePerWeight - this.pricePerWeight)*100);        //��Ʒ����λ������ֵ�Ƚϴ�С������
    }

    //ʵ��Comparator�Ƚ����ӿڣ��ṩ��Ʒ�������Ƚϴ�С�Ĺ��򣬼��ṩ��Ʒ������������������  
    public int compare(Article art1, Article art2)
    {
        return (int)(art2.weight - art1.weight);                 //��Ʒ�������Ƚϴ�С������
    }
} 

//PriceComparator��ʵ�ֱȽ����ӿڣ��ṩ��Ʒ����ֵ�Ƚϴ�С�Ĺ��򣬼��ṩ��Ʒ����ֵ������������  
class PriceComparator implements java.util.Comparator<Article>
{
    public int compare(Article art1, Article art2)
    {
        return (int)(art2.price - art1.price);
    }
}