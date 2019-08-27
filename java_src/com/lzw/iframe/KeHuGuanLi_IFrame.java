package com.lzw.iframe;

import java.awt.Color;

import javax.swing.*;
import com.lzw.iframe.KeHuGuanLi.*;
import javax.swing.event.*;


public class KeHuGuanLi_IFrame extends JInternalFrame{
	
	private JTabbedPane tabPane=null;    //�ͻ�����ѡ����
	
	/*
	public static void main(String[] args)
	{
		JFrame t=new JFrame();
		t.setSize(800, 600);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane deskpane=new JDesktopPane();
		KeHuGuanLi_IFrame inFrame=new KeHuGuanLi_IFrame();
		
		deskpane.add(inFrame);
		//inFrame.setVisible(true);
		
		t.setContentPane(deskpane);
		t.setVisible(true);
	}
	*/
	
	//���캯��
	public KeHuGuanLi_IFrame()
	{
		init();
	}
	
	
	//��ʼ���ͻ������ڲ�����
	private void init()
	{
		//�����ڲ����������
		this.setTitle("�ͻ�����");
		this.setMaximizable(true);
		this.setIconifiable(true);
		this.setClosable(true);
		this.setBounds(50, 50, 600, 400);
		
		//���ѡ����
		this.getContentPane().add(this.getTabPane());
		
		this.setVisible(true);
		
	}
	
	
	//��ʼ���ͻ�����ѡ���壺tabPane
	private JTabbedPane getTabPane()
	{
		if(tabPane==null)
		{
			tabPane=new JTabbedPane();
			//tabPane.setBorder(BorderFactory.createLineBorder(Color.RED));
			
			//�ͻ�������
			KeHuTianJiaPanel khtjPanel=new KeHuTianJiaPanel();
			
			//�ͻ���Ϣɾ�����޸����
			KeHuXiuGaiPanel khxgPanel=new KeHuXiuGaiPanel();
			//
			tabPane.addTab("�ͻ���Ϣ���", null, khtjPanel, "��Ϣ���");
			tabPane.addTab("�ͻ���Ϣɾ�����޸�", null, khxgPanel, "��Ϣ�޸���ɾ��");
			
			//��Ӽ����
			tabPane.addChangeListener(new ChangeListener()
					{
				public void stateChanged(ChangeEvent e)
				{
					if(((JTabbedPane)e.getSource()).getSelectedIndex()==1)
					{
						System.out.println(123);
						khxgPanel.initKhComboBox();
					}
				}
					});
		}
		return tabPane;
	}

}
