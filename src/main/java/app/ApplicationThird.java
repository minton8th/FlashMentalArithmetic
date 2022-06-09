package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Application
 */
@WebServlet("/applicationThird")
public class ApplicationThird extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// valuesテーブルの中身が何個あるか調べる
		DatabaseManager databaseManager = new DatabaseManager();
		List<Integer> valueList = databaseManager.select();
		int count = valueList.size();

		// 10個未満ならフラッシュ暗算を続ける
		if (count < 10) {
			// 自動更新する時間の間隔を決める
			response.setIntHeader("Refresh", 1);

			// レスポンスのタイプを決める
			response.setContentType("text/html; charset=Shift_JIS");

			// 現在の時刻を取得
			Calendar calendar = new GregorianCalendar();
			String am_pm;
			int hour = calendar.get(Calendar.HOUR);
			int minute = calendar.get(Calendar.MINUTE);
			int second = calendar.get(Calendar.SECOND);

			if (calendar.get(Calendar.AM_PM) == 0)
				am_pm = "AM";
			else
				am_pm = "PM";

			String CT = am_pm + hour + "時" + minute + "分" + second + "秒";

			// ランダムに数字を生成する
			Random random = new Random();
			int value = random.nextInt(990) + 10;

			// データベースに数字を格納する
			DatabaseManager databaseManager2 = new DatabaseManager();
			databaseManager2.insert(value);

			// レスポンスのHTML記述
			PrintWriter out = response.getWriter();
			String title = "フラッシュ暗算";
			String docType = "<!DOCTYPE html>\n";

			out.println(docType + "<html>\n" + "<head><title>" + title + "</title>\n" + "<meta charset=\"UTF-8\">\n"
					+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"application.css\">" + "</head>\n" + "<body>\n"
					+ "<h1>" + title + "</h1>\n" + "<p>現在の時刻: " + CT + "</p>\n" + "<table border=\"1\">\r\n"
					+ "<tr align=\"center\">\r\n" + "<th>" + value + "</th>\r\n" + "</tr>\r\n" + "</table>");
		} else if (count == 10) {
			response.sendRedirect("http://localhost:8080/flashMentalArithmetic/application1");
			return;
		} else {
			return;
		}
	}

	// Method to handle POST method request.
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
