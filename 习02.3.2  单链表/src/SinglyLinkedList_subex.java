//【习2.3】 单链表类增加匹配、删除、替换等对子表操作方法。

public class SinglyLinkedList_subex 
{
    public static void main(String args[])
    {
/*        String[] valuea={"A","B","C","D","E","F","G","H","I","J","K"};
        SinglyLinkedList<String> lista = new SinglyLinkedList<String>(valuea);
        int i=3, n=4;
        SinglyLinkedList<String> listb = lista.sub(i,n);   //返回子表
        lista.append(listb);                               //深拷贝添加子表
        lista.insert(i, listb);
        System.out.println("lista: "+lista.toString());
        System.out.println("listb: "+listb.toString());

        String[] valuec={"X","Y","Z"};
        SinglyLinkedList<String> listc = new SinglyLinkedList<String>(valuec);
        lista.replaceAll(listb, listc);                    //全部替换子表
        System.out.println("lista: "+lista.toString());   	
        lista.removeAll(listc);                            //全部删除子表
        System.out.println("lista: "+lista.toString());
        System.out.println("listb: "+listb.toString());
        System.out.println("listc: "+listc.toString());    	
        lista.remove(i,n);                                 //删除子表
        System.out.println("lista: "+lista.toString());
        lista.concat(listb);                               //连接合并，浅拷贝添加子表
        System.out.println("lista: "+lista.toString());
        System.out.println("listb: "+listb.toString());
*/        
        //子表匹配，2011年样卷
        String[] value1={"A","A","B","A","B","B","A","B","A","C"}; //目标
        SinglyLinkedList<String> list1 = new SinglyLinkedList<String>(value1);
        String[] value2={"A","B","A"};                     //模式
        SinglyLinkedList<String> list2 = new SinglyLinkedList<String>(value2);
        System.out.println("\nlist1: "+list1.toString());
        System.out.println("list2: "+list2.toString());

/*        System.out.print("list1.index(list2):  ");
        Node<String> start=list1.head.next;
        while (start!=null)
        {
            start = list1.index(start,list2);              //子表匹配，BF模式匹配算法
            if (start!=null)
            {
                System.out.print(start.data.toString()+"，");
                start=start.next;
            }
        }
        
//   	    list1.replaceAll(list2.sub(0,1), list2);           //全部替换子表
   	    list1.replaceAll(list2, list2.sub(0, -1));           //全部替换子表
        System.out.println("\nlist1: "+list1.toString());    	
        list2.set(0, "X");
        System.out.println("\nlist1: "+list1.toString());    	
        System.out.println("list2: "+list2.toString());
*/
        list1.removeAll(list2);                            //全部删除子表
        System.out.println("list1: "+list1.toString());
        System.out.println("list2: "+list2.toString());
    }
}

/*
程序运行结果如下：    
lista: (A, B, C, D, E, F, G, D, E, F, G, H, I, J, K, D, E, F, G)
listb: (D, E, F, G)
lista: (A, B, C, X, Y, Z, X, Y, Z, H, I, J, K, X, Y, Z)
lista: (A, B, C, H, I, J, K)
listb: (D, E, F, G)
listc: (X, Y, Z)
lista: (A, B, C)
lista: (A, B, C, D, E, F, G)
listb: ()

list1: (A, A, B, A, B, B, A, B, A, C)
list2: (A, B, A)
list1.index(list2):  A，A，
list1: (A, A, B, A, A, B, A, B, A, B, A, A, C)
list1: (A, B, A, C)
list2: (A, B, A)

*/
