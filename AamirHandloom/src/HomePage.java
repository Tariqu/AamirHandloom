import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.JTable;

public class HomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPurchase = new JButton("Purchase");
		btnPurchase.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnPurchase.setBounds(25, 41, 176, 47);
		contentPane.add(btnPurchase);
		
		JButton btnSales = new JButton("Sales");
		btnSales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSales.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnSales.setBounds(25, 120, 176, 47);
		contentPane.add(btnSales);
		
		JButton btnStock = new JButton("Stock");
		btnStock.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnStock.setBounds(25, 203, 176, 47);
		contentPane.add(btnStock);
		
		JButton btnCustomer = new JButton("Customer");
		btnCustomer.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnCustomer.setBounds(25, 284, 176, 47);
		contentPane.add(btnCustomer);
		
		JButton btnParty = new JButton("Party");
		btnParty.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnParty.setBounds(25, 364, 176, 47);
		contentPane.add(btnParty);
		
		JButton btnReport = new JButton("Report");
		btnReport.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnReport.setBounds(25, 448, 176, 47);
		contentPane.add(btnReport);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnLogout.setBounds(505, 11, 105, 35);
		contentPane.add(btnLogout);
	}
}
