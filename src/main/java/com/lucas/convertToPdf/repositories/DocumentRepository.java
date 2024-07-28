package com.lucas.convertToPdf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucas.convertToPdf.entities.MyDocument;

@Repository
public interface DocumentRepository extends JpaRepository<MyDocument, Long> {}