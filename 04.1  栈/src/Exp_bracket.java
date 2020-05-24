//����4.1�� �жϱ��ʽ��Բ�����Ƿ�ƥ�䡣

public class Exp_bracket
{
    //�ж�expstr���ʽ�е�Բ�����Ƿ�ƥ�䣬��ƥ�䣬���ؿմ������򷵻ش�����Ϣ
    public static String isValid(String expstr)
    {
//        SeqListStack<String> stack = new SeqListStack<String>(expstr.length()); //˳��ջ
        SeqStack<String> stack = new SeqStack<String>(expstr.length());  //˳��ջ
//        LinkedStack<String> stack = new LinkedStack<String>();           //��ʽջ
//    	SinglyLinkedStack<String> stack = new SinglyLinkedStack<String>(); //��ʽջ
        
        for (int i=0; i<expstr.length(); i++)
        {    
            char ch=expstr.charAt(i);
            switch(ch)
            {
                case '(': stack.push(ch+"");               //��������ջ
                          break;
                case ')': if (stack.isEmpty() || !stack.pop().equals("("))  //����������ʱ����ջ
                              return "����(";              //�жϳ�ջ�ַ��Ƿ�Ϊ������
            }    
        }
        return (stack.isEmpty()) ? "" : "����)";           //���ؿմ���ʾû�д���
    }    

    public static void main(String args[])
    {
        String expstr="((1+2)*3+4))("; 
        System.out.println(expstr+"  "+isValid(expstr));
    }
}

/*
����������ʱ����expstr�ֱ��ʾ��ͬ�ı��ʽ�ַ��������н�����£�
((1+2)*3+4) 
((1+2)*3+4  ����)
((1+2)*3+4))(  ����(

*/