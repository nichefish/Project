package Service.Member;

import java.sql.Timestamp;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Command.Member.MemberCommand;
import Controller.Encrypt;
import Model.DTO.MemberDTO;
import Repository.Member.MemberRepository;

@Service
public class MemberJoinService {
	@Autowired
	private MemberRepository memberRepository;

	public Integer execute(MemberCommand memberCommand) {
		Integer result = 0;
		MemberDTO dto = new MemberDTO();
		dto.setUserId(memberCommand.getUserId());
		dto.setUserPw(Encrypt.getEncryption(memberCommand.getUserPw()));
		dto.setUserName(memberCommand.getUserName());
		// memberCommand에서 userBirth 데이터타입을 Date로 바꿔서...
		Timestamp userBirth = new Timestamp(memberCommand.getUserBirth().getTime());
		dto.setUserBirth(userBirth);
		// 요렇게 하면 되나.. 테스트해보기...
		dto.setUserGender(memberCommand.getUserGender());
		dto.setUserEmail(memberCommand.getUserEmail());
		dto.setUserAddr(memberCommand.getUserAddr());
		dto.setUserPh1(memberCommand.getUserPh1());
		dto.setUserPh2(memberCommand.getUserPh2());
		return memberRepository.insertMember(dto);
	}
	
	

}
