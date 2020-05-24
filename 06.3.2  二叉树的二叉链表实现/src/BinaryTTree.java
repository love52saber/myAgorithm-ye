//�������ӿ�

public interface BinaryTTree<T>                            //�������ӿڣ�������������������
{
    boolean isEmpty();                                     //�ж϶������Ƿ��
    void preOrder();                                       //�ȸ��������������
    void inOrder();                                        //�и��������������
    void postOrder();                                      //����������������
    void levelOrder();                                     //����α���������
    int count();                                           //���ض������Ľ�����
    int height();                                          //���ض������ĸ߶�
    T search(T key);                                       //���Ҳ������״γ��ֵĹؼ���ΪkeyԪ��
//    BinaryNode<T> searchNode(T key);                       //���Ҳ������״γ��ֵĹؼ���ΪkeyԪ�ؽ��
    BinaryNode<T> getParent(BinaryNode<T> node);           //����node�ĸ�ĸ���
    void insertRoot(T x);                                  //����Ԫ��x��Ϊ�����
    BinaryNode<T> insertChild(BinaryNode<T> p, T x, boolean leftChild); //����xԪ����Ϊp������/�Һ���
    void removeChild(BinaryNode<T> p, boolean leftChild);  //ɾ��p�������������
    void removeAll();                                      //ɾ��������
}
//    BinaryNode<T> getRoot();                               //���ض������ĸ����
