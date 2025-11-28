A console-based Pharmacy Management System built in Java. This system allows managing patients, doctors, prescriptions, medicines, insurance companies, and purchases.
------------- TP -------------
setting logger logic and testing it : \src\main\java\org\sparadrap\Main.java
                                    : \src\main\java\org\sparadrap\dao\DaoRun.java
------
creating DAO for doctor, department, insurance, insurance plans, patient 
and a class with a temporary main method to test different DAO : \src\main\java\org\sparadrap\dao\DaoRun.java 
------
connecting the app with Mysql DB : \src\main\java\org\sparadrap\connection

------
starting with swing by display patients and doctors lists : \src\main\java\org\sparadrap\Main.java

------
starting with simple dao unit tests

-----------------------------------
to be completed :

- DAO for all models
- modify models by adding other constructors that takes into consideration getting id from DB
- developing a complete GUI interface*
- more unit testing of DAO
- getting log messages from all important events

