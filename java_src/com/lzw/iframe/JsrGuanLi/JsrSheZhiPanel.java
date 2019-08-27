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
	
	private JScrollPane scrollPane=null;    //滚动面板
	private JTable table=null;    //表格
	private DefaultTableModel model=null;    //表格模型
	private String[] columnName=null;    //列名
	
	
	private JTextField nameField=null;    //姓名
	private JTextField sexField=null;    //性别
	private JTextField ageField=null;    //年龄
	private JTextField telField=null;    //联系电话
	
	
	private JButton on_offButton=null;    //禁用/启用按钮
	private JButton delButton=null;    //删除按钮
	private JButton gbButton=null;    //关闭按钮
	private JButton xgButton=null;    //修改按钮
	
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
	
	//构造函数
	public JsrSheZhiPanel()
	{
		init();
	}
	
	
	//初始化经手人设置面板
	private void init()
	{
		this.setLayout(new GridBagLayout());
		
		//表格面板
		scrollPane=this.getScrollPane();
		scrollPane.setPreferredSize(new Dimension(570,180));
		this.setupComponent(this.getScrollPane(), 0, 0, 4, true);
		
		
		//姓名
		JLabel nameLabel=new JLabel("姓名：");
		this.setupComponent(nameLabel, 0, 1, 1, false);
		
		nameField=new JTextField();
		nameField.setEditable(false);
		nameField.setPreferredSize(new Dimension(200,24));
		this.setupComponent(nameField, 1, 1, 1, true);
		
		
		//性别
		JLabel sexLabel=new JLabel("性别：");
		this.setupComponent(sexLabel, 2, 1, 1, false);
		
		sexField=new JTextField();
		sexField.setEditable(false);
		this.setupComponent(sexField, 3, 1, 1, true);
		
		
		//年龄
		JLabel ageLabel=new JLabel("年龄：");
		this.setupComponent(ageLabel, 0, 2, 1, false);
		
		ageField=new JTextField();
		this.setupComponent(ageField, 1, 2, 1, true);
		
		
		//联系电话
		JLabel telLabel=new JLabel("联系电话：");
		this.setupComponent(telLabel, 2, 2, 1, false);
		
		telField=new JTextField();
		this.setupComponent(telField, 3, 2, 1, true);
		
		
		//按钮
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
	
	
	
	//初始化组件布置
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
	
	
	
	//初始化滚动面板：scrollPane
	private JScrollPane getScrollPane()
	{
		if(scrollPane==null)
		{
			scrollPane=new JScrollPane();
			scrollPane.setViewportView(this.getTable());
			
		}
		return scrollPane;
	}
	
	
	//初始化表格：table
	private JTable getTable()
	{
		if(table==null)
		{
			table=new JTable();
			table.setShowGrid(true);
			//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			model=(DefaultTableModel)table.getModel();
			columnName=new String[]{"编号","姓名","性别","年龄","联系电话","禁用"};
			model.setColumnIdentifiers(columnName);
			
			//添加监控器
			table.addMouseListener(new MouseAdapter()
					{
				public void mouseClicked(MouseEvent e)
				{
					int index=table.getSelectedRow();
					if(index<0)
					{
						return;
					}
					
					//更新所有相关文本框
					nameField.setText(table.getValueAt(index, 1).toString().trim());
					sexField.setText(table.getValueAt(index, 2).toString().trim());
					ageField.setText(table.getValueAt(index, 3).toString().trim());
					telField.setText(table.getValueAt(index, 4).toString().trim());
				}
					});
		}
		return table;
	}
	
	
	//初始化禁用/启用按钮：on_offButton
	private JButton getOn_offButton()
	{
		if(on_offButton==null)
		{
			on_offButton=new JButton("禁用/启动");
			
			//添加监控器
			on_offButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					int index=table.getSelectedRow();
					if(index<0)
					{
						return;
					}
					
					int confirm=JOptionPane.showConfirmDialog(JsrSheZhiPanel.this, "确认修改此经手人的状态吗？");
					if(confirm==JOptionPane.YES_OPTION)
					{
						String id=table.getValueAt(index, 0).toString().trim();
						int res=Dao.update("update tb_jsr set enable=abs(enable-1) where id='" + id + "'");
						if(res>0)
						{
							JOptionPane.showMessageDialog(JsrSheZhiPanel.this, "修改成功！");
							//重新初始化表格和文本框
							updateTable();
						}
					}
				}
					});
		}
		return on_offButton;
	}
	
	
	//初始化删除按钮：delButton
	private JButton getDelButton()
	{
		if(delButton==null)
		{
			delButton=new JButton("删除");
			
			//添加监控器
			delButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					int index=table.getSelectedRow();
					if(index<0)
					{
						return;
					}
					
					int confirm=JOptionPane.showConfirmDialog(JsrSheZhiPanel.this, "确认删除此经手人吗？");
					if(confirm==JOptionPane.YES_OPTION)
					{
						String id=table.getValueAt(index, 0).toString().trim();
						int res=Dao.delete("delete from tb_jsr where id='" + id + "'");
						if(res>0)
						{
							JOptionPane.showMessageDialog(JsrSheZhiPanel.this, "删除成功");
							//更新表格和文本框
							updateTable();
						}
						
					}
				}
					});
		}
		return delButton;
	}
	
	
	
	//初始化关闭按钮：gbButton
	private JButton getGbButton()
	{
		if(gbButton==null)
		{
			gbButton=new JButton("关闭");
			
			//添加监控器
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
	
	
	
	//初始化修改按钮：xgButton
	private JButton getXgButton()
	{
		if(xgButton==null)
		{
			xgButton=new JButton("修改");
			
			//添加监控器
			xgButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					int row=table.getSelectedRow();
					if(row<0)
					{
						return;
					}
					
					int confirm=JOptionPane.showConfirmDialog(JsrSheZhiPanel.this, "确认修改年龄和联系电话吗？");
					if(confirm==JOptionPane.YES_OPTION)
					{
						String id=table.getValueAt(row, 0).toString().trim();
						String age=ageField.getText();
						String tel=telField.getText();
						
						//更新经手人数据库
						int res=Dao.update("update tb_jsr set age='" + age + "',tel='" + tel + "' where id='" + id + "'");
						if(res>0)
						{
							JOptionPane.showMessageDialog(JsrSheZhiPanel.this, "修改成功");
							updateTable();
						}
						
					}
				}
					});
		}
		return xgButton;
	}
	
	
	
	//更新文本框
	private void updateAllField()
	{
		nameField.setText("");
		sexField.setText("");
		ageField.setText("");
	}
	
	
	
	//更新表格
	public void updateTable()
	{
		this.updateAllField();
		List lst=Dao.getAllJsrs();    //不管是否为启用或禁用，获取所有经手人
		
		//初始化表格内容和列名
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
			row[5]=(tmp.get(5).toString().trim()).equals("1") ? "启用" : "禁用";
			model.addRow(row);
		}
		
	}

}
