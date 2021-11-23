package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcEmployeeDao implements EmployeeDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcEmployeeDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = new ArrayList<>();
		String sql = "SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date FROM employee;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()){
			Employee employee = mapRowToEmployee(results);
			employeeList.add(employee);
		}

		return employeeList;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		List<Employee> employeeList = new ArrayList<>();
		String sql = "SELECT * FROM employee WHERE first_name ILIKE ? AND last_name ILIKE ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + firstNameSearch + "%", "%" + lastNameSearch + "%");
		while(results.next()){
			Employee employee = mapRowToEmployee(results);
			employeeList.add(employee);
		}
		return employeeList;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		String sqlGetEmployeesByProject = "SELECT * FROM employee AS e " +
				"JOIN project_employee AS pe ON e.employee_id = pe.employee_id " +
				"WHERE pe.project_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetEmployeesByProject, projectId);
		List<Employee> employeeList = new ArrayList<>();
		while(results.next()){
			Employee employee = mapRowToEmployee(results);
			employeeList.add(employee);
		}
		return employeeList;
	}

	@Override
	public void addEmployeeToProject(Long projectId, Long employeeId) {
		String sql = "INSERT INTO project_employee (project_id, employee_id) VALUES (?, ?)";
		jdbcTemplate.update(sql, projectId, employeeId);

	}

	@Override
	public void removeEmployeeFromProject(Long projectId, Long employeeId) {
		String sql = "DELETE FROM project_employee WHERE project_id = ? AND employee_id = ?";
		jdbcTemplate.update(sql, projectId, employeeId);
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		String sql = "SELECT * FROM employee AS e " +
				"LEFT JOIN project_employee AS pe ON e.employee_id = pe.employee_id " +
				"WHERE pe.employee_id IS NULL";
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);
		List<Employee> employeeList = new ArrayList<>();
		while(rows.next()){
			Employee employee = mapRowToEmployee(rows);
			employeeList.add(employee);
		}
		return employeeList;
	}

	private Employee mapRowToEmployee(SqlRowSet rowSet) {
		Employee employee = new Employee();

		employee.setId(rowSet.getLong("employee_id"));
		employee.setDepartmentId( rowSet.getLong("department_id") );
		employee.setFirstName( rowSet.getString("first_name") );
		employee.setLastName( rowSet.getString("last_name") );
		employee.setBirthDate( rowSet.getDate("birth_date").toLocalDate());
		employee.setHireDate( rowSet.getDate("hire_date").toLocalDate());
		return employee;
	}
}
