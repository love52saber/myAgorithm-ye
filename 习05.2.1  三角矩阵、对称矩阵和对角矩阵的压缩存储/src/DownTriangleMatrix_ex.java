//5.2   特殊矩阵的压缩存储
//5.2.1   三角矩阵、对称矩阵和对角矩阵的压缩存储
//1.  三角矩阵
//【例5.2】  下三角矩阵的线性压缩存储。

class DownTriangleMatrix_ex
{
    public static void main(String args[])
    {
        int m1[]={1,2,3,4,5,6,7,8,9,10,11,12};
        DownTriangleMatrix mata=new DownTriangleMatrix(4,m1);  //忽略m1多余元素
        System.out.print("A"+mata.toString());
        int m2[]={1,0,1,0,0,1};
        DownTriangleMatrix matb=new DownTriangleMatrix(4,m2);  //m2元素不足时补0
        matb.set(3,3,1);
        System.out.print("B"+matb.toString());
        DownTriangleMatrix matc = mata.plus(matb);
        System.out.print("C=A+B"+mata.plus(matb).toString());
        mata.add(matb);
        System.out.println("A+=B"+mata.toString());
        
        //习题5
        System.out.println("//习题5");
        System.out.println("C.equals(A)？"+matc.equals(mata));
    }
}

/*
程序运行结果如下：
A 下三角矩阵DownTriangleMatrix（4阶）：
   1   0   0   0
   2   3   0   0
   4   5   6   0
   7   8   9  10
B 下三角矩阵DownTriangleMatrix（4阶）：
   1   0   0   0
   0   1   0   0
   0   0   1   0
   0   0   0   1
C=A+B 下三角矩阵DownTriangleMatrix（4阶）：
   2   0   0   0
   2   4   0   0
   4   5   7   0
   7   8   9  11
A+=B 下三角矩阵DownTriangleMatrix（4阶）：
   2   0   0   0
   2   4   0   0
   4   5   7   0
   7   8   9  11

//习题5
C.equals(A)？true




*/
