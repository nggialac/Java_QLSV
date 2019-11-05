package Controller;

import Model.ClassList;
import Model.CreditClass;
import Model.Student;
import Model.Subject;
import java.util.ArrayList;
import java.util.Scanner;

public class Update {

    Scanner sc = new Scanner(System.in);
    private int Count, Limit, Subject, Student, Class, Verify, Temp;
    Display Display = new Display();
    Check Check = new Check();
    Remove Remove = new Remove();

    public void Register_Framework(ArrayList<CreditClass> arrCC, ArrayList<Student> arrST, ArrayList<Subject> arrSU, ArrayList<ClassList> arrCL) {
        Display.Student(arrST);
        System.out.print("Select: ");
        do {
            Student = sc.nextInt();
        } while (!Check.Student(arrST, Student) || Student == 0);
        Display.Subject(arrSU);
        System.out.print("Select: ");
        do {
            Subject = sc.nextInt();
        } while (!Check.Subject(arrSU, Subject) || Subject == 0);
        Display.CreditClass(arrCC, Subject);
        System.out.print("Select: ");
        do {
            Class = sc.nextInt();
        } while (!Check.CreditClass(arrCC, Class) || Class == 0 || Check.Full(arrCC, Class));
        ClassList CL = new ClassList();
        CL.SetCode(Class);
        CL.SetID(Subject);
        CL.SetStudentID(Student);
        CL.SetScore(-1);
        for (int i = 0; i < arrCC.size(); i++) {
            if (arrCC.get(i).GetCode() == Class) {
                Temp = arrCC.get(i).GetQuantity();
                arrCC.get(i).SetQuantity(Temp + 1);
            }
        }
        arrCL.add(CL);
    }

    public void Escape_Framework(ArrayList<CreditClass> arrCC, ArrayList<Student> arrST, ArrayList<Subject> arrSU, ArrayList<ClassList> arrCL) {
        Display.Student(arrST);
        System.out.print("Select(Student ID): ");
        do {
            Student = sc.nextInt();
        } while (!Check.Student(arrST, Student) || Student == 0);
        Display.CreditClass(arrCC, arrCL, Student);
        System.out.print("Select(Class Code): ");
        do {
            Class = sc.nextInt();
        } while (!Check.CreditClass(arrCC, Class) || Class == 0);
        System.out.print("Verify(0 - Exit|1 - OK): ");
        do {
            Verify = sc.nextInt();
        } while (Verify != 0 && Verify != 1);
        if (Verify == 1) {
            Remove.Escape(arrCL, Class, Student);
            for (int i = 0; i < arrCC.size(); i++) {
                if (arrCC.get(i).GetCode() == Class) {
                    Temp = arrCC.get(i).GetQuantity();
                    arrCC.get(i).SetQuantity(Temp - 1);
                }
            }
        }
    }

    public void CreditClass_Framework(ArrayList<CreditClass> arrCC, ArrayList<Subject> arrSU) {
        System.out.print("Import the number: ");
        do {
            Count = sc.nextInt();
        } while (Count <= 0);
        Limit = Count + arrCC.size();
        Display.Subject(arrSU);
        for (int i = arrCC.size(); i < Limit; i++) {
            System.out.print("* Credit Class #");
            if (arrCC.isEmpty()) {
                System.out.println(i + 1);
            } else {
                System.out.println(arrCC.get(arrCC.size() - 1).GetCode() + 1);
            }
            CreditClass CC = new CreditClass();
            System.out.print(" - Subject Code: ");
            do {
                Subject = sc.nextInt();
            } while (!Check.Subject(arrSU, Subject) || Subject == 0);
            CC.SetID(Subject);
            CC.Import();
            if (arrCC.isEmpty()) {
                CC.SetCode(i + 1);
            } else {
                CC.SetCode(arrCC.get(arrCC.size() - 1).GetCode() + 1);
            }
            CC.SetQuantity(0);
            arrCC.add(CC);
        }
    }

    public void Student_Framework(ArrayList<Student> arrST) {
        System.out.print("Import the number: ");
        do {
            Count = sc.nextInt();
        } while (Count <= 0);
        Limit = Count + arrST.size();
        for (int i = arrST.size(); i < Limit; i++) {
            System.out.print("* Student #");
            if (arrST.isEmpty()) {
                System.out.println(i + 1);
            } else {
                System.out.println(arrST.get(arrST.size() - 1).GetID() + 1);
            }
            Student ST = new Student();
            ST.Import();
            if (arrST.isEmpty()) {
                ST.SetID(i + 1);
            } else {
                ST.SetID(arrST.get(arrST.size() - 1).GetID() + 1);
            }
            arrST.add(ST);
        }
    }

    public void Subject_Framework(ArrayList<Subject> arrSU) {
        System.out.print("Import the number: ");
        do {
            Count = sc.nextInt();
        } while (Count <= 0);
        Limit = Count + arrSU.size();
        for (int i = arrSU.size(); i < Limit; i++) {
            System.out.print("* Subject #");
            if (arrSU.isEmpty()) {
                System.out.println(i + 1);
            } else {
                System.out.println(arrSU.get(arrSU.size() - 1).GetID() + 1);
            }
            Subject SU = new Subject();
            SU.Import();
            if (arrSU.isEmpty()) {
                SU.SetID(i + 1);
            } else {
                SU.SetID(arrSU.get(arrSU.size() - 1).GetID() + 1);
            }
            arrSU.add(SU);
        }
    }
}
