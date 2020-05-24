//5.2.2 ϡ������ѹ���洢
//2.  ϡ�������Ԫ��˳���

public class SeqSparseMatrix                               //��Ԫ��˳��洢��ϡ������� 
{
    private int rows, columns;                             //��������������
    private SeqList<Triple> list;                          //ϡ�������Ԫ��˳���

    public SeqSparseMatrix(int rows, int columns)          //����rows��columns�������
    {
        if (rows<=0 || columns<=0)
            throw new IllegalArgumentException("����������������������"); //�׳���Ч�����쳣
        this.rows = rows;
        this.columns = columns;
        this.list = new SeqList<Triple>();                 //�����˳���ִ��SeqList()���췽��
    }
    //����rows��columns�о�������Ԫ������elems�ṩ�����ֵ
    public SeqSparseMatrix(int rows, int columns, Triple[] elems)
    {
        this(rows, columns);
        for (int i=0; i<elems.length; i++)
            this.set(elems[i]);                            //�����������һ��Ԫ�ص���Ԫ��
    }
    
    //���ؾ����i�е�j��Ԫ�أ�����˳����˳������㷨��O(n)
    public int get(int i, int j)
    {
    	if (i<0 || i>=rows || j<0 || j>=columns) 
            throw new IndexOutOfBoundsException("����Ԫ�ص��л������Խ��");
        Triple item = new Triple(i,j,0);
        int k=0;
        Triple elem = this.list.get(k);
        while (k<this.list.length() && item.compareTo(elem)>=0) //������˳���list��˳�����item����
        {
            if (item.compareTo(elem)==0)                   //ֻ�Ƚ���Ԫ��Ԫ��λ�ã���elem.row==i && elem.column==j
                return elem.value;                         //���ҵ�(i,j)�����ؾ���Ԫ��
            k++;                                           //item����ʱ�����
            elem = this.list.get(k);
        }
        return 0;                                          //û���ҵ�ʱ����0
    }

    public void set(Triple elem)                           //����Ԫ�����þ���Ԫ��
    {
        this.set(elem.row, elem.column, elem.value);
    }
    //���þ����row�е�column�е�Ԫ��ֵΪvalue����������������˳���list�и��Ļ����һ��Ԫ�ص���Ԫ�飬O(n) 
    public void set(int row, int column, int value)
    {
        if (value==0) 
            return;                                        //���洢ֵΪ0Ԫ��
        if (row>=this.rows || column>=this.columns) 
            throw new IllegalArgumentException("��Ԫ����л������Խ��");

        Triple elem = new Triple(row,column,value);
        int i=0;
        while (i<this.list.length())                       //���������Ԫ��˳����в���elem���󣬻���Ļ����
        {
            Triple item = this.list.get(i);
            if (elem.compareTo(item)==0)                   //��elem���ڣ�����ĸ�λ�þ���Ԫ��
            {
                this.list.set(i, elem);                    //����˳����i��Ԫ��Ϊelem
                return;
            }
            if (elem.compareTo(item)>=0)
                i++;                                       //elem�ϡ���ʱ�����
            else break;
        }
        this.list.insert(i, elem);                         //����elem������Ϊ˳����i��Ԫ��
    }

    public String toString()                               //����ϡ�������Ԫ��˳����ϡ����������ַ���
    {
        String str="��Ԫ��˳���"+ this.list.toString()+"\n";
        str+="ϡ�����"+this.getClass().getName()+"��"+rows+"��"+columns+"����\n";
        int k=0;
        Triple elem = this.list.get(k++);                  //���ص�k��Ԫ�أ���kָ�������Ч�򷵻�null
        for (int i=0; i<this.rows; i++)
        {
            for (int j=0; j<this.columns; j++)
               if (elem!=null && i==elem.row && j==elem.column)
               {
                   str += String.format("%4d",elem.value);
                   elem = this.list.get(k++);
               }               
               else
                   str += String.format("%4d",0);
            str += "\n";
        }
        return str;
    }

    //���ص�ǰ������smat��ӵľ���smatc=this+smat�����ı䵱ǰ�����㷨ͬ��������ʽ���
    public SeqSparseMatrix plus(SeqSparseMatrix smat)
    {
        if (this.rows!=smat.rows || this.columns!=smat.columns)
            throw new IllegalArgumentException("�������������ͬ���������");

        SeqSparseMatrix smatc=new SeqSparseMatrix(this.rows, this.columns);   //����rows��columns�����
        int i=0, j=0;
        while (i<this.list.length() && j<smat.list.length())//�ֱ�������������˳���
        {
            Triple elema = this.list.get(i);
            Triple elemb = smat.list.get(j);
            if (elema.compareTo(elemb)==0)                 //��������Ԫ���ʾ��ͬλ�õľ���Ԫ�أ����ӦԪ��ֵ���
            {
                if (elema.value+elemb.value!=0)            //��ӽ����Ϊ0�����½�Ԫ��
                    smatc.list.append(new Triple(elema.row, elema.column, elema.value+elemb.value));
                i++;
                j++;
            }
            else if (elema.compareTo(elemb)<0)             //����С��Ԫ�鸴����ӵ�smatc˳������
            {
                smatc.list.append(new Triple(elema));      //����elemaԪ��ִ��Triple�������췽��
                i++;
            }
            else
            {
                smatc.list.append(new Triple(elemb));
                j++;
            }
        }
        while (i<this.list.length())                       //����ǰ����˳����ʣ����Ԫ�鸴����ӵ�smatc˳������
            smatc.list.append(new Triple(this.list.get(i++)));
        while (j<smat.list.length())                       //��smat��ʣ����Ԫ�鸴����ӵ�smatc˳������
            smatc.list.append(new Triple(smat.list.get(j++)));
        return smatc;                                      //���ض�������
    }

