package Repository.Survey;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.DTO.QuestionOptionDTO;

@Repository
public class SurveyRepository {
	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "questionMapper";
	
	public List<QuestionOptionDTO> surveySelectAll() {
		String statement = namespace + ".surveySelectAll";
		System.out.println("!!@!#!@#");
		List<QuestionOptionDTO> list = sqlSession.selectList(statement);
		return list;
	}
}