package Service.Member;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Command.Member.MemberCommand;
import Repository.Member.MemberRepository;

@Service
public class MemberJoinService {

	
	
	@Autowired
	private MemberRepository memberRepository;

	public Integer execute(MemberCommand memberCommand) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
