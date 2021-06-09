package kodlama.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.hrms.business.abstracts.VerifyEmployeeService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.entities.concretes.VerifyEmployee;

@RestController
@RequestMapping("api/verifyemployees/")
public class VerifyEmployeesController {
	private VerifyEmployeeService verifyEmployeeService;

	@Autowired
	public VerifyEmployeesController(VerifyEmployeeService verifyEmployeeService) {
		super();
		this.verifyEmployeeService = verifyEmployeeService;
	}
	
	@GetMapping("getall")
	public DataResult<List<VerifyEmployee>> getall(){
		return this.verifyEmployeeService.getAll();
	}
}
