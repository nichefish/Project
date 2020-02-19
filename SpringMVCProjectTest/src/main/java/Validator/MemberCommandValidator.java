package Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class MemberCommandValidator implements Validator {
	private static final String emailRegExp = "^[_A-Za-z0-9-]+(.[_A-Za-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
	private Pattern pattern;
	public MemberCommandValidator() {
		pattern = Pattern.compile(emailRegExp);
	}
	
	public boolean supports(Class<?> clazz) {	// 지금 받은 타겟이 memberCommand냐- 요런 얘기고, 특별히 쓸일 없으면 그냥 return false로 놔둬도 무방하다...
		return Command.Member.MemberCommand.class.isAssignableFrom(clazz);	
	}
	public void validate(Object target, Errors errors) {	// 실제로 체크하는 validate 메소드-
		Command.Member.MemberCommand regReq = (Command.Member.MemberCommand) target;
		if (regReq.getUserEmail() == null || regReq.getUserEmail().trim().isEmpty()) {
			errors.rejectValue("userEmail", "required");	// error.properties에서 key값에 value 할당...
		} else {
			Matcher matcher = pattern.matcher(regReq.getUserEmail());	// true or false로 저장됨...
			if (!matcher.matches()) {
				errors.rejectValue("userEmail", "bad.userEmail");
			}
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "required");	// 비었거나 공백문자로 이루어져 있을 때 경고메세지...
		ValidationUtils.rejectIfEmpty(errors, "userPw", "required");
		ValidationUtils.rejectIfEmpty(errors, "userPwCon", "required");
		if (!regReq.getUserPw().isEmpty()) {
			if (!regReq.isUserPwEqualToUserPwCon()) {
				errors.rejectValue("userPwCon", "nomatch");
			}
		}
		ValidationUtils.rejectIfEmpty(errors, "userId", "required");
		ValidationUtils.rejectIfEmpty(errors, "userAddr", "required");
		ValidationUtils.rejectIfEmpty(errors, "userPh1", "required");
		ValidationUtils.rejectIfEmpty(errors, "userBirth", "required");
		
		
		
		
		
	}
}
