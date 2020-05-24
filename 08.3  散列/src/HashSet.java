//8.3   ɢ��
//8.3.4   ��������ַ����ɢ�б�
//��������ַ����ɢ�б��࣬�������롢ɾ�������ҡ������Ȳ�����
//public class HashSet<T>                                  //��������ַ����ɢ�б��࣬8.3 ɢ��
public class HashSet<T> extends AbstractCCollection<T>     //��10�£�10.2 ʵ�ֵ����� 
{
    private SinglyLinkedList<T>[] table;                   //ɢ�б�ͬ��ʵ������������
//    private int count;                                       //ɢ�б�Ԫ�ظ���

    public HashSet(int length)                             //����ָ��������ɢ�б�
    {
        this.table = new SinglyLinkedList[Math.abs(length)];
        for (int i=0; i<table.length; i++)
            table[i] = new SinglyLinkedList<T>();          //����յ�����
//        this.len=0;
    }
    public HashSet()                                       //����Ĭ��������ɢ�б�
    {
        this(97);                                          //Ĭ��97��100���ڵ��������
    }

    //ɢ�к�����ȷ���ؼ���ΪkeyԪ�ص�ɢ�е�ַ����x==null�����׳��ն����쳣
    private int hash(T x)
    {
        int key = Math.abs(x.hashCode());                  //ÿ�������hashCode()��������int
        return key % table.length;                         //������������������ɢ�б���
    }
    
    public void insert(T x)                                //����xԪ��
    {
        if (search(x)==null)                               //������ؼ����ظ�Ԫ��
    	    table[hash(x)].insert(0, x);                   //������Ϊͬ��ʵ�����ĵ�һ�����
        
//        this.len++;
    } 
    public void remove(T x)                                //ɾ��xԪ��
    {
        table[hash(x)].remove(x);                          //��ͬ��ʵ�������ɾ��xԪ�ؽ��
//        this.len--;
    }

    public T search(T key)                            //���ز��ҵ��Ĺؼ���ΪkeyԪ�أ������Ҳ��ɹ�����null
    {
        return table[hash(key)].search(key);          //��ͬ��ʵ������в��ҹؼ���ΪkeyԪ��
    }
    public boolean contain(T key)                     //�ж�ɢ�б��Ƿ�����ؼ���ΪkeyԪ��
    {
        return this.search(key)!=null;
    }
    public String toString()                          //����ɢ�б�����Ԫ�ص������ַ���
    {
        String str="";
        for (int i=0; i<table.length; i++)            //������ͬ��ʵ�����
            if (!table[i].isEmpty())
                str += table[i].toString()+"\n";
        return str;
    }

    //��10�£�10.2 ʵ�ֵ�����
    public java.util.Iterator<T> iterator()                //����Java����������
    {
        return new HashSetIterator();
    }

    private class HashSetIterator implements java.util.Iterator<T> //˽���ڲ��࣬ʵ�ֵ������ӿ�
    {
    	private int index=0;                               //��ǰ���������
        private java.util.Iterator<T> it;                  //���������������

    	public HashSetIterator()
    	{
    		this.index=0;
    		this.it=table[index].iterator();               //��õ�һ��������ĵ���������
    	}
        public boolean hasNext()                           //���к��Ԫ�أ�����true
        {
            if (this.it.hasNext())
        	    return this.it.hasNext();                  //
            int i=this.index+1;
            while (i<table.length)                         //lenɢ�б�Ԫ�ظ���
            {
            	if (table[i].iterator().hasNext())
    	            return true;    //�����һ��������ĵ���������
            	i++;
            }
            return false;
        }

        public T next()                                    //���غ��Ԫ��
        {
            if (this.it.hasNext())
        	    return this.it.next();                     //���ص�ǰ������ǰ���ĺ��Ԫ��
            this.index++;
            while (this.index<table.length)                             //lenɢ�б�Ԫ�ظ���
            {
        		this.it=table[this.index].iterator();               //�����һ��������ĵ���������
                if (this.it.hasNext())
            	    return this.it.next();                     //
                this.index++;
            }
            return null;
        }

        public void remove()                   
        {
            throw new UnsupportedOperationException();  //��֧�ָò������׳��쳣
        }
    }
    
    public int length()                          //���ؼ���Ԫ�ظ��������󷽷�
    {
        return 0;
    }
    
}
