//���鼯
public class UnionFindSet                                  //���鼯��
{
    private int parent[];                                  //��ָ������
    
    //������n��Ԫ�صĲ��鼯���󣬼��ϳ�ʼ״̬�ǰ���n������ɭ�֣��丸ָ������Ԫ��ֵΪ-1����ʾÿ����ֻ��һ�����
    public UnionFindSet(int n)                        
    {
        this.parent = new int[n];
        for (int i=0; i<n; i++)
            this.parent[i]=-1;
    }

    //���Ҳ�����Ԫ��x�������ĸ��±ꡣ�㷨���Ÿ�ָ������Ѱ��ֱ����
    public int find(int x)
    {
        while (this.parent[x]>=0)                          //��x���Ǹ�
            x=this.parent[x];                              //�ҵ�������±�
        return x;                                          //���ظ�����±�
    }
    
    //���ϲ����㣬��x��y����ͬһ�����У���ϲ����x��y���ڵ�������������true�����򷵻�false
    //�㷨���Ȳ��Ҳ��ֱ𷵻ؽ��x��y�������ĸ������������϶��һ������Ϊ��һ�����ĺ��ӽ��
    public boolean union(int x, int y)
    {
    	int rootx=find(x), rooty=find(y);                  //rootx��rooty�ֱ��ý��x��y�������ĸ�
        if (rootx!=rooty)                                  //x��y����ͬһ������
            if (parent[rootx]<=parent[rooty])              //rootx���������������϶�
            {
                this.parent[rootx]+=this.parent[rooty];    //���������
                this.parent[rooty]=rootx;                  //��rooty��Ϊrootx�ĺ��ӽ�㣬����Ԫ��ֵָ�򸸽���±�
            }
            else
            {
                this.parent[rooty]+=this.parent[rootx];
                this.parent[rootx]=rooty;                  //��rootx��Ϊrooty�ĺ��ӽ��
            }
        return rootx!=rooty;                               //���غϲ����״̬
    }
    
    public String toString()
    {
        String str="(";
        if (this.parent.length>0)
            str += this.parent[0];
        for (int i=1; i<this.parent.length; i++)
            str += ", "+this.parent[i];
        return str+") ";
    }
    
    public static void main(String args[])
    {
        //������p263ͼ6.4
        UnionFindSet ufset = new UnionFindSet(10);          //���鼯
        ufset.union(0,6);
        ufset.union(0,7);
        ufset.union(0,8);
        ufset.union(1,4);
        ufset.union(1,9);        
        System.out.println("���鼯��"+ufset.toString());
        ufset.union(0,1);
        System.out.println("���鼯��"+ufset.toString());
    }    
/*
�������н�����£�
���鼯��(-4, -3, -1, -1, 1, -1, 0, 0, 0, 1) 
���鼯��(-7, 0, -1, -1, 1, -1, 0, 0, 0, 1) 
*/

    //���Ҳ�����Ԫ��x�������ĸ��±꣬ͬʱ�����۵�����ѹ��·��
    //�㷨���Ÿ�ָ������Ѱ��ֱ����������x����·���ϵ����н�㶼�ĳɸ��ĺ���
    public int collapsingFind(int x)
    {
        int root=x;
        while (this.parent[root]>=0)                       //��x���Ǹ�
            root=this.parent[root];                        //�ҵ�������±�
        while (root!=x && parent[x]!=root)                 //��x���Ǹ���x���Ǹ��ĺ���ʱ
        {
            int pa = parent[x];
            parent[x]=root;                                //��x��Ϊroot�ĺ��ӽ��
            x=pa;                                          //���ϵ�x�ĸ����
        }
        return root;                                       //���ظ�����±�
    }
}