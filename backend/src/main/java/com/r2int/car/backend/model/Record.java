package com.r2int.car.backend.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.r2int.car.backend.utils.ParseDeserializer;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity @Table( name = "record", catalog = "test" ) public class Record {

	@Id
	@GeneratedValue
	private Integer id;
	@Column( name = "entry_time" )
	@JsonSerialize( using = ToStringSerializer.class )
	@JsonDeserialize( using = ParseDeserializer.class )
	private LocalDateTime entryTime;
	@Column( name = "transaction_time" )
	@JsonSerialize( using = ToStringSerializer.class )
	@JsonDeserialize( using = ParseDeserializer.class )
	private LocalDateTime transactionTime;
	@Column( name = "category_time" ) private String category;
	@Column( name = "amount" ) private Double amount;
	@Column( name = "comment" ) private String comment;

	public Record( String category )
	{
		this.entryTime = LocalDateTime.now();
		this.transactionTime = entryTime;
		this.category = category;
	}

	public Record()
	{
	}

	public LocalDateTime getEntryTime()
	{
		return entryTime;
	}

	public String getTransactionTime()
	{
		return transactionTime.toString();
	}

	public void setTransactionTime( LocalDateTime transactionTime )
	{
		this.transactionTime = transactionTime;
	}

	public String getCategory()
	{
		return category;
	}

	public void setCategory( String category )
	{
		this.category = category;
	}

	public Double getAmount()
	{
		return amount;
	}

	public void setAmount( Double amount )
	{
		this.amount = amount;
	}

	public String getComment()
	{
		return comment;
	}

	public void setComment( String comment )
	{
		this.comment = comment;
	}
}
