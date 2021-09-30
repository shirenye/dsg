package com.dsg.common.security.annotation;

import com.dsg.common.security.configure.DsgResourceServerConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author MrBird
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(DsgResourceServerConfigure.class)
public @interface EnableDsgResourceServer {
}
