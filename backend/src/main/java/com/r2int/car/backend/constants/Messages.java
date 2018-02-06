package com.r2int.car.backend.constants;

import java.util.HashMap;
import java.util.Map;

public enum Messages {
	INVALID_CATEGORY("Invalid category entered "), SUCCESS("Record successfully added "), SYSTEMERROR(
			"System failure code 500 ");

	private String displayName;

	Messages( String displayName )
	{
		this.displayName = displayName;
	}

	public String displayName()
	{
		return displayName;
	}

	public Map<String, String> response( String suffix )
	{
		HashMap<String, String> response = new HashMap<>();
		response.put("response", displayName + suffix);
		return response;
	}

	// Optionally and/or additionally, toString.
	@Override
	public String toString()
	{
		return displayName;
	}
}
