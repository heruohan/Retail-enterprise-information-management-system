package com.lzw.iframe.KeHuGuanLi;

import javax.swing.*;
import java.awt.event.*;
import com.lzw.dao.*;
import java.sql.*;
import com.lzw.dao.model.*;
import java.awt.*;



public class KeHuTianJiaPanel extends JPanel{
	
	/*
	 * �������
	 */
	private JTextField khnameField=null;    //�ͻ�ȫ���ı���
	private JTextField khdzField=null;    //�ͻ���ַ�ı���
	private JTextField khjcField=null;    //�ͻ�����ı���
	private JTextField yzbmField=null;    //���������ı���
	private JTextField dhField=null;    //�绰�ı���
	private JTextField czField=null;    //�����ı���
	private JTextField lxrField=null;    //��ϵ���ı���
	private JTextField lxdhField=null;    //��ϵ�绰�ı���
	private JTextField emailField=null;    //E-Mail�ı���
	private JTextField khyhField=null;    //���������ı���
	private JTextField yhzhField=null;    //�����˺��ı���
	
	private JButton tjButton=null;    //��Ӱ�ť
	private JButton resetButton=null;    //���ð�ť
	
	/*
	public static void main(String[] args)
	{
		JFrame t=new JFrame();
		t.setSize(600,350);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//JDesktopPane deskpane=new JDesktopPane();
		KeHuTianJiaPanel inFrame=new KeHuTianJiaPanel();
		
		
		
		//t.getContentPane().setLayout(null);
		t.getContentPane().add(inFrame);
		//t.pack();
		t.setVisible(true);
	}
	*/
	
