package com.myentry.MyEntry.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class VisitorResponseBodyDTO {
  
  List<VisitorDTO> visitors;
  private String message;

}
