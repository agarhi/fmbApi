package com.fmb.api.error.handling;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fmb.api.model.request.SignUpResponse;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
	
	@ExceptionHandler(FmbException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody SignUpResponse handleResourceNotFound(final FmbException exception,
			final HttpServletRequest request) {

		SignUpResponse error = new SignUpResponse();
		error.setErrorMessage(exception.getMessage());
		error.setStatus(500);
		exception.printStackTrace();
		return error;
	}

}
