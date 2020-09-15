package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout.Constraints;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import controller.Commands;
import controller.ControllerClient;
import utils.Constants;

public class JPButtonsAdmin extends JPanel{
	private JPHeadName jpHeadName;
	private JBBaseButton jBShowTeachers;
	private JBBaseButton jBShowCourse;
	private JBBaseButton jBShowStudents;
	private JBBaseButton jBShowSubjects;
	private JBBaseButton jBShowLogin;
	private JBBaseButton jBShowLogout;
	private JBBaseButton jBShowRegister;
	private JPSearch jpSearch;
	
	public JPButtonsAdmin(ControllerClient controller) {
		super();
		this.setSize(1000, 200);
		this.setBackground(Constants.BASE_BLUE);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, Constants.BORDER_THICKNESS));
		this.setLayout(new BorderLayout());
		init(controller);
	}

	private void init(ControllerClient controller) {
		this.setBorder(BorderFactory.createEmptyBorder(38, 6, 38, 22));
		this.jpHeadName = new JPHeadName("Emerson Vargas", "EStudiante");
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.jpSearch = new JPSearch(controller);
		
		this.jBShowCourse = new JBBaseButton(Constants.SHOW_COURSES_ICON, Constants.SHOW_COURSES_ICON_PRESS, controller, Commands.AC_SHOW_COURSES_BUTTON);
		this.jBShowStudents = new JBBaseButton(Constants.SHOW_STUDENTS_ICON, Constants.SHOW_STUDENTS_ICON_PRESS, controller, Commands.AC_SHOW_STUDENTS_BUTTON);
		this.jBShowSubjects = new JBBaseButton(Constants.SHOW_SUBJECTS_ICON, Constants.SHOW_SUBJECTS_ICON_PRESS, controller, Commands.AC_SHOW_SUBJECTS_BUTTON);
		this.jBShowTeachers = new JBBaseButton(Constants.SHOW_TEACHERS_ICON, Constants.SHOW_TEACHERS_ICON_PRESS, controller, Commands.AC_SHOW_TEACHERS_BUTTON);
		this.jBShowLogin = new JBBaseButton(Constants.SHOW_LOGIN_ICON, Constants.SHOW_LOGIN_ICON_PRESS, controller, Commands.AC_SHOW_LOGIN_BUTTON);
		this.jBShowLogout = new JBBaseButton(Constants.SHOW_LOGOUT_ICON, Constants.SHOW_LOGOUT_ICON_PRESS, controller, Commands.AC_SHOW_LOGOUT_BUTTON);
		this.jBShowRegister = new JBBaseButton(Constants.SHOW_REGISTER_USER_ICON, Constants.SHOW_REGISTER_USER_ICON_PRESS, controller, Commands.AC_SHOW_REGISTER_BUTTON);
		
		this.add(jpHeadName, new FlowLayout(FlowLayout.LEFT, 10, 20));
		this.add(jpSearch, new FlowLayout(FlowLayout.CENTER, 20, 0));
		this.add(jBShowTeachers, new FlowLayout(FlowLayout.RIGHT, 0, 0));
		this.add(jBShowSubjects, new FlowLayout(FlowLayout.RIGHT, 0, 0));
		this.add(jBShowCourse, new FlowLayout(FlowLayout.RIGHT, 0, 0));
		this.add(jBShowStudents, new FlowLayout(FlowLayout.RIGHT, 0, 0));
		this.add(jBShowLogin, new FlowLayout(FlowLayout.RIGHT, 0, 0));
		this.add(jBShowRegister, new FlowLayout(FlowLayout.RIGHT, 0, 0));
		this.add(jBShowLogout, new FlowLayout(FlowLayout.RIGHT, 0, 0));
		
		this.setVisible(true);		
	}
	
	public String captureSearchText() {
		return jpSearch.captureText();
	}
	
	
	 public static void main(String[] args) throws FileNotFoundException, IOException {
		JFrame frame = new JFrame();
		frame.add(new JPButtonsAdmin(new ControllerClient()));
		frame.setVisible(true);
		frame.setSize(1500, 200);
	}
	 
	 
	
	
	

}
