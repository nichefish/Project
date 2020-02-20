package Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class BoardCommandValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return false;
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "boardName", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "boardPass", "required");
		ValidationUtils.rejectIfEmpty(errors, "boardSubject", "required");
	}
}