package com.lzw.iframe.KeHuGuanLi;

import javax.swing.*;
import java.awt.event.*;
import com.lzw.*;
import com.lzw.dao.Dao;
import com.lzw.dao.model.*;
import com.lzw.iframe.ShangPinGuanLi.ShangPinXiuGaiPanel;

import java.util.Iterator;
import java.util.List;
import java.awt.*;



public class KeHuXiuGaiPanel extends JPanel{
	
	/*
	 * 各子组件
	 */
	private JTextField khnameField=null;    //客户全称
	private JTextField khdzField=null;    //客户地址
	private JTextField khjcField=null;    //客户简称
	private JTextField yzbmField=null;    //邮政编码
	private JTextField dhField=null;    //电话
	private JTextField czField=null;    //传真
	private JTextField lxrField=null;    //联系人
	private JTextField lxdhField=null;    //联系电话
	private JTextField emailField=null;    //电子邮箱
	private JTextField khyhField=null;    //开户银行
	private JTextField yhzhField=null;    //银行账号
	private JComboBox xzkhComboBox=null;    //选择客户下拉列表框
	
	private JButton delButton=null;    //删除按钮
	private JButton xgButton=null;    //修改按钮
	
	
	/*
	public static void main(String[] args)
	{
		JFrame t=new JFrame();
		t.setSize(600,400);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//JDesktopPane deskpane=new JDesktopPane();
		KeHuXiuGaiPanel inFrame=new KeHuXiuGaiPanel();
		
		
		
		//t.getContentPane().setLayout(null);
		t.getContentPane().add(inFrame);
		//t.pack();
		t.setVisible(true);
	}
	*/
	
	
	//构造函数
	public KeHuXiuGaiPanel()
	{
		init();
	}
	
	
	//初始化内部客户修改与删除面板
	private void init()
	{
		this.setLayout(new GridBagLayout());
		
		//客户全称
		JLabel khnameLabel=new JLabel("客户全称：");
		this.setupComponent(khnameLabel, 0, 0, 1, 0, false);
		
		khnameField=new JTextField();
		khnameField.setEditable(false);
		khnameField.setPreferredSize(new Dimension(480,21));
		this.setupComponent(khnameField, 1, 0, 3, 0, true);
		
		
		//客户地址
		JLabel khdzLabel=new JLabel("客户地址：");
		this.setupComponent(khdzLabel, 0, 1, 1, 0, false);
		
		khdzField=new JTextField();
		this.setupComponent(khdzField, 1, 1, 3, 0, true);
		
		
		//客户简称
		JLabel khjcLabel=new JLabel("客户简称：");
		this.setupComponent(khjcLabel, 0, 2, 1, 0, false);
		
		khjcField=new JTextField();
		khjcField.setPreferredSize(new Dimension(200,21));
		this.setupComponent(khjcField, 1, 2, 1, 0, true);
		
		
		//邮政编码
		JLabel yzbmLabel=new JLabel("邮政编码：");
		this.setupComponent(yzbmLabel, 2, 2, 1, 0, false);
		
		yzbmField=new JTextField();
		this.setupComponent(yzbmField, 3, 2, 1, 0, true);
		
		
		//电话
		JLabel dhLabel=new JLabel("电话：");
		this.setupComponent(dhLabel, 0, 3, 1, 0, false);
		
		dhField=new JTextField();
		this.setupComponent(dhField, 1, 3, 1, 0, true);
		
		
		//传真
		JLabel czLabel=new JLabel("传真：");
		this.setupComponent(czLabel, 2, 3, 1, 0, false);
		
		czField=new JTextField();
		this.setupComponent(czField, 3, 3, 1, 0, true);
		
		
		//联系人
		JLabel lxrLabel=new JLabel("联系人：");
		this.setupComponent(lxrLabel, 0, 4, 1, 0, false);
		
		lxrField=new JTextField();
		this.setupComponent(lxrField, 1, 4, 1, 0, true);
		
		
		//联系电话
		JLabel lxdhLabel=new JLabel("联系电话：");
		this.setupComponent(lxdhLabel, 2, 4, 1, 0, false);
		
		lxdhField=new JTextField();
		this.setupComponent(lxdhField, 3, 4, 1, 0, true);
		
		
		//Email
		JLabel emailLabel=new JLabel("E-Mail：");
		this.setupComponent(emailLabel, 0, 5, 1, 0, false);
		
		emailField=new JTextField();
		this.setupComponent(emailField, 1, 5, 3, 0, true);
		
		
		//开户银行
		JLabel khyhLabel=new JLabel("开户银行：");
		this.setupComponent(khyhLabel, 0, 6, 1, 0, false);
		
		khyhField=new JTextField();
		this.setupComponent(khyhField, 1, 6, 1, 0, true);
		
		
		//银行账号
		JLabel yhzhLabel=new JLabel("银行账号：");
		this.setupComponent(yhzhLabel, 2, 6, 1, 0, false);
		
		yhzhField=new JTextField();
		this.setupComponent(yhzhField, 3, 6, 1, 0, true);
		
		//选择客户下拉列表框：xzkhComboBox
		JLabel xzkhLabel=new JLabel("选择客户：");
		this.setupComponent(xzkhLabel, 0, 7, 1, 0, false);
		
		this.setupComponent(this.getXzkhComboBox(), 1, 7, 1, 0, true);
		
		
		
		//添加删除按钮和修改按钮
		JPanel panel=new JPanel();
		FlowLayout layout=new FlowLayout();
		layout.setHgap(24);
		panel.setLayout(layout);
		panel.add(this.getDelButton());
		panel.add(this.getXgButton());
		
		this.setupComponent(panel, 2, 7, 2, 0, true);
		//删除按钮：delButton
		//this.setupComponent(this.getDelButton(), 2, 7, 1, 0, false);
		
		//修改按钮：xgButton
		//this.setupComponent(this.getXgButton(), 3, 7, 1, 0, false);
		
		
		
	}
	
	
	//布局组件的方法设置
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
	
	
	
