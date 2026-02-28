import java.util.*;

class Transaction {
    String date;   // DD-MM-YYYY
    String time;   // HH:MM
    String type;   // DEBIT, CREDIT, FAILED
    int amount;

    Transaction(String date, String time, String type, int amount) {
        this.date = date;
        this.time = time;
        this.type = type;
        this.amount = amount;
    }
}

public class Solution {

    static class Pair {
        Long key;
        Transaction item;
        Pair(Long key, Transaction item) {
            this.key = key;
            this.item = item;
        }
    }

    public static List<Transaction> extractSuspiciousTransactions(List<Transaction> transactions) {
        // implement logic here
        List<Transaction> filtered = new ArrayList<>();
        for(Transaction item : transactions) {
            if(item.type.equals("FAILED") || item.type.equals("DEBIT")) {
                filtered.add(item);
            }
        }
        List<Pair> data  = new ArrayList<>();
        for(Transaction item : filtered) {
            String yyyy = item.date.substring(6, 10);
            String mm = item.date.substring(3, 5);
            String dd = item.date.substring(0, 2);
            String hh = item.time.substring(0, 2);
            String mi = item.time.substring(3, 5);
            Long key = Long.parseLong(yyyy + mm + dd + hh + mi);
            data.add(new Pair(key, item));
        }
        data.sort((a, b) -> Long.compare(a.key, b.key));
        List<Transaction> result = new ArrayList<>();
        for(Pair item : data) {
            result.add(item.item);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Transaction> list = new ArrayList<>();
        list.add(new Transaction("12-01-2024", "10:30", "DEBIT", 500));
        list.add(new Transaction("12-01-2024", "10:30", "FAILED", 700));
        list.add(new Transaction("11-01-2024", "09:15", "CREDIT", 1000));
        list.add(new Transaction("13-01-2024", "08:00", "FAILED", 200));

        List<Transaction> result = extractSuspiciousTransactions(list);

        for (Transaction t : result) {
            System.out.println(t.date + " " + t.time + " " + t.type + " " + t.amount);
        }
    }
}
