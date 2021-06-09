package kodlama.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.hrms.business.abstracts.CandidateService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.ErrorResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.Candidate;

@RestController
@RequestMapping("api/candidates/")
public class CandidatesController {
	private CandidateService candidateService;
	
	@Autowired
	public CandidatesController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}
	
	@GetMapping("getall")
	public DataResult<List<Candidate>> getall(){
		return this.candidateService.getAll();
	}
	
	@PostMapping("register")
	public Result register(@RequestBody Candidate candidate) {
		if(this.candidateService.findNotNull(candidate)) {
			return new ErrorResult("Alanlar boş");
		}
		else {
			return this.candidateService.register(candidate);
		}
		
	}
}
