INSERT INTO sensors (name, model, range, sensor_type_id,
                     sensor_unit_id, location, description, created, updated)
values ('Sensor1', 'Model1', '{"to": 10, "from": 5}',
        1, 1, 'Some location1',
        'Some description1', now(), now()),
       ('Sensor2', 'Model2', '{"to": 10, "from": 5}',
        1, 2, 'Some location2',
        'Some description2', now(), now());