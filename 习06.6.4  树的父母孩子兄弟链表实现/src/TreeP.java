//6.6.4   树的父母孩子链表实现
//树类，实现TTree<T>接口，泛型T指定结点的元素类型

public class TreeP<T> //implements TTree<T>       //树类，泛型T指定结点的元素类型
{
    public TreePNode<T> root;                     //根结点，结点结构是树的父母孩子兄弟链表

    public TreeP()                                //构造空树
    {
        this.root=null;
    }
    public boolean isEmpty()                     //判断树是否空
    {
        return this.root==null;
    }
    
    //3. 树的先根遍历算法
    public String toString()                     //先根次序遍历树并返回树的横向凹入表示字符串，算法同树的孩子兄弟链表
    {
        return "先根次序遍历树： \n "+toString(root,"");
    }
    //先根次序遍历以p为根的子树，tab参数指定缩进量，返回子树的横向凹入表示字符串，递归算法
    private String toString(TreePNode<T> p, String tab)
    {
        if (p==null)
            return "";
        return tab+p.data.toString()+"\n" + toString(p.child,tab+"\t") + toString(p.sibling,tab);//递归调用
    }
    
}
/*以下未调试
    //4.返回 结点
    public TreeNode<T> getLastChild(TreeNode<T> p)         //返回p结点的最后一个孩子
    {
        if (p==null || p.child==null)                      //p没有孩子
            return null;
        p = p.child;
        while (p.sibling!=null)                            //沿着兄弟链到达最后一个兄弟结点
            p = p.sibling;
        return p;                                          //返回孩子链的最后一个结点
    }

    public TreeNode<T> getLastSibling(TreeNode<T> p)       //返回p结点的最后一个兄弟
    {
        if (p==null || p.sibling==null)
            return null;
        while (p.sibling!=null)                            //p沿着兄弟链到达最后一个兄弟结点
            p = p.sibling;
        return p;
    }

    
    


    //5.插入结点
    public void insertRoot(T x)                            //插入元素x作为根结点，原根结点作为其孩子结点
    {
        this.root = new TreeNode<T>(x, this.root, null);
    }
    //插入x作为p结点的最后一个兄弟结点，返回插入结点
    public TreeNode<T> insertLastSibling(TreeNode<T> p, T x)
    {
        if (p==null)
            return null;
        while (p.sibling!=null)                            //p沿着兄弟链到达最后一个兄弟结点
            p = p.sibling;
        p.sibling = new TreeNode<T>(x);                    //插入最后一个兄弟
        return p.sibling;
    }    
    //插入x作为p结点的最后一个孩子结点，返回插入结点
    public TreeNode<T> insertLastChild(TreeNode<T> p, T x)
    {
        if (p==null)
            return null;
        if (p.child==null)
        {
            p.child = new TreeNode<T>(x);                  //插入作为p结点的第一个孩子
            return p.child;
        }
        else
            return insertLastSibling(p.child, x);          //插入作为p.child的最后一个兄弟
    }
    
    public void removeAll()                                //删除树的所有结点
    {
        this.root = null;
    }
    
    //【例6.7】  构造一棵城市树或森林。
    //【例6.8】 以树的横向凹入表示构造树或森林。
    
    //7.树的广义表表示
    public String toGenListString()                        //返回树或森林的广义表表示字符串
    {
        return "树的广义表表示："+toGenListString(this.root);
    }
    public String toGenListString(TreeNode<T> p)           //返回以p结点为根的子树的广义表表示
    {
        if (p==null)
            return "";                                     //返回空子树表示
        String str=p.data.toString();
        if (p.child!=null)
            str += "("+ toGenListString(p.child)+ ")";
        if (p.sibling!=null)
            str += ","+ toGenListString(p.sibling);
        return str;
    }
    //【例6.9】 树的广义表表示及构造。
   
    
    //习题6
    //返回 结点
    public TreeNode<T> getRoot()                 //返回树的根结点
    {
        return this.root;
    }
    public TreeNode<T> getChild(TreeNode<T> p, int i)      //返回p结点的第i（i≥0）个孩子结点
    {
        if (p==null || p.child==null || i<=0)
            return null;
        p = p.child;
        for (int j=1;  p!=null && j<i; j++)
            p = p.sibling;
        return p;
    }    
 
    
    public int childCount(TreeNode<T> p)         //返回p结点的孩子结点数
    {
        int i=0;
        if (p!=null)
            for (p=p.child;  p!=null;  p=p.sibling) 
                i++;
        return i;
    }
    
    //判断node结点是否是parent结点的孩子结点
    public boolean isChild(TreeNode<T> parent, TreeNode<T> node)
    {
        if (root==null || parent==null || node==null)
            return false;
        for (TreeNode<T> p=parent.child;  p!=null;  p=p.sibling)
            if (p==node) 
                return true;
        return false;
    }
    
    //返回node结点的父母结点，若空树、未找到或node为根，则返回null
    public TreeNode<T> getParent(TreeNode<T> node)
    {
        if (root==null || node==null || node==root)
            return null; 
        return getParent(root, node);
    }
    //在以p为根的子树中查找并返回node结点的父母结点
    public TreeNode<T> getParent(TreeNode<T> p, TreeNode<T> node)
    {
        if (p==null)
            return null;
        if (isChild(p,node)) 
            return p;
        TreeNode<T> find = getParent(p.child, node);
        if (find==null)
            find = getParent(p.sibling, node);
        return find;
    }
    
    //3. 树的先根和后根次序遍历算法
    public void postOrder()                      //后根次序遍历树
    {
        System.out.print("后根次序遍历树:  ");   
        postOrder(root);
        System.out.println();   
    }
    //后根次序遍历以p为根的子树，递归算法，算法同二叉树的中根次序遍历
    public void postOrder(TreeNode<T> p)
    {
        if (p!=null)
        {
            postOrder(p.child);
            System.out.print(p.data+" ");
            postOrder(p.sibling);
        }
    }
 
    //插入x元素作为p结点的第i个孩子结点，返回插入结点。
    //当i≤0时，插入x作为p结点的第一个孩子结点；当i大于p结点的孩子个数时，插入x作为p结点的最后一个孩子结点。 
    public TreeNode<T> insertChild(TreeNode<T> p, T x, int i)
    {
        if (p==null)
            return null;
        TreeNode<T> q=new TreeNode<T>(x);
        if (p.child==null || i<=0)                         //插入x作为p结点的第一个孩子
        {
            q.sibling = p.child;
            p.child = q;
        }
        else                                               //插入x作为p结点的第i（i≥1）个孩子
        {
            p = p.child;
            for (int j=1;  j<i && p.sibling!=null;  j++)
                p = p.sibling;
            q.sibling = p.sibling;
            p.sibling = q;
        }
        return q;
    }
    
    //插入x元素作为p结点的下一个兄弟结点，返回插入结点??有必要吗??
    public TreeNode<T> insertNextSibling(TreeNode<T> p, T x)
    {
        if (p==null)
            return null;
        TreeNode<T> q = new TreeNode<T>(x, null, p.sibling);
        p.sibling = q;
        return q;
    }
    
    //复制sub子树并插入作为p的第i（i≥0）个子树，返回插入结点。
    //当i≤0时，插入x作为p结点的第一个孩子结点；当i大于p结点的孩子个数时，插入x作为p结点的最后一个孩子结点。 
    public TreeNode<T> insertChild(TreeNode<T> p, Tree<T> sub, int i)
    {
        TreeNode<T> q = insertChild(p, sub.root.data, i);
        q.child = copy(sub.root.child);
        return q; 
    }    
    
    //树的删除操作
    public void removeRoot()                               //删除树
    {
        this.root = null;
    }

    public void removeChild(TreeNode<T> p, int i)          //删除以p的第i（i≥0）个孩子为根的子树
    {
        if (p==null || p.child==null || i<0)
            return;
        if (i==0)
            p.child = p.child.sibling;
        else
        {
            p = p.child;
            for (int j=1;  j<i-1 && p!=null;  j++)
                p = p.sibling;
            p.sibling = p.sibling.sibling;
        }
    }    
    
    //基于遍历的操作，递归算法
    public int height()                                    //返回树的高度
    {
        return height(root);
    }
    public int height(TreeNode<T> p)                       //返回以p结点为根的子树高度，后根次序遍历，递归算法
    {
        if (p!=null)
        {
            int lh = height(p.child)+1; 
            int rh = height(p.sibling); 
            return (lh>=rh) ? lh: rh;  
        }
        return 0;
    }

    //返回元素为x的结点所在的层次，若空树或未查找到x返回-1
    public int getLevel(T x)
    {
        return getLevel(root, 1, x);                       //令根结点的层次为1
    }
    //在以p结点（层次为i）为根的子树中，求x结点所在的层次
    private int getLevel(TreeNode<T> p, int i, T x)
    { 
        if (p==null)                                       //空树或查找不成功
            return -1;
        if (p.data.equals(x)) 
            return i;                                      //查找成功
        int level = getLevel(p.child, i+1, x);             //在子树查找
        if (level==-1)
            level = getLevel(p.sibling, i, x);             //继续在其他兄弟子树中查找
        return level;
    }

    //树的层次遍历
    public void levelOrder()                               //按层次遍历树
    {
        System.out.print("层次遍历树：  ");
        LinkedQueue<TreeNode<T>> que=new LinkedQueue<TreeNode<T>>(); //创建一个空队列
        for (TreeNode<T> p=this.root;  p!=null;  p=que.dequeue())
        {
            System.out.print(p.data+ " ");
            for (p=p.child;  p!=null;  p=p.sibling)        //所有孩子结点入队
                que.enqueue(p); 
        }
        System.out.println();
    }
  
    //以下算法同二叉树
    public void preOrder()                                 //先根次序遍历树，算法同二叉树
    {
        System.out.print("先根次序遍历树:  ");   
        preOrder(root);
        System.out.println();   
    }    
    public void preOrder(TreeNode<T> p)                    //先根次序遍历以p为根的子树，递归算法
    {
        if (p!=null)
        {
            System.out.print(p.data+" ");
            preOrder(p.child);                             //递归调用
            preOrder(p.sibling);
        }
    }

    public int count()                                     //返回树的结点个数，算法同二叉树
    {
        return count(root);
    }
    public int count(TreeNode<T> p)                        //返回以p结点为根的子树的结点个数
    {
        if (p==null)
            return 0;
        return 1+count(p.child)+count(p.sibling);
    }
    
    public TreeNode<T> search(T x)                         //查找值为x的结点，算法同二叉树
    {
        return search(root, x);
    }
    //在以p为根的子树中查找值为x结点，先根次序遍历，返回首次出现的值为x的结点，若未找到返回null
    public TreeNode<T> search(TreeNode<T> p, T x)
    {
        if (p==null || x==null)
            return null;
        if (p.data.equals(x)) 
            return p;                                      //查找成功，返回指定结点
        TreeNode<T> find=search(p.child, x);               //在左子树中查找，递归调用
        if (find==null)                                    //若在左子树中未找到
            find=search(p.sibling, x);                     //则继续在右子树中查找，递归调用
        return find;                                       //返回查找结果
    }
    
    public Tree(Tree<T> bitree)                            //深拷贝，算法同二叉树
    {
        this.root = copy(bitree.root);
    }
    public TreeNode<T> copy(TreeNode<T> p)                 //复制以p根的子树，返回新建子树的根结点
    {
        if (p==null)
            return null;
        TreeNode<T> q = new TreeNode<T>(p.data);
        q.child = copy(p.child);                           //递归调用
        q.sibling = copy(p.sibling);                       //递归调用
        return q;                                          //返回建立子树的根结点
    }

    public boolean equals(Object obj)                      //比较两棵树是否相等，算法同二叉树
    {
        return obj==this || obj instanceof Tree && this.equals(this.root,((Tree<T>)obj).root);
    }
    //判断以p和q结点为根的两棵子树是否相等，递归方法
    private boolean equals(TreeNode<T> p, TreeNode<T> q)
    {
        return p==null && q==null || p!=null && q!=null && p.data.equals(q.data) &&
               equals(p.child, q.child) && equals(p.sibling, q.sibling);
    }

    public void preOrderTraverse()                         //先根次序遍历树的非递归算法，算法同二叉树
    {
        System.out.print("先根次序遍历（非递归）：  ");
        LinkedStack<TreeNode<T>> stack = new LinkedStack<TreeNode<T>>();   //创建一个空栈
        TreeNode<T> p = this.root;
        while (p!=null || !stack.isEmpty())                //p非空或栈非空时
            if (p!=null)
            {
                System.out.print(p.data+" ");              //访问结点
                stack.push(p);                             //p结点入栈
                p=p.child;                                 //进入左子树
            }
            else                                           //p为空且栈非空时
            {
                p=stack.pop();                             //p指向出栈结点
                p=p.sibling;                               //进入右子树
            }
        System.out.println();
    }  
}
        //4.插入结点
    public void insertRoot(T x)                  //插入元素x作为根结点，原根结点作为其孩子结点
    {
        this.root = new TreePNode<T>(x, this.root, null);
    }    

    //插入x元素作为p结点的第i个孩子结点，返回插入结点。
    //当i≤0时，插入x作为p结点的第一个孩子结点；当i大于p结点的孩子个数时，插入x作为p结点的最后一个孩子结点。 
    public TreePNode<T> insertChild(TreePNode<T> p, T x, int i)
    {
        if (p==null)
            return null;
        TreePNode<T> q=new TreePNode<T>(x);
        if (p.child==null || i<=0)                         //插入x作为p结点的第一个孩子
        {
            q.sibling = p.child;
            p.child = q;
        }
        else                                               //插入x作为p结点的第i（i≥1）个孩子
        {
            int j=1;
            p = p.child;
            while (p.sibling!=null && j<i)
            {
                p = p.sibling;
                j++;
            }
            q.sibling = p.sibling;
            p.sibling = q;
        }
        return q;
    }
    
    //插入x元素作为p结点的下一个兄弟结点，返回插入结点
    public TreePNode<T> insertNextSibling(TreePNode<T> p, T x)
    {
        if (p==null)
            return null;
        TreePNode<T> q = new TreePNode<T>(x, null, p.sibling);
        p.sibling = q;
        return q;
    }
    //【例6.7】 构造一棵中国城市树。

    
    
    //习题6
    public void postOrder()                      //后根次序遍历树
    {
        System.out.print("后根次序遍历树:  ");   
        postOrder(root);
        System.out.println();   
    }
    //后根次序遍历以p为根的子树，递归算法，算法同二叉树的中根次序遍历
    public void postOrder(TreePNode<T> p)
    {
        if (p!=null)
        {
            postOrder(p.child);
            System.out.print(p.data+" ");
            postOrder(p.sibling);
        }
    }
 
    public TreePNode<T> getChild(TreePNode<T> p, int i)      //返回p结点的第i（i≥1）个孩子
    {
        if (p==null || p.child==null || i<=0)
            return null;
        p = p.child;
        int j=1;
        while (p!=null && j<i)
        {
            p = p.sibling;
            j++;
        }
        return p;
    }    
    public TreePNode<T> getLastChild(TreePNode<T> p)         //返回p结点的最后一个孩子
    {
        if (p==null || p.child==null)
            return null;
        p = p.child;
        while (p.sibling!=null)
            p = p.sibling;
        return p;
    }

    public TreePNode<T> getLastSibling(TreePNode<T> p)       //返回p结点的最后一个兄弟
    {
        if (p==null || p.sibling==null)
            return null;
        while (p.sibling!=null)
            p = p.sibling;
        return p;
    }
    
    public TreePNode<T> insertLastChild(TreePNode<T> p, T x) //插入x作为p结点的最后一个孩子
    {
        if (p==null)
            return null;
        TreePNode<T> q=new TreePNode<T>(x);
        if (p.child==null)
            p.child = q;
        else
        {
            p = p.child;
            while (p.sibling!=null)
                p = p.sibling;
            p.sibling = q;
        }
        return q;
    }
    
    //插入兄弟结点
    public TreePNode<T> insertLastSibling(TreePNode<T> p, T x)//插入x作为p结点的最后一个兄弟结点
    {
        if (p==null)
            return null;
        while (p.sibling!=null)
            p = p.sibling;
        TreePNode<T> q = new TreePNode<T>(x, null, p.sibling);
        p.sibling = q;
        return q;
    }
    //【例6.7】  构造一棵城市树。

    
    //6.广义表表示
    public String toGenListString()                        //以广义表表示输出树
    {
        return "以广义表表示输出树："+toGenListString(root)+"\n";
    }
    public String toGenListString(TreePNode<T> p)           //以广义表表示输出以p结点为根的子树
    {
        if (p==null)
            return "^"; 
        String str=p.data.toString();
        if (p.child!=null)
            str += "("+ toGenListString(p.child)+ ")";
        if (p.sibling!=null)
            str += ","+ toGenListString(p.sibling);
        return str;
    }
    
       
    //习题6
    //4. 基于遍历的操作
    public int count()                           //返回树的结点个数，算法同二叉树
    {
        return count(root);
    }
    public int count(TreePNode<T> p)              //返回以p结点为根的子树的结点个数
    {
        if (p==null)
            return 0;
        return 1+count(p.child)+count(p.sibling);
    }
    
    public int childCount(TreePNode<T> p)         //返回p结点的孩子结点数
    {
        int i=0;
        if (p!=null)
        {
            p = p.child;
            while (p!=null)
            {
                i++;
                p = p.sibling;
            }
        }
        return i;
    }
   
    public int height()                           //返回树的高度
    {
        return height(root);
    }
    public int height(TreePNode<T> p)            //返回以p结点为根的子树的高度，后根次序遍历
    {
        if (p==null)
            return 0;
        int lh = height(p.child);                 //返回左子树的高度
        int rh = height(p.sibling);                //返回右子树的高度
        return (lh>=rh) ? lh+1 : rh+1;           //当前子树高度为较高子树的高度加1
    }

    //查找，算法同二叉树
    public TreePNode<T> search(T x)             //查找值为x的结点
    {
        return search(root, x);
    }
    //在以p为根的子树中查找值为x结点，先根次序遍历，返回首次出现的值为x的结点，若未找到返回null
    public TreePNode<T> search(TreePNode<T> p, T x)
    {
        if (p==null || x==null)
            return null;
        if (p.data.equals(x)) 
            return p;                            //查找成功，返回指定结点
        TreePNode<T> find=search(p.child, x);    //在左子树中查找，递归调用
        if (find==null)                          //若在左子树中未找到
            find=search(p.sibling, x);             //则继续在右子树中查找，递归调用
        return find;                             //返回查找结果
    }
}
/*

    //返回node结点的父母结点，若空树、未找到或node为根，则返回null
    public TreePNode<T> getParent(TreePNode<T> node)
    {
        if (root==null || node==null || node==root)
            return null; 
        return getParent(root, node);
    }
    //在以p为根的子树中查找并返回node结点的父母结点
    public TreePNode<T> getParent(TreePNode<T> p, TreePNode<T> node)
    {
        if (p==null)
            return null;
        if (p.child==node || p.sibling==node) 
            return p;
        TreePNode<T> find = getParent(p.child, node);
        if (find==null)
            find = getParent(p.sibling, node);
        return find;
    }

    
    //6. 树的插入和删除操作
    //插入元素x作为p结点的孩子，若leftChild为true，插入结点作为左孩子，否则作为右孩子
    //返回插入结点
    public TreePNode<T> insertChild(TreePNode<T> p, T x, boolean leftChild)
    {
        if (p==null || x==null)
            return null;
        if (leftChild)
        {
            p.child=new TreePNode<T>(x,p.child,null);  //插入x结点作为p的左孩子，p原左孩子成为x的左孩子
            return p.child;                            //返回插入结点
        }
        p.sibling=new TreePNode<T>(x,null,p.sibling);    //插入x结点作为p的右孩子，p原右孩子成为x的右孩子
        return p.sibling;
    }    

    public void removeRoot()                     //删除树
    {
        this.root = null;
    }
    //删除p结点的左或右子树，若leftChild为true，删除左子树，否则删除右子树
    public void removeChild(TreePNode<T> p, boolean leftChild)
    {
        if (p!=null)
            if (leftChild)
                p.child = null;
            else
                p.sibling = null;
    }

/*    //7. 树遍历的非递归算法
    public void preOrderTraverse()               //先根次序遍历树的非递归算法
    {
        System.out.print("先根次序遍历（非递归）：  ");
        LinkedStack<TreePNode<T>> stack = new LinkedStack<TreePNode<T>>();   //创建一个空栈
        TreePNode<T> p = this.root;
        while (p!=null || !stack.isEmpty())      //p非空或栈非空时
            if (p!=null)
            {
                System.out.print(p.data+" ");    //访问结点
                stack.push(p);                   //p结点入栈
                p=p.child;                        //进入左子树
            }
            else                                 //p为空且栈非空时
            {
                p=stack.pop();                   //p指向出栈结点
                p=p.sibling;                       //进入右子树
            }
        System.out.println();
    }    

    //8. 树的层次遍历
    public void levelOrder()                     //按层次遍历树
    {
        LinkedQueue<TreePNode<T>> que=new LinkedQueue<TreePNode<T>>(); //创建一个空队列
        TreePNode<T> p=this.root;
        System.out.print("层次遍历树：  ");
        while (p!=null)
        {
            System.out.print(p.data+ " ");
            if(p.child!=null)    
                que.enqueue(p.child);             //p的左孩子结点入队
            if(p.sibling!=null)
                que.enqueue(p.sibling);            //p的右孩子结点入队
            p = que.dequeue();                   //p指向出队结点
        }
        System.out.println();
    }
  
    //9. 深拷贝和比较相等
    public Tree(Tree<T> bitree)      //深拷贝，以已知的bitree构造树
    {
        this.root = copy(bitree.root);
    }

    //复制以p根的子树，返回新建子树的根结点
    public TreePNode<T> copy(TreePNode<T> p)
    {
        if (p==null)
            return null;
        TreePNode<T> q = new TreePNode<T>(p.data);
        q.child = copy(p.child);                   //复制左子树，递归调用
        q.sibling = copy(p.sibling);                 //复制右子树，递归调用
        return q;                                //返回建立子树的根结点
    }

    public boolean equals(Object obj)            //比较两棵树是否相等 ，覆盖Object类的equals(obj)方法
    {
        if (obj == this)
            return true;
        if (obj instanceof Tree)
            return equals(this.root, ((Tree<T>)obj).root);
        return false;
    }
    //判断以p和q结点为根的两棵子树是否相等，递归方法
    private boolean equals(TreePNode<T> p, TreePNode<T> q)
    {
        if(p==null && q==null)
            return true;
        return p!=null && q!=null && p.data.equals(q.data) &&
               equals(p.child, q.child) && equals(p.sibling, q.sibling);
    }


    
    //返回x结点所在的层次，若空树或未查找到x返回-1
    public int getLevel(T x)
    {
        return getLevel(root, 1, x);             //令根结点的层次为1
    }
    //在以p结点（层次为i）为根的子树中，求x结点所在的层次
    private int getLevel(TreePNode<T> p, int i, T x)
    { 
        if (p==null)                                  //空树或查找不成功
            return -1;
        if (p.data.equals(x)) 
            return i;                                 //查找成功
        int level = getLevel(p.child, i+1, x);         //在左子树查找
        if (level==-1)
            level = getLevel(p.sibling, i+1, x);        //继续在右子树中查找
        return level;
    }
}
    
 * */
