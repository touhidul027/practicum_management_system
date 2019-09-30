package com.packt.webstore.service;

import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;


public interface UserService {
  public abstract int getUserId(String userName);
  public abstract String getViewFolderName(SecurityContextHolderAwareRequestWrapper request);
}
