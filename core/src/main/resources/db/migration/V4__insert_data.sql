CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

INSERT INTO drinks (id, name)
    VALUES
        (uuid_generate_v4(), 'espresso'),
        (uuid_generate_v4(), 'americano'),
        (uuid_generate_v4(), 'cappuccino');

INSERT INTO ingredients (id, name, quantity)
    VALUES
        (uuid_generate_v4(), 'water', 100000),
        (uuid_generate_v4(), 'coffee', 10000),
        (uuid_generate_v4(), 'milk', 10000),
        (uuid_generate_v4(), 'sugar', 10000);

INSERT INTO recipes (id, amount, drink_id, ingredient_id)
    VALUES
        (uuid_generate_v4(), 30,
            (SELECT id FROM drinks WHERE name = 'espresso'),
            (SELECT id FROM ingredients WHERE name = 'water')
        ),
        (uuid_generate_v4(), 10,
            (SELECT id FROM drinks WHERE name = 'espresso'),
            (SELECT id FROM ingredients WHERE name = 'coffee')
        );

INSERT INTO recipes (id, amount, drink_id, ingredient_id)
    VALUES
        (uuid_generate_v4(), 120,
            (SELECT id FROM drinks WHERE name = 'americano'),
            (SELECT id FROM ingredients WHERE name = 'water')
        ),
        (uuid_generate_v4(), 10,
            (SELECT id FROM drinks WHERE name = 'americano'),
            (SELECT id FROM ingredients WHERE name = 'coffee')
        ),
        (uuid_generate_v4(), 10,
            (SELECT id FROM drinks WHERE name = 'americano'),
            (SELECT id FROM ingredients WHERE name = 'sugar')
        );

INSERT INTO recipes (id, amount, drink_id, ingredient_id)
    VALUES
        (uuid_generate_v4(), 60,
            (SELECT id FROM drinks WHERE name = 'cappuccino'),
            (SELECT id FROM ingredients WHERE name = 'water')
        ),
        (uuid_generate_v4(), 10,
            (SELECT id FROM drinks WHERE name = 'cappuccino'),
            (SELECT id FROM ingredients WHERE name = 'coffee')
        ),
        (uuid_generate_v4(), 60,
         (SELECT id FROM drinks WHERE name = 'cappuccino'),
         (SELECT id FROM ingredients WHERE name = 'milk')
        ),
        (uuid_generate_v4(), 10,
         (SELECT id FROM drinks WHERE name = 'cappuccino'),
         (SELECT id FROM ingredients WHERE name = 'sugar')
        );