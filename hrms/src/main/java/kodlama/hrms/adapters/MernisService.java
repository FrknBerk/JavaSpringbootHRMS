package kodlama.hrms.adapters;

import kodlama.hrms.entities.concretes.Candidate;

public interface MernisService {
	boolean checkIfRealPerson(Candidate candidate);
}
