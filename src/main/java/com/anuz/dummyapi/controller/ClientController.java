/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anuz.dummyapi.controller;

import com.anuz.dummyapi.constants.CONSTANTS;
import com.anuz.dummyapi.service.ContentService;
import com.anuz.dummyapi.service.ContentUpdateService;
import com.anuz.dummyapi.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.anuz.dummyapi.entity.Client;
import com.anuz.dummyapi.entity.Content;
import com.anuz.dummyapi.entity.ContentUpdateStatus;
import com.anuz.dummyapi.util.ZipUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;

/**
 *
 * @author anuz
 */
@RestController
@RequestMapping(value = "/api/v1/users")
public class ClientController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ClientService clientService;
    @Autowired
    private ContentUpdateService contentUpdateService;
    @Autowired
    private ContentService contentService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Client> allClients() {
        logger.info("Retreive all Users");
        logger.debug("show this");
        return clientService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Client findOne(@PathVariable("id") int id) {
        return clientService.getById(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public int create(@RequestBody Client client) {
        return clientService.saveOrUpdate(client);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public ResponseEntity delete(@PathVariable("id") int id) {
        clientService.delete(id);
        return ResponseEntity.ok(id);
    }

    @RequestMapping(value = "update_content/{id}", method = RequestMethod.GET)
    public ModelMap updateContent(@PathVariable("id") int clientId) {
        ModelMap map = new ModelMap();
        ContentUpdateStatus contentUpdate = contentUpdateService.getContentStatusById(clientId);
        if (!contentUpdate.getStatus()) {
            map.addAttribute("contentUpdate", contentService.getById(contentUpdate.getContentId().getContentId()));

            contentUpdate.setStatus(true);
            contentUpdateService.saveOrUpdate(contentUpdate);
            logger.info("Client" + contentUpdate.getClientId() + " content Synchronized ");

        }
        System.out.println(contentService.getById(1));
        return map;
    }

    @RequestMapping(value = "/download_content_data/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public FileSystemResource getFiles(@PathVariable("id") int id, HttpServletResponse response) throws FileNotFoundException {

        String fileName = "content" + id + ".zip";
//        
//        byte[] buffer = new byte[1024];
//        FileOutputStream fos = new FileOutputStream(CONSTANTS.CONTENTS+fileName);
//        ZipOutputStream zos=new ZipOutputStream(fos);
//        
//        ZipEntry ze= new ZipEntry("spy.log");

        return new FileSystemResource(CONSTANTS.CONTENTS + fileName);
    }

    @RequestMapping(value = "/contents_file/{id}", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> downloadFiles(@PathVariable("id") int id) throws IOException {

        List<Content> contentList = contentUpdateService.getUnsynchronizedContentList(id);
//        logger.info("check");
        if (!contentList.isEmpty()) {
            String fileName = "zipFile" + new Date().getTime()+".zip";
            ZipUtil zipFile = new ZipUtil();
            for (Content content : contentList) {
                zipFile.generateFileList(new File(CONSTANTS.CONTENTS + content.getContentLocation()));
            }
            String finalZip = zipFile.zipIt(CONSTANTS.CONTENTS + fileName   );
            System.out.println("check filename");
            System.out.println(finalZip);
            FileSystemResource file = new FileSystemResource(finalZip);
         
            return ResponseEntity.ok().contentLength(file.contentLength())
                    .contentType(MediaType.parseMediaType("application/zip"))
                    .header("Content-Disposition", "attachment; filename=" + fileName)
                    .body(new InputStreamResource(file.getInputStream()));

        }
        return ResponseEntity.ok().body(null);
        
    }

    @RequestMapping(value = "/content_status/{userId}", method = RequestMethod.GET)
    public ModelMap contentUpdate(@PathVariable("userId") int userId) {

        ModelMap map = new ModelMap();

        map.addAttribute("status", contentUpdateService.getContentStatusById(userId).getStatus());
        return map;

    }

    @RequestMapping(value = "/test/{userId}", method = RequestMethod.GET)
    public ModelMap check(@PathVariable("userId") int userId) {

        ModelMap map = new ModelMap();

        map.addAttribute("test", contentUpdateService.getUnsynchronizedContentList(userId));
        return map;

    }

//    @RequestMapping(value = "/get_content_updates/{userId}", method = RequestMethod.GET)
//    public ModelMap getContentUpdates(@PathVariable("userId") int userId) {
//
//        ModelMap map = new ModelMap();
//        map.addAttribute("updates",contentService.getUpdates(userId) );
//       
////        UserContent userContent=userContentService.getContentStatusById(userId);
//
////        map.addAttribute("status", userService.contentUpdateStatus(userId));
//        return map;
//
//    }
//    @RequestMapping(value = "byEmail", method = RequestMethod.GET)
//    public User delete() {
//        return userService.userByEmail("anuj.maharjan@gmail.com");
//        
//        
//    }
//    
}
