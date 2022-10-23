package com.robin.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.robin.constant.Message;
import com.robin.entity.JsonData;

@RestController()
@RequestMapping(path="/upload")
public class UploadController {
	
	// 注意，此处是在win下运行的path，Linux 系统下的路径不一样
	private static final String filePath = "D:/workspace/zjy_workspace_java/work_sts_4_16/spring-boot-demo2/src/main/resources/static/images/";
	/**
	 * Upload files
	 * @return true for success, and false for failed
	 */
	@PostMapping("/files")
	public Object uploadFiles(MultipartFile file, HttpServletRequest request) {
		// file.isEmpty(); // 判断文件是否空
		// file.getSize(); // 图片大小判断，太大阻止上传，防止恶意上传文件
		
		String username = request.getParameter("username");
		System.out.println("用户名："+username);
		
		// 获取文件名
		String filename = file.getOriginalFilename();
		System.out.println("文件名："+filename);
		
		// 获取文件的后缀名
		String suffixName = filename.substring(filename.lastIndexOf("."));
		System.out.println("上传的后缀名："+suffixName);
		
		// 上传后的路径
		filename = UUID.randomUUID() + suffixName;
		System.out.println("上传后的路径:" + filePath +filename);
		File dest = new File(filePath + filename);
		
		
		try {
			file.transferTo(dest);
		}catch (Exception e) {
			e.printStackTrace();
			return new JsonData(Message.ERROR, e);
		}
		Map<String, Object> map = new HashMap<>();
		map.put("username", username);
		map.put("filename", "http://localhost:8082/images/"+filename);
		return new JsonData(Message.SUCCESS, map);
	}
	
}
