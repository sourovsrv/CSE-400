import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;


public class FrameRoomInfo extends JFrame {

	private JPanel contentPane;
	private JTextField tfRoomId;
	private JTextField tfNmbrStdnts;
	private JRadioButton rdbtnRegular;
	private JRadioButton rdbtnLab;
	private final ButtonGroup buttonGroupRoomInfo = new ButtonGroup();
	private JButton btnsubmit;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameRoomInfo frame = new FrameRoomInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static boolean insert_data(String rid, int nmbr, String type){
		try{
			DB data=new DB();
			data.connectdb();
			data.st.executeUpdate("INSERT INTO RoomInfo(RoomID, NumberOfStudent, Type)" + " VALUES ('"+rid+"', '"+nmbr+"', '"+type+"')");
			return true;
		
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return false;
		}
	}

	/**
	 * Create the frame.
	 */
	public FrameRoomInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfRoomId = new JTextField();
		tfRoomId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfRoomId.setBounds(228, 11, 155, 25);
		contentPane.add(tfRoomId);
		tfRoomId.setColumns(10);
		
		JLabel lblRoomId = new JLabel("Room ID");
		lblRoomId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRoomId.setBounds(20, 11, 86, 25);
		contentPane.add(lblRoomId);
		
		tfNmbrStdnts = new JTextField();
		tfNmbrStdnts.setToolTipText("Only Number is valid");
		tfNmbrStdnts.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfNmbrStdnts.setBounds(228, 47, 148, 32);
		contentPane.add(tfNmbrStdnts);
		tfNmbrStdnts.setColumns(10);
		
		JLabel lblNumberOfStudents = new JLabel("Number of Students");
		lblNumberOfStudents.setToolTipText("How many student can sit on the classs");
		lblNumberOfStudents.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumberOfStudents.setBounds(20, 47, 139, 23);
		contentPane.add(lblNumberOfStudents);
		
		rdbtnRegular = new JRadioButton("Regular");
		rdbtnRegular.setSelected(true);
		buttonGroupRoomInfo.add(rdbtnRegular);
		rdbtnRegular.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnRegular.setBounds(429, 11, 200, 50);
		contentPane.add(rdbtnRegular);
		
		rdbtnLab = new JRadioButton("Lab");
		buttonGroupRoomInfo.add(rdbtnLab);
		rdbtnLab.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnLab.setBounds(429, 47, 200, 50);
		contentPane.add(rdbtnLab);
		
		JCheckBox checkBoxD1S1 = new JCheckBox("08.00-09.30");
	
		
		
		btnsubmit = new JButton("Submit");
		btnsubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String type="";
				int nmbr=0;
				try{

					nmbr = Integer.parseInt(tfNmbrStdnts.getText());
					//Setting type
					if(rdbtnRegular.isSelected()==true) type="Regular";
					else type="Lab";
					
					boolean nw=insert_data(tfRoomId.getText(),15,type);
					if(nw==true){
						JOptionPane.showMessageDialog(null, "Value Inserted");
					}
				}catch(Exception Enmbr){
					JOptionPane.showMessageDialog(null, "Invalid Input");
				}
			
			}
		});
		btnsubmit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnsubmit.setBounds(225, 288, 89, 23);
		contentPane.add(btnsubmit);
		
		
		
		if(checkBoxD1S1.isSelected()==true)
			System.out.println("Selected1");
	}
}
