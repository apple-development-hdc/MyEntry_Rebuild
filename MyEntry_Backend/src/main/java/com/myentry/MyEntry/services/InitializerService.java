package com.myentry.MyEntry.services;

import org.springframework.stereotype.Service;

@Service
public interface InitializerService {

   public void saveAdminRole();

   public void saveUserRole();

   public void setSuperUserCredentials();

}
