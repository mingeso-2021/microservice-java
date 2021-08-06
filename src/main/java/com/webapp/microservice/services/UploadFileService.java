package com.webapp.microservice.services;

import com.webapp.microservice.repositories.UploadFiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/uploadfiles")
public class UploadFileService {


    @Autowired
    private UploadFiles uploadFiles;

    @PostMapping(value="/upload")
    public ResponseEntity<String> uploadFiles(@RequestParam("file") List<MultipartFile> files){
        try {
            uploadFiles.save(files);
            return ResponseEntity.status(HttpStatus.OK).body("Los archivos fueron cargados correctamente al servidor");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El/los archivo/s ya existe/n");
        }
    }

    @GetMapping(value="/files/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String fileName) throws Exception {
        Resource resource = uploadFiles.load(fileName);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attchment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @GetMapping(value = "/getall")
    public ResponseEntity<List<File>> getAllFiles() throws Exception {
        List<File> files = uploadFiles.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder.fromMethodName(UploadFileService.class, "getFile", path.getFileName().toString()).build().toString();
            return new File(filename, url);
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @PostMapping(value = "/file", consumes = {"multipart/form-data"})
    public ResponseEntity<String> uploadFile(@RequestParam("files") MultipartFile file, RedirectAttributes attributes) throws IOException {
        try{
            if (file == null || file.isEmpty()) {
                attributes.addFlashAttribute("message", "Por favor seleccione un archivo");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Algo ocurrió mal 2");
            }
            StringBuilder builder = new StringBuilder();
            builder.append(System.getProperty("user.home"));
            builder.append(File.separator);
            builder.append("uploaded-files");
            builder.append(File.separator);
            builder.append(file.getOriginalFilename());

            byte[] fileBytes = file.getBytes();
            Path path = Paths.get(builder.toString());
            Files.write(path, fileBytes);

            attributes.addFlashAttribute("message", "Archivo cargado correctamente");
            return ResponseEntity.status(HttpStatus.OK).body("OK");
        }catch ( Exception e ) {
            System.err.println( e ); // capturar error server-side
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Algo ocurrió mal 3");
        }
    }
}
