package kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.hrms.business.abstracts.JobTitleService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.ErrorResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.core.utilities.results.SuccessDataResult;
import kodlama.hrms.core.utilities.results.SuccessResult;
import kodlama.hrms.dataAccess.abstracts.JobTitleDao;
import kodlama.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService{
	private JobTitleDao jobTitleDao;

	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll(),"Job Title Listelendi");
	}

	@Override
	public Result add(JobTitle jobTitle) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<JobTitle>(this.jobTitleDao.save(jobTitle),"Job Title Eklendi");
	}

	@Override
	public Result findByTitleIn(String title) {
		boolean isTitle = this.jobTitleDao.findAll().contains(title);
		if(isTitle == true) {
			return new ErrorResult("Aynı isimde kullanıcı var");
		}
		else {
			return new SuccessResult("Eklendi");
		}
	}

}
