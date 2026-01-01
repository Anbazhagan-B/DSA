package LLD2.StackOverflow;

public class Answer {
    long answerId;
    String answer;
    public Answer(long answerId, String answer)
    {
        this.answer = answer;
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }
}
