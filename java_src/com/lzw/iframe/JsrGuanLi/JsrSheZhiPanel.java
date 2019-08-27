package com.lzw.iframe.JsrGuanLi;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import com.lzw.dao.*;

import java.util.Iterator;
import java.util.List;
import com.lzw.iframe.*;
import java.awt.*;


public class JsrSheZhiPanel extends JPanel{
	
	private JScrollPane scrollPane=null;    //�������
	private JTable table=null;    //���
	private DefaultTableModel model=null;    //���ģ��
	private String[] columnName=null;    //����
	
	
	private JTextField nameField=null;    //����
	private JTextField sexField=null;    //�Ա�
	private JTextField ageField=null;    //����
	private JTextField telField=null;    //��ϵ�绰
	
	
	private JButton on_offButton=null;    //����/���ð�ť
	private JButton delButton=null;    //ɾ����ť
	private JButton gbButton=null;    //�رհ�ť
	private JButton xgButton=null;    //�޸İ�ť
	
	/*
	public static void main(String[] args)
	{
		JFrame t=new JFrame();
		t.setSize(600,350);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//JDesktopPane deskpane=new JDesktopPane();
		JsrSheZhiPanel inFrame=new JsrSheZhiPanel();
		
		
		
		//t.getContentPane().setLayout(null);
		t.getContentPane().add(inFrame);
		//t.pack();
		t.setVisible(true);
	}
	*/
	
	//���캯��
	public JsrSheZhiPanel()
	{
		init();
	}
	
	
	//��ʼ���������������
	private void init()
	{
		this.setLayout(new GridBagLayout());
		
		//������
		scrollPane=this.getScrollPane();
		scrollPane.setPreferredSize(new Dimension(570,180));
		this.setupComponent(this.getScrollPane(), 0, 0, 4, true);
		
		
		//����
		JLabel nameLabel=new JLabel("������");
		this.setupComponent(nameLabel, 0, 1, 1, false);
		
		nameField=new JTextField();
		nameField.setEditable(false);
		nameField.setPreferredSize(new Dimension(200,24));
		this.setupComponent(nameField, 1, 1, 1, true);
		
		
		//�Ա�
		JLabel sexLabel=new JLabel("�Ա�");
		this.setupComponent(sexLabel, 2, 1, 1, false);
		
		sexField=new JTextField();
		sexField.setEditable(false);
		this.setupComponent(sexField, 3, 1, 1, true);
		
		
		//����
		JLabel ageLabel=new JLabel("���䣺");
		this.setupComponent(ageLabel, 0, 2, 1, false);
		
		ageField=new JTextField();
		this.setupComponent(ageField, 1, 2, 1, true);
		
		
		//��ϵ�绰
		JLabel telLabel=new JLabel("��ϵ�绰��");
		this.setupComponent(telLabel, 2, 2, 1, false);
		
		telField=new JTextField();
		this.setupComponent(telField, 3, 2, 1, true);
		
		
		//��ť
		JPanel panel=new JPanel();
		FlowLayout layout=new FlowLayout();
		layout.setHgap(40);
		panel.setLayout(layout);
		panel.add(this.getXgButton());
		panel.add(this.getOn_offButton());
		panel.add(this.getDelButton());
		panel.add(this.getGbButton());
		this.setupComponent(panel, 0, 3, 4, true);
		//this.setupComponent(this.getXgButton(), 0, 3, 1, false);
		//this.setupComponent(this.getOn_offButton(), 1, 3, 1, false);
		//this.setupComponent(this.getDelButton(), 2, 3, 1, false);
		//this.setupComponent(this.getGbButton(), 3, 3, 1, false);
		

	}
	
	
	
	//��ʼ���������
	private void setupComponent(JComponent component,int gridx,int gridy,int gridwidth,boolean fill)
	{
		GridBagConstraints constraint=new GridBagConstraints();
		constraint.gridx=gridx;
		constraint.gridy=gridy;
		constraint.insets=new Insets(2,2,2,2);
		
		if(gridwidth>1)
		{
			constraint.gridwidth=gridwidth;
		}
		
		if(fill)
		{
			constraint.fill=GridBagConstraints.HORIZONTAL;
		}
		
		this.add(component, constraint);
		
	}
	
	
	
