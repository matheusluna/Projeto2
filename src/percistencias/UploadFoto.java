package percistencias;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class UploadFoto {
	public String upload(String email, Part path, HttpServletRequest request, HttpServletResponse response) throws IOException {
		String diretorio = File.separator+request.getServletContext().getRealPath("fotosPerfil")+File.separator+email;
		File caminhoUser = new File(diretorio);
		if(!caminhoUser.exists()) {
			caminhoUser.mkdirs();
		}
		String cam = diretorio+File.separator+path.getSubmittedFileName();
		path.write(cam);
		return "fotosPerfil"+File.separator+email+File.separator+path.getSubmittedFileName();
	}
}
