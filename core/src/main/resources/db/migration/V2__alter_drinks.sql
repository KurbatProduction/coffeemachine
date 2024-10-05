ALTER TABLE drinks
    ADD CONSTRAINT uc_drinks_name UNIQUE (name);