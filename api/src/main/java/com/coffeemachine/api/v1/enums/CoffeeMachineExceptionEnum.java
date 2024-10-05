package com.coffeemachine.api.v1.enums;

import lombok.Getter;

@Getter
public enum CoffeeMachineExceptionEnum {
    BAD_REQUEST(400, "BAD_REQUEST", "Неправильный ввод данных. Пожалуйста, проверьте значения и попробуйте снова"),
    DUPLICATE_VALUE(400, "DUPLICATE_VALUE", "Напиток с таким названием уже существует"),
    NOT_FOUND_DRINK(404, "NOT_FOUND", "Запрашиваемый напиток не найден. Пожалуйста, проверьте название напитка и попробуйте снова"),
    NOT_FOUND_INGREDIENT(404, "NOT_FOUND", "Запрашиваемый ингредиент не найден. Пожалуйста, добавьте сначала этот ингредиент"),
    NOT_ACCEPTABLE(406, "NOT_ACCEPTABLE", "Недостаточно ингредиентов для приготовления напитка. Пожалуйста, попробуйте заказать напиток позже"),
    INTERNAL_ERROR(500, "INTERNAL_ERROR", "Произошла внутренняя ошибка сервера. Пожалуйста, попробуйте снова позже");

    private final int code;
    private final String error;
    private final String message;

    CoffeeMachineExceptionEnum(int code, String error, String message) {
        this.code = code;
        this.error = error;
        this.message = message;
    }
}
