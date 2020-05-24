//5.2.1   对称（三角）矩阵的压缩存储
//使用三角形的二维数组存储上或下三角矩阵的非零元素，声明up作为上或下三角矩阵标记

public class TriangleMatrix
{
    boolean up;                                            //上或下三角矩阵
    private int element[][];                               //三角形的二维数组存储矩阵非零元素

    public TriangleMatrix(int rows, boolean up)            //构造rows阶零矩阵，up为true时上三角矩阵
    {
        this.up = up;
        this.element = new int[rows][];                    //若rows<0，Java将抛出负数组长度异常NegativeArraySizeException
        if (up)                                            //上三角矩阵
            for (int i=0; i<this.element.length; i++)
                this.element[i]=new int[rows-i];           //数组元素初值为0
        else                                               //下三角矩阵
            for (int i=0; i<this.element.length; i++)
                this.element[i]=new int[i+1];
    }
    public TriangleMatrix(int rows, boolean up, int mat[][])  //构造rows阶矩阵，由二维数组mat提供元素
    {
        this(rows, up);
        for (int i=0; i<mat.length && i<this.element.length; i++) //mat元素不足时补0，忽略多余元素
            for (int j=0; j<mat[i].length && j<this.element[i].length; j++)
               this.element[i][j] = mat[i][j];
    }
    public TriangleMatrix(TriangleMatrix mat)              //深拷贝
    {
        this(mat.element.length, mat.up, mat.element);
    }

    public int get(int i, int j)                           //返回矩阵第i行第j列元素值，O(1)
    {
        if (up)
   	        return i>j ? 0 : this.element[i][j-i];
        else
   	        return i<j ? 0 : this.element[i][j];           //若i、j下标越界，Java将抛出数组下标越界异常ArrayIndexOutOfBoundsException

    }
    public void set(int i, int j, int value)               //设置矩阵第i行第j列的元素值为value，O(1)
    {
        if (up)
            this.element[i][j-i]=value;
        else
            this.element[i][j]=value;
    }

    public String toString()                               //行主序遍历，访问矩阵全部元素
    {
        String str=" "+this.getClass().getName()+"（"+this.element.length+"阶）：\n";
        for (int i=0; i<this.element.length; i++)
        {
            for (int j=0; j<this.element.length; j++)
                str += String.format("%4d", this.get(i,j));
            str += "\n";
        }
        return str;
    }

    //当前矩阵与mat矩阵相加，this+=mat，各对应元素相加，改变当前矩阵
    public void add(TriangleMatrix mat)
    {
        if (this.element.length!=mat.element.length)
            throw new IllegalArgumentException("两个矩阵阶数不同，不能相加"); //抛出无效参数异常
        if (this.up!=mat.up)
            throw new IllegalArgumentException("该类不支持上三角矩阵与下三角矩阵相加");
        for (int i=0; i<this.element.length; i++)
            for (int j=0; j<this.element[i].length; j++)
               this.element[i][j] += mat.element[i][j];
    }

    //返回当前矩阵与mat相加后的矩阵，不改变当前矩阵，=this+mat，各对应元素相加
    public TriangleMatrix plus(TriangleMatrix mat)
    {
        TriangleMatrix matc=new TriangleMatrix(this);      //深拷贝
        matc.add(mat);
        return matc;                                       //返回对象引用
    }    
    
    public boolean equals(Object obj)                      //比较两个同阶矩阵是否相等
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
                if (this.element[i][j]!=mat.element[i][j]) //比较对应元素是否相等
                    return false;
        return true;
    }
    
    public TriangleMatrix transpose()                      //返回当前矩阵的转置矩阵
    {
        TriangleMatrix trans = new TriangleMatrix(this.element.length, !this.up);//构造零矩阵
        if (up)                                            //上三角矩阵转置为下三角矩阵
            for (int i=0; i<this.element.length; i++)
                for (int j=0; j<this.element[i].length; j++)
                    trans.element[j+i][i]=this.element[i][j]; 
        else                                               //下三角矩阵转置为上三角矩阵
            for (int i=0; i<this.element.length; i++)
                for (int j=0; j<this.element[i].length; j++)
                    trans.element[j][i-j]=this.element[i][j]; 
        return trans;                                      //返回对象引用
    }
}
