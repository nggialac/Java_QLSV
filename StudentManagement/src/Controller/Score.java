package Controller;

import Model.ClassList;
import Model.CreditClass;
import Model.Student;
import Model.Subject;
import java.util.ArrayList;
import java.util.Scanner;

public class Score {

    Scanner sc = new Scanner(System.in);
    Check Check = new Check();

    private int Class, Student, Verify, Temp;
    private float Score;

    public float GPA(ArrayList<Subject> arrSU, ArrayList<ClassList> arrCL, int Student) {
        float Total = 0;
        int Credit = 0;
        for (int i = 0; i < arrCL.size(); i++) {
            if (arrCL.get(i).GetStudentID() == Student && arrCL.get(i).GetScore() != -1) {
                for (int j = 0; j < arrSU.size(); j++) {
                    if (arrSU.get(j).GetID() == arrCL.get(i).GetID()) {
                        Temp = arrSU.get(j).GetID();
                        Credit = arrSU.get(j).GetCredit();
                        Total = Highest(arrCL, arrSU, Student, Temp) * Credit;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < arrCL.size(); i++) {
            if (arrCL.get(i).GetStudentID() == Student && arrCL.get(i).GetScore() != -1) {
                for (int j = 0; j < arrSU.size(); j++) {
                    if (arrSU.get(j).GetID() == arrCL.get(i).GetID()) {
                        if (arrSU.get(j).GetID() != Temp) {
                            Temp = arrSU.get(j).GetID();
                            Credit += arrSU.get(j).GetCredit();
                            Total += Highest(arrCL, arrSU, Student, Temp) * Credit;
                        }
                    }
                }
            }
        }
        if (Credit == 0) {
            return 0;
        }
        return Total / Credit;
    }

    public float Average(ArrayList<CreditClass> arrCC, ArrayList<ClassList> arrCL, int Class) {
        float Total = 0;
        int Quantity = 1;
        for (int i = 0; i < arrCL.size(); i++) {
            if (arrCL.get(i).GetCode() == Class) {
                Total += arrCL.get(i).GetScore();
            }
        }
        for (int i = 0; i < arrCC.size(); i++) {
            if (arrCC.get(i).GetCode() == Class) {
                Quantity = arrCC.get(i).GetQuantity();
            }
        }
        return Total / Quantity;
    }

    public float Average(ArrayList<CreditClass> arrCC, ArrayList<Subject> arrSU, ArrayList<ClassList> arrCL, int Student, int Session, int Term) {
        float Total = 0;
        int Credit = 0;
        for (int i = 0; i < arrCL.size(); i++) {
            if (arrCL.get(i).GetStudentID() == Student && arrCL.get(i).GetScore() != -1) {
                for (int j = 0; j < arrSU.size(); j++) {
                    if (arrSU.get(j).GetID() == arrCL.get(i).GetID()) {
                        for (int k = 0; k < arrCC.size(); k++) {
                            if (arrCC.get(k).GetID() == arrSU.get(j).GetID()) {
                                if (arrCC.get(k).GetSession() == Session && arrCC.get(k).GetTerm() == Term) {
                                    Credit += arrSU.get(j).GetCredit();
                                    Total += arrCL.get(i).GetScore() * Credit;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (Credit == 0) {
            return 0;
        }
        return Total / Credit;
    }

    public float Highest(ArrayList<ClassList> arrCL, ArrayList<Subject> arrSU, int Student, int Subject) {
        float Highest = -1;
        for (int i = 0; i < arrCL.size(); i++) {
            if (arrCL.get(i).GetID() == Subject && arrCL.get(i).GetStudentID() == Student) {
                if (arrCL.get(i).GetScore() > Highest) {
                    Highest = arrCL.get(i).GetScore();
                }
            }
        }
        return Highest;
    }

    public void Enter_Framework(ArrayList<CreditClass> arrCC, ArrayList<Student> arrST, ArrayList<ClassList> arrCL) {
        System.out.print("Enter: ");
        do {
            Class = sc.nextInt();
        } while (!Check.CreditClass(arrCC, Class) || Check.Entered(arrCL, Class) || Check.Empty(arrCL, Class) || Class == 0);
        System.out.println("ID" + "\t" + "NAME" + "\t" + "SCORE");
        for (int i = 0; i < arrCL.size(); i++) {
            if (arrCL.get(i).GetCode() == Class) {
                System.out.print(arrCL.get(i).toString());
                for (int j = 0; j < arrST.size(); j++) {
                    if (arrST.get(j).GetID() == arrCL.get(i).GetStudentID()) {
                        System.out.print(arrST.get(j).GetName() + "\t");
                        do {
                            Score = sc.nextFloat();
                        } while (Score < 0 || Score > 10);
                        arrCL.get(i).SetScore(Score);
                    }
                }
            }
        }
        System.out.print("Verify(0 - Exit|1 - OK): ");
        do {
            Verify = sc.nextInt();
        } while (Verify != 0 && Verify != 1);
        if (Verify == 0) {
            for (int i = 0; i < arrCL.size(); i++) {
                if (arrCL.get(i).GetCode() == Class) {
                    arrCL.get(i).SetScore(-1);
                }
            }
        }
    }

    public void Modify_Framework(ArrayList<CreditClass> arrCC, ArrayList<Student> arrST, ArrayList<ClassList> arrCL) {
        System.out.print("Select: ");
        do {
            Class = sc.nextInt();
        } while (!Check.CreditClass(arrCC, Class) || !Check.Entered(arrCL, Class) || Check.Empty(arrCL, Class) || Class == 0);
        System.out.println("ID" + "\t" + "NAME" + "\t" + "SCORE");
        for (int i = 0; i < arrCL.size(); i++) {
            if (arrCL.get(i).GetCode() == Class) {
                System.out.print(arrCL.get(i).toString());
                for (int j = 0; j < arrST.size(); j++) {
                    if (arrST.get(j).GetID() == arrCL.get(i).GetStudentID()) {
                        System.out.print(arrST.get(j).GetName() + "\t");
                        System.out.println(arrCL.get(i).GetScore());
                    }
                }
            }
        }
        System.out.print("Modify: ");
        do {
            Student = sc.nextInt();
        } while (!Check.Student(arrST, Student) || Student == 0);
        System.out.print("Update Score: ");
        do {
            Score = sc.nextFloat();
        } while (Score < 0 || Score > 10);
        System.out.print("Verify(0 - Exit|1 - OK): ");
        do {
            Verify = sc.nextInt();
        } while (Verify != 0 && Verify != 1);
        if (Verify == 1) {
            for (int i = 0; i < arrCL.size(); i++) {
                if (arrCL.get(i).GetStudentID() == Student && arrCL.get(i).GetCode() == Class) {
                    arrCL.get(i).SetScore(Score);
                }
            }
        }
    }
}
