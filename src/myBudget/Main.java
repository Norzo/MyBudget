package myBudget;

import java.awt.BorderLayout;
import java.awt.GridLayout;

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
		
		// Create and set up the panel
		JPanel mainPanel = new JPanel();
		frame.setSize(400,400);
		
		// Create and set layout
		GridLayout mainGridLayout = new GridLayout(4,4);
		mainPanel.setLayout(mainGridLayout);
		frame.add(mainPanel);
		
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
		
		mainPanel.add(inputSalary);
		mainPanel.add(inputExpense);
		mainPanel.add(calculation);
		mainPanel.add(expenseList);
		mainPanel.add(resultLabel);
		
		mainPanel.add(calculate);
		
		frame.setVisible(true);
	}

}
