package com.myentry.MyEntry.DTO;

import com.myentry.MyEntry.Interfaces.EmployeeImageInterface;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;

public class EmployeeDetails {
    private static final long serialVersionUID = 1L;
    private String employeeID;
    private Locations employeeLocation;
}
