import java.awt.Color;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;


public class MineButton extends JButton
{
	public MineButton()
	{
		super();
		
		try 
		{
		  Image img = ImageIO.read(getClass().getResource("resources/mine.png"));
		  this.setIcon(new ImageIcon(img));
		} 
		catch (IOException ex) 
		{
			ex.printStackTrace();
		}
		
		//this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		this.setMargin(new Insets(0, 0, 0, 0));
		this.setContentAreaFilled(false);
		this.setFocusPainted(false);
		this.setBorder(new EmptyBorder(0, 0, 0, 0));
	}
	
	public MineButton(String str)
	{
		super(str);
	}
	
	public MineButton(Icon icon)
	{
		super(icon);
	}

}
