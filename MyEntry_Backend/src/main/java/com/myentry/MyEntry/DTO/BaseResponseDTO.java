package com.myentry.MyEntry.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class BaseResponseDTO<T> {
  private ResponseHeaderDTO responseHeader;

  private T responseBody;
}
