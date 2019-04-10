package by.den.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class FileDeleteService {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    private Long id;
    private File path;

    public void deleteFile(File path, long id){
        this.path = path;
        this.id = id;
        File[] pathList = path.listFiles();
        if (pathList != null) {
            for (File file : pathList) {
                String fileFound = id+".jpg";
                if (file.getName().equals(fileFound)){
                    File pathPics = new File(path+"//"+id+".jpg");
                    boolean del = pathPics.delete();
                    if (del) {
                        logger.info(" / Pics deleted!");
                    }else {
                        logger.info(" / Pics was not delete !!!");
                    }
                }
            }
        }
    }
}
