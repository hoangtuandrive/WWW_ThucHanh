package index.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class index
 */
@WebServlet("/guidulieu")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AccountDbUtil accountDbUtil;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Resource(name="jdbc/account_data")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		// create our student db util ... and pass in the conn pool / datasource
		try {
			accountDbUtil = new AccountDbUtil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String html="<br>" + "<html>"
				+ "<head>" + "<title>Result Page</title>"
				+ "</head>" + "<body>"
				+ "Full Name: "+ name +"<br>"
				+ "Email: "+ email +"<br>"
				+ "Password: "+ password +"<br>"
				+ "</body>" + "</html>";
				out.println(html);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		System.out.println("ABCs");
		try {
			addAccount(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
	}

	private void addAccount(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read student info from form data
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		// create a new student object
		Account account = new Account(name, email, password);		
		account.toString();
		// add the student to the database
		accountDbUtil.addAccountToDb(account);				
	}
}
