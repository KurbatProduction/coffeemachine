package com.coffeemachine.core.exception.handler;

import com.coffeemachine.api.v1.CoffeeMachineExceptionEnum;
import com.coffeemachine.api.v1.dto.ExceptionDto;
import com.coffeemachine.core.exception.CoffeeMachineException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ControllerExceptionHandler {

    @ExceptionHandler({
            HandlerMethodValidationException.class,
            HttpMessageNotReadableException.class,
            MethodArgumentNotValidException.class,
            ConstraintViolationException.class})
    public ResponseEntity<ExceptionDto> onConstraintValidationException(Exception e) {
        log.error("{} {}", e.getClass(), e.getMessage());
        CoffeeMachineExceptionEnum coffeeMachineException = CoffeeMachineExceptionEnum.BAD_REQUEST;
        return ResponseEntity
                .status(coffeeMachineException.getCode())
                .body(ExceptionDto.builder()
                        .error(coffeeMachineException.getError())
                        .message(coffeeMachineException.getMessage())
                        .build());
    }

    @ExceptionHandler(CoffeeMachineException.class)
    public ResponseEntity<ExceptionDto> exceptionHandler(Exception e) {
        log.error("{} {}", e.getClass(), e.getMessage());
        CoffeeMachineExceptionEnum coffeeMachineException = CoffeeMachineExceptionEnum.valueOf(e.getMessage());
        return ResponseEntity
                .status(coffeeMachineException.getCode())
                .body(ExceptionDto.builder()
                        .error(coffeeMachineException.getError())
                        .message(coffeeMachineException.getMessage())
                        .build());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> defaultExceptionHandler(Exception e) {
        log.error("{} {}", e.getClass(), e.getMessage());
        CoffeeMachineExceptionEnum coffeeMachineException = CoffeeMachineExceptionEnum.INTERNAL_ERROR;
        return ResponseEntity
                .status(coffeeMachineException.getCode())
                .body(ExceptionDto.builder()
                        .error(coffeeMachineException.getError())
                        .message(coffeeMachineException.getMessage())
                        .build());
    }
}
