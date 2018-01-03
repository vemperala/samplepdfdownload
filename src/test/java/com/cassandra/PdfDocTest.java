package com.cassandra;

import com.cassandra.model.PdfDoc;
import com.cassandra.repository.PdfDocRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.imageio.IIOException;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * Created by akhilesh on 1/2/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)


@SpringBootTest(classes = BlobpdfApplication.class)

@WebAppConfiguration
public class PdfDocTest {

    @Autowired
    private PdfDocRepo pdfDocRepo;


    private PdfDoc sampleRecord(){

        PdfDoc record= new PdfDoc();


        Path path = Paths.get("/Users/akhilesh/Documents/checkstubs/CheckStub2017.pdf");
        try{


            FileInputStream fis=new FileInputStream("/Users/akhilesh/Documents/checkstubs/CheckStub2017.pdf");
            byte[] b= new byte[fis.available()+1];
            int length=b.length;
            fis.read(b);


            ByteBuffer buffer =ByteBuffer.wrap(b);

            //byte[] pdf = Files.readAllBytes(path);

            record.setId(UUID.randomUUID());
            record.setDocument(buffer);

        }catch (IOException e){
            e.printStackTrace();
        }

        return record;
    }

    @Test
    public void repositoryCrudOperations() {
        PdfDoc sample = sampleRecord();
        this.pdfDocRepo.save(sample);
        PdfDoc saveddoc = this.pdfDocRepo.findOne(sample.getId());
        //assertThat(saveddoc.getId(), equalTo(sample.getId()));
        //this.pdfDocRepo.delete(s);
    }

}
