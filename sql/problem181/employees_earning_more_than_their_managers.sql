SELECT
    e.name AS employee
FROM
    employee e
    LEFT JOIN employee m ON e.managerid = m.id
WHERE
    e.salary > m.salary
