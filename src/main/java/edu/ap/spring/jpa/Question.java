package edu.ap.spring.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Question {
	   @Id
	   @GeneratedValue
	   private Long id;

	    private String q, a;

	    public Question() {}

	    public Question(String q, String a) {
	        this.q = q;
	        this.a = a;
	    }
	    
	    @Override
	    public String toString() {
	        return "User {" +
	                "question = " + q +
	                ", answer = '" + a + '\'' +
	                '}';
	    }
}
