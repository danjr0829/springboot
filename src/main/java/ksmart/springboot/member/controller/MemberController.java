package ksmart.springboot.member.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ksmart.springboot.exam.dto.Member;
import ksmart.springboot.exam.service.ExamService;

/**
 * @RestController = @Controller + @ResponseBody
 */
@RestController
public class MemberController {

	private final ExamService examService;
	
	public MemberController(ExamService examService) {
		this.examService = examService;
	}
	
	/**
	 * @RequestBody 요청한 json 객체를 서버에서 바인딩 받을 때 사용하는 어노테이션
	 * json 전달되는 데이터 타입에 맞게 자바타입를 선언해야한다.
	 * DTO로 선언하고 데이터바인딩 받는게 유지보수시 유리하다. 
	 * @param paramMap
	 * @return
	 */
	@PostMapping("/member/searchId")
	public Member getMemberInfo(@RequestBody Map<String, String> paramMap) {
		/*
		Set<String> keySet = paramMap.keySet();
		keySet.forEach(key -> {
			System.out.println(paramMap.get(key));
		});
		*/
		
		String memberId = paramMap.get("memberId");
		//System.out.println("Member: " + member);
		System.out.println("memberId: " + memberId);
		return examService.getMemberInfoById(memberId);
	}
	
	@GetMapping("/member/list")
	public List<Member> getMemberList(){
		return examService.getMemberList();
	}
	
	/**
	 * @PathVariable :  주소 맵핑 시 {바인딩 받을 키}
	 * 핸들러 메소드 매개변수의 @PathVariable(name="바인딩 받을 키") 데이터타입 변수명
	 * @param memberId
	 * @return
	 */
	@GetMapping("/member/{memberId}")
	public Member getMemberInfoById(@PathVariable(name="memberId") String memberId) {
		
		return examService.getMemberInfoById(memberId);
	}
}











