//�ַ���������������

public interface SString
{
    int length();                                //�����ַ�������
    char charAt(int i);                          //���ص�i��i��0�����ַ�
    SString concat(SString str);                 //���ص�ǰ����str���������ɵ��´�
    SString substring(int begin, int end);       //���ش����ַ���Ŵ�begin��end-1���Ӵ�
    int indexOf(SString pattern);                //����pattern���������еĵ�һ��ƥ��λ��
}
