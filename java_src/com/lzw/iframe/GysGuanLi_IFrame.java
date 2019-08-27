package com.lzw.iframe;

import javax.swing.*;
import com.lzw.iframe.gysGuanLi.*;
import javax.swing.event.*;


public class GysGuanLi_IFrame extends JInternalFrame{
	
	private JTabbedPane tabPane=null;    //��Ӧ��ѡ����
	
	
	
	public static void main(String[] args)
	{
		JFrame t=new JFrame();
		t.setSize(800, 600);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane deskpane=new JDesktopPane();
		GysGuanLi_IFrame inFrame=new GysGuanLi_IFrame();
		
		deskpane.add(inFrame);
		inFrame.setVisible(true);
		
		t.setContentPane(deskpane);
		t.setVisible(true);
	}
	//���캯��
	public GysGuanLi_IFrame()
	{
		init();
	}
	
	
	//��ʼ����Ӧ���ڲ�����
	private void init()
	{
		this.setTitle("��Ӧ�̹���");
		this.setClosable(true);
		this.setIconifiable(true);
		this.setBounds(50, 50, 600, 400);
		
		//������
		this.getContentPane().add(this.getTabPane());
		
		
		
	}
	
	
	//��ʼ����Ӧ��ѡ����
	private JTabbedPane getTabPane()
	{
		if(tabPane==null)
		{
			tabPane=new JTabbedPane();
			
			//��Ӧ��������
			GysTianJiaPanel gystjPane=new GysTianJiaPanel();
			
			//��Ӧ��ɾ�����޸����
			GysXiuGaiPanel gysxgPane=new GysXiuGaiPanel();
			
			//��ӽ�ѡ����
			tabPane.addTab("��Ӧ����Ϣ���", null, gystjPane, "��Ϣ���");
			tabPane.addTab("��Ӧ����Ϣɾ�����޸�", null, gysxgPane, "��Ϣɾ�����޸�");
			
			//��Ӽ����
			tabPane.addChangeListener(new ChangeListener()
					{
				public void stateChanged(ChangeEvent e)
				{
					if(((JTabbedPane)e.getSource()).getSelectedIndex()==1)
					{
						System.out.println(123);
						gysxgPane.updateComboBox();
					}
				}
					});
			
		}
		return tabPane;
	}

}
