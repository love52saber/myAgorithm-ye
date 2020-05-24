//���Ա�ӿ�LList���������Ա�����������ͣ����Ͳ���T��ʾ����Ԫ�ص���������
//package dataStructure.linear;                  //������ǰ�ļ��е����ӿ���ָ������

public interface LList<T>                        //���Ա�ӿڣ����Ͳ���T��ʾ����Ԫ�ص���������
{
    boolean isEmpty();                           //�ж����Ա��Ƿ��
    int length();                                //�������Ա���
    T get(int i);                                //���ص�i��i��0����Ԫ��
    void set(int i, T x);                        //���õ�i��Ԫ��ֵΪx
    void insert(int i, T x);                     //����x��Ϊ��i��Ԫ��
    void append(T x);                            //�����Ա�������xԪ��
    T remove(int i);                             //ɾ����i��Ԫ�ز����ر�ɾ������
    void removeAll();                            //ɾ�����Ա�����Ԫ��
    T search(T key);                             //���ң������״γ��ֵĹؼ���ΪkeyԪ��
  //boolean contain(T x);                        //�жϼ����Ƿ����Ԫ��x����Ԫ��x�Ƿ����ڼ���
}
//String toString();                           //������ʾ���Ա�����Ԫ��ֵ��Ӧ���ַ���
//boolean equals(Object obj);                  //�Ƚ��������Ա��Ƿ����
//int count();                                 //���ؼ��ϵ�Ԫ�ظ���

/*Ҳ�ɼ̳�SSet<T>���������·�����ʹ��i��Ϊ����ָ��������ţ�λ�ã������Ա�������ص�
public interface LList<T> extends SSet<T>
{
    T get(int i);                                //���ص�i��i��0����Ԫ��
    void set(int i, T x);                        //���õ�i��Ԫ��ֵΪx
    void insert(int i, T x);                     //����x��Ϊ��i��Ԫ��
    T remove(int i);                             //ɾ����i��Ԫ�ز����ر�ɾ������
}*/
