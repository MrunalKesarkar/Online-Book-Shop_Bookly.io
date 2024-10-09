package com.bookly.services;

import static org.apache.commons.io.FileUtils.readFileToByteArray;
import static org.apache.commons.io.FileUtils.writeByteArrayToFile;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bookly.custom_exceptions.ApiException;
import com.bookly.custom_exceptions.ResourceNotFoundException;
import com.bookly.dao.BookDao;
import com.bookly.dao.UserDao;
import com.bookly.dto.ApiResponse;
import com.bookly.entities.Book;
import com.bookly.entities.User;

@Service
@Transactional
public class ImageHandlingServiceImpl implements ImageHandlingService {
	
	@Value("${file.upload.location}") 
	private String uploadFolder;

	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private UserDao userDao;

	@PostConstruct
	public void init() throws IOException {
		
		File folder = new File(uploadFolder);
		if (folder.exists()) {
			System.out.println("folder exists already !");
		} else {
			
			folder.mkdir();
			System.out.println("created a folder !");
		}
	}

	@Override
	public ApiResponse uploadBookImage(Long bookId, MultipartFile image) throws IOException {
		
		Book book = bookDao.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Invalid Book ID!!!!"));
		
		String path = uploadFolder.concat(image.getOriginalFilename());
		System.out.println(path);
		
		writeByteArrayToFile(new File(path), image.getBytes());
		
		book.setImgPath(path);

		return new ApiResponse("Image file uploaded successfully for Book id " + bookId);
	}

	@Override
	public void uploadImage(Book book, MultipartFile image) throws IOException {
		if (image.isEmpty()) {
	        throw new IllegalArgumentException("Uploaded file is empty");
	    }
		String path = uploadFolder.concat(image.getOriginalFilename());
		System.out.println(path);
		writeByteArrayToFile(new File(path), image.getBytes());
		book.setImgPath(path);
		System.out.println("Image file uploaded successfully for Book " + book.getTitle());
	}

	@Override
	public byte[] serveImage(Long bookId) throws IOException {
		Book book = bookDao.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Invalid emp ID!!!!"));
		// emp found --> PERSISTENT
		String path = book.getImgPath();
		if (path != null) {
			// path ---> File --> byte[]
			return readFileToByteArray(new File(path));
			// OR from DB : return emp.getImage();
		} else
			throw new ApiException("Image not yet assigned !!!!");

	}

	@Override
	public ApiResponse uploadUserImage(Long userId, MultipartFile image) throws IOException {	
		User user = userDao.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Invalid Book ID!!!!"));
		
		String path = uploadFolder.concat(image.getOriginalFilename());
		System.out.println(path);
		
		writeByteArrayToFile(new File(path), image.getBytes());
		
		user.setImgPath(path);

		return new ApiResponse("Image file uploaded successfully for User id " + userId);

	}

	@Override
	public void uploadImage(User user, MultipartFile image) throws IOException {
		String path = uploadFolder.concat(image.getOriginalFilename());
		System.out.println(path);
		writeByteArrayToFile(new File(path), image.getBytes());
		user.setImgPath(path);
		System.out.println("Image file uploaded successfully for User " + user.getFirstName());
	
	}

	
}
