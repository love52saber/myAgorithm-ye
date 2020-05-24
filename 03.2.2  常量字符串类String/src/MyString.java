//3.2.2  �������Ļ���������//JDK 1.6

import java.io.Serializable;                     //���л�
import java.util.Arrays;                         //ʵ�ð��е�������

public final class MyString implements Comparable<MyString>,java.io.Serializable
{
    private final char[] value;                  //�ַ����飬˽�����ձ�����ֻ�ܸ�ֵһ��

    public MyString()                            //����һ���մ�??
    {
        this.value = new char[0];
    }    
    public MyString(java.lang.String original)   //���ַ����������촮����
    {
        this.value = original.toCharArray();     //����ַ����е��ַ�����
    }
    
    public MyString(char[] value, int begin, int count)    //��value�����д�begin��ʼ��count���ַ����촮����
    {
//        this.value = value;                    //�������ø�ֵ
        this.value = new char[count];            //��value==nullʱ��Java�׳��ն����쳣
        for (int i=begin; i<begin+count; i++)    //��������
            this.value[i] = value[i];
//        java.lang.System.arraycopy(value,0,this.value,0,value.length);  //�������飬����for���
//        this.value = java.util.Arrays.copyOf(value,value.length);       //�������飬������������ռ�
    }
    
    public MyString(char[] value)                //��value�������ַ����촮����
    {
        this(value, 0, value.length);
    }

    public MyString(MyString str)                //�������췽�������ƶ���
    {
        this(str.value);
    }

    public int length()                          //�����ַ����ĳ���
    {
        return this.value.length;
    }

    public char charAt(int i)                    //���ص�i��i��0�����ַ�
    {
        if (i<0 || i >= this.value.length)
            throw new StringIndexOutOfBoundsException(i);  //�׳��ַ������Խ���쳣
        return this.value[i]; 
    }

    public java.lang.String toString() 
    {
        return new String(this.value);           //java.lang.Stringʵ��Ϊ return this;
    }

    public MyString concat(MyString str)         //���ص�ǰ����ָ����str�������ɵ��´������ı䵱ǰ��
    {
        if (str.length()==0)                     //�����ӵĴ�Ϊ��ʱ�����ص�ǰ��
            return this;
        char[] buffer = new char[this.value.length+str.length()];
        int i;
        for (i=0; i<this.value.length; i++)      //���Ƶ�ǰ��
            buffer[i] = this.value[i];
        for (int j=0; j<str.value.length; j++)   //����ָ����str
            buffer[i+j] = str.value[j];
        return new MyString(buffer);             //���ַ����鹹�촮����
    }

    public MyString substring(int begin, int end)//���ش�����Ŵ�begin��end-1���Ӵ�
    {
        if (begin<0) 
            begin=0;                             //����ݴ�
        if (end>this.value.length) 
            end=this.value.length; 
        if (begin==0 && end==this.value.length) 
            return this;
        if (begin>end) 
            throw new StringIndexOutOfBoundsException(end-begin);      
        char[] buffer = new char[end-begin];
        for (int i=0; i<buffer.length; i++) 
            buffer[i] = this.value[i+begin];
        return new MyString(buffer);             //���ַ����鹹�촮����
    }
    public MyString substring(int begin)         //���ش�����Ŵ�begin����β���Ӵ�
    {
        return substring(begin, this.value.length);
    }

    //�Ƚϵ�ǰ���Ƿ���obj���õĴ���� ������Object���equals(obj)����
    public boolean equals(Object obj)
    {
        if (this==obj)
            return true;
        if (obj instanceof MyString)
        {
            MyString str=(MyString)obj;
            if (this.value.length == str.value.length)
            {
                for (int i=0; i<this.value.length; i++)
                    if (this.value[i]!=str.value[i])
                        return false;
                return true;
            }
        }
        return false;
    }    
    
