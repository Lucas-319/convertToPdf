package com.lucas.convertToPdf.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class DocumentService {

	private static final Logger logger = LoggerFactory.getLogger(DocumentService.class);

	public Map<String, Object> upload(MultipartFile file) throws IOException, DocumentException {
		Map<String, Object> response = new HashMap<>();

		byte[] pdfData = convertDocxToPdf(file);

		if (pdfData != null && pdfData.length > 0) {
			String base64String = Base64.getEncoder().encodeToString(pdfData);
			response.put("status", 201);
			response.put("base64", base64String);
		} else {
			response.put("status", 500);
			response.put("message", "Arquivo invalido.");
			logger.error("Não foi possível converter o arquivo enviado.");
		}
		return response;
	}

	public byte[] convertDocxToPdf(MultipartFile docxFile) {

		try (XWPFDocument document = new XWPFDocument(docxFile.getInputStream())) {

			try (ByteArrayOutputStream pdfOutputStream = new ByteArrayOutputStream()) {
				Document pdfDocument = new Document();
				PdfWriter.getInstance(pdfDocument, pdfOutputStream);
				pdfDocument.open();

				List<XWPFParagraph> paragraphs = document.getParagraphs();
				for (XWPFParagraph paragraph : paragraphs) {
					pdfDocument.add(new Paragraph(paragraph.getText()));
				}
				pdfDocument.close();

				return pdfOutputStream.toByteArray();
			}
		} catch (Exception e) {
			logger.error("Não foi possível converter o arquivo enviado.");
			return null;
		}
	}
}
