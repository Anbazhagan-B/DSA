package LLD2.StackOverflow;

import java.util.ArrayList;
import java.util.List;

public class User {
    long id;
    String name;
    List<Question> questions;
    List<Answer> answers;

    public User(long id, String name)
    {
        this.id = id;
        this.name = name;
        this.questions = new ArrayList<>();
        this.answers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void addQuestions(Question question)
    {
        if(question == null)
            throw new RuntimeException("Question cannot be empty");
        this.questions.add(question);
    }

    public void addAnswers(Answer answer)
    {
        if(answer == null)
            throw new RuntimeException("Answer cannot be empty");
        this.answers.add(answer);
    }
}
