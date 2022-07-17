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
import java.time.Period;
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
		frmMainWindow.setBounds(100, 100, 485, 733);
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
		comboTheme.setBounds(364, 25, 77, 19);
		frmMainWindow.getContentPane().add(comboTheme);

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// Countries' comboBox

		// Here we will display the registered persons
		TextArea textAreaPersons = new TextArea();
		textAreaPersons.setEditable(false);
		textAreaPersons.setBackground(UIManager.getColor("InternalFrame.borderHighlight"));
		textAreaPersons.setBounds(40, 458, 401, 216);
		frmMainWindow.getContentPane().add(textAreaPersons);

		// Labels, images and separators
		JLabel lblRedmi9A = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/logoSemiTinyALPHA.png")).getImage();
		lblRedmi9A.setIcon(new ImageIcon(img2));
		lblRedmi9A.setBounds(15, 10, 70, 45);
		frmMainWindow.getContentPane().add(lblRedmi9A);

		JSeparator separator = new JSeparator();
		separator.setBounds(12, 47, 440, 2);
		frmMainWindow.getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 375, 440, 2);
		frmMainWindow.getContentPane().add(separator_1);

		JLabel lblTheme = new JLabel("THEME");
		lblTheme.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheme.setBounds(344, 10, 103, 15);
		frmMainWindow.getContentPane().add(lblTheme);

		JLabel lblIcon = new JLabel("");
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		Image img3 = new ImageIcon(this.getClass().getResource("/peopleMedium.png")).getImage();
		lblIcon.setIcon(new ImageIcon(img3));
		lblIcon.setBounds(162, 47, 77, 82);
		frmMainWindow.getContentPane().add(lblIcon);

		JLabel lblTitle = new JLabel("PERSON'S REGISTRY");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Lato Semibold", Font.BOLD, 18));
		lblTitle.setBounds(0, 1, 450, 54);
		frmMainWindow.getContentPane().add(lblTitle);

		JSeparator separator_3_1 = new JSeparator(SwingConstants.VERTICAL);
		separator_3_1.setBounds(242, 47, 2, 328);
		frmMainWindow.getContentPane().add(separator_3_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(12, 420, 440, 2);
		frmMainWindow.getContentPane().add(separator_2);

		JLabel lblSOP = new JLabel("PERSONS");
		lblSOP.setHorizontalAlignment(SwingConstants.CENTER);
		lblSOP.setFont(new Font("Lato Semibold", Font.BOLD, 18));
		lblSOP.setBounds(144, 370, 172, 54);
		frmMainWindow.getContentPane().add(lblSOP);

		JLabel lblSubTitle = new JLabel("ADD A PERSON!");
		lblSubTitle.setFont(new Font("Dialog", Font.BOLD, 15));
		lblSubTitle.setBounds(40, 79, 200, 13);
		frmMainWindow.getContentPane().add(lblSubTitle);

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Persons
		JLabel lblName = new JLabel("First name");
		lblName.setBounds(40, 120, 89, 15);
		frmMainWindow.getContentPane().add(lblName);

		JLabel lblLName = new JLabel("Last name");
		lblLName.setBounds(40, 160, 103, 15);
		frmMainWindow.getContentPane().add(lblLName);

		JLabel lblCountry = new JLabel("Country");
		lblCountry.setBounds(40, 200, 123, 15);
		frmMainWindow.getContentPane().add(lblCountry);

		JLabel lblChildAmount = new JLabel("Amount of children");
		lblChildAmount.setBounds(40, 240, 139, 19);
		frmMainWindow.getContentPane().add(lblChildAmount);

		JLabel lblBirthDate = new JLabel("Date of birth");
		lblBirthDate.setBounds(40, 280, 172, 15);
		frmMainWindow.getContentPane().add(lblBirthDate);

		// There is also a dateChooser!
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(40, 300, 150, 19);
		frmMainWindow.getContentPane().add(dateChooser);

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
		textName.setBounds(40, 140, 114, 19);
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
		textLName.setBounds(40, 180, 114, 19);
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
		textChildren.setBounds(40, 260, 114, 19);
		frmMainWindow.getContentPane().add(textChildren);

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
		comboCountry.setBounds(40, 220, 114, 19);
		frmMainWindow.getContentPane().add(comboCountry);

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Vehicles

		JLabel lblRegisteredPersons = new JLabel("Owner");
		lblRegisteredPersons.setBounds(253, 120, 154, 15);
		frmMainWindow.getContentPane().add(lblRegisteredPersons);

		JLabel lblKOP = new JLabel("Kilometers");
		lblKOP.setBounds(162, 122, 70, 13);
		frmMainWindow.getContentPane().add(lblKOP);

		JLabel lblVehiculeName = new JLabel("Vehicle name");
		lblVehiculeName.setBounds(40, 160, 129, 15);
		frmMainWindow.getContentPane().add(lblVehiculeName);

		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(40, 280, 114, 15);
		frmMainWindow.getContentPane().add(lblColor);

		JLabel lbl1 = new JLabel("Brand");
		lbl1.setBounds(40, 200, 70, 19);
		frmMainWindow.getContentPane().add(lbl1);

		JLabel lbl2 = new JLabel("Model");
		lbl2.setBounds(40, 240, 139, 15);
		frmMainWindow.getContentPane().add(lbl2);

		JLabel lblVehicles = new JLabel("Vehicles");
		lblVehicles.setBounds(40, 120, 70, 15);
		frmMainWindow.getContentPane().add(lblVehicles);

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
		textAreaVehicles.setBounds(253, 180, 188, 92);
		frmMainWindow.getContentPane().add(textAreaVehicles);

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
		textVName.setBounds(40, 180, 114, 19);
		frmMainWindow.getContentPane().add(textVName);

		textKOP = new JTextField();
		textKOP.setBounds(162, 140, 77, 19);
		frmMainWindow.getContentPane().add(textKOP);
		textKOP.setColumns(10);

		JComboBox comboColor = new JComboBox();
		comboColor.setModel(new DefaultComboBoxModel(new String[] { "", "White", "Black", "Red", "Blue" }));
		comboColor.setBounds(40, 300, 114, 19);
		frmMainWindow.getContentPane().add(comboColor);

		JComboBox comboModel = new JComboBox();
		comboModel.setBounds(40, 260, 114, 19);
		frmMainWindow.getContentPane().add(comboModel);

		JComboBox comboBrand = new JComboBox();
		// In the following actionListener we will make sure the comboModel's options
		// change whenever we change the vehicle's brand.
		comboBrand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedOption = comboBrand.getSelectedItem().toString();

				if (comboBrand.getSelectedIndex() == 0) {
					String[] model = { "" };
					changeCombo(comboModel, model);
				} else {
					changeModel(comboModel, selectedOption);
				}

			}
		});
		comboBrand.setBounds(40, 220, 114, 19);
		frmMainWindow.getContentPane().add(comboBrand);

		// invisible by default
		lblRegisteredPersons.setVisible(false);
		lblKOP.setVisible(false);
		lblVehiculeName.setVisible(false);
		lblColor.setVisible(false);
		lbl1.setVisible(false);
		lbl2.setVisible(false);
		lblVCounter.setVisible(false);
		lblVehicles.setVisible(false);
		textAreaVehicles.setVisible(false);
		comboBrand.setVisible(false);
		comboModel.setVisible(false);
		comboColor.setVisible(false);

		textVName.setVisible(false);
		textKOP.setVisible(false);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// Stats labels and separators

		JLabel lblPopulation = new JLabel("TOTAL POPULATION");
		lblPopulation.setFont(new Font("Dialog", Font.BOLD, 10));
		lblPopulation.setBounds(65, 440, 114, 13);
		frmMainWindow.getContentPane().add(lblPopulation);

		JLabel lblTotalVehicles = new JLabel("TOTAL VEHICLES");
		lblTotalVehicles.setFont(new Font("Dialog", Font.BOLD, 10));
		lblTotalVehicles.setBounds(293, 440, 114, 13);
		frmMainWindow.getContentPane().add(lblTotalVehicles);

		JLabel lblCounterPlus18 = new JLabel("0");
		lblCounterPlus18.setHorizontalAlignment(SwingConstants.CENTER);
		lblCounterPlus18.setFont(new Font("Dialog", Font.BOLD, 40));
		lblCounterPlus18.setBounds(15, 590, 200, 50);
		frmMainWindow.getContentPane().add(lblCounterPlus18);

		JLabel lblCounterTVehicles = new JLabel("0");
		lblCounterTVehicles.setHorizontalAlignment(SwingConstants.CENTER);
		lblCounterTVehicles.setFont(new Font("Dialog", Font.BOLD, 40));
		lblCounterTVehicles.setBounds(240, 460, 200, 50);
		frmMainWindow.getContentPane().add(lblCounterTVehicles);

		JLabel lblCounterVxP = new JLabel("0");
		lblCounterVxP.setHorizontalAlignment(SwingConstants.CENTER);
		lblCounterVxP.setFont(new Font("Dialog", Font.BOLD, 40));
		lblCounterVxP.setBounds(240, 590, 200, 50);
		frmMainWindow.getContentPane().add(lblCounterVxP);

		JLabel lblPlus18 = new JLabel("ADULT POPULATION");
		lblPlus18.setFont(new Font("Dialog", Font.BOLD, 10));
		lblPlus18.setBounds(65, 570, 114, 13);
		frmMainWindow.getContentPane().add(lblPlus18);

		JLabel lblVxP = new JLabel("VEHICLES PER PERSON");
		lblVxP.setFont(new Font("Dialog", Font.BOLD, 10));
		lblVxP.setBounds(282, 570, 125, 13);
		frmMainWindow.getContentPane().add(lblVxP);

		// Person's counter
		JLabel lblCounterPopulation = new JLabel("0");
		lblCounterPopulation.setHorizontalAlignment(SwingConstants.CENTER);
		lblCounterPopulation.setFont(new Font("Dialog", Font.BOLD, 40));
		lblCounterPopulation.setBounds(15, 460, 200, 50);
		frmMainWindow.getContentPane().add(lblCounterPopulation);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(12, 550, 440, 2);
		frmMainWindow.getContentPane().add(separator_3);

		JSeparator separator_3_2 = new JSeparator();
		separator_3_2.setBounds(12, 680, 440, 2);
		frmMainWindow.getContentPane().add(separator_3_2);

		JSeparator separatorVerticalBottom = new JSeparator(SwingConstants.VERTICAL);
		separatorVerticalBottom.setBounds(225, 424, 2, 256);
		frmMainWindow.getContentPane().add(separatorVerticalBottom);

		// We make them invisible by default
		lblPopulation.setVisible(false);
		lblTotalVehicles.setVisible(false);
		lblCounterPlus18.setVisible(false);
		lblCounterTVehicles.setVisible(false);
		lblCounterVxP.setVisible(false);
		lblPlus18.setVisible(false);
		lblVxP.setVisible(false);
		lblCounterPopulation.setVisible(false);
		separator_3.setVisible(false);
		separator_3_2.setVisible(false);
		separatorVerticalBottom.setVisible(false);

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// With this events we avoid most of the possible layer 8 errors by restricting
		// the characters the user could type in the following textFields

		JComboBox comboPersons = new JComboBox();
		comboPersons.setBounds(253, 139, 188, 21);
		frmMainWindow.getContentPane().add(comboPersons);
		// invisible by default
		comboPersons.setVisible(false);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		////////////////////////////////////////////////////////////////////////////////////

		// This is where we actually start creating persons and adding them their
		// respective Vehicles

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
				lblCounterPopulation.setText(Integer.toString(arrPersons.size()));
				lblCounterPlus18.setText(Integer.toString(plus18Counter(arrPersons)));
			}
		});
		btnAddPerson.setBounds(40, 330, 145, 40);
		frmMainWindow.getContentPane().add(btnAddPerson);

		/*
		 * We make these labels, comboBoxes and textFields invisible until the user
		 * choose a vehicle type in comboVehicles
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
				// Fields cleansing

				String[] model = { "" };

				changeCombo(comboModel, model);
				comboColor.setSelectedIndex(0);
				comboBrand.setSelectedIndex(0);

				textKOP.setText(null);
				textVName.setText(null);
			}
		});
		comboVehicles.setBounds(40, 140, 114, 19);
		frmMainWindow.getContentPane().add(comboVehicles);

		comboVehicles.setVisible(false);

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		

		// The following code is for showing the user the list of registered people with
		// their respective Vehicles

		JCheckBox chckbxSoloPadres = new JCheckBox("Only parents");
		chckbxSoloPadres.setBackground(new Color(204, 153, 204));
		chckbxSoloPadres.setBounds(49, 436, 114, 21);
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
		btnShowPersons.setBounds(271, 433, 170, 19);
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
		btnAddVehicule.setBounds(40, 330, 145, 35);
		frmMainWindow.getContentPane().add(btnAddVehicule);

		// With this action listener we make sure the "Add vehicle" button is invisible
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
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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

				//We set the values of the stats
				lblCounterTVehicles.setText(Integer.toString(totalVehicles.size()));
				lblCounterVxP.setText(Integer.toString(totalVehicles.size()/arrPersons.size()));

			}
		});
		// invisible by default
		btnSave.setVisible(false);

		btnSave.setBounds(253, 330, 188, 35);
		frmMainWindow.getContentPane().add(btnSave);

		JButton btnChangeView = new JButton("VIEW STATS");
		btnChangeView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// We change what the user sees when pressing btnChangeView
				changeView(btnChangeView, chckbxSoloPadres, textAreaPersons, btnShowPersons, separatorVerticalBottom,
						lblSOP, lblPopulation, lblTotalVehicles, lblCounterPlus18, lblCounterTVehicles, lblCounterVxP,
						lblPlus18, lblVxP, lblCounterPopulation, separator_3, separator_3_2);

			}
		});
		btnChangeView.setBounds(302, 383, 139, 27);
		frmMainWindow.getContentPane().add(btnChangeView);

		JButton btnNext = new JButton("NEXT");
		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblSubTitle.setText("ADD VEHICLES!");

				changeRegistry( lblSubTitle,  lblIcon,  lblVehiculeName,  lblColor,  lbl1,  lbl2,
						 lblVCounter,  lblVehicles,  textAreaVehicles,  comboPersons,
						 comboBrand,  comboModel,  comboColor,  comboVehicles,
						 textVName,  btnNext,  dateChooser,  lblBirthDate,  lblChildAmount,
						 lblCountry,  lblName,  lblLName,  comboCountry,  btnAddVehicule,
						 btnAddPerson,  btnSave, lblRegisteredPersons);
			}
		});
		btnNext.setBounds(305, 65, 125, 21);
		frmMainWindow.getContentPane().add(btnNext);

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
			JButton btnShowPersons, JSeparator separatorVerticalBottom, JLabel lblSOP, JLabel lblPopulation,
			JLabel lblTotalVehicles, JLabel lblCounterPlus18, JLabel lblCounterTVehicles, JLabel lblCounterVxP,
			JLabel lblPlus18, JLabel lblVxP, JLabel lblCounterPopulation, JSeparator separator_3,
			JSeparator separator_3_2) {

		if (btnChangeView.getText().equals("VIEW STATS")) {
			// From Stats to Persons

			chckbxSoloPadres.setVisible(false);
			textAreaPersons.setVisible(false);
			btnShowPersons.setVisible(false);

			lblPopulation.setVisible(true);
			lblTotalVehicles.setVisible(true);
			lblCounterPlus18.setVisible(true);
			lblCounterTVehicles.setVisible(true);
			lblCounterVxP.setVisible(true);
			lblPlus18.setVisible(true);
			lblVxP.setVisible(true);
			lblCounterPopulation.setVisible(true);
			separator_3.setVisible(true);
			separator_3_2.setVisible(true);

			separatorVerticalBottom.setVisible(true);
			lblSOP.setText("STATS");
			btnChangeView.setText("VIEW PERSONS");
			
			
			
		} else {
			// From Stats to Persons

			chckbxSoloPadres.setVisible(true);
			textAreaPersons.setVisible(true);
			btnShowPersons.setVisible(true);
			separatorVerticalBottom.setVisible(false);
			lblPopulation.setVisible(false);
			lblTotalVehicles.setVisible(false);
			lblCounterPlus18.setVisible(false);
			lblCounterTVehicles.setVisible(false);
			lblCounterVxP.setVisible(false);
			lblPlus18.setVisible(false);
			lblVxP.setVisible(false);
			lblCounterPopulation.setVisible(false);
			separator_3.setVisible(false);
			separator_3_2.setVisible(false);
			separatorVerticalBottom.setVisible(false);

			lblSOP.setText("PERSONS");
			btnChangeView.setText("VIEW STATS");

		}

	}

	
	//We will use this method to change bewtween the person's section and the vehicle's section.
	public void changeRegistry(JLabel lblSubTitle, JLabel lblIcon, JLabel lblVehiculeName, JLabel lblColor, JLabel lbl1, JLabel lbl2,
			JLabel lblVCounter, JLabel lblVehicles, TextArea textAreaVehicles, JComboBox comboPersons,
			JComboBox comboBrand, JComboBox comboModel, JComboBox comboColor, JComboBox comboVehicles,
			JTextField textVName, JButton btnNext, JDateChooser dateChooser, JLabel lblBirthDate, JLabel lblChildAmount,
			JLabel lblCountry, JLabel lblName, JLabel lblLName, JComboBox comboCountry, JButton btnAddVehicule,
			JButton btnAddPerson, JButton btnSave, JLabel lblRegisteredPersons) {

		if (btnNext.getText().equals("NEXT")) {
			// From Persons to Vehicles

			comboVehicles.setVisible(true);
			//Combo reset
			comboVehicles.setModel(new DefaultComboBoxModel(new String[] { "None", "Car", "Motorcycle", "Boat", "Plane" }));
			
			//lblVehiculeName.setVisible(true);
			//lblColor.setVisible(true);
			//lbl1.setVisible(true);
			//lbl2.setVisible(true);
			//lblVCounter.setVisible(true);
			lblVehicles.setVisible(true);
			//comboBrand.setVisible(true);
			//comboModel.setVisible(true);
			//comboColor.setVisible(true);
			comboPersons.setVisible(true);
			btnAddVehicule.setVisible(true);
			btnSave.setVisible(true);
			textAreaVehicles.setVisible(true);
			lblRegisteredPersons.setVisible(true);
			
			//textVName.setVisible(true);
			//textKOP.setVisible(true);
			btnNext.setText("BACK");
			//////////////////////////////////////////////////////////////////////
			textChildren.setVisible(false);
			textLName.setVisible(false);
			textName.setVisible(false);
			dateChooser.setVisible(false);
			lblBirthDate.setVisible(false);
			lblChildAmount.setVisible(false);
			lblCountry.setVisible(false);
			lblName.setVisible(false);
			lblLName.setVisible(false);
			comboCountry.setVisible(false);
			btnAddPerson.setVisible(false);

			/////////////////////////////////////////////////////////////////
			Image img3 = new ImageIcon(this.getClass().getResource("/car.png")).getImage();
			lblIcon.setIcon(new ImageIcon(img3));
			
			////////////////////////////////////////////////////////////////
			lblSubTitle.setText("ADD VEHICLES!");
		} else {
			// From Persons to Vehicles

			
		
			///////////////////////////////////////////////////////////////////
			lblVehiculeName.setVisible(false);
			lblColor.setVisible(false);
			lbl1.setVisible(false);
			lbl2.setVisible(false);
			lblVCounter.setVisible(false);
			lblVehicles.setVisible(false);
			textAreaVehicles.setVisible(false);
			comboBrand.setVisible(false);
			comboModel.setVisible(false);
			comboColor.setVisible(false);
			comboVehicles.setVisible(false);
			comboPersons.setVisible(false);
			btnAddVehicule.setVisible(false);
			btnSave.setVisible(false);
			lblRegisteredPersons.setVisible(false);

			
			textVName.setVisible(false);
			textKOP.setVisible(false);
			comboVehicles.setVisible(false);
			/////////////////////////////////////

			textChildren.setVisible(true);
			textLName.setVisible(true);
			textName.setVisible(true);
			dateChooser.setVisible(true);
			lblBirthDate.setVisible(true);
			lblChildAmount.setVisible(true);
			lblCountry.setVisible(true);
			lblName.setVisible(true);
			lblLName.setVisible(true);
			comboCountry.setVisible(true);
			btnAddPerson.setVisible(true);

			btnNext.setText("NEXT");
			//////////////////////////////////////////////////////////////////////
			
			//Icon change
			Image img3 = new ImageIcon(this.getClass().getResource("/peopleMedium.png")).getImage();
			lblIcon.setIcon(new ImageIcon(img3));
			///////////////////////////////////////////////////////////////////////
			
			//Subtitle change
			lblSubTitle.setText("ADD PERSONS!");
			
			
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

		if (selectedOption.equals("Airbus") || selectedOption.equals("Boeing")) {
			type = "Plane";
		}

		if (selectedOption.equals("Bertram") || selectedOption.equals("Chaparral") || selectedOption.equals("Safran")) {
			type = "Boat";
		}

		if (selectedOption.equals("Benelli") || selectedOption.equals("Yumbo")
				|| selectedOption.equals("Harley Davidson") || selectedOption.equals("Yamaha")) {
			type = "Motorcycle";
		}

		if (selectedOption.equals("Tesla") || selectedOption.equals("Ford") || selectedOption.equals("Subaru")
				|| selectedOption.equals("Fiat")) {
			type = "Car";
		}

		return type;
	}

	// This method is for changing the options inside of comboModel
	public void changeModel(JComboBox comboBox, String selectedOption) {

		String type = vehicleType(selectedOption);

		// Plane
		if (type.equals("Plane")) {
			if (selectedOption.equals("Airbus")) {
				String[] model = { "", "A220", "A300", "A310", "A318" };
				changeCombo(comboBox, model);
			}

			if (selectedOption.equals("Boeing")) {
				String[] model = { "", "737", "747", "767", "777" };
				changeCombo(comboBox, model);
			}
		}

		// Boat
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

		// Car
		else if (type.equals("Car")) {
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
		// Motorcycle
		else if (type.equals("Motorcycle")) {
			if (selectedOption.equals("Benelli")) {
				String[] model = { "", "TRK502", "TNT150I", "LEONCINO", "TRK251" };
				changeCombo(comboBox, model);
			}

			if (selectedOption.equals("Yamaha")) {
				String[] model = { "", "Crux", "YBR-Z", "FZ-S FI", "MT-09 ABS" };
				changeCombo(comboBox, model);
			}

			if (selectedOption.equals("Yumbo")) {
				String[] model = { "", "GSIII", "GS-F", "PX 110", "Eco 70" };
				changeCombo(comboBox, model);
			}

			if (selectedOption.equals("Harley Davidson")) {
				String[] model = { "", "Street Bob", "Sporster Iron", "Street Glide", "Fat Boy" };
				changeCombo(comboBox, model);
			}

		}
	}
	
	public int plus18Counter(ArrayList<Person> arrPersons) {
		int counter = 0;
		for(Person p : arrPersons) {
			
			if((p.getAge()) >= 18) {
				counter++;
			}
		}		
		return counter;
	}
}
