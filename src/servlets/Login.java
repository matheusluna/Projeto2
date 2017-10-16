package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import banco.DaoUsuario;
import entidades.Usuario;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		HttpSession session = request.getSession();
		DaoUsuario dao = new DaoUsuario();
		Usuario usuario;
		try {
			usuario = dao.read(email);
			if(usuario != null) {
				if(usuario.getSenha().equals(senha)) {
					session.setAttribute("usuario", usuario);
					request.getRequestDispatcher("principal.jsp").forward(request, response);
				}else {
					request.setAttribute("mensagem", "<script>alert('Senha incorreta')</script>");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}else {
				request.setAttribute("mensagem", "<script>alert('Usuario não existente')</script>");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			request.setAttribute("mensagem", "<script>alert('Erro na comunicação com o banco de dados')</script>");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

}
