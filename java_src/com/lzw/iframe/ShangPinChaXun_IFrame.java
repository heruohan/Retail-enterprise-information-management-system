package com.lzw.iframe;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.util.List;
import com.lzw.dao.*;
import java.util.*;
import com.lzw.*;
import com.lzw.dao.model.*;
import java.awt.*;


public class ShangPinChaXun_IFrame extends JInternalFrame{
	
	/*
	 * �ڲ������ϵĸ������
	 */
	private JComboBox tiaojianComboBox=null;    //��ѯ���������б��
	private JComboBox jingqueComboBox=null;    //��ȷ�����������б��
	private JTextField contentField=null;    //��ѯ�����ı���
	
	private JButton chaxunButton=null;    //��ѯ��ť
	private JButton showAllButton=null;    //��ʾȫ�����ݰ�ť
	
	private JScrollPane tablePane=null;    //������
	private JTable table=null;    //���
	
	/*
	public static void main(String[] args)
	{
		JFrame t=new JFrame();
		t.setSize(800, 600);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane deskpane=new JDesktopPane();
		ShangPinChaXun_IFrame inFrame=new ShangPinChaXun_IFrame();
		
		
		deskpane.add(inFrame);
		inFrame.setVisible(true);
		
		t.setContentPane(deskpane);
		t.setVisible(true);
	}
	*/
	
	//���캯��
	public ShangPinChaXun_IFrame()
	{
		init();
	}
	
	
	//��ʼ����Ʒ��ѯ�ڲ�����
	private void init()
	{
		//�����ڲ����������
		this.setTitle("��Ʒ��Ϣ��ѯ");
		this.setMaximizable(true);
		this.setIconifiable(true);
		this.setResizable(true);
		this.setClosable(true);
		this.getContentPane().setLayout(new GridBagLayout());
		this.setBounds(50, 50, 600, 320);
		
		
		//���ô�������
		final JLabel label=new JLabel("��ѡ���ѯ������");
		this.setupComponent(label, 0, 0, 1, 0, false);
		
		//��ѯ���������б��tiaojianComboBox
		this.setupComponent(this.getTiaojianComboBox(), 1, 0, 1, 0, true);
		
		//��ȷ�����������б��jingqueComboBox
		jingqueComboBox=this.getJingqueComboBox();
		//jingqueComboBox.setPreferredSize(new Dimension(60,28));
		this.setupComponent(this.getJingqueComboBox(), 2, 0, 1, 0, true);
		
		//�����ı���contentField
		contentField=this.getContentField();
		contentField.setPreferredSize(new Dimension(120,21));
		this.setupComponent(this.getContentField(), 3, 0, 1, 0, true);
		
		//��ѯ��ť��chaxunButton
		this.setupComponent(this.getChaxunButton(), 4, 0, 1, 0, false);
		
		//��ʾȫ�����ݰ�ť��showAllButton
		this.setupComponent(this.getShowAllButton(), 5, 0, 1, 0, false);
		
		
		//�����������tablePane
		tablePane=this.getTablePane();
		tablePane.setPreferredSize(new Dimension(570,240));
		this.setupComponent(this.getTablePane(), 0, 1, 6, 0, true);
		
	}
	
	
	//����������ڲ������ϵ�λ��
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
	
	
	
