package com.tubes_dpbo_cafe.cafe.interfaces;

public interface ITea {
    String getLeafOrigin();
    void setLeafOrigin(String leafOrigin);

    boolean isHerbal();
    void setHerbal(boolean isHerbal);

    String getBrewMethod();
    void setBrewMethod(String brewMethod);
}
