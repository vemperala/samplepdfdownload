package com.cassandra.service;

import com.cassandra.model.PdfDoc;
import com.cassandra.repository.PdfDocRepo;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import sun.misc.IOUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by akhilesh on 1/3/18.
 */

@Service
public class PdfDocService {

    @Autowired
    private PdfDocRepo pdfDocRepo;


    public void downloadPdf(HttpServletResponse response){

        List<PdfDoc> pdfDoc = (List)pdfDocRepo.findAll();

        pdfDoc.stream().forEach(e -> {
            try{
                InputStream is = new ByteArrayInputStream(e.getDocument().array());

                StreamUtils.copy(is, response.getOutputStream());

                response.flushBuffer();
                response.setContentType("application/pdf");
            }catch (IOException ex ){
                ex.printStackTrace();
            }
        });
    }
}
