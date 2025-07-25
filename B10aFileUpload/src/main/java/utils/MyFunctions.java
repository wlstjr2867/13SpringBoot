package utils;

import java.io.File;
import java.util.UUID;

public class MyFunctions {
	
	/*
	UUID(Universally Unique IDentifier) : 직역하면 '범용고유식별자' 라고
		한다. JDK에서 기본적으로 제공되는 클래스로 32자의 영문&숫자를 포함한 고유한
		문자열을 생성해준다.
	 */
	public static String getUuid() {
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replaceAll("-", "");
		System.out.println("생성된UUID:"+ uuid);
		return uuid;
	}
	
	public static String renameFile(String sDirectory,
			String fileName) {
		String ext = fileName.substring(fileName.lastIndexOf("."));
		String now = getUuid();
		String newFileName = now + ext;
		
		File oldFile =
				new File(sDirectory + File.separator + fileName);
		File newFile =
				new File(sDirectory + File.separator + newFileName);
		 oldFile.renameTo(newFile);
		 return newFileName;
	}
}
