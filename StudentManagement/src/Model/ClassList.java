package Model;

public class ClassList extends CreditClass {

    private int StudentID;
    private float Score;

    public ClassList(int Code, int SubjectCode, int StudentID, float Score) {
        this.Code = Code;
        this.ID = SubjectCode;
        this.StudentID = StudentID;
        this.Score = Score;
    }

    public ClassList() {
        super();
    }

    public float GetScore() {
        return Score;
    }

    public void SetScore(float Score) {
        this.Score = Score;
    }

    public int GetStudentID() {
        return StudentID;
    }

    public void SetStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

    @Override
    public String toString() {
        return this.StudentID + "\t";
    }
}
