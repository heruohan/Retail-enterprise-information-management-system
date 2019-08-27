package com.lzw;

import javax.swing.*;
import java.util.*;
import java.lang.reflect.*;
import javax.swing.event.*;
import java.awt.*;

import java.awt.Desktop;
import java.awt.event.*;
import java.beans.PropertyVetoException;
import java.net.*;
import com.lzw.iframe.*;

public class MenuBar extends JMenuBar{    //创建并封装菜单栏类
	
	/*
	 * 进货管理菜单，及其菜单项
	 */
	//(进货管理)菜单
	private JMenu jinhuo_Menu=null;
	//(进货单)菜单项,位于(进货管理)菜单内
	private JMenuItem jinhuoItem=null;
	//(进货退货)菜单项,位于(进货管理)菜单内
	private JMenuItem jinhuo_tuihuoItem=null;
	
	
	
	//(销售管理)菜单
	private JMenu xiaoshou_Menu=null;
	
	//(库存管理)菜单
	private JMenu kucun_Menu=null;
	
	//(信息查询)菜单
	private JMenu xinxi_chaxunMenu=null;
	
	//(基本资料)菜单
	private JMenu jiben_ziliaoMenu=null;
	
	//(系统维护)菜单
	private JMenu xitong_weihuMenu=null;
	
	//(窗口)菜单
	private JMenu chuang_kouMenu=null;
	
	
	
	/*
	 * 帮助菜单，及其菜单项
	 */
	//(帮助)菜单
	private JMenu bang_zhuMenu=null;
	//(关于)菜单项，位于(帮助)菜单内
	private JMenuItem guanyu_Item=null;
	//(联系技术支持)菜单项，位于(帮助)菜单内
	private JMenuItem bugItem=null;
	//(访问技术网站）菜单项，位于（帮助）菜单内
	private JMenuItem fangwen_wangzhanItem=null;
	
	
	
	/*
	 * 销售管理菜单，及其菜单项
	 */
	//(销售单）菜单项，位于（销售管理）菜单内
	private JMenuItem xiaoshou_danItem=null;
	//(销售退货）菜单项，位于（销售管理）菜单内
	private JMenuItem xiaoshou_tuihuoItem=null;
	
	
	
	/*
	 * 库存管理菜单，及其菜单项
	 */
	//(库存盘点）菜单项，位于（库存管理）菜单内
	private JMenuItem kucun_pandianItem=null;
	//(价格调整）菜单项，位于（库存管理）菜单内
	private JMenuItem jiage_tiaozhengItem=null;
	
	
	
	/*
	 * 信息查询菜单，及其菜单项
	 */
	//(销售查询）菜单项，位于(信息查询)菜单内
	private JMenuItem xiaoshou_chaxunItem=null;
	//(商品查询）菜单项，位于（信息查询）菜单内
	private JMenuItem shangpin_chaxunItem=null;
	//（销售排行）菜单项，位于（信息查询）菜单内
	private JMenuItem xiaoshou_paihangItem=null;
	
	
	
	/*
	 * 基本资料菜单，及其菜单项
	 */
	//(商品管理）菜单项，位于（基本资料）菜单内
	private JMenuItem shangpin_guanliItem=null;
	//（客户管理）菜单项，位于（基本资料）菜单内
	private JMenuItem kehu_guanliItem=null;
	//（供应商管理）菜单项，位于（基本资料）菜单内
	private JMenuItem gys_guanliItem=null;
	//（经手人设置）菜单项，位于（基本资料）菜单内
	private JMenuItem jsr_guanliItem=null;
	
	
	
	/*
	 * 系统维护菜单，及其菜单项
	 */
	//（密码修改）菜单项，位于（系统维护）菜单内
	private JMenuItem mima_xiugaiItem=null;
	//（数据备份与恢复），位于（系统维护）菜单内
	private JMenuItem shuju_beifenItem=null;
	//（退出）菜单项，位于（系统维护）菜单内
	private JMenuItem exitItem=null;
	
	
	/*
	 * 窗口菜单，及其菜单项
	 */
	//（窗口平铺）菜单项，位于（窗口）菜单内
	private JMenuItem pingpuItem=null;
	//（全部关闭）菜单项，位于（窗口）菜单内
	private JMenuItem closeAllItem=null;
	//（全部最小化）菜单项，位于（窗口）菜单内
	private JMenuItem allIconItem=null;
	//（全部还原）菜单项，位于（窗口）菜单内
	private JMenuItem allResumeItem=null;
	
	
	//容纳内部窗体的桌面面板
	private JDesktopPane desktopPanel=null;
	
