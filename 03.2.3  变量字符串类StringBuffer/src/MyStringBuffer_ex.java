
public class MyStringBuffer_ex
{
    public static void main(String args[])
    {
/*        MyStringBuffer sb1 = new MyStringBuffer("abcde");  //���ַ����������촮����
        MyStringBuffer sb2 = new MyStringBuffer("xyz");
        System.out.println("sb1.insert(2,sb2)=\""+sb1.insert(2,sb2).toString()+"\"");    //���룬�ı�sb1��
        System.out.println("sb1.delete(2,5)=\""+sb1.delete(2,5).toString()+"\"");
        sb1.append("pqrst").append(null);
        System.out.println("\""+sb1.toString()+"\"");
*/
        
    	//Brute-Forceģʽƥ���㷨
//        MyString target=new MyString("abbabaaba"), pattern=new MyString("aba");//ͼ3.10
//        MyString target=new MyString("aabaaa"), pattern=new MyString("aab");   //������
//        MyString target=new MyString("aaaaaa"), pattern=new MyString("aab");     //����
//        System.out.println("\""+target+"\".indexOf_BF(\""+pattern+"\")="+target.indexOf_BF(pattern));
    }
}
/*
sb1.insert(2,sb2)="abxyzcde"
sb1.delete(2,5)="abcde"
"abcdepqrstnull"

//Brute-Forceģʽƥ���㷨
"abbabaaba".indexOf_BF("aba")=3                 //ͼ3.10
count=8

indexOf("aabaaa", "aab")=0                      //������
count=3

indexOf("aaaaab", "aab")=3
count=12

indexOf("aaaaaa", "aab")=-1                      //����
count=12                                         //�Ƚ�m*(n-m+1)�Σ�O(n*m)


 **/