import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Home {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 743, 389);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnRoomInfo = new JButton("Room Info");
		btnRoomInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameRoomInfo ri=new FrameRoomInfo();
				ri.setVisible(true);
				frame.dispose();
			}
		});
		btnRoomInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRoomInfo.setBounds(102, 128, 104, 23);
		frame.getContentPane().add(btnRoomInfo);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHome.setBounds(347, 39, 81, 23);
		frame.getContentPane().add(lblHome);
		
		JButton btnStudentInfo = new JButton("Student Info");
		btnStudentInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnStudentInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnStudentInfo.setBounds(507, 116, 120, 23);
		frame.getContentPane().add(btnStudentInfo);
		
		JButton btnCourseInfo = new JButton("Course Info");
		btnCourseInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCourseInfo.setBounds(102, 199, 131, 23);
		frame.getContentPane().add(btnCourseInfo);
		
		JButton btnRoutine = new JButton("Routine");
		btnRoutine.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRoutine.setBounds(507, 199, 120, 23);
		frame.getContentPane().add(btnRoutine);
	}
}
