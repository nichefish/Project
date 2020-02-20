package Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import Command.Member.ChangePwdCommand;

public class ChangePwdCommandValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return ChangePwdCommand.class.isAssignableFrom(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "pw", "required");
		ValidationUtils.rejectIfEmpty(errors, "newPw", "required");
		ValidationUtils.rejectIfEmpty(errors, "reNewPw", "required");
		ChangePwdCommand regReq = (ChangePwdCommand) target;
		if (!regReq.getNewPw().isEmpty()) {
			if(!regReq.isPasswordEqualToConfirmPassword()) {
				errors.rejectValue("reNewPw","pwNomatch");
			}
		}
	}
}
