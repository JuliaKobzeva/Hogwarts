CREATE TABLE people_with_cars (name VARCHAR, age INTEGER, licence BOOLEAN, car_id INTEGER);
ALTER TABLE people_with_cars ADD PRIMARY KEY (name);
CREATE TABLE cars ( id INTEGER, brand VARCHAR, model VARCHAR, price INTEGER);
ALTER TABLE people_with_cars ADD PRIMARY KEY (id);
SELECT people_with_cars.name, people_with_cars.age, people_with_cars.licence, people_with_cars. car_id, cars.brand,
       cars.model, cars.price FROM people_with_cars INNER JOIN cars ON people_with_cars.car_id = cars.id
