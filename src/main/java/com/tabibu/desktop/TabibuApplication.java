import com.dlsc.formsfx.model.structure.Field;
import com.dlsc.formsfx.model.structure.Form;
import com.dlsc.formsfx.model.structure.Group;
import com.dlsc.formsfx.view.renderer.FormRenderer;
import com.dlsc.workbenchfx.Workbench;
import com.tabibu.desktop.controller.HealthCareProviderController;
import com.tabibu.desktop.repository.HealthCareProviderRepository;
import com.tabibu.desktop.repository.IProviderRepository;
import com.tabibu.desktop.repository.TabibuApiService;
import com.tabibu.desktop.view.CustomWorkBench;
import com.tabibu.desktop.view.HealthCareProviderView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class TabibuApplication extends Application {


    public void start(Stage primaryStage) throws Exception {
        IProviderRepository providerRepository = new HealthCareProviderRepository();
        HealthCareProviderController providerController = new HealthCareProviderController(providerRepository);
        HealthCareProviderView providerView = new HealthCareProviderView();
        providerView.setController(providerController);
        providerController.setView(providerView);

        providerView.loadData();


        Form loginForm = Form.of(
                Group.of(
                        Field.ofStringType("model.usernameProperty()")
                                .label("Username"),
                        Field.ofStringType("model.passwordProperty()")
                                .label("Password")
                                .required("This field can’t be empty")
                )
        ).title("Login");
        providerView.getChildren().add(new FormRenderer(loginForm));
        Scene scene = new Scene(providerView);

        Workbench customWorkbench = Workbench.builder(
                new CustomWorkBench()

        )
                .modulesPerPage(6)
                .build();

        Scene myScene = new Scene(customWorkbench);
        primaryStage.setScene(myScene);
        primaryStage.setWidth(700);
        primaryStage.setHeight(450);
        primaryStage.show();
    }

    public static void main(String args) {
        launch(args);
    }
}




