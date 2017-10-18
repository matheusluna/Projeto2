package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import banco.DaoTcc;
import entidades.Tcc;

/**
 * Servlet implementation class Pesquisa
 */
@WebServlet("/Pesquisa")
public class Pesquisa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pesquisa() {
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
		String pesquisa = request.getParameter("pesquisa");
		List<Tcc> listaAutor = dao.pesquisaAutor(pesquisa);
		List<Tcc> listaAno = dao.pesquisaAno(pesquisa);
		List<Tcc> listaConteudo = dao.pesquisaConteudo(pesquisa);
		request.setAttribute("listaAutor", listaAutor);
		request.setAttribute("listaAno", listaAno);
		request.setAttribute("listaConteudo", listaConteudo);
		request.getRequestDispatcher("pesquisa.jsp").forward(request, response);
	}

}
