CREATE TABLE drinks
(
    id   UUID NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_drinks PRIMARY KEY (id)
);

CREATE TABLE ingredients
(
    id       UUID    NOT NULL,
    name     VARCHAR(255),
    quantity INTEGER NOT NULL,
    CONSTRAINT pk_ingredients PRIMARY KEY (id)
);

CREATE TABLE orders
(
    id         UUID NOT NULL,
    drink_id   UUID,
    order_time BIGINT,
    CONSTRAINT pk_orders PRIMARY KEY (id)
);

CREATE TABLE recipes
(
    id            UUID    NOT NULL,
    drink_id      UUID,
    ingredient_id UUID,
    amount        INTEGER NOT NULL,
    CONSTRAINT pk_recipes PRIMARY KEY (id)
);

ALTER TABLE orders
    ADD CONSTRAINT FK_ORDERS_ON_DRINK FOREIGN KEY (drink_id) REFERENCES drinks (id);

ALTER TABLE recipes
    ADD CONSTRAINT FK_RECIPES_ON_DRINK FOREIGN KEY (drink_id) REFERENCES drinks (id);

ALTER TABLE recipes
    ADD CONSTRAINT FK_RECIPES_ON_INGREDIENT FOREIGN KEY (ingredient_id) REFERENCES ingredients (id);