//����10.1��  �绰����
//�� TelephoneBookJFrame��ʵ�ֵ绰����ͼ���û����棬�ṩ��ӡ����Һ�ɾ�����ܡ�

//�̳�JFrame���ڿ���࣬ʵ��ListSelectionListener�б��ѡ���¼��ӿڡ�ActionListener�����¼��ӿڡ�WindowListener�����¼��ӿ�

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class PhoneBookJFrame extends JFrame 
    implements ListSelectionListener, ActionListener, WindowListener
{
    private PhoneBookTreeSet book;                         //�绰����ʹ��һ�������ϴ洢����Friend����
    private JList list;                                    //�б��
    private DefaultListModel listModel;                    //Ĭ���б��ģ��
    private JTable table;                                  //������
    private DefaultTableModel tableModel;                  //Ĭ�ϱ��ģ��
    private JComboBox combobox_name;                       //������Ͽ�
    private DefaultComboBoxModel comboModel;               //��Ͽ�ģ�ͣ�ѡ������
    private JTextField text_code;                          //�绰�����ı���

    public PhoneBookJFrame(String filename)                //����ͼ���û�����
    {
        super("�绰��");
        this.setBounds(300,300,450,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addWindowListener(this);                      //ע�ᴰ���¼�������
        JSplitPane split_h=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT); //ˮƽ�ָ��
        split_h.setDividerLocation(40);                    //���ô�ֱ�ָ�����λ��
        this.getContentPane().add(split_h);
        JSplitPane split_v=new JSplitPane(JSplitPane.VERTICAL_SPLIT); //��ֱ�ָ��
        split_v.setDividerLocation(180);                   //����ˮƽ�ָ�����λ��

        this.book = new PhoneBookTreeSet(filename);
        this.listModel = new DefaultListModel();           //Ĭ���б��ģ��
        this.listModel.addElement("ȫ��"); 
        this.list = new JList(listModel);                  //�����б��
        this.list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //���õ�ѡģʽ��Ĭ��Ϊ��ѡ
        this.list.addListSelectionListener(this);          //�б��ע��ѡ���¼�������
        split_h.add(new JScrollPane(this.list));           //����ڹ���������
        split_h.add(split_v);
        
        String[] columns={"����","�绰����"};               //�����е����ı���
        this.tableModel=new DefaultTableModel(columns,0);  //Ĭ�ϱ��ģ�ͣ�ָ���б��⣬0��
        this.table=new JTable(tableModel);                 //�����ձ�����б���
        this.list.setSelectedIndex(0);                     //ѡ���б���һ�ִ��valueChanged()����
        split_v.add(new JScrollPane(table));

        //������������Ͽ��ı��к���ӡ�ɾ�������ҵȰ�ť
        JPanel friendpanel=new JPanel(new GridLayout(2,1)); 
        split_v.add(friendpanel);
        JPanel panels[]={new JPanel(), new JPanel()};
        for (int i=0; i<panels.length; i++)
            friendpanel.add(panels[i]);
        panels[0].add(new JLabel(columns[0]));
        this.comboModel = new DefaultComboBoxModel();      //Ĭ����Ͽ�ģ��
        combobox_name = new JComboBox(this.comboModel); 
        combobox_name.setEditable(true);
        panels[0].add(combobox_name);
        panels[0].add(new JLabel(columns[1]));
        this.text_code = new JTextField("12345678901", 12);
        panels[0].add(text_code);
        this.addIndex();                                   //JList��ӵ绰���е���������������
            
        String buttonstr[]={"���","����������","���绰�������","ɾ����"};
        JButton buttons[] = new JButton[buttonstr.length];
        for (int i=0; i<buttons.length; i++)
        {
            buttons[i] = new JButton(buttonstr[i]);
            panels[1].add(buttons[i]);
            buttons[i].addActionListener(this);
        }
        this.setVisible(true);
    }
    
    private void addIndex()                                //JList��ӵ绰������������������
    {
        Iterator<Friend> it=this.book.iterator();          //����һ������������
        while (it.hasNext())                               //���к��Ԫ�أ�ʹ�õ�������������
        {
            String indexstr=it.next().index();             //��ú��Ԫ������������
            if (!this.listModel.contains(indexstr))
            {
                this.listModel.addElement(indexstr);       //�б��ģ����Ӳ��ظ�������
                this.comboModel.addElement(indexstr);      //��Ͽ�ģ����Ӳ��ظ�������
            }
        }
    }
    
    public void valueChanged(ListSelectionEvent e)         //�б���ѡ���¼�������
    {
//      System.out.println(" "+selected);  //һ��ѡ��ִ�����θ��¼�����Ϊʲô

        String surname=(String)list.getSelectedValue();    //�����б��ѡ�����������
        if (!this.book.isEmpty() && surname!=null && surname!="")  //��ѡ�����ϸ��±��
        {
            for (int i=this.tableModel.getRowCount()-1; i>=0; i--) //��ձ��
                this.tableModel.removeRow(i);              
            if (surname=="ȫ��")
                this.addAll();                             //���������ж���
            else                                           //������ָ�����ϵ�������
                this.addAll(new Friend(surname, ""), new IndexComparator());
        }
    }
    //���绰��������friend����ͱȽ���cָ�����������ж�����ӵ�tableModel���ģ����
    private void addAll(Friend friend, Comparator<Friend> c)
    {
        Iterator<Friend> it = this.book.iterator();
        while (it.hasNext())                           //��������
        {
            Friend f = it.next();
            if (c==null || c.compare(friend, f)==0)    //�Ƚ���cָ������ȽϹ���
                this.tableModel.addRow(f.toArray());   //������һ�У���������ָ������ֵ
        }
    }
    private void addAll()
    {
        this.addAll(null, null);
    }

    public void actionPerformed(ActionEvent e)             //�����¼�������
    {
        String name=(String)combobox_name.getSelectedItem();
        String code=text_code.getText();
        if (e.getActionCommand().equals("���"))             //������Ӱ�ť
        {
            Friend f = new Friend(name, code);
            if (!name.equals("") && !this.book.contains(f))//�绰�����ܲ��������մ����ظ�����
            {
                this.book.add(f);                          //��Ӷ���TreeSet�������ظ�Ԫ�أ�û��ʾҲ���׳��쳣
                String surname = f.index();                //��������
                if (list.getSelectedValue().equals(surname))
                    tableModel.addRow(f.toArray());     
                else
                {   if (!listModel.contains(surname))      //�б������Ӳ��ظ�Ԫ��
                    {
                        listModel.addElement(surname);
                        comboModel.addElement(surname);
                    }
                    list.setSelectedValue(surname,true);   //�����б��ѡ����
                }
            }
            else
                JOptionPane.showMessageDialog(this, "������������մ����ظ�����"+f.toString());
            return;
        }

        if (!this.book.isEmpty() && e.getActionCommand().endsWith("����"))
        {                                                  //��������绰������ң������ʾ�ڱ����
            for (int i=tableModel.getRowCount()-1; i>=0; i--) //��ձ��
                this.tableModel.removeRow(i);                    
            if (e.getActionCommand().equals("����������"))
                this.addAll(new Friend(name,""), new Friend(name,""));   //Friend���ǱȽ�������
                               //���绰��������Ƚ���cָ�����������ж�����ӵ�tableModel���ģ����
            else               //���绰������ң������״γ��ֵĶ����ɱȽ���cָ���ȽϹ���
            {   Friend find = this.book.search(new Friend("",code), new CodeComparator());
                if (find!=null)                            //���ҳɹ�
                    this.tableModel.addRow(find.toArray());  
            }
            return;
        }
 
        if (e.getActionCommand().equals("ɾ����"))
        {
            if (this.book.isEmpty())
                JOptionPane.showMessageDialog(this, "���գ�����ɾ�������");
            else
            {   int i = table.getSelectedRow();            //���ǰѡ���к�
                if (i==-1)
                    JOptionPane.showMessageDialog(this, "��ѡ�������");
                else
                {   name=(String)table.getValueAt(i,0);
                    int yes=JOptionPane.showConfirmDialog(null, "ɾ��\""+name+"\"�У�");//ȷ�϶Ի������Yes��No��ť
                    if (yes==0)                            //����ȷ�϶Ի����Yes��ť
                    {
                        code=(String)table.getValueAt(i,1);
                        Friend f = new Friend(name, code);
                        this.book.remove(f);               //�绰����ɾ������
                        tableModel.removeRow(i);           //�����ɾ��һ��
                        if (this.book.search(f, new IndexComparator())==null)
                        {                                  //�����ϲ��ң��绰����û����ͬ����
                            listModel.removeElement(f.index());  //�б����ɾ��ָ������
                            comboModel.removeElement(f.index());
                        }
                    }
                }
            }
        }
    }
    
    public void windowClosing(WindowEvent e)               //�رմ����¼�������
    {
    	this.book.writeToFile();     //���绰�������ж���д��ָ���ļ������ļ������ڣ������ļ�
    }
    public void windowOpened(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
    public void windowClosed(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}

    public static void main(String args[])
    {
        new PhoneBookJFrame("friends.dat");
    }
}
