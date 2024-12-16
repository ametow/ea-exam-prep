package edu.miu.cs.najeeb.spring.examprep.Controller;

import edu.miu.cs.najeeb.spring.examprep.dto.ErrorDto;
import edu.miu.cs.najeeb.spring.examprep.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDto> handleNotFoundException(NotFoundException e) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(e.getMessage());
        errorDto.setCode(404);
        return new ResponseEntity<>(errorDto, org.springframework.http.HttpStatus.NOT_FOUND);
    }
}
