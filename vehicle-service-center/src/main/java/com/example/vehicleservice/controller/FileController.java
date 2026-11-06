package com.example.vehicleservice.controller;
import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import org.springframework.web.multipart.MultipartFile; import java.io.*; import java.nio.file.*;
@RestController @RequestMapping("/api/files") public class FileController {
 private final Path root=Paths.get("uploads");
 @PostMapping("/upload") public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file)throws IOException{if(file.isEmpty())return ResponseEntity.badRequest().body("File is empty");Files.createDirectories(root);String name=Path.of(file.getOriginalFilename()==null?"upload.bin":file.getOriginalFilename()).getFileName().toString();Files.copy(file.getInputStream(),root.resolve(name),StandardCopyOption.REPLACE_EXISTING);return ResponseEntity.ok(java.util.Map.of("fileName",name,"message","Uploaded successfully"));}
 @GetMapping("/{name}") public ResponseEntity<byte[]> download(@PathVariable String name)throws IOException{Path file=root.resolve(Path.of(name).getFileName().toString());if(!Files.exists(file))return ResponseEntity.notFound().build();return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM).header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=""+file.getFileName()+""").body(Files.readAllBytes(file));}
}
