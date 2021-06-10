SELECT
    Request_at AS `Day`,
    ROUND(
        COUNT(
            `Status` LIKE 'cancelled%'
            OR NULL
        ) / COUNT(1),
        2
    ) AS `Cancellation Rate`
FROM
    Trips
WHERE
    Client_Id IN (
        SELECT
            Users_Id
        FROM
            Users
        WHERE
            Banned = 'No'
    )
    AND Driver_Id IN (
        SELECT
            Users_Id
        FROM
            Users
        WHERE
            Banned = 'No'
    )
    AND (
        Request_at BETWEEN '2013-10-01'
        AND '2013-10-03'
    )
GROUP BY
    Request_at
