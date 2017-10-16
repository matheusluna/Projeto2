package percistencias;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class UpLoadPdf {
	private String cam;
	public String upload(String autor, Part path, HttpServletRequest request, HttpServletResponse response) throws IOException {
		String diretorio = File.separator+request.getServletContext().getRealPath("tcc")+File.separator+autor;
		File caminhoUser = new File(diretorio);
		if(!caminhoUser.exists()) {
			caminhoUser.mkdirs();
		}
		this.cam = diretorio+File.separator+path.getSubmittedFileName();
		path.write(cam);
		return "tcc"+File.separator+autor+File.separator+path.getSubmittedFileName();
	}
	public String getCam() {
		return cam;
	}
	public void setCam(String cam) {
		this.cam = cam;
	}
	
	
}
