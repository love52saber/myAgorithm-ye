public class ThreadBinaryTree<T>                 //���������������࣬����Tָ������Ԫ������
{
    public ThreadNode<T> root;

    public ThreadBinaryTree()                    //�������������������
    {
        this.root = null;
    }

    public boolean isEmpty()                     //�ж����������������Ƿ��
    {
        return root==null;
    }

    public ThreadBinaryTree(T[] prelist)         //�Ա������������ȸ����й������������������������
    {
        this.root = create(prelist);
        inorderThread(this.root);
    }
    //�Ա������������ȸ����й���һ���Ӷ������������ĸ�ֵ��prelist[i]�����������������ĸ����
    private int i=0;
    private ThreadNode<T> create(T[] prelist)
    {
        ThreadNode<T> p = null;
        if (i<prelist.length)
        {
            T elem=prelist[i++];
            if (elem!=null)
            {
                p = new ThreadNode<T>(elem);
                p.left = create(prelist);
                p.right = create(prelist);
            }
        }
        return p;
    }

    //������������p���Ϊ����������p��ǰ�������front
    private ThreadNode<T> front=null;
    private void inorderThread(ThreadNode<T> p)
    {
        if (p!=null)
        {
            inorderThread(p.left);               //����������p��������
            if (p.left==null)                    //��p��������Ϊ��
            {
                p.ltag=1;                        //�������������
                p.left=front;                    //����p.leftΪָ��ǰ��front������
            }
            if (p.right==null)                   //��p��������Ϊ��
                p.rtag=1;                        //�������������
            if (front!=null && front.rtag==1) 
                front.right=p;                   //����ǰ��front.rightΪָ����p������
            front=p;
            inorderThread(p.right);              //����������p��������
        }
    }

    public ThreadNode<T> inNext(ThreadNode<T> p) //����p���и������µĺ�̽��
    {
        if (p.rtag==1)                           //��������Ϊ��
            p=p.right;                           //p.right����ָ���̽�������
        else
        {
            p=p.right;                           //���������ǿգ�����������
            while (p.ltag==0)                    //�ҵ�����ߵĺ�����
                p=p.left;
        }
        return p;
    }
    public void inOrder()                                  //�и�������������������������ǵݹ��㷨
    {
        System.out.print("�и������������������������  ");
        ThreadNode<T> p=this.root;
        while (p!=null && p.ltag==0)                       //Ѱ�Ҹ�������ߵĺ����㣬����һ�����ʽ��
            p=p.left; 
        while (p!=null)
        {
            System.out.print(p.data.toString()+" ");
            p = this.inNext(p);                            //����p���и������µĺ�̽��
        }
        System.out.println();
    }    

    public ThreadNode<T> preNext(ThreadNode<T> p)          //����p���ȸ������µĺ�̽��
    {
        if (p.ltag==0)                                     //���������ǿ�
            p=p.left;                                      //���Ӿ���p�ĺ�̽��
        else                                               //���򣬺�������ֵܻ�ĳ���������ȵ��Һ���
        {
            while(p.rtag==1 && p.right!=null)              //Ѱ��ĳ����������
                p=p.right;                                 //�������ĳ���������ȵ��Һ���
            p=p.right;                                     //�Һ�����p�ĺ�̽��
        }
        return p;
    }
    public void preOrder()                       //�ȸ�������������������������ǵݹ��㷨
    {
        System.out.print("�ȸ������������������������  ");
        for (ThreadNode<T> p=this.root;  p!=null;  p=preNext(p))  //����p���ȸ������µĺ�̽��
            System.out.print(p.data.toString()+" ");
        System.out.println();
    }
    
    //6. ���������������Ĳ������
    public void insertRoot(T x)                  //������Ϊ�����
    {
        if (this.root==null)
            this.root=new ThreadNode<T>(x, null,1, null,1);
        else
        {
            ThreadNode<T> p=this.root;
            while (p!=null && p.rtag==0)         //Ѱ��ԭ�������ұ�������p���������ʽ��
                p=p.right;
            this.root=new ThreadNode<T>(x, this.root,0, null,1);
            p.right=this.root;                   //�޸�p�ĺ������
        }
    }
    
    //����x��Ϊp���ĺ��ӽ�㣬��leftChildΪtrue���������ӣ���������Һ��ӣ����ز���ĺ��ӽ��
    public ThreadNode<T> insertChild(ThreadNode<T> p, T x, boolean leftChild)
    {
        ThreadNode<T> q=null;
        if (leftChild)                           //��������
        {
            q=new ThreadNode<T>(x, p.left, p.ltag, p,1);
            p.left=q;
            p.ltag=0;
            if (q.ltag==0)
            {
                ThreadNode<T> pred=inPred(q);    //pred��q���и������µ�ǰ��
                pred.right=q;                    //�޸�ǰ�����pred�ĺ������
            }
        }
        else                                     //�����Һ���
        {
            q=new ThreadNode<T>(x, p,1,p.right, p.rtag);
            p.right=q;
            p.rtag=0;
            if (q.rtag==0)
            {
                ThreadNode<T> succ=inNext(q);    //succ��q���и������µĺ��
                succ.left=q;                     //�޸ĺ�̽��succ��ǰ������
            }
        }
        return q;
    }
    
    //7. ��������������ɾ�������������Ӷ��棬Ҷ�㷨
    public void removeRightChild(ThreadNode<T> p)//ɾ��ָ�����p���Һ��ӽ��
    {
        if (root==null || p==null || p.rtag==1)  //��p���Һ��ӣ���ɾ��
            return;
        ThreadNode<T> q=p.right;                 //qΪ��ɾ�����
        if (q.ltag==0)                           //q������
        {
            p.right = q.left;                    //��q�����Ӷ���q��p.rtagδ��
            ThreadNode<T> pred=inPred(q);        //predָ��q���и������µ�ǰ��
            pred.right=q.right;                  //�޸�ǰ�����pred�ĺ������
            pred.rtag=q.rtag;
            if (q.rtag==0)                       //qҲ���Һ��ӣ�q��2�Ƚ��
                inNext(q).left=pred;             //�޸�q��̽��inNext(q)��ǰ������
        }
        else                                     //q����ֻ���Һ��ӵ�1�Ƚ�㣬����Ҷ�ӽ��
        {
            p.right = q.right;                   //��q���Һ��ӣ���������������q
            p.rtag = q.rtag;
            if (q.rtag==0)                       //q���Һ���û������
                inNext(q).left=p;                //�޸�q��̽��inNext(q)��ǰ������
        }
    }
    
    //ɾ������㣬�����Ӷ���
    public void removeRoot()
    {
        if (root==null)                          //����������ɾ��
            return;
        ThreadNode<T> pred=inPred(root);         //predָ�����ǰ��
        ThreadNode<T> succ=inNext(root);         //succָ�����ǰ��
        if (pred!=null)                          //����ǰ��ʱ
        {
            pred.right=root.right;               //ʹǰ��pred�ĺ����ָ������Һ���
            pred.rtag=root.rtag;
        }
        if (succ!=null)                          //���к��ʱ
            succ.left=pred;                      //�޸ĺ��succ��ǰ��������succ.ltagδ��
        if (root.ltag==0)                        //��������ʱ
            root = root.left;                    //�����Ӷ����
        else
            root = root.right;                   //���Һ��Ӷ����
    }
    
    //ϰ��6
    public ThreadNode<T> inPred(ThreadNode<T> p) //����p���и������µ�ǰ�����
    {
        if (p.ltag==1)                           //��������Ϊ��
            p=p.left;                            //p.left����ָ��pǰ����������
        else                                     //���������ǿ�
        {
            p=p.left;                            //����������
            while (p.rtag==0)                    //�ҵ����ұߵ�������
                p=p.right;
        }
        return p;
    }
    public void inOrder_pred()                   //�и�������������������������ǵݹ��㷨
    {
        System.out.print("�и����򣨷��򣩱�������������������  ");
        ThreadNode<T> p=this.root;
        while (p!=null && p.rtag==0)             //Ѱ�Ҹ������ұߵĺ�����
            p=p.right; 
        while (p!=null)
        {
            System.out.print(p.data.toString()+" ");
            p=inPred(p);                         //����p���и������µ�ǰ�����
        } 
        System.out.println();
    }    

    public ThreadNode<T> postPred(ThreadNode<T> p) //����p�ں�������µ�ǰ�����
    {
        if(p.rtag==0)                            //�������ǿ�
            p=p.right;                           //�Һ�����p��ǰ�����
        else                                     //����ǰ�������ֵܻ���ĳ���������ȵ�����
        {
            while (p.ltag==1 && p.left!=null)    //Ѱ����ĳ����������
                p=p.left;
            p=p.left;                            //������p��ǰ�����
        }
        return p;
    }
    public void postOrder_pred()                 //���������������������������ǵݹ��㷨
    {
        System.out.print("������򣨷��򣩱�������������������  ");
        for (ThreadNode<T> p=this.root;  p!=null;  p=postPred(p))  //����p�ں�������µ�ǰ�����
            System.out.print(p.data.toString()+" ");
        System.out.println();
    }
    
    public void removeLeftChild(ThreadNode<T> p) //ɾ��ָ�����p�����ӽ��
    {
        if (root==null || p==null || p.ltag==1)  //��p�����ӣ���ɾ��
            return;
        ThreadNode<T> q=p.left;                  //qΪ��ɾ�����
        if (q.ltag==0)                           //q������
        {
            p.left = q.left;                     //��q�����Ӷ���q��p.rtagδ��
            ThreadNode<T> pred=inPred(q);        //predָ��q���и������µ�ǰ��
            pred.right=q.right;                  //�޸�ǰ�����pred�ĺ������
            pred.rtag=q.rtag;
            if (q.rtag==0)                       //qҲ���Һ��ӣ�q��2�Ƚ��
                inNext(q).left=pred;             //�޸�q��̽��inNext(q)��ǰ������
        }
        else                                     //q����ֻ���Һ��ӵ�1�Ƚ�㣬����Ҷ�ӽ��
            if (q.rtag==1)                       //q��Ҷ�ӽ��
            {
                p.left = q.left;                 //��q��ǰ����������q
                p.ltag = 1;
            }
            else                                 //q��ֻ���Һ��ӵ�1�Ƚ��
            {
                p.left = q.right;                //��q���Һ��Ӷ���q
                inNext(q).left=q.left;           //�޸�q��̽��inNext(q)��ǰ������
            }
    }
    
    //ϰ��6
    ThreadNode<T> getParent(ThreadNode<T> node)            //����node���ĸ�ĸ���
    {
        if (root==null || node==null || node==root)
            return null;                                   //���ĸ�ĸ���Ϊnull
        ThreadNode<T> p=node;            
        while (p.ltag==0)                                  //�ȴ�����ң�Ѱ��node�������ߵ�������
            p=p.left; 
        if (p.left!=null)                                  //ǰ����������ʱ
        {
            p=p.left;                                      //��ǰ����������node��һ�����Ƚ��
            if (p.right==node)
                return p;                                  //������������ĸ���
            p=p.right;                                     //�����Һ������������Ѱ��
            while (p.left!=node)
                p=p.left;                                  //�����������������Ѱ��
        }
        else                                               //ǰ��������ʱ�������ұ�Ѱ��  
        {   p=node;
            while (p.rtag==0)                              //�ҵ�node������ұߵ�������
                p=p.right;
            p=p.right;                                     //�غ����������node��һ�����Ƚ��
            if (p.left==node)
                return p;
            p=p.left;  
            while (p.right!=node)
                p=p.right;                                 //�����Һ������������Ѱ��
        }
        return p;
    }
}
