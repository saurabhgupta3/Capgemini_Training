import java.util.*;

public class Game {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int ch = -1;
        while(true) {

            System.out.println("enter 1 for roll and 0 for exit");
            ch = sc.nextInt();

            if(ch == 0) break;
            
            if(ch == 1) {
                int p1 = (int)(Math.random()*6) + 1;
                int p2 = (int)(Math.random()*6) + 1;
                System.out.println("player 1: " + p1);
                System.out.println("player 2 : " + p2);
                if(p1 > p2) {
                    System.out.println("player 1 wins");
                } else if(p1 < p2) {
                    System.out.println("player 2 wins");
                } else {
                    System.out.println("both ties");
                }
        }
        }

        
    }
}