//����8.4�� ���ö�����������Ϊ�洢�ṹ��ͳ���ı��и��ַ��ĳ��ִ�����

public class BSTCharWeight
{
    //ͳ��text�и��ַ��ĳ��ִ�����ʹ�ö�����������Ϊ����Ԫ�صĴ洢�ṹ���洢ͳ�ƽ��
    public BSTCharWeight(String text)
    {
        BinarySortTree<CharCount> set=new BinarySortTree<CharCount>(); //����ն���������
        //�����㷨ͬ��8.3
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
        new BSTCharWeight("public class");
    }
}
/*
�������н�����£�
�ַ�������ִ�����( ,1) (a,1) (b,1) (c,2) (i,1) (l,2) (p,1) (s,2) (u,1) 

 */
