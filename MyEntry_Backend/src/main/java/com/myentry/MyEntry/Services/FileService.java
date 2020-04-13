package com.myentry.MyEntry.Services;

import com.myentry.MyEntry.Domain.LaptopRequest;
import com.myentry.MyEntry.Repository.LaptopRequestRepository;
import com.myentry.MyEntry.Utils.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
/**
 * Author :SAURAV ROY
 */
@Service
public class FileService{

    @Autowired
    LaptopRequestRepository laptopRequestRepository;

    /**
     *   Store File Data to Database
      */
    public void store(MultipartFile file){

        try {
            List<LaptopRequest> lstCustomers = ExcelUtils.parseExcelFile(file.getInputStream());
            // Save requestData to DataBase
            for(LaptopRequest laptopRequests : lstCustomers){
                System.out.print(laptopRequests);
            }
            laptopRequestRepository.saveAll(lstCustomers);
        } catch (IOException e) {
            throw new RuntimeException("FAIL! -> message = " + e.getMessage());
        }
    }

    /**
     * Load Data to Excel File
     * @return ByteArrayInputStream
     */
    public ByteArrayInputStream loadFile() {
        List<LaptopRequest> laptopRequestList = (List<LaptopRequest>) laptopRequestRepository.findAll();

        try {
            ByteArrayInputStream in = ExcelUtils.LaptopRequestToExcel(laptopRequestList);
            return in;
        } catch (IOException e) {}

        return null;
    }
}