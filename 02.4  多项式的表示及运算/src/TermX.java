//2.4   ���Ա��Ӧ�ã�����ʽ�ı�ʾ������
//2.4.1   һԪ����ʽ�ı�ʾ������

//���࣬һԪ����ʽ��һ�ʵ�ֿɱȽϽӿںͿ���ӽӿ�
public class TermX implements Comparable<TermX>,Addible<TermX> 
{
    protected int coef, exp;                               //ϵ��coefficient��ָ��exponent����Ϊ����0��
 
    public TermX(int coef, int exp)                        //����һ��
    {
        this.coef = coef;
        this.exp = exp;
    }
    public TermX(TermX term)                               //�������췽��
    {
        this(term.coef, term.exp);
    }
    
    //�ԡ�ϵ��x^ָ������ʡ����ʽ����һԪ����ʽ��һ�
    //ʡ����ʽ˵������ϵ��Ϊ1��-1��ָ��>0ʱ��ʡ��1��-1ֻд���š�-������x^2��-x^3��
    //��ָ��Ϊ0ʱ��ʡ��x^0��ֻдϵ������ָ��Ϊ1ʱ��ʡ��^1��ֻдx��
    public TermX(String termstr)                           
    {
        if (termstr.charAt(0)=='+')                        //ȥ��+��
            termstr=termstr.substring(1);
        int i = termstr.indexOf('x');
        if (i==-1)                                         //û��x����ָ��Ϊ0
        {
            this.coef = Integer.parseInt(termstr);         //���ϵ��
            this.exp = 0;
        }
        else                                               //��x��x֮ǰΪϵ����x^֮��Ϊָ��
        {
            if (i==0)                                      //��x��ͷ����ϵ��Ϊ1
                this.coef = 1;
            else
            {
                String sub=termstr.substring(0,i);         //x֮ǰ���б�ʾϵ��
                if (sub.equals("-"))                       //ϵ��ֻ��-�ţ���ϵ��Ϊ1
                    this.coef=-1;
                else
                    this.coef = Integer.parseInt(sub);     //���ϵ��
            }
            i = termstr.indexOf('^');
            if (i==-1)
                 this.exp=1;                               //û��^����ָ��Ϊ1
            else
                 this.exp = Integer.parseInt(termstr.substring(i+1));//���ָ��
        }
    }

    //����һԪ����ʽ��һ���Ӧ�ġ�ϵ��x^ָ������ʡ����ʽ�ַ�����ʡ����ʽ˵��ͬTermX(String)���췽����
    public String toString()                     
    {
        String str=this.coef>0 ? "+" : "-";                //ϵ���ķ���λ
        if (this.exp==0 || this.exp>0 && this.coef!=1 && this.coef!=-1)
            str+=Math.abs(this.coef);                      //ϵ������ֵ��ʡ��ϵ��1
        if (this.exp>0)
            str+="x";                                      //ָ��Ϊ0ʱ��ʡ��x^0��ֻдϵ��
        if (this.exp>1)
            str+="^"+this.exp;                             //ָ��Ϊ1ʱ��ʡ��^1��ֻдx
        return str;
    }

    public int compareTo(TermX term)                       //Լ����ָ���Ƚ������С
    {
        if (this.exp == term.exp)                          //�Ƚ����
            return 0;                                      //�ȽϹ�����equals(Object obj)��ͬ
        return this.exp<term.exp ? -1 : 1;                 //�Ƚϴ�С�����Ƚ�ָ��
    }
    
    public void add(TermX term)                            //�ӷ�����=���������
    {
        if (this.compareTo(term)==0)
            this.coef += term.coef;
        else
            throw new IllegalArgumentException("�����ָ����ͬ��������ӡ�");
    }
    public boolean removable()                             //Լ��ɾ��Ԫ������
    {
        return this.coef==0;                               //���洢ϵ��Ϊ0����
    }
    
    public boolean equals(Object obj)                      //�Ƚ������Ƿ����
    {
        if (this==obj)
            return true;
        if (!(obj instanceof TermX))
            return false;
        TermX term=(TermX)obj;        
        return this.coef==term.coef && this.exp==term.exp; //�ȽϹ�����compareTo(term)==0��ͬ
    }
}

/*Ҫ��Ҫ??
    public double value(int x)                             //��һ���ֵ
    {
        return this.coef*Math.pow(x, this.exp);
    }
    public TermX plus(TermX term)                          //�ӷ��������������
    {
        TermX tmp = new TermX(this);                       //ִ�п������췽��
        tmp.add(term);
        return tmp;
    }

*/