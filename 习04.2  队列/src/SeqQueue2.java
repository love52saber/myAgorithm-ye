//4.15  能否将队列声明为继承线性表，入栈调用append(x)方法，出栈调用remove(0)方法？为什么？

public class SeqQueue2<T> extends SeqList<T>               //顺序队列类，继承顺序表
{
    public void enqueue(T x)                               //元素x入队
    {
        this.append(x);
    } 
    public T dequeue()                                     //出队，返回队头元素，若队列空返回null 
    {
        return this.remove(0);
    }
}
//【答】不行。队列不支持中间插入和删除操作。队列概念不依赖于线性表而存在。
