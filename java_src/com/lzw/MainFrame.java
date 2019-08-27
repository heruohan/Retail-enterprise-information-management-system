package com.lzw;

import java.awt.Cursor;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import com.lzw.login.*;
import java.util.*;


public class MainFrame extends JFrame{    //�������ⴰ�ڣ�����װ 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MenuBar frameMenuBar;    //�˵�������
	private JPanel frameContentPane;    //�������
	
	/*
	 * ��������ϵ����
	 */

	private ToolBar toolBar;    //������
	//�����ڲ�������������
	private DesktopPanel desktopPanel;
	//״̬��壨�ں�ѡ������״̬������Ա����ǰ���ڡ���˾���Ƶ���Ϣ��
	private JPanel statePanel;
	private JLabel stateLabel;    //״̬��ǩ
	private static JLabel czyLabel;    //����Ա��ǩ
	private JLabel nowDateLabel;    //��ǰ���ڱ�ǩ
	private JLabel nameLabel;    //��˾���Ʊ�ǩ
	
	private JSeparator separator2;    //�����ķָ���
	private JSeparator separator3;    //
	
	
	//�������е����
	public static void main(String[] args)
	{
		SplashScreen splashScreen=SplashScreen.getSplashScreen();    //����������Ļ����
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
	
	//���캯��
	public MainFrame()
	{
		init();    //��ʼ��������
	}
	
	
	//��ʼ�����崰��
	private void init()
	{
		this.setSize(800,600);    //����������Ŀ��
		this.setJMenuBar(this.getFrameMenuBar());    //������������Ӳ˵���
		this.setContentPane(this.getFrameContentPane());    //���������������������
		this.setTitle("��ҵ����ϵͳ");
		//this.setVisible(true);
		
	}
	
	//��ʼ��������:toolBar
	private ToolBar getToolBar()
	{
		if(toolBar==null)
		{
			toolBar=new ToolBar(this.getFrameMenuBar());
			toolBar.setCursor(new Cursor(Cursor.HAND_CURSOR));    //���ù����״
		}
		return toolBar;
	}
	
	//��ʼ���˵�������frameMenuBar
	private MenuBar getFrameMenuBar()
	{
		if(frameMenuBar==null)
		{
			frameMenuBar=new MenuBar(this.getDesktopPanel(),this.getStateLabel());    //�����˵�������
		}
		return frameMenuBar;
	}
	
	
	//��ʼ���������:desktopPanel
	private DesktopPanel getDesktopPanel()
	{
		if(desktopPanel==null)
		{
			desktopPanel=new DesktopPanel();    //�����������
		}
		return desktopPanel;
	}
	
	//��ʼ��״̬��壺statePanel
	private JPanel getStatePanel()
	{
		if(statePanel==null)
		{
			/*
			 * ���������鲼�ֹ����������Ϸָ�����һ����7�����
			 */
			//״̬��ǩ�����stateLabel
			GridBagConstraints constraints_0=new GridBagConstraints();
			constraints_0.gridx=0;    //���ô����������
			constraints_0.gridy=0;
			constraints_0.fill=GridBagConstraints.HORIZONTAL;    //��䷽ʽ
			constraints_0.weightx=1.0;    //������չ��Ȩ��
			
			//�ָ���1���
			GridBagConstraints constraints_1=new GridBagConstraints();
			constraints_1.gridx=2;
			constraints_1.gridy=0;
			constraints_1.fill=GridBagConstraints.VERTICAL;
			constraints_1.insets=new Insets(0,5,0,5);
			
			//����Ա�����czyLabel
			GridBagConstraints constraints_2=new GridBagConstraints();
			constraints_2.gridx=3;
			constraints_2.gridy=0;
			
			//�ָ���2���
			GridBagConstraints constraints_3=new GridBagConstraints();
			constraints_3.gridx=4;
			constraints_3.gridy=0;
			constraints_3.fill=GridBagConstraints.VERTICAL;
			constraints_3.insets=new Insets(0,5,0,5);
			constraints_3.weighty=1.0;
			
			//���ڱ�ǩ�����nowDateLabel
			nowDateLabel=new JLabel();    //������ǰ���ڱ�ǩ
			Date date=new Date();
			String time=String.format("%tF", date);
			nowDateLabel.setText(time);    //���õ�ǰ���ڱ�ǩ���ı�����
			
			GridBagConstraints constraints_4=new GridBagConstraints();
			constraints_4.gridx=5;
			constraints_4.gridy=0;
			constraints_4.insets=new Insets(0,5,0,5);
			
			//�ָ���3���
			GridBagConstraints constraints_5=new GridBagConstraints();
			constraints_5.gridx=6;
			constraints_5.gridy=0;
			constraints_5.fill=GridBagConstraints.VERTICAL;
			constraints_5.insets=new Insets(0,5,0,5);
			
			//��˾���������nameLabel
			GridBagConstraints constraints_6=new GridBagConstraints();
			constraints_6.gridx=7;
			constraints_6.gridy=0;
			
			nameLabel=new JLabel("XXX���޹�˾");
			
			/*
			 * ��ʼ��״̬��壺statePanel
			 */
			statePanel=new JPanel();
			statePanel.setLayout(new GridBagLayout());    //��״̬���Ĳ��ֹ���������Ϊ�����鲼�ֹ�����
			statePanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
			//��������
			//���״̬��ǩ
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
	
	//��ȡ״̬��ǩ�ķ���:stateLabel
	private JLabel getStateLabel()
	{
		if(stateLabel==null)
		{
			stateLabel=new JLabel();
			stateLabel.setText("��ǰû��ѡ������");
		}
		return stateLabel;
	}
	
	
	//��ȡ����Ա��ǩ�ķ�����czyLabel
	public static JLabel getCzyLabel()
	{
		if(czyLabel==null)
		{
			czyLabel=new JLabel();
			czyLabel.setText("");
		}
		return czyLabel;
	}
	
	
	//����3���ָ�������Ļ�ȡ����
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
	
	//��ʼ��������壺frameContentPane
	private JPanel getFrameContentPane()
	{
		//��ӹ�������������壬״̬���
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
