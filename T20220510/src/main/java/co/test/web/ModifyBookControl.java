package co.test.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.test.service.BookService;
import co.test.vo.BookVO;

public class ModifyBookControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String code = request.getParameter("code");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String press = request.getParameter("press");
        String price = request.getParameter("price");
        
        BookVO vo = new BookVO();
        vo.setBookCode(code);
        vo.setBookTitle(title);
        vo.setBookAuthor(author);
        vo.setBookPress(press);
        vo.setBookPrice(Integer.parseInt(price));
       
        BookService service = new BookService();
        service.modifyBook(vo);
        
        request.setAttribute("code", code);
        request.setAttribute("title", title);
        request.setAttribute("author", author);
        request.setAttribute("press", press);
        request.setAttribute("price", price);
		
		request.getRequestDispatcher("result/modifyOutput.jsp").forward(request, response);
	}

}
