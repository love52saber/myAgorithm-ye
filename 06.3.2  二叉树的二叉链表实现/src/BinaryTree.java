//�������࣬ʵ��BinaryTTree<T>�ӿڣ�����Tָ������Ԫ������
public class BinaryTree<T> implements BinaryTTree<T>
{
    public BinaryNode<T> root;                   //����㣬���ṹΪ��������

    public BinaryTree()                          //����ն�����
    {
        this.root=null;
    }
    public boolean isEmpty()                     //�ж϶������Ƿ��
    {
        return this.root==null;
    }

    //3. ���������ȸ����и��ͺ����������㷨
    public void preOrder()                       //�ȸ��������������
    {
        System.out.print("�ȸ����������������  ");
        preOrder(root);                          //�����ȸ���������������ĵݹ鷽��
        System.out.println();
    }    
    public void preOrder(BinaryNode<T> p)        //�ȸ����������p���Ϊ�����Ӷ��������ݹ鷽��
    {
        if (p!=null)                             //������������
        {
            System.out.print(p.data.toString()+" ");  //���ʵ�ǰ���
            preOrder(p.left);                    //���ȸ����������ǰ�������������ݹ����
            preOrder(p.right);                   //���ȸ����������ǰ�������������ݹ����
        }
    }
    public String toString()                     //�����ȸ�����������������н��������ַ���
    {
        return toString(root);
    }
    private String toString(BinaryNode<T> p)     //�����ȸ����������pΪ�������������ַ������ݹ��㷨
    {
        if (p==null)
            return "";
        return p.data.toString()+" " + toString(p.left) + toString(p.right);//�ݹ����
    }

    public void inOrder()                        //�и��������������
    {
        System.out.print("�и����������������  ");
        inOrder(root);
        System.out.println();
    }    
    public void inOrder(BinaryNode<T> p)         //�и����������p���Ϊ�����Ӷ��������ݹ鷽��
    {
        if (p!=null)
        {
            inOrder(p.left);                     //�и�����������������ݹ����
            System.out.print(p.data.toString()+" ");
            inOrder(p.right);                    //�и�����������������ݹ����
        }
    }

    public void postOrder()                      //����������������
    {
        System.out.print("������������������  ");
        postOrder(root);
        System.out.println();
    }
    public void postOrder(BinaryNode<T> p)       //������������p���Ϊ�����Ӷ��������ݹ鷽��
    {
        if (p!=null)
        {
            postOrder(p.left);
            postOrder(p.right);
            System.out.print(p.data.toString()+" ");
        }
    }
    //����6.1��  ���첢������������

    //4. ���ڱ����Ĳ���
    public int count()                           //���ض������Ľ�����
    {
        return count(root);
    }
    public int count(BinaryNode<T> p)            //������p���Ϊ���������Ľ�����
    {
        if (p==null)
            return 0;
        return 1+count(p.left)+count(p.right);
    }

    public int height()                           //���ض������ĸ߶�
    {
        return height(root);
    }
    public int height(BinaryNode<T> p)            //������p���Ϊ���������߶ȣ�����������
    {
        if (p==null)
            return 0;
        int lh = height(p.left);                 //�����������ĸ߶�
        int rh = height(p.right);                //�����������ĸ߶�
        return (lh>=rh) ? lh+1 : rh+1;           //��ǰ�����߶�Ϊ�ϸ������ĸ߶ȼ�1
    }

    public T search(T key)                           //���Ҳ������״γ��ֵĹؼ���ΪkeyԪ��
    {
        return searchNode(root, key).data;
    }
    public BinaryNode<T> searchNode(T key)           //���Ҳ������״γ��ֵĹؼ���ΪkeyԪ�ؽ��
    {
        return searchNode(root, key);
    }
    //����pΪ���������в��Ҳ������״γ��ֵĹؼ���ΪkeyԪ�ؽ�㣬��δ�ҵ�����null���ȸ��������
    public BinaryNode<T> searchNode(BinaryNode<T> p, T key)
    {
        if (p==null || key==null)
            return null;
        if (p.data.equals(key)) 
            return p;                            //���ҳɹ��������ҵ����
        BinaryNode<T> find=searchNode(p.left, key);  //���������в��ң��ݹ����
        if (find==null)                          //������������δ�ҵ�
            find=searchNode(p.right, key);           //��������������в��ң��ݹ����
        return find;                             //���ز��ҽ��
    }

