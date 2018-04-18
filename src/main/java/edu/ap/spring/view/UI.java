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
	private JLabel label1;
	private JTextField question;
	private JPanel controlPanel;
    private JButton btnAddQuestion;
    
    public UI() {}
    
    public void setupUI() {
	    	jFrame = new JFrame("Spring JFrame");
	    	jFrame.setLayout(new FlowLayout());
	    	
	    	controlPanel = new JPanel();
	    controlPanel.setLayout(new GridLayout(3, 2));

		label1 = new JLabel("Question : ");
		question = new JTextField(15);
		question.setDragEnabled(true);

		btnAddQuestion = new JButton();
		btnAddQuestion.setText("Ask");
		btnAddQuestion.setTransferHandler(new TransferHandler("text"));
		btnAddQuestion.addActionListener(eventHandler::whenButtonClicked);

		controlPanel.add(label1);
		controlPanel.add(question);
		controlPanel.add(btnAddQuestion);

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

    public JButton getButton() {
        return btnAddQuestion;
    }
}
