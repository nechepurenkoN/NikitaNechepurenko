package ru.training.at.hw7.tests;

import static ru.training.at.hw7.page.objects.JdiTestingSite.loginForm;

import java.lang.reflect.Method;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.training.at.hw7.annotations.LoginAs;
import ru.training.at.hw7.providers.UsersProvider;

public interface PossibleLogin {

    @BeforeMethod(alwaysRun = true)
    static void loginBefore(Method method) {
        if (method.isAnnotationPresent(LoginAs.class)) {
            loginForm.login(
                UsersProvider.getUserByUsername(method.getAnnotation(LoginAs.class).username())
            );
        }
    }

    @AfterMethod(alwaysRun = true)
    static void loginAfter(Method method) {
        if (method.isAnnotationPresent(LoginAs.class)) {
            loginForm.logout();
        }
    }
}
