package interoperabilite.webservice.manager;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;

public class HtmlPageSaver {
	private final String LOCAL_REPO = "saves\\html\\";
	private final String FILE_NAME = "myPage.html";

	public void SaveHtmlToFile(String toSave){
		this.SaveHtmlToFile(toSave, this.FILE_NAME, this.LOCAL_REPO);
	}

	public void SaveHtmlToFile(String toSave,String filename){
		this.SaveHtmlToFile(toSave, filename, this.LOCAL_REPO);
	}

	public void SaveHtmlToFile(String toSave,String filename, String path){
		try {
			FileUtils.writeStringToFile(new File(path+filename), toSave,StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void LaunchHtmlFile(){
		this.LaunchHtmlFile(this.FILE_NAME, this.LOCAL_REPO);
	}

	public void LaunchHtmlFile(String filename){
		this.LaunchHtmlFile(filename, this.LOCAL_REPO);
	}

	public void LaunchHtmlFile(String filename, String path){
		if (Desktop.isDesktopSupported()) {


		try {
			Desktop.getDesktop().browse(new File(path+filename).toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
		}else{
			System.err.println("Desktop not supported!");
		}
	}
}
