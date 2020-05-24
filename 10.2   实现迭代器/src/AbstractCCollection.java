//10.2   ʵ�ֵ�����
//import java.util.Iterator;                       //Java�������ӿ�

//���󼯺��࣬ʵ��java.lang.Iterable�ɵ����ӿڣ�Ϊ���м����ṩ������ʽ�ı����㷨
public abstract class AbstractCCollection<T> implements java.lang.Iterable<T> 
//public abstract class AAbstractList<T> implements java.util.Collection<T> 
{
    public abstract java.util.Iterator<T> iterator();      //��õ��������󣬳��󷽷�

    public String toString()                               //���ؼ�������Ԫ�ص��ַ�������
    {
        java.util.Iterator<T> it = this.iterator();        //it��һ������������
        String str="(";
        while (it.hasNext())                               //���к��Ԫ��
        {
            str += it.next().toString();                   //��Ӻ��Ԫ���ַ���
            if (it.hasNext())
                str += ", ";
        } 
        return str+")";
    }

    //ϰ��10
//    boolean contains(Object obj);               	//�жϵ�ǰ�����Ƿ����Ԫ��obj
    public boolean contains(T key)                //�жϼ����Ƿ�����ؼ���ΪkeyԪ�أ�����������true
    {
        if (key!=null)
        {
            java.util.Iterator<T> it = this.iterator();
            while (it.hasNext())
                if (key.equals(it.next()))
                    return true;
        }
        return false;
    }

    public abstract int length();                          //���ؼ���Ԫ�ظ��������󷽷�
//    int size();                               	//���ص�ǰ���ϵ�Ԫ�ظ���

    public Object[] toArray()                              //���ذ�����ǰ����������Ԫ�ص�����
    {
        Object[] temp = new Object[this.length()];
        java.util.Iterator<T> it = this.iterator();        //����������
        int i=0; 
        while (it.hasNext())                               //������Ԫ��
            temp[i++]=it.next();
        return temp;
    }
}
/*
    public abstract boolean isEmpty();                     //�жϼ����Ƿ�գ����󷽷�
    public abstract boolean add(T x);                         	//����Ԫ��x
    boolean remove(Object obj);                 	//ɾ���״γ��ֵ�Ԫ��obj
    void clear();                             	//ɾ����ǰ���ϵ�����Ԫ��
    public <T> T[] toArray(T[] a)             	//���ذ�����ǰ����������Ԫ�ص�����
        //���·��������������㣬��������һ������
    boolean containsAll(Collection<?> c);
                           	//�жϵ�ǰ�����Ƿ��������c������Ԫ�أ����ж�c�Ƿ����Ӽ�
    boolean addAll(Collection<? extends T> c);   	//���Ӽ���c�е�����Ԫ�أ����ϲ�����
    boolean removeAll(Collection<?> c);       //ɾ����ЩҲ�����ڼ���c�е�Ԫ�أ����ϲ�����
    boolean retainAll(Collection<?> c);          	//��������ЩҲ�����ڼ���c�е�Ԫ��

*/
