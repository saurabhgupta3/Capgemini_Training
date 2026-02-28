import java.util.*;

/* -------------------- LOG ENTRY CLASS -------------------- */
class Pair {
    LogEntry log;
    long ts;
    Pair(LogEntry log, long ts) {
        this.log = log;
        this.ts = ts;
    }
}
class LogEntry {

    String date;        // DD-MM-YYYY
    String time;        // HH:MM:SS
    String severity;    // INFO, WARNING, ERROR, CRITICAL
    String service;
    String message;

    public LogEntry(String date, String time,
                    String severity, String service,
                    String message) {
        this.date = date;
        this.time = time;
        this.severity = severity;
        this.service = service;
        this.message = message;
    }

    @Override
    public String toString() {
        return date + " " + time + " [" + severity + "] "
                + service + " - " + message;
    }
}

/* -------------------- YOUR CLASS TO IMPLEMENT -------------------- */
class LogProcessor {

    /*
        Implement this function:

        1. Return logs with severity ERROR or CRITICAL
        2. Only include logs within given time window (inclusive)
        3. Sort by timestamp ascending
        4. If same timestamp:
              CRITICAL before ERROR
        5. If still same → preserve original order (stable sort)
        6. Do NOT use any datetime libraries
    */
    public static List<LogEntry> extractCriticalWindowLogs(
            List<LogEntry> logs,
            String startDate,
            String startTime,
            String endDate,
            String endTime
    ) {

        // TODO: Implement this method
        List<Pair> data = new ArrayList<>();
        for(LogEntry log : logs) {
            String severity = log.severity;          // DD-MM-YYYY  // HH:MM:SS
            String date = log.date;
            String time = log.time;
            String dd = date.substring(0, 2);
            String mm = date.substring(3, 5);
            String yyyy = date.substring(6, 10);
            String hh = time.substring(0, 2);
            String mi = time.substring(3, 5);
            String ss = time.substring(6, 8);
            long newdate = Long.parseLong(yyyy + mm + dd);
            long newtime = Long.parseLong(hh + mi + ss);
            String odd = startDate.substring(0, 2);
            String omm = startDate.substring(3, 5);
            String oyyyy = startDate.substring(6, 10);
            String ohh = startTime.substring(0, 2);
            String omi = startTime.substring(3, 5);
            String oss = startTime.substring(6, 8);
            long odate = Long.parseLong(oyyyy + omm + odd);
            long otime = Long.parseLong(ohh + omi + oss);
            String ndd = endDate.substring(0, 2);
            String nmm = endDate.substring(3, 5);
            String nyyyy = endDate.substring(6, 10);
            String nhh = endTime.substring(0, 2);
            String nmi = endTime.substring(3, 5);
            String nss = endTime.substring(6, 8);
            long ndate = Long.parseLong(nyyyy + nmm + ndd);
            long ntime = Long.parseLong(nhh + nmi + nss);
            if((severity == "ERROR" || severity == "CRITICAL") && newdate >= odate && newdate <= ndate && newtime >= otime && newtime <= ntime) {
                long ts = Long.parseLong(yyyy + mm + dd + hh + mi + ss);
                data.add(new Pair(log, ts));
            }
        }
        data.sort((a, b) -> (a.ts == b.ts) ? (a.log.severity == "CRITICAL" && b.log.severity == "ERROR") ? 1 : (a.log.severity == "ERROR" && b.log.severity == "CRITICAL") ? -1 : 0 : Long.compare(a.ts, b.ts));
        List<LogEntry> ans = new ArrayList<>();
        for(Pair p : data) {
            ans.add(p.log);
        }

        return ans;
    }
}

/* -------------------- MAIN WITH TEST CASES -------------------- */
public class Main {

    public static void main(String[] args) {

        List<LogEntry> logs = new ArrayList<>();

        logs.add(new LogEntry("05-02-2026", "09:14:30",
                "INFO", "AuthService", "Login success"));

        logs.add(new LogEntry("05-02-2026", "09:15:10",
                "ERROR", "PaymentService", "Transaction failed"));

        logs.add(new LogEntry("05-02-2026", "09:15:10",
                "CRITICAL", "PaymentService", "Payment gateway down"));

        logs.add(new LogEntry("06-02-2026", "02:00:00",
                "CRITICAL", "DBService", "Database crash"));

        logs.add(new LogEntry("07-02-2026", "11:30:45",
                "WARNING", "CacheService", "High memory usage"));

        logs.add(new LogEntry("07-02-2026", "11:35:00",
                "ERROR", "AuthService", "Token expired"));

        logs.add(new LogEntry("08-02-2026", "10:00:00",
                "CRITICAL", "NetworkService", "Network failure"));

        /* -------- Test Case 1 -------- */
        System.out.println("Test Case 1:");
        List<LogEntry> result1 =
                LogProcessor.extractCriticalWindowLogs(
                        logs,
                        "05-02-2026", "09:00:00",
                        "07-02-2026", "12:00:00"
                );

        for (LogEntry log : result1) {
            System.out.println(log);
        }

        /* -------- Test Case 2 -------- */
        System.out.println("\nTest Case 2:");
        List<LogEntry> result2 =
                LogProcessor.extractCriticalWindowLogs(
                        logs,
                        "06-02-2026", "00:00:00",
                        "08-02-2026", "23:59:59"
                );

        for (LogEntry log : result2) {
            System.out.println(log);
        }

        /* -------- Edge Case -------- */
        System.out.println("\nEdge Case (No Results):");
        List<LogEntry> result3 =
                LogProcessor.extractCriticalWindowLogs(
                        logs,
                        "01-01-2020", "00:00:00",
                        "02-01-2020", "00:00:00"
                );

        for (LogEntry log : result3) {
            System.out.println(log);
        }
    }
}