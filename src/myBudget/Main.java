package myBudget;

import java.awt.BorderLayout;

import javax.swing.*;

public class Main 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		CreateWindow();
	}
	
	static void CreateWindow()
	{
		// Create the actual window
		JFrame frame = new JFrame("MyBugdet");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		
		// Create and set up the panels within the window
		JPanel panel = new JPanel(new BorderLayout());
		
		
		// Create and add buttons/textfields to the window
		JButton button = new JButton("Press");
		JTextField inputSalary = new JTextField("Enter your monthly salary");
		
		button.setSize(50,50);
		inputSalary.setSize(20,50);
		
		frame.getContentPane().add(button, BorderLayout.SOUTH);
		frame.getContentPane().add(inputSalary, BorderLayout.PAGE_START);
		
		frame.setVisible(true);
	}

}
