package tutorial.interceptor;

import javax.annotation.Resource;

import org.aopalliance.intercept.MethodInvocation;
import org.seasar.framework.aop.interceptors.AbstractInterceptor;
import org.seasar.struts.annotation.Execute;

import tutorial.dto.UserDto;

public class LoginInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	@Resource
    protected UserDto userDto;

	@Override
    public Object invoke(MethodInvocation inv) throws Throwable {
        // @Executeアノテーションをあるかチェック
        if (inv.getMethod().isAnnotationPresent(Execute.class)) {
            // ログインユーザーセッションがあるかをチェック
            if (userDto != null && userDto.name != null) {
                // あればそのままリクエストを流す
                return inv.proceed();
            }
            return "login?redirect=true";
        }

        return null;
	}

}
