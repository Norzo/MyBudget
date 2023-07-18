package myBudget;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class Main 
{
	static int userSalary;
	
	static List<Integer> userExpenses = new ArrayList<Integer>();

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
		JList<Integer> expenseList = new JList<>();
		
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
		
		//Define Actions
		Action storeSalValue = new AbstractAction()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						setSalary(inputSalary.getText());
						inputSalary.setText("");
					}
				};
			
			Action storeExpValue = new AbstractAction()
				{
	
					@Override
					public void actionPerformed(ActionEvent e) 
					{
						// TODO Auto-generated method stub
						saveExpense(inputExpense.getText());
						inputExpense.setText("");
					}
				
				};
		
		Action calculateBudget = new AbstractAction()
				{

					@Override
					public void actionPerformed(ActionEvent e)
					{
						// TODO Auto-generated method stub
						calculateAll(resultLabel, calculation);
					}
			
				};
				
		inputSalary.addActionListener(storeSalValue);
		inputExpense.addActionListener(storeExpValue);
		calculate.addActionListener(calculateBudget);
		
		frame.setVisible(true);
	}
	
	static void setSalary(String input)
	{
		userSalary = Integer.parseInt(input);
	}
	
	static void saveExpense(String input)
	{
		userExpenses.add(Integer.parseInt(input));
	}
	
	static void calculateAll(JLabel resultLabel, JLabel calculation)
	{
		int sumExpenses = 0;
		
		for (int i = 0; i < userExpenses.size(); i++)
			sumExpenses += userExpenses.get(i);
		
		String remains = Integer.toString(userSalary - sumExpenses);
		
		calculation.setText("Salary - sum of expenses: " + Integer.toString(userSalary) + " - " + Integer.toString(sumExpenses));
		
		resultLabel.setText("Budget: " + remains);
	}

}
