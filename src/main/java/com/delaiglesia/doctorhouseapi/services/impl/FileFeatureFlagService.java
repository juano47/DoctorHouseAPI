package com.delaiglesia.doctorhouseapi.services.impl;

import com.delaiglesia.doctorhouseapi.services.FeatureFlagService;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Service
public class FileFeatureFlagService implements FeatureFlagService {

    private Properties properties;

    public FileFeatureFlagService() throws IOException {
        properties = new Properties();
        File file = ResourceUtils.getFile("classpath:featuresFlags.properties");
        InputStream stream = new FileInputStream(file);
        properties.load(stream);
    }

    @Override
    public boolean isFeatureFlagSet(String flag) {
        return Boolean.valueOf(properties.getProperty(flag));
    }
}
