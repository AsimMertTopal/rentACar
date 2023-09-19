package kodlama.io.rentACar.bussiness.abstracts;

import java.util.List;


import kodlama.io.rentACar.bussiness.requests.CreateBrandRequest;
import kodlama.io.rentACar.bussiness.requests.UpdateBrandRequest;
import kodlama.io.rentACar.bussiness.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.bussiness.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.core.utilities.results.DataResult;
import kodlama.io.rentACar.core.utilities.results.Result;

public interface BrandService {
	 DataResult<List<GetAllBrandsResponse>> findAll();
	 Result add(CreateBrandRequest createBrandRequest);
	 Result update(UpdateBrandRequest updateBrandRequest);
	 Result delete(int id);
	 GetByIdBrandResponse getById(int id);
}
