import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;

/* Michael WU
 * mvw5mf
 * Homework 5
 */

public class BusinessExpenses extends JFrame
{
	private JPanel panel;// A panel to hold everything (you need this at least)
	private JLabel dayLabel; // a label for number of days on travel
	private JLabel airfare; // a label for airfare cost
	private JLabel carRental;// a label for car rental fees
	private JLabel milesDriven; // a label for miles driven with personal car
	private JLabel parkingFees;// a label for parking fees
	private JLabel taxiCharge;// a label for taxi costs
	private JLabel registration; // a label for conference registration
	private JLabel lodging; // a label for hotel fees
	
	private JTextField dayField; // an input field for dayLabel
	private JTextField airField; // an input field for airfare
	private JTextField carField;// an input field for carRental
	private JTextField mileField;// an input field for milesDriven
	private JTextField parkingField;// an input field for parkingFees
	private JTextField taxiField;// an input field for taxiCharge
	private JTextField registerField;// an input field for registration
	private JTextField hotelField;// an input field for lodging 
	
	private JButton calcButton; // button to calculate all the costs
	
	//sets the size for the input window
	private final int WINDOW_WIDTH = 650;
	private final int WINDOW_HEIGHT = 400;
	
	/** method creates the window for the input panel
	 *
	 */
	public BusinessExpenses()
	{
		setTitle("Travel Expense Calculator");
		
		// Specify what happens when the close button is clicked.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
		// Build the panel that contains the other components.
		buildPanel();
      
		// Add the panel to the content pane.
		add(panel);
	
		
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	    setVisible(true);
	}
	
	/** Method for all the fields necessary for the user to input
	 * 
	 */
	private void buildPanel()
	{
	    // -- User prompts/directions for the respective input fields 
		dayLabel = new JLabel("Number of days on the trip: ");
		airfare = new JLabel("Amount of airfare, if any: "); 
		carRental= new JLabel("Amount of car rental fees per day, if any:");
		milesDriven=new JLabel("Number of miles drive, if a private vehicle was used: "); 
		parkingFees=new JLabel("Amount of parking fees per day, if any: ");
		taxiCharge=new JLabel("Amount of taxi charges per day, if any: ");
		registration=new JLabel("Conference or seminar registration fees, if any: "); 
		lodging=new JLabel("Lodging charges, per night: "); 
		JLabel empty = new JLabel ("");
		JLabel empty2 = new JLabel ("");
		JLabel instruction = new JLabel ("If there is no cost above, then place a 0 (zero) in box.");
		
	  
		// -- Size of the input fields 
		dayField = new JTextField(100);
		airField = new JTextField(100);
		carField = new JTextField(10);
		mileField = new JTextField(10);
		parkingField =new JTextField(10);
		taxiField = new JTextField(10);
		registerField = new JTextField(10);
		hotelField = new JTextField(10);
	  
		// -- Create a component to click.
		calcButton = new JButton("Calculate");
	  
		// -- Action listener button, does all the calculations for the math when the button is pushed
		calcButton.addActionListener(new CalcButtonListener());
	  
		// Create a panel in an easy to read/navigate manner
		panel = new JPanel(new GridLayout(0,2, 10, 5));
		//panel2 = new JPanel(new GridLayout(0,1));
	  
		// -- Adding all the components to the panel in this order (order is important) 
	    panel.add(dayLabel);
	    panel.add(dayField);
	    panel.add(airfare);
	    panel.add(airField);
	    panel.add(carRental);
	    panel.add(carField);
	    panel.add(milesDriven);
	    panel.add(mileField);
	    panel.add(parkingFees);
	    panel.add(parkingField);
	    panel.add(taxiCharge);
	    panel.add(taxiField);
	    panel.add(registration);
	    panel.add(registerField);
	    panel.add(lodging);
	    panel.add(hotelField);
		panel.add(empty);
		panel.add(instruction);
		panel.add(empty2);
	    panel.add(calcButton);
	}
	
	/**
	 * Method for all the actions and calculations done when the calculate button is pressed.
	 *
	 */
	private class CalcButtonListener implements ActionListener
	{
		/**
         	actionPerformed method
         	@param e An ActionEvent object.
		 */
      
