package lk.ijse.instagram.instagram.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class FileWriter {

    @Value("opt/dramatv/document")
    private String documentPath;


    public void write(String fileName, byte[] bytes) throws IOException {
        File dir = new File(documentPath);
        if (!dir.exists()) {
            dir.mkdir();
        }

        File serverFile = new File(dir.getAbsolutePath()
                + File.separator + fileName);
        BufferedOutputStream stream = new BufferedOutputStream(
                new FileOutputStream(serverFile));
        stream.write(bytes);
        stream.close();

    }

    public byte[] read(String fileName) throws IOException {
        File file = new File(documentPath + File.separator + fileName);

        Path pathF = Paths.get(file.getAbsolutePath());

        return Files.readAllBytes(pathF);
    }

}
