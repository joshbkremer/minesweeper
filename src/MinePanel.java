import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MinePanel extends JPanel
{
	private int pos_;
	
	final static String MINEPANEL = "Card with Mine";
	final static String BOMBPANEL = "Card with Bomb";
	
	public MinePanel(int pos) throws Exception
	{
		pos_ = pos;
		
		JPanel mineCard = new JPanel();
		mineCard.setLayout(new BorderLayout());
		JPanel bombCard = new JPanel();
		bombCard.setLayout(new BorderLayout());
		
		this.setLayout(new CardLayout());
		this.add(mineCard, MINEPANEL);
		this.add(bombCard, BOMBPANEL);
		
		BombButton orgbb = null;
		if(Grid.bombSet.contains(new Integer(pos)))
		{
		  Image img = ImageIO.read(getClass().getResource("resources/bomb.png"));
			orgbb = new BombButton(img, true);
		}
		else
		{
			
			int nearBombs =0;
			
			if(Grid.bombSet.contains(new Integer(pos-1))  && (pos % 10 !=0))
				nearBombs++;
			
			if(Grid.bombSet.contains(new Integer(pos+1))  && (pos % 10 != 9))
				nearBombs++;
			
			if(Grid.bombSet.contains(new Integer(pos-9))  && (pos % 10 != 9))
				nearBombs++;
			
			if(Grid.bombSet.contains(new Integer(pos-10)))
				nearBombs++;
			
			if(Grid.bombSet.contains(new Integer(pos-11)) && (pos % 10 !=0))
				nearBombs++;
			
			if(Grid.bombSet.contains(new Integer(pos+9))  && (pos % 10 !=0))
				nearBombs++;
			
			if(Grid.bombSet.contains(new Integer(pos+10)))
				nearBombs++;
			
			if(Grid.bombSet.contains(new Integer(pos+11)) && (pos % 10 != 9))
				nearBombs++;
			
			switch(nearBombs)
			{
				case 0:
				{
				  Image img = ImageIO.read(getClass().getResource("resources/mine0.png"));
				  orgbb = new BombButton(img, false);
					break;
				}
				case 1:
				{
				  Image img = ImageIO.read(getClass().getResource("resources/mine1.png"));
				  orgbb = new BombButton(img, false);
					break;
				}
				case 2:
				{
					Image img = ImageIO.read(getClass().getResource("resources/mine2.png"));
				  orgbb = new BombButton(img, false);
					break;
				}
				case 3:
				{
					Image img = ImageIO.read(getClass().getResource("resources/mine3.png"));
				  orgbb = new BombButton(img, false);
					break;
				}
				case 4:
				{
					Image img = ImageIO.read(getClass().getResource("resources/mine4.png"));
				  orgbb = new BombButton(img, false);
					break;
				}
				case 5:
				{
					Image img = ImageIO.read(getClass().getResource("resources/mine5.png"));
				  orgbb = new BombButton(img, false);
					break;
				}
				case 6:
				{
					Image img = ImageIO.read(getClass().getResource("resources/mine6.png"));
				  orgbb = new BombButton(img, false);
					break;
				}
				case 7:
				{
					Image img = ImageIO.read(getClass().getResource("resources/mine7.png"));
				  orgbb = new BombButton(img, false);
					break;
				}
				case 8:
				{
					Image img = ImageIO.read(getClass().getResource("resources/mine8.png"));
				  orgbb = new BombButton(img, false);
					break;
				}
			}
		}
		
			
		final BombButton bb = orgbb;
		bombCard.add(bb);
		
		
		final MinePanel mp = this;
		final MineButton mb = new MineButton();
		mb.addMouseListener(new MouseListener()
		{
			@Override
			public void mouseClicked(MouseEvent arg0){}

			@Override
			public void mouseEntered(MouseEvent arg0){}

			@Override
			public void mouseExited(MouseEvent arg0){}
			
			@Override
			public void mouseReleased(MouseEvent arg0){}
			
			@Override
			public void mousePressed(MouseEvent arg0)
			{
				CardLayout c1 = (CardLayout)(mp.getLayout());
				c1.show(mp, BOMBPANEL);
				if(bb.getIsBomb())
				{
					JOptionPane.showMessageDialog(mp,
					    "BOOOOOOOOOOMMMM!",
					    "You Lost!",
					    JOptionPane.ERROR_MESSAGE);
					
					((Grid)mp.getParent()).disp();
					
					GridFrame.runMine();
				}
			}

		});
		
		mineCard.add(mb);
		mineCard.setBorder(BorderFactory.createEmptyBorder());
		
		CardLayout c1 = (CardLayout)(this.getLayout());
		c1.show(this, MINEPANEL);
	
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setVisible(true);
		
		//this.setBackground(new Color(185, 122, 87));
	}
}
