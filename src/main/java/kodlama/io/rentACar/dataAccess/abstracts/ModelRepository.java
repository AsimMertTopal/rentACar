package kodlama.io.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entities.concretes.Model;

public interface ModelRepository extends JpaRepository<Model, Integer>{
	List<Model> findAll();
}
