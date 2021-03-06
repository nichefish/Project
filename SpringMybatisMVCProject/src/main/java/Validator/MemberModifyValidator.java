package Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class MemberModifyValidator implements Validator {
	// 항목 갯수가 안 맞으면 null..이 떠서 걍 MemberCommandValidator갖다 돌려쓰는 식으론 사용할 수 없다고?하는거 같음...
	private static final String emailRegExp = "^[_A-Za-z0-9-]+(.[_A-Za-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
	private Pattern pattern;
	public MemberModifyValidator() {
		pattern = Pattern.compile(emailRegExp);
	}
	
	public boolean supports(Class<?> clazz) {	// 지금 검사받는 타겟이 memberCommand냐- 요런 얘기고, 특별히 쓸일 없으면 그냥 return false로 놔둬도 무방하다...
		return Command.Member.MemberCommand.class.isAssignableFrom(clazz);	
	}
	public void validate(Object target, Errors errors) {	// 실제로 체크하는 validate 메소드-
		Command.Member.MemberCommand regReq = (Command.Member.MemberCommand) target;		// 이메일 검사하는 로직...
		if (regReq.getUserEmail() == null || regReq.getUserEmail().trim().isEmpty()) {
			errors.rejectValue("userEmail", "required");	// error.properties에서 key값에 value 할당...
		} else {
			Matcher matcher = pattern.matcher(regReq.getUserEmail());	// true or false로 저장됨...
			if (!matcher.matches()) {
				errors.rejectValue("userEmail", "bad.userEmail");
			}
		}
		ValidationUtils.rejectIfEmpty(errors, "userPw", "required");
		ValidationUtils.rejectIfEmpty(errors, "userAddr", "required");
		ValidationUtils.rejectIfEmpty(errors, "userPh1", "required");
	}
}
