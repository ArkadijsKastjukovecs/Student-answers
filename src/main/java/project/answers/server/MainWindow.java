package project.answers.server;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import project.answers.Server;
import project.answers.tests.Test;

public class MainWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5532796858471663065L;
	private JTextField txtActiveTest;
	private JList<Test> list;

	@SuppressWarnings("unchecked")
	public MainWindow() {

		JButton btnCloseProgramm = new JButton("Close programm");
		btnCloseProgramm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Server.testController.saveTests();
				System.exit(0);
			}
		});
		getContentPane().add(btnCloseProgramm, BorderLayout.SOUTH);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		setTitle("Student Answers");
		txtActiveTest = new JTextField();
		txtActiveTest.setEditable(false);
		txtActiveTest.setHorizontalAlignment(JTextField.CENTER);
		txtActiveTest.setText("Active test: " + null);
		panel.add(txtActiveTest, BorderLayout.NORTH);
		txtActiveTest.setColumns(10);

		list = new JList(Server.testController.showAllTests().toArray());
		JScrollPane scrollPane1 = new JScrollPane(list);
		panel.add(scrollPane1, BorderLayout.CENTER);
	    MouseListener mouseListener = new MouseAdapter() {
	        public void mouseClicked(MouseEvent mouseEvent) {
	          JList<Test> theList = (JList<Test>) mouseEvent.getSource();
	          if (mouseEvent.getClickCount() == 2) {
	            int index = theList.locationToIndex(mouseEvent.getPoint());
	            if (index >= 0) {
	              Test o = theList.getModel().getElementAt(index);
	              Server.testController.SetActiveTest(o);
	            }
	          }
	        }
	      };
	      list.addMouseListener(mouseListener);
		setSize(392, 373);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void changeActiveTest(Test test) {
		txtActiveTest.setText("Active test: " + test);
	}

}
