package com.myentry.MyEntry.controller;


import com.myentry.MyEntry.constants.APIConstants;
import com.myentry.MyEntry.dto.SearchCriteria;
import com.myentry.MyEntry.dto.VisitorRequestDTO;
import com.myentry.MyEntry.dto.VisitorResponseDTO;
import com.myentry.MyEntry.serviceImpl.VisitorServiceImpl;
import com.myentry.MyEntry.utils.ApplicationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = APIConstants.VISITOR_BASE_URL)
public class VisitorController {

	@Autowired
	private VisitorServiceImpl visitorService;

	@PreAuthorize("hasRole('USER')")
	@GetMapping
	public VisitorResponseDTO getAllVisitors() {
		long startTime = System.currentTimeMillis();
		VisitorResponseDTO visitorResponseDTO = visitorService.getAllVisitors();
		visitorResponseDTO.setResponseHeader(ApplicationUtils.prepareResponseHeader(startTime));
		return visitorResponseDTO;
	}

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/{visitorId}")
	public VisitorResponseDTO getVisitor(@PathVariable Long visitorId) {
		long startTime = System.currentTimeMillis();
		VisitorResponseDTO visitorResponseDTO = visitorService.getVisitor(visitorId);
		visitorResponseDTO.setResponseHeader(ApplicationUtils.prepareResponseHeader(startTime));
		return visitorResponseDTO;
	}

	@PreAuthorize("hasRole('USER')")
	@PostMapping
	public VisitorResponseDTO createVisitor(@RequestBody VisitorRequestDTO visitorRequestDTO) {
		long startTime = System.currentTimeMillis();
		VisitorResponseDTO visitorResponseDTO = visitorService.createVisitor(visitorRequestDTO);
		visitorResponseDTO.setResponseHeader(ApplicationUtils.prepareResponseHeader(startTime));
		return visitorResponseDTO;
	}

	@PreAuthorize("hasRole('USER')")
	@PutMapping
	public VisitorResponseDTO updateVisitor(@RequestBody VisitorRequestDTO visitorRequestDTO) {
		long startTime = System.currentTimeMillis();
		VisitorResponseDTO visitorResponseDTO = visitorService.updateVisitor(visitorRequestDTO);
		visitorResponseDTO.setResponseHeader(ApplicationUtils.prepareResponseHeader(startTime));
		return visitorResponseDTO;
	}

	@PreAuthorize("hasRole('USER')")
	@DeleteMapping("/{visitorId}")
	public VisitorResponseDTO deleteVisitor(@PathVariable Long visitorId) {
		long startTime = System.currentTimeMillis();
		VisitorResponseDTO visitorResponseDTO = visitorService.deleteVisitor(visitorId);
		visitorResponseDTO.setResponseHeader(ApplicationUtils.prepareResponseHeader(startTime));
		return visitorResponseDTO;
	}

	@PreAuthorize("hasRole('USER')")
	@PostMapping("/search")
	public  VisitorResponseDTO searchVisitor(@RequestBody SearchCriteria searchCriteria) {
		long startTime = System.currentTimeMillis();
		VisitorResponseDTO visitorResponseDTO= visitorService.searchVisitor(searchCriteria);
		visitorResponseDTO.setResponseHeader(ApplicationUtils.prepareResponseHeader(startTime));
		return visitorResponseDTO;
	}
}
