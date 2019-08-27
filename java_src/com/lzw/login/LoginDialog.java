package com.lzw.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import com.lzw.dao.*;
import com.lzw.*;


public class LoginDialog extends JFrame{    //��¼��������
	private static final long serialVersionUID = 1L;
	private LoginPanel loginPanel=null;    //��¼���
	
	private JLabel jLabel=null;    //�û�����ǩ
	private JTextField userField=null;   //�û����ı���
	
	private JLabel jLabel1=null;    //�����ǩ
	private JPasswordField passwordField=null;    //�����ı���
	
	private JButton loginButton=null;    //��¼��ť
	private JButton exitButton=null;    //�˳���ť
	
	private static String userStr;    //�û����ı����е�����
	private MainFrame mainFrame;    //���崰��
	

	//���캯��
	public LoginDialog()
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			mainFrame=new MainFrame();    //ʵ�������ⴰ��
			init();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	//��ʼ����¼����
	private void init()
	{
		Dimension size=this.getToolkit().getScreenSize();
		this.setLocation((size.width - 296) / 2, (size.height-188)/2);
		this.setSize(296, 188);
		this.setTitle("ϵͳ��¼");
		this.setResizable(false);    //��¼�����С���ɱ�
		this.setContentPane(getLoginPanel());
	}
	
	//��ʼ����¼��壺loginPanel
	private LoginPanel getLoginPanel()
	{
		if(loginPanel==null)
		{
			//�û�����ǩ
			jLabel=new JLabel();
			jLabel.setText("�û�����");
			jLabel.setBounds(new Rectangle(85, 41, 56, 18));
			
			//�����ǩ
			jLabel1=new JLabel();
			jLabel1.setText("���룺");
			jLabel1.setBounds(new Rectangle(86, 71, 55, 18));
			
			//��ʼ����¼���
			loginPanel=new LoginPanel();
			loginPanel.setLayout(null);
			loginPanel.setBackground(new Color(0xD8DDC7));
			
			//�ڵ�¼�������Ӹ������
			//�û���������
			loginPanel.add(jLabel);
			loginPanel.add(getUserField());
			
			//����������
			loginPanel.add(jLabel1);
			loginPanel.add(getPasswordField());
			
			//��¼��ť
			loginPanel.add(getLoginButton());
			//�˳���ť
			loginPanel.add(getExitButton());
		}
		return loginPanel;
		
	}
	
	
	
	//��ʼ���û����ı���:userField
	private JTextField getUserField()
	{
		if(userField==null)
		{
			userField=new JTextField();
			userField.setBounds(new Rectangle(142, 39, 127, 22));    //�����û����ı����λ�úͿ��
		}
		return userField;
	}
	
	
	//��ʼ�������ı���:passwordField
	private JPasswordField getPasswordField()
	{
		if(passwordField==null)
		{
			passwordField=new JPasswordField();
			passwordField.setBounds(new Rectangle(143,69,125,22));
			passwordField.addKeyListener(new KeyAdapter()
					{
				public void keyTyped(KeyEvent e)
				{
					if(e.getKeyChar()=='\n')
					{
						loginButton.doClick();
					}
				}
					});
		}
		
		return passwordField;
	}
	
	
	
	//��ʼ����¼��ť:loginButton
	private JButton getLoginButton()
	{
		if(loginButton==null)
		{
			loginButton=new JButton();
			loginButton.setBounds(new Rectangle(109, 114, 48, 20));
			
			URL url=this.getClass().getResource("/res/loginButton.jpg");    //�õ�ͼƬ��λ��
			Icon icon=new ImageIcon(url);    //���ͼ��
			loginButton.setIcon(icon);    //Ϊ��ť���ͼ��
			
			loginButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					try
					{
						//���ñ���ϵͳ�����ʽ
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
						userStr=userField.getText();    //��ȡ�û���
						String passwordStr=new String(passwordField.getPassword());    //��ȡ����
						
						if(!Dao.checkLogin(userStr, passwordStr))    //�����û����������Ƿ���ȷ
						{
							System.out.println(111);
							JOptionPane.showMessageDialog(LoginDialog.this, "�û����������޷���¼", "��¼ʧ��",JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
					}
					
					//����û���������ȷ������ʾ���崰��
					mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					mainFrame.setVisible(true);
					
					
					//���þ����˱�ǩ
					mainFrame.getCzyLabel().setText(userStr);
							
					//���ص�¼����
					setVisible(false);
				}
					});	
		}
		return loginButton;	
	}
	
	
	//��ʼ���˳���ť��exitButton
	private JButton getExitButton()
	{
		if(exitButton==null)
		{
			exitButton=new JButton();
			exitButton.setBounds(new Rectangle(181,114,48,20));
			
			URL url=this.getClass().getResource("/res/exitButton.jpg");
			Icon icon=new ImageIcon(url);
			exitButton.setIcon(icon);
			
			exitButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					System.exit(0);    //�˳���ǰӦ�ó���
				}
					});
		}
		return exitButton;
	}
	
	
	//��ȡ�û����ı����е�����
	public String getUserStr()
	{
		return userStr;
	}
	
}
