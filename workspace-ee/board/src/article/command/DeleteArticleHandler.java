package article.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.ArticleContentNotFoundException;
import article.service.ArticleNotFoundException;
import article.service.DeleteArticleService;
import mvc.command.CommandHandler;

public class DeleteArticleHandler implements CommandHandler {
	private DeleteArticleService deleteService = new DeleteArticleService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String noVal = req.getParameter("no");
		int articleNum = Integer.parseInt(noVal);
		try {
			 String deleteDone = deleteService.delete(articleNum);
			 req.setAttribute("deleteDone", deleteDone);
			 req.setAttribute("articleNum", articleNum);
			 return "/WEB-INF/view/deleteArticle.jsp";
		} catch (ArticleNotFoundException | ArticleContentNotFoundException e) {
			req.getServletContext().log("no article", e);
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	
	}
}
