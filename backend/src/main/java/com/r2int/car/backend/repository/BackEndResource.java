package com.r2int.car.backend.repository;

import com.r2int.car.backend.constants.Category;
import com.r2int.car.backend.constants.Messages;
import com.r2int.car.backend.model.Entry;
import com.r2int.car.backend.model.Record;
import com.r2int.car.backend.resources.RecordRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController @RequestMapping( "/backend" ) public class BackEndResource {

	@Autowired private RecordRepository recordRepository;

	private Logger logger = LoggerFactory.getLogger(BackEndResource.class);

	@GetMapping( "/getlog" )
	public List<Record> addAllRecords()
	{
		return recordRepository.findAll();
	}

	@PostMapping( "/addexpense" )
	public Map<String, String> addExpense( @RequestBody Entry entry )
	{
		Category category;
		try
		{
			category = Category.valueOf(entry.getCategory().toUpperCase());
		}
		catch( IllegalArgumentException e )
		{
			logger.error(Messages.INVALID_CATEGORY.displayName() + entry.getCategory());
			return Messages.INVALID_CATEGORY.response(entry.getCategory());
		}

		try
		{
			Record record = new Record(category.toString().toUpperCase());
			record.setAmount(entry.getAmount());
			if( entry.getTransactionTime() != null )
			{
				record.setTransactionTime(entry.getHappenedAt());
			}
			record.setComment(entry.getComments());
			recordRepository.save(record);
			return Messages.SUCCESS.response("");
		}
		catch( Exception e )
		{
			logger.error(e.getMessage());
			return Messages.SYSTEMERROR.response("");
		}

	}

}
