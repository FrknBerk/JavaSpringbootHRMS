package kodlama.hrms.adapters;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import kodlama.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisServiceAdapter implements MernisService{

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		boolean result = false;
		try {
			result = client.TCKimlikNoDogrula(Long.parseLong(candidate.getIdentityNumber()), candidate.getFirstName().toUpperCase(), candidate.getLastName().toUpperCase(), candidate.getBirthDate().getYear());
		}catch (NumberFormatException e) {
			e.printStackTrace();
		}catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
