package proyecto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import entidades.Plane;
import entidades.Boat;
import entidades.Person;
import entidades.Vehicule;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class PersonsRegistry {

	private JFrame frmProyectoRedmia;
	private JTextField textName;
	private JTextField textLName;
	private JTextField textChildren;
	private JTextField textVName;
	private JTextField textColor;
	private JTextField text1;
	private JTextField text2;
	ArrayList<Person> arrPersons = new ArrayList<>();
	ArrayList<Vehicule> arrVolatilVehicules = new ArrayList<>();
	ArrayList<Vehicule> totalVehicules = new ArrayList<>();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonsRegistry window = new PersonsRegistry();
					window.frmProyectoRedmia.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PersonsRegistry() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//Color theme election feature

		frmProyectoRedmia = new JFrame();
		frmProyectoRedmia.getContentPane().setBackground(new Color(204, 244, 255));
		frmProyectoRedmia.setTitle("PROYECTO REDMI 9A");
		frmProyectoRedmia.setBounds(100, 100, 989, 698);
		frmProyectoRedmia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProyectoRedmia.getContentPane().setLayout(null);
		
		
		
		JComboBox comboTheme = new JComboBox();
		comboTheme.setFont(new Font("Dialog", Font.BOLD, 11));
		comboTheme.setBackground(UIManager.getColor("FormattedTextField.background"));
		comboTheme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String selectedColor = comboTheme.getSelectedItem().toString();
				if(selectedColor.equals("Sky blue")) {
					frmProyectoRedmia.getContentPane().setBackground(new Color(204, 244, 255));					
				} else if(selectedColor.equals("Pink")){					
					frmProyectoRedmia.getContentPane().setBackground(new Color(246, 205, 255));										
				} else {
					frmProyectoRedmia.getContentPane().setBackground(new Color(252, 234, 185));
				}
			}
		});
		comboTheme.setModel(new DefaultComboBoxModel(new String[] {"Sky blue", "Pink", "Orange"}));
		comboTheme.setBounds(822, 27, 114, 19);
		frmProyectoRedmia.getContentPane().add(comboTheme);	
		
        
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
		
		//Countries' comboBox
		JComboBox comboCountry = new JComboBox();
		comboCountry.setFont(new Font("Dialog", Font.BOLD, 11));
		comboCountry.setModel(new DefaultComboBoxModel(new String[] {"Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua & Deps", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Central African Rep", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo", "Congo {Democratic Rep}", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland {Republic}", "Israel", "Italy", "Ivory Coast", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea North", "Korea South", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar, {Burma}", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russian Federation", "Rwanda", "St Kitts & Nevis", "St Lucia", "Saint Vincent & the Grenadines", "Samoa", "San Marino", "Sao Tome & Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tonga", "Trinidad & Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe"}));
		comboCountry.setMaximumRowCount(19);
		comboCountry.setBounds(82, 154, 114, 19);
		frmProyectoRedmia.getContentPane().add(comboCountry);
		

		//Here we will display the registered persons
		TextArea textAreaPersons = new TextArea();
		textAreaPersons.setEditable(false);
		textAreaPersons.setBackground(UIManager.getColor("InternalFrame.borderHighlight"));
		textAreaPersons.setBounds(493, 392, 443, 240);
		frmProyectoRedmia.getContentPane().add(textAreaPersons);
	

		//Vehicules' counter
		JLabel lblVCounter = new JLabel("0");
		lblVCounter.setHorizontalAlignment(SwingConstants.CENTER);
		lblVCounter.setFont(new Font("Dialog", Font.BOLD, 35));
		lblVCounter.setBounds(669, 85, 36, 39);
		frmProyectoRedmia.getContentPane().add(lblVCounter);
		

		//Here we will show the registered vehicules	
		TextArea textAreaVehicules = new TextArea();
		textAreaVehicules.setBackground(UIManager.getColor("InternalFrame.borderLight"));
		textAreaVehicules.setEditable(false);
		textAreaVehicules.setBounds(748, 117, 188, 135);
		frmProyectoRedmia.getContentPane().add(textAreaVehicules);
		
		
		//Person's counter
		JLabel lblPCounter = new JLabel("0");
		lblPCounter.setFont(new Font("Dialog", Font.BOLD, 40));
		lblPCounter.setBounds(320, 113, 70, 47);
		frmProyectoRedmia.getContentPane().add(lblPCounter);
		
		
		//Labels, images and separators
		JLabel lblRedmi9A = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/logoSemiTiny.png")).getImage();
		lblRedmi9A.setIcon(new ImageIcon(img2));
		lblRedmi9A.setBounds(15, 1, 70, 45);
		frmProyectoRedmia.getContentPane().add(lblRedmi9A);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(22, 47, 940, 2);
		frmProyectoRedmia.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 305, 965, 2);
		frmProyectoRedmia.getContentPane().add(separator_1);
		
		JLabel lblTheme = new JLabel("Theme");
		lblTheme.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheme.setBounds(822, 10, 103, 15);
		frmProyectoRedmia.getContentPane().add(lblTheme);
		
		JLabel lblWomen = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/Office-Girl-icon.png")).getImage();
		lblWomen.setIcon(new ImageIcon(img3));
		lblWomen.setBounds(251, 92, 77, 82);
		frmProyectoRedmia.getContentPane().add(lblWomen);
		
		JLabel lblTitulo = new JLabel("PERSON'S REGISTRY");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Lato Semibold", Font.BOLD, 18));
		lblTitulo.setBounds(0, 1, 902, 54);
		frmProyectoRedmia.getContentPane().add(lblTitulo);

		JLabel lblVehiculeName = new JLabel("Vehicule name");
		lblVehiculeName.setBounds(460, 99, 129, 15);
		frmProyectoRedmia.getContentPane().add(lblVehiculeName);	
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(460, 138, 114, 15);
		frmProyectoRedmia.getContentPane().add(lblColor);
		
		JLabel lbl1 = new JLabel("Length");
		lbl1.setBounds(460, 173, 70, 19);
		frmProyectoRedmia.getContentPane().add(lbl1);
		
		JLabel lbl2 = new JLabel("Beam");
		lbl2.setBounds(460, 210, 139, 15);
		frmProyectoRedmia.getContentPane().add(lbl2);


		JLabel lblVehicules = new JLabel("Vehicules");
		lblVehicules.setBounds(460, 55, 70, 15);
		frmProyectoRedmia.getContentPane().add(lblVehicules);

		JLabel lblName = new JLabel("First name");
		lblName.setBounds(81, 55, 89, 15);
		frmProyectoRedmia.getContentPane().add(lblName);
		
		JLabel lblApellido = new JLabel("Last name");
		lblApellido.setBounds(82, 99, 103, 15);
		frmProyectoRedmia.getContentPane().add(lblApellido);
		
		JLabel lblNewLabel = new JLabel("Country");
		lblNewLabel.setBounds(82, 138, 123, 15);
		frmProyectoRedmia.getContentPane().add(lblNewLabel);
		
		JLabel lblCantidadDeHijos = new JLabel("Amount of children");
		lblCantidadDeHijos.setBounds(82, 173, 139, 19);
		frmProyectoRedmia.getContentPane().add(lblCantidadDeHijos);
		
		JLabel lblFechaDeNacimiento = new JLabel("Date of birth");
		lblFechaDeNacimiento.setBounds(82, 210, 172, 15);
		frmProyectoRedmia.getContentPane().add(lblFechaDeNacimiento);

		JLabel lblCar = new JLabel("");
		Image imgAuto = new ImageIcon(this.getClass().getResource("/vw-beetle-icon.png")).getImage();
		lblCar.setIcon(new ImageIcon(imgAuto));
		lblCar.setBounds(608, 76, 70, 54);
		frmProyectoRedmia.getContentPane().add(lblCar);
		
		JSeparator separator_3_1 = new JSeparator(SwingConstants.VERTICAL);
		separator_3_1.setBounds(450, 47, 2, 600);
		frmProyectoRedmia.getContentPane().add(separator_3_1);
		Image img = new ImageIcon(this.getClass().getResource("/Save-icon.png")).getImage();
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(15, 354, 437, 2);
		frmProyectoRedmia.getContentPane().add(separator_2);
		
		JLabel lblStats = new JLabel("STATS");
		lblStats.setHorizontalAlignment(SwingConstants.CENTER);
		lblStats.setFont(new Font("Lato Semibold", Font.BOLD, 18));
		lblStats.setBounds(15, 310, 437, 54);
		frmProyectoRedmia.getContentPane().add(lblStats);
		
		JSeparator separator_3_1_1 = new JSeparator(SwingConstants.VERTICAL);
		separator_3_1_1.setBounds(231, 354, 8, 308);
		frmProyectoRedmia.getContentPane().add(separator_3_1_1);
		
		JLabel lblRegisteredPersons = new JLabel("Registered persons");
		lblRegisteredPersons.setBounds(748, 55, 154, 15);
		frmProyectoRedmia.getContentPane().add(lblRegisteredPersons);

		//There is also a dateChooser!
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(82, 227, 150, 19);
		frmProyectoRedmia.getContentPane().add(dateChooser);

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		//With this events we avoid most of the possible layer 8 errors by restricting the characters the user could type in the following textFields

		textName = new JTextField();
		textName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				 int key = e.getKeyChar();

				    boolean mayusculas = key >= 65 && key <= 90;
				    boolean minusculas = key >= 97 && key <= 122;
				            
				     if (!(minusculas || mayusculas)){
				        e.consume();
				    }
			}
		});
		textName.setBounds(81, 76, 114, 19);
		frmProyectoRedmia.getContentPane().add(textName);
		textName.setColumns(10);
						
		textLName = new JTextField();
		textLName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				 int key = e.getKeyChar();

				    boolean mayusculas = key >= 65 && key <= 90;
				    boolean minusculas = key >= 97 && key <= 122;
				            
				     if (!(minusculas || mayusculas))
				    {
				        e.consume();
				    }
			}
		});
		textLName.setColumns(10);
		textLName.setBounds(82, 117, 114, 19);
		frmProyectoRedmia.getContentPane().add(textLName);

		textChildren = new JTextField();
		textChildren.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent hijosE) {
				int key = hijosE.getKeyChar();

			    boolean numeros = key >= 48 && key <= 57;
			        
			    if (!numeros)
			    {
			        hijosE.consume();
			    }

			    if (textChildren.getText().trim().length() == 10) {
			        hijosE.consume();
			    }
				
			}
		});
		textChildren.setColumns(10);
		textChildren.setBounds(82, 191, 114, 19);
		frmProyectoRedmia.getContentPane().add(textChildren);
	
		
		textVName = new JTextField();
		textVName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();

			    boolean mayusculas = key >= 65 && key <= 90;
			    boolean minusculas = key >= 97 && key <= 122;
			    boolean space = key == 32;

			            
			     if (!(minusculas || mayusculas || space ))
			    {
			        e.consume();
			    }
			}
		});
		textVName.setColumns(10);
		textVName.setBounds(460, 117, 114, 19);
		frmProyectoRedmia.getContentPane().add(textVName);

			
		textColor = new JTextField();
		textColor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();

			    boolean mayusculas = key >= 65 && key <= 90;
			    boolean minusculas = key >= 97 && key <= 122;
			    boolean space = key == 32;
    
			     if (!(minusculas || mayusculas || space))
			    {
			        e.consume();
			    }
			}
		});
		textColor.setColumns(10);
		textColor.setBounds(460, 154, 114, 19);
		frmProyectoRedmia.getContentPane().add(textColor);
	
		text1 = new JTextField();
		text1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();

			    boolean numeros = key >= 48 && key <= 57;
			    boolean punto = key == 46;
			    if (!(numeros||punto)){
			        e.consume();
			    }
			    if (text1.getText().trim().length() == 10) {
			        e.consume();
			    }
			}
		});
		text1.setColumns(10);
		text1.setBounds(460, 191, 114, 19);
		frmProyectoRedmia.getContentPane().add(text1);


		text2 = new JTextField();
		text2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();

			    boolean numeros = key >= 48 && key <= 57;
			    boolean punto = key == 46;
			    if (!(numeros||punto))
			    {
			        e.consume();
			    }

			    if (text2.getText().trim().length() == 10) {
			        e.consume();
			    }
			}
		});
		text2.setColumns(10);
		text2.setBounds(460, 227, 114, 19);
		frmProyectoRedmia.getContentPane().add(text2);
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/*We make these labels and textFields invisibles until the user choose a vehicule type in comboVehicules
		*/
		lbl1.setVisible(false);	
		lbl2.setVisible(false);
		lblVehiculeName.setVisible(false);
		lblColor.setVisible(false);
		
		text1.setVisible(false);
		text2.setVisible(false);
		textVName.setVisible(false);
		textColor.setVisible(false);
		
	    ////////////////	

		JComboBox comboVehicules = new JComboBox();
		comboVehicules.setModel(new DefaultComboBoxModel(new String[] {"None", "Boat", "Plane"}));
		comboVehicules.setBackground(Color.WHITE);
		comboVehicules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				

				//Extraction of the selected option
				String selectedOption = comboVehicules.getSelectedItem().toString();
			
				///////////////////////////////////////////

		     	//We make the textFields and labels visible again acording to what the user have choose.	
				if(selectedOption.equals("None")) {
					
					lbl1.setVisible(false);	
					lbl2.setVisible(false);
					lblVehiculeName.setVisible(false);
					lblColor.setVisible(false);
					
					text1.setVisible(false);
					text2.setVisible(false);
					textVName.setVisible(false);
					textColor.setVisible(false);
					
				} else if(selectedOption.equals("Boat")){	
					
					lbl1.setVisible(true);	
					lbl2.setVisible(true);
					lblVehiculeName.setVisible(true);
					lblColor.setVisible(true);
					
					text1.setVisible(true);
					text2.setVisible(true);
					textVName.setVisible(true);
					textColor.setVisible(true);	
					
					// These two labels differ between Boats and Planes so we have to set the correct text in each case
					lbl1.setText("Length");
					lbl2.setText("Beam");
				} else {
					
					lbl1.setVisible(true);	
					lbl2.setVisible(true);
					lblVehiculeName.setVisible(true);
					lblColor.setVisible(true);
					
					text1.setVisible(true);
					text2.setVisible(true);
					textVName.setVisible(true);
					textColor.setVisible(true);			
			
					lbl1.setText("Length");
					lbl2.setText("Mxm. passengers");
	
				}
				
				//textFields cleansing
				text1.setText(null);
				text2.setText(null);
				textVName.setText(null);
				textColor.setText(null);
				
			}
		});
		comboVehicules.setBounds(460, 76, 114, 19);
		frmProyectoRedmia.getContentPane().add(comboVehicules);
		
		
		
		////////////////////////////////////////////////////////////////////////////////////

		//This is where we start actually creating persons and adding them their respective vehicules



		JComboBox comboPersons = new JComboBox();
		comboPersons.setBounds(748, 76, 188, 21);
		frmProyectoRedmia.getContentPane().add(comboPersons);
		
		JButton btnAddPerson = new JButton("Add person");
		btnAddPerson.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {


			//First we extract data and check their integrity to avoid undesirable errors
			try{
				String name = textName.getText();
				String lName = textLName.getText();
				int aChildren = (byte)Integer.parseInt(textChildren.getText());					
				String country = (String)(comboCountry.getSelectedItem());
				
				LocalDate bDate = dateChooser.getDate().toInstant()
					      .atZone(ZoneId.systemDefault())
					      .toLocalDate();
				
				Person p = new Person((arrPersons.size() + 1), name, lName, country, aChildren, bDate);
				arrPersons.add(p);
				
			}catch(Exception ex){
             JOptionPane.showMessageDialog(null, "Datos no v�lidos.");
			}

				//We make sure the comboBoxPersons update everytime we add a person		
				updateComboBoxPerson(comboPersons);
				
				textName.setText("");
				textLName.setText("");
				textChildren.setText("");
				dateChooser.setDate(null);
				lblPCounter.setText(Integer.toString(arrPersons.size()));
			}
		});
		btnAddPerson.setBounds(172, 258, 145, 39);
		frmProyectoRedmia.getContentPane().add(btnAddPerson);
		


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		
		// The following code is for showing the user the list of registered people with their respective vehicules


		JCheckBox chckbxSoloPadres = new JCheckBox("Only parents");
		chckbxSoloPadres.setBackground(new Color(204, 153, 204));
		chckbxSoloPadres.setBounds(493, 354, 139, 21);
		frmProyectoRedmia.getContentPane().add(chckbxSoloPadres);
		
		JButton btnNewButton = new JButton("Show persons");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textAreaPersons.setText("");

				if(chckbxSoloPadres.isSelected()){
					for (Person p : arrPersons) {
						if(p.getChildren() > 0)
							textAreaPersons.setText(textAreaPersons.getText()+p.toString());
					}
				}	
				else{
					for (Person p : arrPersons) {
						textAreaPersons.setText(textAreaPersons.getText()+p.toString());
					}
				}
				
			}
		});
		btnNewButton.setBounds(748, 345, 184, 39);
		frmProyectoRedmia.getContentPane().add(btnNewButton);
		
		//Adding vehicules to the vehicule list
		JButton btnAddVehicule = new JButton("Add vehicule");
		btnAddVehicule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddVehicule.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String strNombreVehiculo = textVName.getText();
				String strColor = textColor.getText();
				double str1 = Double.parseDouble(text1.getText());
				double str2 = Double.parseDouble(text2.getText());
				
				textAreaVehicules.setText(textAreaVehicules.getText() + ((arrVolatilVehicules.size() + 1) + totalVehicules.size())  + " " + strNombreVehiculo + "\n");
				
				if(comboVehicules.getSelectedIndex() == 1) {
					Boat barco = new Boat(((arrVolatilVehicules.size() + 1) + totalVehicules.size()), strNombreVehiculo, strColor, str1, str2, arrPersons.get(comboPersons.getSelectedIndex()));
					arrVolatilVehicules.add(barco);
				}
				if(comboVehicules.getSelectedIndex() == 2) {
					Plane avion = new Plane(((arrVolatilVehicules.size() + 1) + totalVehicules.size()), strNombreVehiculo, strColor, str1, (int)str2, arrPersons.get(comboPersons.getSelectedIndex()));
					arrVolatilVehicules.add(avion);
				}
				
				//This feature unables the user to switch from a person to another after registering the first vehicule
				comboPersons.enable(false);

				lblVCounter.setText(Integer.toString(arrVolatilVehicules.size()));
				
				comboVehicules.setSelectedIndex(0);

			}
		});
		btnAddVehicule.setBounds(460, 258, 172, 35);
		frmProyectoRedmia.getContentPane().add(btnAddVehicule);
		
		//Assigning of vehicules to their respective person
		JButton btnSave = new JButton("Save person");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				textAreaVehicules.setText("");
				for (Vehicule v : arrVolatilVehicules) {
					arrPersons.get(comboPersons.getSelectedIndex()).vehicules.add(v);
					totalVehicules.add(v);
				}
				comboPersons.enable(true);
				arrVolatilVehicules.clear();
				
	     		lblVCounter.setText("0");

			}
		});
		
		btnSave.setBounds(748, 258, 188, 35);
		frmProyectoRedmia.getContentPane().add(btnSave);
		
		
		
		
		
	}
	
	//With this method we load the registered persons into their respective comboBox
	public void updateComboBoxPerson(JComboBox comboBoxPersons) {
		comboBoxPersons.removeAllItems();
		for (Person p : arrPersons) {
			comboBoxPersons.addItem(p.idPerson+ " - " +p.name + " " + p.lastName + " ");
		}
	}
}	