    //����node���ĸ�ĸ��㣬��������δ�ҵ���nodeΪ�����򷵻�null
    public BinaryNode<T> getParent(BinaryNode<T> node)
    {
        if (root==null || node==null || node==root)
            return null; 
        return getParent(root, node);
    }
    //����pΪ���������в��Ҳ�����node���ĸ�ĸ���
    public BinaryNode<T> getParent(BinaryNode<T> p, BinaryNode<T> node)
    {
        if (p==null)
            return null;
        if (p.left==node || p.right==node) 
            return p;
        BinaryNode<T> find = getParent(p.left, node);
        if (find==null)
            find = getParent(p.right, node);
        return find;
    }

    //5. ���������
    public BinaryTree(T[] prelist, T[] inlist)        //���ȸ����и����й��������
    {
        this.root = create(prelist, inlist, 0, 0, prelist.length);
    }
    //���ȸ����и����д���һ�����������������ֵ��prelist[preStart]��nָ�������г��ȣ�
    //���������������ĸ����
    private BinaryNode<T> create(T[] prelist, T[] inlist, int preStart, int inStart, int n)
    {
        System.out.print("prelist:");
        print(prelist, preStart, n);
        System.out.print("��inlist:");
        print(inlist, inStart, n);
        System.out.println();
        
        if (n<=0)
            return null;
        T elem=prelist[preStart];                          //�����ֵ
        BinaryNode<T> p=new BinaryNode<T>(elem);           //����Ҷ�ӽ��
        int i=0;
        while (i<n && !elem.equals(inlist[inStart+i]))     //���и������в��Ҹ�ֵ����λ��
            i++;
        p.left = create(prelist, inlist, preStart+1, inStart, i);             //����������
        p.right = create(prelist, inlist, preStart+i+1, inStart+i+1, n-1-i);  //����������
        return p;
    }
    private void print(T[] table, int start, int n)
    {
        for (int i=0; i<n; i++)
    	    System.out.print(table[start+i]);
    }
       
    public BinaryTree(T[] prelist)                    //�Ա������������ȸ����й��������
    {
        this.root = create(prelist);
    }
    //�Ա������������ȸ����й���һ���Ӷ������������ĸ�ֵ��prelist[i]�����������������ĸ����
    private int i=0;
    private BinaryNode<T> create(T[] prelist)
    {
        BinaryNode<T> p = null;
        if (i<prelist.length)
        {
            T elem=prelist[i];
            i++;
            if (elem!=null)                           //����elem!="^"����ΪT��һ����String
            {
                p = new BinaryNode<T>(elem);          //����Ҷ�ӽ��
                p.left = create(prelist);             //����p��������
                p.right = create(prelist);            //����p��������
            }
        }
        return p;
    }
    //����6.2��  �����������ָ�������������Ƚ�㡣

    public String toGenListString()                        //���ض������Ĺ�����ʾ�ַ���
    {
        return "�������Ĺ�����ʾ��"+toGenListString(this.root)+"\n";
    }
    //������p���Ϊ�����Ӷ������Ĺ�����ʾ�ַ������ݹ鷽��
    public String toGenListString(BinaryNode<T> p)
    {
        if (p==null)
            return "^";                                    //���ؿ�������ʾ
        String str=p.data.toString();
        if (p.left!=null || p.right!=null)                 //��Ҷ��㣬������
            str += "("+toGenListString(p.left)+","+toGenListString(p.right)+")";//�ݹ����
        return str;
    }
    //����6.3�� �������Ĺ�����ʾ��
    
    //6. �������Ĳ����ɾ������

    //����Ԫ��x��Ϊ����㣬ԭ�������Ϊ������
    public void insertRoot(T x)
    {
        this.root = new BinaryNode<T>(x, this.root, null);
    }
    //����Ԫ��x��Ϊp���ĺ��ӣ���leftChildΪtrue����������Ϊ���ӣ�������Ϊ�Һ���
    //���ز����㡣��p==null�����׳��ն����쳣
    public BinaryNode<T> insertChild(BinaryNode<T> p, T x, boolean leftChild)
    {
        if (x==null)
            return null;
        if (leftChild)
        {
            p.left=new BinaryNode<T>(x,p.left,null);  //����x�����Ϊp�����ӣ�pԭ���ӳ�Ϊx������
            return p.left;                            //���ز�����
        }
        p.right=new BinaryNode<T>(x,null,p.right);    //����x�����Ϊp���Һ��ӣ�pԭ�Һ��ӳ�Ϊx���Һ���
        return p.right;
    }    

