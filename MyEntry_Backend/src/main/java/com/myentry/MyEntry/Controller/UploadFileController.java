package com.myentry.MyEntry.Controller;
import com.myentry.MyEntry.Services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller

/**
 * Author :SAURAV ROY
 */
public class UploadFileController {

    @Autowired
    FileService fileService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/")
    public String index() {
        return "multipartfile/uploadform.html";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/")
    public String uploadMultipartFile(@RequestParam("uploadfile") MultipartFile file, Model model) {
        try {
            fileService.store(file);
            model.addAttribute("message", "File uploaded successfully!");
        } catch (Exception e) {
            model.addAttribute("message", "Fail! -> uploaded filename: " + file.getOriginalFilename());
        }
        return "multipartfile/uploadform.html";
    }
}