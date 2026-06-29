package com.wildlife.stats.exceptions.handler;

import com.wildlife.stats.dto.ErrorResponseDTO;
import com.wildlife.stats.exceptions.QueryObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionsHandler {

    Logger logger = LoggerFactory.getLogger(GlobalExceptionsHandler.class);

    @ExceptionHandler(QueryObjectNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleObjectNotFoundExceptions(QueryObjectNotFoundException ex) {
        logger.error("Entity {} not found due to: {}", ex.getStackTrace(), ex.getMessage());

        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
                ex.getMessage(),
                "EntityNotFoundException");

        return ResponseEntity.internalServerError().body(errorResponseDTO);
    }

    //Catch all exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleAllOtherExceptions(Exception ex) {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
                ex.getMessage(),
                "Other Exceptions");

        return ResponseEntity.internalServerError().body(errorResponseDTO);
    }

}
