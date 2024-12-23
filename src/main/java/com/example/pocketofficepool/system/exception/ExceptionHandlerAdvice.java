package com.example.pocketofficepool.system.exception;

import com.example.pocketofficepool.system.Result;
import com.example.pocketofficepool.system.StatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.AccessDeniedException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ExceptionHandlerAdvice {
    @ExceptionHandler(ObjectNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    Result handleObjectNotFoundException(ObjectNotFoundException e) {
        return new Result(false, StatusCode.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    Result handleValidationException(MethodArgumentNotValidException ex) {
        List<ObjectError> errors = ex.getBindingResult().getAllErrors();
        Map<String, String> map = new HashMap<>(errors.size());
        errors.forEach((error) -> {
            String key = ((FieldError) error).getField();
            String val = error.getDefaultMessage();
            map.put(key, val);
        });
        return new Result(false, StatusCode.INVALID_ARGUMENT, "Provided arguments are invalid, see data for details.", map);
    }

    @ExceptionHandler({UsernameNotFoundException.class, BadCredentialsException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    Result handleBadCredentialsException(Exception e) {
        return new Result(false, StatusCode.UNAUTHORIZED, "username or password is incorrect", e.getMessage());
    }

    @ExceptionHandler({AccountStatusException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    Result handleAccountStatusException(AccountStatusException e) {
        return new Result(false, StatusCode.UNAUTHORIZED, "User account is abnormal", e.getMessage());
    }

//    @ExceptionHandler({InvalidBearerTokenException.class})
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    Result handleInvalidBearerTokenException(InvalidBearerTokenException e) {
//        return new Result(false, StatusCode.UNAUTHORIZED, "The access token provided is expired, revoked, malformed, or invalid for other reasons", e.getMessage());
//    }

    @ExceptionHandler({AccessDeniedException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    Result handleAccessDeniedException(AccessDeniedException e) {
        return new Result(false, StatusCode.FORBIDDEN, "No Permission", e.getMessage());
    }

    /**
     * Handle other exceptions, only called if no other exception handler is called
     * @param e
     * @return
     */
    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    Result handleOtherException(Exception e) {
        return new Result(false, StatusCode.INTERNAL_SERVER_ERROR, "A server internal error occurred", e.getMessage());
    }
}
