package com.lucas.convertToPdf.controllers;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.text.DocumentException;
import com.lucas.convertToPdf.entities.MyDocument;
import com.lucas.convertToPdf.services.DocumentService;

@RestController
@RequestMapping("/documents")
public class DocumentController {
	private final DocumentService documentService;

	public DocumentController(DocumentService documentService) {
		this.documentService = documentService;
	}

	@PostMapping
	public Map<String, Object> upload(@RequestParam MultipartFile file) throws IOException, DocumentException {
		return documentService.upload(file);
	}
}