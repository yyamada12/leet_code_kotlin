SELECT
    id
FROM
    weather w1
    LEFT JOIN weather w2 ON DATE_SUB(w1.recordDate, INTERVAL 1 DAY) = w2.recordDate
WHERE
    w1.Temperature > w2.Temperature
