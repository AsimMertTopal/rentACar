package kodlama.io.rentACar.rules;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.core.utilities.exception.BussinessException;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class BrandBusinessRules {
	private BrandRepository brandRepository;
	public void checkIfBrandNameExists(String name) {
		if(this.brandRepository.existsByName(name)) {
			throw new BussinessException("Marka Zaten Mevcut");
		}
		
	}

}
