package app;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StartApplication
 */
@WebServlet("/start")
public class StartApplication extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// データベースをリセットする
		DatabaseManager databaseManager = new DatabaseManager();
		databaseManager.delete();

		// リクエストに応じた処理
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/start.jsp");
		requestDispatcher.forward(request, response);
		return;
	}

}
