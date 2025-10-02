package LLDProblems.LibraryManagement;

public enum BookType {
    REGULAR(14, 4.0),
    REFERENCE(0, 1.0),
    SPECIAL_COLLECTION(7, 1.0);

    final int lateFee;
    final double dailyFineAmount;


    BookType(int i, double v) {
        this.lateFee = i;
        this.dailyFineAmount = v;
    }

    public int getLateFee(){return lateFee; }
    public double getDailyFineAmount() {return dailyFineAmount; }
}
