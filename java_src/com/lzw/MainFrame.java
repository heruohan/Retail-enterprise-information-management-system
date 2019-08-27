package com.lzw;

import java.awt.Cursor;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import com.lzw.login.*;
import java.util.*;


public class MainFrame extends JFrame{    //构造主题窗口，并封装 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MenuBar frameMenuBar;    //菜单栏对象
	private JPanel frameContentPane;    //内容面板
	
	/*
	 * 内容面板上的组件
	 */

	private ToolBar toolBar;    //工具栏
	//容纳内部窗体的桌面面板
	private DesktopPanel desktopPanel;
	//状态面板（内含选定窗体状态、操作员、当前日期、公司名称等信息）
	private JPanel statePanel;
	private JLabel stateLabel;    //状态标签
	private static JLabel czyLabel;    //操作员标签
	private JLabel nowDateLabel;    //当前日期标签
	private JLabel nameLabel;    //公司名称标签
	
	private JSeparator separator2;    //组件间的分隔符
	private JSeparator separator3;    //
	
	
	//程序运行的入口
	public static void main(String[] args)
	{
		SplashScreen splashScreen=SplashScreen.getSplashScreen();    //创建闪现屏幕对象
		JFrame login=new LoginDialog();
		
		if(splashScreen!=null)
		{
			System.out.println("hcc");
			try
			{
				login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Thread.sleep(3000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		login.setVisible(true);
		
	}
	
	
	/*
	public static void main(String[] args)
	{
		new MainFrame();
	}
	*/
	
	//构造函数
	public MainFrame()
	{
		init();    //初始化主窗体
	}
	
	
	//初始化主体窗口
	private void init()
	{
		this.setSize(800,600);    //设置主窗体的宽高
		this.setJMenuBar(this.getFrameMenuBar());    //在主窗体上添加菜单栏
		this.setContentPane(this.getFrameContentPane());    //在主窗体上设置内容面板
		this.setTitle("企业管理系统");
		//this.setVisible(true);
		
	}
	
	//初始化工具栏:toolBar
	private ToolBar getToolBar()
	{
		if(toolBar==null)
		{
			toolBar=new ToolBar(this.getFrameMenuBar());
			toolBar.setCursor(new Cursor(Cursor.HAND_CURSOR));    //设置光标形状
		}
		return toolBar;
	}
	
	//初始化菜单栏对象：frameMenuBar
	private MenuBar getFrameMenuBar()
	{
		if(frameMenuBar==null)
		{
			frameMenuBar=new MenuBar(this.getDesktopPanel(),this.getStateLabel());    //创建菜单栏对象
		}
		return frameMenuBar;
	}
	
	
	//初始化桌面面板:desktopPanel
	private DesktopPanel getDesktopPanel()
	{
		if(desktopPanel==null)
		{
			desktopPanel=new DesktopPanel();    //创建桌面面板
		}
		return desktopPanel;
	}
	
	//初始化状态面板：statePanel
	private JPanel getStatePanel()
	{
		if(statePanel==null)
		{
			/*
			 * 创建网格组布局管理器，加上分隔符，一共有7个组件
			 */
			//状态标签组件：stateLabel
			GridBagConstraints constraints_0=new GridBagConstraints();
			constraints_0.gridx=0;    //设置此组件的索引
			constraints_0.gridy=0;
			constraints_0.fill=GridBagConstraints.HORIZONTAL;    //填充方式
			constraints_0.weightx=1.0;    //横向扩展的权重
			
			//分隔符1组件
			GridBagConstraints constraints_1=new GridBagConstraints();
			constraints_1.gridx=2;
			constraints_1.gridy=0;
			constraints_1.fill=GridBagConstraints.VERTICAL;
			constraints_1.insets=new Insets(0,5,0,5);
			
			//操作员组件：czyLabel
			GridBagConstraints constraints_2=new GridBagConstraints();
			constraints_2.gridx=3;
			constraints_2.gridy=0;
			
			//分隔符2组件
			GridBagConstraints constraints_3=new GridBagConstraints();
			constraints_3.gridx=4;
			constraints_3.gridy=0;
			constraints_3.fill=GridBagConstraints.VERTICAL;
			constraints_3.insets=new Insets(0,5,0,5);
			constraints_3.weighty=1.0;
			
			//日期标签组件：nowDateLabel
			nowDateLabel=new JLabel();    //创建当前日期标签
			Date date=new Date();
			String time=String.format("%tF", date);
			nowDateLabel.setText(time);    //设置当前日期标签的文本内容
			
			GridBagConstraints constraints_4=new GridBagConstraints();
			constraints_4.gridx=5;
			constraints_4.gridy=0;
			constraints_4.insets=new Insets(0,5,0,5);
			
			//分隔符3组件
			GridBagConstraints constraints_5=new GridBagConstraints();
			constraints_5.gridx=6;
			constraints_5.gridy=0;
			constraints_5.fill=GridBagConstraints.VERTICAL;
			constraints_5.insets=new Insets(0,5,0,5);
			
			//公司名称组件：nameLabel
			GridBagConstraints constraints_6=new GridBagConstraints();
			constraints_6.gridx=7;
			constraints_6.gridy=0;
			
			nameLabel=new JLabel("XXX有限公司");
			
			/*
			 * 初始化状态面板：statePanel
			 */
			statePanel=new JPanel();
			statePanel.setLayout(new GridBagLayout());    //将状态面板的布局管理器设置为网格组布局管理器
			statePanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
			//添加子组件
			//添加状态标签
			statePanel.add(this.getStateLabel(), constraints_0);
			statePanel.add(this.getJSeparator1(), constraints_1);
			statePanel.add(this.getCzyLabel(), constraints_2);
			statePanel.add(this.getJSeparator2(), constraints_3);
			statePanel.add(nowDateLabel,constraints_4);
			statePanel.add(this.getJSeparator3(), constraints_5);
			statePanel.add(nameLabel, constraints_6);
		}
		return statePanel;
	}
	
	//获取状态标签的方法:stateLabel
	private JLabel getStateLabel()
	{
		if(stateLabel==null)
		{
			stateLabel=new JLabel();
			stateLabel.setText("当前没有选定窗体");
		}
		return stateLabel;
	}
	
	
	//获取操作员标签的方法：czyLabel
	public static JLabel getCzyLabel()
	{
		if(czyLabel==null)
		{
			czyLabel=new JLabel();
			czyLabel.setText("");
		}
		return czyLabel;
	}
	
	
	//创建3个分隔符组件的获取方法
	private JSeparator getJSeparator1()
	{
		JSeparator separator1=new JSeparator();
		separator1.setOrientation(SwingConstants.VERTICAL);
		return separator1;
	}
	
	private JSeparator getJSeparator2()
	{
		if(separator2==null)
		{
			separator2=new JSeparator();
			separator2.setOrientation(SwingConstants.VERTICAL);
		}
		return separator2;
	}
	
	private JSeparator getJSeparator3()
	{
		if(separator3==null)
		{
			separator3=new JSeparator();
			separator3.setOrientation(SwingConstants.VERTICAL);
		}
		return separator3;
	}
	
	//初始化内容面板：frameContentPane
	private JPanel getFrameContentPane()
	{
		//添加工具栏，桌面面板，状态面板
		if(frameContentPane==null)
		{
			frameContentPane=new JPanel();
			frameContentPane.setLayout(new BorderLayout());
			frameContentPane.add(this.getToolBar(), BorderLayout.NORTH);
			frameContentPane.add(this.getDesktopPanel());
			frameContentPane.add(this.getStatePanel(), BorderLayout.SOUTH);
		}
		return frameContentPane;
	}

}