    //ϰ��5
    /*  ���У�Ч�ʵͣ����ڲ���get(i,j)�����Ƿ���ȷ
    public String toString()                               //����ϡ�������Ԫ��˳����ϡ����������ַ���
    {
        String str="��Ԫ��˳���"+ this.list.toString()+"\n";
        str+="ϡ�����"+this.getClass().getName()+"��"+rows+"��"+columns+"����\n";
        for (int i=0; i<this.rows; i++)
        {
            for (int j=0; j<this.columns; j++)
                str += String.format("%4d", this.get(i,j));
            str += "\n";
        }
        return str;
    }*/
    
    //��ǰ������smat������ӣ�this+=smat���ı䵱ǰ�����㷨ͬ��������ʽ���
    public void add(SeqSparseMatrix smat)
    {
        if (this.rows!=smat.rows || this.columns!=smat.columns)
            throw new IllegalArgumentException("�������������ͬ���������");
  
        int i=0, j=0;
        while (i<this.list.length() && j<smat.list.length())
        {                                                  //��mat�ĸ���Ԫ�����β��루����ӣ�����ǰ������Ԫ��˳�����
            Triple elema = this.list.get(i);
            Triple elemb = smat.list.get(j);
            if (elema.compareTo(elemb)==0)
            {                                              //��������Ԫ���ʾ��ͬλ�õľ���Ԫ�أ����ӦԪ��ֵ���
                if (elema.value+elemb.value!=0)            //��ӽ����Ϊ0�����½�Ԫ��
                    this.list.set(i++, new Triple(elema.row, elema.column, elema.value+elemb.value));
                else
                    this.list.remove(i);
                j++;
            }
            else if (elema.compareTo(elemb)<0)              //�������Ѱ��elembԪ�صĲ���λ��
                     i++;
                 else
                 {
                     this.list.insert(i++, new Triple(elemb));//����elembԪ�ز�����Ϊthis.list�ĵ�i��Ԫ��
                     j++;
                 }
        }
        while (j<smat.list.length())                       //��mat��ʣ����Ԫ�����θ��Ʋ��뵱ǰ������Ԫ��˳�����
             this.list.append(new Triple(smat.list.get(j++)));
    }
    
    public SeqSparseMatrix(SeqSparseMatrix smat)           //���
    {
        this(smat.rows, smat.columns);
        this.list = new SeqList<Triple>();                 //������˳���Ĭ������
        for (int i=0; i<smat.list.length(); i++)           //����smat��������Ԫ�����
            this.list.append(new Triple(smat.list.get(i)));
    }
    /*Ҳ��
    public SeqSparseMatrix(SeqSparseMatrix smat)           //���
    {
        this(smat.rows, smat.columns);
        this.add(smat);
    }*/
    
    //Ҳ�ɣ��㷨Ч�ʵ�
    //���ص�ǰ������smat��Ӻ�ľ���smatc=this+smat�����ı䵱ǰ�����㷨ͬ��������ʽ���
/*    
    public SeqSparseMatrix plus(SeqSparseMatrix smat)
    {
        SeqSparseMatrix smatc=new SeqSparseMatrix(this);   //���
        smatc.add(smat);
        return smatc;                                      //���ض�������
    }
*/     
    public boolean equals(Object obj)                      //�Ƚ����������Ƿ����
    {
        if (this==obj)
            return true;
        if (!(obj instanceof SeqSparseMatrix))
            return false;
        SeqSparseMatrix smat=(SeqSparseMatrix)obj;        
        return this.rows==smat.rows && this.columns==smat.columns && this.list.equals(smat.list);
                                                           //�Ƚ�������Ԫ��˳����Ƿ����
    }    
    
    public SeqSparseMatrix transpose()                     //����ת�þ���
    {
        SeqSparseMatrix trans = new SeqSparseMatrix(columns, rows);    //���������ָ������������
        for (int i=0; i<this.list.length(); i++)
            trans.set(this.list.get(i).toSymmetry());      //�������Գ�λ��Ԫ�ص���Ԫ��
        return trans;
    }

}
/*
    ��֧��
    public SeqSparseMatrix()
    {
        this(10, 10);
    }


*/
