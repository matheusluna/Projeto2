package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tika.exception.TikaException;

import com.mongodb.MongoException;

import banco.DaoTcc;
import banco.DaoTccNeo4j;
import banco.DaoTccRedis;
import conversores.Conversor;
import entidades.Tcc;
import jdk.internal.org.xml.sax.SAXException;
import leitor.LeitorPdf;
import percistencias.UpLoadPdf;
import percistencias.UploadFoto;

/**
 * Servlet implementation class CadastroTcc
 */
@WebServlet("/CadastroTcc")
@MultipartConfig
public class CadastroTcc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroTcc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		DaoTcc dao = new DaoTcc();
		DaoTccNeo4j neo = new DaoTccNeo4j();
		
		
		
		try {
			UpLoadPdf pdf = new UpLoadPdf();
			String autor = request.getParameter("autor");
			String orientador = request.getParameter("orientador");
			String[] palavrasChave = new Conversor().lista(request.getParameter("palavrasChave"));
			String titulo = request.getParameter("titulo");
			String resumo = request.getParameter("resumo");
			int ano = Integer.parseInt(request.getParameter("ano"));
			String area = request.getParameter("area");
			String caminho = pdf.upload(autor, request.getPart("pdf"), request, response);
			LeitorPdf leitor = new LeitorPdf(pdf.getCam());
			String texto = leitor.getText();
			Tcc tcc = new Tcc(autor, orientador, palavrasChave, ano, resumo, area, titulo, caminho, texto);
			if(dao.create(tcc)) {
				neo.create(tcc);
				request.setAttribute("tcc", null);
				request.setAttribute("mensagem", "<script>alert('Tcc cadastrado com sucesso!')</script>");
				request.getRequestDispatcher("principal.jsp").forward(request, response);;
			}else {
				request.setAttribute("mensagem", "<script>alert('Este tcc já foi cadastrado!')</script>");
				request.getRequestDispatcher("principal.jsp");
			}
		} catch (SAXException | TikaException | org.xml.sax.SAXException | MongoException e) {
			// TODO Auto-generated catch block
			
			DaoTccRedis redis = new DaoTccRedis();
			UpLoadPdf pdf = new UpLoadPdf();
			String autor = request.getParameter("autor");
			String orientador = request.getParameter("orientador");
			String[] palavrasChave = new Conversor().lista(request.getParameter("palavrasChave"));
			String titulo = request.getParameter("titulo");
			String resumo = request.getParameter("resumo");
			int ano = Integer.parseInt(request.getParameter("ano"));
			String area = request.getParameter("area");
			String caminho = pdf.upload(autor, request.getPart("pdf"), request, response);
			LeitorPdf leitor = new LeitorPdf(pdf.getCam());
			String texto;
			try {
				texto = leitor.getText();
				Tcc tcc = new Tcc(autor, orientador, palavrasChave, ano, resumo, area, titulo, caminho, texto);
				redis.create(tcc);
				request.setAttribute("tcc", tcc);
				request.setAttribute("mensagem", "<script>alert('Houve um erro na persistência!')</script>");
				request.getRequestDispatcher("principal.jsp").forward(request, response);
			} catch (SAXException | TikaException | org.xml.sax.SAXException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
	}

}