	//��ʼ����ѯ���������б��tiaojianComboBox
	private JComboBox getTiaojianComboBox()
	{
		if(tiaojianComboBox==null)
		{
			tiaojianComboBox=new JComboBox();
			tiaojianComboBox.addItem("��Ʒ����");
			tiaojianComboBox.addItem("��Ӧ������");
			tiaojianComboBox.addItem("����");
			tiaojianComboBox.addItem("���");
		}
		return tiaojianComboBox;
	}
	
	
	//��ʼ����ȷ�����������б��jingqueComboBox
	private JComboBox getJingqueComboBox()
	{
		if(jingqueComboBox==null)
		{
			jingqueComboBox=new JComboBox();
			jingqueComboBox.addItem("����");
			jingqueComboBox.addItem("����");
			
		}
		return jingqueComboBox;
	}
	
	
	//��ʼ�������ı���contentField
	private JTextField getContentField()
	{
		if(contentField==null)
		{
			contentField=new JTextField();
			//��Ӽ����
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
	private JButton getChaxunButton()
	{
		if(chaxunButton==null)
		{
			chaxunButton=new JButton("��ѯ");
			
			//���ִ�в�ѯ�����ļ����
			chaxunButton.addActionListener(new MyListener());
			
		}
		return chaxunButton;
	}
	
	
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
					contentField.setText("");
					List lst=Dao.getSpinfos();
					updateTable(lst);
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
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table.setEnabled(false);
			table.setShowGrid(true);
			
			//�������
			String[] columnname= {"��Ʒ���", "��Ʒ����", "���", "����", "��λ","���", "��װ", "����", "��׼�ĺ�", "��Ӧ��ȫ��", "��ע"};
			((DefaultTableModel)table.getModel()).setColumnIdentifiers(columnname);
		}
		return table;
	}
	
	
	
	//���ò�ѯ��ִ�в��������
	private final class MyListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String tiaojian_str=tiaojianComboBox.getSelectedItem().toString();    //��ѯ����
			String jingque_str=jingqueComboBox.getSelectedItem().toString();    //��ѯ��ȷ��
			
			String content=contentField.getText();
			if(content.isEmpty())
			{
				JOptionPane.showMessageDialog(ShangPinChaXun_IFrame.this, "�������ѯ����");
				return;
			}
			
			//���ݲ�ѯ��������SQL��䣬��������Ʒ�Ĳ�ѯ��ά������
			List res=null;
			String sql="select * from tb_spinfo where ";
			/*
			 * ����res�ķ���ֵ�ض���Ϊnull����ʹΪ���б�
			 */
			if(jingque_str.equals("����"))
			{
				if(tiaojian_str.equals("��Ʒ����"))
				{
					res=Dao.findForList(sql + "spname='" + content + "'");
				}
				else if(tiaojian_str.equals("��Ӧ������"))
				{
					res=Dao.findForList(sql + "gysname='" + content + "'");
				}
				else if(tiaojian_str.equals("����"))
				{
					res=Dao.findForList(sql + "cd='" + content + "'");
				}
				else if(tiaojian_str.equals("���"))
				{
					res=Dao.findForList(sql + "gg='" + content + "'");
				}
			}
			else
			{
				if(tiaojian_str.equals("��Ʒ����"))
				{
					res=Dao.findForList(sql + "spname like '%" + content + "%'");
				}
				else if(tiaojian_str.equals("��Ӧ������"))
				{
					res=Dao.findForList(sql + "gysname like '%" + content + "%'");
				}
				else if(tiaojian_str.equals("����"))
				{
					res=Dao.findForList(sql + "cd like '%" + content + "%'");
				}
				else if(tiaojian_str.equals("���"))
				{
					res=Dao.findForList(sql + "gg like '%" + content + "%'");
				}
			}
			
			//���ݽ�������±��
			updateTable(res);
		}
	}
	
	
	//���±�񷽷�
	private void updateTable(List lst)
	{
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		//��ձ��
		int row=table.getRowCount();
		for(int i=0;i<row;i++)
		{
			model.removeRow(0);
		}
		
		Iterator iter=lst.iterator();
		while(iter.hasNext())
		{
			List<String> tmp=(List<String>)iter.next();
			Item item=new Item();
			item.setId(tmp.get(0));
			item.setName(tmp.get(1));
			TbSpinfo info=Dao.getSpinfo(item);
			
			//��������
			Vector v=new Vector();
			v.add(info.getId());
			v.add(info.getSpname());
			v.add(info.getJc());
			v.add(info.getCd());
			v.add(info.getDw());
			v.add(info.getGg());
			v.add(info.getBz());
			v.add(info.getPh());
			v.add(info.getPzwh());
			v.add(info.getGysname());
			v.add(info.getMemo());
			
			//������뵽���ģ����
			model.addRow(v);
		}
	}
}
