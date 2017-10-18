package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import banco.DaoTcc;
import banco.DaoTccNeo4j;
import entidades.Tcc;

/**
 * Servlet implementation class Tcc
 */
@WebServlet("/PaginaTcc")
public class PaginaTcc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaginaTcc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String titulo = request.getParameter("titulo");
		DaoTcc dao = new DaoTcc();
		DaoTccNeo4j neo = new DaoTccNeo4j();
		Tcc tcc = dao.read(titulo);
		List<Tcc> listaOrientador = neo.listarOrientador(tcc.getOrientador());
		List<Tcc> listaArea = neo.listarArea(tcc.getArea());
 		request.setAttribute("tcc", tcc);
 		request.setAttribute("listaOrientador", listaOrientador);
 		request.setAttribute("listaArea", listaArea);
		request.getRequestDispatcher("tcc.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
