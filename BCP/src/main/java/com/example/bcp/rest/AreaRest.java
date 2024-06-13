package com.example.bcp.rest;

import com.example.bcp.model.Area;
import com.example.bcp.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/area/")
public class AreaRest {

    @Autowired
    private AreaService areaService;

    @GetMapping("/todo")
    public List<Object[]> todoAreas() {
        return areaService.todoAreas();
    }
}
