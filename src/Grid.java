import java.awt.Color;
import java.awt.GridLayout;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;


public class Grid extends JPanel
{
	private static int NUM_WIDTH = 10;
	private static int NUM_HEIGHT = 10;
	
	public static Set<Integer> bombSet = new HashSet<Integer>();
	private JFrame frame_ = null;
	
	public void disp()
	{
		frame_.dispose();
	}
	
	public Grid(JFrame frame)
	{
		frame_ = frame;
		generateBombs();
		GridLayout gl = new GridLayout(NUM_WIDTH, NUM_HEIGHT, 0, 0);
		this.setLayout(gl);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		this.setBackground(new Color(185, 122, 87));
		
		for(int ww =0; ww < NUM_WIDTH; ww++)
		{
			for(int hh =0; hh < NUM_HEIGHT; hh++)
			{
				MinePanel mp = null;
				try
				{
					mp = new MinePanel(ww*10 + hh);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
				this.add(mp);
			}
		}
	}
	
	private void generateBombs()
	{
		Random r = new Random();
		while (bombSet.size() < 10) 
		{
	    bombSet.add(r.nextInt(100));
		}
		
		System.out.println(bombSet);
	}
	
}
