package com.lucas.convertToPdf.controllers;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.text.DocumentException;
import com.lucas.convertToPdf.services.ConvertDocumentService;


@RestController
@RequestMapping("/documents")
public class DocumentController {
	
	@Autowired
	private ConvertDocumentService documentService;

	@PostMapping
	public Map<String, Object> upload(@RequestParam MultipartFile file) throws IOException, DocumentException {
		return documentService.upload(file);
	}
}