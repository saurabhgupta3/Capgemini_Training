import java.util.*;


class Student {
    String name;
    int rollNo;
    Boolean isPdfOpen = ((int)(Math.random()*2)) == 0 ? true : false;
    int totalMarks = (int)(Math.random()*100 + 1);
    Student(String name, int rollNo, Boolean ispdfOpen) {
        this.name = name;
        this.rollNo = rollNo;
        this.isPdfOpen = ispdfOpen;
    }
}

public class SMS {
    public static void main(String[] args) {
        List<Student> userInfo = new ArrayList<>();
        userInfo.add(new Student("Saurabh", 1, false));
        userInfo.add(new Student("Abhay", 2, true));
        userInfo.add(new Student("Surya", 3, false));
        Scanner sc = new Scanner(System.in);
        String currName = "";
        int currRoll = -1;
        while(true) {
            System.out.print("Enter 0 for login, -1 for exit and 1 for register: ");
            int ch = Integer.parseInt(sc.nextLine());
            if(ch == -1) break;
            if(ch == 1) {
                System.out.print("Enter name: ");
                String name = sc.nextLine();
                System.out.print("Enter roll No: ");
                int rollNo = Integer.parseInt(sc.nextLine());
                currName = name;
                currRoll = rollNo;
                System.out.print("Enter pdf open status(1 for open and 0 for not open): ");
                int a = Integer.parseInt(sc.nextLine());
                Boolean status = (a == 1);
                userInfo.add(new Student(name, rollNo, status));
                System.out.println("You are successfully registered");
            } else if(ch == 0) {
                System.out.print("Enter name: ");
                String name = sc.nextLine();
                System.out.print("Enter roll No: ");
                int rollNo = Integer.parseInt(sc.nextLine());
                Boolean isLoggedIn = false;
                for(int i=0; i<userInfo.size(); i++) {
                    if(userInfo.get(i).name.equals(name) && userInfo.get(i).rollNo == rollNo) {
                        System.out.println("You are logged in now");
                        isLoggedIn = true;
                        currName = name;
                        currRoll = rollNo;
                        break;
                    }
                }
                if(!isLoggedIn) {
                    System.out.println("No details found");
                    break;
                }
            } else {
                System.out.println("Enter correct choice");
                break;
            }
            while(true) {
                System.out.print("Enter 1 for Your info, 0 for exit and 2 for toggle reading status: ");
                int option = Integer.parseInt(sc.nextLine());
                if(option == 1) {
                    for(int i=0; i<userInfo.size(); i++) {
                        if(userInfo.get(i).name.equals(currName) && userInfo.get(i).rollNo == currRoll) {
                            System.out.println("-----STUDENT INFORMATION-----");
                            System.out.println();
                            System.out.println("Name: " + userInfo.get(i).name);
                            System.out.println("Roll no : " + userInfo.get(i).rollNo);
                            System.out.println("Reading status: " + userInfo.get(i).isPdfOpen);
                            System.out.println("Total score: " + userInfo.get(i).totalMarks);
                            System.out.println();
                            break;
                        }
                        
                    }
                } else if(option == 2) {
                    for(int i=0; i<userInfo.size(); i++) {
                        if(userInfo.get(i).name.equals(currName) && userInfo.get(i).rollNo == currRoll) {
                            userInfo.get(i).isPdfOpen = !userInfo.get(i).isPdfOpen;
                            break;
                        }
                    }
                    System.out.println("Status updated");
                } else if(option == 0) break;
                else System.out.println("wrong choice");
            }
        }
    }
}