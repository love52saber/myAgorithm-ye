//����ӿڣ�Ϊʵ�־�������Լ����������
//û�о���ADT

public interface MMatrix                         //����ӿ�
{
    //���췽��
	public int get(int i, int j);                //���ؾ����i�е�j��Ԫ��ֵ
    public void set(int i, int j, int value);    //���þ����i�е�j�е�Ԫ��ֵΪvalue
    //String toString();
    public void add(MMatrix mat);                //������ӣ�this+=mat������ӦԪ����ӣ��ı�this����

    //ϰ��5
    //���
    public boolean equals(Object obj);
    public MMatrix plus(MMatrix mat);            //����this��mat��Ӻ�ľ��󣬲��ı�this����
    public MMatrix transpose();                  //���ص�ǰ�����ת�þ���
}
