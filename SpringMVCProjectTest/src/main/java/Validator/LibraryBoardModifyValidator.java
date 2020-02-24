package Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import Command.Library.LibraryBoardCommand;

public class LibraryBoardModifyValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return LibraryBoardCommand.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "boardName", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "boardPass", "required");
		ValidationUtils.rejectIfEmpty(errors, "boardSubject", "required");
	}
}
