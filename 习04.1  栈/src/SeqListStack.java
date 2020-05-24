//【习4.1】  用顺序表作为栈的成员变量实现栈。

public class SeqListStack<T> implements SStack<T>          //顺序栈类，实现栈接口
{
    private SeqList<T> list;                               //使用顺序表存储栈元素
    
    public SeqListStack(int size)                          //构造容量为size的空栈
    {
        this.list = new SeqList<T>(size); 
    }
    public SeqListStack()                                  //构造空栈
    {
        this.list = new SeqList<T>(); 
    }
    public boolean isEmpty()                               //判断栈是否空，若空返回true
    {
        return list.isEmpty();
    }

    public void push(T x)                                  //元素x入栈，空对象不能入栈，若操作成功返回true，O(1)
    {
        list.append(x);                                    //将元素x插入在顺序表最后，自动扩充容量
    } 
    
    public T pop()                                         //出栈，返回栈顶元素，若栈空返回null，O(1)
    {
        return list.remove(list.length()-1);               //返回栈顶元素并删除栈顶元素，尾删除
    }

    public T get()                                         //取栈顶元素，未出栈，若栈空返回null
    {
        return list.isEmpty() ? null : list.get(list.length()-1);
    }

    public String toString()                               //返回栈中各元素的字符串描述 
    {
        return list.toString();
    }
}
/*
以下操作效率较低：
    public void push(T x)                                  //元素x入栈，O(n)
    {
        list.insert(0, x);                                 //将元素x插入在单链表最前，头插入
    } 
    public T pop()                                         //出栈，返回栈顶元素，若栈空返回null，O(n)
    {
        return list.remove(0);                             //返回栈顶元素并删除栈顶元素
    }
*/