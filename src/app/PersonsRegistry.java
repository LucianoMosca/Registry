package app;

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

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import entities.Boat;
import entities.Car;
import entities.Motorcycle;
import entities.Person;
import entities.Plane;
import entities.Vehicle;

public class PersonsRegistry {

	private JFrame frmMainWindow;
	private JTextField textName;
	private JTextField textLName;
	private JTextField textChildren;
	private JTextField textVName;
	ArrayList<Person> arrPersons = new ArrayList<>();
	ArrayList<Vehicle> arrVolatilVehicles = new ArrayList<>();
	ArrayList<Vehicle> totalVehicles = new ArrayList<>();
	private JTextField textKOP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonsRegistry window = new PersonsRegistry();
					window.frmMainWindow.setVisible(true);
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

		// Color theme election feature

		frmMainWindow = new JFrame();
		frmMainWindow.getContentPane().setBackground(new Color(204, 244, 255));
		frmMainWindow.setTitle("PERSON'S REGISTRY");
		frmMainWindow.setBounds(100, 100, 989, 698);
		frmMainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainWindow.getContentPane().setLayout(null);

		JComboBox comboTheme = new JComboBox();
		comboTheme.setFont(new Font("Dialog", Font.BOLD, 10));
		comboTheme.setBackground(UIManager.getColor("FormattedTextField.background"));
		comboTheme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String selectedColor = comboTheme.getSelectedItem().toString();
				if (selectedColor.equals("Sky blue")) {
					frmMainWindow.getContentPane().setBackground(new Color(204, 244, 255));
				} else if (selectedColor.equals("Pink")) {
					frmMainWindow.getContentPane().setBackground(new Color(246, 205, 255));
				} else {
					frmMainWindow.getContentPane().setBackground(new Color(252, 234, 185));
				}
			}
		});
		comboTheme.setModel(new DefaultComboBoxModel(new String[] { "Sky blue", "Pink", "Orange" }));
		comboTheme.setBounds(822, 27, 114, 19);
		frmMainWindow.getContentPane().add(comboTheme);

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// Countries' comboBox
		JComboBox comboCountry = new JComboBox();
		comboCountry.setFont(new Font("Dialog", Font.BOLD, 10));
		comboCountry.setModel(new DefaultComboBoxModel(new String[] { "Afghanistan", "Albania", "Algeria", "Andorra",
				"Angola", "Antigua & Deps", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas",
				"Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia",
				"Bosnia Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina", "Burundi", "Cambodia",
				"Cameroon", "Canada", "Cape Verde", "Central African Rep", "Chad", "Chile", "China", "Colombia",
				"Comoros", "Congo", "Congo {Democratic Rep}", "Costa Rica", "Croatia", "Cuba", "Cyprus",
				"Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador",
				"Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Fiji", "Finland",
				"France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea",
				"Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran",
				"Iraq", "Ireland {Republic}", "Israel", "Italy", "Ivory Coast", "Jamaica", "Japan", "Jordan",
				"Kazakhstan", "Kenya", "Kiribati", "Korea North", "Korea South", "Kosovo", "Kuwait", "Kyrgyzstan",
				"Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg",
				"Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands",
				"Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro",
				"Morocco", "Mozambique", "Myanmar, {Burma}", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand",
				"Nicaragua", "Niger", "Nigeria", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea",
				"Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russian Federation",
				"Rwanda", "St Kitts & Nevis", "St Lucia", "Saint Vincent & the Grenadines", "Samoa", "San Marino",
				"Sao Tome & Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore",
				"Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Sudan", "Spain",
				"Sri Lanka", "Sudan", "Suriname", "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan",
				"Tanzania", "Thailand", "Togo", "Tonga", "Trinidad & Tobago", "Tunisia", "Turkey", "Turkmenistan",
				"Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "Uruguay",
				"Uzbekistan", "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe" }));
		comboCountry.setMaximumRowCount(19);
		comboCountry.setBounds(82, 154, 114, 19);
		frmMainWindow.getContentPane().add(comboCountry);

		// Here we will display the registered persons
		TextArea textAreaPersons = new TextArea();
		textAreaPersons.setEditable(false);
		textAreaPersons.setBackground(UIManager.getColor("InternalFrame.borderHighlight"));
		textAreaPersons.setBounds(67, 416, 869, 216);
		frmMainWindow.getContentPane().add(textAreaPersons);

		// Vehicles' counter
		JLabel lblVCounter = new JLabel("0");
		lblVCounter.setHorizontalAlignment(SwingConstants.CENTER);
		lblVCounter.setFont(new Font("Dialog", Font.BOLD, 35));
		lblVCounter.setBounds(669, 85, 36, 39);
		frmMainWindow.getContentPane().add(lblVCounter);

		// Here we will show the registered Vehicles
		TextArea textAreaVehicles = new TextArea();
		textAreaVehicles.setBackground(UIManager.getColor("InternalFrame.borderLight"));
		textAreaVehicles.setEditable(false);
		textAreaVehicles.setBounds(748, 117, 188, 135);
		frmMainWindow.getContentPane().add(textAreaVehicles);

		// Person's counter
		JLabel lblPCounter = new JLabel("0");
		lblPCounter.setFont(new Font("Dialog", Font.BOLD, 40));
		lblPCounter.setBounds(316, 80, 70, 47);
		frmMainWindow.getContentPane().add(lblPCounter);

		// Labels, images and separators
		JLabel lblRedmi9A = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/logoSemiTiny.png")).getImage();
		lblRedmi9A.setIcon(new ImageIcon(img2));
		lblRedmi9A.setBounds(15, 1, 70, 45);
		frmMainWindow.getContentPane().add(lblRedmi9A);

		JSeparator separator = new JSeparator();
		separator.setBounds(22, 47, 940, 2);
		frmMainWindow.getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 305, 965, 2);
		frmMainWindow.getContentPane().add(separator_1);

		JLabel lblTheme = new JLabel("Theme");
		lblTheme.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheme.setBounds(822, 10, 103, 15);
		frmMainWindow.getContentPane().add(lblTheme);

		JLabel lblWomen = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/Office-Girl-icon.png")).getImage();
		lblWomen.setIcon(new ImageIcon(img3));
		lblWomen.setBounds(247, 65, 77, 82);
		frmMainWindow.getContentPane().add(lblWomen);

		JLabel lblTitulo = new JLabel("PERSON'S REGISTRY");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Lato Semibold", Font.BOLD, 18));
		lblTitulo.setBounds(0, 1, 902, 54);
		frmMainWindow.getContentPane().add(lblTitulo);

		JLabel lblVehiculeName = new JLabel("Vehicle name");
		lblVehiculeName.setBounds(460, 99, 129, 15);
		frmMainWindow.getContentPane().add(lblVehiculeName);

		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(460, 210, 114, 15);
		frmMainWindow.getContentPane().add(lblColor);

		JLabel lbl1 = new JLabel("Brand");
		lbl1.setBounds(460, 136, 70, 19);
		frmMainWindow.getContentPane().add(lbl1);

		JLabel lbl2 = new JLabel("Model");
		lbl2.setBounds(460, 175, 139, 15);
		frmMainWindow.getContentPane().add(lbl2);

		JLabel lblVehicles = new JLabel("Vehicles");
		lblVehicles.setBounds(460, 55, 70, 15);
		frmMainWindow.getContentPane().add(lblVehicles);

		JLabel lblName = new JLabel("First name");
		lblName.setBounds(81, 55, 89, 15);
		frmMainWindow.getContentPane().add(lblName);

		JLabel lblApellido = new JLabel("Last name");
		lblApellido.setBounds(82, 99, 103, 15);
		frmMainWindow.getContentPane().add(lblApellido);

		JLabel lblNewLabel = new JLabel("Country");
		lblNewLabel.setBounds(82, 138, 123, 15);
		frmMainWindow.getContentPane().add(lblNewLabel);

		JLabel lblCantidadDeHijos = new JLabel("Amount of children");
		lblCantidadDeHijos.setBounds(82, 173, 139, 19);
		frmMainWindow.getContentPane().add(lblCantidadDeHijos);

		JLabel lblFechaDeNacimiento = new JLabel("Date of birth");
		lblFechaDeNacimiento.setBounds(82, 210, 172, 15);
		frmMainWindow.getContentPane().add(lblFechaDeNacimiento);

		JLabel lblCar = new JLabel("");
		Image imgAuto = new ImageIcon(this.getClass().getResource("/vw-beetle-icon.png")).getImage();
		lblCar.setIcon(new ImageIcon(imgAuto));
		lblCar.setBounds(608, 76, 70, 54);
		frmMainWindow.getContentPane().add(lblCar);

		JSeparator separator_3_1 = new JSeparator(SwingConstants.VERTICAL);
		separator_3_1.setBounds(448, 47, 2, 256);
		frmMainWindow.getContentPane().add(separator_3_1);
		Image img = new ImageIcon(this.getClass().getResource("/Save-icon.png")).getImage();

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(15, 354, 947, 2);
		frmMainWindow.getContentPane().add(separator_2);

		JLabel lblSOP = new JLabel("PERSONS");
		lblSOP.setHorizontalAlignment(SwingConstants.CENTER);
		lblSOP.setFont(new Font("Lato Semibold", Font.BOLD, 18));
		lblSOP.setBounds(232, 305, 437, 54);
		frmMainWindow.getContentPane().add(lblSOP);

		JSeparator separatorVerticalBottom = new JSeparator(SwingConstants.VERTICAL);
		separatorVerticalBottom.setBounds(448, 354, 2, 279);
		frmMainWindow.getContentPane().add(separatorVerticalBottom);
		separatorVerticalBottom.setVisible(false);

		JLabel lblRegisteredPersons = new JLabel("Registered persons");
		lblRegisteredPersons.setBounds(748, 55, 154, 15);
		frmMainWindow.getContentPane().add(lblRegisteredPersons);

		JLabel lblKOP = new JLabel("Kilometers");
		lblKOP.setBounds(608, 139, 70, 13);
		frmMainWindow.getContentPane().add(lblKOP);

		// There is also a dateChooser!
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(82, 227, 150, 19);
		frmMainWindow.getContentPane().add(dateChooser);

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// With this events we avoid most of the possible layer 8 errors by restricting
		// the characters the user could type in the following textFields

		textName = new JTextField();
		textName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();

				boolean upper = key >= 65 && key <= 90;
				boolean lower = key >= 97 && key <= 122;

				if (!(lower || upper)) {
					e.consume();
				}
			}
		});
		textName.setBounds(81, 76, 114, 19);
		frmMainWindow.getContentPane().add(textName);
		textName.setColumns(10);

		textLName = new JTextField();
		textLName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();

				boolean upper = key >= 65 && key <= 90;
				boolean lower = key >= 97 && key <= 122;

				if (!(lower || upper)) {
					e.consume();
				}
			}
		});
		textLName.setColumns(10);
		textLName.setBounds(82, 117, 114, 19);
		frmMainWindow.getContentPane().add(textLName);

		textChildren = new JTextField();
		textChildren.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent hijosE) {
				int key = hijosE.getKeyChar();

				boolean numbers = key >= 48 && key <= 57;

				if (!numbers) {
					hijosE.consume();
				}

				if (textChildren.getText().trim().length() == 10) {
					hijosE.consume();
				}

			}
		});
		textChildren.setColumns(10);
		textChildren.setBounds(82, 191, 114, 19);
		frmMainWindow.getContentPane().add(textChildren);

		textVName = new JTextField();
		textVName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();

				boolean upper = key >= 65 && key <= 90;
				boolean lower = key >= 97 && key <= 122;
				boolean space = key == 32;

				if (!(lower || upper || space)) {
					e.consume();
				}
			}
		});
		textVName.setColumns(10);
		textVName.setBounds(460, 117, 114, 19);
		frmMainWindow.getContentPane().add(textVName);

		textKOP = new JTextField();
		textKOP.setBounds(609, 154, 96, 19);
		frmMainWindow.getContentPane().add(textKOP);
		textKOP.setColumns(10);


		JComboBox comboColor = new JComboBox();
		comboColor.setModel(new DefaultComboBoxModel(new String[] {"", "White", "Black", "Red", "Blue"}));
		comboColor.setBounds(460, 227, 114, 19);
		frmMainWindow.getContentPane().add(comboColor);

		JComboBox comboModel = new JComboBox();
		comboModel.setBounds(460, 191, 114, 19);
		frmMainWindow.getContentPane().add(comboModel);

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		JComboBox comboBrand = new JComboBox();		
		//In the following actionListener we will make sure the comboModel's options change whenever we change the vehicle's brand.
		comboBrand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedOption = comboBrand.getSelectedItem().toString();
				
				if(comboBrand.getSelectedIndex()==0) {
					String[] model = {""};
					changeCombo(comboModel, model);	
				} else {
					changeModel(comboModel, selectedOption);
				}
				
			}
		});
		comboBrand.setBounds(460, 154, 114, 19);
		frmMainWindow.getContentPane().add(comboBrand);
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		/*
		 * We make these labels, comboBoxes and textFields invisible until the user choose a vehicle
		 * type in comboVehicles
		 */
		comboBrand.setVisible(false);
		comboModel.setVisible(false);
		comboColor.setVisible(false);
		lblVehiculeName.setVisible(false);
		lblKOP.setVisible(false);
		lbl1.setVisible(false);
		lbl2.setVisible(false);
		lblColor.setVisible(false);
		textVName.setVisible(false);
		textKOP.setVisible(false);

		////////////////

		JComboBox comboVehicles = new JComboBox();
		comboVehicles.setModel(new DefaultComboBoxModel(new String[] { "None", "Car", "Motorcycle", "Boat", "Plane" }));
		comboVehicles.setBackground(Color.WHITE);
		comboVehicles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {

				// Here we change the acceptable inputs for the textKOP (kilometers or
				// passengers) field
				textKOP.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						changeInput(e, comboVehicles);
					}
				});

				// Extraction of the selected option
				int selectedOption = comboVehicles.getSelectedIndex();

				///////////////////////////////////////////

				// We make the textFields and labels visible again according to what the user
				// may choose.
				if (selectedOption == 0) {
					// None

					lbl1.setVisible(false);
					lbl2.setVisible(false);
					lblVehiculeName.setVisible(false);
					lblColor.setVisible(false);
					lblKOP.setVisible(false);

					comboBrand.setVisible(false);
					comboModel.setVisible(false);
					textVName.setVisible(false);
					comboColor.setVisible(false);
					textKOP.setVisible(false);

				} else if (selectedOption == 4) {
					// Plane

					String[] model = { "", "Airbus", "Boeing" };

					changeCombo(comboBrand, model);

					lblKOP.setText("Passengers");

					lblKOP.setVisible(true);
					lbl1.setVisible(true);
					lbl2.setVisible(true);
					lblVehiculeName.setVisible(true);
					lblColor.setVisible(true);

					comboBrand.setVisible(true);
					comboModel.setVisible(true);
					textVName.setVisible(true);
					comboColor.setVisible(true);
					textKOP.setVisible(true);

				} else if (selectedOption == 3) {
					// Boat

					String[] model = { "", "Bertram", "Chaparral", "Lund" };

					changeCombo(comboBrand, model);

					lbl1.setVisible(true);
					lbl2.setVisible(true);
					lblVehiculeName.setVisible(true);
					lblColor.setVisible(true);
					lblKOP.setVisible(false);

					comboBrand.setVisible(true);
					comboModel.setVisible(true);
					textVName.setVisible(true);
					comboColor.setVisible(true);
					textKOP.setVisible(false);

				} else if (selectedOption == 2) {
					// Motorcycle
					String[] model = { "", "Benelli", "Harley Davidson", "Yamaha", "Yumbo" };

					changeCombo(comboBrand, model);

					lblKOP.setText("Kilometers");

					lblKOP.setVisible(true);
					lbl1.setVisible(true);
					lbl2.setVisible(true);
					lblVehiculeName.setVisible(true);
					lblColor.setVisible(true);

					comboBrand.setVisible(true);
					comboModel.setVisible(true);
					textVName.setVisible(true);
					comboColor.setVisible(true);
					textKOP.setVisible(true);

				} else if (selectedOption == 1) {
					// Car

					String[] model = { "", "Tesla", "Ford", "Subaru", "Fiat" };

					changeCombo(comboBrand, model);

					lblKOP.setText("Kilometers");

					lblKOP.setVisible(true);
					lbl1.setVisible(true);
					lbl2.setVisible(true);
					lblVehiculeName.setVisible(true);
					lblColor.setVisible(true);

					comboBrand.setVisible(true);
					comboModel.setVisible(true);
					textVName.setVisible(true);
					comboColor.setVisible(true);
					textKOP.setVisible(true);
				}
				//Fields cleansing

				String[] model = {""};
				
				changeCombo(comboModel, model);
				comboColor.setSelectedIndex(0);
				comboBrand.setSelectedIndex(0);
				
				
				textKOP.setText(null);
				textVName.setText(null);
			}
		});
		comboVehicles.setBounds(460, 76, 114, 19);
		frmMainWindow.getContentPane().add(comboVehicles);

		////////////////////////////////////////////////////////////////////////////////////

		// This is where we actually start creating persons and adding them their
		// respective Vehicles

		JComboBox comboPersons = new JComboBox();
		comboPersons.setBounds(748, 76, 188, 21);
		frmMainWindow.getContentPane().add(comboPersons);

		JButton btnAddPerson = new JButton("ADD PERSON");
		btnAddPerson.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// First we extract data and check their integrity to avoid undesirable errors
				try {
					String name = textName.getText();
					String lName = textLName.getText();
					int aChildren = (byte) Integer.parseInt(textChildren.getText());
					String country = (String) (comboCountry.getSelectedItem());

					LocalDate bDate = dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

					Person p = new Person((arrPersons.size() + 1), name, lName, country, aChildren, bDate);
					arrPersons.add(p);

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Invalid data");
				}

				// We make sure the comboBoxPersons update everytime we add a person
				updateComboBoxPerson(comboPersons);

				textName.setText("");
				textLName.setText("");
				textChildren.setText("");
				dateChooser.setDate(null);
				lblPCounter.setText(Integer.toString(arrPersons.size()));
			}
		});
		btnAddPerson.setBounds(172, 258, 145, 39);
		frmMainWindow.getContentPane().add(btnAddPerson);

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		

		// The following code is for showing the user the list of registered people with
		// their respective Vehicles

		JCheckBox chckbxSoloPadres = new JCheckBox("Only parents");
		chckbxSoloPadres.setBackground(new Color(204, 153, 204));
		chckbxSoloPadres.setBounds(67, 389, 139, 21);
		frmMainWindow.getContentPane().add(chckbxSoloPadres);

		JButton btnShowPersons = new JButton("SHOW PERSONS");
		btnShowPersons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnShowPersons.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textAreaPersons.setText("");

				if (chckbxSoloPadres.isSelected()) {
					for (Person p : arrPersons) {
						if (p.getChildren() > 0)
							textAreaPersons.setText(textAreaPersons.getText() + p.toString());
					}
				} else {
					for (Person p : arrPersons) {
						textAreaPersons.setText(textAreaPersons.getText() + p.toString());
					}
				}

			}
		});
		btnShowPersons.setBounds(748, 371, 184, 39);
		frmMainWindow.getContentPane().add(btnShowPersons);

		// Adding Vehicles to the vehicle list
		JButton btnAddVehicule = new JButton("ADD VEHICLE");
		btnAddVehicule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddVehicule.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String strVehiculeName = textVName.getText();
				String strColor = comboColor.getSelectedItem().toString();
				String strBrand = comboBrand.getSelectedItem().toString();
				String strModel = comboModel.getSelectedItem().toString();
				textAreaVehicles.setText(textAreaVehicles.getText()
						+ ((arrVolatilVehicles.size() + 1) + totalVehicles.size()) + " " + strVehiculeName + "\n");

				if (comboVehicles.getSelectedIndex() == 1) {
					double kilometers = Double.parseDouble(textKOP.getText());
					Car car = createCar(strVehiculeName, strColor, strBrand, strModel, kilometers, comboPersons);
					// Car car = new Car(((arrVolatilVehicles.size() + 1) + totalVehicles.size()),
					// strVehiculeName, strColor, strBrand, strModel, kilometers,
					// arrPersons.get(comboPersons.getSelectedIndex()));

					arrVolatilVehicles.add(car);
				}

				if (comboVehicles.getSelectedIndex() == 2) {
					double kilometers = Double.parseDouble(textKOP.getText());
					Motorcycle bike = createBike(strVehiculeName, strColor, strBrand, strModel, kilometers,
							comboPersons);
					// Motorcycle bike = new Motorcycle(((arrVolatilVehicles.size() + 1) +
					// totalVehicles.size()), strVehiculeName, strColor, strBrand, strModel,
					// kilometers, arrPersons.get(comboPersons.getSelectedIndex()));
					arrVolatilVehicles.add(bike);

				}
				if (comboVehicles.getSelectedIndex() == 3) {
					Boat boat = createBoat(strVehiculeName, strColor, strBrand, strModel, comboPersons);
					// Boat boat = new Boat(((arrVolatilVehicles.size() + 1) +
					// totalVehicles.size()), strVehiculeName, strColor, strBrand, strModel,
					// arrPersons.get(comboPersons.getSelectedIndex()));
					arrVolatilVehicles.add(boat);
				}
				if (comboVehicles.getSelectedIndex() == 4) {
					int passengers = Integer.parseInt(textKOP.getText());
					Plane plane = createPlane(strVehiculeName, strColor, strBrand, strModel, passengers, comboPersons);
					// Plane plane = new Plane(((arrVolatilVehicles.size() + 1) +
					// totalVehicles.size()), strVehiculeName, strColor, strBrand, strModel,
					// passengers, arrPersons.get(comboPersons.getSelectedIndex()));
					arrVolatilVehicles.add(plane);
				}

				// This feature unables the user to switch from a person to another after
				// registering the first vehicule
				comboPersons.enable(false);

				lblVCounter.setText(Integer.toString(arrVolatilVehicles.size()));

				comboVehicles.setSelectedIndex(0);

			}
		});
		btnAddVehicule.setBounds(460, 260, 172, 35);
		frmMainWindow.getContentPane().add(btnAddVehicule);

		// With this action listener we make sure the "Add vehicule" button is invisible
		// until a vehicle type is selected
		btnAddVehicule.setVisible(false);
		comboVehicles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				if (comboVehicles.getSelectedIndex() != 0) {
					btnAddVehicule.setVisible(true);
				}
				if (comboVehicles.getSelectedIndex() == 0) {
					btnAddVehicule.setVisible(false);
				}
			}
		});
		//

		// Here we assign vehicles to their respective owners
		JButton btnSave = new JButton("SAVE PERSON");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				textAreaVehicles.setText("");
				for (Vehicle v : arrVolatilVehicles) {
					arrPersons.get(comboPersons.getSelectedIndex()).vehicles.add(v);
					totalVehicles.add(v);
				}
				comboPersons.enable(true);
				arrVolatilVehicles.clear();

				lblVCounter.setText("0");

			}
		});

		btnSave.setBounds(748, 258, 188, 35);
		frmMainWindow.getContentPane().add(btnSave);

		JButton btnChangeView = new JButton("VIEW STATS");
		btnChangeView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// We change what the user sees when pressing btnChangeView
				changeView(btnChangeView, chckbxSoloPadres, textAreaPersons, btnShowPersons, separatorVerticalBottom,
						lblSOP);

			}
		});
		btnChangeView.setBounds(40, 317, 139, 27);
		frmMainWindow.getContentPane().add(btnChangeView);

	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	// Functions

	// We are going to use this function to change the information that the user may
	// see.
	// The user will have the option to see either
	// A) "Persons": A list of the persons registered with their respective vehicles
	// or
	// B) "Stats": Several global indexes such as total amount of vehicles, most
	// populated countries, etc.
	// In order to do this we are going to hide or show elements depending of the
	// user's choice.
	public void changeView(JButton btnChangeView, JCheckBox chckbxSoloPadres, TextArea textAreaPersons,
			JButton btnShowPersons, JSeparator separatorVerticalBottom, JLabel lblSOP) {

		if (btnChangeView.getText().equals("VIEW STATS")) {
			// From Stats to Persons

			chckbxSoloPadres.setVisible(false);
			textAreaPersons.setVisible(false);
			btnShowPersons.setVisible(false);
			separatorVerticalBottom.setVisible(true);

			lblSOP.setText("STATS");
			btnChangeView.setText("VIEW PERSONS");

		} else {
			// From Stats to Persons

			chckbxSoloPadres.setVisible(true);
			textAreaPersons.setVisible(true);
			btnShowPersons.setVisible(true);
			separatorVerticalBottom.setVisible(false);

			lblSOP.setText("PERSONS");
			btnChangeView.setText("VIEW STATS");

		}

	}

	// Vehicle objects creation
	public Car createCar(String vehiculeName, String strColor, String strBrand, String strModel, double kilometers,
			JComboBox comboPersons) {
		Car car = new Car(((arrVolatilVehicles.size() + 1) + totalVehicles.size()), vehiculeName, strColor, strBrand,
				strModel, kilometers, arrPersons.get(comboPersons.getSelectedIndex()));
		return car;
	}

	public Boat createBoat(String vehiculeName, String strColor, String strBrand, String strModel,
			JComboBox comboPersons) {
		Boat boat = new Boat(((arrVolatilVehicles.size() + 1) + totalVehicles.size()), vehiculeName, strColor, strBrand,
				strModel, arrPersons.get(comboPersons.getSelectedIndex()));
		return boat;
	}

	public Plane createPlane(String vehiculeName, String strColor, String strBrand, String strModel, int passengers,
			JComboBox comboPersons) {
		Plane plane = new Plane(((arrVolatilVehicles.size() + 1) + totalVehicles.size()), vehiculeName, strColor,
				strBrand, strModel, passengers, arrPersons.get(comboPersons.getSelectedIndex()));
		return plane;
	}

	public Motorcycle createBike(String vehiculeName, String strColor, String strBrand, String strModel,
			double kilometers, JComboBox comboPersons) {
		Motorcycle bike = new Motorcycle(((arrVolatilVehicles.size() + 1) + totalVehicles.size()), vehiculeName,
				strColor, strBrand, strModel, kilometers, arrPersons.get(comboPersons.getSelectedIndex()));
		return bike;
	}

	// With this method we load the registered persons into their respective
	// comboBox
	public void updateComboBoxPerson(JComboBox comboPersons) {
		comboPersons.removeAllItems();
		for (Person p : arrPersons) {
			comboPersons.addItem(p.idPerson + " - " + p.name + " " + p.lastName + " ");
		}
	}

	/*
	
	*/
	// With this method we switch the permitted inputs in the KOP textField, so the
	// user will be able to use it both for the amount of passengers of a plane or
	// the kilometres of other vehicles
	public void changeInput(KeyEvent e, JComboBox comboVehicles) {

		if (comboVehicles.getSelectedIndex() == 2 || comboVehicles.getSelectedIndex() == 1) {
			int key = e.getKeyChar();

			boolean numbers = key >= 48 && key <= 57;
			boolean dot = key == 46;
			if (!(numbers || dot)) {
				e.consume();
			}

		}
		if (comboVehicles.getSelectedIndex() == 3) {
			int key = e.getKeyChar();

			boolean numbers = key >= 48 && key <= 57;
			if (!(numbers)) {
				e.consume();
			}
		}

	}

	// Method that changes the options we display inside a comboBox
	public void changeCombo(JComboBox comboBox, String[] array) {
		comboBox.setModel(new DefaultComboBoxModel(array));
	}
	
	
	// This function retrieves us the type of the vehicle we are trying to add
	public String vehicleType(String selectedOption) {
		String type = "";
		
		
		if(selectedOption.equals("Airbus")||selectedOption.equals("Boeing")) {
			type = "Plane";
		}
		
		if(selectedOption.equals("Bertram")||selectedOption.equals("Chaparral")||selectedOption.equals("Safran")) {
			type = "Boat";
		}
		
		if(selectedOption.equals("Benelli")||selectedOption.equals("Yumbo")||selectedOption.equals("Harley Davidson")||selectedOption.equals("Yamaha")) {
			type = "Motorcycle";
		}
		
		if(selectedOption.equals("Tesla")||selectedOption.equals("Ford")||selectedOption.equals("Subaru")||selectedOption.equals("Fiat")) {
			type = "Car";
		}
		
		
		return type;
	}
	
	
	//This method is for changing the options inside of comboModel
	public void changeModel(JComboBox comboBox, String selectedOption) {
	
		String type = vehicleType(selectedOption);
		
		
		//Plane
		if(type.equals("Plane")) {
			if (selectedOption.equals("Airbus")) {
				String[] model = { "", "A220", "A300", "A310", "A318" };
				changeCombo(comboBox, model);
			}

			if (selectedOption.equals("Boeing")) {
				String[] model = { "", "737", "747", "767", "777" };
				changeCombo(comboBox, model);
			}
		}
		
		
		//Boat
		else if (type.equals("Boat")) {	

			if (selectedOption.equals("Safran")) {
				String[] model = { "", "737", "747", "767", "777" };
				changeCombo(comboBox, model);
			}

			if (selectedOption.equals("Bertram")) {
				String[] model = { "", "Bahia Mar", "Flybridge", "Moppie", "Sport Fisherman" };
				changeCombo(comboBox, model);
			}

			if (selectedOption.equals("Chaparral")) {
				String[] model = { "", "SSX OB", "SSX", "SSi", "Surf" };
				changeCombo(comboBox, model);
			}
		}
		
		//Car
		else if(type.equals("Car")) {
			if (selectedOption.equals("Tesla")) {
				String[] model = { "", "Y", "3", "S", "X" };
				changeCombo(comboBox, model);
			}

			if (selectedOption.equals("Ford")) {
				String[] model = { "", "Mustang", "Explorer", "Taurus", "LTD" };
				changeCombo(comboBox, model);
			}

			if (selectedOption.equals("Subaru")) {
				String[] model = { "", "Legacy", "WRX STI", "Outback", "Ascent" };
				changeCombo(comboBox, model);
			}
			
			if (selectedOption.equals("Fiat")) {
				String[] model = { "", "Abarth", "Uno Turbo", "Coupe", "Spider" };
				changeCombo(comboBox, model);
			}
			
			

		}
		//Motorcycle
		else if(type.equals("Motorcycle")) {
			if (selectedOption.equals("Benelli")) {
				String[] model = { "", "TRK502", "TNT150I", "LEONCINO", "TRK251" };
				changeCombo(comboBox, model);
			}

			if (selectedOption.equals("Yamaha")) {
				String[] model = { "", "Crux", "YBR-Z", "FZ-S FI", "MT-09 ABS" };
				changeCombo(comboBox, model);
			}

			if (selectedOption.equals("Yumbo")) {
				String[] model = { "", "GSIII", "GS-F","PX 110", "Eco 70" };
				changeCombo(comboBox, model);
			}
			
			if (selectedOption.equals("Harley Davidson")) {
				String[] model = { "", "Street bob", "Sporster Iron", "Street Glide", "Street Bob" };
				changeCombo(comboBox, model);
			}
			
			
		}
	}

}
