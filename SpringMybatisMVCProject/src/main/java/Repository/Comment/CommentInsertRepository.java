package Repository.Comment;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.DTO.CommentDTO;
import Model.DTO.ReplyDTO;

@Repository
public class CommentInsertRepository {
	@Autowired
	private SqlSession sqlSession;
	// abstractRepository.. 요거는 jsp스타일에서 연결 새로 만들어서 쓸때 쓰는거고.. 스프링 스타일에서는 그렇게 안 해도 된다고...	
	private final String namespace = "Repository.Comment.commentMapper";
	
	public void commentInsert(CommentDTO dto) {
		String statement = namespace + ".insertComment";
		sqlSession.insert(statement, dto);
	}

	public void replyInsert(ReplyDTO dto) {
		String statement = namespace + ".insertReply";
		sqlSession.insert(statement, dto);
	}
}
