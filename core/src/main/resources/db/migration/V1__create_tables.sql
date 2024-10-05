CREATE TABLE drinks
(
    id      UUID            NOT NULL,
    name    VARCHAR(255)    NOT NULL,
    CONSTRAINT pk_drinks PRIMARY KEY (id)
);

CREATE TABLE ingredients
(
    id          UUID            NOT NULL,
    name        VARCHAR(255)    NOT NULL,
    quantity    INTEGER         NOT NULL,
    CONSTRAINT pk_ingredients PRIMARY KEY (id)
);

CREATE TABLE orders
(
    id                  UUID        NOT NULL,
    drink_id            UUID        NOT NULL,
    create_date_time    timestamp   NOT NULL,
    CONSTRAINT pk_orders PRIMARY KEY (id)
);

CREATE TABLE recipes
(
    id              UUID        NOT NULL,
    drink_id        UUID        NOT NULL,
    ingredient_id   UUID        NOT NULL,
    amount          INTEGER     NOT NULL,
    CONSTRAINT pk_recipes PRIMARY KEY (id)
);

ALTER TABLE orders
    ADD CONSTRAINT FK_ORDERS_ON_DRINK FOREIGN KEY (drink_id) REFERENCES drinks (id);

ALTER TABLE recipes
    ADD CONSTRAINT FK_RECIPES_ON_DRINK FOREIGN KEY (drink_id) REFERENCES drinks (id);

ALTER TABLE recipes
    ADD CONSTRAINT FK_RECIPES_ON_INGREDIENT FOREIGN KEY (ingredient_id) REFERENCES ingredients (id);