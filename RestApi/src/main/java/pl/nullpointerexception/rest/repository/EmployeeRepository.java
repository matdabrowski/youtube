package pl.nullpointerexception.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.nullpointerexception.rest.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
