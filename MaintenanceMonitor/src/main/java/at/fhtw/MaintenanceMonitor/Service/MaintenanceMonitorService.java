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


}
