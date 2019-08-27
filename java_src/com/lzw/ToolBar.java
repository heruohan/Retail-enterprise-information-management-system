package com.lzw;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

import java.awt.event.*;
import java.awt.*;

public class ToolBar extends JToolBar{
	
	private MenuBar menuBar;    //�����˵���������������Ĳ˵���
	
	//�������캯��
	private ToolBar()
	{
		
	}
	
	public ToolBar(MenuBar menuBar)
	{
		this.menuBar=menuBar;
		init();
	}
	
	
	//��ʼ��������
	private void init()
	{
		this.setSize(new Dimension(600,24));
		this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));    //���ù������ı߿�
		//�����ذ�ť
		//��������ť
		this.add(createToolButton(menuBar.getJinhuoItem()));
		//���۵���ť
		this.add(createToolButton(menuBar.getXiaoshou_danItem()));
		//����̵㰴ť
		this.add(createToolButton(menuBar.getKucun_pandianItem()));
		//�۸������ť
		this.add(createToolButton(menuBar.getJiage_tiaozhengItem()));
		//��Ʒ��ѯ��ť
		this.add(createToolButton(menuBar.getShangpin_chaxunItem()));
		//��Ʒ���Ϲ���ť
		this.add(createToolButton(menuBar.getShangpin_guanliItem()));
		//�ͻ����Ϲ���ť
		this.add(createToolButton(menuBar.getKehu_guanliItem()));
		//��Ӧ�����Ϲ���ť
		this.add(createToolButton(menuBar.getGys_guanliItem()));
		//�˳���ť
		this.add(createToolButton(menuBar.getExitItem()));
		
	}
	
	//�����������ϵĳ��ð�ť��
	private JButton createToolButton(final JMenuItem item)
	{
		JButton button=new JButton();    //��������ť
		button.setText(item.getText());    //���ð�ť���ı�����
		button.setToolTipText(item.getText());
		button.setIcon(item.getIcon());    //���ð�ťͼ��
		button.setFocusable(false);
		button.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e)
			{
				item.doClick();
			}
				});
		return button;
	}
	
	
	//���ò˵���
	public void setMenuBar(MenuBar menuBar)
	{
		this.menuBar=menuBar;
	}
}
