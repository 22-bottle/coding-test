SELECT YEAR(E.DIFFERENTIATION_DATE) AS YEAR, (M.MAX - E.SIZE_OF_COLONY) AS YEAR_DEV, E.ID
FROM ECOLI_DATA E
JOIN (SELECT YEAR(DIFFERENTIATION_DATE) AS YEAR, MAX(SIZE_OF_COLONY) AS MAX
    FROM ECOLI_DATA
    GROUP BY YEAR) M
ON YEAR(E.DIFFERENTIATION_DATE) = M.YEAR
ORDER BY YEAR, YEAR_DEV;