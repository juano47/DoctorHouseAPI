package com.delaiglesia.doctorhouseapi.aspect;

//@Aspect
//@Component
public class FeatureFlagAspect {

  /*  private FeatureFlagService featureFlagService;

    public FeatureFlagAspect(FeatureFlagService featureFlagService) {
        this.featureFlagService = featureFlagService;
    }

    @Before("execution (* com.delaiglesia.doctorhouseapi..*(..)) && @annotation(checkFeatureFlag)")
    public void checkFeatureFlag(CheckFeatureFlag checkFeatureFlag) {
        String flag = checkFeatureFlag.flag();
        if (!featureFlagService.isFeatureFlagSet(flag)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Feature flag " + flag + " is not enabled");
        }
    }*/
}
