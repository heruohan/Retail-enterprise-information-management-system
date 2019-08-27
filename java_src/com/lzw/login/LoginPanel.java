package com.lzw.login;

import java.awt.*;
import java.net.URL;
import javax.swing.*;

public class LoginPanel extends JPanel{    //µÇÂ½Ãæ°å
	public int width,height;    //Ãæ°åµÄ¿íºÍ¸ß
	private Image img;    //µÇÂ½Ãæ°åµÄ±³¾°Í¼Æ¬
	
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
