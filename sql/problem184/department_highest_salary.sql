SELECT
    d.Name AS Department,
    e.Name AS Employee,
    e.Salary
FROM
    Department d
    JOIN (
        SELECT
            max(Salary) AS MaxSalary,
            DepartmentId
        FROM
            Employee
        GROUP BY
            DepartmentId
    ) m ON d.Id = m.DepartmentId
    JOIN employee e ON m.MaxSalary = e.Salary
    AND m.DepartmentId = e.DepartmentId;
