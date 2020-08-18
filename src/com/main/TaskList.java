package com.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Class to hold a list of tasks and process
 * them accordingly
 * @author Deron Washington II
 * Last updated at 11/2/19 at 1:00am
 *
 */
public class TaskList
{
	// private member variables
	/** holds a list of tasks*/
	private Heap<Task> toDo;

	// public member functions

	/**
	 * Default Constructor
	 */
	public TaskList()
	{
		toDo = new Heap<Task>();
	}

	/**
	 * Parameterized Constructor
	 * @param _toDo is the queue to start the this 
	 * object with
	 */
	public TaskList(Heap<Task> _toDo)
	{
		toDo = _toDo;
	}

	/**
	 * Determines if the Heap/Queue is empty or not
	 * @return 
	 * 				= true if Heap is empty
	 * 				= false otherwise
	 */
	public boolean isEmpty()
	{
		return toDo.isEmpty();
	}

	/**
	 * Reads file contents and manipulates data to occupy
	 * the toDo queue private member variable
	 */
	public void readFile()
	{
		// open file
		File f = new File("database.txt");
		try
		{
			Scanner read = new Scanner(f);
			Date dateTemp = new Date();

			// holds the temporary values from the file
			String tempName = "";
			String tempDate = "";
			String tempTime = "";

			// holds output from one line of the file
			String oneLine = ""; 

			// create task object
			Task t = new Task(oneLine, dateTemp);

			// read each line, create a corresponding Task and add to Queue 
			while(read.hasNext())
			{
				oneLine = read.nextLine();

				String[] x = oneLine.split(",");
				tempName = x[0];
				oneLine = x[1];

				x = oneLine.split(" ");
				tempDate = x[0];
				tempTime = x[1];

				Calendar now = Calendar.getInstance();
				String[] Date = tempDate.split("/");
				String[] Time = tempTime.split(":");



				now.set(Integer.parseInt(Date[2]), Integer.parseInt(Date[0]) - 1, Integer.parseInt(Date[1]),
						Integer.parseInt(Time[0]), Integer.parseInt(Time[1]));

				// create the new Task and add it to the Queue
				t = new Task(tempName, now.getTime());
				toDo.addItem(t);
				tempName = "";
				tempDate = "";
				tempTime = "";

			}	
		} catch (FileNotFoundException e)
		{
			System.out.println("\n\nThe file could not be found and thus couldn't be opened.");
		} 
	}


	/**
	 * getter method to return number of remaining tasks
	 * in the queue
	 * @return size of queue of tasks private member variable
	 */
	public Integer getNumOfTasks()
	{
		return toDo.size();
	}

	/**
	 * getter method to return the head of the queue
	 * @return the head Task object
	 */
	public Task getCurrTask()
	{
		if (toDo.isEmpty() == false)
			return toDo.getCurrent();

		else 
		{
			System.out.println("\n\nThere is no current task.");
			return (Task) null;
		}
	}

	/**
	 * Add Task to the Queue
	 * @param newTask = task to add to queue
	 */
	public void addTask(Task newTask)
	{
		toDo.addItem(newTask);
	}

	/**
	 * Marks task as completed (removes it from queue)
	 * @return the element that has been completed
	 */
	public Task taskCompleted()
	{
		if (toDo.isEmpty() == false)
			return toDo.removeItem();

		System.out.println("\n\nThere are no tasks to mark as empty.");
		return (Task) null;
	}

	/**
	 * Postpone task to a later date
	 * @param newDate = task's new postponed date
	 * @return 
	 * 				1 = successfully postponed task
	 * 				0 = postponed task incorrectly
	 */
	public int postponeTask(Date newDate) // modifiedTask)
	{
		if (toDo.isEmpty() == true)
		{
			System.out.println("\n\nThere are no tasks to postpone.");
			return 0;
		}


		String taskName = toDo.getCurrent().getName();
		Date oldDate = toDo.getCurrent().getDate();

		if (oldDate.before(newDate) == true)
		{
			toDo.removeItem();
			Task t = new Task(taskName, newDate);
			toDo.addItem(t);
			return 1;
		}

		else
			System.out.println("\nSorry you can't postpone "
					+ "a task to a previous date. Try setting the"
					+ " postpone date after it's current date.");

		return 0;
	}

	/**
	 * Saves the rest of the contents of the queue into the file
	 * "database.txt"
	 */
	public void quit()
	{

		try
		{
			File f = new File("database.txt");
			PrintWriter writer = new PrintWriter(f);

			for (int i = 0; i < toDo.size(); i++)
			{
				writer.println(toDo.removeItem());
			}

			writer.close();

		} catch(FileNotFoundException e)
		{
			System.out.println("The file could not be found and thus can't be written to.");
		}
	}
}
