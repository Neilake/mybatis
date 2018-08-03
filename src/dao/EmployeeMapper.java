package dao;

import entity.Employee;

public interface EmployeeMapper {
	public Employee getEmpById(Integer id);
	public Employee getAll(Integer id);
}
