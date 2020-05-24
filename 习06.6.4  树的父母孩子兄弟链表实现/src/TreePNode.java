//6.6.4   树的父母孩子兄弟链表实现
//树的父母孩子兄弟链表结点类

public class TreePNode<T>                         //树的父母孩子兄弟链表结点类，泛型T指定结点的元素类型
{
    public T data;                                //数据域，存储数据元素
    public TreePNode<T> parent;                   //指向父母结点的链
    public TreePNode<T> child, sibling;           //链，分别指向孩子、兄弟结点

    //构造结点，参数分别指定元素、父母、孩子和兄弟结点
    public TreePNode(T data, TreePNode<T> parent, TreePNode<T> child, TreePNode<T> sibling)
    {
        this.data = data;
        this.parent = parent;
        this.child = child;
        this.sibling = sibling;
    }
    public TreePNode(T data)                      //构造指定值的叶子结点
    {
        this(data, null, null, null);
    }
    public TreePNode()
    {
        this(null, null, null, null);
    }
    
    //可声明以下方法
    public String toString()
    {
        return this.data.toString();
    }
    public boolean equals(Object obj)            //比较两个结点值是否相等，覆盖Object类的equals(obj)方法
    {
        return obj==this || obj instanceof TreePNode && this.data.equals(((TreePNode<T>)obj).data);
    }    
}
