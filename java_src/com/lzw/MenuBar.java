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

public class MenuBar extends JMenuBar{    //��������װ�˵�����
	
	/*
	 * ��������˵�������˵���
	 */
	//(��������)�˵�
	private JMenu jinhuo_Menu=null;
	//(������)�˵���,λ��(��������)�˵���
	private JMenuItem jinhuoItem=null;
	//(�����˻�)�˵���,λ��(��������)�˵���
	private JMenuItem jinhuo_tuihuoItem=null;
	
	
	
	//(���۹���)�˵�
	private JMenu xiaoshou_Menu=null;
	
	//(������)�˵�
	private JMenu kucun_Menu=null;
	
	//(��Ϣ��ѯ)�˵�
	private JMenu xinxi_chaxunMenu=null;
	
	//(��������)�˵�
	private JMenu jiben_ziliaoMenu=null;
	
	//(ϵͳά��)�˵�
	private JMenu xitong_weihuMenu=null;
	
	//(����)�˵�
	private JMenu chuang_kouMenu=null;
	
	
	
	/*
	 * �����˵�������˵���
	 */
	//(����)�˵�
	private JMenu bang_zhuMenu=null;
	//(����)�˵��λ��(����)�˵���
	private JMenuItem guanyu_Item=null;
	//(��ϵ����֧��)�˵��λ��(����)�˵���
	private JMenuItem bugItem=null;
	//(���ʼ�����վ���˵��λ�ڣ��������˵���
	private JMenuItem fangwen_wangzhanItem=null;
	
	
	
	/*
	 * ���۹���˵�������˵���
	 */
	//(���۵����˵��λ�ڣ����۹����˵���
	private JMenuItem xiaoshou_danItem=null;
	//(�����˻����˵��λ�ڣ����۹����˵���
	private JMenuItem xiaoshou_tuihuoItem=null;
	
	
	
	/*
	 * ������˵�������˵���
	 */
	//(����̵㣩�˵��λ�ڣ��������˵���
	private JMenuItem kucun_pandianItem=null;
	//(�۸�������˵��λ�ڣ��������˵���
	private JMenuItem jiage_tiaozhengItem=null;
	
	
	
	/*
	 * ��Ϣ��ѯ�˵�������˵���
	 */
	//(���۲�ѯ���˵��λ��(��Ϣ��ѯ)�˵���
	private JMenuItem xiaoshou_chaxunItem=null;
	//(��Ʒ��ѯ���˵��λ�ڣ���Ϣ��ѯ���˵���
	private JMenuItem shangpin_chaxunItem=null;
	//���������У��˵��λ�ڣ���Ϣ��ѯ���˵���
	private JMenuItem xiaoshou_paihangItem=null;
	
	
	
	/*
	 * �������ϲ˵�������˵���
	 */
	//(��Ʒ�����˵��λ�ڣ��������ϣ��˵���
	private JMenuItem shangpin_guanliItem=null;
	//���ͻ������˵��λ�ڣ��������ϣ��˵���
	private JMenuItem kehu_guanliItem=null;
	//����Ӧ�̹����˵��λ�ڣ��������ϣ��˵���
	private JMenuItem gys_guanliItem=null;
	//�����������ã��˵��λ�ڣ��������ϣ��˵���
	private JMenuItem jsr_guanliItem=null;
	
	
	
	/*
	 * ϵͳά���˵�������˵���
	 */
	//�������޸ģ��˵��λ�ڣ�ϵͳά�����˵���
	private JMenuItem mima_xiugaiItem=null;
	//�����ݱ�����ָ�����λ�ڣ�ϵͳά�����˵���
	private JMenuItem shuju_beifenItem=null;
	//���˳����˵��λ�ڣ�ϵͳά�����˵���
	private JMenuItem exitItem=null;
	
	
	/*
	 * ���ڲ˵�������˵���
	 */
	//������ƽ�̣��˵��λ�ڣ����ڣ��˵���
	private JMenuItem pingpuItem=null;
	//��ȫ���رգ��˵��λ�ڣ����ڣ��˵���
	private JMenuItem closeAllItem=null;
	//��ȫ����С�����˵��λ�ڣ����ڣ��˵���
	private JMenuItem allIconItem=null;
	//��ȫ����ԭ���˵��λ�ڣ����ڣ��˵���
	private JMenuItem allResumeItem=null;
	
	
	//�����ڲ�������������
	private JDesktopPane desktopPanel=null;
	
