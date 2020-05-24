//����10.1��  �绰����
//��	Friend���ʾ�绰���еĶ���

public class Friend implements java.lang.Comparable<Friend>, java.util.Comparator<Friend>, java.io.Serializable  //ʵ�ֿɱȽϺ����л��ӿ�
{
    String name, phonecode;                           //�������绰���룬ȱʡȨ�ޣ���ǰ���ɼ�

    public Friend(String name, String phonecode)      //���췽����ָ�������͵绰����
    {
        this.name = name;
        this.phonecode = phonecode;
    }
    public String toString() 
    {
        return this.name+"��"+this.phonecode;
    }
    public Object[] toArray()                         //���ذ����������г�Ա����������
    {
        Object[] vars = new Object[2];
        vars[0] = this.name;
        vars[1] = this.phonecode;
        return vars;
    }
    public String index()                             //��������
    {
        return this.name.substring(0,1);              //������Ϊ����
    }
    public int compareTo(Friend f)                    //�Ƚ����������С��ʵ��Comparable�ӿ�
    {                                                 //ָ�����������绰�����������
        if (this.name.compareTo(f.name)!=0)     
            return this.name.compareTo(f.name);       //�Ƚ������ַ���
        return this.phonecode.compareTo(f.phonecode); //������ͬʱ��ͬһ�ˣ��ٱȽϵ绰����
    }
    public int compare(Friend f1, Friend f2)          //�Ƚ����������С��ʵ��Comparator�ӿ�
    {
        return f1.name.compareTo(f2.name);            //�Ƚ�����
    }
}

//CodeComparator��ʵ�ֱȽ����ӿڣ��ṩFriend���绰����ȽϵĹ���
class CodeComparator implements java.util.Comparator<Friend>
{
    public int compare(Friend f1, Friend f2) 
    {
        return f1.phonecode.compareTo(f2.phonecode);  //�Ƚϵ绰�����ַ���
    }
}
//IndexComparator��ʵ�ֱȽ����ӿڣ��ṩFriend�����ϱȽϵĹ���
class IndexComparator implements java.util.Comparator<Friend>
{
    public int compare(Friend f1, Friend f2) 
    {
        return f1.index().compareTo(f2.index());      //�Ƚ������ַ���
    }
}

/*
�������˵�����¡�
 *����������Ƚ��������������£���绰���в������һ���˵������绰����
    public int compareTo(Friend f)                         //�Ƚ���������
    {                                                      //ָ���������Ȼ����
        return this.name.compareTo(f.name);
    }

//���·���δ��
    public boolean equals(Object obj)                      //����Object���з���
    {
        if (this==obj)
        	return true;        	
        if (obj instanceof Friend)                         //�жϵ�ǰ�����Ƿ�����Friend��
        {
            Friend f = (Friend)obj;
            return this.name.equals(f.name) && this.phonecode.equals(f.phonecode);
        }
        return false;
    }
*/

