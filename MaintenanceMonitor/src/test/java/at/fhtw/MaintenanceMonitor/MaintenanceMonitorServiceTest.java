package at.fhtw.MaintenanceMonitor;

import at.fhtw.MaintenanceMonitor.Service.MaintenanceMonitorService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

public class MaintenanceMonitorServiceTest {
    @Mock
    Map<String, String> statusMap;
    @InjectMocks
    MaintenanceMonitorService maintenanceMonitorService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInit() throws Exception {
        maintenanceMonitorService.init();
    }

    @Test
    public void testResetStatus() throws Exception {
        Map<String, String> result = maintenanceMonitorService.resetStatus();
        Assert.assertEquals(new HashMap<String, String>() {{
            put("status", "status message update successfully");
        }}, result);
    }

    @Test
    public void testPollMessageStatus() throws Exception {
        Map<String, String> result = maintenanceMonitorService.pollMessageStatus();
       Assert.assertNotNull(result);
    }

    @Test
    public void testMessage() throws Exception {
        Map<String, String> result = maintenanceMonitorService.message("uptimeInPercentage");
        Assert.assertEquals(new HashMap<String, String>() {{
            put("failure", "uptime updated failed");
        }}, result);
    }
}
