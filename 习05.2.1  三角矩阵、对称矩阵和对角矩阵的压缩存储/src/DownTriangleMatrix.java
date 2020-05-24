//5.2   ��������ѹ���洢
//5.2.1   ���Ǿ��󡢶Գƾ���ͶԽǾ����ѹ���洢
//1.  ���Ǿ���
//����5.2��  �����Ǿ��������ѹ���洢��

public class DownTriangleMatrix                            //����ѹ���洢�������Ǿ�����
{
    private int rows;                                      //�����Ǿ���������������
    private int element[];                                 //�洢����Ԫ�ص�һά����

    public DownTriangleMatrix(int rows)                    //����rows�������Ǿ���Ԫ��Ϊ0
    {
        if (rows<=0)
            throw new IllegalArgumentException("����������������"+rows); //�׳���Ч�����쳣
        this.rows = rows ;
        this.element = new int[rows*(rows+1)/2];           //rows�������Ǿ�����Ҫ�洢rows*(rows+1)/2��Ԫ��    
    } 
    //����rows�������Ǿ��󣬳�ֵ��mat�ṩ��mat��������˳��洢rows�������Ǿ���Ԫ��
    public DownTriangleMatrix(int rows, int mat[])           
    {
        this(rows);
        int n = element.length<=mat.length ? element.length : mat.length;
        for (int i=0; i<n; i++)                            //matԪ�ز���ʱ��0�����Զ���Ԫ��
            this.element[i] = mat[i];
    }

    public int get(int i, int j)                           //���ؾ����i�е�j��Ԫ��ֵ��O(1)
    {
        if (i<0 || i>=rows || j<0 || j>=rows) 
            throw new IndexOutOfBoundsException("����Ԫ�ص��л������Խ��");
        return i<j ? 0 : element[i*(i+1)/2+j];             //������ѹ���洢��ַѰ�Ҿ���Ԫ��
    }
    public void set(int i, int j, int value)               //���þ����i�е�j��Ԫ��ֵΪvalue��O(1)
    {
        if (i<0 || i>=rows || j<0 || j>=rows) 
            throw new IndexOutOfBoundsException("����Ԫ�ص��л������Խ��");
        this.element[i*(i+1)/2+j] = value;
    }
    public String toString()                     //���������Ǿ�������Ԫ�ص������ַ��������������
    {
        String str=" �����Ǿ���"+this.getClass().getName()+"��"+this.rows+"�ף���\n";
        for (int i=0; i<this.rows; i++)
        {
            for (int j=0; j<this.rows; j++)
                str += String.format("%4d", this.get(i,j));
            str += "\n";
        }
        return str;
    }

    //��ǰ�����Ǿ�����mat������ӣ�this+=mat������ӦԪ����ӣ��ı䵱ǰ����
    public void add(DownTriangleMatrix mat)
    {
        if (this.rows!=mat.rows)
            throw new IllegalArgumentException("�������������ͬ���������");
        for (int i=0; i<this.element.length; i++)
            this.element[i] += mat.element[i];
    }

    //ϰ��5
    public DownTriangleMatrix(DownTriangleMatrix mat)      //���
    {
        this(mat.rows, mat.element);
    }
    
    //���ص�ǰ������mat��Ӻ�ľ���=this+mat������ӦԪ����ӣ����ı䵱ǰ����
    public DownTriangleMatrix plus(DownTriangleMatrix mat)
    {
        DownTriangleMatrix matc=new DownTriangleMatrix(this);//���
        matc.add(mat);
        return matc;                                       //���ض�������
    }    
    
    public boolean equals(Object obj)                      //�Ƚ�����ͬ�׾����Ƿ����
    {
        if (this==obj)
            return true;
        if (!(obj instanceof DownTriangleMatrix))
            return false;
        DownTriangleMatrix mat=(DownTriangleMatrix)obj;
        if (this.rows!=mat.rows)
            return false;
        for (int i=0; i<this.element.length; i++)
            if (this.element[i]!=mat.element[i])           //�Ƚ϶�ӦԪ���Ƿ����
                return false;
        return true;
    }
}
/*��֧��
    public DownTriangleMatrix transpose()                  //���ص�ǰ�����ת�þ���

*/