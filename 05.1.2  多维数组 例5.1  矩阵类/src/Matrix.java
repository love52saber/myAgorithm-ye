//5.1   ����
//5.1.2   ��ά����
//����5.1��  �����ࡣ

public class Matrix                                       //������
{
    private int element[][];                               //�洢����Ԫ�صĶ�ά����

    public Matrix(int m, int n)                            //����m��n�����
    {
        this.element=new int[m][n];                        //����Ԫ�س�ֵΪ0
                         //��m��nΪ������Java���׳������鳤���쳣NegativeArraySizeException
    }
    public Matrix(int n)                                   //����n��n�㷽��
    {
        this(n,n); 
    }
    public Matrix(int m, int n, int mat[][])               //����m��n������mat�ṩԪ��
    {
        this(m, n);
        for (int i=0; i<mat.length && i<m; i++)            //matԪ�ز���ʱ��0�����Զ���Ԫ��
            for (int j=0; j<mat[i].length && j<n; j++)
               this.element[i][j] = mat[i][j];
    }

    public int get(int i, int j)                           //���ؾ����i�е�j��Ԫ��ֵ��O(1)
    {
        return this.element[i][j];                         //��i��j�±�Խ�磬Java���׳������±�Խ���쳣ArrayIndexOutOfBoundsException
    }
    public void set(int i, int j, int value)               //���þ����i�е�j�е�Ԫ��ֵΪvalue��O(1)
    {
        this.element[i][j]=value;
    }

    public String toString()                               //���ؾ�������Ԫ�ص������ַ��������������
    {
        String str=" ����"+this.getClass().getName()+"��"+this.element.length+"��"+this.element[0].length+"����\n";
        for (int i=0; i<this.element.length; i++)
        {
            for (int j=0; j<this.element[i].length; j++)
                str += String.format("%4d", this.element[i][j]);
            str += "\n";
        }
        return str;
    }

    //��ǰ������mat������ӣ�this+=mat������ӦԪ����ӣ��ı䵱ǰ����
    public void add(Matrix mat)
    {
        if (this.element.length!=mat.element.length || this.element[0].length!=mat.element[0].length)
            throw new IllegalArgumentException("�������������ͬ���������"); //�׳���Ч�����쳣
        for (int i=0; i<this.element.length; i++)
            for (int j=0; j<this.element[i].length; j++)
               this.element[i][j] += mat.element[i][j];
    }
    
    //ϰ��5
    public Matrix(Matrix mat)                              //���
    {
        this(mat.element.length, mat.element[0].length, mat.element);
    }

    //���ص�ǰ������mat��Ӻ�ľ��󣬲��ı䵱ǰ����=this+mat������ӦԪ�����
    public Matrix plus(Matrix mat)
    {
        Matrix matc=new Matrix(this);                      //���
        matc.add(mat);
        return matc;                                       //���ض�������
    }    

    public boolean equals(Object obj)                      //�Ƚ�����ͬ�׾����Ƿ����
    {
        if (this==obj)
            return true;
        if (!(obj instanceof Matrix))
            return false;
        Matrix mat=(Matrix)obj;
        if (this.element.length!=mat.element.length || this.element[0].length!=mat.element[0].length)
            return false;
        for (int i=0; i<this.element.length; i++)
            for (int j=0; j<this.element[i].length; j++)
                if (this.element[i][j]!=mat.element[i][j]) //�Ƚ϶�ӦԪ���Ƿ����
                    return false;
        return true;
    }
    
    public Matrix transpose()                              //���ص�ǰ�����ת�þ���
    {
        Matrix trans = new Matrix(this.element[0].length, this.element.length);//���������
        for (int i=0; i<this.element.length; i++)
            for (int j=0; j<this.element[i].length; j++)
               trans.element[j][i]=this.element[i][j]; 
        return trans;                                      //���ض�������
    }

    public boolean isUpTriangular()                        //�жϵ�ǰ�����Ƿ�Ϊ�����Ǿ���
    {
        if (this.element.length!=this.element[0].length)
            return false;
        for (int i=0; i<this.element.length; i++)
            for (int j=0; j<i; j++)
                if (this.element[i][j]!=0)                 //������Ԫ��ӦΪ0
                    return false;
        return true;
    }

    public boolean isDownTriangular()                      //�жϵ�ǰ�����Ƿ�Ϊ�����Ǿ���
    {
        if (this.element.length!=this.element[0].length)
            return false;
        for (int i=0; i<this.element.length; i++)
            for (int j=i+1; j<this.element.length; j++)
                if (this.element[i][j]!=0)                 //������Ԫ��ӦΪ0
                    return false;
        return true;
    }

    public boolean isSymmetric()                           //�жϵ�ǰ�����Ƿ�Ϊ�Գƾ���
    {
        if (this.element.length!=this.element[0].length)
            return false;
        for (int i=0; i<this.element.length; i++)
            for (int j=0; j<this.element[i].length; j++)
                if (this.element[i][j]!=this.element[j][i])
                    return false;
        return true;
    }    
}

/*
��֧������Ĭ�Ϲ��췽��������ָ��������
    public Matrix()                              //Ĭ�Ϲ��췽��������10��10�վ��󣬳�ֵΪ0
    {
        this(10,10);
    }
int Matrix::saddlePoint()       //���ذ���ֵ
{
}
*/