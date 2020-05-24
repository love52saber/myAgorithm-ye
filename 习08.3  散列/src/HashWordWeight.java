
public class HashWordWeight
{
    private HashSet<WordCount> hashset;                    //使用散列表存储统计结果

    public HashWordWeight(String text)     //将从text中统计出的各单词及其出现次数存储在散列表中
    {
        hashset = new HashSet<WordCount>(text.length());   //创建空散列表
        int i=0; 
        while (i<text.length())                            //逐个单词查找计数
        {
            int j=text.indexOf(' ',i);
            if (j==-1)
                j=text.length();
            if (j!=i)
            {            
                WordCount key = new WordCount(text.substring(i,j),1);
                WordCount find = hashset.search(key);      //查找，find引用查找到的元素
                if (find==null)
                    hashset.insert(key);                   //散列表插入
                else
                    find.add(1);                           //对应单词计数加1
            }
            i=j+1;
        }   
        System.out.println("单词及其出现次数："+hashset.toString());
    }
 
    public static void main(String args[]) //throws java.io.IOException
    {
        new HashWordWeight("public  class  CharCount");
    }
}
/*
程序运行结果如下：
单词及其出现次数：((class,1))
((public,1))
((CharCount,1))

 */