package com.lzw.iframe;

import java.awt.event.KeyEvent;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import com.lzw.dao.*;
import java.io.*;
import javax.swing.border.*;


public class BackupAndRestore_IFrame extends JInternalFrame{
	
	//数据库备份与恢复内部窗体的各个子组件
	
	private JPanel contentPane=null;    //内部窗体的内容面板
	private JPanel backupPane=null;    //备份面板
	private JPanel restorePane=null;    //恢复面板
	
	private JTextField backupField=null;    //备份文本框
	private JTextField restoreField=null;   //恢复文本框
	
	private JButton backupButton=null;    //备份按钮
	private JButton restoreButton=null;    //恢复按钮
	private JButton browseButton=null;    //浏览按钮
	
	/*
	public static void main(String[] args)
	{
		JFrame t=new JFrame();
		t.setSize(800, 600);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane deskpane=new JDesktopPane();
		BackupAndRestore_IFrame inFrame=new BackupAndRestore_IFrame();
		
		deskpane.add(inFrame);
		inFrame.setVisible(true);
		
		t.setContentPane(deskpane);
		t.setVisible(true);
	}
	*/
	
	
	//构造函数
	public BackupAndRestore_IFrame()
	{
		init();
	}
	
	
	//初始化数据备份与恢复内部窗体
	private void init()
	{
		//设置内部窗体的属性
		this.setTitle("数据库备份与恢复");
		this.setMaximizable(true);
		this.setIconifiable(true);
		this.setResizable(true);
		this.setClosable(true);
		
		this.setBounds(50, 50, 600, 320);
		this.setContentPane(this.getContentPanes());
	}
	
	
	//初始化内容面板：contentPane
	private JPanel getContentPanes()
	{
		if(contentPane==null)
		{
			contentPane=new JPanel();
			contentPane.setLayout(new BoxLayout(contentPane,BoxLayout.Y_AXIS));
			
			contentPane.add(this.getBackupPane());
			contentPane.add(this.getRestorePane());
		}
		return contentPane;
	}
	
	
	
	//初始化备份面板：backupPane
	private JPanel getBackupPane()
	{
		if(backupPane==null)
		{
			backupPane=new JPanel();
			TitledBorder border=BorderFactory.createTitledBorder("数据库备份");
			border.setTitleFont(new Font("Dialog",Font.BOLD, 12));
			//border.setTitleColor(Color.BLUE);
			backupPane.setBorder(border);
			backupPane.setLayout(new GridBagLayout());
			
			
			//备份文本框：backupField
			GridBagConstraints constraint1=new GridBagConstraints();
			constraint1.gridx=0;
			constraint1.gridy=0;
			constraint1.fill=GridBagConstraints.HORIZONTAL;
			constraint1.weightx=1.0;
			constraint1.insets=new Insets(0,0,3,0);
			
			
			//备份按钮：backupButton
			GridBagConstraints constraint2=new GridBagConstraints();
			constraint2.gridx=0;
			constraint2.gridy=1;
			constraint2.anchor=GridBagConstraints.EAST;
			
			//添加组件
			backupPane.add(this.getBackupField(), constraint1);
			backupPane.add(this.getBackupButton(), constraint2);
			
		}
		return backupPane;
	}
	
	
	
