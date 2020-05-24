//5.2.2 ϡ������ѹ���洢
//1.  ��ʾϡ��������Ԫ�ص���Ԫ��

public class Triple implements java.lang.Comparable<Triple>,Addible<Triple>//ϡ��������Ԫ�ص���Ԫ����
{
    int row, column, value;                                //�кţ��кţ�Ԫ��ֵ��Ĭ�Ϸ���Ȩ��

    public Triple(int row, int column, int value)
    {
        if (row<0 || column<0)
            throw new IllegalArgumentException("ϡ�����Ԫ����Ԫ�����/����ŷ�������");
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public Triple(Triple elem)                             //�������췽��������һ����Ԫ��
    {
        this(elem.row, elem.column, elem.value);
    }
    public String toString()                               //������Ԫ�������ַ���
    {
        return "("+row+","+column+","+value+")";
    }

    public boolean equals(Object obj)                      //������Ԫ��Ƚ��Ƿ���ȣ��Ƚ�λ�ú�Ԫ��ֵ
    {
        if (!(obj instanceof Triple))
            return false;
        Triple elem = (Triple)obj;
        return this.row==elem.row && this.column==elem.column && this.value==elem.value;
    }
    
    //������Ԫ��λ�ñȽ�������Ԫ��Ĵ�С����Ԫ��ֵ�޹أ�Լ����Ԫ���������
    public int compareTo(Triple elem)
    {
        if (this.row<elem.row || this.row==elem.row && this.column<elem.column)
            return -1;                                     //��ǰ��Ԫ�����С
        if (this.row==elem.row && this.column==elem.column)
            return 0;                                      //��ȣ���equals()�������岻ͬ
        return 1;                                          //��ǰ��Ԫ������
    }
    
    //����ʵ��Addible<Triple>�ӿڣ��еĵ�������
    public void add(Triple term)                           //�ӷ�����=���������
    {
        if (this.compareTo(term)==0)
            this.value += term.value;
        else
            throw new IllegalArgumentException("�����ָ����ͬ��������ӡ�");
    }
    public boolean removable()                             //Լ��ɾ��Ԫ������
    {
        return this.value==0;                              //���洢ֵΪ0��Ԫ��    
    }
    
   
    //ϰ��5��ת�þ�����
    public Triple toSymmetry()                            //���ضԳ�λ�þ���Ԫ�ص���Ԫ��
    {
        return new Triple(this.column, this.row, this.value);
    }

 
}

/*û���õ�
    public Triple plus(Triple term)                 //�ӷ��������������
    {
    	Triple tmp = new Triple(this);             //�������췽��
        tmp.add(term);
    	return tmp;
    } * 
 * û��
 
    public Element()
    {
        this(10,10,0);
    }
 */