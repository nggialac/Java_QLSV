package Controller;

import Model.CreditClass;
import Model.Student;
import Model.Subject;
import Model.ClassList;
import java.util.ArrayList;
import java.util.Scanner;

public class Display {

    Scanner sc = new Scanner(System.in);
    Check Check = new Check();
    Score Score = new Score();
    private int Class, Student, Subject, Term, Session;

    public void CreditClass(ArrayList<CreditClass> arrCC) {
        System.out.println("--------------------");
        System.out.println("CODE" + "\t" + "SUBJECT CODE" + "\t" + "TERM" + "\t" + "SESSION" + "\t" + "QUANTITY" + "\t" + "LIMIT");
        for (int i = 0; i < arrCC.size(); i++) {
            System.out.println(arrCC.get(i).toString());
        }
    }

    public void CreditClass(ArrayList<CreditClass> arrCC, int Code) {
        System.out.println("--------------------");
        System.out.println("CODE" + "\t" + "SUBJECT CODE" + "\t" + "TERM" + "\t" + "SESSION" + "\t" + "QUANTITY" + "\t" + "LIMIT");
        for (int i = 0; i < arrCC.size(); i++) {
            if (arrCC.get(i).GetID() == Code) {
                System.out.println(arrCC.get(i).toString());
            }
        }
    }

    public void CreditClass(ArrayList<CreditClass> arrCC, ArrayList<ClassList> arrCL, int ID) {
        System.out.println("--------------------");
        System.out.println("CODE" + "\t" + "SUBJECT CODE" + "\t" + "TERM" + "\t" + "SESSION" + "\t" + "QUANTITY" + "\t" + "LIMIT");
        for (int i = 0; i < arrCC.size(); i++) {
            for (int j = 0; j < arrCL.size(); j++) {
                if (arrCL.get(j).GetStudentID() == ID && arrCL.get(j).GetCode() == arrCC.get(i).GetCode()) {
                    System.out.println(arrCC.get(i).toString());
                }
            }
        }
    }

    public void Student(ArrayList<Student> arrST) {
        System.out.println("--------------------");
        System.out.println("ID" + "\t" + "NAME" + "\t" + "GENDER" + "\t" + "BORN" + "\t" + "PHONE" + "\t" + "ADDRESS");
        for (int i = 0; i < arrST.size(); i++) {
            System.out.println(arrST.get(i).toString());
        }
    }

    public void Student(ArrayList<Student> arrST, int Student) {
        System.out.println("--------------------");
        System.out.println("ID" + "\t" + "NAME" + "\t" + "GENDER" + "\t" + "BORN" + "\t" + "PHONE" + "\t" + "ADDRESS");
        for (int i = 0; i < arrST.size(); i++) {
            if (arrST.get(i).GetID() == Student) {
                System.out.println(arrST.get(i).toString());
            }
        }
    }

    public void Subject(ArrayList<Subject> arrSU) {
        System.out.println("--------------------");
        System.out.println("ID" + "\t" + "NAME" + "\t" + "CREDIT");
        for (int i = 0; i < arrSU.size(); i++) {
            System.out.println(arrSU.get(i).toString());
        }
    }

    private void Subject(ArrayList<Subject> arrSU, ArrayList<ClassList> arrCL, int Student) {
        for (int i = 0; i < arrCL.size(); i++) {
            if (arrCL.get(i).GetStudentID() == Student) {
                for (int j = 0; j < arrSU.size(); j++) {
                    if (arrSU.get(j).GetID() == arrCL.get(i).GetID()) {
                        System.out.println(arrSU.get(j).toString() + "\t");
                    }
                }
            }
        }
    }

    public void ClassList(ArrayList<CreditClass> arrCC, ArrayList<Student> arrST, ArrayList<ClassList> arrCL) {
        CreditClass(arrCC);
        System.out.print("View|0 for Exit: ");
        do {
            Class = sc.nextInt();
        } while (!Check.CreditClass(arrCC, Class));
        if (Class != 0) {
            System.out.println("--------------------");
            System.out.println("CODE" + "\t" + "SUBJECT CODE" + "\t" + "TERM" + "\t" + "SESSION" + "\t" + "QUANTITY" + "\t" + "LIMIT");
            for (int i = 0; i < arrCC.size(); i++) {
                if (arrCC.get(i).GetCode() == Class) {
                    System.out.println(arrCC.get(i).toString());
                }
            }
            System.out.println("ID" + "\t" + "NAME" + "\t" + "SCORE");
            for (int i = 0; i < arrCL.size(); i++) {
                if (arrCL.get(i).GetCode() == Class) {
                    System.out.print(arrCL.get(i).toString());
                    for (int j = 0; j < arrST.size(); j++) {
                        if (arrST.get(j).GetID() == arrCL.get(i).GetStudentID()) {
                            System.out.print(arrST.get(j).GetName() + "\t");
                            if (arrCL.get(i).GetScore() != -1) {
                                System.out.println(arrCL.get(i).GetScore());
                            } else {
                                System.out.println("null");
                            }
                        }
                    }
                }
            }
            if (Score.Average(arrCC, arrCL, Class) != -1) {
                System.out.println("Average: " + Score.Average(arrCC, arrCL, Class));
            } else {
                System.out.println("Average: null");
            }
        }
    }

