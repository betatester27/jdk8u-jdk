/*
	<applet code="calculator" height="470" width="400">
	</applet>
*/

import java.awt.event.*;
import java.awt.*;
import java.applet.Applet;

public class calculator extends Applet implements ActionListener
{	
    Panel labelPanel = new Panel();
    Label calcLabel = new Label("CALCULATOR");
	Panel panel1 = new Panel();		
	Panel panel2 = new Panel();		
	Panel panel4 = new Panel();		
	Panel panel3 = new Panel();		
	int signID = 0;
	Button addButton = new Button("+");
	Button minusButton = new Button("-");
	Button divideButton = new Button("/");
	Button multiplyButton = new Button("x");
	Button equalButton = new Button("=");
	Button onButton = new Button("ON");
	Button offButton = new Button("OFF");
	Button clearButton = new Button("CLEAR");
	TextField field1 = new TextField("0",20);
	TextField field2 = new TextField("0",20);
	TextField resultField = new TextField("",20);

	public calculator()
	{
		setBackground(Color.cyan);
        labelPanel.setBackground(Color.CYAN);
		labelPanel.setBounds(0,3,100,100);
		calcLabel.setForeground(Color.black);
		calcLabel.setFont(new Font("serif",Font.BOLD,50)); 
		labelPanel.add(calcLabel);
		addButton.setEnabled(false);
		minusButton.setEnabled(false);
		multiplyButton.setEnabled(false);
		divideButton.setEnabled(false);
		clearButton.setEnabled(false);
		equalButton.setEnabled(false);
		offButton.setEnabled(false);
		field1.setEnabled(false);
		field2.setEnabled(false);

		panel1.setLayout(new GridLayout(2,2,5,5));
		panel1.setBounds(353,107,225,175);
		panel1.add(addButton);
		panel1.add(minusButton);
		panel1.add(divideButton);
		panel1.add(multiplyButton);
		panel2.setLayout(new GridLayout(2,1,5,5));
		panel2.setBounds(353,530,300,200);
		panel2.add(panel4);	
		panel2.add(equalButton);
		panel4.setLayout(new GridLayout(1,3,5,5));
		panel4.add(clearButton);
		panel4.add(onButton);
		panel4.add(offButton);
		panel3.setLayout(new GridLayout(3,1,5,5));
		panel3.setBounds(10,107,300,600);
		panel3.add(field1);
		panel3.add(field2);
		panel3.add(resultField);

		add(labelPanel);
		add(panel1);
		add(panel2);
		add(panel3);

		addButton.setFont(new Font("Font.Plain",Font.BOLD,40));	
		minusButton.setFont(new Font("Font.Plain",Font.BOLD,40));
		multiplyButton.setFont(new Font("Font.Plain",Font.BOLD,40));
		divideButton.setFont(new Font("Font.Plain",Font.BOLD,70));
		equalButton.setFont(new Font("Font.Plain",Font.BOLD,70));
		clearButton.setFont(new Font("Font.Plain",Font.BOLD,20));
		offButton.setFont(new Font("Font.Plain",Font.BOLD,20));
		onButton.setFont(new Font("Font.Plain",Font.BOLD,20));

		addButton.setBackground(Color.yellow);
		addButton.setForeground(Color.black);
		minusButton.setBackground(Color.yellow);
		minusButton.setForeground(Color.black);
		multiplyButton.setBackground(Color.yellow);
		multiplyButton.setForeground(Color.black);
		divideButton.setBackground(Color.yellow);
		divideButton.setForeground(Color.black);
		equalButton.setBackground(Color.blue);
		equalButton.setForeground(Color.black);
		onButton.setBackground(Color.green);
		onButton.setForeground(Color.black);
		offButton.setBackground(Color.red);
		offButton.setForeground(Color.black);
		clearButton.setBackground(Color.white);
		clearButton.setForeground(Color.black);

		field1.setBackground(Color.cyan);
		field1.setFont(new Font("Font.Digital",Font.BOLD,30));
		field2.setBackground(Color.cyan);
		field2.setFont(new Font("Font.Digital",Font.BOLD,30));
		resultField.setBackground(Color.cyan);
		resultField.setFont(new Font("Font.Digital",Font.BOLD,30));
		resultField.setEditable(false);

		addButton.addActionListener(this);
		minusButton.addActionListener(this);
		multiplyButton.addActionListener(this);
		divideButton.addActionListener(this);
		clearButton.addActionListener(this);
		equalButton.addActionListener(this);
		onButton.addActionListener(this);
		offButton.addActionListener(this);
	}

	private double performOperation(double x, double y, int operation) 
	{
   		if (operation == 1)
   			return x + y;

   		else if (operation == 2)
    			return x - y;

  		else if (operation == 3)
    			return x * y;

   		else if (operation == 4)
    			return x / y;

   		else
   			return 0.0;
  	}

	public void actionPerformed(ActionEvent e) 
	{	double x = Double.valueOf(field1.getText());
     		double y = Double.valueOf(field2.getText());

    		if (e.getSource() == onButton) 
		{
     			addButton.setEnabled(true);
      		minusButton.setEnabled(true);
      		multiplyButton.setEnabled(true);
      		divideButton.setEnabled(true);
      		equalButton.setEnabled(true);
      		offButton.setEnabled(true);
      		clearButton.setEnabled(true);
      		onButton.setEnabled(false);
      		field1.setEnabled(true);
      		field2.setEnabled(true);
 		}

 		if (e.getSource() == offButton) 
		{
			addButton.setEnabled(false);
		 	minusButton.setEnabled(false);
		 	multiplyButton.setEnabled(false);
		 	divideButton.setEnabled(false);
		 	equalButton.setEnabled(false);

		 	offButton.setEnabled(false);
		 	clearButton.setEnabled(false);
		 	onButton.setEnabled(true);

		 	field1.setEnabled(false);
		 	field2.setEnabled(false);
	 	}


     		if (e.getSource() == addButton) 
		{	signID = 1;
     		}

     		if (e.getSource() == minusButton) 
		{	signID = 2;
     		}

    		if (e.getSource() == multiplyButton) 
		{	signID = 3;
     		}

     		if (e.getSource() == divideButton) 
		{	signID = 4;
    		}

     		if (e.getSource() == equalButton) 
		{	String answer = Double.toString(performOperation(x, y, signID));
      		resultField.setText(" = "+answer);
  		}

		if (e.getSource() == clearButton) 
		{	field1.setText("0");
			field2.setText("0");
			resultField.setText("");
		 	signID = 0;
	 	}
 	}
	
	public void main(String args[])
	{ new calculator();}

}


