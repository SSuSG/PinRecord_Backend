package com.ssafy.enjoytrip.global.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.enjoytrip.domain.travel.dto.request.WriteTravelImageRequestDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ImageService {
	// 루트 경로 불러오기
//	private final String rootPath = System.getProperty("user.dir");
	private final String rootPath = "c:\\SSAFY";
    // 프로젝트 루트 경로에 있는 files 디렉토리
    private final String fileDir = rootPath + "\\upload\\";
    
    public String getFullPath(String filename) { return fileDir + filename; }

    public String storeFile(MultipartFile multipartFile) throws IOException {

        if(multipartFile.isEmpty()) {
            return null;
        }
        File folder = new File(fileDir);
        if (!folder.exists()) 
            folder.mkdirs();
        
        String originalFilename = multipartFile.getOriginalFilename();
        // 작성자가 업로드한 파일명 -> 서버 내부에서 관리하는 파일명
        // 파일명을 중복되지 않게끔 UUID로 정하고 ".확장자"는 그대로
        String storeFilename = UUID.randomUUID() + "." + extractExt(originalFilename);

        // 파일을 저장하는 부분 -> 파일경로 + storeFilename 에 저장
        String fullPath = getFullPath(storeFilename);
//        log.info("rootPath : {}",rootPath);
//        log.info("fileDir : {}",fileDir);
        log.info("Full Path : {}",fullPath);
        
        multipartFile.transferTo(new File(fullPath));

        return fullPath;
    }
    
    public String storeFileForBase64(WriteTravelImageRequestDto writeTravelImageRequestDto) throws IOException {
    	
        if(writeTravelImageRequestDto.getImage().isEmpty()) {
            return null;
        }
        byte[] imageBytes = Base64.getDecoder().decode(writeTravelImageRequestDto.getImage());
        
        File folder = new File(fileDir);
        if (!folder.exists()) 
            folder.mkdirs();
        
        String originalFilename = writeTravelImageRequestDto.getUploadName();
        // 작성자가 업로드한 파일명 -> 서버 내부에서 관리하는 파일명
        // 파일명을 중복되지 않게끔 UUID로 정하고 ".확장자"는 그대로
        String storeFilename = UUID.randomUUID() + "." + extractExt(originalFilename);

        // 파일을 저장하는 부분 -> 파일경로 + storeFilename 에 저장
        String fullPath = getFullPath(storeFilename);
        log.info("Full Path : {}",fullPath);

//        FileOutputStream fos = new FileOutputStream(fullPath);
//        fos.write(imageBytes);
        
    	BASE64DecodedMultipartFile multilpartFile = new BASE64DecodedMultipartFile(imageBytes);
        multilpartFile.transferTo(new File(fullPath));
        


        return fullPath;
    }
    
    // 확장자 추출
    private String extractExt(String originalFilename) {
        int pos = originalFilename.lastIndexOf(".");
        return originalFilename.substring(pos + 1);
    }
    
    public class BASE64DecodedMultipartFile implements MultipartFile {
        private final byte[] imgContent;
        

        public BASE64DecodedMultipartFile(byte[] imgContent) {
            this.imgContent = imgContent;
        }

        @Override
        public String getName() {
            // TODO - implementation depends on your requirements 
            return null;
        }

        @Override
        public String getOriginalFilename() {
            // TODO - implementation depends on your requirements
            return null;
        }

        @Override
        public String getContentType() {
            // TODO - implementation depends on your requirements
            return null;
        }

        @Override
        public boolean isEmpty() {
            return imgContent == null || imgContent.length == 0;
        }

        @Override
        public long getSize() {
            return imgContent.length;
        }

        @Override
        public byte[] getBytes() throws IOException {
            return imgContent;
        }

        @Override
        public InputStream getInputStream() throws IOException {
            return new ByteArrayInputStream(imgContent);
        }

        @Override
        public void transferTo(File dest) throws IOException, IllegalStateException { 
            new FileOutputStream(dest).write(imgContent);
        }
    }
}
