package day1;

import java.util.*;
import java.io.*;

class Student implements Serializable {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String fileName = "student.dat";

        int choice;

        do {

            System.out.println("\nEnter 1 to Write Student");
            System.out.println("Enter 2 to Read Student");
            System.out.println("Enter 0 to Exit");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            try {

                if (choice == 1) {

                    System.out.println("Enter Name:");
                    String name = sc.nextLine();

                    System.out.println("Enter Age:");
                    int age = sc.nextInt();

                    Student s1 = new Student(name, age);

                    FileOutputStream fos = new FileOutputStream(fileName);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);

                    oos.writeObject(s1);

                    oos.close();
                    fos.close();

                    System.out.println("Student Object Written Successfully");

                } else if (choice == 2) {

                    FileInputStream fis = new FileInputStream(fileName);
                    ObjectInputStream ois = new ObjectInputStream(fis);

                    Student s2 = (Student) ois.readObject();

                    System.out.println("Student Data:");
                    System.out.println("Name: " + s2.name);
                    System.out.println("Age: " + s2.age);

                    ois.close();
                    fis.close();

                } else if (choice == 0) {

                    System.out.println("Exiting Program...");

                } else {
                    System.out.println("Invalid Choice");
                }

            } catch (FileNotFoundException e) {
                System.out.println("File not found. Please write first.");
            } catch (Exception e) {
                System.out.println(e);
            }

        } while (choice != 0);

        sc.close();
    }
}