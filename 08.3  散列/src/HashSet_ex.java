//8.3   ɢ��
//8.3.4   ��������ַ����ɢ�б�
//��������ַ����ɢ�б��࣬�������롢ɾ�������ҡ������Ȳ�����

public class HashSet_ex 
{
    public static void main(String args[]) 
    {
        int n=10;
        HashSet<Integer> hashset = new HashSet<Integer>(n);
        System.out.print("����ؼ��֣� ");
        int key;
        Integer x=null;
        for (int i=0; i<n; i++)
        {
            key=(int)(Math.random()*100);             //����n���������Ϊ�ؼ���
            x = new Integer(key);
            hashset.insert(x);                      //��ɢ�б��в����������Ͷ���
            System.out.print(key+" ");
        }
        hashset.insert(x);                            //����ؼ����ظ�Ԫ��
//        hashset.insert(null);                      //����ն����׳��쳣
        
        System.out.print("\nɢ�б�\n"+hashset.toString());
/*        System.out.println("���� "+x+", "+(hashset.contain(x)?"":"��")+"�ɹ�");
        key = 50;
        System.out.println("���� "+key+", "+(hashset.contain(new Integer(key))?"":"��")+"�ɹ�");
        hashset.remove(x);
        hashset.remove(new Integer(key));
        System.out.println("ɾ�� "+x+"�� ɾ�� "+key+"\n");
        System.out.println("ɢ�б�"+hashset.toString());
*/        
    }
}
/*
public final class Integer
{
    public int hashCode()                //����Object���з���
    {
        return value;
    }
} 
 **/
 

/*
�������н�����£�
����ؼ��֣� 26 21 75 96 21 80 84 98 42 23 
ɢ�б�
table[0]= (80)
table[1]= (21, 21)        ??
table[2]= (42)
table[3]= (23)
table[4]= (84)
table[5]= (75)
table[6]= (96, 26)
table[7]= ()
table[8]= (98)
table[9]= ()
���� 23, �ɹ�
���� 50, ���ɹ�
ɾ�� 23�� ɾ�� 50

ɢ�б�table[0]= (80)
table[1]= (21, 21)
table[2]= (42)
table[3]= ()
table[4]= (84)
table[5]= (75)
table[6]= (96, 26)
table[7]= ()
table[8]= (98)
table[9]= ()


*/
