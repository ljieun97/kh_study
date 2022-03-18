package com.example.bank.controller.vue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/file")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class VueFileUploadController {

    @ResponseBody
    @PostMapping("/uploadImg")
    public String requestUploadFile (@RequestParam("fileList") List<MultipartFile> fileList) {
        try {
            for (MultipartFile multipartFile: fileList) {
                log.info("requestUploadFile() - Make file:" + multipartFile.getOriginalFilename());

                FileOutputStream writer = new FileOutputStream(
                        "./images/" + multipartFile.getOriginalFilename()
                );
                writer.write(multipartFile.getBytes());
                writer.close();
            }
        } catch (Exception e) {
            return "Upload Fail!";
        }

        log.info("requestUploadFile(): Success!!!");

        return "Upload Success!";
    }
}