    //ɾ��p�����������������leftChildΪtrue��ɾ��������������ɾ��������
    //��p==null�����׳��ն����쳣
    public void removeChild(BinaryNode<T> p, boolean leftChild)
    {
        if (leftChild)
            p.left = null;
        else p.right = null;
    }
    public void removeAll()                     //ɾ�������������н��
    {
        this.root = null;
    }

    //7. �����������ķǵݹ��㷨
    public void preOrderTraverse()               //�ȸ���������������ķǵݹ��㷨
    {
        System.out.print("�ȸ�����������ǵݹ飩��  ");
        LinkedStack<BinaryNode<T>> stack = new LinkedStack<BinaryNode<T>>();   //����һ����ջ
        BinaryNode<T> p = this.root;
        while (p!=null || !stack.isEmpty())      //p�ǿջ�ջ�ǿ�ʱ
            if (p!=null)
            {
                System.out.print(p.data+" ");    //���ʽ��
                stack.push(p);                   //p�����ջ
                p=p.left;                        //����������
            }
            else                                 //pΪ����ջ�ǿ�ʱ
            {
                p=stack.pop();                   //pָ���ջ���
                p=p.right;                       //����������
            }
        System.out.println();
    }    

    public void inOrderTraverse()                          //�и���������������ķǵݹ��㷨
    {
        System.out.print("�и�����������ǵݹ飩��  ");
        LinkedStack<BinaryNode<T>> stack = new LinkedStack<BinaryNode<T>>();   //����һ����ջ
        BinaryNode<T> p = this.root;
        while (p!=null || !stack.isEmpty())                //p�ǿջ�ջ�ǿ�ʱ
            if (p!=null)
            {
                stack.push(p);                             //p�����ջ
                p=p.left;                                  //����������
            }
            else                                           //pΪ����ջ�ǿ�ʱ
            {
                p=stack.pop();                             //pָ���ջ���
                System.out.print(p.data+" ");              //���ʽ��
                p=p.right;                                 //����������
            }
        System.out.println();
    }    

    //8. �������Ĳ�α���
    public void levelOrder()                     //����α���������
    {
        System.out.print("��α�����������  ");
        SeqQueue<BinaryNode<T>> que=new SeqQueue<BinaryNode<T>>(); //����һ���ն���
//        LinkedQueue<BinaryNode<T>> que=new LinkedQueue<BinaryNode<T>>(); //����һ���ն���
        BinaryNode<T> p=this.root;
        while (p!=null)
        {
            System.out.print(p.data+ " ");       //���ʵ�ǰ���
            if (p.left!=null)    
                que.enqueue(p.left);             //p�����ӽ�����
            if (p.right!=null)
                que.enqueue(p.right);            //p���Һ��ӽ�����
            p = que.dequeue();                   //pָ����ӽ�㣬�����пշ���null
        }
        System.out.println();
    }   

    //ϰ��6
    public void leaf()                           //�������Ҷ�ӽ��
    {
        leaf(root);
    }
    //�����p���Ϊ��������������Ҷ�ӽ�㣬�ȸ���������㷨��3�ֱ���������һ��
    private void leaf(BinaryNode<T> p)
    {
        if(p!=null)
        {
            if (p.left==null && p.right==null)   //p.isLeaf()
                System.out.print(p.data.toString()+" ");
            leaf(p.left);
            leaf(p.right);
        }
    }
    
    public int countLeaf()                       //���ض�������Ҷ�ӽ����
    {
        return countLeaf(root);
    }
    private int countLeaf(BinaryNode<T> p)       //������p���Ϊ����������Ҷ�ӽ�����
    {
        if (p==null)
            return 0;
        if (p.left==null && p.right==null) 
            return 1;
        return countLeaf(p.left)+countLeaf(p.right);
    }
    
    public void replace(T x, T y)                //���״γ��ֵ�ֵΪx�Ľ��ֵ�滻Ϊy
    {
        BinaryNode<T> find = searchNode(x);
        if (find!=null)
            find.data = y;
    }
    public void replaceAll(T x, T y)                       //��ֵΪx�Ľ��ֵȫ���滻Ϊy
    {
        if (x!=null && y!=null)
    	    replaceAll(root, x, y);
    }
    private void replaceAll(BinaryNode<T> p, T x, T y)     //����pΪ����������ʵ��ȫ���滻
    {
        if (p!=null)
        {
            if(p.data.equals(x)) 
                p.data = y;
            replaceAll(p.left, x, y);
            replaceAll(p.right, x, y);
        }
    }
    
