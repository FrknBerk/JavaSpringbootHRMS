package kodlama.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.hrms.business.abstracts.JobTitleService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.JobTitle;

@RestController
@RequestMapping("api/jobtitles/")
public class JobTitlesController {
	private JobTitleService jobTitleService;

	@Autowired
	public JobTitlesController(JobTitleService jobTitleService) {
		super();
		this.jobTitleService = jobTitleService;
	}
	
	@GetMapping("getall")
	public DataResult<List<JobTitle>> getAll(){
		return this.jobTitleService.getAll();
	}
	
	@PostMapping("add")
	public Result add(JobTitle jobTitle) {
		Result isTitle=this.jobTitleService.findByTitleIn(jobTitle.getTitle());
		System.out.println(isTitle.isSuccess());
		if(isTitle.isSuccess()) {
			System.out.println("Zaten aynı ad da var");
		}
		return this.jobTitleService.add(jobTitle);
	}
	
}