	//�ڲ�����ļ���
	private Map<JMenuItem,JInternalFrame> iFrames=null;
	
	//�ڲ����������λ��
	private int nextFrameX,nextFrameY;
	
	//״̬�����ڲ�������ʾ��ǩ
	private JLabel stateLabel=null;
	
	
	
	//���췽��
	private MenuBar()
	{
		
	}
	
	//public ��ʽ�Ĺ��췽�����������ⲿ�����˵�������ʵ��
	public MenuBar(JDesktopPane desktopPanel,JLabel label)
	{
		iFrames=new HashMap<>();
		//
		this.desktopPanel=desktopPanel;
		this.stateLabel=label;
		init();
	}
	
	
	//�˵����ĳ�ʼ��
	private void init()
	{
		//�˵����Ĵ�С
		this.setSize(new Dimension(600,24));
		//��˵����зֱ����8���˵�����
		this.add(getJinhuo_Menu());
		this.add(getXiaoshou_Menu());
		this.add(getKucun_Menu());
		this.add(getXinxi_chaxunMenu());
		this.add(getJiben_ziliaoMenu());
		this.add(getXitong_weihuMenu());
		this.add(getChuang_kouMenu());
		this.add(getBang_zhuMenu());
	}
	
	
	
	
	//�������ɸ����˵����Ӧ���ڲ�����ķ��������÷��似��
	private JInternalFrame createIFrame(JMenuItem item,Class<?> clazz)
	{
		/*
		 * item���˵���
		 * clazz���˵���item��Ӧ���ڲ�����������(�ڲ�����������һ�����ж��壩
		 */
		Constructor<?> constructor=clazz.getConstructors()[0];
		JInternalFrame iFrame=iFrames.get(item);
		
		try
		{
		if(iFrame==null || iFrame.isClosed())
			
		   {
			iFrame=(JInternalFrame)constructor.newInstance(null);    //����constructor����ʵ��
			iFrames.put(item, iFrame);    //����ӳ������ֵ���
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
			
			//���ڲ�������뵽���������
			desktopPanel.add(iFrame);
			iFrame.setResizable(false);
			iFrame.setMaximizable(false);
			iFrame.setVisible(true);
		   }
		iFrame.setSelected(true);
		stateLabel.setText(iFrame.getTitle());
		
		//�򿪶���ڲ����壬Ϊ�л�ѡ�д��壬Ϊÿ���ڲ�������Ӽ�����������A�����л���B����ʱ��
		//��ִ��B�����activated����
		iFrame.addInternalFrameListener(new InternalFrameAdapter()
				{
			public void internalFrameActivated(InternalFrameEvent e)
			{
				JInternalFrame frame=e.getInternalFrame();
				stateLabel.setText(frame.getTitle());
			}
			
			public void internalFrameDeactivated(InternalFrameEvent e)
			{
				stateLabel.setText("û��ѡ����");
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
	 * ��ʼ�������������˵�������˵���
	 */
	//��������˵�
	private JMenu getJinhuo_Menu()
	{
		if(jinhuo_Menu==null)
		{
			jinhuo_Menu=new JMenu();
			jinhuo_Menu.setText("��������(J)");
			jinhuo_Menu.setMnemonic(KeyEvent.VK_J);
			//�����˵���
			jinhuo_Menu.add(getJinhuoItem());
			jinhuo_Menu.add(getJinhuo_tuihuoItem());
		}
		return jinhuo_Menu;
	}
	
	
	//��ʼ�������������˵��Ĳ˵���jinhuoItem,jinhuo_tuihuoItem
	//�������˵��jinhuoItem
	public JMenuItem getJinhuoItem()
	{
		if(jinhuoItem==null)
		{
			jinhuoItem=new JMenuItem();
			jinhuoItem.setText("������");
			Icon icon=new ImageIcon(this.getClass().getResource("/res/icon/jinhuodan.png"));
			jinhuoItem.setIcon(icon);
			//�����ʾ���ڲ�����ļ�����
			jinhuoItem.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					//�����ʾ��Ӧ���ڲ�����ķ���,����AΪjinhuoItem��Ӧ���ڲ������࣬����ʵ��
					createIFrame(jinhuoItem,JinHuoDan_IFrame.class);
				}
					});	
		}
		return jinhuoItem;
	}
	
	
	
	//�����˻��˵��jinhuo_tuihuoItem
	private JMenuItem getJinhuo_tuihuoItem()
	{
		if(jinhuo_tuihuoItem==null)
		{
			jinhuo_tuihuoItem=new JMenuItem();
			jinhuo_tuihuoItem.setText("�����˻�");
			Icon icon=new ImageIcon(this.getClass().getResource("/res/icon/jinhuo_tuihuo.png"));
			jinhuo_tuihuoItem.setIcon(icon);
			jinhuo_tuihuoItem.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					//��ʾ���Ӧ���ڲ����壬����AΪ���ڲ������࣬����ʵ��
					createIFrame(jinhuo_tuihuoItem,JinHuoTuiHuo_IFrame.class);
				}
					});
		}
		return jinhuo_tuihuoItem;
	}
	
	
	
	
	/*
	 * ��ʼ�������۹����˵�������˵��xiaoshou_Menu��xiaoshou_danItem��xiaoshou_tuihuoItem
	 */
	//���۹���˵�:xiaoshou_Menu
	private JMenu getXiaoshou_Menu()
	{
		if(xiaoshou_Menu==null)
		{
			xiaoshou_Menu=new JMenu();
			xiaoshou_Menu.setText("���۹���(X)");
			xiaoshou_Menu.setMnemonic(KeyEvent.VK_X);
			//�����˵���
			xiaoshou_Menu.add(getXiaoshou_danItem());
			xiaoshou_Menu.add(getXiaoshou_tuihuoItem());
		}
		return xiaoshou_Menu;
	}
	
	//���۵��˵��xiaoshou_danItem
	public JMenuItem getXiaoshou_danItem()
	{
		if(xiaoshou_danItem==null)
		{
			xiaoshou_danItem=new JMenuItem();
			xiaoshou_danItem.setText("���۵�");
			Icon icon=new ImageIcon(this.getClass().getResource("/res/icon/xiaoshoudan.png"));
			xiaoshou_danItem.setIcon(icon);
			xiaoshou_danItem.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					//��ʾ���Ӧ���ڲ����壬����AΪ���ڲ������࣬����ʵ��
					createIFrame(xiaoshou_danItem,XiaoShouDan_IFrame.class);
				}
					});
		}
		return xiaoshou_danItem;
	}
	
	//�����˻��˵��xiaoshou_tuihuoItem
	private JMenuItem getXiaoshou_tuihuoItem()
	{
		if(xiaoshou_tuihuoItem==null)
		{
			xiaoshou_tuihuoItem=new JMenuItem();
			xiaoshou_tuihuoItem.setText("�����˻�");
			Icon icon=new ImageIcon(this.getClass().getResource("/res/icon/xiaoshou_tuihuo.png"));
			xiaoshou_tuihuoItem.setIcon(icon);
			xiaoshou_tuihuoItem.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					//��ʾ���Ӧ���ڲ����壬����AΪ���ڲ������࣬����ʵ��
					createIFrame(xiaoshou_tuihuoItem,XiaoShouTuiHuo_IFrame.class);
				}
					});
		}
		return xiaoshou_tuihuoItem;
	}
	
	
	
	/*
	 * ��ʼ�����������˵�������˵��kucun_Menu,kucun_pandianItem��jiage_tiaozhengItem
	 */
	//������˵���kucun_Menu
	private JMenu getKucun_Menu()
	{
		if(kucun_Menu==null)
		{
			kucun_Menu=new JMenu();
			kucun_Menu.setText("������(K)");
			kucun_Menu.setMnemonic(KeyEvent.VK_K);
			//�����˵���
			kucun_Menu.add(getKucun_pandianItem());
			kucun_Menu.add(getJiage_tiaozhengItem());
		}
		return kucun_Menu;
	}
	
	//����̵�˵��kucun_pandianItem
	public JMenuItem getKucun_pandianItem()
	{
		if(kucun_pandianItem==null)
		{
			kucun_pandianItem=new JMenuItem();
			kucun_pandianItem.setText("����̵�");
			Icon icon=new ImageIcon(this.getClass().getResource("/res/icon/kucun_pandian.png"));
			kucun_pandianItem.setIcon(icon);
			kucun_pandianItem.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					//��ʾ���Ӧ���ڲ����壬����AΪ���ڲ������࣬����ʵ��
					createIFrame(kucun_pandianItem,KuCunPanDian_IFrame.class);
				}
					});
		}
		return kucun_pandianItem;
	}
	
	//�۸�����˵��jiage_tiaozhengItem
	public JMenuItem getJiage_tiaozhengItem()
	{
		if(jiage_tiaozhengItem==null)
		{
			jiage_tiaozhengItem=new JMenuItem();
			jiage_tiaozhengItem.setText("�۸����");
			Icon icon=new ImageIcon(this.getClass().getResource("/res/icon/jiage_tiaozheng.png"));
			jiage_tiaozhengItem.setIcon(icon);
			jiage_tiaozhengItem.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					//��ʾ���Ӧ���ڲ����壬����AΪ���ڲ������࣬����ʵ��
					createIFrame(jiage_tiaozhengItem,JiaGeTiaoZheng_IFrame.class);
				}
					});
		}
		return jiage_tiaozhengItem;
	}
	
	
	
	/*
	 * ��ʼ������Ϣ��ѯ���˵�������˵��xinxi_chaxunMenu��xiaoshou_chaxunItem��shangpin_chaxunItem,xiaoshou_paihangItem
	 */
	//��Ϣ��ѯ�˵���xinxi_chaxunMenu
	private JMenu getXinxi_chaxunMenu()
	{
		if(xinxi_chaxunMenu==null)
		{
			xinxi_chaxunMenu=new JMenu();
			xinxi_chaxunMenu.setText("��Ϣ��ѯ(C)");
			xinxi_chaxunMenu.setMnemonic(KeyEvent.VK_C);
			//����Ӳ˵���ָ���
			xinxi_chaxunMenu.add(getXiaoshou_chaxunItem());
			xinxi_chaxunMenu.add(getShangpin_chaxunItem());
			xinxi_chaxunMenu.addSeparator();
			xinxi_chaxunMenu.add(getXiaoshou_paihangItem());
		}
		return xinxi_chaxunMenu;
	}
	
	//���۲�ѯ�˵��xiaoshou_chaxunItem
	private JMenuItem getXiaoshou_chaxunItem()
	{
		if(xiaoshou_chaxunItem==null)
		{
			xiaoshou_chaxunItem=new JMenuItem();
			xiaoshou_chaxunItem.setText("���۲�ѯ");
			Icon icon=new ImageIcon(this.getClass().getResource("/res/icon/xiaoshou_chaxun.png"));
			xiaoshou_chaxunItem.setIcon(icon);
			xiaoshou_chaxunItem.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					//��ʾ���Ӧ���ڲ����壬����AΪ���ڲ������࣬����ʵ��
					createIFrame(xiaoshou_chaxunItem,XiaoShouChaXun_IFrame.class);
				}
					});		
		}
		return xiaoshou_chaxunItem;
	}
	
	//��Ʒ��ѯ�˵��shangpin_chaxunItem
	public JMenuItem getShangpin_chaxunItem()
	{
		if(shangpin_chaxunItem==null)
		{
			shangpin_chaxunItem=new JMenuItem();
			shangpin_chaxunItem.setText("��Ʒ��ѯ");
			Icon icon=new ImageIcon(this.getClass().getResource("/res/icon/shangpin_chaxun.png"));
			shangpin_chaxunItem.setIcon(icon);
			shangpin_chaxunItem.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					//��ʾ���Ӧ���ڲ����壬����AΪ���ڲ������࣬����ʵ��
					createIFrame(shangpin_chaxunItem,ShangPinChaXun_IFrame.class);
				}
					});
		}
		return shangpin_chaxunItem;
	}
	
	//�������в˵��xiaoshou_paihangItem
	private JMenuItem getXiaoshou_paihangItem()
	{
		if(xiaoshou_paihangItem==null)
		{
			xiaoshou_paihangItem=new JMenuItem();
			xiaoshou_paihangItem.setText("��������");
			Icon icon=new ImageIcon(this.getClass().getResource("/res/icon/xiaoshou_paihang.png"));
			xiaoshou_paihangItem.setIcon(icon);
			xiaoshou_paihangItem.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					//��ʾ���Ӧ���ڲ����壬����AΪ���ڲ������࣬����ʵ��
					createIFrame(xiaoshou_paihangItem,XiaoShouPaiHang_IFrame.class);
				}
					});
		}
		return xiaoshou_paihangItem;
	}
	

	
	/*
	 * ��ʼ�����������ϣ��˵�������˵��jiben_ziliaoMenu��shangpin_guanliItem��
	 * kehu_guanliItem��gys_guanliItem��jsr_guanliItem
	 */
	//�������ϲ˵���jiben_ziliaoMenu
	private JMenu getJiben_ziliaoMenu()
	{
		if(jiben_ziliaoMenu==null)
		{
			jiben_ziliaoMenu=new JMenu();
			jiben_ziliaoMenu.setText("��������(B)");
			jiben_ziliaoMenu.setMnemonic(KeyEvent.VK_B);
			//����Ӳ˵���
			jiben_ziliaoMenu.add(getShangpin_guanliItem());
			jiben_ziliaoMenu.add(getKehu_guanliItem());
			jiben_ziliaoMenu.add(getGys_guanliItem());
			jiben_ziliaoMenu.addSeparator();
			jiben_ziliaoMenu.add(getJsr_guanliItem());
		}
		return jiben_ziliaoMenu;
	}
	
	//��Ʒ����˵��shangpin_guanliItem
	public JMenuItem getShangpin_guanliItem()
	{
		if(shangpin_guanliItem==null)
		{
			shangpin_guanliItem=new JMenuItem();
			shangpin_guanliItem.setText("��Ʒ���Ϲ���");
			Icon icon=new ImageIcon(this.getClass().getResource("/res/icon/shangpin_guanli.png"));
			shangpin_guanliItem.setIcon(icon);
			shangpin_guanliItem.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					//��ʾ���Ӧ���ڲ����壬����AΪ���ڲ������࣬����ʵ��
					createIFrame(shangpin_guanliItem,ShangPinGuanLi_IFrame.class);
				}
					});
		}
		return shangpin_guanliItem;
	}
	
	//�ͻ�����˵��kehu_guanliItem
	public JMenuItem getKehu_guanliItem()
	{
		if(kehu_guanliItem==null)
		{
			kehu_guanliItem=new JMenuItem();
			kehu_guanliItem.setText("�ͻ����Ϲ���");
			Icon icon=new ImageIcon(this.getClass().getResource("/res/icon/kehu_guanli.png"));
			kehu_guanliItem.setIcon(icon);
			kehu_guanliItem.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					//��ʾ���Ӧ���ڲ����壬����AΪ���ڲ������࣬����ʵ��
					createIFrame(kehu_guanliItem,KeHuGuanLi_IFrame.class);
				}
					});
		}
		return kehu_guanliItem;
	}
	
	//��Ӧ�̹���˵��gys_guanliItem
	public JMenuItem getGys_guanliItem()
	{
		if(gys_guanliItem==null)
		{
			gys_guanliItem=new JMenuItem();
			gys_guanliItem.setText("��Ӧ�����Ϲ���");
			Icon icon=new ImageIcon(this.getClass().getResource("/res/icon/gys_guanli.png"));
			gys_guanliItem.setIcon(icon);
			gys_guanliItem.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					//��ʾ���Ӧ���ڲ����壬����AΪ���ڲ������࣬����ʵ��
					createIFrame(gys_guanliItem,GysGuanLi_IFrame.class);
				}
					});
		}
		return gys_guanliItem;
	}
	
	//�����˹���˵��jsr_guanliItem
	private JMenuItem getJsr_guanliItem()
	{
		if(jsr_guanliItem==null)
		{
			jsr_guanliItem=new JMenuItem();
			jsr_guanliItem.setText("����������");
			Icon icon=new ImageIcon(this.getClass().getResource("/res/icon/jsr_shezhi.png"));
			jsr_guanliItem.setIcon(icon);
			jsr_guanliItem.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					//��ʾ���Ӧ���ڲ����壬����AΪ���ڲ������࣬����ʵ��
					createIFrame(jsr_guanliItem,JsrGuanLi_IFrame.class);
				}
					});
		}
		return jsr_guanliItem;
	}
	
	
	
	/*
	 * ��ʼ����ϵͳά�����˵�������˵��xitong_weihuMenu��mima_xiugaiItem
	 * shuju_beifenItem��exitItem
	 */
	//ϵͳά���˵���xitong_weihuMenu
	private JMenu getXitong_weihuMenu()
	{
		if(xitong_weihuMenu==null)
		{
			xitong_weihuMenu=new JMenu();
			xitong_weihuMenu.setText("ϵͳά��(S)");
			xitong_weihuMenu.setMnemonic(KeyEvent.VK_S);
			//�����˵���
			xitong_weihuMenu.add(getMima_xiugaiItem());
			xitong_weihuMenu.addSeparator();
			xitong_weihuMenu.add(getShuju_beifenItem());
			xitong_weihuMenu.addSeparator();
			xitong_weihuMenu.add(getExitItem());
		}
		return xitong_weihuMenu;
	}
	
	//�����޸Ĳ˵��mima_xiugaiItem
	private JMenuItem getMima_xiugaiItem()
	{
		if(mima_xiugaiItem==null)
		{
			mima_xiugaiItem=new JMenuItem();
			mima_xiugaiItem.setText("�����޸�");
			Icon icon=new ImageIcon(this.getClass().getResource("/res/icon/mima_xiugai.png"));
			mima_xiugaiItem.setIcon(icon);
			mima_xiugaiItem.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					//��ʾ���Ӧ���ڲ����壬����AΪ���ڲ������࣬����ʵ��
					createIFrame(mima_xiugaiItem,MiMaXiuGai_IFrame.class);
				}
					});
		}
		return mima_xiugaiItem;
	}
	
	//���ݱ�����ָ��˵��shuju_beifenItem
	private JMenuItem getShuju_beifenItem()
	{
		if(shuju_beifenItem==null)
		{
			shuju_beifenItem=new JMenuItem();
			shuju_beifenItem.setText("���ݿⱸ����ָ�");
			Icon icon=new ImageIcon(this.getClass().getResource("/res/icon/shujuku_beifen_huifu.png"));
			shuju_beifenItem.setIcon(icon);
			shuju_beifenItem.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					//��ʾ���Ӧ���ڲ����壬����AΪ���ڲ������࣬����ʵ��
					createIFrame(shuju_beifenItem,BackupAndRestore_IFrame.class);
				}
					});
		}
		return shuju_beifenItem;
	}
	
	//�˳��˵��exitItem
	public JMenuItem getExitItem()
	{
		if(exitItem==null)
		{
			exitItem=new JMenuItem();
			exitItem.setText("�˳�ϵͳ");
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
	 * ��ʼ�������ڣ��˵�������˵��chuang_kouMenu��pingpuItem��closeAllItem
	 * allIconItem��allResumeItem
	 */
	
	//���ڲ˵���chuang_kouMenu
	private JMenu getChuang_kouMenu()
	{
		if(chuang_kouMenu==null)
		{
			chuang_kouMenu=new JMenu();
			chuang_kouMenu.setText("����(W)");
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
	
	//ƽ�̲˵��pingpuItem
	private JMenuItem getPingpuItem()
	{
		if(pingpuItem==null)
		{
			pingpuItem=new JMenuItem();
			pingpuItem.setText("���ڲ��");
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
	
	//ȫ���رղ˵��closeAllItem
	private JMenuItem getCloseAllItem()
	{
		if(closeAllItem==null)
		{
			closeAllItem=new JMenuItem();
			closeAllItem.setText("ȫ���ر�");
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
	
	//ȫ����С���˵��allIconItem
	private JMenuItem getAllIconItem()
	{
		if(allIconItem==null)
		{
			allIconItem=new JMenuItem();
			allIconItem.setText("ȫ����С��");
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
	
	//ȫ����ԭ�˵��allResumeItem
	private JMenuItem getAllResumeItem()
	{
		if(allResumeItem==null)
		{
			allResumeItem=new JMenuItem();
			allResumeItem.setText("ȫ����ԭ");
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
	 * ��ʼ�����������˵�������˵��bang_zhuMenu��guanyu_Item��bugItem��fangwen_wangzhanItem
	 */
	//�����˵���bang_zhuMenu
	private JMenu getBang_zhuMenu()
	{
		if(bang_zhuMenu==null)
		{
			bang_zhuMenu=new JMenu();
			bang_zhuMenu.setText("����(H)");
			bang_zhuMenu.setMnemonic(KeyEvent.VK_K);
			bang_zhuMenu.add(getGuanyu_Item());
			bang_zhuMenu.add(getBugItem());
			bang_zhuMenu.add(getFangwen_wangzhanItem());	
		}
		return bang_zhuMenu;
	}
	
	//���ڲ˵��guanyu_Item
	private JMenuItem getGuanyu_Item()
	{
		if(guanyu_Item==null)
		{
			guanyu_Item=new JMenuItem();
			guanyu_Item.setText("����");
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
	
	//��ϵ����֧�ֲ˵��bugItem
	private JMenuItem getBugItem()
	{
		if(bugItem==null)
		{
			bugItem=new JMenuItem();
			bugItem.setText("��ϵ����֧��");
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
	
	//���ʼ�����վ�˵��fangwen_wangzhanItem
	private JMenuItem getFangwen_wangzhanItem()
	{
		if(fangwen_wangzhanItem==null)
		{
			fangwen_wangzhanItem=new JMenuItem();
			fangwen_wangzhanItem.setText("���ʼ�����վ");
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
