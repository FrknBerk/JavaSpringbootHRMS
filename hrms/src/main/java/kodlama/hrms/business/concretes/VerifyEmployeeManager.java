package kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.hrms.business.abstracts.VerifyEmployeeService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.SuccessDataResult;
import kodlama.hrms.dataAccess.abstracts.VerifyEmployeeDao;
import kodlama.hrms.entities.concretes.VerifyEmployee;

@Service
public class VerifyEmployeeManager implements VerifyEmployeeService{
	private VerifyEmployeeDao verifyEmployeeDao;

	@Autowired
	public VerifyEmployeeManager(VerifyEmployeeDao verifyEmployeeDao) {
		super();
		this.verifyEmployeeDao = verifyEmployeeDao;
	}

	@Override
	public DataResult<List<VerifyEmployee>> getAll() {
		return new SuccessDataResult<List<VerifyEmployee>>(this.verifyEmployeeDao.findAll(),"Sistem personeli doğrulaması listelendi");
	}
	
}
