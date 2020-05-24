
public class MyString_ex
{
    public static void main(String args[])
    {
        //1.  String������
/*   	    MyString s1 = new MyString();                 //����һ���մ�
        MyString s2 = new MyString("xyz");            //��java.lang.String�ַ����������촮����
        char[] letters={'a','b','c','d'};             //�ַ����飬ֻ��������ʱ��ֵ�����ܸ�ֵΪ"abcd"
        MyString s3 = new MyString(letters);          //���ַ����鹹�촮����
        letters[0]='y';                               //����Ԫ�ظ��ˣ��Դ�ûӰ��
        MyString s4 = new MyString(s3);               //�������췽��
        System.out.println("s1=\""+s1.toString()+"\"");
        System.out.println("s2=\""+s2.toString()+"\"");
        System.out.println("s3=\""+s3.toString()+"\"");
        System.out.println("s4=\""+s4.toString()+"\"");
        MyString s5=s2;                               //�������ø�ֵ       
        System.out.println("\""+s5.toString()+"\"==\""+s2.toString()+"\"? "+(s5==s2));
        System.out.println("\""+s3.toString()+"\"==\""+s4.toString()+"\"? "+(s3==s4));
        System.out.println("\""+s3.toString()+"\".equals(\""+s4.toString()+"\")? "+s3.equals(s4));
        System.out.println("\""+s3.toString()+"\".compareTo(\""+s4.toString()+"\")? "+s3.compareTo(s4));
        System.out.println("\""+s2.toString()+"\".equals(\""+s3.toString()+"\")? "+s2.equals(s3));
        System.out.println("\""+s2.toString()+"\".compareTo(\""+s3.toString()+"\")? "+s2.compareTo(s3));

    	//2.  ���Ӵ�
        MyString s1=new MyString("abcd"), s2=new MyString("xyz");
        System.out.println("s1.concat(s2)=\""+s1.concat(s2).toString()+"\""); //s1.concat(s2)="abcdxyz"

    	//3.  ���Ӵ�
        MyString s=new MyString("abcdefgh");
        System.out.println(s.substring(2,5).toString());                //cde
        
        //3.3.1   ���ص�ģʽƥ�䣨Brute-Force���㷨
        //ͼ3.10
//        MyString target=new MyString("ababdabcd");         //Ŀ�괮
//        MyString pattern=new MyString("abc");              //ģʽ��
//        MyString target=new MyString("aabaaa"), pattern=new MyString("aab");   //��������ͼ3.13(a)
//        MyString target=new MyString("aaaaa"), pattern=new MyString("aab");     //������ƥ�䲻�ɹ���ͼ3.13(b)
        MyString target=new MyString("aaaab"), pattern=new MyString("aab");     //������ƥ��ɹ�
        System.out.println("\""+target+"\".indexOf(\""+pattern+"\")="+target.indexOf(pattern));
        System.out.println("BF.count="+target.count);

        //ͼ3.11���滻�Ӵ�
        MyString target=new MyString("ababdabcdabcabc"); //Ŀ�괮����3.3����
        MyString pattern=new MyString("abc");              //ģʽ��
        MyString replacement=new MyString("xy");           //�滻��
*/
        MyString target=new MyString("aaaa");              //Ŀ�괮����3.4����
        MyString pattern=new MyString("a");                //ģʽ��
        MyString replacement=new MyString("ab");           //�滻��

        System.out.println("\""+target+"\".replaceFirst(\""+pattern+"\", \""+replacement+"\")="+
        		target.replaceFirst(pattern,replacement));
        System.out.println("\""+target+"\".replaceAll(\""+pattern+"\", \""+replacement+"\")="+
        		target.replaceAll(pattern,replacement));
        
/*        //ϰ��3
        System.out.println("\""+s3.toString()+"\".startsWith(\""+s2.toString()+"\")? "+s3.startsWith(s6));
        System.out.println("\""+s3.toString()+"\".endsWith(\""+s2.toString()+"\")? "+s3.endsWith(s2));
        System.out.println("\""+s2.toString()+"\".equalsIgnoreCase(\"XYZ\")? "+
            s2.equalsIgnoreCase(new MyString("XYZ")));
        System.out.println("\""+s4.toString()+"\".compareToIgnoreCase(\"ABCDEF\")? "+
            s4.compareToIgnoreCase(new MyString("ABCDEF")));
*/        		
    }
}
/*
�������н�����£�
s1=""
s2="xyz"
s3="abcd"
s4="abcd"
"xyz"=="xyz"? true
"abcd"=="abcd"? false
"abcd".equals("abcd")? true
"abcd".compareTo("abcd")? 0
"xyz".equals("abcd")? false
"xyz".compareTo("abcd")? 23
"abcdxyz".startsWith("xyz")? true
"abcdxyz".endsWith("xyz")? true
"xyz".equalsIgnoreCase("XYZ")? true
"abcd".compareToIgnoreCase("ABCDEF")? -2

//3.3.1   ���ص�ģʽƥ�䣨Brute-Force���㷨
"ababdabcd".indexOf_BF("abc")=5                  //ͼ3.10
BF.count=12

"aabaaa".indexOf("aab")=0                        //��������ͼ3.13(a)
BF.count=3

"aaaaaa".indexOf("aab")=-1                       //����
BF.count=14                                      //�Ƚ�m*(n-m+1)�Σ�O(n*m)

"aaaaa".indexOf("aab")=-1                        //������ƥ�䲻�ɹ���ͼ3.13(b)
BF.count=11 
"aaaab".indexOf("aab")=2                         //������ƥ��ɹ�
BF.count=9

//ͼ3.11���滻�Ӵ�����3.3����
"ababdabcdabcabc".replaceFirst("abc", "xy")=ababdxydabcabc
"ababdabcdabcabc".replaceAll("abc", "xy")=ababdxydxyxy

//ͼ3.11���滻�Ӵ�����3.4����
"aaaa".replaceFirst("a", "ab")=abaaa
"aaaa".replaceAll("a", "ab")=abababab

 **/