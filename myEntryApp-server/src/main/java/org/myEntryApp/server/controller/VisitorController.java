package org.myEntryApp.server.controller;

import org.myEntryApp.server.constants.UrlConstants;
import org.myEntryApp.server.dto.VisitorRequestDTO;
import org.myEntryApp.server.dto.VisitorResponseDTO;
import org.myEntryApp.server.dto.SearchCriteria;
import org.myEntryApp.server.serviceImpl.VisitorServiceImpl;
import org.myEntryApp.server.utils.ApplicationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = UrlConstants.VISITOR_BASE_URL)
public class VisitorController {

  @Autowired
  private VisitorServiceImpl visitorService;

  @GetMapping
  public VisitorResponseDTO getAllVisitors() {
    long startTime = System.currentTimeMillis();
    VisitorResponseDTO visitorResponseDTO = visitorService.getAllVisitors();
    visitorResponseDTO.setResponseHeader(ApplicationUtils.prepareResponseHeader(startTime));
    return visitorResponseDTO;
  }

  @DeleteMapping("/{visitorId}")
  public void deleteVisitor(@PathVariable Long visitorId) {
    visitorService.deleteVisitor(visitorId);
  }


  @PostMapping
  public VisitorResponseDTO saveVisitor(@RequestBody VisitorRequestDTO visitorRequestDTO ) {
    long startTime = System.currentTimeMillis();
    VisitorResponseDTO visitorResponseDTO = visitorService.createVisitor(visitorRequestDTO);
    visitorResponseDTO.setResponseHeader(ApplicationUtils.prepareResponseHeader(startTime));
    return visitorResponseDTO;
  }

  @PostMapping("/search")
  public  VisitorResponseDTO searchVisitor(@RequestBody SearchCriteria searchCriteria) {
    long startTime = System.currentTimeMillis();
    VisitorResponseDTO visitorResponseDTO= visitorService.searchVisitor(searchCriteria);
    visitorResponseDTO.setResponseHeader(ApplicationUtils.prepareResponseHeader(startTime));
    return visitorResponseDTO;
  }
}
