package com.jxj.user.openapi;

import com.jxj.user.openapi.dto.ResultDTO;

public interface OpenUserService {
    ResultDTO getUser(Long id);
}
