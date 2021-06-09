package kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.hrms.business.abstracts.VerifyEmailService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.SuccessDataResult;
import kodlama.hrms.dataAccess.abstracts.VerifyEmailDao;
import kodlama.hrms.entities.concretes.VerifyEmail;

@Service
public class VerifyEmailManager implements VerifyEmailService{
	private VerifyEmailDao verifyEmailDao;

	@Autowired
	public VerifyEmailManager(VerifyEmailDao verifyEmailDao) {
		super();
		this.verifyEmailDao = verifyEmailDao;
	}

	@Override
	public DataResult<List<VerifyEmail>> getAll() {
		return new SuccessDataResult<List<VerifyEmail>>(this.verifyEmailDao.findAll(),"Email doğrulama listelendi");
	}
	
}
