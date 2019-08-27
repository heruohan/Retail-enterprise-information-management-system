package com.lzw.iframe;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import com.lzw.*;
import java.util.Date;
import java.util.Iterator;
import java.awt.event.*;
import javax.swing.table.*;
import java.util.List;
import com.lzw.dao.*;
import com.lzw.*;
import com.lzw.dao.model.*;
import java.awt.*;


public class KuCunPanDian_IFrame extends JInternalFrame{
	
	/*
	 * �ڲ������ϵ��������
	 */
	private JLabel czyLabel=null;    //����Ա��ǩ
	private JTextField czyField=null;    //����Ա�ı���
	
	private JLabel pdsjLabel=null;    //�̵�ʱ���ǩ
	private JTextField pdsjField=null;    //�̵�ʱ���ı���
	
	private JLabel pzsLabel=null;    //Ʒ������ǩ
	private JTextField pzsField=null;    //Ʒ�����ı���
	
	/*
	 * ���������
	 */
	private JScrollPane tablePane=null;    //������
	private JTable table=null;    //���
	
	
	//�̵�ʱ��
	private Date pddate=new Date();
	
	
	public static void main(String[] args)
	{
		JFrame t=new JFrame();
		t.setSize(800, 600);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane deskpane=new JDesktopPane();
		KuCunPanDian_IFrame inFrame=new KuCunPanDian_IFrame();
		
		deskpane.add(inFrame);
		inFrame.setVisible(true);
		
		t.setContentPane(deskpane);
		t.setVisible(true);
	}
	
	
	
	
	//���캯��
	public KuCunPanDian_IFrame()
	{
		init();
		
	}
	
	
	//��ʼ������̵��ڲ�����
	private void init()
	{
		this.setTitle("����̵�");
		this.setMaximizable(true);    //���
		this.setIconifiable(true);    //ͼ�껯
		this.setClosable(true);    //�ɹر�
		this.setResizable(true);
		this.getContentPane().setLayout(new GridBagLayout());
		this.setBounds(50, 50, 600, 320);
		
		
		//����Ա��ǩ��czyLabel
		czyLabel=new JLabel("����Ա��");
		this.setupComponent(czyLabel, 0, 0, 1, 0, false);
		czyField=this.getCzyField();
		czyField.setPreferredSize(new Dimension(100,20));
		this.setupComponent(this.getCzyField(), 1, 0, 1, 0, true);
		
		
		//�̵�ʱ���ǩ��pdsjLabel
		pdsjLabel=new JLabel("�̵�ʱ�䣺");
		this.setupComponent(pdsjLabel, 2, 0, 1, 0, false);
		pdsjField=this.getPdsjField();
        pdsjField.setPreferredSize(new Dimension(150,20));
		this.setupComponent(this.getPdsjField(), 3, 0, 1, 0, true);
		
		
		//Ʒ������ǩ��pzsLabel
		pzsLabel=new JLabel("Ʒ������");
		this.setupComponent(pzsLabel, 4, 0, 1, 0, false);
		this.setupComponent(this.getPzsField(), 5, 0, 1, 0, true);
		
		
		
		//�����弰��������tablePane
		tablePane=this.getTablePane();
		tablePane.setPreferredSize(new Dimension(570,240));
		this.setupComponent(this.getTablePane(), 0, 1, 6, 0, true);
		
	}
	
	
	
	//�����ڲ�����Ĳ��ֹ�����
	private void setupComponent(JComponent component,int gridx,int gridy,int gridwidth,int ipadx,boolean fill)
	{
		GridBagConstraints constraint=new GridBagConstraints();
		constraint.gridx=gridx;
		constraint.gridy=gridy;
		constraint.insets=new Insets(2,2,2,2);
		if(gridwidth>1)
		{
			constraint.gridwidth=gridwidth;
		}
		
		if(ipadx>0)
		{
			constraint.ipadx=ipadx;
		}
		
		if(fill)
		{
			constraint.fill=GridBagConstraints.HORIZONTAL;
		}
		
		this.getContentPane().add(component, constraint);
	}
	
	
	//��ʼ������Ա�ı���czyField
	private JTextField getCzyField()
	{
		if(czyField==null)
		{
			czyField=new JTextField();
			czyField.setEditable(false);
			czyField.setText(MainFrame.getCzyLabel().getText());
		}
		return czyField;
	}
	
	
	//��ʼ���̵�ʱ���ı���pdsjField
	private JTextField getPdsjField()
	{
		if(pdsjField==null)
		{
			pdsjField=new JTextField();
			pdsjField.setEditable(false);
			String s=String.format("%1$tF %1$tT", pddate);
			pdsjField.setText(s);
		}
		return pdsjField;
	}
	
	
	//��ʼ��Ʒ�����ı���pzsField
	private JTextField getPzsField()
	{
		if(pzsField==null)
		{
			pzsField=new JTextField("0");
			pzsField.setEditable(false);
		}
		return pzsField;
	}
	
	
	
