package com.lucas.convertToPdf.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.text.DocumentException;
import com.lucas.convertToPdf.services.ConvertDocumentService;

@RestController
@RequestMapping("/convertDocument")
public class DocumentController {
	
	@Autowired
	private ConvertDocumentService documentService;

	@PostMapping
	public ResponseEntity<Map<String, Object>>  upload(@RequestParam MultipartFile file) throws IOException, DocumentException {
		Map<String, Object> response = new HashMap<>();
		
		Integer statusCode = null;
		
		response = documentService.upload(file);
		
		statusCode = Integer.parseInt(response.get("status").toString());
		
		return ResponseEntity.status(statusCode).body(response);
	}
}