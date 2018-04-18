package edu.ap.spring.view;

import java.awt.event.ActionEvent;

import edu.ap.spring.jpa.Question;
import edu.ap.spring.jpa.QuestionRepository;

public class EventHandler {
	private UI ui;
    private QuestionRepository repository;
    
    @Autowired
    public void setRepository(QuestionRepository repository) {
    		this.repository = repository;
    }
    
    @Autowired
    public void setUI(UI ui) {
    		this.ui = ui;
    }

    public void whenButtonClicked(ActionEvent actionEvent) {
    		
    		String username = ui.getQuestion().getText();
    		Question question = new Question(username);
        repository.save(question);

        System.out.println(question.toString() + " saved in repository");
        System.out.println("Find all : ") ;
        repository.findAll().forEach(System.out::println);
    }
}
