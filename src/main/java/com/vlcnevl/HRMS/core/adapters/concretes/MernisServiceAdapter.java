package com.vlcnevl.HRMS.core.adapters.concretes;

import org.springframework.stereotype.Service;

import com.vlcnevl.HRMS.core.adapters.abstracts.UserCheckService;

@Service
public class MernisServiceAdapter implements UserCheckService {

	@Override
	public boolean validate(String nationalityId, int birthYear) {
		if(nationalityId.length() ==11 && birthYear >= 1900)
		{
			return true;
		}
		
		return false;
		
	}
	/* mernis service added
	private boolean result;
	@Override
	public boolean checkUser(User user) {
		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();
		result = false;
		try {
			result = kpsPublicSoapProxy.TCKimlikNoDogrula(Long.parseLong(user.getNationalityNumber()), user.getFirstName(), user.getLastName(), user.getDateOfBirth());			
		}catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
		
	}*/

}
