package kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.hrms.business.abstracts.EmployerService;
import kodlama.hrms.core.abstracts.RegexService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.ErrorDataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.core.utilities.results.SuccessDataResult;
import kodlama.hrms.dataAccess.abstracts.EmployerDao;
import kodlama.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	private EmployerDao employerDao;
	private RegexService regexService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,RegexService regexService) {
		super();
		this.employerDao = employerDao;
		this.regexService = regexService;
	}

	@Override
	public Result register(Employer employer) {
		if(regexService.checkWebsitesiAndEmail(employer, employer.getEmail())) {
			return new ErrorDataResult<Employer>("Web sitesi ile domain aynı değil");
		}
		return new SuccessDataResult<Employer>(this.employerDao.save(employer),"İş veren eklendi");
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"İş Veren Listelendi");
	}

}
