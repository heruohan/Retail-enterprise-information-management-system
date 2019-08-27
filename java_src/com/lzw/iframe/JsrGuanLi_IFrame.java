package com.lzw.iframe;

import javax.swing.*;
import com.lzw.iframe.JsrGuanLi.*;
import javax.swing.event.*;


public class JsrGuanLi_IFrame extends JInternalFrame{
	
	private JTabbedPane tabPane=null;    //ѡ����
	
	
	/*
	public static void main(String[] args)
	{
		JFrame t=new JFrame();
		t.setSize(800, 600);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane deskpane=new JDesktopPane();
		JsrGuanLi_IFrame inFrame=new JsrGuanLi_IFrame();
		
		deskpane.add(inFrame);
		inFrame.setVisible(true);
		
		t.setContentPane(deskpane);
		t.setVisible(true);
	}
	*/
	
	
	//���캯��
	public JsrGuanLi_IFrame()
	{
		init();
	}
	
	
	//��ʼ���������ڲ�����
	private void init()
	{
		this.setTitle("�����˹���");
		this.setBounds(50, 50, 600, 350);
		
		this.setClosable(true);
		this.setMaximizable(true);
		this.setIconifiable(true);
		
		this.getContentPane().add(this.getTabPane());
		
	}
	
	
	//��ʼ��ѡ����
	private JTabbedPane getTabPane()
	{
		if(tabPane==null)
		{
			tabPane=new JTabbedPane();
			
			//������
			JsrTianJiaPanel jsrtjPanel=new JsrTianJiaPanel();
			
			//�������
			JsrSheZhiPanel jsrszPanel=new JsrSheZhiPanel();
			
			
			tabPane.addTab("��������Ϣ���", null, jsrtjPanel, "��Ϣ���");
			tabPane.addTab("��������Ϣ����", null, jsrszPanel, "��Ϣ����");
			
			//��Ӽ����
			tabPane.addChangeListener(new ChangeListener()
					{
				public void stateChanged(ChangeEvent e)
				{
					if(((JTabbedPane)e.getSource()).getSelectedIndex()==1)
					{
						jsrszPanel.updateTable();
					}
				}
					});
		}
		return tabPane;
	}

}
