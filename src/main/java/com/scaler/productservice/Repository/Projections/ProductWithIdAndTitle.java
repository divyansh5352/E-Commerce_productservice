package com.scaler.productservice.Repository.Projections;

public interface ProductWithIdAndTitle {
    Long getId();
    String getTitle();
    //it can have getter of other attributes also , but if we don't populate it then they will remain null
    String getDescription();
}
