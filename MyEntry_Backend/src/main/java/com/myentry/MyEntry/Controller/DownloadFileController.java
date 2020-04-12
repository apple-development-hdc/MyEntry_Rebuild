package com.myentry.MyEntry.Controller;

import com.myentry.MyEntry.Services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
/**
 * Author :SAURAV ROY
 */

/**
 *  Model+ View Controller to access the Model and create a @ResponseBody for the
 *  Entity
 */
@Controller
public class DownloadFileController {

    @Autowired
    FileService fileService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/file")
    public ResponseEntity<InputStreamResource> downloadFile() {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=Laptop_Request_Report.xlsx");

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new InputStreamResource(fileService.loadFile()));
    }
}