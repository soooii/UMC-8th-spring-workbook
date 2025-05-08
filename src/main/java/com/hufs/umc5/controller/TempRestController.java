package com.hufs.umc5.controller;

import com.hufs.umc5.apiPayload.ApiResponse;
import com.hufs.umc5.converter.TempConverter;
import com.hufs.umc5.dto.TempResponse;

import com.hufs.umc5.service.TempService.TempQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempRestController {

    private final TempQueryService tempQueryService;

    @GetMapping("/test")
    public ApiResponse<TempResponse.TempTestDTO> testAPI(){

        //return ApiResponse.onSuccess(TempConverter.toTempTestDTO(), Code.OK);
        //?? OK 지우기
        return ApiResponse.onSuccess(TempConverter.toTempTestDTO());

    }


    @GetMapping("/exception")
    public ApiResponse<TempResponse.TempExceptionDTO> exceptionAPI(@RequestParam Integer flag){
        tempQueryService.CheckFlag(flag);
        return ApiResponse.onSuccess(TempConverter.toTempExceptionDTO(flag));
    }
}