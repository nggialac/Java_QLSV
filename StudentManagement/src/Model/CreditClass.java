package Model;

public class CreditClass extends Subject {

    private int Session, Term, Limit, Quantity;
    protected int Code;

    public CreditClass(int Code, int SubjectCode, int Term, int Session, int Quantity, int Limit) {
        this.Code = Code;
        this.ID = SubjectCode;
        this.Term = Term;
        this.Session = Session;
        this.Limit = Limit;
        this.Quantity = Quantity;
    }

    public CreditClass() {
        super();
    }

    public int GetCode() {
        return Code;
    }

    public void SetCode(int Code) {
        this.Code = Code;
    }

    public int GetSession() {
        return Session;
    }

    public void SetSession(int Session) {
        this.Session = Session;
    }

    public int GetTerm() {
        return Term;
    }

    public void SetTerm(int Term) {
        this.Term = Term;
    }

    public int GetLimit() {
        return Limit;
    }

    public void SetLimit(int Limit) {
        this.Limit = Limit;
    }

    public int GetQuantity() {
        return Quantity;
    }

    public void SetQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    @Override
    public void Import() {
        System.out.print(" - Term: ");
        do {
            Term = sc.nextInt();
        } while (Term <= 0 || Term > 3);
        System.out.print(" - Session: ");
        do {
            Session = sc.nextInt();
        } while (Session < 2019 || Session > 2050);
        System.out.print(" - Limit: ");
        do {
            Limit = sc.nextInt();
        } while (Limit <= 15 || Limit > 150);
    }

    @Override
    public String toString() {
        return this.Code + "\t" + this.ID + "\t" + "\t" + this.Term + "\t" + this.Session + "\t" + this.Quantity + "\t" + "\t" + this.Limit;
    }
}
