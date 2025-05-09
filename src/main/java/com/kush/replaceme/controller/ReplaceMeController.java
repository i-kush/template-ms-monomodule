package com.kush.replaceme.controller;

import com.kush.replaceme.dto.request.CreateReplaceMeDto;
import com.kush.replaceme.dto.response.GetReplaceMeDto;
import com.kush.replaceme.service.ReplaceMeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/me")
@RequiredArgsConstructor
public class ReplaceMeController {

    private final ReplaceMeService replaceMeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GetReplaceMeDto createReplaceMe(@Valid @RequestBody CreateReplaceMeDto createReplaceMeDto) {
        return replaceMeService.createReplaceMe(createReplaceMeDto);
    }

    @GetMapping("{id}")
    public GetReplaceMeDto createReplaceMe(@PathVariable(name = "id") long id) {
        return replaceMeService.findReplaceMeById(id);
    }
}
