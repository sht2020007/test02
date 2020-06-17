package sht.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String nm ="KIDDALA";
	private static final String ps ="deliveryP";


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//try {
			//PassDAO dao = new PassDAO();
			String action = request.getParameter("action");
			if(action.equals("login")) {
				String name = request.getParameter("name");
				String pass = request.getParameter("pass");
				if(name == null ||pass == null){
					 request.setAttribute("error", "パスワード エラー");
					 RequestDispatcher rd = request.getRequestDispatcher( "/error.jsp");
					 rd.forward(request, response);

				}else if(name.equals(nm)&&pass.equals(ps)) {
					 //HttpSession session = request.getSession();
					 RequestDispatcher rd = request.getRequestDispatcher("/ko_01_1.html");
					 rd.forward(request, response);
				}
			}else {
				request.setAttribute("error", "パスワード エラー");
				 RequestDispatcher rd = request.getRequestDispatcher( "/error.jsp");
				 rd.forward(request, response);
			}
			//List<PassBean> list = dao.findAll(name,pass);



			/*} else {
				for(PassBean i : list) {
					String strName = i.getName();
					String strPass = i.getPass();
					session.setAttribute("name", strName);
					session.setAttribute("pass", strPass);*/

		/*}catch(DAOException e) {
			e.printStackTrace();
			request.setAttribute("error", "内部エラー");
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);*/

	}
	protected void gotoPage(HttpServletRequest request, HttpServletResponse response, String page)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
