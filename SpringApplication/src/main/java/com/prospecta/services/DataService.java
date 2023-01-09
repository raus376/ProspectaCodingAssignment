package com.prospecta.services;

import java.util.List;

import com.prospecta.models.ComponentAPI;
import com.prospecta.models.Data;

public interface DataService {
	
	public List<ComponentAPI> postData(Data data);

}
