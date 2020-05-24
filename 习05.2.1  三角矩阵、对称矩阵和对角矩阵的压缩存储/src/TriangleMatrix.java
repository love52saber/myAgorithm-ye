//5.2.1   �Գƣ����ǣ������ѹ���洢
//ʹ�������εĶ�ά����洢�ϻ������Ǿ���ķ���Ԫ�أ�����up��Ϊ�ϻ������Ǿ�����

public class TriangleMatrix
{
    boolean up;                                            //�ϻ������Ǿ���
    private int element[][];                               //�����εĶ�ά����洢�������Ԫ��

    public TriangleMatrix(int rows, boolean up)            //����rows�������upΪtrueʱ�����Ǿ���
    {
        this.up = up;
        this.element = new int[rows][];                    //��rows<0��Java���׳������鳤���쳣NegativeArraySizeException
        if (up)                                            //�����Ǿ���
            for (int i=0; i<this.element.length; i++)
                this.element[i]=new int[rows-i];           //����Ԫ�س�ֵΪ0
        else                                               //�����Ǿ���
            for (int i=0; i<this.element.length; i++)
                this.element[i]=new int[i+1];
    }
    public TriangleMatrix(int rows, boolean up, int mat[][])  //����rows�׾����ɶ�ά����mat�ṩԪ��
    {
        this(rows, up);
        for (int i=0; i<mat.length && i<this.element.length; i++) //matԪ�ز���ʱ��0�����Զ���Ԫ��
            for (int j=0; j<mat[i].length && j<this.element[i].length; j++)
               this.element[i][j] = mat[i][j];
    }
    public TriangleMatrix(TriangleMatrix mat)              //���
    {
        this(mat.element.length, mat.up, mat.element);
    }

    public int get(int i, int j)                           //���ؾ����i�е�j��Ԫ��ֵ��O(1)
    {
        if (up)
   	        return i>j ? 0 : this.element[i][j-i];
        else
   	        return i<j ? 0 : this.element[i][j];           //��i��j�±�Խ�磬Java���׳������±�Խ���쳣ArrayIndexOutOfBoundsException

    }
    public void set(int i, int j, int value)               //���þ����i�е�j�е�Ԫ��ֵΪvalue��O(1)
    {
        if (up)
            this.element[i][j-i]=value;
        else
            this.element[i][j]=value;
    }

    public String toString()                               //��������������ʾ���ȫ��Ԫ��
    {
        String str=" "+this.getClass().getName()+"��"+this.element.length+"�ף���\n";
        for (int i=0; i<this.element.length; i++)
        {
            for (int j=0; j<this.element.length; j++)
                str += String.format("%4d", this.get(i,j));
            str += "\n";
        }
        return str;
    }

    //��ǰ������mat������ӣ�this+=mat������ӦԪ����ӣ��ı䵱ǰ����
    public void add(TriangleMatrix mat)
    {
        if (this.element.length!=mat.element.length)
            throw new IllegalArgumentException("�������������ͬ���������"); //�׳���Ч�����쳣
        if (this.up!=mat.up)
            throw new IllegalArgumentException("���಻֧�������Ǿ����������Ǿ������");
        for (int i=0; i<this.element.length; i++)
            for (int j=0; j<this.element[i].length; j++)
               this.element[i][j] += mat.element[i][j];
    }

    //���ص�ǰ������mat��Ӻ�ľ��󣬲��ı䵱ǰ����=this+mat������ӦԪ�����
    public TriangleMatrix plus(TriangleMatrix mat)
    {
        TriangleMatrix matc=new TriangleMatrix(this);      //���
        matc.add(mat);
        return matc;                                       //���ض�������
    }    
    
    public boolean equals(Object obj)                      //�Ƚ�����ͬ�׾����Ƿ����
    {
        if (this==obj)
            return true;
        if (!(obj instanceof TriangleMatrix))
            return false;
        TriangleMatrix mat=(TriangleMatrix)obj;
        if (this.element.length!=mat.element.length || this.up!=mat.up)
            return false;
        for (int i=0; i<this.element.length; i++)
            for (int j=0; j<this.element[i].length; j++)
                if (this.element[i][j]!=mat.element[i][j]) //�Ƚ϶�ӦԪ���Ƿ����
                    return false;
        return true;
    }
    
    public TriangleMatrix transpose()                      //���ص�ǰ�����ת�þ���
    {
        TriangleMatrix trans = new TriangleMatrix(this.element.length, !this.up);//���������
        if (up)                                            //�����Ǿ���ת��Ϊ�����Ǿ���
            for (int i=0; i<this.element.length; i++)
                for (int j=0; j<this.element[i].length; j++)
                    trans.element[j+i][i]=this.element[i][j]; 
        else                                               //�����Ǿ���ת��Ϊ�����Ǿ���
            for (int i=0; i<this.element.length; i++)
                for (int j=0; j<this.element[i].length; j++)
                    trans.element[j][i-j]=this.element[i][j]; 
        return trans;                                      //���ض�������
    }
}
