# MaintenanceMonitor
The Maintenance Monitor project is used for checking the availabilty of electricity. The project is developed by Tayyib Erdem, Rajvinder Singh and Emre Aktura. 

Process

Access the main page which is updated every 5 seconds: 
http://localhost:8081/


Open a new Tab for doing changes. We don't want to disturb the main page:

Update downtime with typing a number at the end: 
http://localhost:8081/message/99.99

Reset the message with typing in "reset" at the end:
http://localhost:8081/message/reset


Polling API - internal call every 5 second (this is done automatically):
http://localhost:8081/message/deliver
