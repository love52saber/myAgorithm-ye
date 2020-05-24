//8.4.1   ����������
//SortedBinaryTree??

//�����������࣬�̳ж������࣬Ҫ����T��ʵ�ʲ�����ʵ�ֿɱȽϽӿ�
public class BinarySortTree<T extends Comparable<T>> extends BinaryTree<T>
{
    public BinarySortTree()                                //����ն���������
    {
        super();                                           //���ø����Ĭ�Ϲ��췽��
    }
    public BinarySortTree(T[] values)            //��values����Ԫ�����β��빹��һ�ö���������
    {
        super();
        for (int i=0; i<values.length; i++)
            this.insert(values[i]);                        //��Ԫ�ز��뵽��ǰ�Ķ�����������
    } 
    //û�м̳и���Ĺ��췽��
    
    public String toString()                     //�����и�����������������н��������ַ���
    {
        return toString(root);
    }
    private String toString(BinaryNode<T> p)     //�����и����������pΪ�������������ַ������ݹ��㷨
    {
        if (p==null)
            return "";
        return  toString(p.left) +p.data.toString()+" " + toString(p.right); //�ݹ����
    }
    
    //���Ҳ����عؼ���ΪkeyԪ�ؽ�㣬�����Ҳ��ɹ�����null���ǵݹ��㷨
    public BinaryNode<T> searchNode(T key)
    {
        if (key==null)
            return null;                     
        BinaryNode<T> p=this.root;
        while (p!=null && p.data.compareTo(key)!=0)        //��û�������
        {
//            System.out.print(p.data+"? ");                 //��ʾ���Ҿ����Ľ��ֵ����ʡ��
            if (p.data.compareTo(key)>0)                   //��key��С
                p=p.left;                                  //����������
            else
                p=p.right;                                 //����������
        }
        return p;
    }
    
    public void insert(T x)                      //����Ԫ��x��㣬������ؼ����ظ�Ԫ�غͿն���
    {
        if (x==null)  return;                              //���ܲ���ն���
        if (root==null)
            root=new BinaryNode<T>(x);                     //���������
        else                                               //��x���뵽������������
        {   BinaryNode<T> p=this.root, parent=null;
            while (p!=null)                                //���Ҳ���λ��
            {   parent = p;
                if (x.compareTo(p.data)==0)
                    return;                                //������ؼ����ظ���Ԫ��    
                if (x.compareTo(p.data)<0)
                    p=p.left;
                else p=p.right;
            }
            p=new BinaryNode<T>(x);                        //����Ҷ�ӽ��p
            if(x.compareTo(parent.data)<0)
                parent.left = p;                           //����p��Ϊparent������
            else parent.right = p;                         //����p��Ϊparent���Һ���
        }
    }
    
/*    public BinaryNode<T> remove(T x)             //ɾ��Ԫ��Ϊx�Ľ�㣬����ɾ����㣬��ûɾ������null
    {
        if (root==null || x==null)
            return null;                     
        return remove(x, root, null);                  //����rootΪ���Ķ�����������ɾ��ֵΪx�Ľ��
    }  
    //����pΪ����������ɾ��Ԫ��Ϊx�Ľ�㣬parent��p�ĸ�ĸ��㣬����ɾ����㣬�ݹ��㷨
    private BinaryNode<T> remove(T x, BinaryNode<T> p, BinaryNode<T> parent)
    {
        if (p==null)
            return null;
        if (x.compareTo(p.data)<0)
            return remove(x, p.left, p);                //��p����������ɾ��x���ݹ���ã�����
        if (x.compareTo(p.data)>0)
            return remove(x, p.right, p);               //��p����������ɾ��x���ݹ���ã�����
        if (p.left!=null && p.right!=null)              //�ҵ���ɾ�����p��p��2�Ƚ��
        {
            BinaryNode<T> insucc = p.right;             //Ѱ��p���и������µĺ�̽��insucc
            while (insucc.left!=null)
                insucc = insucc.left;
            p.data = insucc.data;                       //�Ժ�̽��ֵ�滻
            return remove(p.data, p.right, p);          
        }
        if (parent==null)                               //p��1�Ȼ�Ҷ�ӽ�㣬ɾ������㣬��p==root
        {
            if (p.left!=null)
                root = p.left;
            else
                root = p.right;
            return p;                            //����ɾ�����p
        }
        if (p==parent.left)                      //p��1�Ȼ�Ҷ�ӽ�㣬p��parent������
            if (p.left!=null)
                parent.left = p.left;            //��p���������
            else
                parent.left = p.right;
        else                                     //p��parent���Һ���
            if (p.left!=null)
                parent.right = p.left;
            else
                parent.right = p.right;
        return p;
    }*/
    
    //��֧�ָ����insertRoot()��insertChild()��removeChild()���������串�ǲ��׳��쳣��
    public void insertRoot(T x) 
    {
        throw new UnsupportedOperationException("insertRoot(T x)");
    }
    public BinaryNode<T> insertChild(BinaryNode<T> p, T x, boolean leftChild)
    {
        throw new UnsupportedOperationException("insertChild()");
    }    
    public void removeChild(BinaryNode<T> p, boolean leftChild)
    {
        throw new UnsupportedOperationException("removeChild()");
    }    

