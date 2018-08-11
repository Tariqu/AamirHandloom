import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblUserName;
	private JLabel lblPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginPage() {
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("Aamir Handloom");
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 295, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 16));
		textField.setBounds(51, 95, 180, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblLoginPage = new JLabel("Login Page");
		lblLoginPage.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 26));
		lblLoginPage.setBounds(70, 11, 144, 56);
		contentPane.add(lblLoginPage);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.BOLD, 16));
		passwordField.setColumns(10);
		passwordField.setBounds(51, 154, 180, 33);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection conn=Conn.MyConn();
					Statement stmt=conn.createStatement();
					String sql="Select * from tbLogin where UserName='"+textField.getText()+"' and Password='"+passwordField.getText().toString()+"'";
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "Login Sucessfully...");
						dispose();
						new HomePage().setVisible(true);
						}
					else
						JOptionPane.showMessageDialog(null, "Incorrect username and Password...");
					conn.close();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		btnLogin.setBounds(142, 209, 89, 31);
		contentPane.add(btnLogin);
		
		lblUserName = new JLabel("User Name");
		lblUserName.setBounds(51, 80, 89, 14);
		contentPane.add(lblUserName);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(51, 139, 89, 14);
		contentPane.add(lblPassword);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textField, passwordField, btnLogin}));
	}
}
