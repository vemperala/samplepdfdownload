package com.cassandra.controller;

import com.cassandra.service.PdfDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by akhilesh on 1/3/18.
 */
@RestController
@RequestMapping("/pdfdoc")
public class PdfDocController {

    @Autowired
    private PdfDocService pdfDocService;

    @RequestMapping("/")
    public void downloadFile(HttpServletResponse response){
        pdfDocService.downloadPdf(response);
    }
}
