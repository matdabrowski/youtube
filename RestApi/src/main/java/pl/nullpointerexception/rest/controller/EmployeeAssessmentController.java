package pl.nullpointerexception.rest.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.nullpointerexception.rest.model.EmployeeAssessment;

@RestController
public class EmployeeAssessmentController {

    @PutMapping("/employees/{id}/assessments/{assessmentId}")
    public EmployeeAssessment updateAssessment(@PathVariable Long id, @PathVariable Long assessmentId){
        return null;
    }
}
