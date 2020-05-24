//2.4   ���Ա��Ӧ�ã�����ʽ�ı�ʾ������
//2.4.2   ��Ԫ����ʽ�ı�ʾ������

public class TermXY extends TermX                          //��Ԫ����ʽ��һ��
{
    protected int exp_y;                                   //yָ��

    public TermXY(int coef, int exp, int exp_y)            //����һ��
    {
        super(coef, exp);                                  //���츸��һ����ø���ͬ�������췽��
        this.exp_y = exp_y;
    }

    //���ض�Ԫ����ʽ��һ���Ӧ�ġ�ϵ��x^ָ������ʡ����ʽ�ַ�����ʡ����ʽҪ��ͬTermX�ࡣ���Ǹ���ͬ������
    public String toString()                     
    {
        String str=super.toString();                       //ִ�и���TermXͬ�����������ϵ����xָ��
        if (this.exp_y>0)
            str+="y";
        if (this.exp_y>1)
            str+="^"+this.exp_y;
        return str;
    }   

    public int compareTo(TermXY term)                      //Լ����ָ���Ƚ������С�����Ǹ���ͬ������
    {
        if (this.exp==term.exp && this.exp_y==term.exp_y)  //����ָ����Ӧ���
            return 0;
        return (this.exp<term.exp || this.exp==term.exp && this.exp_y<term.exp_y)? -1 : 1;
    }
    
    public boolean equals(Object obj)                      //�Ƚ������Ƿ���ȣ����Ǹ���ͬ������
    {
        return this==obj || obj instanceof TermXY && super.equals(obj) && this.exp==((TermXY)obj).exp_y; 
    }    

    //ϰ��2
    //�ԡ�ϵ��x^ָ������ʡ����ʽ����һԪ����ʽ��һ�
    public TermXY(String termstr)
    {
        super(termstr);
        if (termstr.charAt(0)=='+')
        	termstr=termstr.substring(1);
    	int i = termstr.indexOf('y');
        if (i==-1)
        {
            this.coef = Integer.parseInt(termstr);
            this.exp = 0;
        }
        else if (i==0)
             {
                 this.coef = 1;
                 this.exp = 1;
             }
             else
             {
                 String sub=termstr.substring(0,i);
                 if (sub.equals("-"))
                	 this.coef=-1;
                 else
            	     this.coef = Integer.parseInt(sub);
                 i = termstr.indexOf('^');
                 if (i==-1)
            	     this.exp=1;
                 else
                     this.exp = Integer.parseInt(termstr.substring(i+1));
             }
    }

    public TermXY(int coef, int exp)                       //����һ�ָ��Ĭ��ֵ
    {
        this(coef, exp, 0);
    }
    public TermXY(TermXY term)                             //�������췽��
    {
        this(term.coef, term.exp, term.exp_y);
    }
    public TermXY(TermX term, int exp_y)                   //����һ��
    {
        this(term.coef, term.exp, exp_y);
    }
    public TermXY(TermX term)                              //����һ��
    {
        this(term.coef, term.exp, 0);
    }
}
 /*   
    public double value(int x, int y)                       //��һ���ֵ
    {
        return super.value(x)*Math.pow(y, this.exp_y);       //Term::value(x)ִ�л��౻���ǵ�ͬ������
    }
}*/