package ma.files.store.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import ma.files.store.model.FileDB;
import ma.files.store.repository.FileDBRepository;

@Service
public class FileStorageService {

	@Autowired
	private FileDBRepository fileDBRepository;

	public FileDB store(MultipartFile file) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes());

		return fileDBRepository.save(FileDB);
	}

	public FileDB getFile(String id) {
		return fileDBRepository.findById(id).get();
	}

	public Stream<FileDB> getAllFiles() {
		return fileDBRepository.findAll().stream();
	}

	public String deletFileById(String id) {
		if (fileDBRepository.existsById(id)) {
			fileDBRepository.deleteById(id);
			return "File has been successfully deleted";
		}
		return "File doesn't exist";
	}
}