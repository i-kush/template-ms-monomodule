package com.kush.replaceme.service;

import com.kush.replaceme.BaseTest;
import com.kush.replaceme.exception.NotFoundException;
import com.kush.replaceme.repository.ReplaceMeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Optional;

class ReplaceMeServiceTest extends BaseTest {

    @InjectMocks
    private ReplaceMeService replaceMeService;

    @Mock
    private ReplaceMeRepository replaceMeRepository;

    @Test
    void whenReplaceMeIsNotNotFoundByIdThenErrorShouldBeThrown() {
        Mockito.when(replaceMeRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.empty());

        Assertions.assertThrows(
                NotFoundException.class,
                () -> replaceMeService.findReplaceMeById(1),
                "When no info in DB then exception should be thrown"
        );
    }

}
