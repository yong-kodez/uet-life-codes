SELECT
    c.customer_id AS customer_id,
    c.first_name AS first_name,
    c.last_name AS last_name,
    c.email AS customer_email,
    COUNT(r.rental_id) AS total_rentals
FROM customer c
JOIN rental r ON r.customer_id = c.customer_id
GROUP BY c.customer_id, c.first_name, c.last_name, c.email
HAVING total_rentals > 30
ORDER BY total_rentals DESC;
    
