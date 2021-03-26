package tn.kindergarten.sevices;

import org.springframework.web.multipart.MultipartFile;

public interface IUploadFileService {
	public boolean addFile(MultipartFile file);

}
