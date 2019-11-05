package Controller;

import java.util.Scanner;

public class Operate {

    public int Select, Run;
    Scanner sc = new Scanner(System.in);

    public void Menu() {
        System.out.println("---------MENU--------");
        System.out.println("  1 . Credit Class");
        System.out.println("  2 . Student");
        System.out.println("  3 . Subject");
        System.out.println("  4 . Score");
        System.out.println("  5 . View");
        System.out.println("  6 . Exit");
        System.out.print("Select: ");
        do {
            Select = sc.nextInt();
        } while (Select != 1 && Select != 2 && Select != 3 && Select != 4 && Select != 5 && Select != 6);
    }

    public void Continue() {
        System.out.println("----Continue----");
        System.out.println("  1 . Menu");
        System.out.println("  2 . Exit");
        System.out.print("Select: ");
        do {
            Run = sc.nextInt();
        } while (Run != 1 && Run != 2);
        if (Run == 2) {
            System.exit(0);
        }
    }

    public void CreditClass() {
        System.out.println("----CREDIT CLASS----");
        System.out.println("  1 . Add");
        System.out.println("  2 . Delete");
        System.out.println("  3 . Edit");
        System.out.print("Select: ");
        do {
            Select = sc.nextInt();
        } while (Select != 1 && Select != 2 && Select != 3);
    }

    public void Student() {
        System.out.println("-------STUDENT-------");
        System.out.println("  1 . Register");
        System.out.println("  2 . Escape");
        System.out.println("  3 . Add");
        System.out.println("  4 . Delete");
        System.out.println("  5 . Edit");
        System.out.print("Select: ");
        do {
            Select = sc.nextInt();
        } while (Select != 1 && Select != 2 && Select != 3 && Select != 4 && Select != 5);
    }

    public void Subject() {
        System.out.println("------SUBJECT------");
        System.out.println("  1 . Add");
        System.out.println("  2 . Delete");
        System.out.println("  3 . Edit");
        System.out.print("Select: ");
        do {
            Select = sc.nextInt();
        } while (Select != 1 && Select != 2 && Select != 3);
    }

    public void Score() {
        System.out.println("------SCORE------");
        System.out.println("  1 . Enter");
        System.out.println("  2 . Modify");
        System.out.print("Select: ");
        do {
            Select = sc.nextInt();
        } while (Select != 1 && Select != 2);
    }

    public void Score_View() {
        System.out.println("-----SCORE-VIEW-----");
        System.out.println("  1 . Course");
        System.out.println("  2 . Person");
        System.out.print("Select: ");
        do {
            Select = sc.nextInt();
        } while (Select != 1 && Select != 2);
    }

    public void Person_View() {
        System.out.println("-----PERSON-VIEW-----");
        System.out.println("  1 . Subject");
        System.out.println("  2 . Term");
        System.out.println("  3 . GPA");
        System.out.print("Select: ");
        do {
            Select = sc.nextInt();
        } while (Select != 1 && Select != 2 && Select != 3);
    }

    public void View() {
        System.out.println("---------VIEW---------");
        System.out.println("  1 . Credit Class");
        System.out.println("  2 . Student");
        System.out.println("  3 . Subject");
        System.out.println("  4 . Score");
        System.out.print("Select: ");
        do {
            Select = sc.nextInt();
        } while (Select != 1 && Select != 2 && Select != 3 && Select != 4);
    }
}
