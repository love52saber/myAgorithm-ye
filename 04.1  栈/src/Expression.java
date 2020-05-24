//����4.2�� ʹ��ջ������ʽ��ֵ��

public class Expression 
{
    public static String toPostfix(String expstr)          //����expstr�ĺ�׺���ʽ
    {
        SeqStack<String> stack = new SeqStack<String>(expstr.length());   //���������ջ��˳��ջ
//        SeqListStack<String> stack = new SeqListStack<String>(expstr.length()); //˳��ջ
        String postfix="";                                 //���غ�׺���ʽ
        int i=0;
        while (i<expstr.length())
        {    
            char ch=expstr.charAt(i);
            switch (ch)
            {
                case '+':                                  //�������������������ջ��Ԫ�رȽ�
                case '-': while (!stack.isEmpty() && !stack.get().equals("("))
                              postfix += stack.pop();
                          stack.push(ch+"");               //��ǰ�������ջ
                          i++; break;
                case '*':                                  //����*��/ �����
                case '/': while (!stack.isEmpty() && (stack.get().equals("*") || stack.get().equals("/")))
                              postfix += stack.pop();
                          stack.push(ch+"");
                          i++; break;
                case '(': stack.push(ch+"");               //���������ţ���ջ
                          i++; break;
                case ')': String out = stack.pop();        //���������ţ���ջ����ջ�շ���null
                          while (out!=null && !out.equals("("))  //�жϳ�ջ�ַ��Ƿ�Ϊ������
                          {
                              postfix += out;
                              out = stack.pop();
                          }
                          i++; break;
                default: while (i<expstr.length() && ch>='0' && ch<='9') //��������ʱ�����뵽��׺���ʽ
                         {
                             postfix += ch;
                             i++;
                             if (i<expstr.length())
                                 ch=expstr.charAt(i);
                         }
                         postfix += " ";                   //��ӿո���Ϊ��ֵ֮��ķָ���
            }
        }
        while (!stack.isEmpty())
            postfix += stack.pop();
        return postfix;
    }
    
    public static int value(String postfix)                //�����׺���ʽ��ֵ
    {
        LinkedStack<Integer> stack = new LinkedStack<Integer>();     //����������ջ����ʽջ
//    	SinglyLinkedStack<Integer> stack = new SinglyLinkedStack<Integer>(); //��ʽջ
        int i=0, result=0;
        while (i<postfix.length())                         //�������׺���ʽ�е��ַ�
        {    
            char ch=postfix.charAt(i);
            if (ch>='0' && ch<='9')                        //���������ַ�
            {
                result=0;
                while (ch!=' ')                            //�ַ���ת��Ϊ��ֵ
                {
                    result = result*10 + Integer.parseInt(ch+"");
                    i++;
                    ch = postfix.charAt(i);
                }
                i++;
                stack.push(new Integer(result));           //��������ջ
            }
            else
            {
                int y=stack.pop().intValue();              //��ջ����������
                int x=stack.pop().intValue();
                switch (ch)                                //����������ֱ����
                {
                    case '+': result=x+y; break;
                    case '-': result=x-y; break;
                    case '*': result=x*y; break;
                    case '/': result=x/y; break;           //����������Ϊ0ʱ���׳��쳣
                }
                stack.push(new Integer(result));           //��������ջ
                i++;
            }
        }
        return stack.pop().intValue();                     //����������
    }
    public static void main(String args[])
    {
        String expstr="121+10*(53-49+20)/((35-25)*2+10)+11";
        String postfix = toPostfix(expstr);
        System.out.println("expstr= "+expstr);
        System.out.println("postfix= "+postfix);
        System.out.println("value= "+value(postfix));
    }    
}
/*
�������н�����£�
expstr= 121+10*(53-49+20)/((35-25)*2+10)+11
postfix= 121 10 53 49 -20 +*35 25 -2 *10 +/+11 +
value= 140


expstr= 121+10*(53-49+20)/((35-25)*2+10)+11/0
postfix= 121 10 53 49 -20 +*35 25 -2 *10 +/+11 0 /+
Exception in thread "main" java.lang.ArithmeticException: / by zero
	at Expression.value(Expression.java:79)
	at Expression.main(Expression.java:93)

*/