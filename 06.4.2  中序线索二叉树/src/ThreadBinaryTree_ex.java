
public class ThreadBinaryTree_ex                           //��������������
{
    public static void main(String args[])
    {
        //����
/*        //ͼ6.25��ʾ�������������������ȸ�����
        String[] prelist = {"A","B","D",null,null,"E","G",null,null,null,"C","F",null,"H",null,null,"K"};
        ThreadBinaryTree<String> tbitree = new ThreadBinaryTree<String>(prelist);    //������������������
        tbitree.preOrder();                                 //�ȸ��������
        tbitree.inOrder();                                  //�и��������
        tbitree.inOrder_previous();                         //�и������������ǰ����
        tbitree.postOrder_previous();                       //��������������ǰ����

*/        //����
//        tbitree = new ThreadBinaryTree<String>();           //��������������������
//        tbitree.insertRoot("A");                          //�����
        String[] prelist = {"A","B","C",null,null,"D","E","F",null,null,"G",null,"H",null,null,null,
                "I","J",null,"K","L","M",null,null,null,"N",null,null,"O"};
        ThreadBinaryTree<String> tbitree = new ThreadBinaryTree<String>(prelist);
        ThreadNode<String> node = tbitree.insertChild(tbitree.root.left.right, "W", false); //����D���Һ���W
        System.out.println(node+"�ĸ�ĸ�����"+tbitree.getParent(node));         
        node = tbitree.insertChild(tbitree.root.left, "X", false);       //����B���Һ���X
        System.out.println(node+"�ĸ�ĸ�����"+tbitree.getParent(node)); 
        node = tbitree.insertChild(tbitree.root.right.left, "Y", true);  //����J������Y
//        System.out.println(node+"�ĸ�ĸ�����"+tbitree.getParent(node)); 
        node = tbitree.insertChild(tbitree.root.right, "Z", true);       //����I������Z
        System.out.println(node+"�ĸ�ĸ�����"+tbitree.getParent(node)); 
        tbitree.preOrder();                                //�ȸ��������
        tbitree.inOrder();                                 //�и��������
        
/*        //ɾ���Һ���
        String[] prelist = {"A","B","C",null,null,"X","D","E",null,null,"F",null,"G",null,null,
                            "H","I","J",null,null,null,"K",null,null,"L"};
        ThreadBinaryTree<String> tbitree = new ThreadBinaryTree<String>(prelist);
/*        tbitree.removeRightChild(tbitree.root.left.left);            //ɾ��C���Һ��ӣ�û�У���ɾ��
        tbitree.removeRightChild(tbitree.root.left);                 //ɾ��B���Һ���X��X��2�Ƚ��
        tbitree.removeRightChild(tbitree.root.left.right.right);     //ɾ��F���Һ���G��G��ֻ���Һ��ӵ�1�Ƚ��
        tbitree.removeRightChild(tbitree.root.left.right.right.right);//ɾ��H���Һ���K��K��0�Ƚ��
        tbitree.removeRightChild(tbitree.root.left.right.right);     //ɾ��F���Һ���H��H��ֻ�����ӵ�1�Ƚ��
        tbitree.preOrder();                                //�ȸ��������
        tbitree.inOrder();                                 //�и��������

        //ɾ������
        tbitree.removeLeftChild(tbitree.root.left);        //ɾ��B�����ӣ�û�У���ɾ��
        tbitree.removeLeftChild(tbitree.root.right);       //ɾ��C������X��X��2�Ƚ��
        tbitree.removeLeftChild(tbitree.root.right.left);  //ɾ��D������E��E��0�Ƚ��
        tbitree.removeLeftChild(tbitree.root.right);       //ɾ��C������D��D��ֻ���Һ��ӵ�1�Ƚ��
        tbitree.removeLeftChild(tbitree.root.right.left.right.right);  //ɾ��H������I��I��ֻ�����ӵ�1�Ƚ��
        tbitree.preOrder();                                //�ȸ��������
        tbitree.inOrder();                                 //�и��������

        //ɾ����
        String[] prelist = {"A","B","D",null,null,"E",null,"H",null,null,"C","F","I",null,null,null,"G"};
        ThreadBinaryTree<String> tbitree = new ThreadBinaryTree<String>(prelist);
        tbitree.removeRoot();                               
        tbitree.preOrder();                                 //�ȸ��������
        tbitree.inOrder();                                  //�и��������
*/    }
}
/*
�������н�����£�
//����
�ȸ������������������������  A B D E G C F H K 
�и������������������������  D B G E A F H C K 
�и����򣨷��򣩱�������������������  K C H F A E G B D 
������򣨷��򣩱�������������������  A C K F H B E G D 

//����
�ȸ������������������������  A B C X D E F G H W I Z J Y K L M N O 
�и������������������������  C B X F E G H D W A Y J M L K N Z I O 

//ɾ���Һ���
�ȸ������������������������  A B C D E F I J L 
�и������������������������  C B E D F J I A L 

//ɾ������
�ȸ������������������������  A X D E F G H I J K L 
�и������������������������  E D F G X J I H K A L 

//ɾ����
�ȸ������������������������  B D E H C F I G 
�и������������������������  D B E H I F C G 


*/

/* 
  //ɾ��
    tbitree.remove(tbitree.root.left,false);         //ɾ��B���Һ���X
    tbitree.remove(tbitree.root.left.right,false);  //ɾ��D���Һ���W
    tbitree.remove(tbitree.root.left,false);         //ɾ��B���Һ���D
    
    tbitree.remove(tbitree.root.left);           //ɾ��B�����ӣ�û�У���ɾ��
    tbitree.remove(tbitree.root.right);          //ɾ��C������X��X��2�Ƚ��
    tbitree.remove(tbitree.root.right.left);    //ɾ��D������E��E��0�Ƚ��
    tbitree.remove(tbitree.root.right);          //ɾ��C������D��D��ֻ���Һ��ӵ�1�Ƚ��
    tbitree.remove(tbitree.root.right.left.right.right);  //ɾ��H������I��I��ֻ�����ӵ�1�Ƚ��


*/
//??
//    ThreadBinaryNode<char> *node = tbitree.root.left.right.right;    //
/*    ThreadBinaryNode<char> *node = tbitree.root.right.left.left;       
    ThreadBinaryNode<char> *parent = tbitree.getParent(node);
    cout<<node.data<<"�ĸ�ĸ�����";
    if (parent==NULL)
        cout<<"NULL"<<endl;
    else
        cout<<parent.data<<endl;
*/