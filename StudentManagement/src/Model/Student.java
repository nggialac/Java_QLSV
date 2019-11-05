package Model;

import java.util.Scanner;

public class Student {

    private int ID, Gender, Year;
    private String Name, Phone, Address;
    Scanner sc = new Scanner(System.in);

    public Student(int ID, String Name, int Gender, int Year, String Phone, String Address) {
        this.ID = ID;
        this.Name = Name;
        this.Gender = Gender;
        this.Year = Year;
        this.Phone = Phone;
        this.Address = Address;
    }

    public Student() {
    }

    public int GetID() {
        return ID;
    }

    public void SetID(int ID) {
        this.ID = ID;
    }

    public int GetGender() {
        return Gender;
    }

    public void SetGender(int Gender) {
        this.Gender = Gender;
    }

    public int GetYear() {
        return Year;
    }

    public void SetYear(int Year) {
        this.Year = Year;
    }

    public String GetName() {
        return Name;
    }

    public void SetName(String Name) {
        this.Name = Name;
    }

    public String GetPhone() {
        return Phone;
    }

    public void SetPhone(String Phone) {
        this.Phone = Phone;
    }

    public String GetAddress() {
        return Address;
    }

    public void SetAddress(String Address) {
        this.Address = Address;
    }

    public void Import() {
        System.out.print(" - Name: ");
        Name = sc.nextLine();
        System.out.print(" - Gender: ");
        do {
            Gender = sc.nextInt();
        } while (Gender != 0 && Gender != 1);
        System.out.print(" - Born: ");
        do {
            Year = sc.nextInt();
        } while (Year < 1989 || Year > 2001);
        sc.nextLine();
        System.out.print(" - Phone: ");
        Phone = sc.nextLine();
        System.out.print(" - Address: ");
        Address = sc.nextLine();
    }

    @Override
    public String toString() {
        if (this.Gender == 0) {
            return this.ID + "\t" + this.Name + "\t" + "Male" + "\t" + this.Year + "\t" + this.Phone + "\t" + this.Address;
        }
        return this.ID + "\t" + this.Name + "\t" + "Female" + "\t" + this.Year + "\t" + this.Phone + "\t" + this.Address;
    }
}
