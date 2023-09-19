package kodlama.io.rentACar.bussiness.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.bussiness.abstracts.ModelService;
import kodlama.io.rentACar.bussiness.requests.CreateModelRequest;
import kodlama.io.rentACar.bussiness.responses.GetAllModelResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.core.utilities.results.DataResult;
import kodlama.io.rentACar.core.utilities.results.Result;
import kodlama.io.rentACar.core.utilities.results.SuccessDataResult;
import kodlama.io.rentACar.core.utilities.results.SuccessResult;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import kodlama.io.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

	 private ModelRepository modelRepository;
	 private ModelMapperService modelMapperService;
	 
	@Override
	public DataResult<List<GetAllModelResponse>> findAll() {
		List<Model> models=modelRepository.findAll();
		List<GetAllModelResponse> modelResponse=models.stream()
				.map(model->this.modelMapperService.forResponse()
					.map(model,GetAllModelResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllModelResponse>>(modelResponse, "Modeller Listelendi");
	}

	@Override
	public Result add(CreateModelRequest createModelRequest) {

		Model model= this.modelMapperService.forRequest().map(createModelRequest, Model.class);
	
		this.modelRepository.save(model);
		return new SuccessResult("Model Eklendi");
	}

}
