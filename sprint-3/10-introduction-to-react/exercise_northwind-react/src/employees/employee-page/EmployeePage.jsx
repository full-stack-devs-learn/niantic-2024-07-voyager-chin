import EmployeeRowContainer from "../employee-row-container/EmployeeRowContainer";

export default function EmployeePage() {
    return (
        <>
            <header className="container mt-4">
                <h1>Employees</h1>
            </header>
            
            <EmployeeRowContainer></EmployeeRowContainer>
        </>
    )
}