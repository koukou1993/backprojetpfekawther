package sotrap.com.project.service;

import sotrap.com.project.model.Employee;

import java.util.List;

public interface EmployeeService {


    public List<Employee> getAllEmployee();

    public Employee getById(Long id);

    public Employee update(Employee employee);

    public Employee add(Employee employee);

    public void delete(Long id);





}

