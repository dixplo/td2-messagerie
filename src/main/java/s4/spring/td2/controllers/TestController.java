package s4.spring.td2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import s4.spring.td2.models.Organization;
import s4.spring.td2.models.User;
import s4.spring.td2.repositories.OrgaRepository;

@Controller
@RequestMapping("/test/")
public class TestController {
	
	@Autowired
	private OrgaRepository orgaRepo;
	
	@GetMapping("hello/{from}")
	public String hello(@PathVariable String from) {
		return "hello";
	}
	
	@GetMapping("user/{name}")
	public @ResponseBody String user(@PathVariable String name) {
		User u=new User();
		u.setFirstname(name);
		u.setLastname("Dalton");
		u.setEmail("joe.dalton@prison.org");
		Organization o=new Organization();
		o.setName("Daltons");
		o.getUsers().add(u);
		u.setOrganization(o);
		orgaRepo.save(o);
		return o.toString();
	}
	
	
	@GetMapping("organizations")
	public String displayOrganizations(ModelMap model) {
		List<Organization> orgas=orgaRepo.findAll();
		model.put("orgas", orgas);
		return "orgas";
	}

	public void setOrgaRepo(OrgaRepository orgaRepo) {
		this.orgaRepo = orgaRepo;
	}
	
}
