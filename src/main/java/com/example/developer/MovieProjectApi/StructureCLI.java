package com.example.developer.MovieProjectApi;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.developer.MovieProjectApi.loginUserMenu.FirstPage;


@Component
public class StructureCLI {

    FirstPage firstPage;

    public StructureCLI(FirstPage firstPage) {
        this.firstPage = firstPage;
    }

    public void run() {
        firstPage.loginPage();
    }
}