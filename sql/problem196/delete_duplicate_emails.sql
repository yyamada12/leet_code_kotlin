WITH tmp AS (
    SELECT
        min(Id) AS Id,
        Email
    FROM
        Person
    GROUP BY
        Email
)
DELETE FROM
    Person p
WHERE
    EXISTS (
        SELECT
            1
        FROM
            tmp
        WHERE
            p.Email = tmp.Email
            AND p.Id > tmp.Id
    )
