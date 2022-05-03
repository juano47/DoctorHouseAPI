package com.delaiglesia.doctorhouseapi.aspect;

import com.delaiglesia.doctorhouseapi.services.FeatureFlagService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Aspect
@Component
public class FeatureFlagAspect {

    private FeatureFlagService featureFlagService;

    public FeatureFlagAspect(FeatureFlagService featureFlagService) {
        this.featureFlagService = featureFlagService;
    }

    @Before("execution (* com.delaiglesia.doctorhouseapi..*(..)) && @annotation(checkFeatureFlag)")
    public void checkFeatureFlag(CheckFeatureFlag checkFeatureFlag) {
        String flag = checkFeatureFlag.flag();
        if (!featureFlagService.isFeatureFlagSet(flag)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Feature flag " + flag + " is not enabled");
        }
    }
}
