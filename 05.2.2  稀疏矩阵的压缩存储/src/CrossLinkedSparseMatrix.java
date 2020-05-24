//5.2.2 ϡ������ѹ���洢
//5.  ϡ�����ʮ������

public class CrossLinkedSparseMatrix                       //ʮ������洢��ϡ�������
{
    private int rows, columns;                             //��������������
    private CrossNode rowheads[],columnheads[];            //��ָ���������ָ�����飬Ԫ��������ʮ�������� 

    public CrossLinkedSparseMatrix(int rows, int columns)  //����rows��columns�������
    {
        if (rows<=0 || columns<=0)
            throw new IllegalArgumentException("����������������������");
        this.rows = rows;
        this.columns = columns;
        this.rowheads = new CrossNode[this.rows];          //������ָ������Ŀ�˳���Ԫ����null
        this.columnheads = new CrossNode[this.columns];    //������ָ������Ŀ�˳���Ԫ����null
    }
    
    //����rows��columns�о�������Ԫ������elems�ṩ�����ֵ
    public CrossLinkedSparseMatrix(int rows, int columns, Triple[] elems)
    {
        this(rows, columns);
        for (int i=0; i<elems.length; i++)
            this.set(elems[i]);                            //����һ��Ԫ�ص���Ԫ��
    }

    public int get(int i, int j)                           //���ؾ����i�е�j�е�Ԫ��
    {
        if (i<0 || i>=rows || j<0 || j>=columns) 
            throw new IndexOutOfBoundsException("����Ԫ�ص��л������Խ��");
        for (CrossNode p=this.rowheads[i];  p!=null;  p=p.right) //�ڵ�i������������˳�����(i,j,?)���
            if (p.data.column==j)                          //�����������У�������Ԫ��Ԫ��ֵ
                return p.data.value;                       //���ҵ�(i,j,value)��㣬���ؾ���Ԫ��
        return 0;                                          //û���ҵ�ʱ����0
    }
    
    public void set(Triple elem)                           //����Ԫ�����þ���Ԫ��
    {
        this.set(elem.row, elem.column, elem.value);
    }
    public void set(int i, int j, int value)               //���þ����i�е�j��Ԫ��ֵΪvalue
    {
        if (value==0) 
            return;                                        //���洢ֵΪ0Ԫ��
        if (i>=this.rows || j>=this.columns) 
            throw new IllegalArgumentException("��Ԫ����л������Խ��");
        
        //�����ڵ�i���������в���ָ����Ԫ�飬����ģ������С��е������в�����Ԫ����
        Triple elem = new Triple(i,j,value);
        CrossNode rhead=this.rowheads[i];                  //rheadָ���i�е�����ĵ�һ�����
        if (rhead==null || rhead.data.column>j)            //�ձ�����ͷ����
        {
            this.rowheads[i] = new CrossNode(elem, rhead, null);
            insertColumnHeads(this.rowheads[i]);           //���ý����뵽�еĵ�����
            return;
        }
        CrossNode front=null, p=rhead;
        while (p!=null && p.data.column<=j)                //������������˳�����(i,j,?)���
        {
            if (p.data.column==j)                          //�����������У�������Ԫ��Ԫ��ֵ
            {
                 p.data.value = value;                     //���ҵ������ľ���Ԫ��ֵ
                 return;
            }
            front = p;                                     //front��p��ǰ�����
            p = p.right;
        }
        front.right = new CrossNode(elem, p, null);        //δ�ҵ�����front֮�������Ԫ���㣬�м��β����
        insertColumnHeads(front.right);                    //���ý����뵽�еĵ�����
    }
    
    private void insertColumnHeads(CrossNode node)         //����node��㵽��Ӧ�еĵ�������
    {
        Triple elem = node.data;
        CrossNode chead=this.columnheads[elem.column];     //��õ�column�е�����
        if (chead==null || chead.data.row>elem.row)        //�ձ�����ͷ����
        {
            this.columnheads[elem.column] = node;
            if (chead!=null)
                node.down = chead.down;
        }
        else                                               //�м�����β����
        {
            CrossNode front=chead, p=front.down;           //front��p��ǰ�����
            while (p!=null && p.data.row<=elem.row)        //������������˳����ң�Ѱ�Ҳ���λ��
            {
                front = p;                                   
                p = p.down;
            }
            front.down = node;                             //��node��������front֮���м��β����
            node.down = p;
        }
    }

    public String toString()                               //����ϡ�������Ԫ��ʮ�������ϡ������ַ���
    {
        String str="��Ԫ��ʮ������\n";
        str+="��Ԫ���еĵ�����";
        for (int i=0; i<this.rowheads.length; i++)
        {
            str+="(";
            for (CrossNode p=this.rowheads[i];  p!=null;  p=p.right)
            {
                str += p.data.toString();
                if (p.right!=null)
                    str+=",";
            }
            str += ")";
            if (i<this.rowheads.length-1) 
                str += ", ";
        }
        str+="\n��Ԫ���еĵ�����";
        for (int i=0; i<this.columnheads.length; i++)
        {
            str+="(";
            for (CrossNode p=this.columnheads[i];  p!=null;  p=p.down)
            {
                str += p.data.toString();
                if (p.down!=null)
                    str+=",";
            }
            str += ")";
            if (i<this.columnheads.length-1) 
                str += ", ";
        }
        
        str+="\nϡ�����"+this.getClass().getName()+"��"+rows+"��"+columns+"����\n";
        for (int i=0; i<this.rows; i++)
        {
            CrossNode p=this.rowheads[i];
            for (int j=0; j<this.columns; j++)
               if (p!=null && j==p.data.column)            //��i==p.data.row 
               {
                   str += String.format("%4d",p.data.value);
                   p = p.right;
               }               
               else
                   str +=String.format("%4d",0);
            str += "\n";
        }   
        return str;
    }

