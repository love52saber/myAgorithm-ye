//����8.4��  �����������Ĳ���Ͳ��Ҳ�����

class BinarySortTree_ex
{
    public static void main(String args[])
    {
/*        BinarySortTree<Integer> bstree = new BinarySortTree<Integer>();//����ն���������
        int[] values={54,18,66,87,36,12,54,81,15,76,57,6,40,99,85,99};
        for (int i=0; i<values.length; i++)
             bstree.insert(new Integer(values[i]));                 //����
//        bstree.insert(values[i]);                     //Ҳ�ɣ�������int��Java�Զ�����ת����Integer
        bstree.inOrder();                        //�и���������������������õ����ؼ����������е�����Ԫ������
*/
        Integer[] values={54,18,66,87,36,12,54,6,40,76,81,57,99};
        BinarySortTree<Integer> bstree=new BinarySortTree<Integer>(values); //�������������
        bstree.inOrder();                        //�и���������������������õ����ؼ����������е�����Ԫ������
        Integer key = new Integer(values[values.length-1]);
        System.out.println("����"+key+", "+(bstree.search(key)!=null?"":"��")+"�ɹ� ");
        key = new Integer(50);
        System.out.println("����"+key+", "+(bstree.search(key)!=null?"":"��")+"�ɹ� ");

        System.out.print("ɾ��6,36,66,87,"+key+"��");
        bstree.remove(new Integer(6));
        bstree.remove(new Integer(36));
        bstree.remove(key);
        key = new Integer(66);
        bstree.remove(key);
        bstree.remove(new Integer(87));
        bstree.inOrder();
        
        System.out.print("����66��");
        bstree.insert(key);
        bstree.inOrder();
        System.out.println("����"+key+"��"+(bstree.search(key)!=null?"":"��")+"�ɹ� ");
        
        while (bstree.root!=null)
        {
            System.out.print("ɾ��"+bstree.root.data+"��");
            bstree.remove(bstree.root.data);
            bstree.inOrder();
        }
    }
}
/*
�������н�����£�
�и����������������  6 12 18 36 40 54 57 66 76 81 87 99 
54? 66? 87? 99? ����99, �ɹ� 
54? 18? 36? 40? ����50, ���ɹ� 
ɾ��6,36,66,87,50���и����������������  12 18 40 54 57 76 81 99 
����66���и����������������  12 18 40 54 57 66 76 81 99 
54? 76? 57? 66? ����66���ɹ� 
ɾ��54���и����������������  12 18 40 57 66 76 81 99 
ɾ��57���и����������������  12 18 40 66 76 81 99 
ɾ��66���и����������������  12 18 40 76 81 99 
ɾ��76���и����������������  12 18 40 81 99 
ɾ��81���и����������������  12 18 40 99 
ɾ��99���и����������������  12 18 40 
ɾ��18���и����������������  12 40 
ɾ��40���и����������������  12 
ɾ��12���и����������������  

*/
