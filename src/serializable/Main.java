package serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author Rodney Taylor (u228616)
 */
public class Main {
    static String path = "C:\\Users\\u228616\\Documents\\github\\Master_1Z0_829\\src\\serializable\\";
    
    public static void main(String[] args) {
        sendData(createEmployee());
        Employee employee = receiveData();
        System.out.println(employee);
    }
    
    private static Employee receiveData() {
        Employee employee = null;
        
        try (FileInputStream fileInputStream = new FileInputStream(path + "empdata.dat");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            employee = (Employee)objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        return employee;
    }
    
    private static void sendData(Employee employee) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(path + "empdata.dat");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);) {
            objectOutputStream.writeObject(employee);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static Employee createEmployee() {
        Employee employee = new Employee();
        employee.setId(1234);
        employee.setName(new EmployeeName("John", "Doe"));
        employee.setSocialNo("E1234P");
        
        return employee;
    }
}

class Employee implements Serializable {
    private EmployeeName name;
    private transient String  socialNo; // transient: This will not be serialised
    private int id;
    
    public void setName(EmployeeName name) {
        this.name = name;
    }
    
    public void setSocialNo(String socialNo) {
        this.socialNo = socialNo;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return String.format("Employee:%nName: %s %s%nSocial No: %s%nId: %d",
                name.firstName(), name.lastName(), socialNo, id);
    }
}

record EmployeeName(String firstName, String lastName) implements Serializable {}