    public void postOrderTraverse()                        //�����������������ķǵݹ��㷨
    {
        System.out.print("�������������ǵݹ飩��  ");
        LinkedStack<BinaryNode<T>> stack = new LinkedStack<BinaryNode<T>>();
        BinaryNode<T> p=this.root, front=null;
        while (p!=null || !stack.isEmpty())                //p�ǿջ�ջ�ǿ�ʱ
            if (p!=null)
            {
                stack.push(p);                             //p�����ջ
                p=p.left;                                  //����������
            }
            else                                           //pΪ����ջ�ǿ�ʱ
            {
                p=stack.get();                             //������������p��㣬p��㲻��ջ
                if (p.right!=null && p.right!=front)       //p���Һ��ӣ����Һ���û�����ʹ�
                {
                    p = p.right;                           //����������
                    stack.push(p);
                    p=p.left;                              //������
                }
                else
                {
                    p=stack.pop();                         //������������p��㣬p����ջ
                    System.out.println(p.data+"���������Ƚ���ǣ�"+stack.toString());
                    front = p;                             //front��p�ں�����������µ�ǰ�����
                    p=null; 
                }
            }
        System.out.println();
    }    

    //����x������ڵĲ�Σ���������δ���ҵ�x����-1
    public int getLevel(T x)
    {
        return getLevel(root, 1, x);                  //������Ĳ��Ϊ1
    }
    //����p��㣨���Ϊi��Ϊ���������У���x������ڵĲ��
    private int getLevel(BinaryNode<T> p, int i, T x)
    { 
        if (p==null)                                  //��������Ҳ��ɹ�
            return -1;
        if (p.data.equals(x)) 
            return i;                                 //���ҳɹ�
        int level = getLevel(p.left, i+1, x);         //������������
        if (level==-1)
            level = getLevel(p.right, i+1, x);        //�������������в���
        return level;
    }

    public boolean equals(Object obj)             //�Ƚ����ö������Ƿ���� ������Object���equals(obj)����
    {
        return obj==this || obj instanceof BinaryTree && equals(this.root, ((BinaryTree<T>)obj).root);
    }
    //�ж���p��q���Ϊ�������������Ƿ���ȣ��ݹ鷽��
    private boolean equals(BinaryNode<T> p, BinaryNode<T> q)
    {
        return p==null && q==null || p!=null && q!=null && p.data.equals(q.data) &&
               equals(p.left, q.left) && equals(p.right, q.right);
    }

    public BinaryTree(BinaryTree<T> bitree)      //���������֪��bitree���������
    {
        this.root = copy(bitree.root);
    }

    //������p�����Ӷ������������½��Ӷ������ĸ����
    private BinaryNode<T> copy(BinaryNode<T> p)
    {
        if (p==null)
            return null;
        BinaryNode<T> q = new BinaryNode<T>(p.data);
        q.left = copy(p.left);                   //�������������ݹ����
        q.right = copy(p.right);                 //�������������ݹ����
        return q;                                //���ؽ��������ĸ����
    }
    
boolean isCompleteBinaryTree()               //�ж��Ƿ���ȫ������
{
   if (this.root==null)
       return true;
//	    SeqQueue<BinaryNode<T>> que = new SeqQueue<BinaryNode<T>>(); //�����ն���
    LinkedQueue<BinaryNode<T>> que = new LinkedQueue<BinaryNode<T>>();
    que.enqueue(root);                           //��������
    BinaryNode<T> p=null;
    while (!que.isEmpty())
    {
        p = que.dequeue();                       //pָ����ӽ��
        if (p.left!=null )                       //p�ķǿպ��ӽ�����
        {
            que.enqueue(p.left);
            if (p.right!=null)
                que.enqueue(p.right);
            else break;                          //���ֿ�����������������Ƿ���Ҷ�ӽ��
        }
        else
            if (p.right!=null)
                return false;                    //p���������ն����������գ�ȷ������
            else break;                           //p��Ҷ�ӣ�����������Ƿ���Ҷ�ӽ��
    }
    while (!que.isEmpty())                       //���������Ƿ���Ҷ�ӽ��
    {
        p = que.dequeue();
        if (p.left!=null || p.right!=null)       //���ַ�Ҷ�ӣ�ȷ������
            return false;
    }
    return true;
}
}
