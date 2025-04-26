package com.kush.replaceme.controller;

import com.kush.replaceme.controller.dto.request.CreateReplaceMeDto;
import com.kush.replaceme.controller.dto.response.GetReplaceMeDto;
import com.kush.replaceme.service.ReplaceMeService;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/me")
public class ReplaceMeController {

    private final ReplaceMeService replaceMeService;

    public ReplaceMeController(ReplaceMeService replaceMeService) {
        this.replaceMeService = replaceMeService;
    }

    @PostMapping
    public ResponseEntity<GetReplaceMeDto> createReplaceMe(@Valid @RequestBody CreateReplaceMeDto createReplaceMeDto) {
        return ResponseEntity.ok(replaceMeService.createReplaceMe(createReplaceMeDto));
    }

    @GetMapping("{id}")
    public ResponseEntity<GetReplaceMeDto> createReplaceMe(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(replaceMeService.findReplaceMeById(id));
    }
}
