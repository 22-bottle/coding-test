-- 코드를 입력하세요
# SELECT product_id, product_name, product_cd, category, price
# from food_product
# where price = (select max(price) from food_product);

SELECT product_id, product_name, product_cd, category, price
from food_product
order by price desc
limit 1;