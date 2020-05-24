//10.2   ʵ�ֵ�����
//import java.util.Iterator;                       //Java�������ӿ�

//�����б��࣬�̳�AAbstractCollection<T>�࣬Ϊ���Ա��ṩ������ʽ�ı����㷨
public abstract class AbstractLList<T> extends AbstractCCollection<T> 
{
    public boolean equals(Object obj)                      //�Ƚ��������϶����Ƿ����
    {
        if (obj == this)
            return true;
        if (!(obj instanceof AbstractLList))
            return false;
        java.util.Iterator<T> it1 = this.iterator();
        java.util.Iterator<T> it2 = ((AbstractLList<T>)obj).iterator();
        while (it1.hasNext() && it2.hasNext()) 
            if (!(it1.next().equals(it2.next())))          //�Ƚϼ���Ԫ�أ����������ļ�����û��null����
                return false;
        return !it1.hasNext() && !it2.hasNext();           //�����ռ���Ҳ���
    }
}
