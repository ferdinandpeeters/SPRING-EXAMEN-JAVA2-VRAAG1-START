package edu.ap.spring.view;

import java.awt.event.ActionEvent;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ap.spring.jpa.Question;
import edu.ap.spring.jpa.QuestionRepository;
import edu.ap.spring.model.EightBall;

@Service
public class EventHandler {
	private UI ui;
    private QuestionRepository repository;
    private EightBall eightBall;
    
    @Autowired
    public void setRepository(QuestionRepository repository) {
    		this.repository = repository;
    }
    
    @Autowired
    public void setUI(UI ui) {
    		this.ui = ui;
    }

    @Autowired
    public void setEightball(EightBall eightBall) {
    		this.eightBall = eightBall;
    }
    
    public void whenButtonClicked(ActionEvent actionEvent) {
    		
    	String q = ui.getQuestion().getText();
    	Question question;
    	Question lookUp = repository.findByQuestion(q);
    	if(lookUp == null) {
    		question = new Question(q, eightBall.getRandomAnswer(q));
            repository.save(question);
            System.out.println(question.toString() + " saved in repository");
    	}
    	else {
    		question = lookUp;
    		System.out.println(question.toString() + "Already in database");
    	}

    	ui.setAnswer(question.getAnswer());
        //System.out.println("Find all : ") ;
        //repository.findAll().forEach(System.out::println);
    }
}
