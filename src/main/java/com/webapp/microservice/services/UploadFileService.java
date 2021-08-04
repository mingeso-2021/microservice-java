package com.webapp.microservice.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.google.gson.Gson;



@CrossOrigin
@RestController
@RequestMapping(value = "/upload")
public class UploadFileService {

    private final Gson gson;

    public UploadFileService(Gson gson) {
        this.gson = gson;
    }

    @GetMapping(value="/")
    public String index(){
        return "file";
    }

    @PostMapping(value = "/file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes attributes) throws IOException {
        try{
            if (file == null || file.isEmpty()) {
                attributes.addFlashAttribute("message", "Por favor seleccione un archivo");
                return new ResponseEntity<>( gson.toJson("Algo ocurrio mal :("), HttpStatus.BAD_REQUEST );
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
            return new ResponseEntity<>(gson.toJson(builder), HttpStatus.OK);
        }catch ( Exception e ) {
            System.err.println( e ); // capturar error server-side
            return new ResponseEntity<>( gson.toJson("Algo ocurrio mal :("), HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping(value = "/status")
    public String status(){
        return "status";
    }
}
