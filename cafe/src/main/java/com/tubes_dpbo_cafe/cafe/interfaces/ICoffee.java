package com.tubes_dpbo_cafe.cafe.interfaces;

public interface ICoffee {
    String getBeanOrigin();
    void setBeanOrigin(String beanOrigin);

    String getBeanType();
    void setBeanType(String beanType);

    String getRoastLevel();
    void setRoastLevel(String roastLevel);

    int getStrongLevel();
    void setStrongLevel(int strongLevel);

    String getBrewMethod();
    void setBrewMethod(String brewMethod);
}
