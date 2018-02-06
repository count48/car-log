package com.r2int.car.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.r2int.car.backend.utils.ParseDeserializer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Entry {

	@JsonProperty( required = true ) private String category;
	@JsonProperty( required = true ) private Double amount;
	private String comments;
	@JsonSerialize( using = ToStringSerializer.class )
	@JsonDeserialize( using = ParseDeserializer.class )
	private LocalDateTime happenedAt;

	public String getComments()
	{
		return comments;
	}

	public void setComments( String comments )
	{
		this.comments = comments;
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

	public String getTransactionTime()
	{
		return happenedAt.format(DateTimeFormatter.ISO_DATE);
	}

	public LocalDateTime getHappenedAt()
	{
		return happenedAt;
	}

	public void setHappenedAt( LocalDateTime happenedAt )
	{
		this.happenedAt = happenedAt;
	}
}
