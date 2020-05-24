//5.2   特殊矩阵的压缩存储
//5.2.1   三角矩阵、对称矩阵和对角矩阵的压缩存储
//1.  三角矩阵
//【例5.2】  下三角矩阵的线性压缩存储。

public class DownTriangleMatrix                            //线性压缩存储的下三角矩阵类
{
    private int rows;                                      //下三角矩阵行数（阶数）
    private int element[];                                 //存储矩阵元素的一维数组

    public DownTriangleMatrix(int rows)                    //构造rows阶下三角矩阵，元素为0
    {
        if (rows<=0)
            throw new IllegalArgumentException("矩阵行数非正数："+rows); //抛出无效参数异常
        this.rows = rows ;
        this.element = new int[rows*(rows+1)/2];           //rows阶下三角矩阵需要存储rows*(rows+1)/2个元素    
    } 
    //构造rows阶下三角矩阵，初值由mat提供，mat按行主序顺序存储rows阶下三角矩阵元素
    public DownTriangleMatrix(int rows, int mat[])           
    {
        this(rows);
        int n = element.length<=mat.length ? element.length : mat.length;
        for (int i=0; i<n; i++)                            //mat元素不足时补0，忽略多余元素
            this.element[i] = mat[i];
    }

    public int get(int i, int j)                           //返回矩阵第i行第j列元素值，O(1)
    {
        if (i<0 || i>=rows || j<0 || j>=rows) 
            throw new IndexOutOfBoundsException("矩阵元素的行或列序号越界");
        return i<j ? 0 : element[i*(i+1)/2+j];             //按线性压缩存储地址寻找矩阵元素
    }
    public void set(int i, int j, int value)               //设置矩阵第i行第j列元素值为value，O(1)
    {
        if (i<0 || i>=rows || j<0 || j>=rows) 
            throw new IndexOutOfBoundsException("矩阵元素的行或列序号越界");
        this.element[i*(i+1)/2+j] = value;
    }
    public String toString()                     //返回下三角矩阵所有元素的描述字符串，行主序遍历
    {
        String str=" 下三角矩阵"+this.getClass().getName()+"（"+this.rows+"阶）：\n";
        for (int i=0; i<this.rows; i++)
        {
            for (int j=0; j<this.rows; j++)
                str += String.format("%4d", this.get(i,j));
            str += "\n";
        }
        return str;
    }

    //当前下三角矩阵与mat矩阵相加，this+=mat，各对应元素相加，改变当前矩阵
    public void add(DownTriangleMatrix mat)
    {
        if (this.rows!=mat.rows)
            throw new IllegalArgumentException("两个矩阵阶数不同，不能相加");
        for (int i=0; i<this.element.length; i++)
            this.element[i] += mat.element[i];
    }

    //习题5
    public DownTriangleMatrix(DownTriangleMatrix mat)      //深拷贝
    {
        this(mat.rows, mat.element);
    }
    
    //返回当前矩阵与mat相加后的矩阵，=this+mat，各对应元素相加，不改变当前矩阵
    public DownTriangleMatrix plus(DownTriangleMatrix mat)
    {
        DownTriangleMatrix matc=new DownTriangleMatrix(this);//深拷贝
        matc.add(mat);
        return matc;                                       //返回对象引用
    }    
    
    public boolean equals(Object obj)                      //比较两个同阶矩阵是否相等
    {
        if (this==obj)
            return true;
        if (!(obj instanceof DownTriangleMatrix))
            return false;
        DownTriangleMatrix mat=(DownTriangleMatrix)obj;
        if (this.rows!=mat.rows)
            return false;
        for (int i=0; i<this.element.length; i++)
            if (this.element[i]!=mat.element[i])           //比较对应元素是否相等
                return false;
        return true;
    }
}
/*不支持
    public DownTriangleMatrix transpose()                  //返回当前矩阵的转置矩阵

*/