package by.den.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


@Service
public class FileSaveService {

    private static final Logger logger = Logger.getLogger(FileSaveService.class);

    private boolean save = false;

    @Autowired
    private Environment environment;

    public Boolean saveFile (MultipartFile file, Long id){
        if(!file.isEmpty()){
            String fileName = id + ".jpg";
            try {
                BufferedOutputStream outputStream = new BufferedOutputStream(
                        new FileOutputStream(new File(environment.getProperty("files.path.news"), fileName)));
                        outputStream.write(file.getBytes());
                return save=true;
            }catch (IOException e){
                logger.error("IOException in FileSaveService "+e);
                return save;
            }
        }else {
            return save;
        }
    }
}
