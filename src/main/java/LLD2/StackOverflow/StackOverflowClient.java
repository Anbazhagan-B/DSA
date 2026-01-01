package LLD2.StackOverflow;

public class StackOverflowClient {

    public static void main(String[] args)
    {
        Question question = new Question(1, "Java", "Does Java is OOP language ?", "Java");
        Question question1 = new Question(1, "Java", "Does Java is functional  language ?", "Java");
        Question question2 = new Question(1, "Java", "What is Java 8 features ?", "Java");

        Answer answer = new Answer(1, "Java is OOP Language");
        Answer answer2 = new Answer(2, "Java is not functional Language");
        Answer answer3 = new Answer(2, "Lambda, Functional Interface");

        User muthu = new User(1, "Muthu");
        User anbu = new User(2, "Anbu");

        StackOverflow stackOverflow = new StackOverflow();
        stackOverflow.addQuestion(question, muthu);
        stackOverflow.addQuestion(question1, muthu);
        stackOverflow.addQuestion(question1, muthu);

        question.addAnswer(anbu, answer);

        question1.addAnswer(anbu, answer2);
        question2.addAnswer(anbu, answer3);


        System.out.println(stackOverflow.getMatchingQuestion("Java").getContent());
    }


}
