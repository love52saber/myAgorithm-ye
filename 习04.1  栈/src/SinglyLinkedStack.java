//【习4.2】  用单链表作为栈的成员变量实现栈。

public class SinglyLinkedStack<T> implements SStack<T>     //链式栈类，实现栈接口
{
    private SinglyLinkedList<T> list;                      //使用单链表存储栈元素，单链表类声明见第2章
    
    public SinglyLinkedStack()                             //构造空栈
    {
        this.list = new SinglyLinkedList<T>(); 
    }
    public boolean isEmpty()                               //判断栈是否空，若空返回true
    {
        return list.isEmpty();
    }

    public void push(T x)                                  //元素x入栈，若操作成功返回true，空对象不能入栈，O(1)
    {
        list.insert(0, x);                                 //将元素x插入在单链表最前，头插入
    } 
    
    public T pop()                                         //出栈，返回栈顶元素，若栈空返回null，O(1)
    {
        return list.remove(0);                             //返回栈顶结点元素并删除栈顶结点
    }

    public T get()                                         //取栈顶元素，未出栈，若栈空返回null
    {
        return list.isEmpty() ? null : list.get(0);
    }

    public String toString()                               //返回栈中各元素的字符串描述 
    {
        return list.toString();
    }
}
