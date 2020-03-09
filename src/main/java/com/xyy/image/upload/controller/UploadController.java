package com.xyy.image.upload.controller;

import com.xyy.image.upload.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
public class UploadController {
    @RequestMapping("/contract")
    public String contract(){
        return "contract";
    }

    @RequestMapping(value = "/uploadImage")
    @ResponseBody
    public void uploadImage(MultipartFile[] blobs, Person person) {
        System.out.println("file->" + blobs);
        int i = 0 ;
        for(MultipartFile blob : blobs){
//            String fileName = blob.getOriginalFilename() + ".png";
            String fileName = ++ i + ".png";
            StringBuilder stringBuilder = new StringBuilder();
            File fileDir = new File("d:/tmp/");
            String path = fileDir.getAbsolutePath();
            if(!fileDir.exists()){
                fileDir.mkdir();
            }
            try {
                blob.transferTo(new File(path, fileName));
                System.out.println("url->" + stringBuilder.append(path).append( java.io.File.separator ).append(fileName).toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
