package com.niantic.controllers;

import com.niantic.exceptions.HttpError;
import com.niantic.repositories.EmployeeDao;
import com.niantic.services.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeesController
{
    private final EmployeeDao employeeDao;
    private final LoggingService logger;

    @Autowired
    public EmployeesController(EmployeeDao employeeDao, LoggingService logger)
    {
        this.employeeDao = employeeDao;
        this.logger = logger;
    }

    @GetMapping()
    public ResponseEntity<?> getAllEmployees()
    {
        try
        {
            var employees = employeeDao.getAllEmployees();
            return ResponseEntity.ok(employees);
        }
        catch (Exception e)
        {
            // log the error then return the exception
            logger.logMessage(e.getMessage());

            var error = new HttpError(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Oops something went wrong");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }
}
