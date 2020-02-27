package Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import Command.Board.BoardCommand;

public class BoardCommandValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return BoardCommand.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "boardName", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "boardPass", "required");
		ValidationUtils.rejectIfEmpty(errors, "boardSubject", "required");
	}
}