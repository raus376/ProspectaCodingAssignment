package com.prospecta.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@lombok.Data
public class Data {
	
	private int count;
	
	private List<ComponentAPI> values;

}
