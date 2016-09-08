import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class FrameCI extends JFrame {

	private JPanel contentpane;
	private JTextField tfCID;
	private JTextField tfTID;
	private JTextField tfSPW;
	private JTextField tfType;
	private JTextField tfBatch;
	private JTable table;
	private Connection connect =null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameCI frame = new FrameCI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//Import Courses from Student info database
	private void insertfromstudent()
	{
		
		try {
			//String query = "select DISTINCT CourseID from StudentInfo where NOT EXISTS( SELECT * FROM CourseInfo WHERE StudentInfo.CourseID = CourseInfo.CourseID )";
			String query = "select DISTINCT CourseID from StudentInfo";
			String query2 = "insert into CourseInfo (CourseID) values(?)";
			PreparedStatement pst = connect.prepareStatement(query);
			PreparedStatement pst2 = connect.prepareStatement(query2);
			ResultSet rs= pst.executeQuery();
			while(rs.next()){
				pst2.setString(1, rs.getString(1));
				pst2.execute();
				System.out.println(rs.getString(1));
			}
			pst.close();
			pst2.close();
			JOptionPane.showMessageDialog(null, "Inserted Sucesssfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
		
		
	}
	
	

	/**
	 * Create the frame.
	 */
	public FrameCI() {
		connect = DB.connectdb();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 839, 471);
		contentpane = new JPanel();
		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentpane);
		contentpane.setLayout(null);
		
		JLabel lblCourseInfo = new JLabel("Course Info");
		lblCourseInfo.setForeground(Color.BLUE);
		lblCourseInfo.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblCourseInfo.setBounds(269, 11, 82, 24);
		contentpane.add(lblCourseInfo);
		
		JLabel lblCID = new JLabel("Course ID");
		lblCID.setBounds(26, 109, 72, 17);
		contentpane.add(lblCID);
		
		tfCID = new JTextField();
		tfCID.setBounds(147, 107, 86, 20);
		contentpane.add(tfCID);
		tfCID.setColumns(10);
		
		JLabel lblTeacherID = new JLabel("Teacher ID");
		lblTeacherID.setBounds(26, 157, 72, 17);
		contentpane.add(lblTeacherID);
		
		tfTID = new JTextField();
		tfTID.setColumns(10);
		tfTID.setBounds(147, 155, 86, 20);
		contentpane.add(tfTID);
		
		JLabel lblSlotPerWeek = new JLabel("Slot Per Week");
		lblSlotPerWeek.setBounds(26, 221, 82, 24);
		contentpane.add(lblSlotPerWeek);
		
		tfSPW = new JTextField();
		tfSPW.setBounds(147, 223, 86, 20);
		contentpane.add(tfSPW);
		tfSPW.setColumns(10);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(26, 291, 46, 14);
		contentpane.add(lblType);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(65, 375, 89, 23);
		contentpane.add(btnSubmit);
		
		tfType = new JTextField();
		tfType.setToolTipText("Theory/Lab");
		tfType.setBounds(147, 288, 86, 20);
		contentpane.add(tfType);
		tfType.setColumns(10);
		
		JLabel lblBatch = new JLabel("Batch");
		lblBatch.setBounds(26, 326, 53, 24);
		contentpane.add(lblBatch);
		
		tfBatch = new JTextField();
		tfBatch.setBounds(147, 319, 86, 20);
		contentpane.add(tfBatch);
		tfBatch.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(254, 68, 540, 353);
		contentpane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnImportFromStudentinfo = new JButton("Import From StudentInfo");
		btnImportFromStudentinfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				insertfromstudent();
				
			}
		});
		btnImportFromStudentinfo.setBounds(515, 36, 223, 23);
		contentpane.add(btnImportFromStudentinfo);
	}
}
