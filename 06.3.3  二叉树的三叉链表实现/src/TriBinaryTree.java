//��������洢�Ķ������࣬ʵ��BinaryTTree<T>�ӿڣ�����Tָ������Ԫ������
public class TriBinaryTree<T> //implements BinaryTTree<T,TriNode> 
{
    public TriNode<T> root;                                //�����

    public TriBinaryTree()                                 //����ն�����
    {
        this.root=null;
    }

    public boolean isEmpty()                               //�ж϶������Ƿ��
    {
        return this.root==null;
    }
    
    //(1) ������������㷨�иĶ�
    public TriBinaryTree(T[] prelist)                      //�Ա������������ȸ����й��������
    {
        this.root = create(prelist,1,null);                //������Ĳ��Ϊ1
    }
    //�Ա������������ȸ����й���һ���Ӷ������������ĸ�ֵ��prelist[i]�����Ϊlevel��
    //parentָ��ĸ��㣬���������������ĸ����
    private int i=0;
    private TriNode<T> create(T[] prelist, int level, TriNode<T> parent)
    {
        TriNode<T> p = null;
        if (i<prelist.length)
        {
            T elem=prelist[i++];
            if (elem!=null)
            {
                p = new TriNode<T>(elem, parent, null, null, level);
                p.left = create(prelist, level+1, p);
                p.right = create(prelist, level+1, p);
            }
        }
        return p;   
    }

    //(2) �������Ĳ���������㷨Ҫά��parent���level
    //����Ԫ��x��Ϊ����㣬ԭ�������Ϊ������
    public void insertRoot(T x)
    {
        this.root = new TriNode<T>(x, null, this.root, null, 1);
        if (this.root.left!=null)
            this.root.left.parent = this.root;
        setLevel(this.root.left, 2);             //������ԭ�����Ϊ�������������н��Ĳ��
    }
    //����Ԫ��x��Ϊp���ĺ��ӣ���leftChildΪtrue����������Ϊ���ӣ�������Ϊ�Һ���
    //���ز�����
    public TriNode<T> insertChild(TriNode<T> p, T x, boolean leftChild)
    {
        if (p==null || x==null)
            return null;
        TriNode<T> q=null;
        if (leftChild)
        {                                        //����x�����Ϊp�����ӣ�pԭ���ӳ�Ϊx������
            q=new TriNode<T>(x, p, p.left,null, p.level+1);
            if (p.left!=null)
                p.left.parent = q;               //ԭp���ӽ����¸�ĸ�����q
            p.left=q;
        }
        else
        {                                        //����x�����Ϊp���Һ��ӣ�pԭ�Һ��ӳ�Ϊx���Һ���
            q=new TriNode<T>(x, p, null, p.right, p.level+1);
            if (p.right!=null)
                p.right.parent = q;              //ԭp�Һ��ӽ����¸�ĸ�����q
            p.right=q;
        }
        setLevel(q, p.level+1);
        return q;                                //���ز�����
    }    
    //������p��㣨���Ϊlevel��Ϊ�������������н��Ĳ��
    public void setLevel(TriNode<T> p, int level)
    {
        if (p!=null)
        {
            p.level = level;
            setLevel(p.left, level+1);
            setLevel(p.right, level+1);
        }
    }
    
    //�����㷨��ͬ��������
    //���������ȸ����и��ͺ����������㷨��ͬ��������
    public void preOrder()                       //�ȸ��������������
    {
        System.out.print("�ȸ����������������  ");
        preOrder(root);
        System.out.println();
    }    
    public void preOrder(TriNode<T> p)           //�ȸ����������p���Ϊ�����Ӷ��������ݹ鷽��
    {
        if (p!=null)
        {
            System.out.print(p.level+p.data.toString()+" ");
            preOrder(p.left);
            preOrder(p.right); 
        }
    }

    public void inOrder()                        //�и��������������
    {
        System.out.print("�и����������������  ");
        inOrder(root);
        System.out.println();
    }    
    public void inOrder(TriNode<T> p)            //�и����������p���Ϊ�����Ӷ��������ݹ鷽��
    {
        if (p!=null)
        {
            inOrder(p.left);
//            System.out.print(p.level+p.data.toString()+" ");
            System.out.print(p.data.toString()+" ");
            inOrder(p.right);
        }
    }

