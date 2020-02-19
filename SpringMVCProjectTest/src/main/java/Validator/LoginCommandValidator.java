package Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import Command.Member.LoginCommand;
import oracle.net.aso.e;

public class LoginCommandValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return false;
//		return LoginCommand.class.isAssignableFrom(clazz);
	}
	public void validate(Object target, Errors errors) {
//		if (supports(target)) { ... } 		// supports를 재정의하면 이런 식으로 쓰는 거다...
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id1", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pw", "required");
	}

}
