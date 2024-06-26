package com.caveofprogramming.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;



@Service
public class AWSS3ServiceImpl implements AWSS3Service {

	private static final Logger LOGGER = LoggerFactory.getLogger(AWSS3ServiceImpl.class);

	@Autowired
	private AmazonS3 amazonS3;
	@Value("${aws.s3.bucket}")
	private String bucketName;
	
	

	@Override
	// @Async annotation ensures that the method is executed in a different background thread 
	// but not consume the main thread.
	@Async
	public String uploadFile(final MultipartFile multipartFile) {
		
		LOGGER.info("File upload in progress.");
		try {
			final File file = convertMultiPartFileToFile(multipartFile);
			final String fileName = uploadFileToS3Bucket(bucketName, file);
//			System.out.printf("FILE: " + file);
			LOGGER.info("File upload is completed.");
			file.delete();	// To remove the file locally created in the project folder.

			return fileName;
		} catch (final AmazonServiceException ex) {
			LOGGER.info("File upload is failed.");
			LOGGER.error("Error= {} while uploading file.", ex.getMessage());
			return "Error";
		}
	}

	private File convertMultiPartFileToFile(final MultipartFile multipartFile) {
		final File file = new File(multipartFile.getOriginalFilename());
		try (final FileOutputStream outputStream = new FileOutputStream(file)) {
			outputStream.write(multipartFile.getBytes());
		} catch (final IOException ex) {
			LOGGER.error("Error converting the multi-part file to file= ", ex.getMessage());
		}
		return file;
	}

	private String uploadFileToS3Bucket(final String bucketName, final File file) {
//		final String uniqueFileName = LocalDateTime.now() + "_" + file.getName();
		final String uniqueFileName = file.getName();
		LOGGER.info("Uploading file with name= " + uniqueFileName);
		final PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, uniqueFileName, file);
		amazonS3.putObject(putObjectRequest);
		return uniqueFileName;
	}
	
	@Override
    // @Async annotation ensures that the method is executed in a different background thread 
    // but not consume the main thread.
    @Async
    public byte[] downloadFile(final String keyName) {
        byte[] content = null;
        LOGGER.info("Downloading an object with key= " + keyName);
        final S3Object s3Object = amazonS3.getObject(bucketName, keyName);
        final S3ObjectInputStream stream = s3Object.getObjectContent();
        try {
            content = IOUtils.toByteArray(stream);
            LOGGER.info("File downloaded successfully.");
            s3Object.close();
        } catch(final IOException ex) {
            LOGGER.info("IO Error Message= " + ex.getMessage());
        }
        return content;
    }
	
}