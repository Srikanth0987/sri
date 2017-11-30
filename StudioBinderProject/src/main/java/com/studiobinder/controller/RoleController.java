package com.studiobinder.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.studiobinder.pojo.RolePojo;
import com.studiobinder.service.IRolService;

@RestController
@RequestMapping("role")
public class RoleController {

	@Autowired
	private IRolService roleservice;

	@RequestMapping(value="/save",method = RequestMethod.POST)
	public void getData(@RequestBody RolePojo rolePojo) {
		roleservice.SaveRoledata(rolePojo);

	}
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void DeleteData(@PathVariable int id) {
		System.out.println("====================");
		roleservice.DeleteRoleData(id);

	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<RolePojo> getall(RolePojo rolepojo) {
		List<RolePojo> list= roleservice.getRole(rolepojo);
		return list;

	}
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public void RoleByid(@PathVariable int id) {
		roleservice.getRoleById(id);
	}

}
