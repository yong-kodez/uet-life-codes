SELECT
    f.title AS film_title,
    c.name AS category_name,
    f.length AS film_length,
    RANK() OVER (
        PARTITION BY c.name
        ORDER BY f.length DESC
    ) AS film_rank
FROM film f
JOIN film_category fc ON fc.film_id = f.film_id
JOIN category c ON fc.category_id = c.category_id

