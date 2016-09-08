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


public class FrameRoomInfo extends JFrame {

	private JPanel contentPane;
	private JTextField tfRoomId;
	private JTextField tfNmbrStdnts;
	private JRadioButton rdbtnRegular;
	private JRadioButton rdbtnLab;
	private final ButtonGroup buttonGroupRoomInfo = new ButtonGroup();
	private JButton btnsubmit;

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
		tfRoomId.setBounds(228, 51, 155, 25);
		contentPane.add(tfRoomId);
		tfRoomId.setColumns(10);
		
		JLabel lblRoomId = new JLabel("Room ID");
		lblRoomId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRoomId.setBounds(20, 57, 86, 25);
		contentPane.add(lblRoomId);
		
		tfNmbrStdnts = new JTextField();
		tfNmbrStdnts.setToolTipText("Only Number is valid");
		tfNmbrStdnts.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfNmbrStdnts.setBounds(228, 121, 148, 32);
		contentPane.add(tfNmbrStdnts);
		tfNmbrStdnts.setColumns(10);
		
		JLabel lblNumberOfStudents = new JLabel("Number of Students");
		lblNumberOfStudents.setToolTipText("How many student can sit on the classs");
		lblNumberOfStudents.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumberOfStudents.setBounds(20, 124, 139, 23);
		contentPane.add(lblNumberOfStudents);
		
		rdbtnRegular = new JRadioButton("Regular");
		rdbtnRegular.setSelected(true);
		buttonGroupRoomInfo.add(rdbtnRegular);
		rdbtnRegular.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnRegular.setBounds(51, 201, 200, 50);
		contentPane.add(rdbtnRegular);
		
		rdbtnLab = new JRadioButton("Lab");
		buttonGroupRoomInfo.add(rdbtnLab);
		rdbtnLab.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnLab.setBounds(292, 201, 200, 50);
		contentPane.add(rdbtnLab);
		
		
		btnsubmit = new JButton("Submit");
		btnsubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int nmbr=0;
				try{
					
					nmbr = Integer.parseInt(tfNmbrStdnts.getText());
				}catch(Exception Enmbr){
					JOptionPane.showMessageDialog(null, "Invalid Input");
				}
			
			}
		});
		btnsubmit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnsubmit.setBounds(225, 288, 89, 23);
		contentPane.add(btnsubmit);
	}
}
