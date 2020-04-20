package com.myentry.MyEntry.serviceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import com.myentry.MyEntry.constants.CommonConstants;
import com.myentry.MyEntry.domain.Image;
import com.myentry.MyEntry.domain.Visitor;
import com.myentry.MyEntry.dto.*;
import com.myentry.MyEntry.repository.ImageRepository;
import com.myentry.MyEntry.repository.VisitorRepository;
import com.myentry.MyEntry.services.VisitorService;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class VisitorServiceImpl implements VisitorService {

	@Autowired
	VisitorRepository visitorRepository;

	@Autowired
	ImageRepository imageRepository;

	@Override
	public VisitorResponseDTO getAllVisitors() {
		List<VisitorDTO> visitorDTOList = new ArrayList<>();
		Optional<List<Visitor>> visitors = visitorRepository.fetchAllVisitors();
		if (visitors.isPresent()) {
			visitorDTOList = prepareVisitorDTOList(visitors.get());
		}
		return prepareVisitorResponse(visitorDTOList, StringUtils.EMPTY);
	}

	private List<VisitorDTO> prepareVisitorDTOList(List<Visitor> liVisitor) {
		List<VisitorDTO> visitors = new ArrayList<>();
		liVisitor.stream().forEach(visitor -> {
			visitors.add(prepareVisitorDTO(visitor));
		});
		return visitors;

	}

	private VisitorDTO prepareVisitorDTO(Visitor visitor) {

		VisitorDTO visitorDTO = new VisitorDTO();
		BeanUtils.copyProperties(visitor, visitorDTO);
		return visitorDTO;
	}

	@Override
	public VisitorResponseDTO createVisitor(VisitorRequestDTO visitorRequestDTO) {
		Visitor visitor = new Visitor();
		StringBuilder messageBuilder = new StringBuilder();
		List<VisitorDTO> visitorDTOList = null;
		VisitorDTO visitorDTO = visitorRequestDTO.getRequestBody().getVisitorDTO();
		if (!visitorExists(visitorDTO)) {
			saveVisitor(visitorDTO, visitor);
			visitorDTOList = prepareVisitorDTOList(Arrays.asList(visitor));
		} else {
			messageBuilder.append("Visitor Already Exists");
		}
		return prepareVisitorResponse(visitorDTOList, messageBuilder.toString());
	}

	private boolean visitorExists(VisitorDTO visitorDTO) {
		Optional<Visitor> visitorEntity = visitorRepository.findByEmployeeId(visitorDTO.getVisitorEmpId());
		if (visitorEntity.isPresent()) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	private Visitor saveVisitor(VisitorDTO visitorDTO, Visitor visitor) {
		BeanUtils.copyProperties(visitorDTO, visitor);
		Image image = new Image();
		image.setImageValue(visitorDTO.getImageValue());
		visitor.setActiveInd(1);
		visitor.setFirstName(visitorDTO.getFirstName().toUpperCase(Locale.ENGLISH));
		visitor.setLastName(visitorDTO.getLastName().toUpperCase(Locale.ENGLISH));
		visitor.setStatus(CommonConstants.ADDED);
		image.setVisitor(visitor);
		visitorRepository.save(visitor);
		imageRepository.save(image);
		return visitor;

	}

	@Override
	public VisitorResponseDTO updateVisitor(VisitorRequestDTO updateVisitorDTO) {
		Visitor visitor = fetchVisitorById(updateVisitorDTO.getRequestBody().getVisitorDTO().getId());
		StringBuilder messageBuilder = new StringBuilder();
		List<VisitorDTO> visitorDTOList = null;
		if (visitor != null) {
			updateAndSaveVisitor(visitor, updateVisitorDTO.getRequestBody().getVisitorDTO());
			visitorDTOList = prepareVisitorDTOList(Arrays.asList(visitor));
		} else {
			messageBuilder.append("visitor cannot be updated");
		}
		return prepareVisitorResponse(visitorDTOList, messageBuilder.toString());

	}

	private void updateAndSaveVisitor(Visitor visitor, VisitorDTO visitorDTO) {
		BeanUtils.copyProperties(visitorDTO, visitor);
		visitor.setFirstName(visitorDTO.getFirstName().toUpperCase(Locale.ENGLISH));
		visitor.setLastName(visitorDTO.getLastName().toUpperCase(Locale.ENGLISH));
		visitorRepository.save(visitor);
	}

	private Visitor fetchVisitorById(Long visitorId) {
		Optional<Visitor> visitorEntity = visitorRepository.findById(visitorId);
		if (visitorEntity.isPresent()) {
			return visitorEntity.get();
		}
		return null;
	}

	@Override
	public VisitorResponseDTO getVisitor(Long visitorId) {
		List<VisitorDTO> visitorDTOList = new ArrayList<>();
		Optional<Visitor> visitor = visitorRepository.findById(visitorId);
		if (visitor.isPresent()) {
			visitorDTOList = prepareVisitorDTOList(Arrays.asList(visitor.get()));
		}
		return prepareVisitorResponse(visitorDTOList, StringUtils.EMPTY);
	}

	@Override
	public VisitorResponseDTO deleteVisitor(Long visitorId) {
		Optional<Image> image = imageRepository.findById(visitorId);
		if(image.isPresent()){imageRepository.deleteById(visitorId);}
		return deleteVisitorAndSave(fetchVisitorById(visitorId));
	}

	@Override
	public VisitorResponseDTO searchVisitor(SearchCriteria searchCriteria) {
		List<VisitorDTO> visitorDTOList = new ArrayList<>();
		StringBuilder messageBuilder = new StringBuilder();
		LocalDateTime fromDate = LocalDateTime.MIN;
		LocalDateTime toDate = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

			if(searchCriteria.getName()==null)
				searchCriteria.setName("");
			if(searchCriteria.getLocation()==null)
				searchCriteria.setLocation("");
			if (searchCriteria.getFromDate() != null)
				fromDate = LocalDateTime.parse(searchCriteria.getFromDate(), formatter);
			if (searchCriteria.getToDate() != null)
				toDate = LocalDateTime.parse(searchCriteria.getToDate(), formatter);

		Optional<List<Visitor>> visitors = visitorRepository.fetchSearchVisitor(searchCriteria.getName().toUpperCase(),fromDate,toDate,searchCriteria.getLocation().toUpperCase());
		if (visitors.isPresent())
			visitorDTOList = prepareVisitorDTOList(visitors.get());
		else
			messageBuilder.append("Visitor not found");

		return prepareVisitorResponse(visitorDTOList,messageBuilder.toString());
	}

	private VisitorResponseDTO deleteVisitorAndSave(Visitor visitor) {
		List<VisitorDTO> visitorDTOList = new ArrayList<>();
		StringBuilder messageBuilder = new StringBuilder();
		if (visitor != null) {
			visitor.setActiveInd(0);
			visitor.setStatus(CommonConstants.DELETED);
			visitorRepository.save(visitor);
			visitorDTOList = prepareVisitorDTOList(Arrays.asList(visitor));
		} else {
			messageBuilder.append("visitor cannot be deleted");
		}
		return prepareVisitorResponse(visitorDTOList, messageBuilder.toString());
	}

	private VisitorResponseDTO prepareVisitorResponse(List<VisitorDTO> liVisitor, String message) {
		VisitorResponseDTO visitorResponseDTO = new VisitorResponseDTO();
		visitorResponseDTO.setResponseBody(new VisitorResponseBodyDTO());
		if (!StringUtils.isEmpty(message)) {
			visitorResponseDTO.getResponseBody().setMessage(message);
		} else {
			visitorResponseDTO.getResponseBody().setVisitors(liVisitor);
		}
		return visitorResponseDTO;
	}

}
