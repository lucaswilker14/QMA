package daca.qma.security;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import java.lang.annotation.*;

/**
 * 
 * @author lucas_wilker
 * @annotation
 * 
 * 			To access the currently authenticated user in the controllers
 */

@Target({ ElementType.PARAMETER, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@AuthenticationPrincipal
public @interface CurrentUser {

}
