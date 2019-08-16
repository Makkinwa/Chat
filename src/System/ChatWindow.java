package System;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ChatWindow implements ActionListener {
	OutputHandler out;
	String BufferedText = "";
	Server server;
	String username = "mak";
	private String str;
	private JTextArea area;
	private JTextField field;
	private int width = 100;
	private int height = 400;
	private String text;
	
	public ChatWindow(String username, OutputHandler out) {
		this.out = out;
		this.username = username;
		init();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		str = username + ": " + e.getActionCommand() + "\n";
		area.append(str);
		sendText(str, out);
		field.setText("");
	}
	
	public void takeMessage(String s) {
		area.append(s);
	}
	
	private void sendText(String s, OutputHandler out) {
		out.takeText(s);
	}
	
	private void init() {
		JFrame frame = new JFrame("Chat");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		BorderLayout gb = new BorderLayout();
		field = new JTextField(text);
		field.setPreferredSize(new Dimension(width, 40));
		field.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		field.addActionListener(this);
		area = new JTextArea();
		area.setEditable(false);
		area.setPreferredSize(new Dimension(width, height - 40));
		frame.setLayout(gb);
		frame.add(area, BorderLayout.PAGE_START);
		frame.add(field, BorderLayout.PAGE_END);
		frame.setResizable(true);
		frame.setVisible(true);
		frame.pack();
		frame.setSize(400, 400);
	}

}
