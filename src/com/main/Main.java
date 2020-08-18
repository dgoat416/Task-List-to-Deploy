//package com.main;
//
//import java.util.Date;
//
///**
// * Main class to test and implement the
// * rest of the classes
// * @author Deron Washington II
// * Last Updated: 11/1/2019 at 11:48pm
// *
// */
//public class Main
//{
//
//	/**
//	 * Performs the actual execution of the program
//	 * @param args necessary to run program
//	 */
//	public static void main(String[] args)
//	{
//		// test HEAP class
//	//	Heap<Integer> h = new Heap<Integer>();for(int i= 1;i<=10;i++){int rand =(int)(Math.random()*100)+1;System.out.print(rand+" ");h.addItem( rand );}System.out.println( ); System.out.println();System.out.println( h );for(int i=0;i<10;i++){h.removeItem();System.out.println( h );}
//
//		// test TASK class
//	//	Date d = new Date();Task t = new Task("A", d);Date e = new Date(1);Task te = new Task("A", e);	int j = te.compareTo(t);  /* should return -1*/  j = te.compareTo(te); /* should return 0*/	j = t.compareTo(te); /* should return 1*/String temp = t.getName();d = te.getDate();
//		
//		
//		// test TASKLIST class
//		TaskList t = new TaskList();
//		t.readFile();
//		// test heap working properly
//		//System.out.println( ); System.out.println();System.out.println( t.getCurrTask() );for(int i=0;i<10;i++){t.taskCompleted();System.out.println( t.getCurrTask() );}
//		t.getNumOfTasks(); // 10
//		t.getCurrTask(); // do math
//		
////		Date e = new Date();
////		Task temp = new Task("Z", e);
////		Task te = new Task("A", e);
////		Task d = new Task("B", e);
////		Task f = new Task("C", e);
////		t.addTask(temp); // 11
////		t.addTask(te);
////		t.addTask(d);
////		t.addTask(f);
//		
////		while(t.getCurrTask() != (Task) null)
////		{
////			System.out.println("\n\n" + t.getCurrTask());
////			t.taskCompleted();
////		}
//		
//		t.taskCompleted(); 
//		t.getNumOfTasks(); // 10
//		
//		Date date = new Date(Long.MAX_VALUE);
//	
//		//Task tel = new Task(t.getCurrTask().getName(), date);
//		t.getCurrTask().toString();
//		t.postponeTask(date); // date changed
//		t.getNumOfTasks(); // 10
//		t.quit();
//		
//	
//		
//		
//	}
//
//}
