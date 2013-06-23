import java.awt.Color;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;


public class BombButton extends JButton
{
	private boolean isBomb = false;
	public BombButton(Image img, boolean bomb)
	{
		super();
		this.setIcon(new ImageIcon(img));
		isBomb = bomb;
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		this.setMargin(new Insets(0, 0, 0, 0));
		this.setContentAreaFilled(false);
		this.setFocusPainted(false);
		//this.setBorder(new EmptyBorder(0, 0, 0, 0));
	}
	
	public BombButton(String str)
	{
		super(str);
	}
	
	public boolean getIsBomb()
	{
		return isBomb;
	}
}
