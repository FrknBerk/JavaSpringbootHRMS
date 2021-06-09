package kodlama.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.hrms.entities.concretes.VerifyEmail;

public interface VerifyEmailDao extends JpaRepository<VerifyEmail, Integer>{

}
