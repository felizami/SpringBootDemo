/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anuz.dummyapi.util;

import com.anuz.dummyapi.constants.CONSTANTS;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author anuz
 */
public class ZipUtil {

    List<String> fileList;

    public  ZipUtil() {
        fileList = new ArrayList<>();
    }

    
    
    
    public String zipIt(String zipFileName){
         byte[] buffer = new byte[1024];

     try{

    	    FileOutputStream fos = new FileOutputStream(zipFileName);
    	    ZipOutputStream zos = new ZipOutputStream(fos);

    	System.out.println("Output to Zip : " + zipFileName);

    	for(String file : this.fileList){

    		System.out.println("File Added : " + file);
    		      ZipEntry ze= new ZipEntry(file);
        	zos.putNextEntry(ze);

        	   FileInputStream in =new FileInputStream(CONSTANTS.CONTENTS + File.separator + file);

        	int len;
        	while ((len = in.read(buffer)) > 0) {
        		zos.write(buffer, 0, len);
        	}

        	in.close();
    	}

    	zos.closeEntry();
    	//remember close it
    	zos.close();

    	System.out.println("Done");
    }catch(IOException ex){
       ex.printStackTrace();
    }
            
     return zipFileName;
    }
    
    
    public void generateFileList(File node) {
        if (node.isFile()) {
            fileList.add(generateZipEntry(node.getAbsoluteFile().toString()));
        }

        if (node.isDirectory()) {
            String[] subNote = node.list();
            for (String filename : subNote) {
                generateFileList(new File(node, filename));
            }
        }

    }

    private String generateZipEntry(String file) {
        return file.substring(CONSTANTS.CONTENTS.length(), file.length());
    }

}
