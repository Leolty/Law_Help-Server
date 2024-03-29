package tech.linjuliwhu.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

public class Util {

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static String getUniqueId(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString().toUpperCase();
    }

    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    public static String getFileTypePostFix(String filename){
        return filename.substring(filename.indexOf("."));
    }

}
