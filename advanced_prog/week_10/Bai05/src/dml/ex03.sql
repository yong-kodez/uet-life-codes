WITH customer_spending AS (
    SELECT
        c.customer_id,
        c.first_name || ' ' || c.last_name AS customer_name,
        c.email,
        SUM(p.amount) AS total_spent
    FROM customer c
    JOIN payment p ON c.customer_id = p.customer_id
    GROUP BY c.customer_id, c.first_name, c.last_name, c.email
)

SELECT
    cs.customer_id,
    cs.customer_name,
    cs.email,
    cs.total_spent
FROM customer_spending cs
WHERE total_spent > (
    SELECT AVG(total_spent) FROM customer_spending
)
ORDER BY total_spent DESC;