	//内部窗体的集合
	private Map<JMenuItem,JInternalFrame> iFrames=null;
	
	//内部窗体的坐标位置
	private int nextFrameX,nextFrameY;
	
	//状态栏的内部窗体提示标签
	private JLabel stateLabel=null;
	
	
	
	//构造方法
	private MenuBar()
	{
		
	}
	
	//public 形式的构造方法，用于在外部创建菜单栏对象实例
	public MenuBar(JDesktopPane desktopPanel,JLabel label)
	{
		iFrames=new HashMap<>();
		//
		this.desktopPanel=desktopPanel;
		this.stateLabel=label;
		init();
	}
	
	
	//菜单栏的初始化
	private void init()
	{
		//菜单栏的大小
		this.setSize(new Dimension(600,24));
		//向菜单栏中分别添加8个菜单对象
		this.add(getJinhuo_Menu());
		this.add(getXiaoshou_Menu());
		this.add(getKucun_Menu());
		this.add(getXinxi_chaxunMenu());
		this.add(getJiben_ziliaoMenu());
		this.add(getXitong_weihuMenu());
		this.add(getChuang_kouMenu());
		this.add(getBang_zhuMenu());
	}
	
	
	
	
	//创建生成各个菜单项对应的内部窗体的方法，运用反射技术
	private JInternalFrame createIFrame(JMenuItem item,Class<?> clazz)
	{
		/*
		 * item：菜单项
		 * clazz：菜单项item对应的内部窗体的类对象(内部窗体类在另一个包中定义）
		 */
		Constructor<?> constructor=clazz.getConstructors()[0];
		JInternalFrame iFrame=iFrames.get(item);
		
		try
		{
		if(iFrame==null || iFrame.isClosed())
			
		   {
			iFrame=(JInternalFrame)constructor.newInstance(null);    //利用constructor创建实例
			iFrames.put(item, iFrame);    //将此映射放入字典中
			iFrame.setFrameIcon(item.getIcon());    
			iFrame.setLocation(nextFrameX, nextFrameY);
			
			int frameH=iFrame.getPreferredSize().height;
			int panelH=iFrame.getContentPane().getPreferredSize().height;
			
			int fSpacing=frameH-panelH;
			nextFrameX+=fSpacing;
			nextFrameY+=fSpacing;
			
			if(nextFrameX+iFrame.getWidth()>desktopPanel.getWidth())
				nextFrameX=0;
			if(nextFrameY+iFrame.getHeight()>desktopPanel.getHeight())
				nextFrameY=0;
			
			//将内部窗体加入到桌面面板上
			desktopPanel.add(iFrame);
			iFrame.setResizable(false);
			iFrame.setMaximizable(false);
			iFrame.setVisible(true);
		   }
		iFrame.setSelected(true);
		stateLabel.setText(iFrame.getTitle());
		
		//打开多个内部窗体，为切换选中窗体，为每个内部窗体添加监视器，当从A窗体切换到B窗体时，
		//会执行B窗体的activated方法
		iFrame.addInternalFrameListener(new InternalFrameAdapter()
				{
			public void internalFrameActivated(InternalFrameEvent e)
			{
				JInternalFrame frame=e.getInternalFrame();
				stateLabel.setText(frame.getTitle());
			}
			
			public void internalFrameDeactivated(InternalFrameEvent e)
			{
				stateLabel.setText("没有选择窗体");
			}
			
				});
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return iFrame;	
	}
	
	
	
	
	/*
	 * 初始化（进货管理）菜单，及其菜单项
	 */
	//进货管理菜单
	private JMenu getJinhuo_Menu()
	{
		if(jinhuo_Menu==null)
		{
			jinhuo_Menu=new JMenu();
			jinhuo_Menu.setText("进货管理(J)");
			jinhuo_Menu.setMnemonic(KeyEvent.VK_J);
			//添加其菜单项
			jinhuo_Menu.add(getJinhuoItem());
			jinhuo_Menu.add(getJinhuo_tuihuoItem());
		}
		return jinhuo_Menu;
	}
	
	
	//初始化（进货管理）菜单的菜单项jinhuoItem,jinhuo_tuihuoItem
	//进货单菜单项：jinhuoItem
	public JMenuItem getJinhuoItem()
	{
		if(jinhuoItem==null)
		{
			jinhuoItem=new JMenuItem();
			jinhuoItem.setText("进货单");
			Icon icon=new ImageIcon(this.getClass().getResource("/res/icon/jinhuodan.png"));
			jinhuoItem.setIcon(icon);
			//添加显示其内部窗体的监听器
			jinhuoItem.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					//添加显示对应的内部窗体的方法,其中A为jinhuoItem对应的内部窗体类，单独实现
					createIFrame(jinhuoItem,JinHuoDan_IFrame.class);
				}
					});	
		}
		return jinhuoItem;
	}
	
	
	
	//进货退货菜单项：jinhuo_tuihuoItem
	private JMenuItem getJinhuo_tuihuoItem()
	{
		if(jinhuo_tuihuoItem==null)
		{
			jinhuo_tuihuoItem=new JMenuItem();
			jinhuo_tuihuoItem.setText("进货退货");
			Icon icon=new ImageIcon(this.getClass().getResource("/res/icon/jinhuo_tuihuo.png"));
			jinhuo_tuihuoItem.setIcon(icon);
			jinhuo_tuihuoItem.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					//显示其对应的内部窗体，其中A为其内部窗体类，单独实现
					createIFrame(jinhuo_tuihuoItem,JinHuoTuiHuo_IFrame.class);
				}
					});
		}
		return jinhuo_tuihuoItem;
	}
	
	
	
	
	/*
	 * 初始化（销售管理）菜单，及其菜单项：xiaoshou_Menu，xiaoshou_danItem，xiaoshou_tuihuoItem
	 */
	//销售管理菜单:xiaoshou_Menu
	private JMenu getXiaoshou_Menu()
	{
		if(xiaoshou_Menu==null)
		{
			xiaoshou_Menu=new JMenu();
			xiaoshou_Menu.setText("销售管理(X)");
			xiaoshou_Menu.setMnemonic(KeyEvent.VK_X);
			//添加其菜单项
			xiaoshou_Menu.add(getXiaoshou_danItem());
			xiaoshou_Menu.add(getXiaoshou_tuihuoItem());
		}
		return xiaoshou_Menu;
	}
	
	//销售单菜单项：xiaoshou_danItem
	public JMenuItem getXiaoshou_danItem()
	{
		if(xiaoshou_danItem==null)
		{
			xiaoshou_danItem=new JMenuItem();
			xiaoshou_danItem.setText("销售单");
			Icon icon=new ImageIcon(this.getClass().getResource("/res/icon/xiaoshoudan.png"));
			xiaoshou_danItem.setIcon(icon);
			xiaoshou_danItem.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					//显示其对应的内部窗体，其中A为其内部窗体类，单独实现
					createIFrame(xiaoshou_danItem,XiaoShouDan_IFrame.class);
				}
					});
		}
		return xiaoshou_danItem;
	}
	
	//销售退货菜单项：xiaoshou_tuihuoItem
	private JMenuItem getXiaoshou_tuihuoItem()
	{
		if(xiaoshou_tuihuoItem==null)
		{
			xiaoshou_tuihuoItem=new JMenuItem();
			xiaoshou_tuihuoItem.setText("销售退货");
			Icon icon=new ImageIcon(this.getClass().getResource("/res/icon/xiaoshou_tuihuo.png"));
			xiaoshou_tuihuoItem.setIcon(icon);
			xiaoshou_tuihuoItem.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					//显示其对应的内部窗体，其中A为其内部窗体类，单独实现
					createIFrame(xiaoshou_tuihuoItem,XiaoShouTuiHuo_IFrame.class);
				}
					});
		}
		return xiaoshou_tuihuoItem;
	}
	
	
	
	/*
	 * 初始化（库存管理）菜单，及其菜单项：kucun_Menu,kucun_pandianItem，jiage_tiaozhengItem
	 */
	//库存管理菜单：kucun_Menu
	private JMenu getKucun_Menu()
	{
		if(kucun_Menu==null)
		{
			kucun_Menu=new JMenu();
			kucun_Menu.setText("库存管理(K)");
			kucun_Menu.setMnemonic(KeyEvent.VK_K);
			//添加其菜单项
			kucun_Menu.add(getKucun_pandianItem());
			kucun_Menu.add(getJiage_tiaozhengItem());
		}
		return kucun_Menu;
	}
	
	//库存盘点菜单项：kucun_pandianItem
	public JMenuItem getKucun_pandianItem()
	{
		if(kucun_pandianItem==null)
		{
			kucun_pandianItem=new JMenuItem();
			kucun_pandianItem.setText("库存盘点");
			Icon icon=new ImageIcon(this.getClass().getResource("/res/icon/kucun_pandian.png"));
			kucun_pandianItem.setIcon(icon);
			kucun_pandianItem.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					//显示其对应的内部窗体，其中A为其内部窗体类，单独实现
					createIFrame(kucun_pandianItem,KuCunPanDian_IFrame.class);
				}
					});
		}
		return kucun_pandianItem;
	}
	
	//价格调整菜单项：jiage_tiaozhengItem
	public JMenuItem getJiage_tiaozhengItem()
	{
		if(jiage_tiaozhengItem==null)
		{
			jiage_tiaozhengItem=new JMenuItem();
			jiage_tiaozhengItem.setText("价格调整");
			Icon icon=new ImageIcon(this.getClass().getResource("/res/icon/jiage_tiaozheng.png"));
			jiage_tiaozhengItem.setIcon(icon);
			jiage_tiaozhengItem.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					//显示其对应的内部窗体，其中A为其内部窗体类，单独实现
					createIFrame(jiage_tiaozhengItem,JiaGeTiaoZheng_IFrame.class);
				}
					});
		}
		return jiage_tiaozhengItem;
	}
	
	
	
	/*
	 * 初始化（信息查询）菜单，及其菜单项：xinxi_chaxunMenu，xiaoshou_chaxunItem，shangpin_chaxunItem,xiaoshou_paihangItem
	 */
	//信息查询菜单：xinxi_chaxunMenu
	private JMenu getXinxi_chaxunMenu()
	{
		if(xinxi_chaxunMenu==null)
		{
			xinxi_chaxunMenu=new JMenu();
			xinxi_chaxunMenu.setText("信息查询(C)");
			xinxi_chaxunMenu.setMnemonic(KeyEvent.VK_C);
			//添加子菜单项及分隔符
			xinxi_chaxunMenu.add(getXiaoshou_chaxunItem());
			xinxi_chaxunMenu.add(getShangpin_chaxunItem());
			xinxi_chaxunMenu.addSeparator();
			xinxi_chaxunMenu.add(getXiaoshou_paihangItem());
		}
		return xinxi_chaxunMenu;
	}
	
	//销售查询菜单项：xiaoshou_chaxunItem
	private JMenuItem getXiaoshou_chaxunItem()
	{
		if(xiaoshou_chaxunItem==null)
		{
			xiaoshou_chaxunItem=new JMenuItem();
			xiaoshou_chaxunItem.setText("销售查询");
			Icon icon=new ImageIcon(this.getClass().getResource("/res/icon/xiaoshou_chaxun.png"));
			xiaoshou_chaxunItem.setIcon(icon);
			xiaoshou_chaxunItem.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					//显示其对应的内部窗体，其中A为其内部窗体类，单独实现
					createIFrame(xiaoshou_chaxunItem,XiaoShouChaXun_IFrame.class);
				}
					});		
		}
		return xiaoshou_chaxunItem;
	}
	
	//商品查询菜单项：shangpin_chaxunItem
	public JMenuItem getShangpin_chaxunItem()
	{
		if(shangpin_chaxunItem==null)
		{
			shangpin_chaxunItem=new JMenuItem();
			shangpin_chaxunItem.setText("商品查询");
			Icon icon=new ImageIcon(this.getClass().getResource("/res/icon/shangpin_chaxun.png"));
			shangpin_chaxunItem.setIcon(icon);
			shangpin_chaxunItem.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					//显示其对应的内部窗体，其中A为其内部窗体类，单独实现
					createIFrame(shangpin_chaxunItem,ShangPinChaXun_IFrame.class);
				}
					});
		}
		return shangpin_chaxunItem;
	}
	
	//销售排行菜单项：xiaoshou_paihangItem
	private JMenuItem getXiaoshou_paihangItem()
	{
		if(xiaoshou_paihangItem==null)
		{
			xiaoshou_paihangItem=new JMenuItem();
			xiaoshou_paihangItem.setText("销售排行");
			Icon icon=new ImageIcon(this.getClass().getResource("/res/icon/xiaoshou_paihang.png"));
			xiaoshou_paihangItem.setIcon(icon);
			xiaoshou_paihangItem.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					//显示其对应的内部窗体，其中A为其内部窗体类，单独实现
					createIFrame(xiaoshou_paihangItem,XiaoShouPaiHang_IFrame.class);
				}
					});
		}
		return xiaoshou_paihangItem;
	}
	

	
	/*
	 * 初始化（基本资料）菜单，及其菜单项：jiben_ziliaoMenu，shangpin_guanliItem，
	 * kehu_guanliItem，gys_guanliItem，jsr_guanliItem
	 */
	//基本资料菜单：jiben_ziliaoMenu
	private JMenu getJiben_ziliaoMenu()
	{
		if(jiben_ziliaoMenu==null)
		{
			jiben_ziliaoMenu=new JMenu();
			jiben_ziliaoMenu.setText("基本资料(B)");
			jiben_ziliaoMenu.setMnemonic(KeyEvent.VK_B);
			//添加子菜单项
			jiben_ziliaoMenu.add(getShangpin_guanliItem());
			jiben_ziliaoMenu.add(getKehu_guanliItem());
			jiben_ziliaoMenu.add(getGys_guanliItem());
			jiben_ziliaoMenu.addSeparator();
			jiben_ziliaoMenu.add(getJsr_guanliItem());
		}
		return jiben_ziliaoMenu;
	}
	
	//商品管理菜单项：shangpin_guanliItem
	public JMenuItem getShangpin_guanliItem()
	{
		if(shangpin_guanliItem==null)
		{
			shangpin_guanliItem=new JMenuItem();
			shangpin_guanliItem.setText("商品资料管理");
			Icon icon=new ImageIcon(this.getClass().getResource("/res/icon/shangpin_guanli.png"));
			shangpin_guanliItem.setIcon(icon);
			shangpin_guanliItem.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					//显示其对应的内部窗体，其中A为其内部窗体类，单独实现
					createIFrame(shangpin_guanliItem,ShangPinGuanLi_IFrame.class);
				}
					});
		}
		return shangpin_guanliItem;
	}
	
	//客户管理菜单项：kehu_guanliItem
	public JMenuItem getKehu_guanliItem()
	{
		if(kehu_guanliItem==null)
		{
			kehu_guanliItem=new JMenuItem();
			kehu_guanliItem.setText("客户资料管理");
			Icon icon=new ImageIcon(this.getClass().getResource("/res/icon/kehu_guanli.png"));
			kehu_guanliItem.setIcon(icon);
			kehu_guanliItem.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					//显示其对应的内部窗体，其中A为其内部窗体类，单独实现
					createIFrame(kehu_guanliItem,KeHuGuanLi_IFrame.class);
				}
					});
		}
		return kehu_guanliItem;
	}
	
	//供应商管理菜单项：gys_guanliItem
	public JMenuItem getGys_guanliItem()
	{
		if(gys_guanliItem==null)
		{
			gys_guanliItem=new JMenuItem();
			gys_guanliItem.setText("供应商资料管理");
			Icon icon=new ImageIcon(this.getClass().getResource("/res/icon/gys_guanli.png"));
			gys_guanliItem.setIcon(icon);
			gys_guanliItem.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					//显示其对应的内部窗体，其中A为其内部窗体类，单独实现
					createIFrame(gys_guanliItem,GysGuanLi_IFrame.class);
				}
					});
		}
		return gys_guanliItem;
	}
	
	//经手人管理菜单项：jsr_guanliItem
	private JMenuItem getJsr_guanliItem()
	{
		if(jsr_guanliItem==null)
		{
			jsr_guanliItem=new JMenuItem();
			jsr_guanliItem.setText("经手人设置");
			Icon icon=new ImageIcon(this.getClass().getResource("/res/icon/jsr_shezhi.png"));
			jsr_guanliItem.setIcon(icon);
			jsr_guanliItem.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					//显示其对应的内部窗体，其中A为其内部窗体类，单独实现
					createIFrame(jsr_guanliItem,JsrGuanLi_IFrame.class);
				}
					});
		}
		return jsr_guanliItem;
	}
	
	
	
	/*
	 * 初始化（系统维护）菜单，及其菜单项：xitong_weihuMenu，mima_xiugaiItem
	 * shuju_beifenItem，exitItem
	 */
	//系统维护菜单：xitong_weihuMenu
	private JMenu getXitong_weihuMenu()
	{
		if(xitong_weihuMenu==null)
		{
			xitong_weihuMenu=new JMenu();
			xitong_weihuMenu.setText("系统维护(S)");
			xitong_weihuMenu.setMnemonic(KeyEvent.VK_S);
			//添加其菜单项
			xitong_weihuMenu.add(getMima_xiugaiItem());
			xitong_weihuMenu.addSeparator();
			xitong_weihuMenu.add(getShuju_beifenItem());
			xitong_weihuMenu.addSeparator();
			xitong_weihuMenu.add(getExitItem());
		}
		return xitong_weihuMenu;
	}
	
	//密码修改菜单项：mima_xiugaiItem
	private JMenuItem getMima_xiugaiItem()
	{
		if(mima_xiugaiItem==null)
		{
			mima_xiugaiItem=new JMenuItem();
			mima_xiugaiItem.setText("密码修改");
			Icon icon=new ImageIcon(this.getClass().getResource("/res/icon/mima_xiugai.png"));
			mima_xiugaiItem.setIcon(icon);
			mima_xiugaiItem.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					//显示其对应的内部窗体，其中A为其内部窗体类，单独实现
					createIFrame(mima_xiugaiItem,MiMaXiuGai_IFrame.class);
				}
					});
		}
		return mima_xiugaiItem;
	}
	
	//数据备份与恢复菜单项：shuju_beifenItem
	private JMenuItem getShuju_beifenItem()
	{
		if(shuju_beifenItem==null)
		{
			shuju_beifenItem=new JMenuItem();
			shuju_beifenItem.setText("数据库备份与恢复");
			Icon icon=new ImageIcon(this.getClass().getResource("/res/icon/shujuku_beifen_huifu.png"));
			shuju_beifenItem.setIcon(icon);
			shuju_beifenItem.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					//显示其对应的内部窗体，其中A为其内部窗体类，单独实现
					createIFrame(shuju_beifenItem,BackupAndRestore_IFrame.class);
				}
					});
		}
		return shuju_beifenItem;
	}
	
	//退出菜单项：exitItem
	public JMenuItem getExitItem()
	{
		if(exitItem==null)
		{
			exitItem=new JMenuItem();
			exitItem.setText("退出系统");
			Icon icon=new ImageIcon(this.getClass().getResource("/res/icon/tuichu_xitong.png"));
			exitItem.setIcon(icon);
			exitItem.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					System.exit(0);
				}
					});
		}
		return exitItem;
	}
	
	
	
	/*
	 * 初始化（窗口）菜单，及其菜单项：chuang_kouMenu，pingpuItem，closeAllItem
	 * allIconItem，allResumeItem
	 */
	
	//窗口菜单：chuang_kouMenu
	private JMenu getChuang_kouMenu()
	{
		if(chuang_kouMenu==null)
		{
			chuang_kouMenu=new JMenu();
			chuang_kouMenu.setText("窗口(W)");
			chuang_kouMenu.setMnemonic(KeyEvent.VK_W);
			chuang_kouMenu.addMenuListener(new MenuListener()
					{
				public void menuSelected(MenuEvent e)
				{
					chuang_kouMenu.removeAll();
					chuang_kouMenu.add(getPingpuItem());
					chuang_kouMenu.add(getCloseAllItem());
					chuang_kouMenu.add(getAllIconItem());
					chuang_kouMenu.add(getAllResumeItem());
					chuang_kouMenu.addSeparator();
					
					int count=0;
					JInternalFrame[] allFrames=desktopPanel.getAllFrames();
					for(JInternalFrame iFrame : allFrames)
					{
						String title=iFrame.getTitle();
						count++;
						JMenuItem tmp=new JMenuItem(count +  " " + title);
						chuang_kouMenu.add(tmp);
						
						tmp.addActionListener(new ActionListener()
								{
							public void actionPerformed(ActionEvent e)
							{
								try
								{
									iFrame.setIcon(false);
									iFrame.setSelected(true);
								}
								catch(PropertyVetoException e1)
								{
									e1.printStackTrace();
								}
							}
								});
					}
				}
				
				public void menuDeselected(MenuEvent e)
				{
					
				}
				
				public void menuCanceled(MenuEvent e)
				{
					
				}
				
					});
		}
		return chuang_kouMenu;
	}
	
	//平铺菜单项：pingpuItem
	private JMenuItem getPingpuItem()
	{
		if(pingpuItem==null)
		{
			pingpuItem=new JMenuItem();
			pingpuItem.setText("窗口层叠");
			Icon icon=new ImageIcon(this.getClass().getResource("/res/icon/chuangkou_pingpu.png"));
			pingpuItem.setIcon(icon);
			pingpuItem.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					JInternalFrame[] allFrames=desktopPanel.getAllFrames();
					int x=0,y=0;
					for(JInternalFrame iFrame : allFrames)
					{
						iFrame.setLocation(x,y);
						try
						{
							iFrame.setSelected(true);
						}
						catch(PropertyVetoException e1)
						{
							e1.printStackTrace();
						}
						
						int frameH=iFrame.getPreferredSize().height;
						int panelH=iFrame.getContentPane().getPreferredSize().height;
						int fSpacing=frameH-panelH;
						x+=fSpacing;
						y+=fSpacing;
						
						if(x+iFrame.getWidth()/2>desktopPanel.getWidth())
							x=0;
						if(y+iFrame.getHeight()/2>desktopPanel.getHeight())
							y=0;
					}
				}
					});
		}
		return pingpuItem;
	}
	
	//全部关闭菜单项：closeAllItem
	private JMenuItem getCloseAllItem()
	{
		if(closeAllItem==null)
		{
			closeAllItem=new JMenuItem();
			closeAllItem.setText("全部关闭");
			Icon icon=new ImageIcon(this.getClass().getResource("/res/icon/quanbu_guanbi.png"));
			closeAllItem.setIcon(icon);
			closeAllItem.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					JInternalFrame[] allFrames=desktopPanel.getAllFrames();
					for(JInternalFrame iFrame : allFrames)
					{
						iFrame.doDefaultCloseAction();
					}
				}
					});
		}
		return closeAllItem;
	}
	
	//全部最小化菜单项：allIconItem
	private JMenuItem getAllIconItem()
	{
		if(allIconItem==null)
		{
			allIconItem=new JMenuItem();
			allIconItem.setText("全部最小化");
			Icon icon=new ImageIcon(this.getClass().getResource("/res/icon/quanbu_zuixiaohua.png"));
			allIconItem.setIcon(icon);
			allIconItem.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					JInternalFrame[] allFrames=desktopPanel.getAllFrames();
					for(JInternalFrame iFrame : allFrames)
					{
						try
						{
						iFrame.setIcon(true);
						}
						catch(Exception e1)
						{
							e1.printStackTrace();
						}
					}
				}
					});
		}
		return allIconItem;
	}
	
	//全部还原菜单项：allResumeItem
	private JMenuItem getAllResumeItem()
	{
		if(allResumeItem==null)
		{
			allResumeItem=new JMenuItem();
			allResumeItem.setText("全部还原");
			Icon icon=new ImageIcon(this.getClass().getResource("/res/icon/quanbu_huanyuan.png"));
			allResumeItem.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					JInternalFrame[] allFrames=desktopPanel.getAllFrames();
					for(JInternalFrame iFrame : allFrames)
					{
						try
						{
						iFrame.setIcon(false);
						}
						catch(Exception e1)
						{
							e1.printStackTrace();
						}
					}
				}
					});
		}
		return allResumeItem;
	}
	
	
	
	/*
	 * 初始化（帮助）菜单，及其菜单项：bang_zhuMenu，guanyu_Item，bugItem，fangwen_wangzhanItem
	 */
	//帮助菜单：bang_zhuMenu
	private JMenu getBang_zhuMenu()
	{
		if(bang_zhuMenu==null)
		{
			bang_zhuMenu=new JMenu();
			bang_zhuMenu.setText("帮助(H)");
			bang_zhuMenu.setMnemonic(KeyEvent.VK_K);
			bang_zhuMenu.add(getGuanyu_Item());
			bang_zhuMenu.add(getBugItem());
			bang_zhuMenu.add(getFangwen_wangzhanItem());	
		}
		return bang_zhuMenu;
	}
	
	//关于菜单项：guanyu_Item
	private JMenuItem getGuanyu_Item()
	{
		if(guanyu_Item==null)
		{
			guanyu_Item=new JMenuItem();
			guanyu_Item.setText("关于");
			Icon icon=new ImageIcon(this.getClass().getResource("/res/icon/guanyu.png"));
			guanyu_Item.setIcon(icon);
			
			//
			URL url=DesktopPanel.class.getResource("/res/about.jpg");
			ImageIcon aboutImage=new ImageIcon(url);
			final JLabel imgLabel=new JLabel(aboutImage);
			//imgLabel.setIcon(aboutImage);
			imgLabel.setVisible(false);
			desktopPanel.add(imgLabel);
			desktopPanel.setLayer(imgLabel, Integer.MAX_VALUE);
			
			guanyu_Item.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					int dw=desktopPanel.getWidth();
					int dh=desktopPanel.getHeight();
					
					imgLabel.setBounds((dw-500)/2, (dh-350)/2, 500, 350);
					imgLabel.setVisible(true);
				}
					});
			
			
			//
			imgLabel.addMouseListener(new MouseAdapter()
					{
				public void mouseClicked(MouseEvent e)
				{
					imgLabel.setVisible(false);
				}
					});
			
		}
		return guanyu_Item;
	}
	
	//联系技术支持菜单项：bugItem
	private JMenuItem getBugItem()
	{
		if(bugItem==null)
		{
			bugItem=new JMenuItem();
			bugItem.setText("联系技术支持");
			Icon icon=new ImageIcon(this.getClass().getResource("/res/icon/jishu_zhichi.png"));
			bugItem.setIcon(icon);
			
			//
			bugItem.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					if(Desktop.isDesktopSupported())
					{
						Desktop desktop=Desktop.getDesktop();
						
						try
						{
							URI uri=new URI("mail:465151160@qq.com");
							desktop.mail(uri);
						}
						catch(Exception e1)
						{
							e1.printStackTrace();
						}
					}
				}
					});
		}
		return bugItem;
	}
	
	//访问技术网站菜单项：fangwen_wangzhanItem
	private JMenuItem getFangwen_wangzhanItem()
	{
		if(fangwen_wangzhanItem==null)
		{
			fangwen_wangzhanItem=new JMenuItem();
			fangwen_wangzhanItem.setText("访问技术网站");
			Icon icon=new ImageIcon(this.getClass().getResource("/res/icon/jishu_wangzhan.png"));
			fangwen_wangzhanItem.setIcon(icon);
			
			//
			fangwen_wangzhanItem.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					if(Desktop.isDesktopSupported())
					{
						Desktop desktop=Desktop.getDesktop();
						
						try
						{
							URL url=new URL("https://www.baidu.com/");
							desktop.browse(url.toURI());
						}
						catch(Exception e1)
						{
							e1.printStackTrace();
						}
					}
				}
					});
		}
		return fangwen_wangzhanItem;
	}
	
	
}
