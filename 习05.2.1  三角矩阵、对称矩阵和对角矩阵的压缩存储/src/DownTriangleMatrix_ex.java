//5.2   ��������ѹ���洢
//5.2.1   ���Ǿ��󡢶Գƾ���ͶԽǾ����ѹ���洢
//1.  ���Ǿ���
//����5.2��  �����Ǿ��������ѹ���洢��

class DownTriangleMatrix_ex
{
    public static void main(String args[])
    {
        int m1[]={1,2,3,4,5,6,7,8,9,10,11,12};
        DownTriangleMatrix mata=new DownTriangleMatrix(4,m1);  //����m1����Ԫ��
        System.out.print("A"+mata.toString());
        int m2[]={1,0,1,0,0,1};
        DownTriangleMatrix matb=new DownTriangleMatrix(4,m2);  //m2Ԫ�ز���ʱ��0
        matb.set(3,3,1);
        System.out.print("B"+matb.toString());
        DownTriangleMatrix matc = mata.plus(matb);
        System.out.print("C=A+B"+mata.plus(matb).toString());
        mata.add(matb);
        System.out.println("A+=B"+mata.toString());
        
        //ϰ��5
        System.out.println("//ϰ��5");
        System.out.println("C.equals(A)��"+matc.equals(mata));
    }
}

/*
�������н�����£�
A �����Ǿ���DownTriangleMatrix��4�ף���
   1   0   0   0
   2   3   0   0
   4   5   6   0
   7   8   9  10
B �����Ǿ���DownTriangleMatrix��4�ף���
   1   0   0   0
   0   1   0   0
   0   0   1   0
   0   0   0   1
C=A+B �����Ǿ���DownTriangleMatrix��4�ף���
   2   0   0   0
   2   4   0   0
   4   5   7   0
   7   8   9  11
A+=B �����Ǿ���DownTriangleMatrix��4�ף���
   2   0   0   0
   2   4   0   0
   4   5   7   0
   7   8   9  11

//ϰ��5
C.equals(A)��true




*/
