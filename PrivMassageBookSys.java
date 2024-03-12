

import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class PrivMassageBookSys {

	public static void main(String[] args) {
		UIManager.put("OptionPane.background", Color.BLACK);
		UIManager.put("OptionPane.messagebackground", Color.BLACK);
		UIManager.put("Panel.background", Color.BLACK);
		UIManager.put("listForeground", Color.WHITE);
		UIManager.put("OptionPane.messageForeground", Color.WHITE);
		PrivMassageBookSysADT q= new PrivMassageBookSysADT(10);
		
		String menu[]= {"Book Reservation", "Delete Reservation in-order", 
				"List of Clients", "Pay and tip in Advance", "Exit"};
		String namesPaid[]= {};
		String choose = "";
		String numEnqueue;
		String clientNum;
		String hold = "";
		String service;
		String message;
		String ask_Client;
		int count = 0;
		int clientPMT;
		int amt = 0;
		
		
		do {
			hold = q.showInfo();
			message = q.message();
			JTextArea textArea = new JTextArea(message);
			Font font = new Font("Lucida Handwriting", Font.BOLD, 25);
			textArea.setFont(font);
			textArea.setBackground(Color.black);
			textArea.setForeground(Color.white);
			
			
			choose = JOptionPane.showInputDialog(null, textArea, "Main Menu by: DA DCODERS", 1, null, menu, menu[0]).toString();
			
			
			
			switch(choose) {

				case "Book Reservation":
					numEnqueue = JOptionPane.showInputDialog("Clients Name: ");
					clientNum = JOptionPane.showInputDialog("Contact Information: ");
					service = JOptionPane.showInputDialog("Services:\n"+"\nFull Body Massage: FBM \nHead and Foot Massage: HFM "
							+ "\nBack Massage: BM \nFoot Massage: FM \nHead Massage: HM");
					
					count ++;
					q.enqueue(numEnqueue + "          \t" + "          \t" + clientNum + "          \t" 
					+ service + "         \t" + count);
					JOptionPane.showMessageDialog(null, "Greetings " + numEnqueue + ", you successfully booked an appointment.\n"
							+ "\nPlease secure it by paying the downpayment within 12 hours or it might get cancelled, afterwards an open time slot "
							+ "will be sent to your number after payment.\n\nThank you!");
					break;
					
				case "Delete Reservation in-order":
					ask_Client = JOptionPane.showInputDialog("Please enter the zen password: ");
					
					if (ask_Client.equals("zenden")) {
						JOptionPane.showMessageDialog(null,"Client: "+ q.dequeue() + " was deleted" );
						break;
					}else {
						JOptionPane.showMessageDialog(null, "Incorrect Password, cannot proceed with deletion.");
						break;
					}

					
				case "List of Clients":
					ask_Client = JOptionPane.showInputDialog("Please enter the zen password: ");
					if (ask_Client.equals("zenden")) {
						JOptionPane.showMessageDialog(null,  new JTextArea(hold));
						JOptionPane.showMessageDialog(null,  "Total amount of advance payment: " + amt);
						break;
					}else {
						JOptionPane.showMessageDialog(null, "Incorrect Password, cannot proceed in viewing the List of Clients.");
						break;
					}
					
				case "Pay and tip in Advance":
					ask_Client = JOptionPane.showInputDialog("Greetings from The Zen Den!\n\n"
							+ "You can pay and tip the masseuse in advance when booking an appointment.\n"
							+ "The downpayment is only 250 pesos for the reservation and any additional fees can be paid afterwards. "
							+ "\n\nPlease input your name below. Thank you! P.S. NO REFUNDS!!!\n\n Name:");
					
					clientPMT = Integer.parseInt(JOptionPane.showInputDialog("Please input the amount:"));
					
					if (clientPMT == 250) {
						amt += clientPMT;
						JOptionPane.showMessageDialog(null, "Transaction details will be sent to your number shorty. Thank you for availing our service!");
					}else if(clientPMT > 250) {
						@SuppressWarnings("unused")
						int tip = clientPMT - 250;
						amt += clientPMT;
						JOptionPane.showMessageDialog(null, "The transaction and masseuse details will be sent to your number shortly. "
								+ "Thank you for the tip!");
						
						
					}else {
						JOptionPane.showMessageDialog(null, "Insufficient Amount. "
								+ "Please try again by inputting a different amount.");
						break;
					}
					
					String arrNew[] = new String [namesPaid.length+ 1];
					int i;
					for (i = 0; i < namesPaid.length; i++) {
						arrNew[i] = namesPaid[i];
					}
					arrNew[i] = ask_Client + " = " + "Status: Paid";
					
					for (String s: arrNew) {
						System.out.println(s);
					}
					break;
			}
			
		}while (!choose.equals("Exit"));
		JOptionPane.showMessageDialog(null, "Thank you for using the Zen Den Booking System!\r\n"
				+ "\r\n"
				+ "Program Coded By:\r\n"
				+ "Mark Raphael Abaya\r\n"
				+ "Alfred Ashley Andrion\r\n"
				+ "TEAM: DA DCODERS");
		
	}

}

