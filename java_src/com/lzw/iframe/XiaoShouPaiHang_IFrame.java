package com.lzw.iframe;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.util.*;
import javax.swing.table.*;
import java.awt.event.*;
import com.lzw.dao.*;
import java.awt.*;
import java.util.List;


public class XiaoShouPaiHang_IFrame extends JInternalFrame{
	
	//�ڲ������ϵĸ������
	private JComboBox yearComboBox=null;    //�������б��
	private JComboBox monthComboBox=null;    //�������б��
	
	private JComboBox tiaojianComboBox=null;    //ѡ���������������б��
	private JComboBox paixuComboBox=null;    //���������б��
	
	private JButton quedingButton=null;    //ȷ����ť
	
	private JScrollPane tablePane=null;    //������
	private JTable table=null;    //���
	
	
	//ʱ������
	private Calendar calendar=Calendar.getInstance();
	
	/*
	public static void main(String[] args)
	{
		JFrame t=new JFrame();
		t.setSize(800, 600);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane deskpane=new JDesktopPane();
		XiaoShouPaiHang_IFrame inFrame=new XiaoShouPaiHang_IFrame();
		
		
		deskpane.add(inFrame);
		inFrame.setVisible(true);
		
		t.setContentPane(deskpane);
		t.setVisible(true);
	}
	*/
	
	
	//���캯��
	public XiaoShouPaiHang_IFrame()
	{
		init();
	}
	
	
	//��ʼ���ڲ�����ĺ���
	private void init()
	{
		//�����ڲ����������
		this.setTitle("��������");
		this.setMaximizable(true);
		this.setIconifiable(true);
		this.setClosable(true);
		this.setResizable(true);
		this.getContentPane().setLayout(new GridBagLayout());
		this.setBounds(50, 50, 620, 320);
		
		
		//�������
		//label1
		JLabel label1=new JLabel("��");
		this.setupComponent(label1, 0, 0, 1, 0, false);
		
		
		//�������б��yearComboBox
		this.setupComponent(this.getYearComboBox(), 1, 0, 1, 0, true);
		
		
		//lable2
		JLabel label2=new JLabel("��");
		this.setupComponent(label2, 2, 0, 1, 0, false);
		
		
		//�������б��monthComboBox
		this.setupComponent(this.getMonthComboBox(), 3, 0, 1, 0, true);
		
		
		//label3
		JLabel label3=new JLabel("�·ݵ�������Ϣ����");
		this.setupComponent(label3, 4, 0, 1, 0, true);
		
		
		//���������б��tiaojianComboBox
		this.setupComponent(this.getTiaojianComboBox(), 5, 0, 1, 0, true);
		
		
		//label4
		JLabel label4=new JLabel("����");
		this.setupComponent(label4, 6, 0, 1, 0, false);
		
		
		//���������б��paixuComboBox
		this.setupComponent(this.getPaixuComboBox(), 7, 0, 1, 0, true);
		
		
		//ȷ����ť��quedingButton
		this.setupComponent(this.getQuedingButton(), 8, 0, 1, 0, false);
		
		
		//�����壺tablePane
		tablePane=this.getTablePane();
		tablePane.setPreferredSize(new Dimension(580,240));
		this.setupComponent(this.getTablePane(), 0, 1, 9, 0, true);
		
	}
	
	
	//��������ķ���
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
	
	
	//��ʼ���������б��yearComboBox
	private JComboBox getYearComboBox()
	{
		if(yearComboBox==null)
		{
			yearComboBox=new JComboBox();
			yearComboBox.setEditable(false);
			
			//�����,1980����������ڵĸ������
			for(int i=1980,j=0;i<calendar.get(Calendar.YEAR)+1;i++,j++)
			{
				yearComboBox.addItem(i);
				if(i==calendar.get(Calendar.YEAR))
				{
					yearComboBox.setSelectedIndex(j);
				}
			}
		}
		return yearComboBox;
	}
	
	
	//��ʼ���������б��monthComboBox
	private JComboBox getMonthComboBox()
	{
		if(monthComboBox==null)
		{
			monthComboBox=new JComboBox();
			monthComboBox.setEditable(false);
			//����·�
			for(int i=1;i<=12;i++)
			{
				monthComboBox.addItem(String.format("%02d", i));
				if(i==calendar.get(Calendar.MONTH)+1)
				{
					monthComboBox.setSelectedIndex(i-1);
				}
			}
		}
		return monthComboBox;
	}
	
	
	//��ʼ�����������б��tiaojianComboBox
	private JComboBox getTiaojianComboBox()
	{
		if(tiaojianComboBox==null)
		{
			tiaojianComboBox=new JComboBox();
			tiaojianComboBox.setEditable(false);
			//�������ѡ��
			tiaojianComboBox.addItem("���");
			tiaojianComboBox.addItem("����");
		}
		return tiaojianComboBox;
	}
	
	
	//��ʼ�����������б��paixuComboBox
	private JComboBox getPaixuComboBox()
	{
		if(paixuComboBox==null)
		{
			
			paixuComboBox=new JComboBox();
			paixuComboBox.setEditable(false);
			//���ѡ��
			paixuComboBox.addItem("��������");
			paixuComboBox.addItem("��������");
		}
		return paixuComboBox;
	}
	
	
	//��ʼ��ȷ����ť��quedingButton
	private JButton getQuedingButton()
	{
		if(quedingButton==null)
		{
			quedingButton=new JButton("ȷ��");
			
			//��Ӽ����
			quedingButton.addActionListener(new MyListener());
			
		}
		return quedingButton;
		
	}
	
	
	/*
	 * ��ʼ��������ͱ�����
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
			String[] columnName= {"��Ʒ���", "��Ʒ����", "���۽��", "��������","���", "����", "��λ", "���", "��װ", "����", "��׼�ĺ�","���","��Ӧ��"};
			
			table=new JTable();
			table.setEnabled(false);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table.setShowGrid(true);
			table.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			
			//������������
			((DefaultTableModel)table.getModel()).setColumnIdentifiers(columnName);	
		}
		return table;
	}
	
	
	//���±�񷽷�
	private void updateTable(Iterator iter)
	{
		//ɾ������е�ԭ������
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		int row=table.getRowCount();
		for(int i=0;i<row;i++)
		{
			model.removeRow(0);
		}
		
		//�������
		while(iter.hasNext())
		{
			Vector vector=new Vector();
			List tmp=(List)iter.next();
			
			int len=tmp.size();
			for(int i=0;i<len-3;i++)
			{
				vector.add(tmp.get(i));
			}
			
			for(int i=len-2;i<len;i++)
			{
				vector.insertElementAt(tmp.get(i), 2);
			}
			
			model.addRow(vector);
		}
	}
	
	
	//ʵ��ȷ����ť�ļ�����ӿڷ���
	private final class MyListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String month_str=(String)monthComboBox.getSelectedItem();
			int year=(int)yearComboBox.getSelectedItem();
			
			String date=year + "-" + month_str;
			
			//����ͼ������ѡ���������ڵ��ڵ�ǰ���£�������Ʒ��Ž��з���
			String sql="select spid , sum(sl) as sl , sum(sl*dj) as je from v_sellview " + 
			          "where substring(xsdate,1,7) = '" + date + "' group by spid";
			
			//
			int tiaojian=tiaojianComboBox.getSelectedIndex();
			String tiaojian_str=tiaojian==0 ? "sl" : "je";
			
			int paixu=paixuComboBox.getSelectedIndex();
			String paixu_str=paixu==0 ? "asc" : "desc";
			
			List res=Dao.findForList("select * from tb_spinfo as s inner join (" + sql + 
					                ") as sp on s.id = sp.spid order by " + tiaojian_str + paixu_str);
			//���±��
			Iterator iter=res.iterator();
			updateTable(iter);
			
		}
	}
	

}
