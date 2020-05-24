//5.2.2 ϡ������ѹ���洢
//4.  ϡ������еĵ�����

public class LinkedSparseMatrix
{
    private int rows, columns;                             //��������������
    private SeqList<PolySLinkedList<Triple>> list;         //��ָ��˳���Ԫ���Ƕ���ʽ����������� 

    public LinkedSparseMatrix(int rows, int columns)       //����rows��columns�������
    {
        if (rows<=0 || columns<=0)
            throw new IllegalArgumentException("����������������������");
        this.rows = rows;
        this.columns = columns;
        this.list = new SeqList<PolySLinkedList<Triple>>();//�����˳���Ԫ����null
        for (int i=0; i<rows; i++)                         //˳�������rows���յ�����Ԫ��
            this.list.append(new PolySLinkedList<Triple>());
    }
    
    //����rows��columns�о�������Ԫ������elems�ṩ�����ֵ
    public LinkedSparseMatrix(int rows, int columns, Triple[] elems)
    {
        this(rows, columns);
        for (int i=0; i<elems.length; i++)
            this.set(elems[i]);                            //�����������һ��Ԫ�ص���Ԫ��
    }

    public int get(int i, int j)                           //���ؾ����i�е�j�е�Ԫ��
    {
        if (i<0 || i>=rows || j<0 || j>=columns) 
            throw new IndexOutOfBoundsException("����Ԫ�ص��л������Խ��");
        PolySLinkedList<Triple> link = this.list.get(i);   //��õ�i�ж���ʽ��������
        Triple find=link.search(new Triple(i,j,0));   //������������˳����ң������ҵ���㣬�㷨ʵ�ּ�8.2.1��
        return (find==null) ? 0 : find.value;         //û���ҵ�ʱ����0�����򷵻ؽ��Ԫ��
    }
    
    public void set(Triple elem)                           //����Ԫ�����þ���Ԫ��
    {
        this.set(elem.row, elem.column, elem.value);
    }
    public void set(int row, int column, int value)        //���þ����row�е�column��Ԫ��ֵΪvalue
    {
        if (value==0) 
            return;                                        //���洢ֵΪ0Ԫ��
        if (row>=this.rows || column>=this.columns) 
            throw new IllegalArgumentException("��Ԫ����л������Խ��");
        
    	//�����ڵ�row���������в���ָ����Ԫ����󣬻���ģ������������һ����Ԫ��
        PolySLinkedList<Triple> link=this.list.get(row);   //��õ�row�ж���ʽ��������
        Node<Triple> front=link.head, p=front.next;        //front��p��ǰ�����
        while (p!=null && p.data.column<=column)           //�����������н���˳�����
        {
            if (p.data.column==column)                     //���ҵ������ľ���Ԫ��ֵ
            {
                p.data.value = value;
                return;
            }
            front = p;                                   
            p = p.next;
        }
        front.next = new Node<Triple>(new Triple(row,column,value), p); //��front֮�������Ԫ��Ԫ��
    }
    //˼���⣺set(elem)�������ܷ����link.insert(elem)��Ϊʲô��
    //�𣺲��ܣ���Ϊֵ��ͬʱҪ�滻�������롣

    public String toString()                               //����ϡ�������Ԫ��˳����ϡ����������ַ���
    {
        String str="��Ԫ���еĵ�����";
        for (int i=0; i<this.list.length(); i++)           //����SeqList��length()����
            str += this.list.get(i).toString();            //����SinglyLinkedList��toString()����
        str += "\nϡ�����"+this.getClass().getName()+"��"+rows+"��"+columns+"����\n";
        for (int i=0; i<this.list.length(); i++)
        {
            PolySLinkedList<Triple> link = this.list.get(i);
            Node<Triple> p=link.head.next;
            for (int j=0; j<this.columns; j++)
               if (p!=null && j==p.data.column)            //��i==p.data.row 
               {
                   str += String.format("%4d",p.data.value);
                   p = p.next;
               }               
               else
                   str +=String.format("%4d",0);
            str += "\n";
        }   
        return str;
    }
    
    //��ǰ������smat������ӣ�this+=smat���ı䵱ǰ����ÿ����������ĺϲ��㷨ͬ��������ʽ���
    public void add(LinkedSparseMatrix smat)
    {
        if (this.rows!=smat.rows || this.columns!=smat.columns)
            throw new IllegalArgumentException("�������������ͬ���������");
        for (int i=0; i<this.rows; i++)
            this.list.get(i).add(smat.list.get(i));        //���ö���ʽ���������(+=)�㷨
    }

    //��ȿ���������˳�������˳��������е������������н���Ԫ�ض���
    public LinkedSparseMatrix(LinkedSparseMatrix smat)
    {
        this(smat.rows, smat.columns);           //����rows��columns�������˳�����rows���յ��������
        for (int i=0; i<this.rows; i++)   
        {
            PolySLinkedList<Triple> link=new PolySLinkedList<Triple>(smat.list.get(i));
                                                 //����ʽ������������Ѹ������н�㣬û�и���Ԫ�ض���                
            for (Node<Triple> p=link.head.next;  p!=null;  p=p.next) 
                p.data = new Triple(p.data);     //����һ���������и�������õ�Ԫ�ض���
            this.list.set(i, link);              //�����ƺ�ĵ���������Ϊ˳����i��Ԫ��
        }
    }
    
    //���ص�ǰ������smat��Ӻ�ľ��󣬲��ı䵱ǰ����smatc=this+smat
    public LinkedSparseMatrix plus(LinkedSparseMatrix smat)
    {
        LinkedSparseMatrix smatc=new LinkedSparseMatrix(this);   //���
        smatc.add(smat);
        return smatc;                                      //���ض�������
    }

    public boolean equals(Object obj)                      //�Ƚ����������Ƿ���ȣ��㷨ͬSeqSparseMatrix��
    {
        if (this==obj)
            return true;
        if (!(obj instanceof LinkedSparseMatrix))
            return false;
        LinkedSparseMatrix smat=(LinkedSparseMatrix)obj;        
        return this.rows==smat.rows && this.columns==smat.columns && this.list.equals(smat.list);
                                                           //�Ƚ�������Ԫ��˳����Ƿ����
    }

    //ϰ��5
    /*    //���У�Ч�ʵͣ����ڲ���get(i,j)�����Ƿ���ȷ
        public String toString()                               //����ϡ�������Ԫ��˳����ϡ����������ַ���
        {
            String str="��Ԫ���еĵ�����"+ this.list.toString()+"\n";
            str+="ϡ�����"+this.getClass().getName()+"��"+rows+"��"+columns+"����\n";
            for (int i=0; i<this.rows; i++)
            {
                for (int j=0; j<this.columns; j++)
                    str += String.format("%4d", this.get(i,j));
                str += "\n";
            }
            return str;
        } */

    public LinkedSparseMatrix transpose()                  //����ת�þ���
    {
        LinkedSparseMatrix trans = new LinkedSparseMatrix(columns, rows);    //���������ָ������������
        for (int i=0; i<this.rows; i++)
        {                                                  //�鲢����ӣ���������ĵ�����
            Node<Triple> p=this.list.get(i).head.next;
            while (p!=null)                                //�Գ�Ԫ�ص���Ԫ��item��������ĵ�����
            {
                trans.set(p.data.toSymmetry());            //����q��㲢���뵽front���֮��
                p = p.next;
            }
        }
        return trans;
    }
}

