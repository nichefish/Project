package Service.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Command.Member.ChangePwdCommand;
import Controller.Encrypt;
import Model.DAO.MemberDAO;

@Service
public class PasswordModifyService {
	@Autowired
	private MemberDAO memberDAO;
	
	public Integer updatePassword(ChangePwdCommand changePwdCommand) {
		return memberDAO.pwUpdate(changePwdCommand.getUserId(), Encrypt.getEncryption(changePwdCommand.getPw()), Encrypt.getEncryption(changePwdCommand.getNewPw()));
	}
}
