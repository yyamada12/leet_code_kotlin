SELECT
    Score,
    (
        SELECT
            COUNT(*)
        FROM
            (
                SELECT
                    DISTINCT Score
                FROM
                    Scores
            ) AS distinct_scores
        WHERE
            distinct_scores.Score >= s2.Score
    ) AS `Rank`
FROM
    Scores s2
ORDER BY
    `Rank`;
