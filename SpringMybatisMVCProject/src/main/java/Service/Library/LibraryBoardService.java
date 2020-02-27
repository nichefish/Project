package Service.Library;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import Command.Library.LibraryBoardCommand;
import Controller.Encrypt;
import Model.DAO.LibraryBoardDAO;
import Model.DTO.AuthInfo;
import Model.DTO.LibraryBoardDTO;

@Service
public class LibraryBoardService {
	@Autowired
	private LibraryBoardDAO libraryBoardDAO;
	final String PATH = "WEB-INF\\view\\libraryBoard\\update\\";		// 파일 업로드될 경로...
	
	public String writePro(LibraryBoardCommand libraryBoardCommand, HttpSession session, HttpServletRequest request) {
		Integer result = 0;
		LibraryBoardDTO libraryDTO = new LibraryBoardDTO();
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		libraryDTO.setUserId(authInfo.getId());
		libraryDTO.setBoardName(libraryBoardCommand.getBoardName());
		libraryDTO.setBoardPass(Encrypt.getEncryption(libraryBoardCommand.getBoardPass()));
		libraryDTO.setBoardSubject(libraryBoardCommand.getBoardSubject());
		libraryDTO.setBoardContent(libraryBoardCommand.getBoardContent());
		libraryDTO.setIpAddr(request.getRemoteAddr());
		// 파일 여러개 배열로 받아서 저장하는 거... 파일은 배열에서 다 저장되고. String들은 DB에 저장하기 위한 정보다...
		String originalTotal = "";
		String storeTotal = "";
		String fileSizeTotal = "";
		String filePath = request.getServletContext().getRealPath(PATH);		// 실제 파일 저장경로...
		System.out.println("filePath: " + filePath);
		String location = "";
		for (MultipartFile mf : libraryBoardCommand.getReport()) {
			// 여기서는 file renaming policy가 없고.. 같은 이름이면 덮어씌워 버리니까. 내가 직접적으로 이름을 바꿔줘야 된다고...
			String original = mf.getOriginalFilename();
			String originalFileExtension = original.substring(original.lastIndexOf("."));		// 마지막에 나오는 점 포함 기준으로 뒤쪽으로 자른 거...
			// UUID.. 랜덤으로 고유한 아이디를 부여할 때 쓰는 거라고...
			String store = UUID.randomUUID().toString().replace("-", "") + originalFileExtension;	// 랜덤생성한 유니크한 아이디에 확장자를 붙여줘서 새 파일명으로...
			String fileSize = Long.toString(mf.getSize());
			// 각 파일마다 이것들을 구해서. total..어쩌고 변수에 하나씩 끄트머리에 더해줘서. 한 문자열로 만든 최종(총합)값을 DB에 저장한다...
			originalTotal += original + "-";
			storeTotal += store + "-";
			fileSizeTotal += fileSize + "-";
			File file = new File(filePath + store);
			// 파일이름에 "-"가 들어있는 경우... 뭔가..
			try {
				mf.transferTo(file);
			} catch (Exception e) {		// 파일 저장 안되는건. 파일 크기 초과했을 때...
				request.setAttribute("fileError",  "업로드 가능한 용량을 초과했습니다.");	// request 받아왔을 때는 굳이 model 또 받아올 필요가 없다고...
				location = "libraryBoard/board_write";				// 글쓰기 페이지로 이동...
				e.printStackTrace();
			}
		}
		libraryDTO.setOriginalFileName(originalTotal);
		libraryDTO.setStoreFileName(storeTotal);
		libraryDTO.setFileSize(fileSizeTotal);		// 여기서 작대기 때문에 에러뜬다.. NumberFormatException.. 결국에는 다 String으로 저장해야 된다.. DB도 varchar2로 바꿔야..
		location = "redirect:/libraryBoard/library";
		libraryBoardDAO.insertBoard(libraryDTO);
		return location;
	}
}