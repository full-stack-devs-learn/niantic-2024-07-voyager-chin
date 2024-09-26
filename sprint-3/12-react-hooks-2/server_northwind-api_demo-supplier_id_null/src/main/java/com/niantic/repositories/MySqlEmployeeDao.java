package com.niantic.repositories;

import com.niantic.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MySqlEmployeeDao implements EmployeeDao
{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MySqlEmployeeDao(DataSource dataSource)
    {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Employee> getAllEmployees()
    {
        List<Employee> employees = new ArrayList<>();

        String sql = """
                select employee_id
                	, last_name
                    , first_name
                    , title
                    , title_of_courtesy
                    , birth_date
                    , hire_date
                    , address
                    , city
                	, region
                    , postal_code
                    , country
                    , home_phone
                    , extension
                    , notes
                    , reports_to
                    , salary
                from employees
                """;
        var row = jdbcTemplate.queryForRowSet(sql);
        while (row.next())
        {
            var employee = mapRowToEmployee(row);
            employees.add(employee);
        }

        return employees;
    }

    @Override
    public Employee getEmployeeById(int id)
    {
        return null;
    }

    @Override
    public Employee addEmployee(Employee employee)
    {
        return null;
    }

    @Override
    public void updateEmployee(int id, Employee employee)
    {

    }

    @Override
    public void deleteEmployee(int id)
    {

    }

    private Employee mapRowToEmployee(SqlRowSet row)
    {
        int employeeId = row.getInt("employee_id");
        String lastName = row.getString("last_name");
        String firstName = row.getString("first_name");
        String title = row.getString("title");
        String titleOfCourtesy = row.getString("title_of_courtesy");
        String address = row.getString("address");
        String city = row.getString("city");
        String state = row.getString("region");
        String zipCode = row.getString("postal_code");
        String country = row.getString("country");
        String homePhone = row.getString("home_phone");
        String extension = row.getString("extension");
        String notes = row.getString("notes");
        int managerId = row.getInt("reports_to");
        BigDecimal salary = row.getBigDecimal("salary");

        LocalDateTime birthDate = null;
        LocalDateTime hireDate = null;

        var birthDayString = row.getString("birth_date");
        if(birthDayString != null)
        {
            birthDate = LocalDateTime.parse(birthDayString);
        }

        var hireDateString = row.getString("hire_date");
        if(hireDateString != null)
        {
            hireDate = LocalDateTime.parse(hireDateString);
        }

        return new Employee(employeeId, lastName, firstName, title, titleOfCourtesy, birthDate, hireDate, address, city, state, zipCode, country, homePhone, extension, notes, salary, managerId);
    }
}
