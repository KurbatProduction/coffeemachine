ALTER TABLE ingredients
    ADD CONSTRAINT uc_ingredients_name UNIQUE (name);