package com.DsaProject.LLD.StackOverFlowLLD;

import java.util.*;
import java.util.Map;

public class StackOverFlow {

    Map<Integer, Question> questions = new HashMap<>();
    Map<Integer, User> users = new HashMap<>();
    Map<Integer, Answer> answers = new HashMap<>();

    public void addQuestion(Question question)
    {
        //if(questions.containsKey(question.getId()))
        {
            questions.put(question.getId(), question);
        }
    }

    public void addAnswer(Question questionToAdd, Answer answer)
    {
        if(!answers.containsKey(answer.id))
        {
            answers.put(answer.id, answer);
        }
        if(questionToAdd.answers == null)
        {
            questionToAdd.answers = new ArrayList<>();
        }
        questionToAdd.answers.add(answer);
    }

    public void acceptAnswer(Answer answer)
    {
        if(answers.containsKey(answer.id))
        {
            answer.isAccepted = true;

            Question question = questions.get(answer.question.id);
            question.acceptedAnswer = answer;
        }
    }

    public Answer getAcceptedAnswer(Question question)
    {
        Answer acceptedAnswer = null;
        if(questions.containsKey(question.id))
        {

            Question question1 = questions.get(question.id);
            if(question1.acceptedAnswer != null)
            {
                acceptedAnswer = question1.acceptedAnswer;
            }
        }

        return acceptedAnswer;
    }

}
