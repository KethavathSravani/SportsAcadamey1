package SportsAcademyLoginPage;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
class SportsAcademyAWT extends Frame implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String Button = null;
	// Components for login and registration
    Label labelUsername, labelPassword, labelMessage;
    TextField textUsername, textPassword;
    Button buttonLogin, buttonRegister;
    HashMap<String, String> userDatabase;

    // Constructor to setup the GUI components
    public SportsAcademyAWT() {
        // Initialize the user database
        userDatabase = new HashMap<>();
        userDatabase.put("coach", "coach123");
        userDatabase.put("player1", "playerpass1");
        userDatabase.put("admin", "admin2024");

        // Set up the frame
        setLayout(new FlowLayout());

        // Username Label and TextField
        labelUsername = new Label("Username: ");
        add(labelUsername);
        textUsername = new TextField(20);
        add(textUsername);

        // Password Label and TextField (with masked input)
        labelPassword = new Label("Password: ");
        add(labelPassword);
        textPassword = new TextField(20);
        textPassword.setEchoChar('*'); // To mask password
        add(textPassword);

        // Buttons for login and register
        buttonLogin = new Button("Login");
        buttonRegister = new Button("Register");
        add(buttonLogin);
        add(buttonRegister);

        // Message label for showing login or registration status
        labelMessage = new Label();
        add(labelMessage);

        // Add action listeners to buttons
        buttonLogin.addActionListener(this);
        buttonRegister.addActionListener(this);

        // Frame properties
        setTitle("Sports Academy Login System");
        setSize(300, 200);
        setVisible(true);
        
        // Handle window closing
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }

    // Action handler for button clicks
    public void actionPerformed(ActionEvent ae) {
        String username = textUsername.getText();
        String password = textPassword.getText();

        if (ae.getSource() == Button) {
            // Handle login action
            if (login(username, password)) {
                labelMessage.setText("Login successful! Welcome, " + username);
                labelMessage.setForeground(Color.GREEN);
            } else {
                labelMessage.setText("Invalid username or password.");
                labelMessage.setForeground(Color.RED);
            }
        } else if (ae.getSource() == buttonRegister) {
            // Handle registration action
            if (register(username, password)) {
                labelMessage.setText("Registration successful for user: " + username);
                labelMessage.setForeground(Color.BLUE);
            } else {
                labelMessage.setText("Username already exists.");
                labelMessage.setForeground(Color.RED);
            }
        }
    }

    // Login method
    public boolean login(String username, String password) {
        if (userDatabase.containsKey(username)) {
            return userDatabase.get(username).equals(password);
        }
        return false;
    }

    // Registration method
    public boolean register(String username, String password) {
        if (userDatabase.containsKey(username)) {
            return false; // Username already exists
        }
        userDatabase.put(username, password);
        return true; // Registration successful
    }

    // Main method to launch the AWT application
    public static void main(String[] args) {
        new SportsAcademyAWT();
    }
}