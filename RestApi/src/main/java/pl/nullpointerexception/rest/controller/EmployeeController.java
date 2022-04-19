package pl.nullpointerexception.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.nullpointerexception.rest.model.Employee;
import pl.nullpointerexception.rest.model.EmployeeDto;
import pl.nullpointerexception.rest.service.EmployeeService;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    public static final Long EMPTY_ID = null;
    private final EmployeeService employeeService;

    @GetMapping("/employees")
    public CollectionModel<EntityModel<Employee>> getEmployees() {
        List<EntityModel<Employee>> employees = employeeService.getEmployees().stream()
                .map(employee -> EntityModel.of(employee,
                        linkTo(methodOn(EmployeeController.class).getEmployee(employee.getId())).withSelfRel(),
                        linkTo(methodOn(EmployeeController.class).getEmployees()).withRel("employees")
                        ))
                .toList();
        return CollectionModel.of(employees,
                linkTo(methodOn(EmployeeController.class).getEmployees()).withSelfRel()
        );
    }

    @GetMapping("/employees/{id}")
    public EntityModel<Employee> getEmployee(@PathVariable Long id) {
        return EntityModel.of(employeeService.getEmployee(id),
                linkTo(methodOn(EmployeeController.class).getEmployee(id)).withSelfRel(),
                linkTo(methodOn(EmployeeController.class).getEmployees()).withRel("employees"),
                linkTo(EmployeeController.class).slash("employees").slash(id).slash("deactivate")
                        .withRel("deactivate")
        );
    }

    @PostMapping("/employees")
    public ResponseEntity<EntityModel<Employee>> createEmployee(@RequestBody EmployeeDto employeeDto) {
        Employee employee = employeeService.createEmployee(new Employee(
                EMPTY_ID,
                employeeDto.getFirstname(),
                employeeDto.getLastname(),
                employeeDto.isActive(),
                employeeDto.getCreated()
        ));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(EntityModel.of(employee,
                        linkTo(methodOn(EmployeeController.class).createEmployee(employeeDto)).withSelfRel(),
                        linkTo(methodOn(EmployeeController.class).getEmployees()).withRel("employees"),
                        linkTo(EmployeeController.class).slash("employees").slash(employee.getId()).slash("deactivate")
                                .withRel("deactivate")
                ));

    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
        employeeService.updateEmployee(new Employee(
                id,
                employeeDto.getFirstname(),
                employeeDto.getLastname(),
                employeeDto.isActive(),
                employeeDto.getCreated()
        ));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/employees/{id}/deactivate")
    public void deactivateEmployee(@PathVariable Long id) {

    }
}
