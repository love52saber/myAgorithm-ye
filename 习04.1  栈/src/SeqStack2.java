//4.8  �ܷ�ջ����Ϊ���¼̳����Ա�Ϊʲô��

public class SeqStack2<T> extends SeqList<T>          //˳��ջ�࣬�̳�˳���
{
    public void push(T x)                             //Ԫ��x��ջ
    {
        this.insert(0, x);
    } 
    public T pop()                                    //��ջ
    {
        return this.remove(0);
    }
    public T get()                                    //ȡջ��Ԫ��
    {
        return this.get(0);
    }
}
/*���𡿲��С�SeqStack�಻�ܼ̳�˳�����SeqList��LinkedStack�಻�ܼ̳е�������SinglyLinkedList��
 * ��Ϊջ��֧�����Ա�������λ�õĲ��롢ɾ��������ջ������������Ա�����ڡ�
 */