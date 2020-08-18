package com.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.StringTokenizer;

/**
 * Houses GUI and the actual execution of the project
 * @author Deron Washington II
 * Last Update: 11/6/19 at 11:00pm
 *
 */
public class Window extends JFrame
{

	/**
	 * Performs the actual execution of the program
	 * @param args necessary to run program
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Window w = new Window();

	}

	/**
	 * Default Constructor for the Window Class
	 * to setup the window
	 */
	public Window()
	{
		setBounds(500,200, 450, 600);
		setTitle("Task List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new Panel());
		setVisible(true);
		setResizable(false);

	}

	/**
	 * Inner class to create the details of the interface and
	 * govern how the user is able to interact with the GUI
	 * @author Deron Washington II
	 * Last Update: 11/6/19 at 11:48pm
	 *
	 */
	public class Panel extends JPanel implements ActionListener
	{
		// PRIVATE MEMBERS

		/**
		 * List of Tasks 
		 */
		private TaskList Tasks;
		/**
		 * LABELS w/names corresponding to their displayed
		 * text in the GUI
		 */
		private JLabel lbl_TasksLeft, lbl_CurrTask,
		lbl_CompleteBy, lbl_AddTask, lbl_Date, lbl_Time, lbl_Task;


		/**
		 * TEXT FIELDS w/names corresponding to the data that 
		 * we are seeking input about
		 */
		private JTextField tf_TasksLeft, tf_CurrTask,
		tf_CompleteBy, tf_Month, tf_Day, tf_Year,
		tf_Hour, tf_Min, tf_Task;


		/**
		 * BUTTONS w/names corresponding to the text that they
		 * are labeled with
		 */
		private JButton btn_Completed, btn_Postpone, 
		btn_Submit, btn_Quit;

		/**
		 * Method to determine if input is numeric
		 * @param str = input string
		 * @return true if all chars are numbers
		 * 			     false otherwise
		 */
		public boolean isNumeric(String str)
		{
			for (char c : str.toCharArray())
			{
				if (!Character.isDigit(c)) return false;
			}
			return true;
		}

		/**
		 * Default Constructor to initialize and provide functionality
		 * to all the private members above
		 */
		public Panel()
		{
			// Instantiate Tasklist and populate the heap/queue
			Tasks = new TaskList();
			Tasks.readFile();

			String date = "00/00/0000 00:00";
			if (Tasks.isEmpty() == false)
			{
				StringTokenizer parseDate = new StringTokenizer(Tasks.getCurrTask().toString());
				parseDate.nextToken(",");
				date = parseDate.nextToken();
			}

			// everything laid out using setBounds
			setLayout(null);

			// ------------------TASKS LEFT----------------------
			// Label
			lbl_TasksLeft = new JLabel("Tasks Left:");
			lbl_TasksLeft.setBounds(50, 30, 100, 30);
			add(lbl_TasksLeft);

			// Text field
			if (Tasks.isEmpty() == true)
				tf_TasksLeft = new JTextField("0");
			else
				tf_TasksLeft = new JTextField(Tasks.getNumOfTasks().toString());

			tf_TasksLeft.setEditable(false);
			tf_TasksLeft.setBounds(50, 60, 65, 25);
			add(tf_TasksLeft);

			// ---------------CURRENT TASK--------------------
			// Label
			lbl_CurrTask = new JLabel("Current Task:");
			lbl_CurrTask.setBounds(50, 90, 100, 25);
			add(lbl_CurrTask);

			// Text field
			if (Tasks.isEmpty() == true)
				tf_CurrTask = new JTextField("None");
			else
				tf_CurrTask = new JTextField(Tasks.getCurrTask().getName());

			tf_CurrTask.setEditable(false);
			tf_CurrTask.setBounds(50, 120, 350, 25);
			add(tf_CurrTask);

			// ---------------COMPLETE BY---------------------
			// Label
			lbl_CompleteBy = new JLabel("Complete By:");
			lbl_CompleteBy.setBounds(50, 150, 100, 25);
			add(lbl_CompleteBy);

			// Text field
			tf_CompleteBy = new JTextField(date);
			tf_CompleteBy.setEditable(false);
			tf_CompleteBy.setBounds(50, 180, 350, 25);
			add(tf_CompleteBy);


			// ---------------BTN_COMPLETED-----------------
			// Button
			btn_Completed = new JButton("Completed!");
			btn_Completed.setBounds(90, 230, 100, 25);
			btn_Completed.addActionListener(this);

			// disable button if tasks is empty
			if (Tasks.isEmpty() == true)
				btn_Completed.setEnabled(false);

			add(btn_Completed);


			// ---------------BTN_POSTPONE-------------------
			// Button
			btn_Postpone = new JButton("Postpone");
			btn_Postpone.setBounds(250, 230, 100, 25);
			btn_Postpone.addActionListener(this);

			// disable button if tasks is empty
			if (Tasks.isEmpty() == true)
				btn_Postpone.setText("Add Task");

			add(btn_Postpone);

			// -------------------ADD TASK-----------------------
			// Label
			lbl_AddTask = new JLabel("Add Task:");
			lbl_AddTask.setBounds(50, 270, 100, 25);
			add(lbl_AddTask);

			// ---------------------DATE----------------------------
			// Label
			lbl_Date = new JLabel("Date:");
			lbl_Date.setBounds(65, 310, 60, 25);
			add(lbl_Date);

			// Text Field for Month
			tf_Month = new JTextField("MM");
			tf_Month.setBounds(100, 310, 50, 25);
			add(tf_Month);

			// Text Field for Day
			tf_Day = new JTextField("DD");
			tf_Day.setBounds(160, 310, 50, 25);
			add(tf_Day);

			// Text Field for Year
			tf_Year = new JTextField("YYYY");
			tf_Year.setBounds(220, 310, 60, 25);
			add(tf_Year);

			// ------------------ TIME -----------------------
			// Label
			lbl_Time = new JLabel("Time:");
			lbl_Time.setBounds(65, 340, 60, 25);
			add(lbl_Time);

			// Text Field for Hour
			tf_Hour = new JTextField("HH");
			tf_Hour.setBounds(100, 340, 50, 25);
			add(tf_Hour);

			// Text Field for Minute
			tf_Min = new JTextField("MM");
			tf_Min.setBounds(160, 340, 50, 25);
			add(tf_Min);

			// ------------------- TASK ----------------------
			// Label
			lbl_Task = new JLabel("Task:");
			lbl_Task.setBounds(65, 390, 60, 25);
			add(lbl_Task);

			// Text Field
			tf_Task = new JTextField("New Task");
			tf_Task.setBounds(100, 390, 250, 25);
			add(tf_Task);

			// ----------------- BTN_SUBMIT ----------------------
			// Submit Button
			btn_Submit = new JButton("Submit");
			btn_Submit.setBounds(250, 460, 100, 25);
			btn_Submit.addActionListener(this);
			add(btn_Submit);

			// ----------------- BTN_QUIT -------------------------
			// Button
			btn_Quit = new JButton("Quit");
			btn_Quit.setBounds(300, 515, 100, 25);
			btn_Quit.addActionListener(this);
			add(btn_Quit);


		}

		/**
		 * Method to capture the actions performed 
		 * so that the user can interact with the GUI 
		 * in the way we desire them to 
		 */
		@Override
		public void actionPerformed(ActionEvent e)
		{
			// OPTION 1
			if (e.getSource() == btn_Completed ) 
			{
				// remove task from heap
				if (Tasks.taskCompleted()!= (Task) null)
				{
					if (Tasks.isEmpty() == true) 
					{
						tf_TasksLeft.setText("0");
						tf_CurrTask.setText("None");
						tf_CompleteBy.setText("00/00/0000 00:00");
						btn_Completed.setEnabled(false);
						return;
					}

					// update tasks left, current task, and complete by
					tf_TasksLeft.setText(Tasks.getNumOfTasks().toString());
					tf_CurrTask.setText(Tasks.getCurrTask().getName());

					// split and just get the date
					StringTokenizer parseDate = new StringTokenizer(Tasks.getCurrTask().toString());
					parseDate.nextToken(",");
					String date = parseDate.nextToken();

					tf_CompleteBy.setText(date);
				}

				else if (Tasks.isEmpty() == true) 
				{
					tf_TasksLeft.setText("0");
					tf_CurrTask.setText("None");
					tf_CompleteBy.setText("00/00/0000 00:00");
					btn_Completed.setEnabled(false);
					return;
				}
			}

			// OPTION 2
			else if (e.getSource() == btn_Postpone) 
			{
				if (Tasks.isEmpty() == false)
				{

					if (btn_Postpone.getText().equals("Postpone" ))
					{
						// toggle to Postpone Task
						lbl_AddTask.setText("Postpone Task");

						// initialize postpone tasks date and time fields to that of current task
						StringTokenizer parseDate = new StringTokenizer(Tasks.getCurrTask().toString());
						parseDate.nextToken(",");
						tf_Month.setText(parseDate.nextToken("/").substring(1));
						tf_Day.setText(parseDate.nextToken());
						tf_Year.setText(parseDate.nextToken(" ").substring(1));
						tf_Hour.setText(parseDate.nextToken(":").substring(1));
						tf_Min.setText(parseDate.nextToken());
						lbl_Task.setVisible(false);
						tf_Task.setVisible(false);
						btn_Postpone.setText("Add Task");

					}
					else if (btn_Postpone.getText().equals("Add Task"))
					{
						// toggle to Add Task
						lbl_AddTask.setText("Add Task");

						// initialize postpone tasks date and time fields to that of current task
						tf_Month.setText("MM");
						tf_Day.setText("DD");
						tf_Year.setText("YYYY");
						tf_Hour.setText("HH");
						tf_Min.setText("MM");
						lbl_Task.setVisible(true);
						tf_Task.setVisible(true);
						tf_Task.setText("New Task");
						btn_Postpone.setText("Postpone");


					}
				} 
			}

			// OPTION 3
			else if (e.getSource() == btn_Submit)
			{
				// if the btn_Postpone's text is Postpone 
				// and click submit means you are adding task
				if (btn_Postpone.getText().equals("Postpone") || Tasks.isEmpty())
				{
					// INSERT DATA INPUT
					if (isNumeric(tf_Year.getText()) == true
							&& isNumeric(tf_Month.getText()) == true
							&& isNumeric(tf_Day.getText()) == true
							&& isNumeric(tf_Hour.getText()) == true
							&& isNumeric(tf_Min.getText()))
					{

						// get date for task you are adding
						Calendar c = Calendar.getInstance();
						c.set(Integer.parseInt(tf_Year.getText()), Integer.parseInt(tf_Month.getText()) - 1,
								Integer.parseInt(tf_Day.getText()), Integer.parseInt(tf_Hour.getText()), 
								Integer.parseInt(tf_Min.getText()));

						Task t = new Task(tf_Task.getText(), c.getTime());
						Tasks.addTask(t);
						btn_Completed.setEnabled(true);

						// update GUI
						tf_TasksLeft.setText(Tasks.getNumOfTasks().toString());
						tf_CurrTask.setText(Tasks.getCurrTask().getName());

						StringTokenizer parseDate = new StringTokenizer(Tasks.getCurrTask().toString());
						parseDate.nextToken(",");
						String date = parseDate.nextToken();
						tf_CompleteBy.setText(date);

						// reset date, time and task text fields
						tf_Month.setText("MM");
						tf_Day.setText("DD");
						tf_Year.setText("YYYY");
						tf_Hour.setText("HH");
						tf_Min.setText("MM");
						tf_Task.setText("New Task");
					}

					else
					{
						JOptionPane.showMessageDialog(this, "All fields for Add Task must be numeric. "
								+ "Input all numeric data and try again.", "Error", 
								JOptionPane.ERROR_MESSAGE);
						return;
					}
				}

				// if the btn_Postpone's text is Add Task
				// and click submit means you are postponing task
				else if (btn_Postpone.getText().equals("Add Task"))
				{
					// INSERT DATA INPUT
					if (isNumeric(tf_Year.getText()) == true
							&& isNumeric(tf_Month.getText()) == true
							&& isNumeric(tf_Day.getText()) == true
							&& isNumeric(tf_Hour.getText()) == true
							&& isNumeric(tf_Min.getText()))
					{

						// get date to postpone task
						Calendar c = Calendar.getInstance();
						c.set(Integer.parseInt(tf_Year.getText()), Integer.parseInt(tf_Month.getText()) - 1,
								Integer.parseInt(tf_Day.getText()), Integer.parseInt(tf_Hour.getText()), 
								Integer.parseInt(tf_Min.getText()));

						// if current task date is before the postpone date
						if (Tasks.getCurrTask().getDate().before(c.getTime()) == true)
							Tasks.postponeTask(c.getTime());

						else if (Tasks.getCurrTask().getDate().before(c.getTime()) == false
								|| Tasks.getCurrTask().getDate().equals(c.getTime()) == true)
						{
							JOptionPane.showMessageDialog(this, "You can't postpone"
									+ " a task to a previous date or to the same date. Try setting the postpone date after it's current date. "
									, "Error",	JOptionPane.ERROR_MESSAGE);
							return;
						}

						// update GUI
						StringTokenizer parseDate = new StringTokenizer(Tasks.getCurrTask().toString());
						parseDate.nextToken(",");
						String date = parseDate.nextToken();
						tf_CompleteBy.setText(date);

						// toggle back to Add Task
						lbl_AddTask.setText("Add Task");

						// initialize postpone tasks date and time fields to that of current task
						tf_Month.setText("MM");
						tf_Day.setText("DD");
						tf_Year.setText("YYYY");
						tf_Hour.setText("HH");
						tf_Min.setText("MM");
						lbl_Task.setVisible(true);
						tf_Task.setVisible(true);
						tf_Task.setText("New Task");
						btn_Postpone.setText("Postpone");
					}

					else
					{
						JOptionPane.showMessageDialog(this, "All fields for Add Task must be numeric. "
								+ "Input all numeric data and try again.", "Error", 
								JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
			}
			// OPTION 4
			else if (e.getSource() == btn_Quit)
			{
				Tasks.quit();
				System.exit(0);

			}

		} // end action performed
	} // end panel class
} // end window class


