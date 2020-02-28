package Repository.Member;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {
	private static SqlSessionFactory sqlSessionFactory;
	
	public static void setSqlSessionFactory() {	// setter... 초기화 방법...
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);		// inputStream을 이용해서 파일 이름을 읽겠다는 얘기...
		} catch (IOException e) {
			e.printStackTrace();
		}	
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	public SqlSessionFactory getSqlSessionFactory() {	// getter
		return sqlSessionFactory;
	}
}
