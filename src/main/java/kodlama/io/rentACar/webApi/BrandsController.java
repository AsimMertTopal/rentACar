package kodlama.io.rentACar.webApi;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import kodlama.io.rentACar.bussiness.abstracts.BrandService;
import kodlama.io.rentACar.bussiness.requests.CreateBrandRequest;
import kodlama.io.rentACar.bussiness.requests.UpdateBrandRequest;
import kodlama.io.rentACar.bussiness.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.bussiness.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.core.utilities.results.DataResult;
import kodlama.io.rentACar.core.utilities.results.Result;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/brands")
@Configuration
@AllArgsConstructor
public class BrandsController {
	BrandService brandService;


     @GetMapping()
	 public DataResult<List<GetAllBrandsResponse>> findAll(){
		 return brandService.findAll();
	 }
     
     @PostMapping()
     @ResponseStatus(code = HttpStatus.CREATED)
     public  Result add(CreateBrandRequest createBrandRequest) {
    	 return this.brandService.add(createBrandRequest);
    	 
     }
     
     @GetMapping("/{id}")
     public GetByIdBrandResponse getById(@PathVariable int id) {
    	 return brandService.getById(id);
    	 
     }
     @PutMapping
     public Result update(@RequestBody UpdateBrandRequest updateBrandRequest) {
    	 System.out.println(updateBrandRequest.getId() + updateBrandRequest.getName());
    	 return this.brandService.update(updateBrandRequest);
     }
     @DeleteMapping("/{id}")
     public Result delete(@PathVariable int id) {
    	 return this.brandService.delete(id);
     }
}
