//3.2.3 �������Ĳ���ʵ��
//1.  StringBuffer������

import java.io.Serializable;                               //���л�
public final class MyStringBuffer implements java.io.Serializable //�ַ�����
{
    private char[] value;                                  //�ַ����飬˽�г�Ա����
    private int len;                                       //������

    public MyStringBuffer(int size)                        //����ָ�������Ŀմ�
    {
        this.value = new char[size<32 ? 32 : size];
        this.len = 0;
    }
    
    public MyStringBuffer()                                //��Ĭ����������մ�
    {
        this(32);
    }

    public MyStringBuffer(String str)                      //���ַ����������촮����
    {
        this(str.length()*2);
        this.append(str);
    }
    
    public int length()                                    //�����ַ�������
    {
         return this.len;                                  //����value.length����������
    }
    public void setLength(int len)                         //���õ�ǰ�ַ�������Ϊlen
    {
         this.len = len;
    }
    
    public synchronized char charAt(int i)                 //���ص�i��i��0�����ַ�
    {
        if (i<0 || i>=this.len)
            throw new StringIndexOutOfBoundsException(i);
        return this.value[i];
    }
    public void setCharAt(int i, char ch)                  //���õ�i���ַ�Ϊch
    {
        if (i<0 || i>=this.len)
            throw new StringIndexOutOfBoundsException(i);
        this.value[i] = ch;
    }
    
    public synchronized String toString()  
    {
        return new String(this.value, 0, this.len);        //���ַ�����value��0��lenԪ�ع���String��
    }
    
    //2.  ���봮
    public synchronized MyStringBuffer insert(int i, MyStringBuffer str)  //�ڵ�i���ַ�������str��
    {
        if (i<0)  i=0;                                     //����ݴ�
        if (i>this.len) i=this.len;
        char temp[]=this.value;
        if (this.value.length-this.len < str.len)          //����ǰ������ռ䲻�㣬����������
        {
            this.value = new char[this.value.length+str.len*2]; //���������ַ�����ռ�
            for (int j=0; j<i; j++)                        //���Ƶ�ǰ��ǰi-1���ַ�
                this.value[j] = temp[j];
        }
        for (int j=i; j<this.len; j++)
            this.value[str.len+j] = temp[j];               //��i��ʼ����ƶ�n���ַ�
        for (int j=0; j<str.len; j++)                      //�����ַ���str
            this.value[i+j] = str.value[j];
        this.len += str.len;
        return this;
    }

    public synchronized MyStringBuffer insert(int i, String str)     //�ڵ�i���ַ�������str��
    {
        if (i<0)  i=0;                                     //����ݴ�
        if (i>this.len) i=this.len;
//        if (i<0 || i>len)
//            throw new StringIndexOutOfBoundsException(i);
        char temp[]=this.value;
        if (this.value.length-this.len < str.length())     //����ǰ��������ռ䲻�㣬����������
        {
            this.value = new char[this.value.length+str.length()*2]; //���������ַ�����ռ�
            for (int j=0; j<i; j++)                        //���Ƶ�ǰ��ǰi-1���ַ�
                this.value[j] = temp[j];
        }
        for (int j=this.len-1; j>=i; j--)
            this.value[str.length()+j] = temp[j];          //��i��ʼ����ƶ�n���ַ�
        for (int j=0; j<str.length(); j++)                 //�����ַ���str
            this.value[i+j] = str.charAt(j);
        this.len += str.length();
        return this;
    }

    public synchronized MyStringBuffer insert(int i, boolean b)      //��i���������ֵת���ɵĴ�
    {
        return this.insert(i, b ? "true" : "false");
    }
    public synchronized MyStringBuffer append(String str)            //���ָ����
    {
        return this.insert(this.len, (str==null) ? "null" : str);
    }

    //3.  ɾ���Ӵ�
    public synchronized MyStringBuffer delete(int begin, int end)  //ɾ����begin��end-1���Ӵ�
    {
        if (begin < 0)                                     //����ݴ�
            begin=0;                                       //�Ӵ��׿�ʼɾ��
        if (end > this.len)
            end = this.len;                                //ɾ������β���Ӵ�
        if (begin > end)
            throw new StringIndexOutOfBoundsException(end - begin);
        for(int i=0; i<this.len-end; i++)                  //��end��ʼ����β���Ӵ���ǰ�ƶ�
            this.value[begin+i] = this.value[end+i];
        this.len -= end-begin;
        return this;
    }
    
    //ϰ��3    
    public MyStringBuffer reverse()                        //����ǰ����ת������
    {
        for (int i=0; i<this.len/2; i++)
        {
   	        char temp = value[i];
   	        value[i] = value[this.len-i-1];
            value[this.len-i-1] = temp;
        }
        return this;
    }
    
}

/*
ϰ��3��δ���
public String substring(int begin)                //���ش�begin����0����ʼ����β���Ӵ�
public String substring(int begin, int end)  //���ش�begin��ʼ��end-1���Ӵ�
public StringBuffer deleteCharAt(int i) //ɾ����i���ַ�

    //�����д�begin��end-1���Ӵ��滻Ϊstr��
    public MyStringBuffer replace(int begin, int end, String str) 
    {
        if (begin < 0)
            throw new StringIndexOutOfBoundsException(begin);
        if (begin > this.len)
            throw new StringIndexOutOfBoundsException("begin > length()");
        if (begin > end)
            throw new StringIndexOutOfBoundsException("begin > end");
        if (end > this.len)
            end = this.len;
        
        System.arraycopy(value, end, value, begin + len, count - end);
        str.getChars(value, begin);
        count = newCount;
        return this;

        char temp[]=this.value;
        if (this.value.length-this.len < str.length() - (end - begin))     //����ǰ��������ռ䲻�㣬����������
        {
            this.value = new char[this.value.length+str.length()*2]; //���������ַ�����ռ�
            for (int j=0; j<i; j++)                        //���Ƶ�ǰ��ǰi-1���ַ�
                this.value[j] = temp[j];
        }
        for (int j=this.len-1; j>=i; j--)
            this.value[str.length()+j] = temp[j];          //��i��ʼ����ƶ�n���ַ�
        for (int j=0; j<str.length(); j++)                 //�����ַ���str
            this.value[i+j] = str.charAt(j);
        this.len += str.length();
        return this;
    }

*/