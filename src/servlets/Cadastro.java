package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import banco.DaoUsuario;
import conversores.Conversor;
import entidades.Usuario;
import percistencias.UploadFoto;

/**
 * Servlet implementation class Cadastro
 */
@WebServlet("/Cadastro")
@MultipartConfig
public class Cadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cadastro() {
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
		response.setContentType("text/html; charset=UTF-8");
		UploadFoto upload = new UploadFoto();
		Conversor conversor = new Conversor();
		DaoUsuario dao = new DaoUsuario();
		
		String nome = request.getParameter("nome");
		System.out.println(nome);
		String email = request.getParameter("email");
		LocalDate nascimento = conversor.data(request.getParameter("nascimento"));
		String sexo = request.getParameter("sexo");
		String telefone = request.getParameter("telefone");
		String senha = request.getParameter("senha");
		String foto = upload.upload(email, request.getPart("foto"), request, response);
		
		Usuario usuario = new Usuario(nome, email, senha, nascimento, telefone, sexo, foto);
		
		try {
			if(dao.create(usuario)) {
				request.setAttribute("mensagem", "<script>alert('Usuario cadastrado com sucesso!')</script>");
				request.getRequestDispatcher("login.jsp").forward(request, response);;
			}else {
				request.setAttribute("mensagem", "<script>alert('Não foi possível cadastrar o usuario!')</script>");
				request.getRequestDispatcher("cadastro.jsp").forward(request, response);;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			request.setAttribute("mensagem", "<script>alert('"+e.getMessage()+"')</script>");
			request.getRequestDispatcher("cadastro.jsp").forward(request, response);
		}
	}

}