	//初始化选择客户下拉列表框：xzkhComboBox
	private JComboBox getXzkhComboBox()
	{
		if(xzkhComboBox==null)
		{
			xzkhComboBox=new JComboBox();
			xzkhComboBox.setMaximumRowCount(5);
			
			//添加监控器
			xzkhComboBox.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					updateAllField();
				}
					});
			
			
		}
		return xzkhComboBox;
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
					Item item=(Item)xzkhComboBox.getSelectedItem();
					if(item==null || item.getId()==null || !(item instanceof Item))
					{
						return;
					}
					
					//删除客户
					int res=JOptionPane.showConfirmDialog(KeHuXiuGaiPanel.this, "确认删除客户吗？", "客户信息删除", JOptionPane.YES_NO_CANCEL_OPTION);
					if(res==JOptionPane.YES_OPTION)
					{
						int re=Dao.delete("delete from tb_khinfo where id='" + item.getId() + "'");
						if(re>0)
						{
							JOptionPane.showMessageDialog(KeHuXiuGaiPanel.this, "客户删除成功");
							xzkhComboBox.removeItem(item);
						}
					}
					
				}
					});
		}
		return delButton;
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
					Object obj=xzkhComboBox.getSelectedItem();
					Item item=null;
					if(obj==null || !(obj instanceof Item) || (item=(Item)obj).getId()==null)
					{
						JOptionPane.showMessageDialog(KeHuXiuGaiPanel.this, "请正确填写客户");
						return;
					}
					
					//构造TbKhinfo
					TbKhinfo khinfo=new TbKhinfo();
					khinfo.setId(item.getId());
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
					
					if(Dao.updateKeHu(khinfo)==1)
					{
						JOptionPane.showMessageDialog(KeHuXiuGaiPanel.this, "客户信息修改成功");
						
					}
					else
					{
						JOptionPane.showMessageDialog(KeHuXiuGaiPanel.this, "客户信息修改失败");
					}
					
				}
					});
		}
		return xgButton;
	}
	
	
	
	//当选择客户后，更新所有的文本框
	private void updateAllField()
	{
		Object obj=xzkhComboBox.getSelectedItem();
		
		if(obj==null || !(obj instanceof Item))
		{
			return;
		}
		
		Item item=(Item)obj;
		TbKhinfo khinfo=Dao.getKhInfo(item);
		if(khinfo.getId()!=null && !khinfo.getId().isEmpty())
		{
			khnameField.setText(khinfo.getKhname());
			khdzField.setText(khinfo.getAddress());
			khjcField.setText(khinfo.getJian());
			yzbmField.setText(khinfo.getBianma());
			dhField.setText(khinfo.getTel());
			czField.setText(khinfo.getFax());
			lxrField.setText(khinfo.getLian());
			lxdhField.setText(khinfo.getLtel());
			emailField.setText(khinfo.getMail());
			khyhField.setText(khinfo.getXinhang());
			yhzhField.setText(khinfo.getHao());
			
		}
	}
	
	
	//初始化客户选择下拉列表框
	public void initKhComboBox()
	{
		List lst=Dao.getKhInfos();
		
		//删除所有项
		xzkhComboBox.removeAllItems();
		
		for(Iterator iter=lst.iterator();iter.hasNext();)
		{
			List tmp=(List)iter.next();
			Item item=new Item();
			item.setId(tmp.get(0).toString().trim());
			item.setName(tmp.get(1).toString().trim());
			xzkhComboBox.addItem(item);
		}
		
		updateAllField();
	}

}
