//����10.1��  �绰����
//��	TelephoneBookTreeSet��ʵ�ֵ绰���Ĵ洢�͹���

//�Զ����������࣬�̳�TreeSet<Friend>�࣬�洢�绰���е�Friend�����ṩ���Ҷ����ܡ�
//����һ�������ļ����ṩ��д�����ļ����ܡ�
//���в��ҡ���д�ļ����㷨�����ڻ��ڵ����������м��ϡ�

import java.util.*;
import java.io.*;

public class PhoneBookTreeSet extends TreeSet<Friend>
{
    private String filename;                          //�ļ���

    public PhoneBookTreeSet(String filename)          //���췽��������ָ���ļ���
    {
        super();                                      //����ռ���new TreeSet<Friend>()��Ĭ����Comparable�ӿ��ṩ�������
        this.filename = filename;
        this.readFromFile();                          //��ָ���ļ��ж�ȡ������ӵ�������
    }
  
    private void readFromFile()                       //��ָ���ļ��ж�ȡ������ӵ�������
    {
        try
        {   FileInputStream fin=new FileInputStream(this.filename);  //�ļ��ֽ�������
            ObjectInputStream objin=new ObjectInputStream(fin);      //�����ֽ�������
            while (true)                              //������δ����ʱ
                try
                {
                	this.add((Friend)objin.readObject());  //��ȡһ��������ӵ�����
                }
                catch (Exception e)                   //����ClassNotFoundException��EOFException�쳣
                {   break;
                }
            objin.close();                            //�ȹرն�����
            fin.close();                              //�ٹر��ļ���
//            System.out.println();
        }
        catch (IOException ioe){}                     //ָ���ļ�������ʱ������Ϊ��
    }
    
    public void writeToFile()                         //�����������ж���д��ָ���ļ������ļ������ڣ������ļ�
    {
        if (!this.isEmpty())
            try
            {   FileOutputStream fout=new FileOutputStream(this.filename); //�ļ��ֽ������
                ObjectOutputStream objout=new ObjectOutputStream(fout);    //�����ֽ������
                Iterator<Friend> it = this.iterator();
                while (it.hasNext())
                {
                    Friend f =it.next();
                    System.out.println(f.name+" "+(int)f.name.charAt(0)+" "+f.phonecode);
                    objout.writeObject(f);    //д��һ������
//              	objout.writeObject(it.next());    //д��һ������
                }
                objout.close();
                fout.close();
                System.out.println();
            }
            catch (IOException ioe){}
    }

    //����x���󣬷����״γ��ֵĶ����ɱȽ���cָ���ȽϹ���
    public Friend search(Friend x, Comparator<Friend> c)
    { 
        Iterator<Friend> it = this.iterator();
        while (it.hasNext())                          //δ�ҵ����к��Ԫ��ʱ����
        {
            Friend f = it.next();
            if (c.compare(f,x)==0)                    //�ɱȽ���cָ���ȽϹ���
                return f;
        }
        return null;                                  //δ�ҵ�ʱ����null����ʱ�Ƚ�������Ԫ��
    }
}
