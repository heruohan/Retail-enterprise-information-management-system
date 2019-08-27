package com.lzw.login;

import java.awt.*;
import java.net.URL;
import javax.swing.*;

public class LoginPanel extends JPanel{    //��½���
	public int width,height;    //���Ŀ�͸�
	private Image img;    //��½���ı���ͼƬ
	
	public LoginPanel()
	{
		super();
		URL url=this.getClass().getResource("/res/login.jpg");
		img=new ImageIcon(url).getImage();
	}
	
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(img, 0, 0, this);
	}

}