    //�Ƚϵ�ǰ����str���Ĵ�С���������߲�ֵ��ʵ��Comparable�ӿ�
    public int compareTo(MyString str)
    {
        for (int i=0; i<this.value.length && i<str.value.length; i++)
            if (this.value[i]!=str.value[i])
                return this.value[i] - str.value[i];       //����������һ����ͬ�ַ��Ĳ�ֵ
        return this.value.length - str.value.length;       //ǰ׺�Ӵ��������������ȵĲ�ֵ
    }
    
    //3.3   ����ģʽƥ��
    //3.3.1   ���ص�ģʽƥ�䣨Brute-Force���㷨
    //����ģʽ��pattern�ڵ�ǰ��this��Ŀ�괮target���д�begin��ʼ���״�ƥ��λ�ã�ƥ��ʧ��ʱ����-1
    int count=0;                                           //���رȽϴ���
    public int indexOf(MyString pattern, int begin)
    {
        if (pattern.length()>0 && this.length()>=pattern.length())
        {                                                  //��Ŀ�괮��ģʽ����ʱ���бȽ�
            int i=begin, j=0;                              //i��j�ֱ�ΪĿ�괮��ģʽ����ǰ�ַ����±�
            count=0;   
            while (i<this.length())
            {
                if (this.charAt(i)==pattern.charAt(j))     //����ǰ���ַ���ȣ�������ȽϺ����ַ�
                {
                    i++;
                    j++;
                }
                else                                       //����i��j���ݣ�������һ��ƥ��
                {
                    i=i-j+1;                               //Ŀ�괮�±�i�˻ص���һ����ƥ���Ӵ����ַ�
                    j=0;                                   //ģʽ���±�j�˻ص�0
                }
                count++;
                if (j==pattern.length())                   //һ��ƥ�������ƥ��ɹ�
                    return i-j;                            //����ƥ����Ӵ����
            }
        }
        return -1;                                         //ƥ��ʧ��ʱ����-1
    }
    //����ģʽ��pattern�ڵ�ǰ���е��״�ƥ��λ�ã�ƥ��ʧ��ʱ����-1
    public int indexOf(MyString pattern)
    {
        return this.indexOf(pattern, 0);
    }

    //2.  ģʽƥ��Ӧ��
    //���ؽ���ǰ�����׸���patternƥ����Ӵ��滻��replacement���ַ���
    public MyString replaceFirst(MyString pattern, MyString replacement)
    {
        int i=this.indexOf(pattern,0);                     //����ƥ���Ӵ�����ţ���0��ʼ����  
        if (i==-1)
            return this;                                   //ƥ��ʧ��ʱ���ص�ǰ��
        return this.substring(0,i).concat(replacement).concat(this.substring(i+pattern.length()));//����3����
    }

    //���ؽ���ǰ����������patternƥ����Ӵ�ȫ���滻��replacement���ַ���
    public MyString replaceAll(MyString pattern, MyString replacement)
    {
        MyString temp = new MyString(this);                //�������췽�������Ƶ�ǰ��
        int i=this.indexOf(pattern,0);
        while (i!=-1)
        {
            temp = temp.substring(0,i).concat(replacement).concat(temp.substring(i+pattern.length()));
            i=temp.indexOf(pattern, i+replacement.length());//����һ���ַ���ʼ�ٴβ���ƥ���Ӵ�
//            i=temp.indexOf(pattern, i+1);                  	//��
        }
        return temp;
    } 

    //ϰ��3
    public int indexOf(char ch)                       	   //����ch�ַ��ڵ�ǰ�����״γ��ֵ����
    {
        for (int i=0; i<this.value.length; i++)
            if (this.value[i]==ch)
                return i;
        return -1;
    }
    
