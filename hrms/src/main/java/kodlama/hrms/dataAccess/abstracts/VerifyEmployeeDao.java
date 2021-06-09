package kodlama.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.hrms.entities.concretes.VerifyEmployee;

public interface VerifyEmployeeDao extends JpaRepository<VerifyEmployee, Integer>{

}
