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
		frame.setSize(400,400);
		frame.add(panel);
		
		// Create and add buttons/textfields to the window
		JButton calculate = new JButton("Calculate");
		JTextField inputSalary = new JTextField("Enter your monthly salary");
		JTextField inputExpense = new JTextField("Enter your expense and press enter");
		JLabel calculation = new JLabel("Calculation");
		JLabel resultLabel = new JLabel("Result");
		JList<Integer> expenseList = new JList<Integer>();
		
		calculate.setSize(50,50);
		inputSalary.setSize(20,50);
		inputExpense.setSize(20,50);
		expenseList.setSize(100, 100);
		
		panel.add(calculate, BorderLayout.SOUTH);
		panel.add(inputSalary, BorderLayout.PAGE_START);
		panel.add(inputExpense, BorderLayout.EAST);
		panel.add(calculation, BorderLayout.WEST);
		panel.add(resultLabel, BorderLayout.WEST);
		panel.add(expenseList, BorderLayout.EAST);
		
		frame.setVisible(true);
	}

}
