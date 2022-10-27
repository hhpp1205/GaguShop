package kr.ac.kopo.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

public class MultipartBinder {

    public String saveReturnName(MultipartFile multipartFile){

        String fileRealName = multipartFile.getOriginalFilename();
        String filenameExtension = fileRealName.substring(fileRealName.lastIndexOf("."), fileRealName.length());
        String uploadPath = "C:/img\\";

        UUID uuid = UUID.randomUUID();

        String filename = uuid.toString() + filenameExtension;

        try {
            if(multipartFile != null && !multipartFile.isEmpty()){
                multipartFile.transferTo(new File(uploadPath + filename));
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        return filename;
    }
}