	//初始化恢复面板：restorePane
	private JPanel getRestorePane()
	{
		if(restorePane==null)
		{
			restorePane=new JPanel();
			TitledBorder border=BorderFactory.createTitledBorder(null,"数据库恢复");
			border.setTitleFont(new Font("Dialog",Font.BOLD, 12));
			restorePane.setBorder(border);
			
			
			restorePane.setLayout(new GridBagLayout());    //设置局部管理器
			
			//恢复文本框：restoreField
			GridBagConstraints constraint1=new GridBagConstraints();
			constraint1.gridx=0;
			constraint1.gridy=0;
			constraint1.fill=GridBagConstraints.HORIZONTAL;
			constraint1.gridwidth=2;
			constraint1.insets=new Insets(0,0,4,0);
			
			/*
			 * 解答疑惑：
			 * 1、恢复文本框横跨两个列，如果其weightx=1.0，则其会赋值给其所跨越的最后一个列；
			 */
			
			
			//浏览按钮：browseButton
			GridBagConstraints constraint2=new GridBagConstraints();
			constraint2.gridx=0;
			constraint2.gridy=1;
			constraint2.weightx=1.0;
			constraint2.anchor=GridBagConstraints.EAST;
			
			
			//恢复按钮：restoreButton
			GridBagConstraints constraint3=new GridBagConstraints();
			constraint3.gridx=1;
			constraint3.gridy=1;
			constraint3.insets=new Insets(0,12,0,0);
			
			
			
			//添加组件
			restorePane.add(this.getRestoreField(), constraint1);
			restorePane.add(this.getBrowseButton(), constraint2);
			restorePane.add(this.getRestoreButton(), constraint3);
	
		}
		return restorePane;
	}
	
	
	
	//初始化备份文本框：backupField
	private JTextField getBackupField()
	{
		if(backupField==null)
		{
			backupField=new JTextField();
			backupField.setEditable(false);
			
			backupField.setFont(new Font("幼圆", Font.PLAIN, 14));    //设置文本框的字体
			//backupField.setForeground(Color.BLUE);     //设置文本框中内容的颜色
			backupField.setText("数据库备份路径：");
		}
		return backupField;
	}
	
	
	
	//初始化恢复文本框：restoreField
	private JTextField getRestoreField()
	{
		if(restoreField==null)
		{
			restoreField=new JTextField();
			restoreField.setEditable(false);
			
		}
		return restoreField;
	}
	
	
	
	//初始化备份按钮：backupButton
	private JButton getBackupButton()
	{
		if(backupButton==null)
		{
			backupButton=new JButton("备份(K)");
			backupButton.setMnemonic(KeyEvent.VK_K);    //添加助记符
			
			//添加监控器
			backupButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					try
					{
						String sqlpath=Dao.backup();
						backupField.setText("数据库备份路径：" + sqlpath);
						
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
						String message=e1.getMessage();
						System.out.println(123);
						JOptionPane.showMessageDialog(BackupAndRestore_IFrame.this, message);
						return;
					}
					
					JOptionPane.showMessageDialog(BackupAndRestore_IFrame.this, "备份成功");
				}
					});
			
		}
		return backupButton;
	}
	
	
	
	//初始化恢复按钮：restoreButton
	private JButton getRestoreButton()
	{
		if(restoreButton==null)
		{
			restoreButton=new JButton("恢复(R)");
			restoreButton.setMnemonic(KeyEvent.VK_R);
			
			//添加监控器
			restoreButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					String path=restoreField.getText();
					
					//判断内容
					if(path==null || path.isEmpty())
					{
						JOptionPane.showMessageDialog(BackupAndRestore_IFrame.this, "恢复路径不存在，请输入路径");
						return;
					}
					
					try
					{
						Dao.restore(path);
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
						String message=e1.getMessage();
						JOptionPane.showMessageDialog(BackupAndRestore_IFrame.this, message);
						return;
					}
					
					//
					JOptionPane.showMessageDialog(BackupAndRestore_IFrame.this, "恢复成功");
				}
					});
		}
		return restoreButton;
	}
	
	
	
	//初始化浏览按钮：browseButton
	private JButton getBrowseButton()
	{
		if(browseButton==null)
		{
			browseButton=new JButton("浏览(W)......");
			browseButton.setMnemonic(KeyEvent.VK_W);
			
			//添加监控器
			browseButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					JFileChooser chooser=new JFileChooser("backup");
					int res=chooser.showOpenDialog(BackupAndRestore_IFrame.this);
					
					if(res==JFileChooser.APPROVE_OPTION)
					{
						File f=chooser.getSelectedFile();
						String path=f.getAbsolutePath();
						restoreField.setText(path);
					}
				}
					});
		}
		return browseButton;
	}
	

}
