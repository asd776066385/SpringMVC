package com.base.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class AspectJAdvice {
    @Pointcut("execution(public * com.base.service.impl.*ServiceImpl.*(..))")
    public void pointCut(){}

    /**
     * 前置通知
     * @param joinPoint
     */
    @Before("pointCut()") //该标签声明次方法是一个前置通知：在目标方法开始之前执行
    public void beforMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("*******************前置通知 "+methodName+" begin. param<"+ args+">***************");
    }
    /**
     * 后置通知（无论方法是否发生异常都会执行,所以访问不到方法的返回值）
     * @param joinPoint
     */
    @After("pointCut()")
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("******************后置通知 "+methodName+" end.**********************");
    }
    /**
     * 返回通知（在方法正常结束执行的代码）
     * 返回通知可以访问到方法的返回值！
     * @param joinPoint
     */
    @AfterReturning(value="pointCut()",returning="result")
    public void afterReturnMethod(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("*********************返回通知"+methodName+" end.result<"+result+">****************");
    }
    /**
     * 异常通知（方法发生异常执行的代码）
     * 可以访问到异常对象；且可以指定在出现特定异常时执行的代码
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(value="pointCut()",throwing="ex")
    public void afterThrowingMethod(JoinPoint joinPoint,Exception ex){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("******************异常通知 "+methodName+" end.ex message<"+ex+">*********************");
    }
    /**
     * 环绕通知(需要携带类型为ProceedingJoinPoint类型的参数)
     * 环绕通知包含前置、后置、返回、异常通知；ProceedingJoinPoin 类型的参数可以决定是否执行目标方法
     * 且环绕通知必须有返回值，返回值即目标方法的返回值
     * @param point
     */
    @Around(value="pointCut()")
    public Object aroundMethod(ProceedingJoinPoint point){

        Object result = null;
        String methodName = point.getSignature().getName();
        try {
            //前置通知
            System.out.println("*****************环绕通知的前置通知 "+ methodName+" start. param<"+ Arrays.asList(point.getArgs())+">*****************");
            //执行目标方法
            result = point.proceed();
            //返回通知
            System.out.println("********************环绕通知的返回通知"+ methodName+" end. result<"+ result+">************");
        } catch (Throwable e) {
            //异常通知
            System.out.println("**************this method "+methodName+" end.ex message<"+e+">");
            throw new RuntimeException(e);
        }
        //后置通知
        System.out.println("***********************环绕通知的后置通知"+ methodName+" end.*************");
        return result;
    }

}
