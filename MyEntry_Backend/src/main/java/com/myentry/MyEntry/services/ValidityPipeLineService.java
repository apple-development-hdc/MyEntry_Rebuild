package com.myentry.MyEntry.services;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Author :SAURAV ROY
 */
@Service
public class ValidityPipeLineService {

    /**
     * WILL BE USED TO VALIDATE LAPTOP
     * @param status
     * @param enddate
     * @param extendedDate
     * @return
     * @throws ParseException
     */
    public boolean decision(String status, String enddate, String extendedDate) throws ParseException {
        boolean result = false;
        if(status.equals("Approved")){
            result=true;
        }
        else if(status.equals("Expired")){
            result=false;
        }
        else if(status.equals("Pending")){
            System.out.print("Pending");
            SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
            Date today= new Date();
            String parsetoday=formatter.format(today);
            today=formatter.parse(parsetoday);
            try{
                Date EndDate= formatter.parse(enddate);
                System.out.println("len"+extendedDate.length());
                if(today.compareTo(EndDate) >= 0 && extendedDate.length()==0){
                    result=false;
                }
                else if(extendedDate.length()>0){
                    Date Extended_Date= formatter.parse(extendedDate);
                    System.out.print("Extended Date:"+Extended_Date);
                    if(today.compareTo(Extended_Date)>=0){
                        result=false;
                    }
                    else{
                        result=true;
                    }
                }
                else{
                    result=false;
                }
            }
            catch(ParseException e){

                throw new RuntimeException("Parsing Exception=>"+e.getMessage());
            }

        }
        return result;
    }
}