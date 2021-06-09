package kodlama.hrms.business.abstracts;

import java.util.List;

import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.entities.concretes.VerifyEmployee;

public interface VerifyEmployeeService {
	DataResult<List<VerifyEmployee>> getAll();
}
