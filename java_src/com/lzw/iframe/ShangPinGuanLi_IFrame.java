package com.lzw.iframe;

import javax.swing.*;
import com.lzw.iframe.ShangPinGuanLi.*;
import javax.swing.event.*;


public class ShangPinGuanLi_IFrame extends JInternalFrame{
	
	private JTabbedPane tabPane=null;    //ѡ����
	private ShangPinTianJiaPanel sptjPane=null;    //��Ʒ������
	
	
	public static void main(String[] args)
	{
		JFrame t=new JFrame();
		t.setSize(800, 600);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane deskpane=new JDesktopPane();
		ShangPinGuanLi_IFrame inFrame=new ShangPinGuanLi_IFrame();
		
		deskpane.add(inFrame);
		inFrame.setVisible(true);
		
		t.setContentPane(deskpane);
		t.setVisible(true);
	}
	
	
	//��Ʒ�����ڲ�����Ĺ��캯��
	public ShangPinGuanLi_IFrame()
	{
		init();
	}
	
	
	//��ʼ���ڲ�����
	private void init()
	{
		//�ڲ����������
		this.setTitle("��Ʒ����");
		this.setClosable(true);
		this.setIconifiable(true);
		this.setBounds(50, 50, 600, 400);
		
		this.getContentPane().add(this.getTabPane());
		
		this.addInternalFrameListener(new InternalFrameAdapter()
				{
			public void internalFrameActivated(InternalFrameEvent e)
			{
				sptjPane.updateGysComboBox();
				System.out.println(123);
			}
				});
		
		
		
	}
	
	
	
	//��ʼ��ѡ���壺tabPane
	private JTabbedPane getTabPane()
	{
		if(tabPane==null)
		{
			tabPane=new JTabbedPane();
			
			
			//��Ʒ������
			sptjPane=new ShangPinTianJiaPanel();
			//sptjPane.setBounds(50, 50, 300, 300);
			
			
			//��Ʒ��Ϣ�޸���ɾ�����
			ShangPinXiuGaiPanel spxgPane=new ShangPinXiuGaiPanel();
			
			//��ѡ����������
			tabPane.addTab("��Ʒ��Ϣ���", null, sptjPane, "��Ϣ���");
			tabPane.addTab("��Ʒ��Ϣ�޸���ɾ��", null, spxgPane, "��Ϣ�޸���ɾ��");
			
			//��Ӽ����
			tabPane.addChangeListener(new ChangeListener()
					{
				public void stateChanged(ChangeEvent e)
				{
					if(((JTabbedPane)e.getSource()).getSelectedIndex()==1)
					{
						System.out.println("ok");
						spxgPane.updateSpComboBox();
						spxgPane.updateGysComboBox();
					}
					
				}
					});
		}
		return tabPane;
	}
	
	
	

}
