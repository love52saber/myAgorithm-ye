//3.3   ����ģʽƥ��
//3.3.1   ���ص�ģʽƥ�䣨Brute-Force���㷨
//����3.4�� java.lang.StringBuffer�ַ������滻��ɾ���Ӵ�������

public class ReplaceStringBuffer
{
    //��target�����׸���patternƥ����Ӵ��滻��replacement�������滻���target�����ı�target��
    public static StringBuffer replaceFirst(StringBuffer target, String pattern, String replacement)
    {
        int i=target.indexOf(pattern);
        if(i!=-1)
        {
            target.delete(i, i+pattern.length());          //ɾ��i��i+pattern.length()-1���Ӵ�
            target.insert(i, replacement);                 //�ڵ�i���ַ�������replacement��
        }
        return target;
    } 
    
    //��target����������patternƥ����Ӵ�ȫ���滻��replacement�������滻���target�����ı�target��
    public static StringBuffer replaceAll(StringBuffer target, String pattern, String replacement)
    {
        int i=target.indexOf(pattern);
        while (i!=-1)
        {
            target.delete(i, i+pattern.length());
            target.insert(i, replacement);
            i=target.indexOf(pattern, i+replacement.length());
//            i=target.indexOf(pattern, i+1);            //��
        }
        return target;
    } 

    //ɾ��target�����׸���patternƥ����Ӵ�������ɾ�����target�����ı�target��
    public static StringBuffer deleteFirst(StringBuffer target, String pattern)
    {
        int i=target.indexOf(pattern);
        if(i!=-1)
            target.delete(i, i+pattern.length()); 
        return target;
    }
        
    public static void main(String args[]) 
    {
        StringBuffer target = new StringBuffer("ababdabcdabcabc"); //��3.3 ����
        String pattern="abc", replacement="xy";
//        StringBuffer target = new StringBuffer("aaaa");    //��3.4 ����
//        String pattern="a", replacement="ab";

        System.out.println("replaceFirst(\""+target+"\", \""+pattern+"\", \""+replacement+"\")="+
                replaceFirst(target, pattern, replacement));
        System.out.println("replaceAll(\""+target+"\", \""+pattern+"\", \""+replacement+"\")="+
                replaceAll(target, pattern, replacement));
        pattern=replacement;
        System.out.println("deleteFirst(\""+target+"\", \""+pattern+"\")="+deleteFirst(target, pattern));
        System.out.println("deleteAll(\""+target+"\", \""+pattern+"\")="+deleteAll(target, pattern));

        System.out.println("removeAll(\""+target+"\", \""+pattern+"\")="+removeAll(target, pattern));
    }
    
    //ϰ��3������3.4��˼���� 
    //ɾ��target����������patternƥ����Ӵ�������ɾ�����target�����ı�target��
    public static StringBuffer deleteAll(StringBuffer target, String pattern)
    {
        int i=target.indexOf(pattern);
        while (i!=-1)
        {
            target.delete(i, i+pattern.length());
            i=target.indexOf(pattern, i);
        }
        return target;
    }
    
    //ɾ��target����������patternƥ����Ӵ�������ɾ�����target�����ı�target��
    //�Ľ�����deleteAll()��������StringBuffer�ַ���ɾ������ƥ���Ӵ����ַ�һ���ƶ���λ
    public static StringBuffer removeAll(StringBuffer target, String pattern)
    {
        int m=target.length(), n=pattern.length();
        int i=target.indexOf(pattern), k=i;
        while (k!=-1)
        {
            int j=k+n;
            k=target.indexOf(pattern, j);
            while (k>0 && j<k || k<0 && j<m)
                target.setCharAt(i++, target.charAt(j++));
        }
        target.setLength(i);                          //����target������Ϊi
        return target;
    }
}

/*
�������н�����£�
//��3.3 ����
replaceFirst("ababdabcdabcabc", "abc", "xy")=ababdxydabcabc
replaceAll("ababdxydabcabc", "abc", "xy")=ababdxydxyxy
deleteFirst("ababdxydxyxy", "xy")=ababddxyxy
deleteAll("ababddxyxy", "xy")=ababdd
        
//��3.4 ����
replaceFirst("aaaa", "a", "ab")=abaaa
replaceAll("abaaa", "a", "ab")=abbababab
deleteFirst("abbababab", "ab")=bababab
deleteAll("bababab", "ab")=b
*/

/*
�������˵��:
1��replaceAll()����
       ���while��������£���pattern="a", replacement="ab"ʱ����ѭ����
    i=target.indexOf(pattern, i);
    ���while��������£���pattern="a", replacement="aab"ʱ����ѭ����
    i=target.indexOf(pattern, i+1);
*/
