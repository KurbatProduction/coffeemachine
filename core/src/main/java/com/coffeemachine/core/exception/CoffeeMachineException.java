package com.coffeemachine.core.exception;

import com.coffeemachine.api.v1.enums.CoffeeMachineExceptionEnum;
import lombok.Getter;

@Getter
public class CoffeeMachineException extends RuntimeException{

    private final CoffeeMachineExceptionEnum coffeeMachineExceptionEnum;

    public CoffeeMachineException(CoffeeMachineExceptionEnum coffeeMachineExceptionEnum) {
        super(coffeeMachineExceptionEnum.toString());
        this.coffeeMachineExceptionEnum = coffeeMachineExceptionEnum;
    }
}
