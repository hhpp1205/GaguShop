package kr.ac.kopo.util;

import kr.ac.kopo.model.Attach;
import kr.ac.kopo.model.Gagu;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class MultipartBinder {


    public String saveImgAndReturnName(MultipartFile multipartFile){
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

    public void saveItemSubImg(Gagu item) {

        List<Attach> list = new ArrayList<Attach>();
        if (item.getAttach() != null) {
            for(MultipartFile attach : item.getAttach()){
                if(attach != null && !attach.isEmpty()){
                    Attach attachItem = new Attach();

                    attachItem.setFilename(saveImgAndReturnName(attach));
                    list.add(attachItem);
                }
            }
            item.setAttachs(list);
        }


    }




}
