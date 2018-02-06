package com.r2int.car.backend.resources;

import com.r2int.car.backend.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RecordRepository extends JpaRepository<Record, Integer> {

	@Override
	List<Record> findAll();

}
