package streams;

public class ExamData {
    private final String studentName;
    private final  Double testScore;

    public ExamData(String studentName, Double testScore) {
        this.studentName = studentName;
        this.testScore = testScore;
    }

    public String getStudentName() {
        return studentName;
    }

    public Double getTestScore() {
        return testScore;
    }


}
