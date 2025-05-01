package com.kush.replaceme.service;

import com.kush.replaceme.BaseIntegrationTest;
import com.kush.replaceme.dto.request.CreateReplaceMeDto;
import com.kush.replaceme.dto.response.GetReplaceMeDto;
import com.kush.replaceme.exception.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

class ReplaceMeServiceIntegrationTest extends BaseIntegrationTest {

    @Autowired
    private ReplaceMeService replaceMeService;

    @Test
    void whenReplaceMeIsNotNotFoundByIdThenErrorShouldBeThrown() {
        Assertions.assertThrows(
                NotFoundException.class,
                () -> replaceMeService.findReplaceMeById(1),
                "When no info in DB then exception should be thrown"
        );
    }

    @Test
    void whenPresentEntityRequestedByIdThenItShouldBeReturned() {
        CreateReplaceMeDto createReplaceMeDto = new CreateReplaceMeDto("test");
        GetReplaceMeDto createdReplaceMe = replaceMeService.createReplaceMe(createReplaceMeDto);

        GetReplaceMeDto foundByIdReplaceMe = Assertions.assertDoesNotThrow(
                () -> replaceMeService.findReplaceMeById(createdReplaceMe.id()),
                "No exceptions on finding should appear"
        );
        Assertions.assertEquals(createdReplaceMe, foundByIdReplaceMe, "Created and found entities are not the same");
    }
}
