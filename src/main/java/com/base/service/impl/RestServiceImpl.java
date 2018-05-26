package com.base.service.impl;

import com.base.service.RestService;
import org.springframework.stereotype.Service;

@Service
public class RestServiceImpl implements RestService {

    @Override
    public String getStatus() {
        return "Test Success!";
    }
}
