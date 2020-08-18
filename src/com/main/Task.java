package com.main;

import java.text.NumberFormat;
import java.util.*;

/**
 * Task class to represent a task that 
 * must be done at a certain time
 * @author Deron Washington II
 * Last update: 11/1/19 at 11:45pm
 *
 */
public class Task implements Comparable<Task>
{
	/* private member variables */

	/** name of the task*/
	private String name;
	/** task's due date*/
	private Date dueDate;
	

	/* public methods */

	/**
	 * Parameterized Constructor to initialize
	 * all private members
	 * @param n = task name
	 * @param d = task's due date
	 */
	public Task(String n, Date d)
	{
		name = n;
		dueDate = d;
	}

	/**
	 * Method to return the private member 
	 * variable corresponding to the name of the task
	 * @return the name of the task 
	 */
	public String getName()	
	{
		return name;
	}

	/**
	 * Method to return the private member 
	 * variable corresponding to the task's due date
	 * @return the task's due date
	 */
	public Date getDate()
	{
		return dueDate;
	}
	

	/**
	 * Method to override compareTo method 
	 * to compare by date and then breaks any 
	 * date ties with comparing by name
	 * @param t is the object to be compared
	 * @return a negative integer, zero, or a positive integer 
	 * as this object is less than, equal to, or greater than the specified object.
	 */
	public int compareTo(Task t)
	{		
		
	// compare by date first then by name
		if (this.dueDate.compareTo(t.getDate()) == 0)
			
		{
			if (this.name.compareTo(t.getName()) == 0)
				return 0;
			else if (this.name.compareTo(t.getName()) < 0)
				return -1;
			else if (this.name.compareTo(t.getName()) > 0)
				return 1; 
		}
		
		else if (this.dueDate.compareTo(t.getDate()) > 0)
			return 1;
		
		return(this.dueDate.compareTo(t.getDate()));  // returns - number

	}

	/**
	 * Override to output a unique representation of the object 
	 * @return the task in the form of "taskName,MM/dd/yyyy hh:mm"
	 */
	@Override
	public String toString()
	{
		Calendar x =Calendar.getInstance();
		x.setTime(dueDate);
		
		Integer month = x.get(Calendar.MONTH) + 1,		
					dayOfMonth = x.get(Calendar.DAY_OF_MONTH),
					year = x.get(Calendar.YEAR),
					hour = x.get(Calendar.HOUR_OF_DAY),
					minute = x.get(Calendar.MINUTE);
		
		if (hour.toString().equals("0") || hour.toString().equals("00"))
			hour = 12;
		
		String sMonth = "",
				 sDayOfMonth = "",
				 sHour = "", 
				 sYear = "",
				 sMinute = "";
		
		
		if (month.toString().length() < 2)
				 sMonth = "0" + month.toString();
		else
			sMonth = month.toString();
		
		
		if (dayOfMonth.toString().length() < 2)
			sDayOfMonth = "0" + dayOfMonth.toString();
		else
			sDayOfMonth = dayOfMonth.toString();
		
		
		if (year.toString().length() < 2)
			sYear = "0" + year.toString();
		else
			sYear = year.toString();
		
		
		if (hour.toString().length() < 2)
			sHour = "0" + hour.toString();
		else
			sHour = hour.toString();
		
		
		if (minute.toString().length() < 2)
			sMinute = "0" + minute.toString();
		else
			sMinute = minute.toString();
		
		return ( this.name + "," 
		+ sMonth + "/" + sDayOfMonth + "/" + sYear
		+ " " + sHour + ":" + sMinute);
	}
	
	
	
}
