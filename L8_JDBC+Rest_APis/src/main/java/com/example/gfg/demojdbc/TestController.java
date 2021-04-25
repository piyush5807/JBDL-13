package com.example.gfg.demojdbc;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.SQLException;

@RestController
public class TestController {

    // RestTemplate - it is used make Rest API calls

    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping(value = "/image", produces = MediaType.IMAGE_GIF_VALUE)
    public byte[] getImage(@RequestParam("id") int id){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://picsum.photos/id/" + id + "/200/300", byte[].class);
    }

    @Autowired
    BookService bookService;

    @PostMapping(value = "/savedata")
    public void saveCSVData(HttpServletRequest httpServletRequest) throws IOException, ServletException, SQLException {

        Part file = httpServletRequest.getPart("my_file"); // getting a resource
        Part testString = httpServletRequest.getPart("test");

        logger.info("got parts as - {}, {}", file, testString);

        InputStream inputStreamTestString = testString.getInputStream();

        InputStream inputStream = file.getInputStream();

        Reader reader = new InputStreamReader(inputStream);
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

        for(CSVRecord record: csvParser){
            String bookName = record.get(0);
            String author = record.get(1);
            int cost = Integer.parseInt(record.get(2));

            Book book = Book.builder()
                    .cost(cost)
                    .author(author)
                    .name(bookName)
                    .build();

            bookService.insertBook(book);
        }
    }
}
