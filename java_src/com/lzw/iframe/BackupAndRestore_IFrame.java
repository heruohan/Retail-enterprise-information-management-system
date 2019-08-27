package com.lzw.iframe;

import java.awt.event.KeyEvent;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import com.lzw.dao.*;
import java.io.*;
import javax.swing.border.*;


public class BackupAndRestore_IFrame extends JInternalFrame{
	
	//���ݿⱸ����ָ��ڲ�����ĸ��������
	
	private JPanel contentPane=null;    //�ڲ�������������
	private JPanel backupPane=null;    //�������
	private JPanel restorePane=null;    //�ָ����
	
	private JTextField backupField=null;    //�����ı���
	private JTextField restoreField=null;   //�ָ��ı���
	
	private JButton backupButton=null;    //���ݰ�ť
	private JButton restoreButton=null;    //�ָ���ť
	private JButton browseButton=null;    //�����ť
	
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
	
	
	//���캯��
	public BackupAndRestore_IFrame()
	{
		init();
	}
	
	
	//��ʼ�����ݱ�����ָ��ڲ�����
	private void init()
	{
		//�����ڲ����������
		this.setTitle("���ݿⱸ����ָ�");
		this.setMaximizable(true);
		this.setIconifiable(true);
		this.setResizable(true);
		this.setClosable(true);
		
		this.setBounds(50, 50, 600, 320);
		this.setContentPane(this.getContentPanes());
	}
	
	
	//��ʼ��������壺contentPane
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
	
	
	
	//��ʼ��������壺backupPane
	private JPanel getBackupPane()
	{
		if(backupPane==null)
		{
			backupPane=new JPanel();
			TitledBorder border=BorderFactory.createTitledBorder("���ݿⱸ��");
			border.setTitleFont(new Font("Dialog",Font.BOLD, 12));
			//border.setTitleColor(Color.BLUE);
			backupPane.setBorder(border);
			backupPane.setLayout(new GridBagLayout());
			
			
			//�����ı���backupField
			GridBagConstraints constraint1=new GridBagConstraints();
			constraint1.gridx=0;
			constraint1.gridy=0;
			constraint1.fill=GridBagConstraints.HORIZONTAL;
			constraint1.weightx=1.0;
			constraint1.insets=new Insets(0,0,3,0);
			
			
			//���ݰ�ť��backupButton
			GridBagConstraints constraint2=new GridBagConstraints();
			constraint2.gridx=0;
			constraint2.gridy=1;
			constraint2.anchor=GridBagConstraints.EAST;
			
			//������
			backupPane.add(this.getBackupField(), constraint1);
			backupPane.add(this.getBackupButton(), constraint2);
			
		}
		return backupPane;
	}
	
	
	
	//��ʼ���ָ���壺restorePane
	private JPanel getRestorePane()
	{
		if(restorePane==null)
		{
			restorePane=new JPanel();
			TitledBorder border=BorderFactory.createTitledBorder(null,"���ݿ�ָ�");
			border.setTitleFont(new Font("Dialog",Font.BOLD, 12));
			restorePane.setBorder(border);
			
			
			restorePane.setLayout(new GridBagLayout());    //���þֲ�������
			
			//�ָ��ı���restoreField
			GridBagConstraints constraint1=new GridBagConstraints();
			constraint1.gridx=0;
			constraint1.gridy=0;
			constraint1.fill=GridBagConstraints.HORIZONTAL;
			constraint1.gridwidth=2;
			constraint1.insets=new Insets(0,0,4,0);
			
			/*
			 * ����ɻ�
			 * 1���ָ��ı����������У������weightx=1.0������ḳֵ��������Խ�����һ���У�
			 */
			
			
			//�����ť��browseButton
			GridBagConstraints constraint2=new GridBagConstraints();
			constraint2.gridx=0;
			constraint2.gridy=1;
			constraint2.weightx=1.0;
			constraint2.anchor=GridBagConstraints.EAST;
			
			
			//�ָ���ť��restoreButton
			GridBagConstraints constraint3=new GridBagConstraints();
			constraint3.gridx=1;
			constraint3.gridy=1;
			constraint3.insets=new Insets(0,12,0,0);
			
			
			
			//������
			restorePane.add(this.getRestoreField(), constraint1);
			restorePane.add(this.getBrowseButton(), constraint2);
			restorePane.add(this.getRestoreButton(), constraint3);
	
		}
		return restorePane;
	}
	
	
	
	//��ʼ�������ı���backupField
	private JTextField getBackupField()
	{
		if(backupField==null)
		{
			backupField=new JTextField();
			backupField.setEditable(false);
			
			backupField.setFont(new Font("��Բ", Font.PLAIN, 14));    //�����ı��������
			//backupField.setForeground(Color.BLUE);     //�����ı��������ݵ���ɫ
			backupField.setText("���ݿⱸ��·����");
		}
		return backupField;
	}
	
	
	
	//��ʼ���ָ��ı���restoreField
	private JTextField getRestoreField()
	{
		if(restoreField==null)
		{
			restoreField=new JTextField();
			restoreField.setEditable(false);
			
		}
		return restoreField;
	}
	
	
	
	//��ʼ�����ݰ�ť��backupButton
	private JButton getBackupButton()
	{
		if(backupButton==null)
		{
			backupButton=new JButton("����(K)");
			backupButton.setMnemonic(KeyEvent.VK_K);    //������Ƿ�
			
			//��Ӽ����
			backupButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					try
					{
						String sqlpath=Dao.backup();
						backupField.setText("���ݿⱸ��·����" + sqlpath);
						
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
						String message=e1.getMessage();
						System.out.println(123);
						JOptionPane.showMessageDialog(BackupAndRestore_IFrame.this, message);
						return;
					}
					
					JOptionPane.showMessageDialog(BackupAndRestore_IFrame.this, "���ݳɹ�");
				}
					});
			
		}
		return backupButton;
	}
	
	
	
	//��ʼ���ָ���ť��restoreButton
	private JButton getRestoreButton()
	{
		if(restoreButton==null)
		{
			restoreButton=new JButton("�ָ�(R)");
			restoreButton.setMnemonic(KeyEvent.VK_R);
			
			//��Ӽ����
			restoreButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					String path=restoreField.getText();
					
					//�ж�����
					if(path==null || path.isEmpty())
					{
						JOptionPane.showMessageDialog(BackupAndRestore_IFrame.this, "�ָ�·�������ڣ�������·��");
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
					JOptionPane.showMessageDialog(BackupAndRestore_IFrame.this, "�ָ��ɹ�");
				}
					});
		}
		return restoreButton;
	}
	
	
	
	//��ʼ�������ť��browseButton
	private JButton getBrowseButton()
	{
		if(browseButton==null)
		{
			browseButton=new JButton("���(W)......");
			browseButton.setMnemonic(KeyEvent.VK_W);
			
			//��Ӽ����
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
