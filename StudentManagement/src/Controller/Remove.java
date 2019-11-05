package Controller;

import Model.ClassList;
import Model.CreditClass;
import Model.Student;
import Model.Subject;
import java.util.ArrayList;
import java.util.Scanner;

public class Remove {

    public int Delete;
    Scanner sc = new Scanner(System.in);
    Check Check = new Check();

    public void CreditClass_Framework(ArrayList<CreditClass> arrCC) {
        System.out.print("Delete(ID|0 for Clear ALL): ");
        do {
            Delete = sc.nextInt();
        } while (!Check.CreditClass(arrCC, Delete));
    }

    public void Student_Framework(ArrayList<Student> arrST) {
        System.out.print("Delete(ID|0 for Clear ALL): ");
        do {
            Delete = sc.nextInt();
        } while (!Check.Student(arrST, Delete));
    }

    public void Subject_Framework(ArrayList<Subject> arrSU) {
        System.out.print("Delete(ID|0 for Clear ALL): ");
        do {
            Delete = sc.nextInt();
        } while (!Check.Subject(arrSU, Delete));
    }

    public void CreditClass(ArrayList<CreditClass> arrCC, int Pos, String Obj) {
        for (int i = 0; i < arrCC.size(); i++) {
            if (Obj == "CC" && arrCC.get(i).GetCode() == Pos) {
                arrCC.remove(i);
            }
            if (Obj == "SU" && arrCC.get(i).GetID() == Pos) {
                arrCC.remove(i);
            }
        }
    }

    public void Student(ArrayList<Student> arrST, int Pos) {
        for (int i = 0; i < arrST.size(); i++) {
            if (arrST.get(i).GetID() == Pos) {
                arrST.remove(i);
            }
        }
    }

    public void Subject(ArrayList<Subject> arrSU, int Pos) {
        for (int i = 0; i < arrSU.size(); i++) {
            if (arrSU.get(i).GetID() == Pos) {
                arrSU.remove(i);
            }
        }
    }

    public void ClassList(ArrayList<ClassList> arrCL, int Pos, String Obj) {
        for (int i = 0; i < arrCL.size(); i++) {
            if (Obj == "CC" && arrCL.get(i).GetCode() == Pos) {
                arrCL.remove(i);
            }
            if (Obj == "ST" && arrCL.get(i).GetStudentID() == Pos) {
                arrCL.remove(i);
            }
            if (Obj == "SU" && arrCL.get(i).GetID() == Pos) {
                arrCL.remove(i);
            }
        }
    }

    public void Escape(ArrayList<ClassList> arrCL, int Code, int ID) {
        for (int i = 0; i < arrCL.size(); i++) {
            if (arrCL.get(i).GetCode() == Code && arrCL.get(i).GetStudentID() == ID) {
                arrCL.remove(i);
            }
        }
    }
}
