//习4.5 用循环双链表作为队列的成员变量实现队列。

public class DLinkedQueue<T> implements QQueue<T>     //链式队列类，实现队列接口
{
    private CirDoublyLinkedList<T> list;              //使用循环双链表存储队列元素

    public DLinkedQueue()                             //构造空队列
    {
        this.list = new CirDoublyLinkedList<T>(); 
    }
    public boolean isEmpty()                          //判断队列是否空，若空返回true
    {
        return list.isEmpty();
    }

    public void enqueue(T x)                          //元素x入队，空对象不能入队，若操作成功返回true
    {
        list.append(x);                               //在双链表最后插入x元素结点，实际是头插入，O(1)
    } 

    public T dequeue()                                //出队，返回队头元素，若队列空返回null
    {
        return list.remove(0);                        //取得队头元素并删除队头结点，头删除，O(1)
    } 

    public String toString()                          //返回队列中各元素的字符串描述
    {
        return list.toString();
    }
}
