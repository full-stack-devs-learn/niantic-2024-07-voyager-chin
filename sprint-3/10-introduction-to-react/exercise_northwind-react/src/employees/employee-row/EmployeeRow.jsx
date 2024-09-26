import './EmployeeRow.css'

export default function EmployeeRow({ id, employee, title, onEmployeeSelected }) {
    const imageUrl = `images/employees/${id}.webp`;

    const employeeClicked = () => {
        onEmployeeSelected(employee)
    }

    return (
        <div className="employee-row" onClick={employeeClicked}>
            <img id="employee-image" src={imageUrl} />
            <div className="employee-name">
                <h1>{employee}</h1>
                <h6>{title}</h6>
            </div>
        </div>
    )
}