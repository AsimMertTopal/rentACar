package kodlama.io.rentACar;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import kodlama.io.rentACar.core.utilities.exception.BussinessException;
import kodlama.io.rentACar.core.utilities.exception.ProblemDetails;

@SpringBootApplication
@RestControllerAdvice
public class RentACarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);
	}
	@ExceptionHandler
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBussinesException(BussinessException bussinessException) {
		ProblemDetails problemDetails=new ProblemDetails();
		problemDetails.setMessage(bussinessException.getMessage());
		return problemDetails;
	
	}
	
    @Bean
	 public ModelMapper getModelMapper() {
		 return new ModelMapper();
	 }
}
