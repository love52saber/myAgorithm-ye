//2.4   ���Ա��Ӧ�ã�����ʽ�ı�ʾ������
//2.4.1   һԪ����ʽ�ı�ʾ������

//����ʽ�࣬ʹ�ö���ʽ������������Ϊ��Ա�������ṩ����ʽ�������
//�������ʽ��������PolySLinkedList�ķ��Ͳ�����TermX����Polynomial��ʾһԪ����ʽ
//�������ʽ��������PolySLinkedList�ķ��Ͳ�����TermXY����Polynomial��ʾ��Ԫ����ʽ
public class Polynomial                                    //����ʽ��
{
    private PolySLinkedList<TermX> list;                   //����ʽ��������TermX��ʾһԪ����ʽ��һ��

    public Polynomial()                                    //Ĭ�Ϲ��췽��
    {
        this.list = new PolySLinkedList<TermX>();          //�����յ�����ִ����������Ĭ�Ϲ��췽��
    }
    public Polynomial(TermX terms[])                       //���췽������������ָ������ʽ����ֵ
    {
        this.list = new PolySLinkedList<TermX>(terms);
    }
    public Polynomial(String polystr)                      //���췽��������ָ������ʽ���ʽ�ַ���  
    {
        this();
        if (polystr==null || polystr.length()==0)
            return;
        Node<TermX> rear = this.list.head;
        int start=0, end=0;                                //���start��end���Ӵ�Ϊһ��
        while (start<polystr.length() && end<polystr.length())
        {
            int i=polystr.indexOf('+',end+1);              //�����ַ�+���ַ����д�end+1��ʼ�����
            if (i==-1)                                     //δ�ҵ�ָ���ַ�
                i=polystr.length();
            int j=polystr.indexOf('-',end+1);
            if (j==-1)
                j=polystr.length();
            end=i<j? i: j;                                 //endΪ��һ��+��-�ŵ����
 //           System.out.println("start="+start+", end="+end+", "+polystr.substring(start,end));
            rear.next = new Node<TermX>(new TermX(polystr.substring(start,end)), null);
                       //β���룬�����start��end���Ӵ���Ϊһ�������㣬����Ԫ�ض���
            rear = rear.next; 
            start=end;
        }
    }
    
    public Polynomial(Polynomial poly)                     //��ȿ������췽�������Ƶ���������н���Ԫ�ض���
    {
        this();                                            //�����յ�����ֻ��ͷ���
        Node<TermX> p = poly.list.head.next; 
        Node<TermX> rear = this.list.head;
        while (p!=null)
        {
            rear.next = new Node<TermX>(new TermX(p.data), null);//���ƽ�㣬����Ԫ�ض���
            rear = rear.next; 
            p = p.next;
        }
    }
    
    public String toString()                               //���ض���ʽ�������ַ���
    {
        String str="";
        for (Node<TermX> p=this.list.head.next;  p!=null;  p=p.next)
            str+=p.data.toString();
        return str;
    }

    public void add(Polynomial poly)                       //����ʽ��ӣ�this��=poly
    {
        this.list.add(poly.list);
    }
    public Polynomial plus(Polynomial poly)                //�ӷ�����C=this��poly
    {
    	Polynomial polyc=new Polynomial(this);             //��ȿ������������н�㼰Ԫ�ض���
        polyc.add(poly);
        return polyc;                                      //���ض�������
    }
    
    public boolean equals(Object obj)                      //�Ƚ���������ʽ�Ƿ����
    {
        return this==obj || obj instanceof Polynomial && this.list.equals(((Polynomial)obj).list);  
                                                           //�Ƚ������������Ƿ����
    }
}
/*��ͨ
    public Polynomial(String var, String polystr)                        //��������ָ������ʽ����ֵ
    {
        this();
        if (polystr.length()==0)
        	return;
        Node<TermX> rear = this.list.head;
        int start=0, end=0;                       //���start~end���Ӵ�Ϊ��1��
        while (start<polystr.length() && end<polystr.length())
        {
            int i=polystr.indexOf('+',end+1);                      //����ָ���ַ����ַ����е���ţ�δ�ҵ�����-1
            if (i==-1)
            	i=polystr.length();
            int j=polystr.indexOf('-',end+1);
            if (j==-1)
            	j=polystr.length();
            end=i<j? i: j;                       //���start~end���Ӵ�Ϊ��1��
            System.out.println("start="+start+", end="+end+", "+polystr.substring(start,end));
            if (var.equals("x"))
                rear.next = new Node<TermX>(new TermX(polystr.substring(start,end)), null);
            if (var.equals("xy"))
//                rear.next = new Node<TermX>(new TermXY(polystr.substring(start,end)), null);
            rear = rear.next; 
            start=end;
        }
    }

}
   /* 
    public void insert(Term term)                          //������
    {
        list.insert(term);                                 //�����������в����㣬����λ����term��ָ������
    }
    public double value(TermX term)                        //�����ʽֵ
    {
        double sum=0;
        Node<TermX> p=this.list.head.next;
        while (p!=null)
        {
             sum+=p.data.value(x);                         //����ֵ֮��
             p=p.next;
        }
        return sum;
    }

public double value(double x)//, double y)                         //��ֵ
{
    double sum=0;
    Node<Term> p=list.head.next;
    while (p!=null)
    {
         sum+=p.data.value(x);
         p=p.next;
    }
    return sum;
}
    

 */
