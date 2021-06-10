SELECT
    d.Name AS Department,
    e1.Name AS Employee,
    e1.Salary
FROM
    Employee e1
    JOIN Department d ON e1.DepartmentId = d.Id
WHERE
    3 > (
        SELECT
            count(*)
        FROM
            (
                SELECT
                    DISTINCT Salary
                FROM
                    Employee e2
                WHERE
                    e1.DepartmentId = e2.DepartmentId
                    AND e1.Salary < e2.Salary
            ) distinctSalary
    );
