import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M1mock1 {
    static class Pair {
        long key;
        List<String> ls = new ArrayList<>();
        Pair(long key, List<String> ls) {
            this.key = key;
            this.ls = ls;
        }
    }
    public static List<List<String>> extractErrorLogs(List<List<String>> logs) {

        List<Pair> filtered = new ArrayList<>();
        for(List<String> log : logs) {
            if(log.get(2).equals("ERROR") || log.get(2).equals("CRITICAL")) {
                String date = log.get(0);
                String time = log.get(1);
                String yyyy = date.substring(6, 10);
                String mm = date.substring(3, 5);
                String dd = date.substring(0, 2);
                String hh = time.substring(0, 2);
                String mi = time.substring(3, 5);
                long key = Long.parseLong(yyyy + mm + dd + hh + mi);
                Pair data = new Pair(key, log);
                filtered.add(data);
            }
        }
        filtered.sort((a, b) -> Long.compare(a.key, b.key));
        List<List<String>> res = new ArrayList<>();
        for(Pair pair : filtered) {
            res.add(pair.ls);
        }

        return res;
    }
    public static void main(String[] args) {
        
        List<List<String>> logs = new ArrayList<>();

        logs.add(Arrays.asList("09-02-2026", "10:15", "INFO", "Started app"));
        logs.add(Arrays.asList("09-02-2026", "10:20", "ERROR", "Null pointer"));
        logs.add(Arrays.asList("08-02-2026", "18:45", "CRITICAL", "System crash"));
        logs.add(Arrays.asList("09-02-2026", "09:30", "ERROR", "DB connection failed"));

        List<List<String>> result = extractErrorLogs(logs);

        System.out.println("Filtered & Sorted Logs:");
        for (List<String> log : result) {
            System.out.println(log);
        }
    }
}