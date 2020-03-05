package Service.Goods;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import Command.Goods.GoodsCommand;
import Model.DTO.AuthInfo;
import Model.DTO.GoodsDTO;
import Repository.Goods.GoodsRepository;

@Service
public class GoodsWriterService {
	@Autowired
	private GoodsRepository goodsRepository;
	
	public Integer execute(GoodsCommand goodsCommand, HttpSession session, HttpServletRequest request) {
		GoodsDTO dto = new GoodsDTO();
		dto.setGoodsNum(goodsCommand.getGoodsNum());
		dto.setGoodsName(goodsCommand.getGoodsName());
		dto.setGoodsPrice(goodsCommand.getGoodsPrice());
		dto.setGoodsQty(goodsCommand.getGoodsQty());
		dto.setGoodsContent(goodsCommand.getGoodsContent());
		dto.setGoodsNum(goodsCommand.getGoodsNum());
		dto.setUserId(((AuthInfo)session.getAttribute("authInfo")).getId());
		
		// 테이블 관계가 일대다 같으면 리스트나 배열에 저장해야... 지금은 그냥 -로 이어서 스트링에 저장...
		String storeTotal = "";
//		<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver"> XML에 요게 있어야 쓸수 있는 거...
		for (MultipartFile mf : goodsCommand.getGoodsImage()) {
			String original = mf.getOriginalFilename();
			String originalFileExtension = original.substring(original.lastIndexOf("."));
			String store = UUID.randomUUID().toString().replace("-", "") + originalFileExtension;
//			String fileSize = Long.toString(mf.getSize());
//			originalTotal += original + "-";
			storeTotal += store + "-";
//			fileSizeTotal += fileSize + "-";
			String path = request.getServletContext().getRealPath("/");
			path += "WEB-INF\\view\\GoodsView\\update";
			System.out.println(path);
			File file = new File(path + "\\" + store);		// 파일 객체 생성- 아직 파일이 저장된 건 아님...
			try {
				mf.transferTo(file);
			} catch (IllegalStateException | IOException e) {
				// 저장이 안 되는 경우는 용량초과인 경우... 에러 만들어주면 됨...
				e.printStackTrace();
			}
		}
		dto.setGoodsImage(storeTotal);
		// 상품등록이고 자료실이 아니니까. 오리지널 파일네임이나 그림파일 용량이 중요하지 않다는 얘기.. 그래서 딴건 필요없음.. 랜덤생성된 실제저장이름만 있으면 된다..
		return goodsRepository.goodsInsert(dto);
	}
}
