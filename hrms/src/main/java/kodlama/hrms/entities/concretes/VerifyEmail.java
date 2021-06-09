package kodlama.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="verify_emails")
@AllArgsConstructor
@NoArgsConstructor
public class VerifyEmail {
	
	//User tablosu ile ilişki kurulabilir çünkü buraki employer_id hem candidate tablosundan hemde employer tablosundan gelebilir
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	/*@Column(name="employer_id")
	private int employerId;*/
	
	@Column(name="verify_code")
	private String verifyCode;
	
	@Column(name="is_confirmed")
	private boolean isConfirmed;
	
	@Column(name="confirmed_date")
	private Date confirmedDate;
	
	@ManyToOne
	@JoinColumn(name="employer_id")
	private Employer employer;
}
