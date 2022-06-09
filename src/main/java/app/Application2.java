package app;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Application2
 */
@WebServlet("/application2")
public class Application2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// データベースから問題の数字を取得して合計を計算する
		DatabaseManager databaseManager = new DatabaseManager();
		List<Integer> valueList = databaseManager.select();
		int result = 0;

		for (int i = 0; i < valueList.size(); i++) {
			result += valueList.get(i);
		}

		// リクエストパラメータの設定
		request.setAttribute("result", result);

		// リクエストに応じた処理
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/result.jsp");
		requestDispatcher.forward(request, response);
		return;
	}

}
