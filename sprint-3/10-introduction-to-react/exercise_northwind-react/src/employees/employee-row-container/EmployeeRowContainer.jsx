import { useState } from 'react';
import EmployeeRow from "../employee-row/EmployeeRow";
import { employees }  from '../../data.js'


export default function EmployeeRowContainer() 
{
    const [selectedEmployee, setSelectedEmployee] = useState("None Selected");

    const employeeSelected = (name) =>
    {
        setSelectedEmployee(name);
        console.log(name)
    }

    return (
        <main className="container mt-4 employees-container" id="employees-container">
        {
            employees.map((employee) => (
                <EmployeeRow key={employee.employeeId}
                employee={`${employee.firstName} ${employee.lastName}`}
                id={employee.employeeId}
                onEmployeeSelected={employeeSelected} 
                ></EmployeeRow>
            ))
        }
        </main>
    )

}