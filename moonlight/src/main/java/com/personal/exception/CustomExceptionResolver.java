package com.personal.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class CustomExceptionResolver implements HandlerExceptionResolver {
    /**
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o 控制器
     * @param e
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        CustomException ce = null;
        if (e instanceof CustomException) {
            ce = (CustomException) e;
        } else {
            ce = new CustomException("unknown error!!!");

        }
        ModelAndView mav = new ModelAndView();

        mav.addObject("ce", ce.getMessage());
        mav.setViewName("ex.jsp");
        return mav;
    }
}
