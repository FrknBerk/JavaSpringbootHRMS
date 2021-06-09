package kodlama.hrms.core.abstracts;

import kodlama.hrms.entities.concretes.Employer;

public interface RegexService {
	boolean checkEmail(String email);
	boolean checkWebsitesiAndEmail(Employer employer,String email);
}
