package edu.ap.spring.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.TransferHandler;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UI implements InitializingBean {
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.setProperty("java.awt.headless", "false");
	}
	
	@Autowired
	EventHandler eventHandler;

	private JFrame jFrame;
	private JLabel label1, label2, label3;
	private JTextField question, answer;
	private JPanel controlPanel;
    private JButton btnAddQuestion;
    
    public UI() {}
    
    public void setupUI() {
	    	jFrame = new JFrame("EightBall app");
	    	jFrame.setLayout(new FlowLayout());
	    	
	    	controlPanel = new JPanel();
	    controlPanel.setLayout(new GridLayout(3, 2));

		label1 = new JLabel("Question : ");
		label2 = new JLabel("Answer : ");
		label3 = new JLabel("Push this button : ");
		question = new JTextField(20);
		answer = new JTextField(20);
		answer.setEditable(false);
		answer.setText("Ask a Question!");
		question.setDragEnabled(true);

		btnAddQuestion = new JButton();
		btnAddQuestion.setText("Click");
		btnAddQuestion.setTransferHandler(new TransferHandler("text"));
		btnAddQuestion.addActionListener(eventHandler::whenButtonClicked);

		controlPanel.add(label1);
		controlPanel.add(question);
		controlPanel.add(label3);
		controlPanel.add(btnAddQuestion);
		controlPanel.add(label2);
		controlPanel.add(answer);

		jFrame.add(controlPanel);
		        
		jFrame.setSize(400, 400);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.pack();
		jFrame.setVisible(true);
    }

    public JFrame getjFrame() {
        return this.jFrame;
    }
    
    public JTextField getQuestion() {
    		return this.question;
    }

    public void setAnswer(String a) {
    	this.answer.setText(a);
    }
    
    public JButton getButton() {
        return btnAddQuestion;
    }
}
