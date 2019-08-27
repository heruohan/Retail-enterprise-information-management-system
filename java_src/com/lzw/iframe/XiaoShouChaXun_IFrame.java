package com.lzw.iframe;

import javax.swing.*;
import java.awt.event.*;
import com.lzw.dao.*;
import java.util.List;
import java.util.*;
import javax.swing.table.*;
import java.awt.*;
import javax.swing.event.*;



public class XiaoShouChaXun_IFrame extends JInternalFrame{
	
	//��ѯ�����������
	private JComboBox tiaojianComboBox=null;    //��ѯ����ѡ�������б��
	private JComboBox jingqueComboBox=null;    //��ѯ��ȷ���������б��
	
	private JTextField contentField=null;    //��ѯ���������ı���
	
	private JButton chaxunButton=null;    //��ѯ��ť
	
	private JCheckBox dateSelectBox=null;    //ʱ��ѡ��ѡ��
	
	private JTextField startDateField=null;     //��ʼʱ���ı���
	private JTextField endDateField=null;    //����ʱ���ı���
	
	private JButton showAllButton=null;    //��ʾȫ�����ݰ�ť
	
	private JScrollPane tablePane=null;    //������
	private JTable table=null;    //���
	
	//private Date date=new Date();    //����
	
	
	/*
	public static void main(String[] args)
	{
		JFrame t=new JFrame();
		t.setSize(800, 600);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane deskpane=new JDesktopPane();
		XiaoShouChaXun_IFrame inFrame=new XiaoShouChaXun_IFrame();
		
		
		deskpane.add(inFrame);
		inFrame.setVisible(true);
		
		t.setContentPane(deskpane);
		t.setVisible(true);
	}
	*/
	
	
	//���캯��
	public XiaoShouChaXun_IFrame()
	{
		init();
	}

	
	//��ʼ�����۲�ѯ�ڲ�����
	private void init()
	{
		//���ڲ�������Ӽ�������ڴ���۽���ִ�г�ʼ����ʼ�ͽ���ʱ��
		this.addInternalFrameListener(new InternalFrameAdapter()
				{
			public void internalFrameActivated(InternalFrameEvent e)
			{
				Calendar calendar=Calendar.getInstance();
				//����ʱ��
				String end_date=String.format("%tF", calendar);
				endDateField.setText(end_date);
				
				//��ʼʱ��
				calendar.set(Calendar.MONTH, 0);
				calendar.set(Calendar.DATE, 1);
				String start_date=String.format("%tF", calendar);
				startDateField.setText(start_date);
			}
				});
		
		
		//�����ڲ����������
		this.setTitle("������Ϣ��ѯ");
		this.setMaximizable(true);
		this.setIconifiable(true);
		this.setClosable(true);
		this.getContentPane().setLayout(new GridBagLayout());
		this.setBounds(50, 50, 600,320);
		
		
		/*
		 * ���ò������
		 */
		//��ѯ��ǩ
		JLabel tiaojianLabel=new JLabel("��ѡ���ѯ������");
		this.setupComponent(tiaojianLabel, 0, 0, 1, 0, false);
		
		//��ѯ����ѡ�������б��tiaojianComboBox
		tiaojianComboBox=this.getTiaojianComboBox();
		tiaojianComboBox.setPreferredSize(new Dimension(80,21));
		this.setupComponent(this.getTiaojianComboBox(), 1, 0, 1, 0, true);
		
		//��ȷ���������б��jingqueComboBox
		jingqueComboBox=this.getJingqueComboBox();
		jingqueComboBox.setPreferredSize(new Dimension(60,21));
		this.setupComponent(this.getJingqueComboBox(), 2, 0, 1, 0, true);
		
		//��ѯ���������ı���contentField
		contentField=this.getContentField();
		contentField.setPreferredSize(new Dimension(150,21));
		this.setupComponent(this.getContentField(), 3, 0,3, 0, true);
		
		//��ѯ��ť��chaxunButton
		chaxunButton=this.getChaXunButton();
		chaxunButton.setPreferredSize(new Dimension(60,21));
		this.setupComponent(this.getChaXunButton(), 6, 0, 1, 0, false);
		
		
		//ʱ��ѡ��ѡ�������dateSelectBox
		dateSelectBox=new JCheckBox();
		GridBagConstraints constraint=new GridBagConstraints();
		constraint.gridx=0;
		constraint.gridy=1;
		constraint.anchor=GridBagConstraints.EAST;
		this.getContentPane().add(dateSelectBox, constraint);
		//this.setupComponent(dateSelectBox, 0, 1, 1, 0, false);
		
		//ָ����ѯ���ڱ�ǩ��zhidingLabel
		JLabel zhidingLabel=new JLabel("ָ����ѯ����       ��");
		this.setupComponent(zhidingLabel, 1, 1, 1, 0, false);
		
		
		//��ʼʱ���ı���startDateField
		startDateField=new JTextField();
		startDateField.setPreferredSize(new Dimension(80,21));
		this.setupComponent(startDateField, 2, 1, 1, 0, true);
		
		//��ǩ��daoLabel
		JLabel daoLabel=new JLabel("��");
		this.setupComponent(daoLabel, 3, 1, 1, 0, false);
		
		
		//����ʱ���ı���endDateField
		endDateField=new JTextField();
		endDateField.setPreferredSize(new Dimension(80,21));
		this.setupComponent(endDateField, 4, 1, 1, 0, true);
		
		//��ʾȫ�����ݰ�ť��showAllButton
		showAllButton=this.getShowAllButton();
		showAllButton.setPreferredSize(new Dimension(110,22));
		this.setupComponent(this.getShowAllButton(), 6, 1, 1, 0, false);
		
		//��ӱ����壺tablePane
		tablePane=this.getTablePane();
		tablePane.setPreferredSize(new Dimension(580,210));
		this.setupComponent(this.getTablePane(), 0, 2, 7, 0, true);
		
	
	}
	
	
	
