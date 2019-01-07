package com.vmoving.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;

import com.vmoving.domain.Files;

public interface FilesRepository extends JpaRepository<Files, Integer> {

}
