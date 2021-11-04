package com.care.root.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired
	MemberService ms;
	public MemberController() {
		System.out.println("controller 생성자 실행");
	}
	@RequestMapping("test")
	public void test() {
		System.out.println(ms);
		ms.test();
	}
	@GetMapping("/index")
	public String memberIndex() {
		return "member/index";
	}
	
	@GetMapping("/register_view")
	public String registerView() {
		return "member/register_view";
	}
	
	@GetMapping("/member_list")
	public String memberList(Model model) {
		ms.memberList(model);
		
		return "member/member_list";
	}
	
	@PostMapping("/register")
	public String register(@RequestParam String id,
						@RequestParam String pwd,
						@RequestParam String name) {
		System.out.println(id);
		System.out.println(pwd);
		System.out.println(name);
		
		ms.register(id,pwd,name);
		
		return "member/index";
	}
	
	@RequestMapping("result")
	public String result(HttpServletRequest request, Model model,
							RedirectAttributes rs) {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		int re = 0;
		MemberDTO dto = new MemberDTO();
		if(id.equals(dto.getId())) {
	//		rs.addFlashAttribute("result","리다이렉트 값");// 리다이렉트 값을 넘길려면 이걸 사용해야함
	//		dto.setId(id);
	//		rs.addFlashAttribute("test",dto);
			if(pwd.equals(dto.getPwd())) {
				re = 1;
				rs.addFlashAttribute("check",re);
				dto.setId(id);
				rs.addFlashAttribute("test",dto);
				return "redirect:login";
			}else {
				re = 2;
				rs.addFlashAttribute("check",re);
				return "redirect:loginchk";
			}
		}else {
			re = 3;
			rs.addFlashAttribute("check",re);
			return "redirect:loginchk";
		}
	}
	
	@RequestMapping("/loginchk")
	public String loginchk() {
		return "member/loginchk";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "member/login";
	}
	
	@RequestMapping("check")
	public String check(Model model, RedirectAttributes re,
				@RequestParam("id") String id, @RequestParam("pwd") String pwd) {
		ms.check(id, pwd, model);
		re.addFlashAttribute("reMap", model);
		return "redirect:/member/index";
	}

	@RequestMapping("memberInfo")
	public String memberInfo(@RequestParam String id, Model model) {
		ms.memberInfo(id, model);
		return "member/member_info";
	}
	
/*	
	@PostMapping("/register1")
	public String register1(HttpServletRequest req) {
		System.out.println(req.getParameter("id"));
		System.out.println(req.getParameter("pwd"));
		System.out.println(req.getParameter("name"));
	
		ms.register(req.getParameter("id"),
					req.getParameter("pwd"),
					req.getParameter("name"));
		
		return "member/index";
	}
	
	@PostMapping("/register2")
	public String register2(MemberDTO dto) {
		System.out.println("dto.id : "+dto.getId());
		System.out.println("dto.pwd : "+dto.getPwd());
		System.out.println("dto.name : "+dto.getName());
				
		return "member/index";
	}
*/
}






