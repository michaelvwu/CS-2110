import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NoteTaker extends JFrame 
{
	//constants for set up of note taking area
   public static final int WIDTH = 600;
   public static final int HEIGHT = 300;
   public static final int LINES = 12;
   public static final int CHAR_PER_LINE = 45;

	//objects in GUI
	private JTextArea theText;		//area to take notes
    private JScrollPane scrolledText;//scroll bars
  	private JMenuBar mBar;	//horizontal menu bar
   private JPanel textPanel;	//panel to hold scrolling text area 
	private JMenu notesMenu;	//vertical menu with choices for notes
	
	//THESE ITEMS ARE NOT YET USED.
	//YOU WILL BE CREATEING THEM IN THIS LAB
	private JMenu viewMenu;	//vertical menu with choices for views
	
	private JMenu lafMenu;  //vertical menu with look and feel
	private JMenu sbMenu;	//vertical menu with scroll bar option
   	private JScrollPane _scrolledText; //scroll bars
	
	//default notes
	private String note1 = "No Note 1.";
   private String note2 = "No Note 2.";

 	//constructor  
	public NoteTaker()
   {
		//create a closeable JFrame with a specific size
	 	super("Note Taker");		
		setSize(WIDTH, HEIGHT);
      setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      		
		//get contentPane and set layout of the window
      Container contentPane = getContentPane();
      contentPane.setLayout(new BorderLayout());

		//creates the vertical menus
		createNotes();
		createViews();
		
		//creates horizontal menu bar and 
		//adds vertical menus to it
      mBar = new JMenuBar();
      mBar.add(notesMenu);
      mBar.add(viewMenu);
      //ADD THE viewMenu TO THE MENU BAR HERE
      setJMenuBar(mBar);

		//creates a panel to take notes on
      textPanel = new JPanel();
      textPanel.setBackground(Color.blue);
      theText = new JTextArea(LINES, CHAR_PER_LINE);
      theText.setBackground(Color.white);
      //Create a JScrollPane Object here called scrolledText
      JScrollPane _scrolledText = new JScrollPane(theText);
      textPanel.add(_scrolledText);
      contentPane.add(textPanel, BorderLayout.CENTER);
      
      
      
      
   }

	 //creates vertical menu associated with Notes 
	 //menu item on menu bar 
    public void createNotes()
	 {
	 	notesMenu = new JMenu("Notes");
		JMenuItem item;
		
		item = new JMenuItem("Save Note 1");
		item.addActionListener(new MenuListener());
		notesMenu.add(item);

		item = new JMenuItem("Save Note 2");
		item.addActionListener(new MenuListener());
		notesMenu.add(item);

		item = new JMenuItem("Open Note 1");
		item.addActionListener(new MenuListener());
		notesMenu.add(item);

		item = new JMenuItem("Open Note 2");
		item.addActionListener(new MenuListener());
		notesMenu.add(item);

		item = new JMenuItem("Clear");
		item.addActionListener(new MenuListener());
		notesMenu.add(item);

		item = new JMenuItem("Exit");
		item.addActionListener(new MenuListener());
		notesMenu.add(item);
	}
	
	//creates vertical menu associated with Views 
	//menu item on the menu bar
	public void createViews()
	{
		//viewMenu.addSeparator();
		viewMenu = new JMenu("Views");
		
		lafMenu = new JMenu("Look and Feel");
		createLookAndFeel();
		viewMenu.add(lafMenu);
		
		sbMenu = new JMenu("Scroll Bars");
		createScrollBars();
		viewMenu.add(sbMenu);
		
	}

	//creates the look and feel submenu 
	public void createLookAndFeel()
	{
		
		//viewMenu = new JMenu("Look and Feel");
		JMenuItem item;
		
		item = new JMenuItem("Metal");
		item.addActionListener(new MenuListener());
		lafMenu.add(item);
		
		item = new JMenuItem("Motif");
		item.addActionListener(new MenuListener());
		lafMenu.add(item);
		
		item = new JMenuItem("Windows");
		item.addActionListener(new MenuListener());
		lafMenu.add(item);
		
	}

	//creates the scroll bars submenu
	public void createScrollBars()
	{
		JMenuItem item;
		
		item = new JMenuItem("Never");
		item.addActionListener(new MenuListener());
		sbMenu.add(item);
		
		item = new JMenuItem("Always");
		item.addActionListener(new MenuListener());
		sbMenu.add(item);
		
		item = new JMenuItem("As Needed");
		item.addActionListener(new MenuListener());
		sbMenu.add(item);
	}

	private class MenuListener implements ActionListener
	{
	
 	   public void actionPerformed(ActionEvent e)
  		{
      	String actionCommand = e.getActionCommand();
       	if (actionCommand.equals("Save Note 1"))
            note1 = theText.getText();
        	else if (actionCommand.equals("Save Note 2"))
            note2 = theText.getText();
        	else if (actionCommand.equals("Clear"))
            theText.setText("");
        	else if (actionCommand.equals("Open Note 1"))
            theText.setText(note1);
        	else if (actionCommand.equals("Open Note 2"))
            theText.setText(note2);
        	else if (actionCommand.equals("Exit"))
            System.exit(0);
        	//ADD 6 BRANCHES TO THE ELSE-IF STRUCTURE HERE
        	else
            theText.setText("Error in memo interface");
    	}
	}

  	public static void main(String[] args)
  	{
   	NoteTaker gui = new NoteTaker();
    gui.setVisible(true);
  	}
}
