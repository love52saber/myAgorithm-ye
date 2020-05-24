//3.3   ����ģʽƥ��
//3.3.1   ���ص�ģʽƥ�䣨Brute-Force���㷨
//����3.3�� java.lang.String�ַ����Ĳ��ҡ��滻��ɾ���Ӵ�������

public class DeleteString 
{
    //���ؽ�target�����׸���patternƥ����Ӵ�ɾ������ַ���
    public static String deleteFirst(String target, String pattern)
    {
        int i=target.indexOf(pattern);
        if (i==-1)
            return target;
        return target.substring(0,i)+target.substring(i+pattern.length());
    }
    
    //���ؽ�target����������patternƥ����Ӵ�ɾ������ַ���
    public static String deleteAll(String target, String pattern)
    {
        int i=target.indexOf(pattern);
        while (i!=-1)
        {
            target = target.substring(0,i)+target.substring(i+pattern.length());
            i=target.indexOf(pattern,i);
        }
        return target;
    }

    public static void main(String args[]) 
    {
        //ͼ3.11���滻�Ӵ�
//        String target="ababdabcdabcabc", pattern="abc", replacement="xy";   //��3.3����
        String target="aaaa", pattern="a", replacement="ab";   //��3.4����

        System.out.println("\""+target+"\".indexOf(\""+pattern+"\")="+target.indexOf(pattern));
        System.out.println("\""+target+"\".replaceFirst(\""+pattern+"\", \""+replacement+"\")="+
                target.replaceFirst(pattern,replacement));
        System.out.println("\""+target+"\".replaceAll(\""+pattern+"\", \""+replacement+"\")="+
                target.replaceAll(pattern,replacement));

        //ͼ3.12��ɾ���Ӵ�
        System.out.println("deleteFirst(\""+target+"\", \""+pattern+"\")="+deleteFirst(target, pattern));
        System.out.println("deleteAll(\""+target+"\", \""+pattern+"\")="+deleteAll(target, pattern));
    }
}

/*
�������н�����£�
//��3.3����
"ababdabcdabcabc".indexOf("abc")=5
"ababdabcdabcabc".replaceFirst("abc", "xy")=ababdxydabcabc
"ababdabcdabcabc".replaceAll("abc", "xy")=ababdxydxyxy
deleteFirst("ababdabcdabcabc", "abc")=ababddabcabc
deleteAll("ababdabcdabcabc", "abc")=ababdd

//��3.4����
"aaaa".indexOf("a")=0
"aaaa".replaceFirst("a", "ab")=abaaa
"aaaa".replaceAll("a", "ab")=abababab
deleteFirst("aaaa", "a")=aaa
deleteAll("aaaa", "a")=

*/