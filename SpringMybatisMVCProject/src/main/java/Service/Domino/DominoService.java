package Service.Domino;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Model.DTO.ADTO;
import Model.DTO.BDTO;
import Model.DTO.CDTO;
import Repository.Domino.DominoRepository;

@Service
public class DominoService {
	@Autowired
	private DominoRepository dominoRepository;
	
	public void execute(Model model) {
		List<ADTO> lists = dominoRepository.selectA();
		model.addAttribute("aa", lists);
	}

	public void execute1(Model model, Integer a1) {
		List<BDTO> lists = dominoRepository.selectB(a1);
		model.addAttribute("bb", lists);
	}

	public void execute2(Model model, Integer a1, Integer b1) {
		BDTO dto = new BDTO();
		dto.setA1(a1);
		dto.setB1(b1);
		List<CDTO> lists = dominoRepository.selectC(dto);
		model.addAttribute("cc", lists);
	}
}
