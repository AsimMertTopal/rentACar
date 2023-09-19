package kodlama.io.rentACar.webApi;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.rentACar.bussiness.abstracts.ModelService;
import kodlama.io.rentACar.bussiness.requests.CreateModelRequest;
import kodlama.io.rentACar.bussiness.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.bussiness.responses.GetAllModelResponse;
import kodlama.io.rentACar.core.utilities.results.DataResult;
import kodlama.io.rentACar.core.utilities.results.Result;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {
     private	ModelService modelService;
	
	     @GetMapping("/findAll")
		 public DataResult<List<GetAllModelResponse>> findAll(){
			 return modelService.findAll();
		 }
	     @PostMapping("/add")
	     @ResponseStatus(code=HttpStatus.CREATED)
	     Result add(@RequestBody CreateModelRequest createModelRequest) {
	    	    return this.modelService.add(createModelRequest);
	    	}

}
