package com.example.blogService.articleService.interceptor;

import com.example.blogService.articleService.annotation.JwtToken;
import com.example.blogService.articleService.dto.ResponseObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import sun.misc.BASE64Encoder;

import javax.crypto.SecretKey;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenInterceptor implements HandlerInterceptor {

    @Value("${app.secretKey}")
    private String appKey;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        if (handlerMethod.getMethod().isAnnotationPresent(JwtToken.class)) {
            return true;
        }

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        response.setContentType("text/json;charset=utf-8");
        String token = request.getHeader("token");
        if (token == null) {
            ResponseObject<Object> responseObject = new ResponseObject<>("token is null");
            response.setStatus(401);
            String json = objectMapper.writeValueAsString(responseObject);
            response.getWriter().println(json);
            return false;
        } else {
            //秘钥
            //对秘钥做BASE64编码
            String base64 = new BASE64Encoder().encode(appKey.getBytes());
            //生成秘钥对象
            SecretKey secretKey = Keys.hmacShaKeyFor(base64.getBytes());
            JwtParser build = Jwts.parserBuilder().setSigningKey(secretKey).build();
            String subject = build.parseClaimsJws(token).getBody().getSubject();
            ResponseObject<Object> responseObject = new ResponseObject<>("0", "success", subject);
            String json = objectMapper.writeValueAsString(responseObject);
            response.getWriter().println(json);
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
