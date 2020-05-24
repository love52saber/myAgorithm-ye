//4.8  能否将栈声明为如下继承线性表？为什么？

public class SeqStack2<T> extends SeqList<T>          //顺序栈类，继承顺序表
{
    public void push(T x)                             //元素x入栈
    {
        this.insert(0, x);
    } 
    public T pop()                                    //出栈
    {
        return this.remove(0);
    }
    public T get()                                    //取栈顶元素
    {
        return this.get(0);
    }
}
/*【答】不行。SeqStack类不能继承顺序表类SeqList，LinkedStack类不能继承单链表类SinglyLinkedList。
 * 因为栈不支持线性表在任意位置的插入、删除操作。栈概念不依赖于线性表而存在。
 */