    public void Subject_Score(ArrayList<CreditClass> arrCC, ArrayList<Student> arrST, ArrayList<Subject> arrSU, ArrayList<ClassList> arrCL) {
        System.out.print("Student|0 for Exit: ");
        do {
            Student = sc.nextInt();
        } while (!Check.Student(arrST, Student));
        if (Student != 0) {
            System.out.println("--------------------");
            System.out.println("ID" + "\t" + "NAME" + "\t" + "CREDIT");
            Subject(arrSU, arrCL, Student);
            System.out.print("Subject|0 for Exit: ");
            do {
                Subject = sc.nextInt();
            } while (!Check.Subject(arrSU, Subject));
            if (Subject != 0) {
                System.out.print("-----");
                for (int i = 0; i < arrSU.size(); i++) {
                    if (arrSU.get(i).GetID() == Subject) {
                        System.out.println(arrSU.get(i).GetName() + "-----");
                        break;
                    }
                }
                System.out.println("CLASS" + "\t" + "TERM" + "\t" + "SESSION" + "\t" + "SCORE");
                for (int i = 0; i < arrCL.size(); i++) {
                    if (arrCL.get(i).GetID() == Subject && arrCL.get(i).GetStudentID() == Student) {
                        System.out.print(arrCL.get(i).GetCode() + "\t");
                        for (int j = 0; j < arrCC.size(); j++) {
                            if (arrCC.get(j).GetCode() == arrCL.get(i).GetCode()) {
                                System.out.print(arrCC.get(j).GetTerm() + "\t" + arrCC.get(j).GetSession() + "\t");
                                if (arrCL.get(i).GetScore() != -1) {
                                    System.out.println(arrCL.get(i).GetScore());
                                } else {
                                    System.out.println("null");
                                }
                            }
                        }
                    }
                }
                System.out.println("Highest Score: " + Score.Highest(arrCL, arrSU, Student, Subject));
            }
        }
    }

    private void Session(ArrayList<CreditClass> arrCC, ArrayList<ClassList> arrCL, int Student) {
        int Temp = 0, k = 2;
        for (int i = 0; i < arrCL.size(); i++) {
            if (arrCL.get(i).GetStudentID() == Student) {
                for (int j = 0; j < arrCC.size(); j++) {
                    if (arrCC.get(j).GetCode() == arrCL.get(i).GetCode()) {
                        Temp = arrCC.get(j).GetSession();
                        break;
                    }
                }
            }
        }
        System.out.println("-------");
        System.out.println("SESSION");
        System.out.println("1. " + Temp);
        for (int i = 0; i < arrCL.size(); i++) {
            if (arrCL.get(i).GetStudentID() == Student) {
                for (int j = 0; j < arrCC.size(); j++) {
                    if (arrCC.get(j).GetCode() == arrCL.get(i).GetCode()) {
                        if (arrCC.get(j).GetSession() != Temp) {
                            Temp = arrCC.get(j).GetSession();
                            System.out.println(k + ". " + Temp);
                            k++;
                        }
                    }
                }
            }
        }
    }

    public void Term_Score(ArrayList<CreditClass> arrCC, ArrayList<Student> arrST, ArrayList<Subject> arrSU, ArrayList<ClassList> arrCL) {
        System.out.print("Student|0 for Exit: ");
        do {
            Student = sc.nextInt();
        } while (!Check.Student(arrST, Student));
        if (Student != 0) {
            Session(arrCC, arrCL, Student);
            System.out.print("Session|0 for Exit: ");
            do {
                Session = sc.nextInt();
            } while (!Check.Session(arrCC, arrCL, Student, Session));
            if (Session != 0) {
                System.out.print("Term|0 for Exit: ");
                do {
                    Term = sc.nextInt();
                } while (Term < 0 || Term > 3);
                if (Term != 0) {
                    System.out.println("--------------------");
                    System.out.println("ID" + "\t" + "NAME" + "\t" + "CREDIT" + "\t" + "SCORE");
                    for (int i = 0; i < arrCL.size(); i++) {
                        if (arrCL.get(i).GetStudentID() == Student) {
                            for (int j = 0; j < arrCC.size(); j++) {
                                if (arrCC.get(j).GetCode() == arrCL.get(i).GetCode() && arrCC.get(j).GetTerm() == Term && arrCC.get(j).GetSession() == Session) {
                                    for (int k = 0; k < arrSU.size(); k++) {
                                        if (arrSU.get(k).GetID() == arrCC.get(j).GetID()) {
                                            System.out.print(arrSU.get(k).toString() + "\t");
                                            System.out.println(arrCL.get(i).GetScore());
                                        }
                                    }
                                }
                            }
                        }
                    }
                    System.out.println("Average: " + Score.Average(arrCC, arrCL, Class));
                }
            }
        }
    }

    public void GPA_Score(ArrayList<Student> arrST, ArrayList<Subject> arrSU, ArrayList<ClassList> arrCL) {
        System.out.print("Student|0 for Exit: ");
        do {
            Student = sc.nextInt();
        } while (!Check.Student(arrST, Student));
        if (Student != 0) {
            Student(arrST, Student);
            System.out.println("GPA: " + Score.GPA(arrSU, arrCL, Student));
        }
    }
}
