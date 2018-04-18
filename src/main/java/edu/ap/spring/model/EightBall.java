package edu.ap.spring.model;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;

@Component
public class EightBall {
	
	private Random randomGenerator = new Random();
	
	ArrayList<Integer> noDoubles = new ArrayList<>();
	
	private String[] answers = {"It is certain", 
								"Yes definitely", 
								"Most likely",
								"Outlook good",
								"Better not tell you now",
								"Cannot predict now",
								"Don't count on it", 
								"Outlook not so good"};
	
	public String getRandomAnswer(String question) {
		String answer = "";
		int index = 0;
		while (answer == "") {
			if (noDoubles.size() < answers.length) {
				index = randomGenerator.nextInt(answers.length);
				if (!noDoubles.contains(index)) {
					noDoubles.add(index);
					answer = answers[index];
				}
			}
			else {
				index = randomGenerator.nextInt(answers.length);
				answer = answers[index];
			}
			
		}
        return answer;
	}

	public String[] getAnswers() {
		return answers;
	}

	public void setAnswers(String[] answers) {
		this.answers = answers;
	}
}
