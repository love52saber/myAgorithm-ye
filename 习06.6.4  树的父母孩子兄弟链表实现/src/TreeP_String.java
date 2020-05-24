//6.6.4   树的父母孩子兄弟链表实现
//【例6.8】 以树的横向凹入表示构造树或森林。

public class TreeP_String
{
    //以横向凹入表示构造树或森林，prelist数组存储树或森林的横向凹入表示字符串序列
    //非递归算法，逐个结点添加方式，没有直接调用返回、插入结点方法
    public static TreeP<String> create(String prelist[])
    {
        TreeP<String> tree = new TreeP<String>();          //创建空树
        if (prelist.length==0)
            return tree;                                   //返回空树
        tree.root = new TreePNode<String>(prelist[0]);     //创建根结点
        TreePNode<String> p = tree.root;
        int len=0;                                         //p结点的前缀'\t'个数
        for (int i=1; i<prelist.length; i++)
        {        //创建元素为prelist[i]结点，添加到tree森林的最后一棵树中，结点值去除了所有\t前缀
            int j=0;
            while (j<prelist[i].length() && prelist[i].charAt(j)=='\t')
                j++;                                       //统计prelist[i]串中'\t'前缀个数
            
            String str = prelist[i].substring(j);          //去除prelist[i]串中若干前缀'\t'
            if (j==len+1)                                  //prelist[i]比p.data多一个'\t'前缀
            {
                p.child = new TreePNode<String>(str, p, null, null);//插入作为p的第一个孩子
                p = p.child;
                len++;
                continue;
            }
            while (len > j)                                //prelist[i]比p.data的'\t'少，p向上寻找插入位置
            {
                p=p.parent;                                //p向上一层
                len--;
            }
            p.sibling = new TreePNode<String>(str, p.parent, null, null);//插入作为p结点的兄弟
            p = p.sibling;
        }
        return tree;
    }
    
    public static void main(String[] args)
    {
    	String prelist[]={"中国","\t北京","\t上海","\t江苏","\t\t南京","\t\t\t江宁","\t\t苏州",
            "\t\t无锡","\t\t\t锡山","\t浙江","\t\t杭州","\t\t宁波","\t\t温州","\t广东","\t\t广州",
            "韩国","\t首尔","法国","意大利","美国","\t华盛顿州","\t\t华盛顿","\t纽约州","\t\t纽约"};
        TreeP<String> tree = create(prelist);              //以树的横向凹入表示法构造树或森林
        System.out.print(tree.toString());                 //先根次序遍历树并输出树的横向凹入表示字符串
    }
}
/*
程序运行结果如下：
先根次序遍历树： 
先根次序遍历树： 
 中国
	北京
	上海
	江苏
		南京
			江宁
		苏州
		无锡
			锡山
	浙江
		杭州
		宁波
		温州
	广东
		广州
韩国
	首尔
法国
意大利
美国
	华盛顿州
		华盛顿
	纽约州
		纽约

*/


