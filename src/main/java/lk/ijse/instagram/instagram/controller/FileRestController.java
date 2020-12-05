package lk.ijse.instagram.instagram.controller;


import lk.ijse.instagram.instagram.dto.FileWriterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("api/file")
@CrossOrigin(origins = "*")
public class FileRestController {
        @Autowired
        private FileWriter fileWriter;

        @PostMapping
        public ResponseEntity<FileWriterDto> at(@RequestParam(value = "document", required = false) MultipartFile file) throws IOException {

            String fName = new Date().getTime() + "_" + file.getOriginalFilename();

            fileWriter.write(fName , file.getBytes());

            return ResponseEntity.status(201).body(new FileWriterDto( "api/file/" + fName));
        }


        @GetMapping("/{name:.+}")
        public ResponseEntity<Resource> read(@PathVariable(value = "name" ) String name) throws IOException {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");
            headers.set(HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename="+name);

            byte[] fileBytes = fileWriter.read(name);

            ByteArrayResource resource = new ByteArrayResource(fileBytes);

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(fileBytes.length)
                    .contentType(MediaType.parseMediaType("application/octet-stream"))
                    .body(resource);

        }



    }




