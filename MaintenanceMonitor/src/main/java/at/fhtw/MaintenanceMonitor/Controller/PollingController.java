package at.fhtw.MaintenanceMonitor.Controller;

import at.fhtw.MaintenanceMonitor.Service.MaintenanceMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class PollingController {

    @Autowired
    private MaintenanceMonitorService maintenanceMonitorService;

    @GetMapping("/")
    public String page() {
        return "html/index";
    }


    @GetMapping(value = "/message/{uptimeInPercentage:.+}")
    public @ResponseBody
    Map<String, String> message(@PathVariable("uptimeInPercentage") String uptimeInPercentage) {
        return maintenanceMonitorService.message(uptimeInPercentage);
    }

    @GetMapping("/message/deliver")
    public @ResponseBody Map pollMessageStatus() {
        return maintenanceMonitorService.pollMessageStatus();

    }

    @GetMapping("/message/reset")
    public @ResponseBody Map<String, String> resetStatus() {
        return maintenanceMonitorService.resetStatus();
    }

}
