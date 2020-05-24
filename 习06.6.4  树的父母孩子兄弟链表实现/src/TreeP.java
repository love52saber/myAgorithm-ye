//6.6.4   ���ĸ�ĸ��������ʵ��
//���࣬ʵ��TTree<T>�ӿڣ�����Tָ������Ԫ������

public class TreeP<T> //implements TTree<T>       //���࣬����Tָ������Ԫ������
{
    public TreePNode<T> root;                     //����㣬���ṹ�����ĸ�ĸ�����ֵ�����

    public TreeP()                                //�������
    {
        this.root=null;
    }
    public boolean isEmpty()                     //�ж����Ƿ��
    {
        return this.root==null;
    }
    
    //3. �����ȸ������㷨
    public String toString()                     //�ȸ�������������������ĺ������ʾ�ַ������㷨ͬ���ĺ����ֵ�����
    {
        return "�ȸ������������ \n "+toString(root,"");
    }
    //�ȸ����������pΪ����������tab����ָ�������������������ĺ������ʾ�ַ������ݹ��㷨
    private String toString(TreePNode<T> p, String tab)
    {
        if (p==null)
            return "";
        return tab+p.data.toString()+"\n" + toString(p.child,tab+"\t") + toString(p.sibling,tab);//�ݹ����
    }
    
}
/*����δ����
    //4.���� ���
    public TreeNode<T> getLastChild(TreeNode<T> p)         //����p�������һ������
    {
        if (p==null || p.child==null)                      //pû�к���
            return null;
        p = p.child;
        while (p.sibling!=null)                            //�����ֵ����������һ���ֵܽ��
            p = p.sibling;
        return p;                                          //���غ����������һ�����
    }

    public TreeNode<T> getLastSibling(TreeNode<T> p)       //����p�������һ���ֵ�
    {
        if (p==null || p.sibling==null)
            return null;
        while (p.sibling!=null)                            //p�����ֵ����������һ���ֵܽ��
            p = p.sibling;
        return p;
    }

    
    


    //5.������
    public void insertRoot(T x)                            //����Ԫ��x��Ϊ����㣬ԭ�������Ϊ�亢�ӽ��
    {
        this.root = new TreeNode<T>(x, this.root, null);
    }
    //����x��Ϊp�������һ���ֵܽ�㣬���ز�����
    public TreeNode<T> insertLastSibling(TreeNode<T> p, T x)
    {
        if (p==null)
            return null;
        while (p.sibling!=null)                            //p�����ֵ����������һ���ֵܽ��
            p = p.sibling;
        p.sibling = new TreeNode<T>(x);                    //�������һ���ֵ�
        return p.sibling;
    }    
    //����x��Ϊp�������һ�����ӽ�㣬���ز�����
    public TreeNode<T> insertLastChild(TreeNode<T> p, T x)
    {
        if (p==null)
            return null;
        if (p.child==null)
        {
            p.child = new TreeNode<T>(x);                  //������Ϊp���ĵ�һ������
            return p.child;
        }
        else
            return insertLastSibling(p.child, x);          //������Ϊp.child�����һ���ֵ�
    }
    
    public void removeAll()                                //ɾ���������н��
    {
        this.root = null;
    }
    
    //����6.7��  ����һ�ó�������ɭ�֡�
    //����6.8�� �����ĺ������ʾ��������ɭ�֡�
    
    //7.���Ĺ�����ʾ
    public String toGenListString()                        //��������ɭ�ֵĹ�����ʾ�ַ���
    {
        return "���Ĺ�����ʾ��"+toGenListString(this.root);
    }
    public String toGenListString(TreeNode<T> p)           //������p���Ϊ���������Ĺ�����ʾ
    {
        if (p==null)
            return "";                                     //���ؿ�������ʾ
        String str=p.data.toString();
        if (p.child!=null)
            str += "("+ toGenListString(p.child)+ ")";
        if (p.sibling!=null)
            str += ","+ toGenListString(p.sibling);
        return str;
    }
    //����6.9�� ���Ĺ�����ʾ�����졣
   
    
    //ϰ��6
    //���� ���
    public TreeNode<T> getRoot()                 //�������ĸ����
    {
        return this.root;
    }
    public TreeNode<T> getChild(TreeNode<T> p, int i)      //����p���ĵ�i��i��0�������ӽ��
    {
        if (p==null || p.child==null || i<=0)
            return null;
        p = p.child;
        for (int j=1;  p!=null && j<i; j++)
            p = p.sibling;
        return p;
    }    
 
    
    public int childCount(TreeNode<T> p)         //����p���ĺ��ӽ����
    {
        int i=0;
        if (p!=null)
            for (p=p.child;  p!=null;  p=p.sibling) 
                i++;
        return i;
    }
    
    //�ж�node����Ƿ���parent���ĺ��ӽ��
    public boolean isChild(TreeNode<T> parent, TreeNode<T> node)
    {
        if (root==null || parent==null || node==null)
            return false;
        for (TreeNode<T> p=parent.child;  p!=null;  p=p.sibling)
            if (p==node) 
                return true;
        return false;
    }
    
    //����node���ĸ�ĸ��㣬��������δ�ҵ���nodeΪ�����򷵻�null
    public TreeNode<T> getParent(TreeNode<T> node)
    {
        if (root==null || node==null || node==root)
            return null; 
        return getParent(root, node);
    }
    //����pΪ���������в��Ҳ�����node���ĸ�ĸ���
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
    
    //3. �����ȸ��ͺ����������㷨
    public void postOrder()                      //������������
    {
        System.out.print("������������:  ");   
        postOrder(root);
        System.out.println();   
    }
    //������������pΪ�����������ݹ��㷨���㷨ͬ���������и��������
    public void postOrder(TreeNode<T> p)
    {
        if (p!=null)
        {
            postOrder(p.child);
            System.out.print(p.data+" ");
            postOrder(p.sibling);
        }
    }
 
    //����xԪ����Ϊp���ĵ�i�����ӽ�㣬���ز����㡣
    //��i��0ʱ������x��Ϊp���ĵ�һ�����ӽ�㣻��i����p���ĺ��Ӹ���ʱ������x��Ϊp�������һ�����ӽ�㡣 
    public TreeNode<T> insertChild(TreeNode<T> p, T x, int i)
    {
        if (p==null)
            return null;
        TreeNode<T> q=new TreeNode<T>(x);
        if (p.child==null || i<=0)                         //����x��Ϊp���ĵ�һ������
        {
            q.sibling = p.child;
            p.child = q;
        }
        else                                               //����x��Ϊp���ĵ�i��i��1��������
        {
            p = p.child;
            for (int j=1;  j<i && p.sibling!=null;  j++)
                p = p.sibling;
            q.sibling = p.sibling;
            p.sibling = q;
        }
        return q;
    }
    
    //����xԪ����Ϊp������һ���ֵܽ�㣬���ز�����??�б�Ҫ��??
    public TreeNode<T> insertNextSibling(TreeNode<T> p, T x)
    {
        if (p==null)
            return null;
        TreeNode<T> q = new TreeNode<T>(x, null, p.sibling);
        p.sibling = q;
        return q;
    }
    
    //����sub������������Ϊp�ĵ�i��i��0�������������ز����㡣
    //��i��0ʱ������x��Ϊp���ĵ�һ�����ӽ�㣻��i����p���ĺ��Ӹ���ʱ������x��Ϊp�������һ�����ӽ�㡣 
    public TreeNode<T> insertChild(TreeNode<T> p, Tree<T> sub, int i)
    {
        TreeNode<T> q = insertChild(p, sub.root.data, i);
        q.child = copy(sub.root.child);
        return q; 
    }    
    
    //����ɾ������
    public void removeRoot()                               //ɾ����
    {
        this.root = null;
    }

    public void removeChild(TreeNode<T> p, int i)          //ɾ����p�ĵ�i��i��0��������Ϊ��������
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
    
    //���ڱ����Ĳ������ݹ��㷨
    public int height()                                    //�������ĸ߶�
    {
        return height(root);
    }
    public int height(TreeNode<T> p)                       //������p���Ϊ���������߶ȣ��������������ݹ��㷨
    {
        if (p!=null)
        {
            int lh = height(p.child)+1; 
            int rh = height(p.sibling); 
            return (lh>=rh) ? lh: rh;  
        }
        return 0;
    }

    //����Ԫ��Ϊx�Ľ�����ڵĲ�Σ���������δ���ҵ�x����-1
    public int getLevel(T x)
    {
        return getLevel(root, 1, x);                       //������Ĳ��Ϊ1
    }
    //����p��㣨���Ϊi��Ϊ���������У���x������ڵĲ��
    private int getLevel(TreeNode<T> p, int i, T x)
    { 
        if (p==null)                                       //��������Ҳ��ɹ�
            return -1;
        if (p.data.equals(x)) 
            return i;                                      //���ҳɹ�
        int level = getLevel(p.child, i+1, x);             //����������
        if (level==-1)
            level = getLevel(p.sibling, i, x);             //�����������ֵ������в���
        return level;
    }

    //���Ĳ�α���
    public void levelOrder()                               //����α�����
    {
        System.out.print("��α�������  ");
        LinkedQueue<TreeNode<T>> que=new LinkedQueue<TreeNode<T>>(); //����һ���ն���
        for (TreeNode<T> p=this.root;  p!=null;  p=que.dequeue())
        {
            System.out.print(p.data+ " ");
            for (p=p.child;  p!=null;  p=p.sibling)        //���к��ӽ�����
                que.enqueue(p); 
        }
        System.out.println();
    }
  
    //�����㷨ͬ������
    public void preOrder()                                 //�ȸ�������������㷨ͬ������
    {
        System.out.print("�ȸ����������:  ");   
        preOrder(root);
        System.out.println();   
    }    
    public void preOrder(TreeNode<T> p)                    //�ȸ����������pΪ�����������ݹ��㷨
    {
        if (p!=null)
        {
            System.out.print(p.data+" ");
            preOrder(p.child);                             //�ݹ����
            preOrder(p.sibling);
        }
    }

    public int count()                                     //�������Ľ��������㷨ͬ������
    {
        return count(root);
    }
    public int count(TreeNode<T> p)                        //������p���Ϊ���������Ľ�����
    {
        if (p==null)
            return 0;
        return 1+count(p.child)+count(p.sibling);
    }
    
    public TreeNode<T> search(T x)                         //����ֵΪx�Ľ�㣬�㷨ͬ������
    {
        return search(root, x);
    }
    //����pΪ���������в���ֵΪx��㣬�ȸ���������������״γ��ֵ�ֵΪx�Ľ�㣬��δ�ҵ�����null
    public TreeNode<T> search(TreeNode<T> p, T x)
    {
        if (p==null || x==null)
            return null;
        if (p.data.equals(x)) 
            return p;                                      //���ҳɹ�������ָ�����
        TreeNode<T> find=search(p.child, x);               //���������в��ң��ݹ����
        if (find==null)                                    //������������δ�ҵ�
            find=search(p.sibling, x);                     //��������������в��ң��ݹ����
        return find;                                       //���ز��ҽ��
    }
    
    public Tree(Tree<T> bitree)                            //������㷨ͬ������
    {
        this.root = copy(bitree.root);
    }
    public TreeNode<T> copy(TreeNode<T> p)                 //������p���������������½������ĸ����
    {
        if (p==null)
            return null;
        TreeNode<T> q = new TreeNode<T>(p.data);
        q.child = copy(p.child);                           //�ݹ����
        q.sibling = copy(p.sibling);                       //�ݹ����
        return q;                                          //���ؽ��������ĸ����
    }

    public boolean equals(Object obj)                      //�Ƚ��������Ƿ���ȣ��㷨ͬ������
    {
        return obj==this || obj instanceof Tree && this.equals(this.root,((Tree<T>)obj).root);
    }
    //�ж���p��q���Ϊ�������������Ƿ���ȣ��ݹ鷽��
    private boolean equals(TreeNode<T> p, TreeNode<T> q)
    {
        return p==null && q==null || p!=null && q!=null && p.data.equals(q.data) &&
               equals(p.child, q.child) && equals(p.sibling, q.sibling);
    }

    public void preOrderTraverse()                         //�ȸ�����������ķǵݹ��㷨���㷨ͬ������
    {
        System.out.print("�ȸ�����������ǵݹ飩��  ");
        LinkedStack<TreeNode<T>> stack = new LinkedStack<TreeNode<T>>();   //����һ����ջ
        TreeNode<T> p = this.root;
        while (p!=null || !stack.isEmpty())                //p�ǿջ�ջ�ǿ�ʱ
            if (p!=null)
            {
                System.out.print(p.data+" ");              //���ʽ��
                stack.push(p);                             //p�����ջ
                p=p.child;                                 //����������
            }
            else                                           //pΪ����ջ�ǿ�ʱ
            {
                p=stack.pop();                             //pָ���ջ���
                p=p.sibling;                               //����������
            }
        System.out.println();
    }  
}
        //4.������
    public void insertRoot(T x)                  //����Ԫ��x��Ϊ����㣬ԭ�������Ϊ�亢�ӽ��
    {
        this.root = new TreePNode<T>(x, this.root, null);
    }    

    //����xԪ����Ϊp���ĵ�i�����ӽ�㣬���ز����㡣
    //��i��0ʱ������x��Ϊp���ĵ�һ�����ӽ�㣻��i����p���ĺ��Ӹ���ʱ������x��Ϊp�������һ�����ӽ�㡣 
    public TreePNode<T> insertChild(TreePNode<T> p, T x, int i)
    {
        if (p==null)
            return null;
        TreePNode<T> q=new TreePNode<T>(x);
        if (p.child==null || i<=0)                         //����x��Ϊp���ĵ�һ������
        {
            q.sibling = p.child;
            p.child = q;
        }
        else                                               //����x��Ϊp���ĵ�i��i��1��������
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
    
    //����xԪ����Ϊp������һ���ֵܽ�㣬���ز�����
    public TreePNode<T> insertNextSibling(TreePNode<T> p, T x)
    {
        if (p==null)
            return null;
        TreePNode<T> q = new TreePNode<T>(x, null, p.sibling);
        p.sibling = q;
        return q;
    }
    //����6.7�� ����һ���й���������

    
    
    //ϰ��6
    public void postOrder()                      //������������
    {
        System.out.print("������������:  ");   
        postOrder(root);
        System.out.println();   
    }
    //������������pΪ�����������ݹ��㷨���㷨ͬ���������и��������
    public void postOrder(TreePNode<T> p)
    {
        if (p!=null)
        {
            postOrder(p.child);
            System.out.print(p.data+" ");
            postOrder(p.sibling);
        }
    }
 
    public TreePNode<T> getChild(TreePNode<T> p, int i)      //����p���ĵ�i��i��1��������
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
    public TreePNode<T> getLastChild(TreePNode<T> p)         //����p�������һ������
    {
        if (p==null || p.child==null)
            return null;
        p = p.child;
        while (p.sibling!=null)
            p = p.sibling;
        return p;
    }

    public TreePNode<T> getLastSibling(TreePNode<T> p)       //����p�������һ���ֵ�
    {
        if (p==null || p.sibling==null)
            return null;
        while (p.sibling!=null)
            p = p.sibling;
        return p;
    }
    
    public TreePNode<T> insertLastChild(TreePNode<T> p, T x) //����x��Ϊp�������һ������
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
    
    //�����ֵܽ��
    public TreePNode<T> insertLastSibling(TreePNode<T> p, T x)//����x��Ϊp�������һ���ֵܽ��
    {
        if (p==null)
            return null;
        while (p.sibling!=null)
            p = p.sibling;
        TreePNode<T> q = new TreePNode<T>(x, null, p.sibling);
        p.sibling = q;
        return q;
    }
    //����6.7��  ����һ�ó�������

    
    //6.������ʾ
    public String toGenListString()                        //�Թ�����ʾ�����
    {
        return "�Թ�����ʾ�������"+toGenListString(root)+"\n";
    }
    public String toGenListString(TreePNode<T> p)           //�Թ�����ʾ�����p���Ϊ��������
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
    
       
    //ϰ��6
    //4. ���ڱ����Ĳ���
    public int count()                           //�������Ľ��������㷨ͬ������
    {
        return count(root);
    }
    public int count(TreePNode<T> p)              //������p���Ϊ���������Ľ�����
    {
        if (p==null)
            return 0;
        return 1+count(p.child)+count(p.sibling);
    }
    
    public int childCount(TreePNode<T> p)         //����p���ĺ��ӽ����
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
   
    public int height()                           //�������ĸ߶�
    {
        return height(root);
    }
    public int height(TreePNode<T> p)            //������p���Ϊ���������ĸ߶ȣ�����������
    {
        if (p==null)
            return 0;
        int lh = height(p.child);                 //�����������ĸ߶�
        int rh = height(p.sibling);                //�����������ĸ߶�
        return (lh>=rh) ? lh+1 : rh+1;           //��ǰ�����߶�Ϊ�ϸ������ĸ߶ȼ�1
    }

    //���ң��㷨ͬ������
    public TreePNode<T> search(T x)             //����ֵΪx�Ľ��
    {
        return search(root, x);
    }
    //����pΪ���������в���ֵΪx��㣬�ȸ���������������״γ��ֵ�ֵΪx�Ľ�㣬��δ�ҵ�����null
    public TreePNode<T> search(TreePNode<T> p, T x)
    {
        if (p==null || x==null)
            return null;
        if (p.data.equals(x)) 
            return p;                            //���ҳɹ�������ָ�����
        TreePNode<T> find=search(p.child, x);    //���������в��ң��ݹ����
        if (find==null)                          //������������δ�ҵ�
            find=search(p.sibling, x);             //��������������в��ң��ݹ����
        return find;                             //���ز��ҽ��
    }
}
/*

    //����node���ĸ�ĸ��㣬��������δ�ҵ���nodeΪ�����򷵻�null
    public TreePNode<T> getParent(TreePNode<T> node)
    {
        if (root==null || node==null || node==root)
            return null; 
        return getParent(root, node);
    }
    //����pΪ���������в��Ҳ�����node���ĸ�ĸ���
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

    
    //6. ���Ĳ����ɾ������
    //����Ԫ��x��Ϊp���ĺ��ӣ���leftChildΪtrue����������Ϊ���ӣ�������Ϊ�Һ���
    //���ز�����
    public TreePNode<T> insertChild(TreePNode<T> p, T x, boolean leftChild)
    {
        if (p==null || x==null)
            return null;
        if (leftChild)
        {
            p.child=new TreePNode<T>(x,p.child,null);  //����x�����Ϊp�����ӣ�pԭ���ӳ�Ϊx������
            return p.child;                            //���ز�����
        }
        p.sibling=new TreePNode<T>(x,null,p.sibling);    //����x�����Ϊp���Һ��ӣ�pԭ�Һ��ӳ�Ϊx���Һ���
        return p.sibling;
    }    

    public void removeRoot()                     //ɾ����
    {
        this.root = null;
    }
    //ɾ��p�����������������leftChildΪtrue��ɾ��������������ɾ��������
    public void removeChild(TreePNode<T> p, boolean leftChild)
    {
        if (p!=null)
            if (leftChild)
                p.child = null;
            else
                p.sibling = null;
    }

/*    //7. �������ķǵݹ��㷨
    public void preOrderTraverse()               //�ȸ�����������ķǵݹ��㷨
    {
        System.out.print("�ȸ�����������ǵݹ飩��  ");
        LinkedStack<TreePNode<T>> stack = new LinkedStack<TreePNode<T>>();   //����һ����ջ
        TreePNode<T> p = this.root;
        while (p!=null || !stack.isEmpty())      //p�ǿջ�ջ�ǿ�ʱ
            if (p!=null)
            {
                System.out.print(p.data+" ");    //���ʽ��
                stack.push(p);                   //p�����ջ
                p=p.child;                        //����������
            }
            else                                 //pΪ����ջ�ǿ�ʱ
            {
                p=stack.pop();                   //pָ���ջ���
                p=p.sibling;                       //����������
            }
        System.out.println();
    }    

    //8. ���Ĳ�α���
    public void levelOrder()                     //����α�����
    {
        LinkedQueue<TreePNode<T>> que=new LinkedQueue<TreePNode<T>>(); //����һ���ն���
        TreePNode<T> p=this.root;
        System.out.print("��α�������  ");
        while (p!=null)
        {
            System.out.print(p.data+ " ");
            if(p.child!=null)    
                que.enqueue(p.child);             //p�����ӽ�����
            if(p.sibling!=null)
                que.enqueue(p.sibling);            //p���Һ��ӽ�����
            p = que.dequeue();                   //pָ����ӽ��
        }
        System.out.println();
    }
  
    //9. ����ͱȽ����
    public Tree(Tree<T> bitree)      //���������֪��bitree������
    {
        this.root = copy(bitree.root);
    }

    //������p���������������½������ĸ����
    public TreePNode<T> copy(TreePNode<T> p)
    {
        if (p==null)
            return null;
        TreePNode<T> q = new TreePNode<T>(p.data);
        q.child = copy(p.child);                   //�������������ݹ����
        q.sibling = copy(p.sibling);                 //�������������ݹ����
        return q;                                //���ؽ��������ĸ����
    }

    public boolean equals(Object obj)            //�Ƚ��������Ƿ���� ������Object���equals(obj)����
    {
        if (obj == this)
            return true;
        if (obj instanceof Tree)
            return equals(this.root, ((Tree<T>)obj).root);
        return false;
    }
    //�ж���p��q���Ϊ�������������Ƿ���ȣ��ݹ鷽��
    private boolean equals(TreePNode<T> p, TreePNode<T> q)
    {
        if(p==null && q==null)
            return true;
        return p!=null && q!=null && p.data.equals(q.data) &&
               equals(p.child, q.child) && equals(p.sibling, q.sibling);
    }


    
    //����x������ڵĲ�Σ���������δ���ҵ�x����-1
    public int getLevel(T x)
    {
        return getLevel(root, 1, x);             //������Ĳ��Ϊ1
    }
    //����p��㣨���Ϊi��Ϊ���������У���x������ڵĲ��
    private int getLevel(TreePNode<T> p, int i, T x)
    { 
        if (p==null)                                  //��������Ҳ��ɹ�
            return -1;
        if (p.data.equals(x)) 
            return i;                                 //���ҳɹ�
        int level = getLevel(p.child, i+1, x);         //������������
        if (level==-1)
            level = getLevel(p.sibling, i+1, x);        //�������������в���
        return level;
    }
}
    
 * */
