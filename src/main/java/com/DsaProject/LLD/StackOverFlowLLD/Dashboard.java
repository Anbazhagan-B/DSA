package com.DsaProject.LLD.StackOverFlowLLD;

public class Dashboard {
    public static void main(String[] args)
    {
        StackOverFlow stackOverFlow = new StackOverFlow();
        User user = new User("Anbu", "anbu@gmail.com");
        User user1 = new User("Anbu1", "anbu1@gmail.com");
        User user2 = new User("Anbu2", "anbu2@gmail.com");
        Question question = new Question("Java is pure OOP", "ALL the features are object in java , so it pur OOP", user);

        Answer answer = new Answer("Yes Its Pure OOP", user1, question);
        Answer answer1 = new Answer("No  Its not Pure OOP", user2, question);

        stackOverFlow.addQuestion(question);
        stackOverFlow.addQuestion(question);
        stackOverFlow.addAnswer(question, answer);
        stackOverFlow.addAnswer(question, answer1);
        stackOverFlow.acceptAnswer(answer1);

        Answer getAcceptedAnswer = stackOverFlow.getAcceptedAnswer(question);

        System.out.printf("AcceptedAnswer %s", getAcceptedAnswer.content);

    }
}
