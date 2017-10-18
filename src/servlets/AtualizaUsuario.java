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
import javax.servlet.http.HttpSession;

import banco.DaoUsuario;
import conversores.Conversor;
import entidades.Usuario;
import percistencias.UploadFoto;

/**
 * Servlet implementation class AtualizaUsuario
 */
@WebServlet("/AtualizaUsuario")
@MultipartConfig

public class AtualizaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtualizaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		response.setContentType("text/html; charset=UTF-8");
		UploadFoto upload = new UploadFoto();
		Conversor conversor = new Conversor();
		DaoUsuario dao = new DaoUsuario();
		
		String nome = request.getParameter("nome");
		String email = usuario.getEmail();
		System.out.println(request.getParameter("nascimento"));
		LocalDate nascimento = conversor.data(request.getParameter("nascimento"));
		String sexo = request.getParameter("sexo");
		String telefone = request.getParameter("telefone");
		String senha = request.getParameter("senha");
		String foto = upload.upload(email, request.getPart("foto"), request, response);
		
		Usuario usuario2 = new Usuario(nome, email, senha, nascimento, telefone, sexo, foto);
		try {
			if(dao.update(usuario2)) {
				request.setAttribute("mensagem", "<script>alert('Usuario atualizado com sucesso!')</script>");
				request.getRequestDispatcher("perfil.jsp").forward(request, response);
			}else {
				request.setAttribute("mensagem", "<script>alert('Não foi possível atualizar o usuario!')</script>");
				request.getRequestDispatcher("editaPerfil.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			request.setAttribute("mensagem", "<script>alert('"+e.getMessage()+"')</script>");
			request.getRequestDispatcher("principal.jsp").forward(request, response);
		}
	}

}
