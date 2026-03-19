package com.in28minutes.media_application.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

//@JsonIgnoreProperties({"field1","field2"})
public class FilteringBean {

    @JsonView(ViewOfFiltering.View1.class)
    private String field1;
    @JsonView(ViewOfFiltering.View2.class)
    private String field2;
//    @JsonIgnore
    @JsonView({ViewOfFiltering.View1.class,ViewOfFiltering.View2.class})
    private String field3;

    public FilteringBean(String field1, String field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    public String getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }

    public String getField3() {
        return field3;
    }

    @Override
    public String toString() {
        return "FilteringBean{" +
                "field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", field3='" + field3 + '\'' +
                '}';
    }
}
