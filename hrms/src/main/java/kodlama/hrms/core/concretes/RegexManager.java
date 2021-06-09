package kodlama.hrms.core.concretes;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import kodlama.hrms.core.abstracts.RegexService;
import kodlama.hrms.entities.concretes.Employer;

@Service
public class RegexManager implements RegexService{

	@Override
	public boolean checkEmail(String email) {
		String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
		Pattern pattern = Pattern.compile(EMAIL_PATTERN,Pattern.CASE_INSENSITIVE);
		boolean emailValid = pattern.matcher(email).find();
		if (emailValid) {
			return false;
		}
		return true;
	}

	@Override
	public boolean checkWebsitesiAndEmail(Employer employer,String email) {
		String input = employer.getWebSite();
		String webSplit = "((www).)|(.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$)";//websitesinde domain adresini alıyoruz
		Pattern pattern1 = Pattern.compile(webSplit);
		String[] result = pattern1.split(input);//parçalara ayırıyoruz 
		String domain = result[1];
		String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@" + domain+ "+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
		Pattern pattern = Pattern.compile(EMAIL_PATTERN,Pattern.CASE_INSENSITIVE);
		boolean emailValid = pattern.matcher(email).find();
		if(emailValid) {
			return false;
		}
		return true;
	}

}
