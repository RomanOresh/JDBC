import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DatabaseConnector dbConnector = new DatabaseConnector();
        try {
            dbConnector.connect();
            EmployeeDAO employeeDAO = new EmployeeDAO(dbConnector.getConnection());

            employeeDAO.addEmployee("John Doe", 30, "Developer", 5000.0f);
            employeeDAO.addEmployee("Jane Smith", 25, "Designer", 4500.0f);
            employeeDAO.addEmployee("John Smith", 35, "Senior Developer", 14500.0f);
            employeeDAO.addEmployee("Jane Doe", 19, "Junior Developer", 2500.0f);



            System.out.println("Все сотрудники:");
            employeeDAO.getAllEmployees();

            employeeDAO.updateEmployee(1, "John Doe", 31, "Senior Developer", 6000.0f);

            System.out.println("После обновления:");
            employeeDAO.getAllEmployees();

            employeeDAO.deleteEmployee(2);

            System.out.println("После удаления:");
            employeeDAO.getAllEmployees();

        } catch (SQLException e) {
            e.fillInStackTrace();

        } finally {
            dbConnector.close();
        }
    }
}