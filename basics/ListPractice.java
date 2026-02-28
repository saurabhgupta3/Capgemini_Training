import java.util.*;

// class Value {
//     String person;
//     String phone;
    
//     Value(String person, String phone) {
//         this.person = person;
//         this.phone = phone;
//     }
//     public String toString() {
//         return person + " - " + phone;
//     }
// }

public class ListPractice {
    public static void main(String[] args) {
        Map<String, String> arr = new HashMap<>();
        arr.put("Saurabh", "Vivo");
        arr.put("Aman", "Samsung");
        arr.put("Vipin", "Redmi");
        arr.put("Gupta", "Realme");
        
        for(Map.Entry<String, String> entry: arr.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}