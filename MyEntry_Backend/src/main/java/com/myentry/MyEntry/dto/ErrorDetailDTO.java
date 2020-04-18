package com.myentry.MyEntry.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(Include.NON_NULL)
@Getter
@Setter
public class ErrorDetailDTO {

  private Integer status;
  private String errorCode;
  private String errorMessage;
  private String exceptionType;
  private String sourceUUID;
}