    public MyString toLowerCase()                          //�����еĴ�д��ĸȫ��ת���ɶ�Ӧ��Сд��ĸ
    {
        char temp[]=new char[this.value.length];
        for (int i=0; i<this.value.length; i++)
            if (this.value[i]>='A' && this.value[i]<='Z')  //��д��ĸ
                temp[i]=(char)(this.value[i]+'a'-'A');     //ת���ɶ�ӦСд��ĸ
        return new MyString(temp);
    }
    public MyString toUpperCase()                          //�����е�Сд��ĸȫ��ת���ɶ�Ӧ�Ĵ�д��ĸ
    {
        char temp[]=new char[this.value.length];
        for (int i=0; i<this.value.length; i++)
            if (this.value[i]>='a' && this.value[i]<='z')  //Сд��ĸ
                temp[i]=(char)(this.value[i]-('a'-'A'));   //ת���ɶ�Ӧ��д��ĸ
        return new MyString(temp); 
    }    
    public char[] toCharArray()                            //�����ַ�����
    {
        char[] temp = new char[this.value.length];
        for (int i=0; i<temp.length; i++)                  //��������
        	temp[i] = this.value[i];
        return temp;
    }
        
    public boolean startsWith(MyString prefix)   //�ж�prefix�Ƿ�ǰ׺�Ӵ�
    {
        if (this.value.length<prefix.value.length)
            return false;
        for (int i=0; i<prefix.value.length; i++)
            if (this.value[i]!=prefix.value[i])
                return false;
        return true;
    }
    public boolean endsWith(MyString suffix)     //�ж�suffix�Ƿ��׺�Ӵ�
    {
        int j=suffix.value.length-1;
        for (int i=this.value.length-1; i>=0 && j>=0; i--,j--)
            if (this.value[i]!=suffix.value[j])
                return false;
        return j==-1;
    }
    
    public boolean equalsIgnoreCase(MyString str)     //�Ƚϵ�ǰ����str���Ƿ���ȣ�������ĸ��Сд
    {
        if (this==str)
            return true;
        if (this.value.length==str.value.length)
        {
            for (int i=0; i<this.value.length; i++)
            {
                int c1=this.value[i];
                if (c1>='a' && c1<='z') 
                    c1 -= 'a'-'A';
                int c2=str.value[i];
                if (c2>='a' && c2<='z') 
                    c2 -= 'a'-'A';
                if (c1!=c2)
                    return false;
            }
            return true;
        }
        return false;
    }    
    
    public int compareToIgnoreCase(MyString str)       //�Ƚ���������С��������ĸ��Сд
    {
        for (int i=0; i<this.value.length && i<str.value.length; i++)
        {
            int c1=this.value[i];
            if (c1>='a' && c1<='z') 
                c1 -= 'a'-'A';
            int c2=str.value[i];
            if (c2>='a' && c2<='z') 
                c2 -= 'a'-'A';
            if (c1!=c2)
                return this.value[i]-str.value[i];
        }
        return this.value.length-str.value.length;
    }

    public MyString trim()                        	       //����ɾ�����пո����ַ���
    {
        char temp[]=new char[this.value.length];
        int j=0;
        for (int i=0; i<this.value.length; i++)
            if (this.value[i]!=' ')
                temp[j++]=this.value[i];
        return new MyString(temp,0,j);                     //��temp�����д�0��ʼ��j���ַ����촮����
    }

}
/*
ϰ��3 δ���
public int indexOf(char ch, int begin)              	//����ch��begin��ʼ�״γ��ֵ����
public int lastIndexOf(char ch)                   	//����ch�ڵ�ǰ���������ֵ����
public int lastIndexOf(char ch, int begin)           	//����ch��begin��ʼ�����ֵ����
public MyString replace(char old, char newc)      	//����������old�ַ��滻Ϊnewc�ַ�
public int lastIndexOf(String pattern)             	//����pattern���ƥ��λ�õ����
public int lastIndexOf(String pattern, int begin)
              //����ģʽ��pattern�ڵ�ǰ���д�begin��ʼ���������һ��ƥ��λ�õ����
 * */