	//��������ڲ��ֹ������е�λ��
	private void setupComponent(JComponent component,int gridx,int gridy,int gridwidth,int ipadx,boolean fill)
	{
		GridBagConstraints constraint=new GridBagConstraints();
		constraint.gridx=gridx;
		constraint.gridy=gridy;
		constraint.insets=new Insets(4,2,4,2);
		
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
	
	
	
	//��ʼ������ѡ�������б��tiaojianComboBox
	private JComboBox getTiaojianComboBox()
	{
		if(tiaojianComboBox==null)
		{
			tiaojianComboBox=new JComboBox();
			tiaojianComboBox.setEditable(false);
			tiaojianComboBox.addItem("�ͻ�ȫ��");
			tiaojianComboBox.addItem("����Ʊ��");
		}
		return tiaojianComboBox;
	}
	
	
	//��ʼ����ȷ�����б��jingqueComboBox
	private JComboBox getJingqueComboBox()
	{
		if(jingqueComboBox==null)
		{
			jingqueComboBox=new JComboBox();
			jingqueComboBox.setEditable(false);
			jingqueComboBox.addItem("����");
			jingqueComboBox.addItem("����");
			
		}
		return jingqueComboBox;
	}
	
	
	//��ʼ����ѯ���������ı���contentField
	private JTextField getContentField()
	{
		if(contentField==null)
		{
			contentField=new JTextField();
			
			//��Ӽ������������س�ʱ��ִ�в�ѯ
			contentField.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					chaxunButton.doClick();
				}
					});
		}
		return contentField;
	}
	
	
	//��ʼ����ѯ��ť��chaxunButton
	private JButton getChaXunButton()
	{
		if(chaxunButton==null)
		{
			chaxunButton=new JButton("��ѯ");
			
			//��Ӽ����
			chaxunButton.addActionListener(new MyListener());
		}
		return chaxunButton;
	}
	
	
	//ʱ��ѡ��ѡ��dateSelectBox
	
	//��ʼʱ���ı���startDateField
	//����ʱ���ı���endDateField
	
	//��ʼ����ʾȫ�����ݰ�ť��showAllButton
	private JButton getShowAllButton()
	{
		if(showAllButton==null)
		{
			showAllButton=new JButton("��ʾȫ������");
			
			//��Ӽ����
			showAllButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					List all_list=Dao.findForList("select * from v_sellview");
					Iterator iter=all_list.iterator();
					//���±��
					updateTable(iter);
				}
					});
		}
		return showAllButton;
	}
	
	
	
	//��ʼ�������壺tablePane
	private JScrollPane getTablePane()
	{
		if(tablePane==null)
		{
			tablePane=new JScrollPane();
			tablePane.setViewportView(this.getTable());
		}
		return tablePane;
	}
	
	
	//��ʼ�����table
	private JTable getTable()
	{
		if(table==null)
		{
			table=new JTable();
			table.setShowGrid(true);
			table.setEnabled(false);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			
			//��������
			String[] columnname= {"����Ʊ��", "��Ʒ����", "��Ʒ���", "���", "����","����", "���", "�ͻ�ȫ��", "��������", "����Ա", "������", "���㷽ʽ"};
			((DefaultTableModel)table.getModel()).setColumnIdentifiers(columnname);
		}
		return table;
	}
	
	
	
	//��ѯ��ť�����ʵ�֣�ActionListener
	private final class MyListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			boolean selectDate=dateSelectBox.isSelected();
			
			//�жϲ�ѯ�����Ƿ�Ϊ��
			if(contentField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(XiaoShouChaXun_IFrame.this, "�������ѯ����");
				return;
			}
			
			
			//�ж��Ƿ������ѯ��ʼ���ڼ���������
			if(selectDate)
			{
				if(startDateField.getText()==null || startDateField.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(XiaoShouChaXun_IFrame.this, "�����뿪ʼ����");
					return;
				}
				
				if(endDateField.getText()==null || endDateField.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(XiaoShouChaXun_IFrame.this, "�������������");
					return;
				}
			}
			
			
			//�����������ã���������ͼ�л�ȡ��ѯ���
			//��ѯ����
			int tiaojian_index=tiaojianComboBox.getSelectedIndex();
			String tiaojian_str=(tiaojian_index==0) ? "khname" : "sellID";
			
			//��ȷ������
			int jingque_index=jingqueComboBox.getSelectedIndex();
			String jingque_str=(jingque_index==0) ? "=" : "LIKE";
			
			String content_str=contentField.getText();    //��ѯ����
			
			
			
			//��ѯ��SQL���
			String sql="select * from v_sellview where " + tiaojian_str + jingque_str + 
					   (jingque_index==0 ? "'" + content_str  + "'" : ("'%" + content_str + "%'")) +
					   (selectDate ? "and xsdate>'" + startDateField.getText() + "' and xsdate<='" + 
					   endDateField.getText() + " 23:59:59'" : "");
			
			List res=Dao.findForList(sql);
			//���±��
			Iterator iter=res.iterator();
			updateTable(iter);
		}
	}
	
	
	
	//���ݲ�ѯ�����Ķ�ά���飬���±��ķ���
	private void updateTable(Iterator iter)
	{
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		
		//ÿ�θ��±���ʱ����Ҫ����ɾ��������
		int row=table.getRowCount();
		for(int i=0;i<row;i++)
		{
			model.removeRow(0);
		}
		
		
		
		while(iter.hasNext())
		{
			Vector vector=new Vector();
			List<String> tmp=(List<String>)iter.next();
			
			vector.addAll(tmp);
			model.addRow(vector);
		}
	}
}
