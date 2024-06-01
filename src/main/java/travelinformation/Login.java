package travelinformation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    private JPanel panel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton loginButton, signupButton, forgotPasswordButton;
    String name=null;

    public Login() {
        setTitle("Login");
        setBackground(new Color(255, 255, 204));
        setBounds(550, 250, 700, 400);

        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        setContentPane(panel);
        panel.setLayout(null);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(124, 89, 95, 24);
        panel.add(usernameLabel);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(124, 124, 95, 24);
        panel.add(passwordLabel);

        textField = new JTextField();
        textField.setBounds(210, 93, 157, 20);
        panel.add(textField);

        passwordField = new JPasswordField();
        passwordField.setBounds(210, 128, 157, 20);
        panel.add(passwordField);

        ImageIcon loginIcon = new ImageIcon(getClass().getResource("/icons/login.png"));
        Image loginImage = loginIcon.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon loginImageIcon = new ImageIcon(loginImage);

        JLabel loginImageLabel = new JLabel(loginImageIcon);
        loginImageLabel.setBounds(480, 70, 150, 150);
        panel.add(loginImageLabel);

        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        loginButton.setForeground(new Color(46, 139, 87));
        loginButton.setBackground(new Color(176, 224, 230));
        loginButton.setBounds(149, 181, 113, 25);
        panel.add(loginButton);

        signupButton = new JButton("Sign Up");
        signupButton.addActionListener(this);
        signupButton.setForeground(new Color(139, 69, 19));
        signupButton.setBackground(new Color(255, 235, 205));
        signupButton.setBounds(289, 181, 113, 25);
        panel.add(signupButton);

        forgotPasswordButton = new JButton("Forgot Password");
        forgotPasswordButton.addActionListener(this);
        forgotPasswordButton.setForeground(new Color(205, 92, 92));
        forgotPasswordButton.setBackground(new Color(253, 245, 230));
        forgotPasswordButton.setBounds(199, 231, 179, 25);
        panel.add(forgotPasswordButton);

        JLabel troubleLoginLabel = new JLabel("Trouble in Login?");
        troubleLoginLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        troubleLoginLabel.setForeground(new Color(255, 0, 0));
        troubleLoginLabel.setBounds(70, 235, 110, 20);
        panel.add(troubleLoginLabel);

        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(255, 255, 204));
        panel2.setBounds(24, 40, 434, 263);
        panel.add(panel2);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == loginButton) {
            try {
                Conn con = new Conn();
                String sql = "select * from account where username=? and password=?";
                PreparedStatement st = con.c.prepareStatement(sql);

                // Set parameters for the prepared statement
                st.setString(1, textField.getText());
                st.setString(2, new String(passwordField.getPassword()));

                ResultSet rs = st.executeQuery();

                if (rs.next()) {
                    // If login successful, retrieve the name
                    String username = textField.getText();
                    String name = rs.getString("name");
                    this.setVisible(false);
                    new Loading(username, name).setVisible(true); // Pass the username and name to the Loading class
                } else {
                    // If login unsuccessful, show error message
                    JOptionPane.showMessageDialog(null, "Invalid Login or Password!");
                }
                // Close resources
                rs.close();
                st.close();
                con.c.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (ae.getSource() == signupButton) {
            setVisible(false);
            Signup su = new Signup();
            su.setVisible(true);
        } else if (ae.getSource() == forgotPasswordButton) {
            setVisible(false);
            ForgetPassword forgot = new ForgetPassword();
            forgot.setVisible(true);
        }
    }


    public static void main(String[] args) {
        new Login().setVisible(true);
    }
}
