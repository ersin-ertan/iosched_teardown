package ca.ersin.shared.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

// must be java

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScoped {
}
