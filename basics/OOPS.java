class Pen {
    String color;
    String type;

    public void write() {
        System.out.println("Writing something");
    }
    public void printColor() {
        System.out.println(this.color);
    }
}

class Student {
    String name;
    int age;
    public void printInfo() {
        System.out.println(this.name);
        System.out.println(this.age);
    }
    Student(){
        System.out.println("constructor called");
    }
}


public class OOPS {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Saurabh";
        s1.age = 21;
        s1.printInfo();       
    }
}