package com.myentry.MyEntry.dto;

import lombok.Data;
@Data
public class BaseRequestDTO<T> {

private RequestHeaderDTO requestHeader;

private T requestBody;
}
