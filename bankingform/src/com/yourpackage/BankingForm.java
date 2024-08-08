package com.yourpackage;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.Font;
import javax.swing.*;
import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.Connection;

public class BankingForm extends JFrame {
    JLabel message;
    JLabel nameLabel,  genderLabel;
    JTextField nameField;
    JRadioButton genderMale, genderFemale;
    ButtonGroup genderGroup;
    JLabel mailIdLabel, mobileNoLabel;
    JTextField mailIdField, mobileNoField;
    JLabel passwordLabel, rePasswordLabel;
    JPasswordField passwordField, rePasswordField;
    JLabel programLabel;
    JComboBox<String> programList;
    JLabel branchLabel, semesterLabel;
    JComboBox<String> branchList;
    JComboBox<String> OptionsList;
    JButton registerButton;
    Container container;
    public BankingForm() {
        message = new JLabel("Fill the form properly");
        message.setFont(new Font("Courier", Font.BOLD, 20));
        nameLabel = new JLabel("Name");
        nameField = new JTextField();
        genderLabel = new JLabel("Gender");
        genderMale = new JRadioButton("Male", true);
        genderFemale = new JRadioButton("Female");
        genderGroup = new ButtonGroup();
        genderGroup.add(genderMale);
        genderGroup.add(genderFemale);
        mailIdLabel = new JLabel("Mail Id");
        mailIdField = new JTextField();
        mobileNoLabel = new JLabel("Mobile No");
        mobileNoField = new JTextField();
        passwordLabel = new JLabel("Password");
        passwordField = new JPasswordField();
        rePasswordLabel = new JLabel("Re Password");
        rePasswordField = new JPasswordField();
        programLabel = new JLabel("Type of acc");
        programList = new JComboBox<String>();
        programList.addItem("Saving");
        programList.addItem("Current");
        programList.addItem("Joint");
        branchLabel = new JLabel("Branch");
        branchList = new JComboBox<String>();
        branchList.addItem("Ahmedabad");
        branchList.addItem("Vadodara");
        branchList.addItem("Rajkot");
        branchList.addItem("Surat");
        branchList.addItem("Valsad");
        branchList.addItem("Gandhinagar");
        semesterLabel = new JLabel("Options");
        OptionsList = new JComboBox<>();
        OptionsList.addItem("Withdrawal");
        OptionsList.addItem("Fast Withdrawal");
        OptionsList.addItem("Change Pin");
        OptionsList.addItem("View Balance");
        OptionsList.addItem("Desposit Card or Cash");
        OptionsList.addItem("Mobile Banking");
      ;
        registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String gender = genderMale.isSelected() ? "Male" : "Female";
                String mailId = mailIdField.getText();
                String mobileNo = mobileNoField.getText();
                char[] password = passwordField.getPassword();
                char[] rePassword = rePasswordField.getPassword();
                String program = programList.getSelectedItem().toString();
                String branch = branchList.getSelectedItem().toString();
                String options =  OptionsList.getSelectedItem().toString();

                
                String message = "Name: " + name + "\nGender: " + gender + "\nMail Id: " + mailId
                        + "\nMobile No: " + mobileNo + "\nProgram: " + program + "\nBranch: " + branch
                        + "\nOptions: " + options;
                JOptionPane.showMessageDialog(container, message, "Registration Successful", JOptionPane.INFORMATION_MESSAGE);
                
                try
            	{
            		Class.forName("com.mysql.jdbc.Driver");
            		
            		java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankform","root","");
            		
            		Statement stmt = con.createStatement();
            		
            		System.out.println("connecting java");
            		
            		String sql= "INSERT INTO bank(Name, Gender, MailId, Mobile, Password, Account, Branch, Options) VALUES (?,?,?,?,?,?,?,?)";
//            		stmt.executeUpdate(sql);
            		System.out.println("created table BANKFORM table");
            		PreparedStatement ps=con.prepareStatement(sql);
            		ps.setNString(1,nameField.getText() );
            		ps.setString(2,genderMale.isSelected() ? "Male" : "Female");
            		ps.setString(3, mailIdField.getText());
            		ps.setString(4,mobileNoField.getText());
            		ps.setString(5, mobileNoField.getText());
            		ps.setString(6,programList.getSelectedItem().toString());
            		ps.setString(7, branchList.getSelectedItem().toString());
            		ps.setString(8, (String) OptionsList.getSelectedItem());
            		
            		int i=ps.executeUpdate();
            		JOptionPane.showMessageDialog(registerButton, i+"Record added");
            		ps.close();
            		con.close();
            		
            	}
            	catch(Exception e1)
            	{
            		System.out.println(e1);
            	}	
            		
                
            }
        });
    
        container = getContentPane();
        container.setLayout(null);
        container.add(registerButton);
        setBounds();
        addComponents();
    }
    public void setBounds() {
        message.setBounds(50, 10, 600, 30);
        nameLabel.setBounds(50, 60, 100, 30);
        nameField.setBounds(130, 60, 200, 30);
        genderLabel.setBounds(50, 160, 100, 30);
        genderMale.setBounds(130, 160, 100, 30);
        genderFemale.setBounds(240, 160, 100, 30);
        mailIdLabel.setBounds(50, 210, 100, 30);
        mailIdField.setBounds(130, 210, 200, 30);
        mobileNoLabel.setBounds(50, 260, 100, 30);
        mobileNoField.setBounds(130, 260, 200, 30);
        passwordLabel.setBounds(50, 310, 100, 30);
        passwordField.setBounds(130, 310, 200, 30);
        rePasswordLabel.setBounds(50, 360, 100, 30);
        rePasswordField.setBounds(130, 360, 200, 30);
        programLabel.setBounds(50, 410, 100, 30);
        programList.setBounds(130, 410, 200, 30);
        branchLabel.setBounds(50, 460, 100, 30);
        branchList.setBounds(130, 460, 200, 30);
        semesterLabel.setBounds(50, 510, 100, 30);
        OptionsList.setBounds(130, 510, 200, 30);
        registerButton.setBounds(130, 550, 200, 30);
    }
    public void addComponents() {
        container.add(message);
        container.add(nameLabel);
        container.add(nameField);
        container.add(genderLabel);
        container.add(genderMale);
        container.add(genderFemale);
        container.add(mailIdLabel);
        container.add(mailIdField);
        container.add(mobileNoLabel);
        container.add(mobileNoField);
        container.add(passwordLabel);
        container.add(passwordField);
        container.add(rePasswordLabel);
        container.add(rePasswordField);
        container.add(programLabel);
        container.add(programList);
        container.add(branchLabel);
        container.add(branchList);
        container.add(semesterLabel);
        container.add(OptionsList);
        container.add(registerButton);
    }
    public static void main(String[] args) {
      
    	SwingUtilities.invokeLater(new Runnable() {
            public void run() {
        BankingForm frame = new BankingForm();
        frame.setTitle("Bank Register Form");
        frame.setVisible(true);
        frame.setBounds(500, 100, 500, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }
    	});
    }
}