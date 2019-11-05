package Controller;

import Model.CreditClass;
import Model.Student;
import Model.Subject;
import java.util.ArrayList;
import java.util.Scanner;

public class Modify {

    Scanner sc = new Scanner(System.in);
    Check Check = new Check();
    public String String;
    public int Number, Edit, Option;

    public void CreditClass_Framework(ArrayList<CreditClass> arrCC) {
        System.out.print("Edit: ");
        do {
            Edit = sc.nextInt();
        } while (!Check.CreditClass(arrCC, Edit) || Edit == 0);
        System.out.println("1. Term  2. Session  3. Limit");
        System.out.print("Option: ");
        do {
            Option = sc.nextInt();
        } while (Option != 1 && Option != 2 && Option != 3);
        sc.nextLine();
        if (Option == 1) {
            System.out.print("Update Term: ");
            do {
                Number = sc.nextInt();
            } while (Number < 0 || Number > 3);
        }
        if (Option == 2) {
            System.out.print("Update Session: ");
            do {
                Number = sc.nextInt();
            } while (Number < 2019 || Number > 2050);
        }
        if (Option == 3) {
            System.out.print("Update Limit: ");
            do {
                Number = sc.nextInt();
            } while (Number < 15 || Number > 150);
        }
    }

    public void Student_Framework(ArrayList<Student> arrST) {
        System.out.print("Edit: ");
        do {
            Edit = sc.nextInt();
        } while (!Check.Student(arrST, Edit) || Edit == 0);
        System.out.println("1. Name  2. Gender  3. Born  4. Phone  5. Address");
        System.out.print("Option: ");
        do {
            Option = sc.nextInt();
        } while (Option != 1 && Option != 2 && Option != 3 && Option != 4 && Option != 5);
        sc.nextLine();
        if (Option == 1) {
            System.out.print("Update Name: ");
            String = sc.nextLine();
        }
        if (Option == 2) {
            System.out.print("Update Gender: ");
            do {
                Number = sc.nextInt();
            } while (Number != 0 && Number != 1);
        }
        if (Option == 3) {
            System.out.print("Update Born: ");
            do {
                Number = sc.nextInt();
            } while (Number < 1989 && Number > 2001);
        }
        if (Option == 4) {
            System.out.print("Update Phone: ");
            String = sc.nextLine();
        }
        if (Option == 5) {
            System.out.print("Update Address: ");
            String = sc.nextLine();
        }
    }

    public void Subject_Framework(ArrayList<Subject> arrSU) {
        System.out.print("Edit: ");
        do {
            Edit = sc.nextInt();
        } while (!Check.Subject(arrSU, Edit) || Edit == 0);
        System.out.println("1. Name  2. Credit");
        System.out.print("Option: ");
        do {
            Option = sc.nextInt();
        } while (Option != 1 && Option != 2);
        sc.nextLine();
        if (Option == 1) {
            System.out.print("Update Name: ");
            String = sc.nextLine();
        }
        if (Option == 2) {
            System.out.print("Update Credit: ");
            Number = sc.nextInt();
        }
    }

    public void CreditClass(ArrayList<CreditClass> arrCC, int Pos, int Option, int Update) {
        for (int i = 0; i < arrCC.size(); i++) {
            if (arrCC.get(i).GetCode() == Pos) {
                if (Option == 1) {
                    arrCC.get(i).SetTerm(Update);
                }
                if (Option == 2) {
                    arrCC.get(i).SetSession(Update);
                }
                if (Option == 3) {
                    arrCC.get(i).SetLimit(Update);
                }
            }
        }
    }

    public void Student(ArrayList<Student> arrST, int Pos, int Option, String Update) {
        for (int i = 0; i < arrST.size(); i++) {
            if (arrST.get(i).GetID() == Pos) {
                if (Option == 1) {
                    arrST.get(i).SetName(Update);
                }
                if (Option == 4) {
                    arrST.get(i).SetPhone(Update);
                }
                if (Option == 5) {
                    arrST.get(i).SetAddress(Update);
                }
            }
        }
    }

    public void Student(ArrayList<Student> arrST, int Pos, int Option, int Update) {
        for (int i = 0; i < arrST.size(); i++) {
            if (arrST.get(i).GetID() == Pos) {
                if (Option == 2) {
                    arrST.get(i).SetGender(Update);
                }
                if (Option == 3) {
                    arrST.get(i).SetYear(Update);
                }
            }
        }
    }

    public void Subject(ArrayList<Subject> arrSU, int Pos, String Update) {
        for (int i = 0; i < arrSU.size(); i++) {
            if (arrSU.get(i).GetID() == Pos) {
                arrSU.get(i).SetName(Update);
            }
        }
    }

    public void Subject(ArrayList<Subject> arrSU, int Pos, int Update) {
        for (int i = 0; i < arrSU.size(); i++) {
            if (arrSU.get(i).GetID() == Pos) {
                arrSU.get(i).SetCredit(Update);
            }
        }
    }
}
