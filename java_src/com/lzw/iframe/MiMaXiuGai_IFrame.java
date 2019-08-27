package com.lzw.iframe;

import javax.swing.*;
import java.awt.event.*;
import com.lzw.dao.*;
import java.awt.*;


public class MiMaXiuGai_IFrame extends JInternalFrame{
	
	private JPasswordField oldPasswordField=null;    //旧密码文本框
	private JPasswordField newPasswordField1=null;    //新密码文本框
	private JPasswordField newPasswordField2=null;    //确认新密码文本框
	
	private JButton querenButton=null;    //确定按钮
	private JButton chongzhiButton=null;    //重置按钮
	
	
	//构造函数
	public MiMaXiuGai_IFrame()
	{
		init();
	}
	
	/*
	public static void main(String[] args)
	{
		JFrame t=new JFrame();
		t.setSize(800, 600);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane deskpane=new JDesktopPane();
		MiMaXiuGai_IFrame inFrame=new MiMaXiuGai_IFrame();
		
		
		deskpane.add(inFrame);
		inFrame.setVisible(true);
		
		t.setContentPane(deskpane);
		t.setVisible(true);
	}
	*/
	
	
	//初始化密码修改内部窗体
	private void init()
	{
		//设置内部窗体的属性
		this.setTitle("密码修改");
		this.setMaximizable(true);
		this.setIconifiable(true);
		this.setResizable(true);
		this.setClosable(true);
		this.getContentPane().setLayout(new GridBagLayout());
		this.setBounds(50, 50, 600, 320);
		
		
		//设置组件的位置
		//旧密码
		JLabel oldPasswordLabel=new JLabel("旧密码：");
		GridBagConstraints constraint_old1=new GridBagConstraints();
		constraint_old1.gridx=0;
		constraint_old1.gridy=0;
		this.getContentPane().add(oldPasswordLabel, constraint_old1);
		
		
		GridBagConstraints constraint_old2=new GridBagConstraints();
		constraint_old2.gridx=1;
		constraint_old2.gridy=0;
		constraint_old2.gridwidth=2;
		constraint_old2.fill=GridBagConstraints.HORIZONTAL;
		constraint_old2.insets=new Insets(0,0,7,0);
		//constraint_old2.weightx=1.0;
		oldPasswordField=this.getOldPasswordField();
		oldPasswordField.setPreferredSize(new Dimension(300,21));
		this.getContentPane().add(this.getOldPasswordField(), constraint_old2);
		
		
		
		//新密码
		JLabel newPasswordLabel=new JLabel("新密码：");
		GridBagConstraints constraint_new=new GridBagConstraints();
		constraint_new.gridx=0;
		constraint_new.gridy=1;
		this.getContentPane().add(newPasswordLabel, constraint_new);
		
		
		GridBagConstraints constraint_newField=new GridBagConstraints();
		constraint_newField.gridx=1;
		constraint_newField.gridy=1;
		constraint_newField.gridwidth=2;
		constraint_newField.fill=GridBagConstraints.HORIZONTAL;
		constraint_newField.insets=new Insets(0,0,7,0);
		this.getContentPane().add(this.getNewPasswordField1(), constraint_newField);
		
		
		
		//确认新密码
		JLabel newPasswordLabel2=new JLabel("确认新密码：");
		GridBagConstraints constraint_new1=new GridBagConstraints();
		constraint_new1.gridx=0;
		constraint_new1.gridy=2;
		this.getContentPane().add(newPasswordLabel2, constraint_new1);
		
		
		GridBagConstraints constraint_newField1=new GridBagConstraints();
		constraint_newField1.gridx=1;
		constraint_newField1.gridy=2;
		constraint_newField1.gridwidth=2;
		constraint_newField1.fill=GridBagConstraints.HORIZONTAL;
		constraint_newField1.insets=new Insets(0,0,7,0);
		this.getContentPane().add(this.getNewPasswordField2(), constraint_newField1);
		
		
		
		//确认按钮：querenButton
		GridBagConstraints constraint_button=new GridBagConstraints();
		constraint_button.gridx=1;
		constraint_button.gridy=3;
		constraint_button.anchor=GridBagConstraints.EAST;
		constraint_button.insets=new Insets(0,20,0,1);
		this.getContentPane().add(this.getQuedingButton(), constraint_button);
		
		
		
		//重置按钮：chongzhiButton
		GridBagConstraints constraint_button2=new GridBagConstraints();
		constraint_button2.gridx=2;
		constraint_button2.gridy=3;
		this.getContentPane().add(this.getChongzhiButton(), constraint_button2);
		
	}
	
	
	
	
	//初始化旧密码文本框：oldPasswordField
	private JPasswordField getOldPasswordField()
	{
		if(oldPasswordField==null)
		{
			oldPasswordField=new JPasswordField();
			
		}
		return oldPasswordField;
	}
	
	
	
	//初始化新密码文本框：newPasswordField1
	private JPasswordField getNewPasswordField1()
	{
		if(newPasswordField1==null)
		{
			newPasswordField1=new JPasswordField();
		}
		return newPasswordField1;
	}
	
	
	
	//初始化确认新密码文本框：newPasswordField2
	private JPasswordField getNewPasswordField2()
	{
		if(newPasswordField2==null)
		{
			newPasswordField2=new JPasswordField();
		}
		return newPasswordField2;
	}
	
	
	
	//确认按钮：querenButton
	private JButton getQuedingButton()
	{
		if(querenButton==null)
		{
			querenButton=new JButton("确定");
			//添加监控器
			querenButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					try
					{
					//获取旧密码
					char[] old=oldPasswordField.getPassword();
					String old_str=new String(old);
					if(old_str==null || old_str.isEmpty())
					{
						JOptionPane.showMessageDialog(MiMaXiuGai_IFrame.this, "请输入旧密码");
						return;
					}
					//新密码
					char[] new1=newPasswordField1.getPassword();
					String new1_str=new String(new1);
					
					//确认新密码
					char[] new2=newPasswordField2.getPassword();
					String new2_str=new String(new2);
					
					if(new1_str==null || new1_str.isEmpty() || new2_str==null || new2_str.isEmpty())
					{
						JOptionPane.showMessageDialog(MiMaXiuGai_IFrame.this, "请输入新密码");
						return;
					}
					
					//验证两者是否相等
					if(new1_str.equals(new2_str))
					{
						//获取旧密码
						//char[] old=oldPasswordField.getPassword();
						//String old_str=new String(old);
						
						int res=Dao.modifyPassword(old_str, new2_str);
						if(res<=0)
						{
							JOptionPane.showMessageDialog(MiMaXiuGai_IFrame.this, "修改失败，请检查旧密码是否输入正确");
							return;
						}
						else
						{
							JOptionPane.showMessageDialog(MiMaXiuGai_IFrame.this, "密码修改成功");
							//
							System.out.println("ok");
							oldPasswordField.setText(null);
							newPasswordField1.setText(null);
							newPasswordField2.setText(null);
							
						}
						
					}
					else
					{
						JOptionPane.showMessageDialog(MiMaXiuGai_IFrame.this, "修改失败，请检查新密码是否输入相同");
						return;
					}
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
					}
	
				}
					});
		}
		return querenButton;
	}
	
	
	
	//重置按钮：chongzhiButton
	private JButton getChongzhiButton()
	{
		if(chongzhiButton==null)
		{
			chongzhiButton=new JButton("重置");
			
			//添加监控器
			chongzhiButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					oldPasswordField.setText(null);
					newPasswordField1.setText(null);
					newPasswordField2.setText(null);
					
				}
					});
		}
		return chongzhiButton;
	}
	

}
