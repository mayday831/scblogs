package cn.sticki.common.exception.userException;

public class FileMaxSizeException extends FileException {

	public FileMaxSizeException() {
		super("文件过大");
	}

	public FileMaxSizeException(String errorMessage) {
		super(errorMessage);
	}

}