    //��ǰ������smat������ӣ�this+=smat���ı䵱ǰ����
    public void add(CrossLinkedSparseMatrix smat)
    {
        if (this.rows!=smat.rows || this.columns!=smat.columns)
            throw new IllegalArgumentException("�������������ͬ���������");

        for (int i=0; i<this.rows; i++)                    //��Ӻϲ�������������
        { 
            CrossNode rhead=this.rowheads[i];              //��õ�ǰ�����i�е�����
            CrossNode q=smat.rowheads[i];                  //��ò��������i�е�����
            if (q==null)
                 continue;
            if (rhead==null || rhead.data.column>q.data.column)//�ձ�����ͷ����
            {
                rhead= new CrossNode(new Triple(q.data), rhead, null);   //������㣬����Ԫ��
                this.rowheads[i]=rhead;
                insertColumnHeads(rhead);
                q = q.right;
            }
            CrossNode front=null, p=rhead;                  //�м��β����
            while (p!=null && q!=null)
            {
                if (p.data.column==q.data.column)           //��������ʾ��ͬλ�þ���Ԫ��
                {
                    p.data.value += q.data.value;           //���Ľ��Ԫ��ֵ������Ԫ��ֵ���
                    if (p.data.value==0)                    //���Ԫ��ֵΪ0
                        if (front==null)
                        {
                            this.rowheads[i]=p.right;
                            removeColumnHeads(p);           //����Ӧ�еĵ�������ɾ��node���
                            p=p.right;
                        }
                        else
                        {
                            front.right=p.right;            //��Ӻ�Ԫ�ز���Ҫ�洢��ɾ��p���
                            removeColumnHeads(p);           //����Ӧ�еĵ�������ɾ��node���
                            p=front.right;
                        }
                    else 
                    {
                        front = p;                         //front��p��ǰ�����
                        p = p.right;
                    }
                    q = q.right;
                }
                else if (p.data.column < q.data.column)
                {
                    front = p;       
                    p = p.right;                           //��ǰ����Ԫ��ֵС��p����ƶ���q����
                }
                else                                       //����q��㲢���뵽front���֮�󣬸���Ԫ��
                {
                    front.right = new CrossNode(new Triple(q.data), p, null);
                    q = q.right;
                    insertColumnHeads(front.right);
                }
            }
            while (q!=null)                                //��smat����������ʣ���㸴�Ʋ����뵽��ǰ����β
            {
                front.right = new CrossNode(new Triple(q.data), null, null);
                insertColumnHeads(front.right);
                front = front.right;
                q = q.right;
            }
        }
    }
    private void removeColumnHeads(CrossNode node)         //����Ӧ�еĵ�������ɾ��node���
    {
        Triple elem = node.data;
        CrossNode chead=this.columnheads[elem.column];     //��õ�column�е�����
        if (chead.data.row==elem.row)                      //ͷɾ������chead!=null
            this.columnheads[elem.column] = node.down;     //ɾ��node���
        else                                               //�м��βɾ��
        {
            CrossNode front=chead, p=front.down;           //front��p��ǰ�����
            while (p!=null && p.data.row<elem.row)         //������������˳�����
            {
                front = p;                                   
                p = p.down;
            }
            if (p!=null && p.data.row==elem.row)           //pΪ���ҵ���㣬��ɾ��
                front.down = node.down;                    //ɾ��front֮���node��㣬�м��βɾ��
        }
    }
    
    //ϰ��5
    public CrossLinkedSparseMatrix(CrossLinkedSparseMatrix smat)           //���
    {
        this(smat.rows, smat.columns);
        this.add(smat);
    }

    //���ص�ǰ������smat��Ӻ�ľ��󣬲��ı䵱ǰ����=this+smat��ͬSeqSparseMatrix��
    public CrossLinkedSparseMatrix plus(CrossLinkedSparseMatrix smat)
    {
        CrossLinkedSparseMatrix smatc=new CrossLinkedSparseMatrix(this);   //���
        smatc.add(smat);
        return smatc;                                      //���ض�������
    }

    public boolean equals(Object obj)                      //�Ƚ����������Ƿ����
    {
        if (this==obj)
            return true;
        if (!(obj instanceof CrossLinkedSparseMatrix))
            return false;
        CrossLinkedSparseMatrix smat=(CrossLinkedSparseMatrix)obj;    
        if (this.rows!=smat.rows || this.columns!=smat.columns)
            return false;
        for (int i=0; i<this.rows; i++) //�ֱ�Ƚ�this����ĵ�i�е�������smat����ĵ�i�е������Ƿ����
        {
            CrossNode p=this.rowheads[i], q=smat.rowheads[i];
            while (p!=null && q!=null)
            {
                if (!(p.data.equals(q.data))) 
                    return false;
                p = p.right;
                q = q.right;
            }
            if (p!=null || q!=null)
                return false; 
        }
        return true;
    }
}
/*����δ����
    public CrossLinkedSparseMatrix transpose()             //����ת�þ���
    {
    	CrossLinkedSparseMatrix trans = new CrossLinkedSparseMatrix(columns, rows);//���������
        for (int i=0; i<this.rows; i++)
        {                                            //�鲢����ӣ���������ĵ�����
            CrossNode p=this.rowheads[i];                    //�ڵ�i���������в���
            while (p!=null)   //�Գ�Ԫ�ص���Ԫ��item��������ĵ�����
            {
                trans.set(p.data.toSymmetry());    //����q��㲢���뵽front���֮��
                p = p.right;
            }
        }
        return trans;
    }
}*/
