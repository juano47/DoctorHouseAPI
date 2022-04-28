package com.delaiglesia.doctorhouseapi.aspect;

import com.delaiglesia.doctorhouseapi.exceptions.FeatureNotEnabledException;
import com.delaiglesia.doctorhouseapi.services.FeatureFlagService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FeatureFlagAspect {

    private FeatureFlagService featureFlagService;

    public FeatureFlagAspect(FeatureFlagService featureFlagService) {
        this.featureFlagService = featureFlagService;
    }

    @Before("execution (* com.delaiglesia.doctorhouseapi..*(..)) && @annotation(checkFeatureFlag)")
    public void checkFeatureFlag(JoinPoint joinPoint, CheckFeatureFlag checkFeatureFlag) {
        String flag = checkFeatureFlag.flag();
        if (!featureFlagService.isFeatureFlagSet(flag)) {
            throw new FeatureNotEnabledException();
        }
    }
}