    public void postOrder()                      //����������������
    {
        System.out.print("������������������  ");
        postOrder(root);
        System.out.println();
    }
    public void postOrder(TriNode<T> p)          //������������p���Ϊ�����Ӷ��������ݹ鷽��
    {
        if (p!=null)
        {
            postOrder(p.left);
            postOrder(p.right);
            System.out.print(p.level+p.data.toString()+" ");
        }
    }
    
    //���ڱ����Ĳ������㷨ͬ��������
    public int count()                           //���ض������Ľ�����
    {
        return count(root);
    }
    public int count(TriNode<T> p)               //������p���Ϊ���������Ľ�����
    {
        if (p==null)
            return 0;
        return 1+count(p.left)+count(p.right);
    }

    public int height()                          //���ض������ĸ߶�
    {
        return height(root);
    }
    public int height(TriNode<T> p)              //������p���Ϊ���������ĸ߶�
    {
        if (p==null)
            return 0;
        int lh = height(p.left);                 //�����������ĸ߶�
        int rh = height(p.right);                //�����������ĸ߶�
        return (lh>=rh) ? lh+1 : rh+1;           //��ǰ�����߶�Ϊ�ϸ������ĸ߶ȼ�1
    }

    public T search(T x)                //����ֵΪx�Ľ��
    {
        return searchNode(root, x).data;
    }
    public TriNode<T> searchNode(T x)                //����ֵΪx�Ľ��
    {
        return searchNode(root, x);
    }
    //����pΪ���������в���ֵΪx��㣬�ȸ���������������״γ��ֵ�ֵΪx�Ľ�㣬��δ�ҵ�����null
    public TriNode<T> searchNode(TriNode<T> p, T x)
    {
    	TriNode<T> find=null;                    //�����ҵ����
        if (p!=null && x!=null)
        {
            if (p.data.equals(x)) 
               return p;                         //���ҳɹ�������ָ�����
            find = searchNode(p.left, x);            //���������в��ң��ݹ����
            if (find==null)                      //������������δ�ҵ�
               find=searchNode(p.right, x);          //��������������в��ң��ݹ����
        }
        return find;                             //���ز��ҽ��
    }
    
    //�Ƚ����ö������Ƿ���ȣ��㷨ͬ��������
    public boolean equals(Object obj)
    {
        return obj==this || obj instanceof TriBinaryTree && equals(this.root, ((TriBinaryTree<T>)obj).root);
    }
    //�ж���p��q���Ϊ�������������Ƿ���ȣ��ݹ鷽��
    private boolean equals(TriNode<T> p, TriNode<T> q)
    {
        return p==null && q==null || p!=null && q!=null && p.data.equals(q.data) &&
               equals(p.left, q.left) && equals(p.right, q.right);
    }

    //����α������������㷨ͬ��������
    public void levelOrder()
    {                                     
        LinkedQueue<TriNode<T>> que=new LinkedQueue<TriNode<T>>();
        TriNode<T> p=this.root;
        System.out.print("��α�����  ");
        while (p!=null)
        {
            System.out.print(p.level+p.data.toString()+ " ");
            if(p.left!=null)    
                que.enqueue(p.left);             //p�����ӽ�����
            if(p.right!=null)
                que.enqueue(p.right);            //p���Һ��ӽ�����
            p = que.dequeue();                   //pָ����ӽ��
        }
        System.out.println();
    }

    //ɾ�����������㷨ͬ��������
    public void removeRoot()                     //ɾ��������
    {
        this.root = null;
    }
    //ɾ��p�����������������leftChildΪtrue��ɾ��������������ɾ��������
    public void removeChild(TriNode<T> p, boolean leftChild)
    {
        if (p!=null)
            if (leftChild)
                p.left = null;
            else
                p.right = null;
    }
	
    //ϰ��6
    //���
    public TriBinaryTree(TriBinaryTree<T> bitree)          //������������
    {
        this.root = copy(bitree.root, null);
    }

    //������p�����Ӷ������������½��Ӷ������ĸ���㣬�㷨�иĶ�
    private TriNode<T> copy(TriNode<T> p, TriNode<T> parent)
    {
        if (p==null)
            return null;
        TriNode<T> q = new TriNode<T>(p.data, parent, null, null, p.level);
        q.left = copy(p.left, q);                          //�������������ݹ����
        q.right = copy(p.right, q);                        //�������������ݹ����
        return q;                                          //���ؽ��������ĸ����
    }

}
