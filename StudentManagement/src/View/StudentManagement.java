package View;

//CONTROLLER
import Controller.Operate;
import Controller.Remove;
import Controller.Modify;
import Controller.Display;
import Controller.File;
import Controller.Score;
import Controller.Update;
//MODEL
import Model.ClassList;
import Model.CreditClass;
import Model.Student;
import Model.Subject;
//LIBRARY
import java.util.ArrayList;
import java.io.IOException;

public class StudentManagement {

    public static void main(String[] args) throws IOException {
        //Array
        ArrayList<CreditClass> arrCC = new ArrayList<>();
        ArrayList<Student> arrST = new ArrayList<>();
        ArrayList<Subject> arrSU = new ArrayList<>();
        ArrayList<ClassList> arrCL = new ArrayList<>();
        //Entity
        Operate Operate = new Operate();
        Remove Remove = new Remove();
        Modify Modify = new Modify();
        Display Display = new Display();
        Update Update = new Update();
        File File = new File();
        Score Score = new Score();
        //Load
        arrCC = File.readCreditClassFromFile("Credit_Class.txt");
        arrST = File.readStudentFromFile("Student.txt");
        arrSU = File.readSubjectFromFile("Subject.txt");
        arrCL = File.readClassListFromFile("Class_List.txt");
        do {
            Operate.Menu();
            switch (Operate.Select) {
                case 1:
                    Operate.CreditClass();
                    switch (Operate.Select) {
                        case 1:
                            Update.CreditClass_Framework(arrCC, arrSU);
                            break;
                        case 2:
                            Display.CreditClass(arrCC);
                            Remove.CreditClass_Framework(arrCC);
                            if (Remove.Delete == 0) {
                                arrCC.clear();
                                arrCL.clear();
                            } else {
                                Remove.CreditClass(arrCC, Remove.Delete, "CC");
                                Remove.ClassList(arrCL, Remove.Delete, "CC");
                            }
                            break;
                        case 3:
                            Display.CreditClass(arrCC);
                            Modify.CreditClass_Framework(arrCC);
                            Modify.CreditClass(arrCC, Modify.Edit, Modify.Option, Modify.Number);
                    }
                    break;
                case 2:
                    Operate.Student();
                    switch (Operate.Select) {
                        case 1:
                            Update.Register_Framework(arrCC, arrST, arrSU, arrCL);
                            break;
                        case 2:
                            Update.Escape_Framework(arrCC, arrST, arrSU, arrCL);
                            break;
                        case 3:
                            Update.Student_Framework(arrST);
                            break;
                        case 4:
                            Display.Student(arrST);
                            Remove.Student_Framework(arrST);
                            if (Remove.Delete == 0) {
                                arrST.clear();
                            } else {
                                Remove.Student(arrST, Remove.Delete);
                                Remove.ClassList(arrCL, Remove.Delete, "ST");
                            }
                            break;
                        case 5:
                            Display.Student(arrST);
                            Modify.Student_Framework(arrST);
                            if (Modify.Option == 1 || Modify.Option == 4 || Modify.Option == 5) {
                                Modify.Student(arrST, Modify.Edit, Modify.Option, Modify.String);
                            } else {
                                Modify.Student(arrST, Modify.Edit, Modify.Option, Modify.Number);
                            }
                            break;
                        default:
                            break;
                    }
                    break;
                case 3:
                    Operate.Subject();
                    switch (Operate.Select) {
                        case 1:
                            Update.Subject_Framework(arrSU);
                            break;
                        case 2:
                            Display.Subject(arrSU);
                            Remove.Subject_Framework(arrSU);
                            if (Remove.Delete == 0) {
                                arrSU.clear();
                                arrCC.clear();
                                arrCL.clear();
                            } else {
                                Remove.Subject(arrSU, Remove.Delete);
                                Remove.CreditClass(arrCC, Remove.Delete, "SU");
                                Remove.ClassList(arrCL, Remove.Delete, "SU");
                            }
                            break;
                        case 3:
                            Display.Subject(arrSU);
                            Modify.Subject_Framework(arrSU);
                            if (Modify.Option == 1) {
                                Modify.Subject(arrSU, Modify.Edit, Modify.String);
                            } else {
                                Modify.Subject(arrSU, Modify.Edit, Modify.Number);
                            }
                            break;
                        default:
                            break;
                    }
                    break;
                case 4:
                    Operate.Score();
                    switch (Operate.Select) {
                        case 1:
                            Display.CreditClass(arrCC);
                            Score.Enter_Framework(arrCC, arrST, arrCL);
                            break;
                        case 2:
                            Display.CreditClass(arrCC);
                            Score.Modify_Framework(arrCC, arrST, arrCL);
                            break;
                        default:
                            break;
                    }
                    break;
                case 5:
                    Operate.View();
                    switch (Operate.Select) {
                        case 1:
                            Display.ClassList(arrCC, arrST, arrCL);
                            break;
                        case 2:
                            Display.Student(arrST);
                            break;
                        case 3:
                            Display.Subject(arrSU);
                            break;
                        case 4:
                            Operate.Score_View();
                            switch (Operate.Select) {
                                case 1:
                                    Display.ClassList(arrCC, arrST, arrCL);
                                    break;
                                case 2:
                                    Operate.Person_View();
                                    switch (Operate.Select) {
                                        case 1:
                                            Display.Student(arrST);
                                            Display.Subject_Score(arrCC, arrST, arrSU, arrCL);
                                            break;
                                        case 2:
                                            Display.Student(arrST);
                                            Display.Term_Score(arrCC, arrST, arrSU, arrCL);
                                            break;
                                        case 3:
                                            Display.Student(arrST);
                                            Display.GPA_Score(arrST, arrSU, arrCL);
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                default:
                                    break;
                            }
                            break;
                        default:
                            break;
                    }
                    break;
                case 6:
                    System.exit(0);
                default:
                    break;
            }
            File.Save(arrCL, arrST, arrCC, arrSU);
            Operate.Continue();
        } while (Operate.Run == 1);
    }
}
