package kodlama.io.rentACar.bussiness.abstracts;

import java.util.List;

import kodlama.io.rentACar.bussiness.requests.CreateModelRequest;
import kodlama.io.rentACar.bussiness.responses.GetAllModelResponse;
import kodlama.io.rentACar.core.utilities.results.DataResult;
import kodlama.io.rentACar.core.utilities.results.Result;

public interface ModelService {
	DataResult<List<GetAllModelResponse>> findAll();
	 Result add(CreateModelRequest createModelRequest);
}