	/*
	 * ���������
	 */
	//�����壺tablePane
	private JScrollPane getTablePane()
	{
		if(tablePane==null)
		{
			tablePane=new JScrollPane();
			tablePane.setViewportView(this.getTable());
		}
		return tablePane;
	}
	
	
	
	//���table
	private JTable getTable()
	{
		if(table==null)
		{
			String[] columnName= { "��Ʒ����", "��Ʒ���", "��Ӧ��", "����", "��λ", "���", "����", "����", "��װ", "�̵�����", "��������" };
			table=new JTable();
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table.setShowGrid(true);
			table.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));    //���ñ��ı߽���״
			
			
			//��ӱ���б���
			DefaultTableModel model=(DefaultTableModel)table.getModel();    //���ģ��
			model.setColumnIdentifiers(columnName);
			
			
			//�����̵������к������еı༭��
			final JTextField pdField=new JTextField(0);    //�̵��еı༭��
			pdField.setEditable(false);
			pdField.addKeyListener(new pdslListener(pdField));    //��Ӽ����
			
			
			final JTextField readOnlyField=new JTextField(0);
			readOnlyField.setEditable(false);
			
			
			//����༭��
			DefaultCellEditor pdEditor=new DefaultCellEditor(pdField);
			DefaultCellEditor readOnlyEditor=new DefaultCellEditor(readOnlyField);
			
			
			//���ñ���е�������Ϊֻ��ģʽ
			for(int i=0;i<columnName.length;i++)
			{
				TableColumn column=table.getColumnModel().getColumn(i);
				column.setCellEditor(readOnlyEditor);
			}
			
			//�����̵������еı༭��ΪpdEditor
			TableColumn pdColumn=table.getColumnModel().getColumn(9);
			pdColumn.setCellEditor(pdEditor);
			
			//��ʼ������е�����
			String pzs_str=pzsField.getText();
			int pzs=Integer.parseInt(pzs_str);    //��ʼƷ����
			List kucun_List=Dao.getKucunInfos();
			for(int i=0;i<kucun_List.size();i++)
			{
				List tmp=(List)kucun_List.get(i);
				Item item=new Item();
				item.setId((String)tmp.get(0));
				item.setName((String)tmp.get(1));
				
				TbSpinfo sp=Dao.getSpinfo(item);    //�����Ӧ����Ʒ��
				
				//����������
				String[] new_row=new String[columnName.length];
				if(sp!=null && sp.getId()!=null && !sp.getId().isEmpty())
				{
					new_row[0]=sp.getSpname();
					new_row[1]=sp.getId();
					new_row[2]=sp.getGysname();
					new_row[3]=sp.getCd();
					new_row[4]=sp.getDw();
					new_row[5]=sp.getGg();
					new_row[6]=(String)tmp.get(2);
					new_row[7]=(String)tmp.get(3);
					new_row[8]=sp.getBz();
					new_row[9]="";
					new_row[10]="";
					model.addRow(new_row);
					
					//����Ʒ�������ı���
					pzs++;
				}
			}
			pzsField.setText(pzs+"");
		}
		return table;
	}
	
	
	
	/*
	 * ʵ����KeyListener�ӿڵĳ�Ա�ڲ���pdslListener,
	 * ��Ŀ���ǵ�����������̵�����ʱ��ʵʱ��������������
	 * ���У���������=�������-�̵�����
	 */
	
	
	/*
	 * KeyListener�еķ���һ��ִ�е�˳���ǣ�KeyPressed,KeyTyped,KeyReleased
	 */
	//��Ա�ڲ���pdslListener
	class pdslListener implements KeyListener
	{
		private final JTextField pdField;
		
		//���캯����Ϊ�˴��ݽ���һ�������еľֲ�����
		public pdslListener(JTextField field)
		{
			this.pdField=field;
		}
		
		public void keyTyped(KeyEvent e)
		{
			/*
			 * �ж�ÿ��������ǲ������ֺ�
			 * ɾ������(char)8
			 */
			if(("0123456789" + (char)8).indexOf((int)e.getKeyChar())<0)
			{
				e.consume();    //����������ֺ�ɾ�����Ͳ���������ֶ�����ʾ
			}
			pdField.setEditable(true);
		}
		
		//ʵʱ������������
		public void keyReleased(KeyEvent e)
		{
			int row=table.getSelectedRow();
			String kucunSL_str=null;    //�������
			String pdSL_str=pdField.getText();    //�̵�����
			if(row>=0)
			{
				kucunSL_str=(String)table.getValueAt(row, 7);	
			}
			
			//���̵�����Ϊnullʱ��ת������ִ��󣬲����в�׽
			try
			{
				int pdSL=Integer.parseInt(pdSL_str);
				int kucunSL=Integer.parseInt(kucunSL_str);
				
				int sySL=kucunSL-pdSL;
				if(row>=0)
				{
					table.setValueAt(sySL, row, 10);
				}
				
			}
			catch(Exception e1)
			{
				if(e.getKeyChar()!=8)    //���������ַ�����ɾ����
				{
					pdField.setEditable(false);
				}
				
				pdField.setText("");
			}
		}
		
		
		public void keyPressed(KeyEvent e)
		{
			
		}
	}

}
