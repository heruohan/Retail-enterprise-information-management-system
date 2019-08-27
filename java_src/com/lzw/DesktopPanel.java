package com.lzw;

import java.awt.*;
import javax.swing.*;
import java.net.*;

public class DesktopPanel extends JDesktopPane{
	
	private static final long serialVersionUID = 1L;
	private final Image backImage;     //×ÀÃæÃæ°å±³¾°Í¼Æ¬
	
	public DesktopPanel()
	{
		URL url=DesktopPanel.class.getResource("/res/back.jpg");
		backImage=new ImageIcon(url).getImage();
	}
	
	protected void paintComponent(Graphics g)
	{
		int width=this.getWidth();
		int height=this.getHeight();
		g.drawImage(backImage, 0, 0, width, height, this);
	}
}
