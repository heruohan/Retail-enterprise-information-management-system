package com.lzw.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import com.lzw.dao.*;
import com.lzw.*;


public class LoginDialog extends JFrame{    //登录窗体的设计
	private static final long serialVersionUID = 1L;
	private LoginPanel loginPanel=null;    //登录面板
	
	private JLabel jLabel=null;    //用户名标签
	private JTextField userField=null;   //用户名文本框
	
	private JLabel jLabel1=null;    //密码标签
	private JPasswordField passwordField=null;    //密码文本框
	
	private JButton loginButton=null;    //登录按钮
	private JButton exitButton=null;    //退出按钮
	
	private static String userStr;    //用户名文本框中的内容
	private MainFrame mainFrame;    //主体窗体
	

	//构造函数
	public LoginDialog()
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			mainFrame=new MainFrame();    //实例化主题窗体
			init();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	//初始化登录窗体
	private void init()
	{
		Dimension size=this.getToolkit().getScreenSize();
		this.setLocation((size.width - 296) / 2, (size.height-188)/2);
		this.setSize(296, 188);
		this.setTitle("系统登录");
		this.setResizable(false);    //登录窗体大小不可变
		this.setContentPane(getLoginPanel());
	}
	
	//初始化登录面板：loginPanel
	private LoginPanel getLoginPanel()
	{
		if(loginPanel==null)
		{
			//用户名标签
			jLabel=new JLabel();
			jLabel.setText("用户名：");
			jLabel.setBounds(new Rectangle(85, 41, 56, 18));
			
			//密码标签
			jLabel1=new JLabel();
			jLabel1.setText("密码：");
			jLabel1.setBounds(new Rectangle(86, 71, 55, 18));
			
			//初始化登录面板
			loginPanel=new LoginPanel();
			loginPanel.setLayout(null);
			loginPanel.setBackground(new Color(0xD8DDC7));
			
			//在登录面板上添加各个组件
			//用户名相关组件
			loginPanel.add(jLabel);
			loginPanel.add(getUserField());
			
			//密码相关组件
			loginPanel.add(jLabel1);
			loginPanel.add(getPasswordField());
			
			//登录按钮
			loginPanel.add(getLoginButton());
			//退出按钮
			loginPanel.add(getExitButton());
		}
		return loginPanel;
		
	}
	
	
	
	//初始化用户名文本框:userField
	private JTextField getUserField()
	{
		if(userField==null)
		{
			userField=new JTextField();
			userField.setBounds(new Rectangle(142, 39, 127, 22));    //设置用户名文本框的位置和宽高
		}
		return userField;
	}
	
	
	//初始化密码文本框:passwordField
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
	
	
	
	//初始化登录按钮:loginButton
	private JButton getLoginButton()
	{
		if(loginButton==null)
		{
			loginButton=new JButton();
			loginButton.setBounds(new Rectangle(109, 114, 48, 20));
			
			URL url=this.getClass().getResource("/res/loginButton.jpg");    //得到图片的位置
			Icon icon=new ImageIcon(url);    //获得图标
			loginButton.setIcon(icon);    //为按钮添加图标
			
			loginButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					try
					{
						//设置本地系统外观样式
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
						userStr=userField.getText();    //获取用户名
						String passwordStr=new String(passwordField.getPassword());    //获取密码
						
						if(!Dao.checkLogin(userStr, passwordStr))    //检验用户名和密码是否正确
						{
							System.out.println(111);
							JOptionPane.showMessageDialog(LoginDialog.this, "用户名与密码无法登录", "登录失败",JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
					}
					
					//如果用户和密码正确，则显示主体窗体
					mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					mainFrame.setVisible(true);
					
					
					//设置经手人标签
					mainFrame.getCzyLabel().setText(userStr);
							
					//隐藏登录窗体
					setVisible(false);
				}
					});	
		}
		return loginButton;	
	}
	
	
	//初始化退出按钮：exitButton
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
					System.exit(0);    //退出当前应用程序
				}
					});
		}
		return exitButton;
	}
	
	
	//获取用户名文本框中的内容
	public String getUserStr()
	{
		return userStr;
	}
	
}
