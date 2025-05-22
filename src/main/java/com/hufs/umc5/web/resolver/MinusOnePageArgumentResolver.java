package com.hufs.umc5.web.resolver;

import com.hufs.umc5.web.annotation.MinusOnePage;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class MinusOnePageArgumentResolver implements HandlerMethodArgumentResolver {

    // 해당 메서드가 true여야 resolveArgument 호출되어 값 만들어줌
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(Integer.class)
                && parameter.hasParameterAnnotation(MinusOnePage.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String pageParam = webRequest.getParameter("page");
        int page = Integer.parseInt(pageParam);
        return page - 1;
    }
}
