package com.api.book.crud.hepler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadHelper {
	
	public final String UPLOAD_DIR="C:\\Users\\Shubham Arya\\Documents\\workspace-spring-tool-suite-4-4.20.1.RELEASE\\BookApiCRUD\\src\\main\\resources\\static\\images";
	
	//uploading file dinamically so that on changing system ni error occure due to no such image folder
//	public final String UPLOAD_DIR=new ClassPathResource("static/image/").getFile().getAbsolutePath();
//	public FileUploadHelper()throws IOException{
//		
//	}
	
	public boolean uploadFile(MultipartFile multipartFile) {
		boolean f=false;
		try {
//			InputStream is=multipartFile.getInputStream();
//			byte data[]=new byte[is.available()]; //gives the array of uploaded file size
//			is.read(data);
//			
//			//writing (uploading file in folder)
//			FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename());// we can also use +//+ on the place of File.Separator
//			fos.write(data);
//			
//			fos.flush();
//			fos.close();
//			
//			  -------------// OR //-------------
			
			Files.copy(multipartFile.getInputStream(),Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
			
			f=true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}
