//5.3   �����
//5.3.1   ����������������
//3.  ����������������

//�����ӿ�GGenList���������������������ͣ����Ͳ���T��ʾ����Ԫ�ص���������
public interface GGenList<T>
{
    boolean isEmpty();                                     //�жϹ�����Ƿ��
    int length();                                          //���ع������
    int depth();                                           //���ع�������
    GenListNode<T> insert(int i, T x);                     //����ԭ��x��Ϊ��i��Ԫ��
    GenListNode<T> insert(int i, GenList<T> glist);        //�����ӱ���Ϊ��i��Ԫ��
    void remove(int i);                                    //ɾ����i��Ԫ��
}

//T get(int i);                                //���ص�i��i��0����Ԫ��
//void set(int i, T x);                     //���õ�i��Ԫ��ֵΪx
//T search(T key);                             //���ң������״γ��ֵĹؼ���ΪkeyԪ��
//add??