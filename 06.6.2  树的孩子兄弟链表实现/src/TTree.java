//���ӿ�

public interface TTree<T>                                  //���ӿ�
{
    boolean isEmpty();                                     //�ж��Ƿ����
    TreeNode<T> getChild(TreeNode<T> p, int i);            //����p���ĵ�i��i��0�������ӽ��
    TreeNode<T> getLastChild(TreeNode<T> p);               //����p�������һ�����ӽ��
    TreeNode<T> getLastSibling(TreeNode<T> p);             //����p�������һ���ֵܽ��
    TreeNode<T> getParent(TreeNode<T> node);               //����node�ĸ�ĸ���

    int count();                                           //�������Ľ�����
    int childCount(TreeNode<T> p);                         //����p���ĺ��ӽ�����
    int height();                                          //�������ĸ߶�
    TreeNode<T> search(T x);                               //���Ҳ�����Ԫ��Ϊx�Ľ��
    void preOrder();                                       //�ȸ����������
    void postOrder();                                      //������������
    void levelOrder();                                     //����α�����

    void insertRoot(T x);                                  //����Ԫ��x��Ϊ�����
    TreeNode<T> insertChild(TreeNode<T> p, T x, int i);    //����xԪ����Ϊp���ĵ�i�����ӽ��
    TreeNode<T> insertLastChild(TreeNode<T> p, T x);       //�������һ�����ӽ��
    TreeNode<T> insertLastSibling(TreeNode<T> p, T x);     //�������һ���ֵܽ��
    void removeChild(TreeNode<T> p, int i);                //ɾ����p���ĵ�i������Ϊ��������
    void removeAll();                                      //ɾ����
}

/*
    public TreeNode<T> getRoot()                 //�������ĸ����
    //�ж�node����Ƿ���parent���ĺ��ӽ��
    public boolean isChild(TreeNode<T> parent, TreeNode<T> node)
*/