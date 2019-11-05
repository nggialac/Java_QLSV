package Controller;

import Model.ClassList;
import Model.CreditClass;
import Model.Student;
import Model.Subject;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class File {

    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private PrintWriter printWriter;
    private Scanner scanner;

    private void openFileToWrite(String fileName) {
        try {
            fileWriter = new FileWriter(fileName, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
        } catch (IOException E) {
            E.printStackTrace();
        }
    }

    private void openFileToRead(String fileName) {
        try {
            scanner = new Scanner(Paths.get(fileName), "UTF-8");
        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    private void closeFileAfterWrite() {
        try {
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    private void closeFileAfterRead() {
        try {
            scanner.close();
        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    private void writeCreditCLassToFile(CreditClass CC, String fileName) {
        openFileToWrite(fileName);
        printWriter.println(CC.GetCode() + "\t" + CC.GetID() + "\t"
                + CC.GetTerm() + "\t" + CC.GetSession() + "\t"
                + CC.GetQuantity() + "\t" + CC.GetLimit());
        closeFileAfterWrite();
    }

    public ArrayList<CreditClass> readCreditClassFromFile(String fileName) {
        openFileToRead(fileName);
        ArrayList<CreditClass> arrCC = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            CreditClass CC = createCreditClassFromData(data);
            arrCC.add(CC);
        }
        closeFileAfterRead();
        return arrCC;
    }

    private CreditClass createCreditClassFromData(String data) {
        String[] datas = data.split("\t");
        CreditClass CC = new CreditClass(Integer.parseInt(datas[0]), Integer.parseInt(datas[1]),
                Integer.parseInt(datas[2]), Integer.parseInt(datas[3]), Integer.parseInt(datas[4]), Integer.parseInt(datas[5]));
        return CC;
    }

    private void writeStudentToFile(Student ST, String fileName) {
        openFileToWrite(fileName);
        printWriter.println(ST.GetID() + "\t" + ST.GetName() + "\t"
                + ST.GetGender() + "\t" + ST.GetYear() + "\t"
                + ST.GetPhone() + "\t" + ST.GetAddress());
        closeFileAfterWrite();
    }

    public ArrayList<Student> readStudentFromFile(String fileName) {
        openFileToRead(fileName);
        ArrayList<Student> arrST = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            Student ST = createStudentFromData(data);
            arrST.add(ST);
        }
        closeFileAfterRead();
        return arrST;
    }

    private Student createStudentFromData(String data) {
        String[] datas = data.split("\t");
        Student ST = new Student(Integer.parseInt(datas[0]), datas[1],
                Integer.parseInt(datas[2]), Integer.parseInt(datas[3]),
                datas[4], datas[5]);
        return ST;
    }

    private void writeClassListToFile(ClassList CL, String fileName) {
        openFileToWrite(fileName);
        printWriter.println(CL.GetCode() + "\t" + CL.GetID() + "\t" + CL.GetStudentID() + "\t" + CL.GetScore());
        closeFileAfterWrite();
    }

    public ArrayList<ClassList> readClassListFromFile(String fileName) {
        openFileToRead(fileName);
        ArrayList<ClassList> arrCL = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            ClassList CL = createClassListFromData(data);
            arrCL.add(CL);
        }
        closeFileAfterRead();
        return arrCL;
    }

    private ClassList createClassListFromData(String data) {
        String[] datas = data.split("\t");
        ClassList CL = new ClassList(Integer.parseInt(datas[0]), Integer.parseInt(datas[1]), Integer.parseInt(datas[2]), Float.parseFloat(datas[3]));
        return CL;
    }

    private void writeSubjectToFile(Subject SU, String fileName) {
        openFileToWrite(fileName);
        printWriter.println(SU.GetID() + "\t" + SU.GetName() + "\t" + SU.GetCredit());
        closeFileAfterWrite();
    }

    public ArrayList<Subject> readSubjectFromFile(String fileName) {
        openFileToRead(fileName);
        ArrayList<Subject> arrSU = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            Subject SU = createSubjectFromData(data);
            arrSU.add(SU);
        }
        closeFileAfterRead();
        return arrSU;
    }

    private Subject createSubjectFromData(String data) {
        String[] datas = data.split("\t");
        Subject SU = new Subject(Integer.parseInt(datas[0]), datas[1], Integer.parseInt(datas[2]));
        return SU;
    }

    public void Save(ArrayList<ClassList> arrCL, ArrayList<Student> arrST, ArrayList<CreditClass> arrCC, ArrayList<Subject> arrSU) throws IOException {
        new FileWriter("Subject.txt");
        new FileWriter("Class_List.txt");
        new FileWriter("Credit_Class.txt");
        new FileWriter("Student.txt");
        for (int i = 0; i < arrCL.size(); i++) {
            writeClassListToFile(arrCL.get(i), "Class_List.txt");
        }
        for (int i = 0; i < arrST.size(); i++) {
            writeStudentToFile(arrST.get(i), "Student.txt");
        }
        for (int i = 0; i < arrCC.size(); i++) {
            writeCreditCLassToFile(arrCC.get(i), "Credit_Class.txt");
        }
        for (int i = 0; i < arrSU.size(); i++) {
            writeSubjectToFile(arrSU.get(i), "Subject.txt");
        }
    }
}
