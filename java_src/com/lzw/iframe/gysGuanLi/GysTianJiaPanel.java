package com.lzw.iframe.gysGuanLi;

import javax.swing.*;
import java.awt.event.*;
import com.lzw.dao.*;
import java.sql.*;
import com.lzw.dao.model.*;
import java.awt.*;



public class GysTianJiaPanel extends JPanel{
	
	/*
	 * ���ø����
	 */
	private JTextField gysnameField=null;     //��Ӧ������
	private JTextField jcField=null;    //���
	private JTextField yzbmField=null;    //��������
	private JTextField dzField=null;    //��ַ
	private JTextField dhField=null;     //�绰
	private JTextField czField=null;    //����
	private JTextField lxrField=null;    //��ϵ��
	private JTextField lxrdhField=null;    //��ϵ�绰
	private JTextField khyhField=null;    //��������
	private JTextField dzxxField=null;    //��������
	
	private JButton tjButton=null;    //��Ӱ�ť
	private JButton resetButton=null;     //���ð�ť
	
	/*
	public static void main(String[] args)
	{
		JFrame t=new JFrame();
		t.setSize(600,400);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//JDesktopPane deskpane=new JDesktopPane();
		GysTianJiaPanel inFrame=new GysTianJiaPanel();
		
		
		
		//t.getContentPane().setLayout(null);
		t.getContentPane().add(inFrame);
		//t.pack();
		t.setVisible(true);
	}
	*/
	
	//���캯��
	public GysTianJiaPanel()
	{
		init();
	}
	
	
	//��ʼ����Ӧ��������
	private void init()
	{
		this.setLayout(new GridBagLayout());
		
		//��Ӧ��ȫ��
		JLabel gysnameLabel=new JLabel("��Ӧ��ȫ�ƣ�");
		this.setupComponent(gysnameLabel, 0, 0, 1, 0, false);
		
		gysnameField=new JTextField();
		gysnameField.setPreferredSize(new Dimension(480,21));
		this.setupComponent(gysnameField, 1, 0, 3, 0, true);
		
		
		//���
		JLabel jcLabel=new JLabel("��ƣ�");
		this.setupComponent(jcLabel, 0, 1, 1, 0, false);
		
		jcField=new JTextField();
		jcField.setPreferredSize(new Dimension(200,21));
		this.setupComponent(jcField, 1, 1, 1, 0, true);
		
		//��������
		JLabel yzbmLabel=new JLabel("�������룺");
		this.setupComponent(yzbmLabel, 2, 1, 1, 0, false);
		
		yzbmField=new JTextField();
		this.setupComponent(yzbmField, 3, 1, 1, 0, true);
		
		//��ַ
		JLabel dzLabel=new JLabel("��ַ��");
		this.setupComponent(dzLabel, 0, 2, 1, 0, false);
		
		dzField=new JTextField();
		this.setupComponent(dzField, 1, 2, 3, 0, true);
		
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
		
		
		//��ϵ�˵绰
		JLabel lxrdhLabel=new JLabel("��ϵ�˵绰��");
		this.setupComponent(lxrdhLabel, 2, 4, 1, 0, false);
		
		lxrdhField=new JTextField();
		this.setupComponent(lxrdhField, 3, 4, 1, 0, true);
		
		
		//��������
		JLabel khyhLabel=new JLabel("�������У�");
		this.setupComponent(khyhLabel, 0, 5, 1, 0, false);
		
		khyhField=new JTextField();
		this.setupComponent(khyhField, 1, 5, 1, 0, true);
		
		//��������
		JLabel dzxxLabel=new JLabel("�������䣺");
		this.setupComponent(dzxxLabel, 2, 5, 1, 0, false);
		
		dzxxField=new JTextField();
		this.setupComponent(dzxxField, 3, 5, 1, 0, true);
		
		//��Ӱ�ť
		JPanel pane=new JPanel();
		FlowLayout layout=new FlowLayout();
		layout.setHgap(40);
		pane.setLayout(layout);
		pane.add(this.getTjButton());
		pane.add(this.getResetButton());
		
		this.setupComponent(pane, 0, 6, 4, 0, true);
		
	}
	
	
	//���ø���������ķ���
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
	
	
	
	//��ʼ����Ӱ�ť:tjButton
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
					if(gysnameField.getText().isEmpty() || jcField.getText().isEmpty() ||
					  yzbmField.getText().isEmpty() || dzField.getText().isEmpty() || 
					  dhField.getText().isEmpty() || czField.getText().isEmpty() || 
					  lxrField.getText().isEmpty() || lxrdhField.getText().isEmpty() ||
					  khyhField.getText().isEmpty() || dzxxField.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(GysTianJiaPanel.this, "����д������Ϣ");
						return;
					}
					
					//�жϹ�Ӧ�����ݿ����Ƿ��Ѿ��д˹�Ӧ��
					ResultSet rs=Dao.query("select * from tb_gysinfo where name='" + gysnameField.getText().trim() + "'");
					
					try
					{
						if(rs.next())
						{
							JOptionPane.showMessageDialog(GysTianJiaPanel.this, "��Ϣ���ʧ�ܣ�����ͬ����Ӧ��", "��Ϣ���", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
					}
					
					
					//��ȡ��Ӧ�̵�ID
					ResultSet re=Dao.query("select max(id) from tb_gysinfo");
					String id=null;
					try
					{
						if(re.next())
						{
							String tmp=re.getString(1);
							if(tmp==null)
							{
								id="gys1000";
							}
							else
							{
								String sub_tmp=tmp.substring(3);
								id="gys" + (Integer.parseInt(sub_tmp)+1);
							}
						}
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
					}
					
					
					//����TbGysinfo
					TbGysinfo gysinfo=new TbGysinfo();
					gysinfo.setId(id);
					gysinfo.setName(gysnameField.getText().trim());
					gysinfo.setJc(jcField.getText().trim());
					gysinfo.setAddress(dzField.getText().trim());
					gysinfo.setBianma(yzbmField.getText().trim());
					gysinfo.setTel(dhField.getText().trim());
					gysinfo.setFax(czField.getText().trim());
					gysinfo.setLian(lxrField.getText().trim());
					gysinfo.setLtel(lxrdhField.getText().trim());
					gysinfo.setYh(khyhField.getText().trim());
					gysinfo.setMail(dzxxField.getText().trim());
					
					//��ӽ����ݿ�
					Dao.addGys(gysinfo);
					JOptionPane.showMessageDialog(GysTianJiaPanel.this, "��Ӧ����Ϣ��ӳɹ�");
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
					gysnameField.setText("");
					jcField.setText("");
					yzbmField.setText("");
					dzField.setText("");
					dhField.setText("");
					czField.setText("");
					lxrField.setText("");
					lxrdhField.setText("");
					khyhField.setText("");
					dzxxField.setText("");
				}
					});
		}
		return resetButton;
	}
	

}