	//���캯��
	public KeHuTianJiaPanel()
	{
		init();
	}
	
	
	//��ʼ���ͻ�������
	private void init()
	{
		this.setLayout(new GridBagLayout());
		
		//�ͻ�ȫ��
		JLabel khnameLabel=new JLabel("�ͻ�ȫ�ƣ�");
		this.setupComponent(khnameLabel, 0, 0, 1, 0, false);
		
		khnameField=new JTextField();
		khnameField.setPreferredSize(new Dimension(500,21));
		this.setupComponent(khnameField, 1, 0, 3, 0, true);
		
		//�ͻ���ַ
		JLabel khdzLabel=new JLabel("�ͻ���ַ��");
		this.setupComponent(khdzLabel, 0, 1, 1, 0, false);
		
		khdzField=new JTextField();
		this.setupComponent(khdzField, 1, 1, 3, 0, true);
		
		
		//�ͻ����
		JLabel khjcLabel=new JLabel("�ͻ���ƣ�");
		this.setupComponent(khjcLabel, 0, 2, 1, 0, false);
		
		khjcField=new JTextField();
		khjcField.setPreferredSize(new Dimension(200,21));
		this.setupComponent(khjcField, 1, 2, 1, 0, true);
		
		//��������
		JLabel yzbmLabel=new JLabel("�������룺");
		this.setupComponent(yzbmLabel, 2, 2, 1, 0, false);
		
		yzbmField=new JTextField();
		this.setupComponent(yzbmField, 3, 2, 1, 0, true);
		
		//�绰
		JLabel dhLabel=new JLabel("�绰��");
		this.setupComponent(dhLabel, 0, 3, 1, 0, false);
		
		dhField=new JTextField();
		this.setupComponent(dhField, 1, 3, 1, 0, true);
		
		
		//����
		JLabel czLabel=new JLabel("���棺");
		this.setupComponent(czLabel, 2, 3, 1, 0, false);
		
		czField=new JTextField();
		this.setupComponent(czField, 3, 3, 1, 0, true);
		
		
		//��ϵ��
		JLabel lxrLabel=new JLabel("��ϵ�ˣ�");
		this.setupComponent(lxrLabel, 0, 4, 1, 0, false);
		
		lxrField=new JTextField();
		this.setupComponent(lxrField, 1, 4, 1, 0, true);
		
		//��ϵ�绰
		JLabel lxdhLabel=new JLabel("��ϵ�绰��");
		this.setupComponent(lxdhLabel, 2, 4, 1, 0, false);
		
		lxdhField=new JTextField();
		this.setupComponent(lxdhField, 3, 4, 1, 0, true);
		
		//E-Mail
		JLabel emailLabel=new JLabel("E-Mail��");
		this.setupComponent(emailLabel, 0, 5, 1, 0, false);
		
		emailField=new JTextField();
		this.setupComponent(emailField, 1, 5, 3, 0, true);
		
		//��������
		JLabel khyhLabel=new JLabel("�������У�");
		this.setupComponent(khyhLabel, 0, 6, 1, 0, false);
		
		khyhField=new JTextField();
		this.setupComponent(khyhField, 1, 6, 1, 0, true);
		
		
		//�����˺�
		JLabel yhzhLabel=new JLabel("�����˺ţ�");
		this.setupComponent(yhzhLabel, 2, 6, 1, 0, false);
		
		yhzhField=new JTextField();
		this.setupComponent(yhzhField, 3, 6, 1, 0, true);
		
		
		//
		JPanel pane=new JPanel();
		FlowLayout layout=new FlowLayout();
		layout.setHgap(50);
		pane.setLayout(layout);
		pane.add(this.getTjButton());
		pane.add(this.getResetButton());
		this.setupComponent(pane, 0, 7, 4, 0, true);
		
		//��Ӱ�ť��tjButton
		//this.setupComponent(this.getTjButton(), 1, 7, 1, 0, false);
		
		//���ð�ť��resetButton
		//this.setupComponent(this.getResetButton(), 2, 7, 1, 0, false);
		
		
	}
	
	
	//���ָ����
	private void setupComponent(JComponent component,int gridx,int gridy,int gridwidth,int ipadx,boolean fill)
	{
		GridBagConstraints constraint=new GridBagConstraints();
		constraint.gridx=gridx;
		constraint.gridy=gridy;
		
		constraint.insets=new Insets(5,3,5,3);
		
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
		
		this.add(component, constraint);
		
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
					//�ж������ı������Ƿ���Ϊ�յ�����
					if(khnameField.getText().isEmpty() || khdzField.getText().isEmpty() ||
					   khjcField.getText().isEmpty() || yzbmField.getText().isEmpty() || 
					   dhField.getText().isEmpty() || czField.getText().isEmpty() || 
					   lxrField.getText().isEmpty() || lxdhField.getText().isEmpty() || 
					   emailField.getText().isEmpty() || khyhField.getText().isEmpty() ||
					   yhzhField.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(KeHuTianJiaPanel.this, "����дȫ����Ϣ");
						return;
					}
					
					//�жϵ�ǰ�ͻ��Ƿ��Ѿ������ݿ���
					ResultSet rs=Dao.query("select * from tb_khinfo where khname='" + khnameField.getText().trim() + "'");
					
					try
					{
						if(rs.next())
						{
							JOptionPane.showMessageDialog(KeHuTianJiaPanel.this,"�ͻ���Ϣ���ʧ�ܣ�����ͬ���ͻ�", "�ͻ���Ϣ���", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
					}
					
					
					//�ҳ����ݿ��е����ͻ�ID
					ResultSet re=Dao.query("select max(id) from tb_khinfo");
					String id=null;
					try
					{
						if(re.next())
						{
							String tmp=re.getString(1);
							if(tmp==null)
							{
								id="kh1000";
							}
							else
							{
								String sub_str=tmp.substring(2);
								id="kh" + (Integer.parseInt(sub_str) + 1);
							}	
						}
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
					}
					
					
					//��ȡ�˿ͻ�ID�󣬹���TbKhinfo��
					TbKhinfo khinfo=new TbKhinfo();
					khinfo.setId(id);
					khinfo.setKhname(khnameField.getText().trim());
					khinfo.setJian(khjcField.getText().trim());
					khinfo.setAddress(khdzField.getText().trim());
					khinfo.setBianma(yzbmField.getText().trim());
					khinfo.setTel(dhField.getText().trim());
					khinfo.setFax(czField.getText().trim());
					khinfo.setLian(lxrField.getText().trim());
					khinfo.setLtel(lxdhField.getText().trim());
					khinfo.setMail(emailField.getText().trim());
					khinfo.setXinhang(khyhField.getText().trim());
					khinfo.setHao(yhzhField.getText().trim());
					
					//��ӽ����ݼ�
					Dao.addKeHu(khinfo);
					JOptionPane.showMessageDialog(KeHuTianJiaPanel.this, "��ӿͻ���Ϣ�ɹ�", "�ͻ���Ϣ���", JOptionPane.INFORMATION_MESSAGE);
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
					khnameField.setText("");
					khdzField.setText("");
					khjcField.setText("");
					yzbmField.setText("");
					dhField.setText("");
					czField.setText("");
					lxrField.setText("");
					lxdhField.setText("");
					emailField.setText("");
					khyhField.setText("");
					yhzhField.setText("");
					
				}
					});
		}
		return resetButton;
	}
	

}
