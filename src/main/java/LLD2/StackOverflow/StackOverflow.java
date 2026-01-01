package LLD2.StackOverflow;

import java.util.*;

public class StackOverflow {
    Map<Long, User> users;
    Map<Long, Answer> answers;
    Map<Long, Question> questions;

    public StackOverflow()
    {
        this.users = new HashMap<>();
        this.questions = new HashMap<>();
        this.answers = new HashMap<>();
    }

    public void addQuestion(Question question, User user)
    {
        if(question == null || user == null)
            throw new RuntimeException("Question or Answer is empty");
        questions.put(question.getId(), question);
        user.addQuestions(question);
    }

    public void addAnswers(Answer answer, User user)
    {
        if(answer == null || user == null)
            throw new RuntimeException("Answer is empty");

        user.addAnswers(answer);
        answers.put(answer.answerId, answer);
    }

    public void addUsers(User user)
    {
        this.users.put(user.id, user);
    }


    public User getUserById(long userId)
    {
        if(userId <= 0)
            throw new RuntimeException("User Id is not valid");
        User userResponse = this.users.get(userId);
        if(userResponse == null)
            throw new RuntimeException("User cannot be empty");

        return userResponse;
    }

    public Question getMatchingQuestion(String questionKeywords)
    {
        return this.questions.entrySet().stream()
                .filter(entry -> entry.getValue().keywords.contains(questionKeywords))
                .findFirst().get().getValue();
    }

}
