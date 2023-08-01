package myBudget;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class Main 
{
	static int userSalary;
	
	static DefaultListModel userExpensesModel = new DefaultListModel();

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
		JList<Integer> expenseJList = new JList(userExpensesModel);
		
		calculate.setSize(50,50);
		inputSalary.setSize(20,50);
		inputExpense.setSize(20,50);
		expenseJList.setSize(100, 100);
		
		mainPanel.add(inputSalary);
		mainPanel.add(inputExpense);
		mainPanel.add(calculation);
		mainPanel.add(expenseJList);
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
		
		try {
			ChatGPT.foodBudgetGPT();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		frame.setVisible(true);
	}
	
	static void setSalary(String input)
	{
		userSalary = Integer.parseInt(input);
	}
	
	static void saveExpense(String input)
	{
		userExpensesModel.addElement(Integer.parseInt(input));
	}
	
	static void calculateAll(JLabel resultLabel, JLabel calculation)
	{
		int sumExpenses = 0;
		
		for (int i = 0; i < userExpensesModel.size(); i++)
			sumExpenses += Integer.parseInt(userExpensesModel.get(i).toString());
		
		String remains = Integer.toString(userSalary - sumExpenses);
		
		calculation.setText("Salary - sum of expenses: " + Integer.toString(userSalary) + " - " + Integer.toString(sumExpenses));
		
		resultLabel.setText("Budget: " + remains);
	}
	
	public class ChatGPT {
	    public static void chatGPT(String text) throws Exception {
	        String url = "https://api.openai.com/v1/completions";
	        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();

	        con.setRequestMethod("POST");
	        con.setRequestProperty("Content-Type", "application/json");
	        con.setRequestProperty("Authorization", "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");

	        JSONObject data = new JSONObject();
	        data.put("model", "gpt-3.5-turbo");
	        data.put("prompt", text);
	        data.put("max_tokens", 2000);
	        data.put("temperature", 1.0);

	        con.setDoOutput(true);
	        con.getOutputStream().write(data.toString().getBytes());

	        String output = new BufferedReader(new InputStreamReader(con.getInputStream())).lines()
	                .reduce((a, b) -> a + b).get();

	        System.out.println(new JSONObject(output).getJSONArray("choices").getJSONObject(0).getString("text"));
	    }
	    
	    public static void foodBudgetGPT() throws Exception
		{
			chatGPT("Please write the monthly budget for food in Norway in NOK, numbers only.");
		}
	}
}

