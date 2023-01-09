package com.prospecta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prospecta.models.ComponentAPI;
import com.prospecta.models.Data;
import com.prospecta.repository.ComponentAPIRepo;

@Service
public class DataServiceImpl implements DataService{

	@Autowired
	ComponentAPIRepo cRepo;
	
	@Override
	public List<ComponentAPI> postData(Data data){
	
		
		int count=data.getCount();
		List<ComponentAPI> list=data.getValues();
		for(ComponentAPI e:list) {
			
			cRepo.save(e);
		}
		return list;

	
		
	
	}

}
