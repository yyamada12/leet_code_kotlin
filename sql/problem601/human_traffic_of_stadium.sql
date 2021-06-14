SELECT
    s.*
FROM
    Stadium s
    LEFT JOIN Stadium s1 ON s.id = s1.id -1
    LEFT JOIN Stadium s2 ON s.id = s2.id -2
    LEFT JOIN Stadium sm1 ON s.id = sm1.id + 1
    LEFT JOIN Stadium sm2 ON s.id = sm2.id + 2
WHERE
    s.people >= 100
    AND (
        (
            s1.people >= 100
            AND s2.people >= 100
        )
        OR (
            s1.people >= 100
            AND sm1.people >= 100
        )
        OR (
            sm1.people >= 100
            AND sm2.people >= 100
        )
    )
