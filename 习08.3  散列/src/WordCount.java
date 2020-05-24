//8.3   散列
//8.3.4   构造链地址法的散列表
//【习8.4】 统计文本中各单词的出现次数。
//采用散列表存储从指定一段文本中统计出的各单词及其出现次数。

public class WordCount                           //单词及其出现次数
{
    String word;                                 //单词
    int count;                                   //出现次数
    public WordCount(String word, int count)
    {
        this.word = word;
        this.count = count;
    }
    public String toString()                     //返回单词及其出现次数描述字符串，形式为“(字符,出现次数)”
    {
        return "("+this.word+","+this.count+")";
    }
    public void add(int n)                       //出现次数加1
    {
        this.count+=n;
    }
    public int hashCode()                        //返回散列码，覆盖Object类的hashCode()方法
    {
        return (int)this.word.hashCode();        //根据单词决定对象在散列表中的位置
    }
    public boolean equals(Object obj)            //比较两个对象是否相等，覆盖Object类的equals(obj)方法
    {
        return obj==this || obj instanceof CharCount && 
            this.word.equals(((WordCount)obj).word);       //仅比较单词是否相等
    }
}
