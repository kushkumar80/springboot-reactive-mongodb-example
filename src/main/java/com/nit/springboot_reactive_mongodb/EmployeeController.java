package com.nit.springboot_reactive_mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepository eerpo;

    @RequestMapping("/testone")
    public String test(){
        return "This is the reactive Programming ";
    }
    @PostMapping("/save")
    public Mono<Employee> save(@RequestBody Employee employee){

       // Mono<String> m=Mono.just("Data will be saved");
        return eerpo.save(employee);

       // return Mono.just("Data will be saved");

    }
    @GetMapping("/alldata")
    public Flux<Employee>all(){
        return eerpo.findAll();
    }
    @GetMapping("by/{name}")
    public Flux<Employee>findByname(@PathVariable String name){
        return eerpo.findByName(name);
    }

}
