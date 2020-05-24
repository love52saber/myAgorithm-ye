//����8.3�� ͳ���ı��и��ַ��ĳ��ִ�����Ϊ����Huffman����׼����
//����ɢ�б�洢��ָ��һ���ı���ͳ�Ƴ��ĸ��ַ�������ִ�����

public class HashCharWeight
{
    //ͳ��text�и��ַ��ĳ��ִ�����ʹ��ɢ�б���Ϊ����Ԫ�صĴ洢�ṹ���洢ͳ�ƽ��
	public HashCharWeight(String text)
    {
        HashSet<CharCount> set=new HashSet<CharCount>(text.length());//������ɢ�б�
        for (int i=0; i<text.length(); i++)                //����ַ����Ҽ���
        {
            CharCount key = new CharCount(text.charAt(i),1);
            CharCount find = set.search(key);              //���ң�find���ò��ҵ���Ԫ��
            if (find==null)
                set.insert(key);                           //����
            else
                find.add(1);                               //��Ӧ�ַ�������1
        }   
        System.out.println("�ַ�������ִ�����"+set.toString());
    }
 
    public static void main(String args[]) 
    {
//        new HashCharWeight("AAAABBBCDDBBAAA");
//        new HashCharWeight("public class");
        new HashCharWeight("public class CharCount uuii");
    }
}
/*
�������н�����£�
�ַ�������ִ�����((A,7))
((B,5))
((C,1))
((D,2))

�ַ�������ִ�����((l,2))
((a,1))
((b,1))
((c,2))
((p,1))
((s,2))
(( ,1))
((i,1), (u,1))

�ַ�������ִ�����((n,1))
((o,1), (C,2))
((p,1))
((r,1))
((s,2))
((t,1))
((u,2))
((a,2))
(( ,2), (b,1))
((c,2))
((h,1))
((i,1))
((l,2))




 */