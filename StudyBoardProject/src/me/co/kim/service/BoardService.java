package me.co.kim.service;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import me.co.kim.dao.BoardDao;
import me.co.kim.domain.Content;
import me.co.kim.domain.User;

// board에 관련된 service 객체입니다.
@Service
public class BoardService {

	//properties로 저장한 절대 경로는 사용합니다.
	@Value("${path.upload}")
	private String path_upload;
	
	
	//session 영역에 있는 loginUser 객체를 주입 받습니다.
	@Resource(name = "loginUser")
	@Lazy
	private User loginUser;
	
	// dao 객체를 자동 주입 받습니다.
	@Autowired
	private BoardDao boardDao;
	
	// 파일을 등록하는 메서드입니다.
	//multipartfile을 받아 지정된 경로로 저장을 합니다.
	private String saveUploadFile(MultipartFile upload_file) {
		
		String file_name = System.currentTimeMillis() + "_" + upload_file.getOriginalFilename();
		
		try {
			upload_file.transferTo(new File(path_upload + "/" + file_name));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return file_name;
	}
	
	//content 객체를 파라미터로 주입 받아 데이터 베이스에 저장하는 메서드입니다.
	public void addContentInfo(Content writeContent) {

		// 주입 받은 content 객체의 upload_file을 가져와 변수에 담습니다.
		MultipartFile upload_file = writeContent.getUpload_file();
		
		// 만약 가져온 upload 변수가 존재한다면 계쏙 실행 되는 로직입니다.
		if(upload_file.getSize() > 0) {
			String file_name = saveUploadFile(upload_file);
			writeContent.setContent_file(file_name);			
		}
		
		writeContent.setContent_writer_idx(loginUser.getUser_idx());
		boardDao.addContentInfo(writeContent);
	}
	
	// board_info_idx와 일치하는 데이터베이스의 객체를 리턴하는 메서드입니다.
	public String getBoardInfoName(int board_info_idx) {
		return boardDao.getBoardInfoName(board_info_idx);
	}
	
	
	// dao에 파라미터 값을 전달해서 데이터베이스에 담긴 content를 list에 담아서 controller에 전달하는 메서드입니다.
	public List<Content> getContentList(int board_info_idx) {
		return boardDao.getContentList(board_info_idx);
	}
	
	
	// 파라미터로 받은 content_idx를 boarDao에게 전달해 주는 메서드입니다.
	public Content getContentInfo(int content_idx) {
		return boardDao.getContentInfo(content_idx);
	}
}
