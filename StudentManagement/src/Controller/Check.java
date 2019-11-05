package Controller;

import Model.ClassList;
import Model.CreditClass;
import Model.Student;
import Model.Subject;
import java.util.ArrayList;

public class Check {

    public boolean Session(ArrayList<CreditClass> arrCC, ArrayList<ClassList> arrCL, int Student, int Session) {
        if (Session == 0) {
            return true;
        }
        for (int i = 0; i < arrCL.size(); i++) {
            if (arrCL.get(i).GetStudentID() == Student) {
                for (int j = 0; j < arrCC.size(); j++) {
                    if (arrCC.get(j).GetSession() == Session) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean Full(ArrayList<CreditClass> arrCC, int Class) {
        for (int i = 0; i < arrCC.size(); i++) {
            if (arrCC.get(i).GetCode() == Class) {
                if (arrCC.get(i).GetQuantity() == arrCC.get(i).GetLimit()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean Entered(ArrayList<ClassList> arrCL, int Class) {
        for (int i = 0; i < arrCL.size(); i++) {
            if (arrCL.get(i).GetCode() == Class) {
                if (arrCL.get(i).GetScore() == -1) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean Empty(ArrayList<ClassList> arrCL, int Class) {
        for (int i = 0; i < arrCL.size(); i++) {
            if (arrCL.get(i).GetCode() == Class) {
                return false;
            }
        }
        return true;
    }

    public boolean CreditClass(ArrayList<CreditClass> arrCC, int Pos) {
        if (Pos == 0) {
            return true;
        }
        for (int i = 0; i < arrCC.size(); i++) {
            if (arrCC.get(i).GetCode() == Pos) {
                return true;
            }
        }
        return false;
    }

    public boolean Student(ArrayList<Student> arrST, int Pos) {
        if (Pos == 0) {
            return true;
        }
        for (int i = 0; i < arrST.size(); i++) {
            if (arrST.get(i).GetID() == Pos) {
                return true;
            }
        }
        return false;
    }

    public boolean Subject(ArrayList<Subject> arrSU, int Pos) {
        if (Pos == 0) {
            return true;
        }
        for (int i = 0; i < arrSU.size(); i++) {
            if (arrSU.get(i).GetID() == Pos) {
                return true;
            }
        }
        return false;
    }
}
