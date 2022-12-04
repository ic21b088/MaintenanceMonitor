package at.fhtw.MaintenanceMonitor.Service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class MaintenanceMonitorService {

    @PostConstruct
    public void init() {
        statusMap.put("uptime", "99.90");
        statusMap.put("lastUpdated", LocalDate.now().toString());
    }

    private static final Map<String, String> statusMap = new HashMap<String, String>();


    public Map<String, String> message(String uptimeInPercentage) {
        Map<String, String> resultMap = new HashMap<String, String>();
        try {
            statusMap.put("uptime", uptimeInPercentage);
            statusMap.put("lastUpdated", LocalDate.now().toString());
            if (Float.valueOf(uptimeInPercentage).compareTo(Float.valueOf("99.95")) >= 0) {
                statusMap.put("statusMessage", "All looks good");
            }
            resultMap.put("status", "uptime updated successfully");
        } catch (Exception e) {
            resultMap.put("failure", "uptime updated failed");
        }
        return resultMap;
    }

    public Map<String, String> pollMessageStatus() {
        Map<String, String> resultMap = new HashMap<String, String>();
        String uptime = statusMap.get("uptime");
        resultMap.put("lastUpdated", "last updated " + LocalTime.now().toString());
        if(uptime!=null){
            resultMap.put("uptime", Float.valueOf(uptime).toString());
        }
        else {
            uptime="99.00";
        }
        int i = Float.valueOf(uptime).compareTo(Float.valueOf("99.95"));
        if (i < 0) {
            resultMap.put("statusMessage",  "Problem with web server maintenance until 06:00 UTC ");
            resultMap.put("color", "red");
        } else if (i == 0) {
            resultMap.put("statusMessage",  "Reset to default");
            resultMap.put("color", "white");
        } else {
            resultMap.put("statusMessage",  "Looks good");
            resultMap.put("color", "green");
        }
        return resultMap;
    }

}
