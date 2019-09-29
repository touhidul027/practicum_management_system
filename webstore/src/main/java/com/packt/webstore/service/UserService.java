package com.packt.webstore.service;

import java.util.Map;

import com.packt.webstore.dto.NoticeDTO;

public interface UserService {
  public abstract int getUserId(String userName);
}
