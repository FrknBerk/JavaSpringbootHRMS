package kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.hrms.business.abstracts.EmployeeService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.core.utilities.results.SuccessDataResult;
import kodlama.hrms.dataAccess.abstracts.EmployeeDao;
import kodlama.hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService{
	private EmployeeDao employeeDao;

	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(),"Sistem çalışanı listelendi");
	}

	@Override
	public Result add(Employee employee) {
		return new SuccessDataResult<Employee>(this.employeeDao.save(employee),"Sistem çalışanı eklendi");
	}
	
	
	
}
