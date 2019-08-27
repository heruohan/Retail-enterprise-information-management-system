package com.lzw.iframe.JsrGuanLi;

import javax.swing.*;
import java.awt.event.*;
import com.lzw.*;
import com.lzw.dao.*;
import com.lzw.dao.model.*;
import java.awt.*;


public class JsrTianJiaPanel extends JPanel{
	
	/*
	 * 各子组件
	 */
	private JTextField nameField=null;    //姓名
	private JComboBox sexComboBox=null;    //性别下拉列表框
	private JTextField ageField=null;    //年龄
	private JTextField telField=null;    //电话
	
	private JButton tjButton=null;    //添加按钮
	private JButton resetButton=null;    //重置按钮
	
	
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
	
	
	//构造函数
	public JsrTianJiaPanel()
	{
		init();
	}
	
	
	//初始化经手人添加面板
	private void init()
	{
		this.setLayout(new GridBagLayout());
		
		//姓名
		JLabel nameLabel=new JLabel("姓名：");
		this.setupComponent(nameLabel, 0, 0, 1, false);
		
		nameField=new JTextField();
		nameField.setPreferredSize(new Dimension(480,24));
		this.setupComponent(nameField, 1, 0, 1, true);
		
		
		//性别
		JLabel sexLabel=new JLabel("性别：");
		this.setupComponent(sexLabel, 0, 1, 1, false);
		
		this.setupComponent(this.getSexComboBox(), 1, 1, 1, true);
		
		
		//年龄
		JLabel ageLabel=new JLabel("年龄：");
		this.setupComponent(ageLabel, 0, 2, 1, false);
		
		ageField=new JTextField();
		this.setupComponent(ageField, 1, 2, 1, true);
		
		
		//电话
		JLabel telLabel=new JLabel("电话：");
		this.setupComponent(telLabel, 0, 3, 1, false);
		
		telField=new JTextField();
		this.setupComponent(telField, 1, 3, 1, true);
		
		
		//添加和重置按钮
		JPanel pane=new JPanel();
		((FlowLayout)pane.getLayout()).setHgap(50);
		pane.add(this.getTjButton());
		pane.add(this.getResetButton());
		this.setupComponent(pane, 0, 4, 2, true);
	}
	
	
	
	//布置组件的方法
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
	
	
	
	//初始化性别下拉列表框：sexComboBox
	private JComboBox getSexComboBox()
	{
		if(sexComboBox==null)
		{
			sexComboBox=new JComboBox();
			sexComboBox.setEditable(false);
			sexComboBox.addItem("男");
			sexComboBox.addItem("女");
		}
		return sexComboBox;
	}
	
	
	
	
	//初始化添加按钮：tjButton
	private JButton getTjButton()
	{
		if(tjButton==null)
		{
			tjButton=new JButton("添加");
			
			//添加监控器
			tjButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					String jsr_name=nameField.getText().trim();
					if(jsr_name.isEmpty() || ageField.getText().isEmpty() || telField.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(JsrTianJiaPanel.this, "请填写经手人完整信息");
						return;
					}
					
					//判断经手人数据库中是否已经有此经手人
					Item item=new Item();
					item.setName(jsr_name);
					TbJsr jsr=Dao.getJsr(item);
					if(jsr.getName()!=null && jsr.getName().equals(jsr_name) && jsr.getSex().equals(sexComboBox.getSelectedItem()) &&
						jsr.getAge().equals(ageField.getText().trim()) && jsr.getTel().equals(telField.getText().trim()))
					{
						JOptionPane.showMessageDialog(JsrTianJiaPanel.this, "经手人" + jsr_name + "已经存在");
						return;
					}
					
					//构造经手人TbJsr类
					String sex=sexComboBox.getSelectedItem().toString();
					TbJsr tbjsr=new TbJsr();
					tbjsr.setName(jsr_name);
					tbjsr.setSex(sex);
					tbjsr.setAge(ageField.getText().trim());
					tbjsr.setTel(telField.getText().trim());
					
					int res=Dao.addJsr(tbjsr);
					if(res>0)
					{
						JOptionPane.showMessageDialog(JsrTianJiaPanel.this, "添加成功");
					}
					
					resetButton.doClick();
				}
					});
		}
		return tjButton;
	}
	
	
	//初始化重置按钮：resetButton
	private JButton getResetButton()
	{
		if(resetButton==null)
		{
			resetButton=new JButton("重置");
			
			//添加监控器
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
