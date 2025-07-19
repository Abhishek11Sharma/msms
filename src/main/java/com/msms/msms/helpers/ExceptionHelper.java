package com.msms.msms.helpers;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExceptionHelper {

    public void sendExceptionEmail(Exception e) {
        log.error("Sending Error Email");
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        String fullStackTrace = sw.toString();
    }
}
