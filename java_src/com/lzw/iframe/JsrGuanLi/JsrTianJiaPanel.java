package com.lzw.iframe.JsrGuanLi;

import javax.swing.*;
import java.awt.event.*;
import com.lzw.*;
import com.lzw.dao.*;
import com.lzw.dao.model.*;
import java.awt.*;


public class JsrTianJiaPanel extends JPanel{
	
	/*
	 * �������
	 */
	private JTextField nameField=null;    //����
	private JComboBox sexComboBox=null;    //�Ա������б��
	private JTextField ageField=null;    //����
	private JTextField telField=null;    //�绰
	
	private JButton tjButton=null;    //��Ӱ�ť
	private JButton resetButton=null;    //���ð�ť
	
	
	/*
	public static void main(String[] args)
	{
		JFrame t=new JFrame();
		t.setSize(600,350);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//JDesktopPane deskpane=new JDesktopPane();
		JsrTianJiaPanel inFrame=new JsrTianJiaPanel();
		
		
		
		//t.getContentPane().setLayout(null);
		t.getContentPane().add(inFrame);
		//t.pack();
		t.setVisible(true);
	}
	*/
	
	
	//���캯��
	public JsrTianJiaPanel()
	{
		init();
	}
	
	
	//��ʼ��������������
	private void init()
	{
		this.setLayout(new GridBagLayout());
		
		//����
		JLabel nameLabel=new JLabel("������");
		this.setupComponent(nameLabel, 0, 0, 1, false);
		
		nameField=new JTextField();
		nameField.setPreferredSize(new Dimension(480,24));
		this.setupComponent(nameField, 1, 0, 1, true);
		
		
		//�Ա�
		JLabel sexLabel=new JLabel("�Ա�");
		this.setupComponent(sexLabel, 0, 1, 1, false);
		
		this.setupComponent(this.getSexComboBox(), 1, 1, 1, true);
		
		
		//����
		JLabel ageLabel=new JLabel("���䣺");
		this.setupComponent(ageLabel, 0, 2, 1, false);
		
		ageField=new JTextField();
		this.setupComponent(ageField, 1, 2, 1, true);
		
		
		//�绰
		JLabel telLabel=new JLabel("�绰��");
		this.setupComponent(telLabel, 0, 3, 1, false);
		
		telField=new JTextField();
		this.setupComponent(telField, 1, 3, 1, true);
		
		
		//��Ӻ����ð�ť
		JPanel pane=new JPanel();
		((FlowLayout)pane.getLayout()).setHgap(50);
		pane.add(this.getTjButton());
		pane.add(this.getResetButton());
		this.setupComponent(pane, 0, 4, 2, true);
	}
	
	
	
	//��������ķ���
	private void setupComponent(JComponent component,int gridx,int gridy,int gridwidth,boolean fill)
	{
		GridBagConstraints constraint=new GridBagConstraints();
		constraint.gridx=gridx;
		constraint.gridy=gridy;
		constraint.insets=new Insets(5,3,5,3);
		
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
	
	
	
	//��ʼ���Ա������б��sexComboBox
	private JComboBox getSexComboBox()
	{
		if(sexComboBox==null)
		{
			sexComboBox=new JComboBox();
			sexComboBox.setEditable(false);
			sexComboBox.addItem("��");
			sexComboBox.addItem("Ů");
		}
		return sexComboBox;
	}
	
	
	
	
	//��ʼ����Ӱ�ť��tjButton
	private JButton getTjButton()
	{
		if(tjButton==null)
		{
			tjButton=new JButton("���");
			
			//��Ӽ����
			tjButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					String jsr_name=nameField.getText().trim();
					if(jsr_name.isEmpty() || ageField.getText().isEmpty() || telField.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(JsrTianJiaPanel.this, "����д������������Ϣ");
						return;
					}
					
					//�жϾ��������ݿ����Ƿ��Ѿ��д˾�����
					Item item=new Item();
					item.setName(jsr_name);
					TbJsr jsr=Dao.getJsr(item);
					if(jsr.getName()!=null && jsr.getName().equals(jsr_name) && jsr.getSex().equals(sexComboBox.getSelectedItem()) &&
						jsr.getAge().equals(ageField.getText().trim()) && jsr.getTel().equals(telField.getText().trim()))
					{
						JOptionPane.showMessageDialog(JsrTianJiaPanel.this, "������" + jsr_name + "�Ѿ�����");
						return;
					}
					
					//���쾭����TbJsr��
					String sex=sexComboBox.getSelectedItem().toString();
					TbJsr tbjsr=new TbJsr();
					tbjsr.setName(jsr_name);
					tbjsr.setSex(sex);
					tbjsr.setAge(ageField.getText().trim());
					tbjsr.setTel(telField.getText().trim());
					
					int res=Dao.addJsr(tbjsr);
					if(res>0)
					{
						JOptionPane.showMessageDialog(JsrTianJiaPanel.this, "��ӳɹ�");
					}
					
					resetButton.doClick();
				}
					});
		}
		return tjButton;
	}
	
	
	//��ʼ�����ð�ť��resetButton
	private JButton getResetButton()
	{
		if(resetButton==null)
		{
			resetButton=new JButton("����");
			
			//��Ӽ����
			resetButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					nameField.setText("");
					ageField.setText("");
					telField.setText("");
				}
					});
		}
		return resetButton;
	}
	

}
