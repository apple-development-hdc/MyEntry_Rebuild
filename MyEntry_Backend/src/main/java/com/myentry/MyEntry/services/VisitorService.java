package com.myentry.MyEntry.services;


import com.myentry.MyEntry.dto.SearchCriteria;
import com.myentry.MyEntry.dto.VisitorRequestDTO;
import com.myentry.MyEntry.dto.VisitorResponseDTO;

public interface VisitorService {

	public VisitorResponseDTO getAllVisitors();
	
	public VisitorResponseDTO createVisitor(VisitorRequestDTO visitorRequestDTO );
	
	public VisitorResponseDTO updateVisitor(VisitorRequestDTO visitorRequestDTO);
	
	public VisitorResponseDTO getVisitor(Long visitorId);
	
	public VisitorResponseDTO deleteVisitor(Long visitorId);

	public VisitorResponseDTO searchVisitor(SearchCriteria searchCriteria);
}
