SELECT
       firstName,
       LastName,
       City,
       State
FROM
       Person AS p
       LEFT JOIN Address AS a ON a.PersonId = p.PersonId;
