package kodlama.io.rentACar.bussiness.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.bussiness.abstracts.BrandService;
import kodlama.io.rentACar.bussiness.requests.CreateBrandRequest;
import kodlama.io.rentACar.bussiness.requests.UpdateBrandRequest;
import kodlama.io.rentACar.bussiness.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.bussiness.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.core.utilities.results.DataResult;
import kodlama.io.rentACar.core.utilities.results.Result;
import kodlama.io.rentACar.core.utilities.results.SuccessDataResult;
import kodlama.io.rentACar.core.utilities.results.SuccessResult;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import kodlama.io.rentACar.rules.BrandBusinessRules;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService{

private	BrandRepository brandRepository;
private ModelMapperService modelMapperService;
private BrandBusinessRules brandBusinessRules; 	


	@Override
	public DataResult<List<GetAllBrandsResponse>> findAll() {
		List<Brand> brandGet=brandRepository.findAll();
		List<GetAllBrandsResponse> brandsResponses=brandGet.stream().map(brand->this.modelMapperService.forResponse()
				.map(brand, GetAllBrandsResponse.class))
				.collect(Collectors.toList());
		
	
		return new SuccessDataResult<List<GetAllBrandsResponse>>(brandsResponses, "Markalar Getirildi");
	
	}

	@Override
	public Result add ( CreateBrandRequest createBrandRequest) {
		this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
		Brand brand= this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
	
		this.brandRepository.save(brand);
		return new SuccessResult("Marka Eklendi");
	}

	@Override
	public Result update(UpdateBrandRequest updateBrandRequest) {
		Brand brand=this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		this.brandRepository.save(brand);
		return new SuccessResult("Marka Güncellendi");
	}

	@Override
	public Result delete(int id) {
		this.brandRepository.deleteById(id);
		return new SuccessResult("Marka Silindi !");
	}

	@Override
	public GetByIdBrandResponse getById(int id) {
		Brand brand=this.brandRepository.findById(id).orElseThrow();
		GetByIdBrandResponse response=this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
		return response;
	}
	

}