		public void actionPerformed(ActionEvent e)
		{
			double totalExpenses;		// variable to hold the total expenses amount
			double allowableExpense;	//variable to hold allowable expenses from the company
			double excess;	//amount the business person has to pay
			double saved;	//amount the business person saves from the company
			double rentCar;	//variable to hold rental car fees
			double parkingFees;		// variable to hold the parking fee amount
			double allowParking;	//variable to hold how much the company will pay in respect to parking fees
			double taxiCharge;		// variable to hold the taxi charges amount
			double allowTaxi;	//variable to hold how much the company will pay in respect to taxi charges
			double lodgingCharge;		// variable to hold the lodging charges amount
			double allowLodging;//variable to hold how much the company will pay in respect to hotel costs
			double privateVehicle;  	// variable to hold the private vehicle charge amount
			double repayCar;	// variable to hold reimbursement value for using private car
			double dayCount; 	//variable to hold length of travel days
			double airCost; // variable to hold the airfare
			double registrationCost; //variable to hold the cost of the conference or seminar
            
            
			// Create a DecimalFormat object to format output.
			DecimalFormat dollar = new DecimalFormat("#,##0.00");
			// To use:
			// if you want to display the countyTaxAmount in the dollar format use:
			// dollar.format(countyTaxAmount)
         
			
			// -- Calculate the parking fees
			parkingFees = Double.parseDouble(parkingField.getText()) ;
         
			// -- Calculate the taxi charges
			taxiCharge = Double.parseDouble(taxiField.getText()) ;
			
			// -- Calculate lodging charges
			lodgingCharge = Double.parseDouble(hotelField.getText()) ;
			
			// -- Calculate the cost for personal vehicles
			privateVehicle = Double.parseDouble(mileField.getText()) ;
			
			if (Double.parseDouble(dayField.getText()) < 0)
			{
				dayCount = 0; 
			}
			else
			{
				dayCount = Math.floor(Double.parseDouble(dayField.getText()));
			}
			
			if (Double.parseDouble(airField.getText()) < 0)
			{
				airCost = 0;
			}
			else
				airCost = Double.parseDouble(airField.getText());
			
			if (Double.parseDouble(carField.getText()) < 0)
			{
				rentCar = 0;
			}
			else
				rentCar = Double.parseDouble(carField.getText());
			
			if (Double.parseDouble(registerField.getText()) < 0)
			{
				registrationCost = 0;
			}
			else
				registrationCost =Double.parseDouble(registerField.getText());
			
			// starting values
			excess = 0.0;
			saved = 0.0;
         
			// -- Calculate the total expenses.
			totalExpenses = dayCount*(parkingFees + lodgingCharge + taxiCharge)
					+ airCost + registrationCost + rentCar;
         
			// -- Calculate total allowable expenses that the company will reimbursed 
			if (parkingFees<= 10.0 && parkingFees > 0.0)
			{
				allowParking = 10;
				saved += 10.0 - allowParking;
			}
			else  if (parkingFees > 10)
			{
				allowParking = 10; 
				excess += parkingFees - 10.0;
			}
			else 
				allowParking =0.0;
			
			if (taxiCharge <= 20.0 && taxiCharge >0)
			{
				allowTaxi = 20.0;
				saved += 20.0 - allowTaxi;
			}
			else if(taxiCharge >20)
			{
				allowTaxi = 20.0;
				excess += taxiCharge- 20.0;
			}
			else
				allowTaxi = 0.0;
			
			if (lodgingCharge <= 95.0 && lodgingCharge >0)
			{
				allowLodging = 95.00;
				saved += 95 - allowLodging;
			}
			else if(lodgingCharge >95)
			{
				allowLodging = 95.00;
				excess += lodgingCharge - 95.0;
			}
			else 
				allowLodging = 0.0;
			
			if (privateVehicle >0)
			{
				repayCar = privateVehicle * 0.27;
				
			}
			else 
				repayCar = 0.0;
			
			//total allowable expenses
			if (dayCount ==0)
			{
				excess = 0; 
				allowableExpense = 0;
			}
			else
			{
				allowableExpense = dayCount*(allowParking + allowLodging + allowTaxi)
						+ airCost + registrationCost + rentCar + repayCar + dayCount*37;
			}
					
				
			//calculates the savings and excess fees
			if (((totalExpenses)- allowableExpense) > 0)
			{
				saved = 0.0;
			}
			else 
			{
				saved += allowableExpense - totalExpenses - excess - dayCount *37;
				if (saved <= 0)
				{
					saved = 0.0; 
				}
			}
			
					
			// -- Display the results.
			JOptionPane.showMessageDialog(null, "Total Expenditures: $" + dollar.format(totalExpenses) +
					"\nTotal Allowable Expenses: $" + dollar.format(allowableExpense) + 
					"\nExcess Expenditures that need to be paid: $" + dollar.format(excess)
					+ "\nAmount saved: $" + dollar.format(saved));
		}
	}
	
	//instantiates the window
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		BusinessExpenses TEC = new BusinessExpenses();
	}

}
