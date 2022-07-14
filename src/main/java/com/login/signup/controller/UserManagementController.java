package com.login.signup.controller;


import com.login.signup.model.SearchResult;
import com.login.signup.model.Users;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/api/v1")
public class UserManagementController {

    @RequestMapping({ "/hello" })
    public String firstPage() {
        return "Hello World";
    }

    @RequestMapping(value = "/loadpage", method = RequestMethod.POST)
    public ResponseEntity<Users> createAuthenticationToken(@RequestBody Users user) throws Exception {
        System.out.println(user.getEmail());
        Users use = new Users();
        use.setEmail("abc@abc.com");
        use.setFirstName("ABC");
        return new ResponseEntity<Users>(use, HttpStatus.OK);

    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public List<SearchResult> searchResultList(@RequestBody Users user) throws Exception {
        List<SearchResult> results = new ArrayList<>();
        SearchResult result = new SearchResult();
        result.setAssignedTo("Deepak Singh");
        result.setDivision("DCFS");
        result.setId(6000);
        result.setStatus("In Progress");
        result.setSubmittedBy("Angel Brown");
        result.setSubmittedDate("2022-07-07");
        result.setTravelEndDate("2022-07-15");
        result.setTravelStartDate("2022-07-08");

        SearchResult result1 = new SearchResult();
        result1.setAssignedTo("Deepak Singh");
        result1.setDivision("DMS");
        result1.setId(6001);
        result1.setStatus("In Progress");
        result1.setSubmittedBy("Matt Jacob");
        result1.setSubmittedDate("2022-07-08");
        result1.setTravelEndDate("02022-07-16");
        result1.setTravelStartDate("2022-07-09");

        SearchResult result2 = new SearchResult();
        result2.setAssignedTo("Deepak Singh");
        result2.setDivision("DMS");
        result2.setId(6002);
        result2.setStatus("In Progress");
        result2.setSubmittedBy("Jennifer Lopez");
        result2.setSubmittedDate("2022-07-08");
        result2.setTravelEndDate("2022-07-16");
        result2.setTravelStartDate("2022-07-09");

        SearchResult result3 = new SearchResult();
        result3.setAssignedTo("Deepak Singh");
        result3.setDivision("DMS");
        result3.setId(6003);
        result3.setStatus("In Progress");
        result3.setSubmittedBy("Alex Xu");
        result3.setSubmittedDate("2022-07-08");
        result3.setTravelEndDate("2022-07-16");
        result3.setTravelStartDate("2022-07-09");

        SearchResult result4 = new SearchResult();
        result4.setAssignedTo("Deepak Singh");
        result4.setDivision("DMS");
        result4.setId(6004);
        result4.setStatus("In Progress");
        result4.setSubmittedBy("Bobby Brown");
        result4.setSubmittedDate("2022-07-08");
        result4.setTravelEndDate("2022-07-16");
        result4.setTravelStartDate("2022-07-09");

        SearchResult result5 = new SearchResult();
        result5.setAssignedTo("Deepak Singh");
        result5.setDivision("DMS");
        result5.setId(6005);
        result5.setStatus("In Progress");
        result5.setSubmittedBy("Kim Kardashian");
        result5.setSubmittedDate("2022-07-08");
        result5.setTravelEndDate("2022-07-16");
        result5.setTravelStartDate("2022-07-09");

        SearchResult result6 = new SearchResult();
        result6.setAssignedTo("Deepak Singh");
        result6.setDivision("DMS");
        result6.setId(6006);
        result6.setStatus("In Progress");
        result6.setSubmittedBy("Michael Jackson");
        result6.setSubmittedDate("2022-07-08");
        result6.setTravelEndDate("2022-07-16");
        result6.setTravelStartDate("2022-07-09");

        results.add(result);
        results.add(result1);
        results.add(result2);
        results.add(result3);
        results.add(result4);
        results.add(result5);
        results.add(result6);

        return results;

    }
}

