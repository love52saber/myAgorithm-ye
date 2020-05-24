//���Ͻӿ�

public interface SSet<T>                         //���Ͻӿڣ�T�Ƿ��Ͳ�����ָ��Ԫ������
{
    boolean isEmpty();                           //�жϼ����Ƿ�Ϊ��
    int count();                                 //���ؼ��ϵ�Ԫ�ظ���
    String toString();                           //���ؼ���������Ԫ�ص������ַ���
    T search(T key);                             //���ң����عؼ���ΪkeyԪ��
    boolean contain(T x);                        //�жϼ����Ƿ����Ԫ��x����Ԫ��x�Ƿ����ڼ���
    void add(T x);                               //����Ԫ��x
    void remove(T x);                            //ɾ���״γ��ֵ�Ԫ��x
    void removeAll();                            //ɾ����������Ԫ��
    
    //���·��������������㣬��������һ������
    boolean equals(SSet<T> s);                   //�Ƚϵ�ǰ�����뼯��s�Ƿ����
    void containAll(SSet<T> s);                  //�жϵ�ǰ�����Ƿ��������s�е�����Ԫ�أ�s�Ƿ��Ӽ�
    void addAll(SSet<T> s);                      //���Ӽ���s�е�����Ԫ�أ����ϲ�
    void removeAll(SSet<T> s);                   //ɾ����ЩҲ�����ڼ���s�е�Ԫ�أ����ϲ�
    void retainAll(SSet<T> s);                   //��������ЩҲ�����ڼ���s�е�Ԫ��
}
//void print();                           	//�������������Ԫ��
