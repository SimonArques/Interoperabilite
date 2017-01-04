package interoperabilite.webservice.manager;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.net.ssl.HttpsURLConnection;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpClientManager {

	private String server;
	private String path;
	private String port;

	public String getPort() {
		if (!port.equals("")) {
			return ":" + port;
		} else {
			return port;
		}
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public HttpClientManager() {
	}

	public HttpClientManager(String server, String port, String path) {
		this.server = server;
		this.port = port;
		this.path = path;
	}

	public HttpClientManager(String server, String port) {
		this.server = server;
		this.port = port;
		this.path = "";
	}

	public HttpClientManager(String server) {
		this.server = server;
		this.port = "80";
		this.path = "";
	}

	public String GetHttpStringItem() {
		try {
			return Request
					.Get("http://" + this.server + this.getPort() + "/" + path)
					.connectTimeout(1000).socketTimeout(1000).execute()
					.returnContent().asString();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public void PostItem(String item) {
		try {
			Request.Post(
					"http://" + this.server + this.getPort() + "/" + this.getPath() + "/\""
							+ item+"\"").connectTimeout(1000).socketTimeout(1000)
					.execute();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String sendPost(String item) throws Exception {

		//Deprecated
		//HttpClient httpClient = new DefaultHttpClient();

		HttpClient httpClient = HttpClientBuilder.create().build(); //Use this instead

		try {

		    HttpPost request = new HttpPost("http://" + this.server + this.getPort() + "/" + this.getPath());
		    StringEntity params =new StringEntity(item);
		    request.addHeader("content-type", "application/x-www-form-urlencoded");
		    request.setEntity(params);
		    HttpResponse response = httpClient.execute(request);
		    return response.toString();
		    //handle response here...

		}catch (Exception ex) {

		    //handle exception here

		} finally {
		    //Deprecated
		    //httpClient.getConnectionManager().shutdown();
		}
		return null;

	}

	public void GetHttpPdfItem(String fileName) {
		try {
			URL url = new URL(this.server);
			InputStream in = url.openStream();
			Files.copy(in, Paths.get(".\\download\\" + fileName + ".pdf"),
					StandardCopyOption.REPLACE_EXISTING);
			in.close();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public byte[] LoadLocalPdf(String sourcePath) {
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(sourcePath);
			return readFully(inputStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public byte[] readFully(InputStream stream) throws IOException {
		byte[] buffer = new byte[8192];
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		int bytesRead;
		while ((bytesRead = stream.read(buffer)) != -1) {
			baos.write(buffer, 0, bytesRead);
		}
		return baos.toByteArray();
	}

	public void saveByteArrayPdf(byte[] pdf, String fileName) {
		try {
			FileOutputStream out = new FileOutputStream(".\\download\\"
					+ fileName + ".pdf");
			out.write(pdf, 0, pdf.length);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
