package org.zerock.w2.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.w2.dto.TodoDTO;
import org.zerock.w2.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "todoReadController", value = "/todo/read")
@Log4j2
public class TodoReadController extends HttpServlet {

    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Long tno = Long.parseLong(req.getParameter("tno"));

            TodoDTO todoDTO = todoService.get(tno);

            // 데이터 담기
            req.setAttribute("dto", todoDTO);

            // 쿠키 찾기
            Cookie viewTodoCookie = findCookie(req.getCookies(), "viewTodos");
            String todoListStr = viewTodoCookie.getValue();
            boolean exist = false;

            // t odoListStr이 null이 아니고, 해당 조회 글번호(tno)가 t odoListStr 안에 존재한다면, exist를 true 로 바꿈
            if (todoListStr!=null && todoListStr.indexOf(tno+"-") >=0) {
                exist = true;
            }

            log.info("exist : " + exist);

            if (!exist) { // exist가 false일 때 실행
                todoListStr += tno + "-";

                // 쿠키를 변경할 때에는 다시 경로나 유효시간을 세팅해야 한다 !!
                viewTodoCookie.setValue(todoListStr);
                viewTodoCookie.setMaxAge(60*60*24); // 24시간
                viewTodoCookie.setPath("/");
                resp.addCookie(viewTodoCookie);
            }

            req.getRequestDispatcher("/WEB-INF/todo/read.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            throw new ServletException("read error");
        }
    }

    // cookies 배열을 돌면서 cookieName에 해당하는 쿠키를 찾고, 만약 없으면 만들어서 반환함.
    private Cookie findCookie(Cookie[] cookies, String cookieName) {
        Cookie targetCookie = null;

        if (cookies!=null && cookies.length>0) {
            for (Cookie ck : cookies) {
                if (ck.getName().equals(cookieName)) {
                    targetCookie = ck;
                    break;
                }
            }
        }

        if (targetCookie == null) {
            targetCookie = new Cookie(cookieName, "");
            targetCookie.setPath("/");
            targetCookie.setMaxAge(60*60*24); // 24시간 유지
        }

        return targetCookie;
    }
}
