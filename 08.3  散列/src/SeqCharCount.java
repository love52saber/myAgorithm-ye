//8.3   ɢ��
//8.3.4   ��������ַ����ɢ�б�
//����8.3�� ͳ���ı��и��ַ��ĳ��ִ�����Ϊ����Huffman����׼����
//����˳���洢��ָ��һ���ı���ͳ�Ƴ��ĸ��ַ�������ִ�����
public class SeqCharCount 
{
    private SeqList<CharCount> list;             //ʹ��˳���洢ͳ�ƽ��

    public SeqCharCount(String text)
    {
        list = new SeqList<CharCount>();
        for (int i=0; i<text.length(); i++)
        {
        	CharCount key = new CharCount(text.charAt(i),1);        	
            CharCount find = list.search(key);             //���ң�find���ò��ҵ���Ԫ��
            if (find==null)
                list.append(key);                          //β����
            else
                find.add(1);                               //��Ӧ�ַ�������1
        }   
        System.out.println("�ַ�������ִ�����"+list.toString());
    }

	public static void main(String args[]) //throws java.io.IOException
    {
        new SeqCharCount("AAAABBBCDDBBAAA");
        new SeqCharCount("public class");
        new SeqCharCount("public class CharWeight");
    }
}
/*
�������н�����£�
�ַ�������ִ�����((A,7), (B,5), (C,1), (D,2)) 
�ַ�������ִ�����((p,1), (u,1), (b,1), (l,2), (i,1), (c,2), ( ,1), (a,1), (s,2)) 
�ַ�������ִ�����((p,1), (u,1), (b,1), (l,2), (i,2), (c,2), ( ,2), (a,2), (s,2), (C,1), (h,2), (r,1), (W,1), (e,1), (g,1), (t,1)) 
  
 */
