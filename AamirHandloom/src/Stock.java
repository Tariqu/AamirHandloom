import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Stock extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Item_ID;
	private JTextField Item_Name;
	private JTextField textField_2;
	private JTextField textField_3;
	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stock frame = new Stock();
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
	public Stock() {
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setHorizontalAlignment(SwingConstants.CENTER);
		lblStock.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblStock.setBounds(150, 26, 186, 56);
		contentPane.add(lblStock);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 107, 460, 318);
		contentPane.add(tabbedPane);
		
		JPanel addNewItem = new JPanel();
		tabbedPane.addTab("Add New Item", null, addNewItem, null);
		addNewItem.setLayout(null);
		
		JLabel lblItemId = new JLabel("Item ID ");
		lblItemId.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		lblItemId.setBounds(32, 45, 79, 28);
		addNewItem.add(lblItemId);
		
		JLabel lblItemName = new JLabel("Item Name");
		lblItemName.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		lblItemName.setBounds(32, 102, 79, 28);
		addNewItem.add(lblItemName);
		
		Item_ID = new JTextField();
		Item_ID.setEnabled(false);
		Item_ID.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		Item_ID.setBounds(152, 45, 141, 26);
		addNewItem.add(Item_ID);
		Item_ID.setColumns(10);
		
		Item_Name = new JTextField();
		Item_Name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Item_Name.setColumns(10);
		Item_Name.setBounds(152, 105, 141, 26);
		addNewItem.add(Item_Name);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//int item_id=Integer.parseInt(Item_ID.getText());
				String item_name=Item_Name.getText().toString();
				select(addNewItem);
				JOptionPane.showMessageDialog(addNewItem, "Till Now");
			}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		btnAdd.setBounds(204, 155, 89, 23);
		addNewItem.add(btnAdd);
		
		JPanel updateItem = new JPanel();
		tabbedPane.addTab("Update Item", null, updateItem, null);
		updateItem.setLayout(null);
		
		JLabel lblSelectItemId = new JLabel("Select Item ID ");
		lblSelectItemId.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		lblSelectItemId.setBounds(38, 39, 102, 28);
		updateItem.add(lblSelectItemId);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(173, 45, 141, 20);
		updateItem.add(comboBox);
		
		JLabel label = new JLabel("Item Name");
		label.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		label.setBounds(38, 96, 79, 28);
		updateItem.add(label);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(173, 98, 141, 26);
		updateItem.add(textField_2);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		btnUpdate.setBounds(225, 153, 89, 23);
		updateItem.add(btnUpdate);
		
		JPanel deleteItem = new JPanel();
		tabbedPane.addTab("Delete Item", null, deleteItem, null);
		deleteItem.setLayout(null);
		
		JLabel label_1 = new JLabel("Select Item ID ");
		label_1.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		label_1.setBounds(41, 46, 102, 28);
		deleteItem.add(label_1);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(176, 52, 141, 20);
		deleteItem.add(comboBox_1);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(176, 105, 141, 26);
		deleteItem.add(textField_3);
		
		JLabel label_2 = new JLabel("Item Name");
		label_2.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		label_2.setBounds(41, 103, 79, 28);
		deleteItem.add(label_2);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		btnDelete.setBounds(228, 160, 89, 23);
		deleteItem.add(btnDelete);
	}
	void insert(JPanel addNewItem,int item_id,String item_name) {
		
		try {
			conn=Conn.MyConn();
			Statement stmt=conn.createStatement();
			JOptionPane.showMessageDialog(addNewItem, "Data Inserted Successfully...");
			String sql="insert into tbstock(`Item_ID`,`Item_Name`) values("+item_id+",'"+item_name+"')";
			int a=stmt.executeUpdate(sql);
			if(a!=0)
				JOptionPane.showMessageDialog(addNewItem, "Data Inserted Successfully...");
			else
				
			conn.close();
		}catch(Exception exp) {
			System.out.println(exp);
			try{conn.close();}catch(Exception e1) {}
		}
	}
void select(JPanel addNewItem) {
		
		try {
			conn=Conn.MyConn();
			Statement stmt=conn.createStatement();
			String sql="select Item_ID from tbstock";
			rs=stmt.executeQuery(sql);
			if(rs.last()) {
				int a=rs.getInt("Item_id");
				JOptionPane.showMessageDialog(addNewItem, a+"Hello");
			}
			else
				JOptionPane.showMessageDialog(addNewItem, "Hello");
			conn.close();
		}catch(Exception exp) {
			System.out.println(exp);
			try{conn.close();}catch(Exception e1) {}
		}
	}
}
