import java.util.*;

public class StudentInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListPractice<String> StuDetails = new ArrayList<>();
        System.out.println("enter no of students: ");
        int n = Integer.parseInt(sc.nextLine());
        for(int i=0; i<n; i++) {
            System.out.println("enter " + (i+1) + "th student name : ");
            String name = sc.nextLine();
            StuDetails.add(name);
        }
        System.out.println(StuDetails);
        System.out.println("enter 1 for add, 2 for update and 3 for delete");
        int ch = Integer.parseInt(sc.nextLine());
        if(ch == 1) {
            System.out.println("enter the " + n + "th student name: ");
            String name = sc.nextLine();
            StuDetails.add(name);
            System.out.println(StuDetails);
        } else if(ch == 2) {
            System.out.println("enter existing name: ");
            String oldName = sc.nextLine();
            int idx = -1;
            for(int i=0; i<n; i++) {
                if(oldName == StuDetails.get(i)) {
                    idx = i;
                    break;
                }
            }
            if(idx == -1) {
                System.out.println("student not exist");
            } else {
                System.out.println("enter new name: ");
                String newName = sc.nextLine();
                StuDetails.set(idx, newName);
            }

        }

    }
}