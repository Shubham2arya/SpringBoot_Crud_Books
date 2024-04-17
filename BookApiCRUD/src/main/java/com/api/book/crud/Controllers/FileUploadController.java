package com.api.book.crud.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.book.crud.hepler.FileUploadHelper;

@RestController
public class FileUploadController {
	
	@Autowired
	private FileUploadHelper fileUploadHelper;
	
	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file")MultipartFile file){
		
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getName());
//		System.out.println(file.getSize());
//		System.out.println(file.getContentType());
		
		try {
			//validation
			if(file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain a file");
			}
			//allowing only jpej file
			if(!file.getContentType().equals("image/jpeg")) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File must be in jpeg format");
			}
			
			// file uploading code
			boolean b=fileUploadHelper.uploadFile(file);
			if(b) {
				return ResponseEntity.ok("File is seccessfully uploaded");
				
				//uploading file dinamically so that on changing system ni error occure due to no such image folder
				//return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images").path(file.getOriginalFilename()).toUriString());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong..Try again");
	}
}
