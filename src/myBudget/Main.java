package myBudget;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class Main 
{
	static JList<Integer> expenseList = new JList<>();

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
		Action storeValue = new AbstractAction()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						int tempNum;
						String tempStr = inputSalary.getText();
						
						try
						{
							tempNum = Integer.valueOf(tempStr);
						}
						catch (NumberFormatException ex)
						{
							inputSalary.setText("Please input a number");
							ex.printStackTrace();
						}
						
						expenseList.addElement(tempNum);
					}
				};
		
		inputSalary.addActionListener(storeValue);
		
		frame.setVisible(true);
	}

}
