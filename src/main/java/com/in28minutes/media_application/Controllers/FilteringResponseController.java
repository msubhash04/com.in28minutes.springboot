package com.in28minutes.media_application.Controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.in28minutes.media_application.Entity.FilteringBean;
import com.in28minutes.media_application.Entity.ViewOfFiltering;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringResponseController {

    //Static Filtering of the JSON response... Strats Here...
    @GetMapping("/filtering")
    public FilteringBean filtering(){
        return new FilteringBean("Value1","Value2","Value3");
    }

    @GetMapping("filtering-list")
    public List<FilteringBean> filteringList(){
        return Arrays.asList(new FilteringBean("Value1","Value2","Value3"),
                new FilteringBean("Value4","Value5","Value6"));
    }
    //Static Filtering Ends Here...

    //Dynamic Filtering of the JSON response Starts Here...
    @GetMapping("filtering-with-view")
    @JsonView(ViewOfFiltering.View1.class)
    public FilteringBean filteringWithView(){
        return new FilteringBean("Value1","Value2","Value3");
    }

    @GetMapping("filtering-list-with-view")
    @JsonView(ViewOfFiltering.View2.class)
    public List<FilteringBean> filteringListWithView(){
        return Arrays.asList(new FilteringBean("Value1","Value2","Value3"),
                new FilteringBean("Value4","Value5","Value6"));
    }
    //Dynamic Filtering Ends Here...
}
