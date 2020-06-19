
/**
 * Write a description of ImageSaver here.
 * 
 * @author umashankar
 * @version 1.0
 */

import edu.duke.*;
import java.io.*;

public class ImageSaver {
    public void doSave() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            ImageResource image = new ImageResource(f);
            String fileName = image.getFileName();
            String newFileName = "copy-"+fileName;
            image.setFileName(newFileName);
            image.save();
            image.draw();
            
        }
    }

}