	//��ʼ��������壺scrollPane
	private JScrollPane getScrollPane()
	{
		if(scrollPane==null)
		{
			scrollPane=new JScrollPane();
			scrollPane.setViewportView(this.getTable());
			
		}
		return scrollPane;
	}
	
	
	//��ʼ�����table
	private JTable getTable()
	{
		if(table==null)
		{
			table=new JTable();
			table.setShowGrid(true);
			//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			model=(DefaultTableModel)table.getModel();
			columnName=new String[]{"���","����","�Ա�","����","��ϵ�绰","����"};
			model.setColumnIdentifiers(columnName);
			
			//��Ӽ����
			table.addMouseListener(new MouseAdapter()
					{
				public void mouseClicked(MouseEvent e)
				{
					int index=table.getSelectedRow();
					if(index<0)
					{
						return;
					}
					
					//������������ı���
					nameField.setText(table.getValueAt(index, 1).toString().trim());
					sexField.setText(table.getValueAt(index, 2).toString().trim());
					ageField.setText(table.getValueAt(index, 3).toString().trim());
					telField.setText(table.getValueAt(index, 4).toString().trim());
				}
					});
		}
		return table;
	}
	
	
	//��ʼ������/���ð�ť��on_offButton
	private JButton getOn_offButton()
	{
		if(on_offButton==null)
		{
			on_offButton=new JButton("����/����");
			
			//��Ӽ����
			on_offButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					int index=table.getSelectedRow();
					if(index<0)
					{
						return;
					}
					
					int confirm=JOptionPane.showConfirmDialog(JsrSheZhiPanel.this, "ȷ���޸Ĵ˾����˵�״̬��");
					if(confirm==JOptionPane.YES_OPTION)
					{
						String id=table.getValueAt(index, 0).toString().trim();
						int res=Dao.update("update tb_jsr set enable=abs(enable-1) where id='" + id + "'");
						if(res>0)
						{
							JOptionPane.showMessageDialog(JsrSheZhiPanel.this, "�޸ĳɹ���");
							//���³�ʼ�������ı���
							updateTable();
						}
					}
				}
					});
		}
		return on_offButton;
	}
	
	
	//��ʼ��ɾ����ť��delButton
	private JButton getDelButton()
	{
		if(delButton==null)
		{
			delButton=new JButton("ɾ��");
			
			//��Ӽ����
			delButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					int index=table.getSelectedRow();
					if(index<0)
					{
						return;
					}
					
					int confirm=JOptionPane.showConfirmDialog(JsrSheZhiPanel.this, "ȷ��ɾ���˾�������");
					if(confirm==JOptionPane.YES_OPTION)
					{
						String id=table.getValueAt(index, 0).toString().trim();
						int res=Dao.delete("delete from tb_jsr where id='" + id + "'");
						if(res>0)
						{
							JOptionPane.showMessageDialog(JsrSheZhiPanel.this, "ɾ���ɹ�");
							//���±����ı���
							updateTable();
						}
						
					}
				}
					});
		}
		return delButton;
	}
	
	
	
	//��ʼ���رհ�ť��gbButton
	private JButton getGbButton()
	{
		if(gbButton==null)
		{
			gbButton=new JButton("�ر�");
			
			//��Ӽ����
			gbButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					JsrGuanLi_IFrame frame=(JsrGuanLi_IFrame)JsrSheZhiPanel.this.getRootPane().getParent();
					frame.doDefaultCloseAction();
				}
					});
			
		}
		return gbButton;
	}
	
	
	
	//��ʼ���޸İ�ť��xgButton
	private JButton getXgButton()
	{
		if(xgButton==null)
		{
			xgButton=new JButton("�޸�");
			
			//��Ӽ����
			xgButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					int row=table.getSelectedRow();
					if(row<0)
					{
						return;
					}
					
					int confirm=JOptionPane.showConfirmDialog(JsrSheZhiPanel.this, "ȷ���޸��������ϵ�绰��");
					if(confirm==JOptionPane.YES_OPTION)
					{
						String id=table.getValueAt(row, 0).toString().trim();
						String age=ageField.getText();
						String tel=telField.getText();
						
						//���¾��������ݿ�
						int res=Dao.update("update tb_jsr set age='" + age + "',tel='" + tel + "' where id='" + id + "'");
						if(res>0)
						{
							JOptionPane.showMessageDialog(JsrSheZhiPanel.this, "�޸ĳɹ�");
							updateTable();
						}
						
					}
				}
					});
		}
		return xgButton;
	}
	
	
	
	//�����ı���
	private void updateAllField()
	{
		nameField.setText("");
		sexField.setText("");
		ageField.setText("");
	}
	
	
	
	//���±��
	public void updateTable()
	{
		this.updateAllField();
		List lst=Dao.getJsrs();
		
		//��ʼ��������ݺ�����
		model.setDataVector(null, columnName);
		
		String[] row=new String[6];
		for(Iterator<List> iter=lst.iterator();iter.hasNext();)
		{
			List tmp=iter.next();
			row[0]=tmp.get(0).toString().trim();
			row[1]=tmp.get(1).toString().trim();
			row[2]=tmp.get(2).toString().trim();
			row[3]=tmp.get(3).toString().trim();
			row[4]=tmp.get(4).toString().trim();
			row[5]=(tmp.get(5).toString().trim()).equals("1") ? "����" : "����";
			model.addRow(row);
		}
		
	}

}
