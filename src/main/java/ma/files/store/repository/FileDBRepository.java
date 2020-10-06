package ma.files.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.files.store.model.FileDB;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {

}