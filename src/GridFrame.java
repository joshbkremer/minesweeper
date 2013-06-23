import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;


public class GridFrame extends JFrame
{
	public GridFrame()
	{
		this.setTitle("Mines");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu jmenuFile = new JMenu("File");
		JMenu jmenuHelp = new JMenu("Help");
		
		JMenuItem itemSmall = new JMenuItem("Small");
		JMenuItem itemMedium = new JMenuItem("Medium");
		JMenuItem itemLarge = new JMenuItem("Large");
		JMenuItem itemExit = new JMenuItem("Exit");
		JMenuItem itemAbout = new JMenuItem("About");
		
		jmenuFile.add(itemSmall);
		jmenuFile.add(itemMedium);
		jmenuFile.add(itemLarge);
		jmenuFile.add(itemExit);
		jmenuHelp.add(itemAbout);
		
		menuBar.add(jmenuFile);
		menuBar.add(jmenuHelp);
		
		this.setJMenuBar(menuBar);
		
		Grid grid = new Grid(this);
		
		grid.setVisible(true);
		this.add(grid);
		//this.validate();
		
		this.pack();
		this.setSize(200, 250);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
	public static void main(String... args)
	{

		runMine();

	}
	
	 public static void runMine() 
	 {
     EventQueue.invokeLater(new Runnable() 
     {
         @Override
         public void run() 
         {
             try 
             {
                 UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
             } 
             catch (Exception e)
             {
             }

         		GridFrame frame = new GridFrame();

         }
     });
 }
}
