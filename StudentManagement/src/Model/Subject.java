package Model;

import java.util.Scanner;

public class Subject {

    protected int ID;
    private int Credit;
    private String Name;
    Scanner sc = new Scanner(System.in);

    public Subject(int ID, String Name, int Credit) {
        this.ID = ID;
        this.Name = Name;
        this.Credit = Credit;
    }

    public Subject() {
    }

    public int GetID() {
        return ID;
    }

    public void SetID(int ID) {
        this.ID = ID;
    }

    public int GetCredit() {
        return Credit;
    }

    public void SetCredit(int Credit) {
        this.Credit = Credit;
    }

    public String GetName() {
        return Name;
    }

    public void SetName(String Name) {
        this.Name = Name;
    }

    public void Import() {
        System.out.print(" - Name: ");
        Name = sc.nextLine();
        System.out.print(" - Credit: ");
        do {
            Credit = sc.nextInt();
        } while (Credit <= 0 || Credit >= 10);
    }

    @Override
    public String toString() {
        return this.ID + "\t" + this.Name + "\t" + this.Credit;
    }
}
