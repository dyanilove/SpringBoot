package com.example.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Calendar;

// 년월일을 입력하면 요일을 알려주는 원격 프로그램
@Controller
public class YoilTeller {
    @RequestMapping("/yoil")
    public String main(@ModelAttribute MyDate myDate, Model model) throws IOException {
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("yoilError");

//        if(!isValid(year,month,day)) {
//            return mv;  // 사용자가 요청한 날짜가 유효하지 않으면 yoilError를 보여준다.
//        }
        // 1. 입력
//        String year = request.getParameter("year");
//        String month = request.getParameter("month");
//        String day = request.getParameter("day");

//        int yyyy = Integer.parseInt(year);
//        int mm = Integer.parseInt(month);
//        int dd = Integer.parseInt(day);

        // 2. 작업 - 요일 계산
        char yoil = getYoil(myDate);

        // 작업한 결과를 model에 저장(DS가 Model을 View로 전달)
//        model.addAttribute("myDate", myDate);
//        model.addAttribute("year", myDate.getYear());
//        model.addAttribute("month", myDate.getMonth());
//        model.addAttribute("day", myDate.getDay());
//        model.addAttribute("yoil", yoil);

        return "yoil";  // yoil.html - 뷰의 이름을 반환
//        return mv;

        // 3. 출력 - 작업 결과를 브라우저에 전송
//        response.setCharacterEncoding("ms949"); // 한글 윈도우 ms949
//        PrintWriter out = response.getWriter();
//        out.println("<html>");
//        out.println("<head>");
//        out.println("</head>");
//        out.println("<body>");
//        out.println("year = " + year + " month = " + month+" day = " + day);
//        out.println("yoil : " + yoil);
//        out.println("</body>");
//        out.println("</html>");
    }

    @ModelAttribute("yoil")
    private static char getYoil(MyDate myDate) {
        Calendar cal = Calendar.getInstance();  // 현재 날짜와 시간을 갖는 cal
        cal.clear();    // cal의 모든 필드 초기화
        cal.set(myDate.getYear(), myDate.getMonth()-1, myDate.getDay());  // 월(mm)은 0부터 11이기 때문에 1을 빼줘야 함.

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);  // 1~7반환, 1: 일요일, 2: 월요일
        char yoil = "일월화수목금토".charAt(dayOfWeek-1);
        return yoil;
    }

    private boolean isValid(int year, int month, int day) {
        return  true;
    }
}
