package s28216.g33c.masfinal;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import s28216.g33c.masfinal.service.*;

import static javafx.application.Application.launch;

@SpringBootApplication
public class MasFinalApplication extends Application {

    public static ConfigurableApplicationContext springContext;
    private FXMLLoader fxmlLoader;

    public static void main(String[] args) {

        //SpringApplication.run(MasFinalApplication.class, args);
        Application.launch(args);


    }

    @Override
    public void start(Stage stage) throws Exception {
        //fxmlLoader.setLocation(MasFinalApplication.class.getResource("/view/KontraktList.fxml"));

        FXMLLoader loader = springContext.getBean(FXMLLoader.class);
        loader.setLocation(getClass().getResource("/view/KontraktList.fxml"));

        Parent root = loader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        func();

    }

    @Override
    public void init() throws Exception {
        springContext = SpringApplication.run(MasFinalApplication.class);
        //fxmlLoader = new FXMLLoader();
        //fxmlLoader.setControllerFactory(springContext::getBean);
    }

    @Override
    public void stop() throws Exception {
        springContext.close();
        Platform.exit();
    }

    @Configuration
    public static class FxmlConfig {
        @Bean
        @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
        public FXMLLoader fxmlLoader(ApplicationContext ctx) {
            FXMLLoader loader = new FXMLLoader();
            loader.setControllerFactory(ctx::getBean);
            return loader;
        }
    }

    public static void func(){
        KontraktService kontraktService = springContext.getBean(KontraktService.class);
        System.out.println("kontraktId: " + kontraktService.wyswietlKontrakt(1));

        AdministratorService administratorService = springContext.getBean(AdministratorService.class);
        System.out.println(administratorService.wyswietlPracownikow());

        InzynierService inzynierService = springContext.getBean(InzynierService.class);
        System.out.println(inzynierService.wyswietlPracownikow());

        MechanikService mechanikService = springContext.getBean(MechanikService.class);
        System.out.println(mechanikService.wyswietlPracownikow());

        PracownikService pracownikService = springContext.getBean(PracownikService.class);
        System.out.println(pracownikService.WyswietlPracownikow());

        DyrektorService dyrektorService = springContext.getBean(DyrektorService.class);
        System.out.println(dyrektorService.wyswietlPracownikow());

        dyrektorService.przypiszPracownikaDoFabryki(6, 1);
    }
}