    //��4��Ľ�����
    public T search(T key)
    {
        if (key==null)
            return null;                     
        BinaryNode<T> p=this.root;
        while (p!=null)                                    //���Ҿ���һ���Ӹ�������·�����ǵݹ�
        {
//            System.out.print(p.data+"? ");                 //��ʾ���Ҿ����Ľ��ֵ����ʡ��
            if (p.data.compareTo(key)==0)                  //���ؼ�����ȣ����ҳɹ�������Ԫ��
                return p.data; 
            if (p.data.compareTo(key)>0)                   //��key��С
                p=p.left;                                  //����������
            else
                p=p.right;                                 //����������
        }
        return null;                                       //���Ҳ��ɹ�������һ���Ӹ���Ҷ�ӵ�·��
    }    
    
    //ɾ���ؼ���ΪkeyԪ�ؽ�㡣��û�ҵ���ɾ�����ǵݹ��㷨
    public void remove(T key)
    {
        if (key==null || root==null)
            return;
        BinaryNode<T> p=this.root, parent=null;            //p�ĸ�ĸ��parent
        while (p!=null && p.data.compareTo(key)!=0)        //���ҹؼ���ΪkeyԪ�ؽ��
        {
             parent = p;
             if (p.data.compareTo(key)>0)
                 p=p.left;
             else
                 p=p.right; 
        }
        if (p!=null && p.left!=null && p.right!=null)      //�ҵ���ɾ�����p��p��2�Ƚ��
        {
            BinaryNode<T> insucc = p.right;                //Ѱ��p���и������µĺ�̽��insucc
            parent = p;
            while (insucc.left!=null)
            {
                parent = insucc;
                insucc = insucc.left;
            }
            p.data = insucc.data;                          //�Ժ�̽��ֵ�滻p���ֵ
            p = insucc;                                    //ɾ��pԭ��̽�㣬ת��Ϊɾ��1��0�Ƚ��
        }
        if (p!=null && parent==null)                       //p��1�Ȼ�Ҷ�ӽ�㣬ɾ������㣬��p==root
        {
            if (p.left!=null)
                root = p.left;
            else
                root = p.right;
            return;
        }
        if (p!=null && p==parent.left)                     //p��1�Ȼ�Ҷ�ӽ�㣬p��parent������
            if (p.left!=null)
                parent.left = p.left;                      //��p���������
            else
                parent.left = p.right;
        if (p!=null && p==parent.right)                    //p��1�Ȼ�Ҷ�ӽ�㣬p��parent���Һ���
            if (p.left!=null)
                parent.right = p.left;
            else
                parent.right = p.right;
    }    
    
    //ϰ��8
    public T max()                                        //��������Ԫ�ص����ֵ
    {                                                     //�㷨Ѱ�Ҹ��������ұߵ�һ�������㣬��ֵ���
        BinaryNode<T> p = root;
        while (p!=null && p.right!=null)
            p=p.right; 
        return p.data;
    }
    public T min()                                        //��������Ԫ�ص���Сֵ
    {                                                     //�㷨Ѱ�Ҹ���������ߵ�һ�������㣬��ֵ��С
        BinaryNode<T> p = root;
        while (p!=null && p.left!=null)
            p=p.left; 
        return p.data;
    }

/*    public BinaryNode<T> searchNode(T x)                   //����ֵΪx�Ľ�㣬�����ҳɹ����ؽ�㣬���򷵻�null
    {
        return searchNode(x, root);
    }
    //����pΪ���������в���ֵΪx�Ľ�㣬�ݹ��㷨
    private BinaryNode<T> searchNode(T x, BinaryNode<T> p)
    {
        if (p==null || x==null)
            return null;
        if (x.compareTo(p.data)==0)                        //������������ȣ����ҳɹ�
            return p; 
        System.out.print(p.data+"? ");
        if (x.compareTo(p.data)<0)
            return searchNode(x, p.left);                  //���������в���
        return searchNode(x, p.right);                     //���������в���
    }*/

    public void insertNode(T x)                            //����Ԫ��x��㣬������ؼ����ظ�Ԫ�غͿն���
    {
        if (x==null)
            return;                                        //���ܲ���ն���
        if (root==null)
            root=new BinaryNode<T>(x);                     //���������
        else insertNode(x, root);                          //����x����rootΪ���Ķ�����������
    }  

    private void insertNode(T x, BinaryNode<T> p)          //��x���뵽��pΪ���������С��ݹ��㷨
    {
        if (p==null || p.data.compareTo(x)==0)
            return;                                        //������ؼ����ظ���Ԫ�� 
        if (x.compareTo(p.data)<0)
            if (p.left==null)
                p.left = new BinaryNode<T>(x);             //����Ҷ�ӽ����Ϊp������
            else  insertNode(x, p.left);                   //��x���뵽p����������
        else
            if (p.right==null)
                p.right = new BinaryNode<T>(x);            //����Ҷ�ӽ����Ϊp���Һ���
            else  insertNode(x, p.right);                  //��x���뵽p����������
    }
}

