package kodlama.hrms.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.hrms.adapters.MernisService;
import kodlama.hrms.business.abstracts.CandidateService;
import kodlama.hrms.core.abstracts.RegexService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.ErrorDataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.core.utilities.results.SuccessDataResult;
import kodlama.hrms.dataAccess.abstracts.CandidateDao;
import kodlama.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{
	private CandidateDao candidateDao;
	private RegexService regexService;
	private MernisService mernisService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao,RegexService regexService,MernisService mernisService) {
		super();
		this.candidateDao = candidateDao;
		this.regexService = regexService;
		this.mernisService = mernisService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"İş arayan listelendi");
	}

	@Override
	public Result register(Candidate candidate) {
		if(!mernisService.checkIfRealPerson(candidate)) {
			return new ErrorDataResult<Candidate>("mernis uymuyor");
		}
		else if(regexService.checkEmail(candidate.getEmail())) {
			return new ErrorDataResult<Candidate>("Email Doğrulama yanlış");
		}
		else {
			this.candidateDao.save(candidate);
			return new SuccessDataResult<Candidate>("İş arayan eklendi");
		}
		
	}

	@Override
	public boolean findNotNull(Candidate candidate) {
		if(candidate.getBirthDate() == null && candidate.getEmail() == null && candidate.getFirstName()==null && candidate.getLastName() == null
				&& candidate.getIdentityNumber() == null && candidate.getPassword() == null) {
			return true;
		}
		return false;
	}

}
