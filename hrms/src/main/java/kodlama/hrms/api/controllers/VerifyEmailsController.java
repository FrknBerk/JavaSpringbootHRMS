package kodlama.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.hrms.business.abstracts.VerifyEmailService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.entities.concretes.VerifyEmail;

@RestController
@RequestMapping("api/verifyemails")
public class VerifyEmailsController {
	private VerifyEmailService verifyEmailService;

	@Autowired
	public VerifyEmailsController(VerifyEmailService verifyEmailService) {
		super();
		this.verifyEmailService = verifyEmailService;
	}
	
	@GetMapping("getall")
	public DataResult<List<VerifyEmail>> getall(){
		return this.verifyEmailService.getAll();
	}
	
}
