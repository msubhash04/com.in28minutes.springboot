package com.in28minutes.media_application.Controllers;

import com.in28minutes.media_application.Entity.NameEntity;
import com.in28minutes.media_application.Entity.PersonV1;
import com.in28minutes.media_application.Entity.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionPersonController {

    @GetMapping("/v1/person")
    public PersonV1 personV1()
    {
         return new PersonV1("Bob Charlie");
    }

    @GetMapping("v2/person")
    public PersonV2 personV2(){
        return new PersonV2(new NameEntity("Mark"," Charlie"));
    }
}
