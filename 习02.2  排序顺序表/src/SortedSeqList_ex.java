
public class SortedSeqList_ex 
{
    public static Integer[] random(int n)              //返回产生n个随机数的数组
    {
        Integer[] elements = new Integer[n];
        for (int i=0; i<n; i++)
        	elements[i] = new Integer((int)(Math.random()*100));   //产生随机数
        return elements;
    }
	
    public static void main(String args[])
    {
    	//顺序表
/*        SeqList<String> lista = new SeqList<String>(4);    //执行默认构造方法
        for (int i=5; i>=0; i--)
            lista.insert(i, new String((char)('A'+i)+"")); //扩容
        System.out.println("lista: "+lista.toString());
        SeqList<String> listb = new SeqList<String>(lista);//执行拷贝构造方法
        System.out.println("listb: "+listb.toString());
        lista.set(3, new String((char)(lista.get(3).charAt(0)+32)+""));
        lista.remove(0);
        lista.remove(3);
        lista.remove(10);                                  //没删除
        System.out.println("lista: "+lista.toString());
        System.out.println("listb: "+listb.toString());
*/
        SeqList<Integer> list1 = new SeqList<Integer>(random(5));
        System.out.println("list1: "+list1.toString());
//        SeqList<Integer> list2 = new SeqList<Integer>(list1);    //拷贝构造方法
//      System.out.println("list2: "+list2.toString());
//        list1.set(0, new Integer(list1.get(0).intValue()+100));
//        list1.remove(0);
//        System.out.println("list1: "+list1.toString());
//        System.out.println("list2: "+list2.toString());
           //由于拷贝构造方法实现为数数深拷贝，对象浅拷贝，且因Integer是常量对象，new 引用另一个对象， 
           //上述语句结果只能说明两个顺序表对象分别有各自的数组，各数组元素可引用不同对象，
           //但不能说明引用同一个对象导致的数据修改错误

        //排序顺序表
        SortedSeqList<Integer> list3 = new SortedSeqList<Integer>(random(6));
        System.out.println("list3: "+list3.toString());
//        SortedSeqList<Integer> list4 = new SortedSeqList<Integer>(list3);  //拷贝构造方法
//        System.out.println("list4: "+list4.toString());

        //第9章
        SortedSeqList<Integer> list5 = new SortedSeqList<Integer>(list1);  //拷贝构造方法
        System.out.println("list5: "+list5.toString());
/*        list3.merge(list5);                           //归并两个排序顺序表
        System.out.println("归并，list3: "+list3.toString());
        System.out.println("list5: "+list5.toString());
*/      
        SortedSeqList<Integer> list6 = list3.mergeWith(list5);      //归并两个排序顺序表
        System.out.println("归并，list3: "+list3.toString());
        System.out.println("list5: "+list5.toString());
        System.out.println("list6: "+list6.toString());
   }
}
/*
程序运行结果如下：    
//（1） 浅拷贝
lista: (A, F, B, E, C, D) 
listb: (A, F, B, E, C, D) 
lista: (F, B, e, D) 
Exception in thread "main" java.lang.NullPointerException
	at SeqList.toString(SeqList.java:55)
	at SeqList_ex.main(SeqList_ex.java:30)
 
//（2） 深拷贝，不能说明深拷贝的正确性，因String、Integer是最终变量
lista: (A, F, B, E, C, D) 
listb: (A, F, B, E, C, D) 
lista: (F, B, e, D) 
listb: (A, F, B, E, C, D) 

list1: (19, 3, 79, 147, 29) 
list2: (19, 3, 79, 47, 29) 


list1: (74, 51, 48, 47, 64) 
list3: (40, 47, 67, 74, 94, 99) 
list5: (47, 48, 51, 64, 74) 
归并，list3: (40, 47, 47, 48, 51, 64, 67, 74, 74, 94, 99) 
list5: (47, 48, 51, 64, 74) 

list1: (53, 48, 92, 41, 1) 
list3: (48, 57, 60, 67, 81, 98) 
list5: (1, 41, 48, 53, 92) 
归并，list3: (48, 57, 60, 67, 81, 98) 
list5: (1, 41, 48, 53, 92) 
list6: (1, 41, 48, 48, 53, 57, 60, 67, 81, 92, 98) 
}
*/
